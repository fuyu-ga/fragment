package com.example.fragment.ui.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.fragment.R;
import com.example.fragment.databinding.FragmentHomeBinding;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private OkHttpClient okHttpClient = new OkHttpClient();
    private String httprequest(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();

        Response response = okHttpClient.newCall(request).execute();
        return response.body().string();
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        binding.btnTokyo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new MyAsyncTask() {
                    //以下をviewmodelに書くのが主流
                    @Override
                    protected String doInBackground(String... params) {
                        String weather = null;
                        try {
                            String result = httprequest("https://weather.tsukumijima.net/api/forecast?city=130010");

                            JSONObject resJson = new JSONObject(result);
                            JSONArray forecasts = resJson.getJSONArray("forecasts");
                            JSONObject today = forecasts.getJSONObject(0);
                            JSONObject detail = today.getJSONObject("detail");
                            weather = detail.getString("weather");
                            Log.d("to",weather);

                        } catch (IOException e) {
                            e.printStackTrace();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        return weather;
                    }
                    @Override
                    protected void onPostExecute(String weather) {
                        binding.tvTokyo.setText(weather);
                    }
                }.execute();
            }
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}