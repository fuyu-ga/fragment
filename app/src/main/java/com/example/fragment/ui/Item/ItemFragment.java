package com.example.fragment.ui.Item;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fragment.R;
import com.example.fragment.databinding.FragmentDashboardBinding;
import com.example.fragment.databinding.FragmentItemBinding;
import com.example.fragment.ui.Item.ItemViewModel;

//何かをコピペして増やす必要があるものはすでに作られているファイルとedit-find-find in file でid検索をして何を一致させるべきなのかを調べると早い
public class ItemFragment extends Fragment {

    private ItemViewModel mViewModel;

    private FragmentItemBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentItemBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        return root;
    }

}