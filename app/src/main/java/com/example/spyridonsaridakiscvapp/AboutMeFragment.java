package com.example.spyridonsaridakiscvapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.spyridonsaridakiscvapp.databinding.FragmentHomeBinding;

import org.w3c.dom.Text;

public class AboutMeFragment extends Fragment {

    private FragmentHomeBinding binding;

    public int counter =0;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        TextView tv = root.findViewById(R.id.tvAboutMe);
        Button btn = root.findViewById(R.id.btnNext);
        String[] text={"My name is Spyridon Saridakis and i was born in Athens, Greece. I live in the city of Nikaia " +
                "which is near the port of Piraeus. From a young age i started fiddling around with computers and i built my" +
                " first computer when i was about 13 years old.","After that, i enrolled at the university of West Attica and " +
                "i have been studying there since 2019 at the Department of Informatics and Computer Engineering"};
        tv.setText(text[0]);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(counter==0){
                    tv.setText(String.format(text[1],"%s"));
                    counter++;
                }else{
                    tv.setText(text[0]);
                    counter = 0;
                }
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