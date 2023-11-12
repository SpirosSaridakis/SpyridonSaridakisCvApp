package com.example.spyridonsaridakiscvapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link UniwaAcademicFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class UniwaAcademicFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public UniwaAcademicFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment UniwaAcademicFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static UniwaAcademicFragment newInstance(String param1, String param2) {
        UniwaAcademicFragment fragment = new UniwaAcademicFragment();
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
        View view = inflater.inflate(R.layout.fragment_uniwa_academic, container, false);
        TextView tvLogo = view.findViewById(R.id.tvLogo);
        TextView tv = view.findViewById(R.id.tvText);
        tvLogo.setText("University of West Attica,\nDepartment of Informatics\nand Computer Engineering");
        tv.setText("• The department of informatics and computer engineering is based in the town of Aigaleo, Greece." +
                "\n\n• It offers an integrated masters degree and its curriculum duration is 5 years." +
                "\n\n• Classes consist of labs and theory parts");

        return view;
    }
}