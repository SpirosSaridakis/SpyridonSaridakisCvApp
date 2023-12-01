package com.example.spyridonsaridakiscvapp;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.spyridonsaridakiscvapp.databinding.FragmentGalleryBinding;

public class AcademicFragment extends Fragment {

    private FragmentGalleryBinding binding;
    public Boolean isUniwaFull =false;
    public static final int HEIGHT =320;
    public Boolean isCutFull=false;
    public Boolean isTalosFull=false;

    public Boolean isConfFull=false;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentGalleryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        View uniwa = root.findViewById(R.id.containerUniwa);
        View cut = root.findViewById(R.id.containerCut);
        View talos = root.findViewById(R.id.containerTalos);
        View conf = root.findViewById(R.id.containerConferences);

        uniwa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Modify layout parameters on click
                if(!isUniwaFull){
                    expandSelected(uniwa);
                    minimize(talos);
                    minimize(cut);
                    minimize(conf);
                    isUniwaFull = true;
                }else{
                    returnToOriginal(uniwa);
                    returnToOriginal(talos);
                    returnToOriginal(cut);
                    returnToOriginal(conf);
                    isUniwaFull =false;
                }
            }
        });

        cut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Modify layout parameters on click

                if(!isCutFull){
                    expandSelected(cut);
                    minimize(talos);
                    minimize(uniwa);
                    minimize(conf);
                    isCutFull=true;
                }else{
                    returnToOriginal(cut);
                    returnToOriginal(talos);
                    returnToOriginal(uniwa);
                    returnToOriginal(conf);
                    isCutFull=false;
                }
            }
        });

        talos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!isTalosFull){
                    expandSelected(talos);
                    minimize(cut);
                    minimize(uniwa);
                    minimize(conf);
                    isTalosFull=true;
                }else{
                    returnToOriginal(talos);
                    returnToOriginal(cut);
                    returnToOriginal(uniwa);
                    returnToOriginal(conf);
                    isTalosFull=false;
                }
            }

        });

        conf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!isConfFull){
                    expandSelected(conf);
                    minimize(cut);
                    minimize(uniwa);
                    minimize(talos);
                    isConfFull=true;
                }else{
                    returnToOriginal(talos);
                    returnToOriginal(cut);
                    returnToOriginal(uniwa);
                    returnToOriginal(conf);
                    isConfFull=false;
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
        param.setMargins(25,25,25,25);
        v.setLayoutParams(param);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}