package com.example.fragment.ui.notifications;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fragment.R;
import com.example.fragment.databinding.FragmentNotifications3Binding;

public class NotificationsFragment3 extends Fragment {
    private FragmentNotifications3Binding binding;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentNotifications3Binding.inflate(inflater, container, false);
        View root = binding.getRoot();


        //再度ボタンを追加して別のactivityを起動する　戻るボタンで戻るかも確認する
        binding.btnActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_norificationsFragment3_to_notificationActivity);
            }
        });
        return root;
    }
}