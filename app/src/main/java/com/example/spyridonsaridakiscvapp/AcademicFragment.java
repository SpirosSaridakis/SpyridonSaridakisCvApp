package com.example.spyridonsaridakiscvapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.spyridonsaridakiscvapp.databinding.FragmentGalleryBinding;

public class AcademicFragment extends Fragment {

    private FragmentGalleryBinding binding;
    public Boolean isTopFull=false;
    public static final int HEIGHT =350;
    public Boolean isBottomFull=false;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentGalleryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        View top = root.findViewById(R.id.containerUniwa);
        View bottom = root.findViewById(R.id.containerCut);
        top.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Modify layout parameters on click
                if(!isTopFull){
                    expandSelected(top);
                    minimize(bottom);
                    isTopFull=true;
                }else{
                    returnToOriginal(top);
                    returnToOriginal(bottom);
                    isTopFull=false;
                }
            }
        });

        bottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Modify layout parameters on click

                if(!isBottomFull){
                    expandSelected(bottom);
                    minimize(top);
                    isBottomFull=true;
                }else{
                    returnToOriginal(bottom);
                    returnToOriginal(top);
                    isBottomFull=false;
                }
            }
        });

        return root;
    }

    public void expandSelected(View v){
        LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT
        );
        v.setLayoutParams(param);
    }

    public void minimize(View v){
        LinearLayout.LayoutParams param1 = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                0
        );
        v.setLayoutParams(param1);
    }

    public void returnToOriginal(View v){
        LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                HEIGHT
        );
        param.setMargins(15,15,15,15);
        v.setLayoutParams(param);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}