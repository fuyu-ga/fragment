package com.example.fragment.ui.notifications;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.fragment.R;
import com.example.fragment.databinding.FragmentNotifications2Binding;


public class NotificationsFragment2 extends Fragment {
    //fragmentの場合、findviewidの代わりにbindingを使う
    private FragmentNotifications2Binding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentNotifications2Binding.inflate(inflater, container, false);
        View root = binding.getRoot();

        binding.btnThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_notificationsFragment2_to_norificationsFragment3);
            }
        });
        return root;
    }
}
