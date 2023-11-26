package com.example.spyridonsaridakiscvapp;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.spyridonsaridakiscvapp.databinding.FragmentSlideshowBinding;

public class VolunteeringFragment extends Fragment {

    private FragmentSlideshowBinding binding;

    public LifeCycleHandler handler = new LifeCycleHandler();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentSlideshowBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
            fragmentManager.registerFragmentLifecycleCallbacks(handler,false);
        }
        final TextView textView = binding.textSlideshow;
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}