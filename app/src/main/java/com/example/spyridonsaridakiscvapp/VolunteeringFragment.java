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


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentSlideshowBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        TextView tvTitle = root.findViewById(R.id.tvVolTitle);
        tvTitle.setText("Volunteering is a big part of my life and I take great joy in helping the people around me, some of" +
                " the most important places that i have volunteered in are the following:");
        TextView tvContent = root.findViewById(R.id.tvContent);
        tvContent.setText("•I was a volunteer at that 26th Panhellenic conference on informatics that has hosted by my university." +
                "There i assisted the organizers in setting up the equipment for the live broadcast of the conference as well as " +
                "showing around guests in the university campus. I also was a moderator for the online streaming of the event.\n\n"+
                "•I volunteered at the TEDx University of Piraeus event where again I was responsible for setting up the equipment of a" +
                " booth that broadcasted the event in the Metaverse platform of Meta. I also helped guests of the event navigate the virtual " +
                "space.\n\n" +
                "•After being a camp member of the Camp of the Holy Metropolis of Nikaia for 7 years, I was chosen to volunteer as a team leader in it." +
                " I was responsible for looking after a team of middle school children for 15 days. I also participated in the cleaning and preparation" +
                "of the campsite before and after the start of the camping season.");
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}