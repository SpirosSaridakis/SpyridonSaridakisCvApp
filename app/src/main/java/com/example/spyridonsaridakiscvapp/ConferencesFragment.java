package com.example.spyridonsaridakiscvapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ConferencesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ConferencesFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ConferencesFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ConferencesFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ConferencesFragment newInstance(String param1, String param2) {
        ConferencesFragment fragment = new ConferencesFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_conferences, container, false);
        TextView tvLogo2 = view.findViewById(R.id.tvConf);
        TextView tvText2 = view.findViewById(R.id.tvTextConf);
        tvLogo2.setText("Conferences");
        tvText2.setText("I have taken part in some conferences about informatics and computer science, these are:"+
                "\n\n• The 24th Panhellenic conference on informatics hosted by the University of Thessaly online." +
                "\n\n• The 26th Panhellenic conference on informatics hosted by the University of West Attica where" +
                "i helped as a volunteer as well."+
                "\n\n•The Besides Cyprus information security conference, which i attended in my time as an Erasmus student in Cyprus."+
                "\n\n•A first aid and lifeguarding basics seminar which was hosted at the University of West Attica and was presented" +
                "by members of the Panhellenic school of lifeguarding.");
        return view;
    }
}