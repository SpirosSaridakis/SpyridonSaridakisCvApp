package com.example.spyridonsaridakiscvapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.spyridonsaridakiscvapp.databinding.FragmentHomeBinding;

import org.w3c.dom.Text;

public class AboutMeFragment extends Fragment {

    private FragmentHomeBinding binding;

    public int counter =1;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        TextView tv = root.findViewById(R.id.tvAboutMe);
        TextView tvTitle = root.findViewById(R.id.tvTitle);

        Button btn = root.findViewById(R.id.btnNext);

        String[] title={"General","Research Groups","Erasmus"};
        String[] text={"My name is Spyridon Saridakis and i was born in Athens, Greece. I live in the city of Nikaia " +
                "which is near the port of Piraeus. From a young age i started fiddling around with computers and i built my" +
                " first computer when i was about 13 years old. After that, i enrolled at the university of West Attica and " +
                "i have been studying there since 2019 at the Department of Informatics and Computer Engineering","As a student i have" +
                " been involved in two university research teams. TALOS UVS which is a research group whose area of study is un-manned" +
                " aerial vehicles (also known as drones),in which i participated in a project whose goal was building a black box for drones. " +
                "I also joined the IEEE student branch which focuses more on software development and" +
                " computer networks.","I also participated in the ERASMUS+ programme. I joined the Cyprus University of Technology that is" +
                " based in Limassol, Cyprus. This allowed me to get a different view on my field of studies by meeting new students, professors" +
                " and getting a different view about how computer engineering is taught abroad."};
        tv.setText(text[0]);
        tvTitle.setText(title[0]);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (counter){
                    case 0 :
                        tv.setText(text[0]);
                        tvTitle.setText(title[0]);
                        counter++;
                        break;
                    case 1 :
                        tv.setText(text[1]);
                        tvTitle.setText(title[1]);
                        counter++;
                        break;
                    case 2:
                        tv.setText(text[2]);
                        tvTitle.setText(title[2]);
                        counter=0;
                        break;
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