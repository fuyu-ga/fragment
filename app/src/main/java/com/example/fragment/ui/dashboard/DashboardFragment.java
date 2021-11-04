package com.example.fragment.ui.dashboard;

import android.content.Context;
import android.content.SharedPreferences;
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
import androidx.navigation.Navigation;

import com.example.fragment.R;
import com.example.fragment.databinding.FragmentDashboardBinding;

public class DashboardFragment extends Fragment {

    private FragmentDashboardBinding binding;
    private final String KAGI = "key";
    private SharedPreferences dataStore;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        dataStore = getContext().getSharedPreferences("DataStore", Context.MODE_PRIVATE);
        View root = binding.getRoot();

        binding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_navigation_dashboard_to_loginFragment);

                SharedPreferences.Editor login = dataStore.edit();
                login.putBoolean(KAGI,true);
                login.commit(); //apply確定するけど時間差がある(非同期）,commitは同期的に瞬時に書き込む　
                Log.d("techi",KAGI); //keyは取れてる
            }
        });
        return root;
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("techi","onResume"); //呼ばれてる
        boolean loginafter = dataStore.getBoolean(KAGI,false);
        if(loginafter) {
            binding.tvResult.setText("ログインしました");
        } else {
            binding.tvResult.setText("ログインされていません");
        }

    }

}