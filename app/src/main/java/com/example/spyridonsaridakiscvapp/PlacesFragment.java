package com.example.spyridonsaridakiscvapp;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PlacesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PlacesFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public PlacesFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PlacesFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PlacesFragment newInstance(String param1, String param2) {
        PlacesFragment fragment = new PlacesFragment();
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
        View view = inflater.inflate(R.layout.fragment_places, container, false);
        TextView tvTitle = view.findViewById(R.id.tvPlacesTitle);
        tvTitle.setText("I have not traveled to many countries so far and that is one of my big regrets. " +
                "I am currently working on it, as mentioned in other sections of this app, I have been to " +
                "Greece and Cyprus. By choosing one of them with the buttons below and pressing the show" +
                " me button, you will see the places I have been in the country you chose.");
        Button btnLoadMap = view.findViewById(R.id.btnShow);
        RadioGroup rgGroup = view.findViewById(R.id.rgGroup);

        btnLoadMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = rgGroup.getCheckedRadioButtonId(); // Move this line inside the onClick method
                Boolean canSend = false;
                String country = "";
                String code = "";
                if (id == R.id.rbGreece) {
                    country = "Greece";
                    code = "1";
                    canSend = true;
                } else if (id == R.id.rbCyprus) {
                    country = "Cyprus";
                    code = "2";
                    canSend = true;
                }
                if (canSend) {
                    Intent in = new Intent(getActivity(), MapsHostActivity.class);
                    Bundle bund = new Bundle();
                    bund.putString("country", country);
                    bund.putString("code", code);
                    in.putExtras(bund);
                    startActivity(in);
                } else {
                    Toast.makeText(getContext(), "Please select a country", Toast.LENGTH_LONG).show();
                }
            }
        });
        return view;
    }

}
