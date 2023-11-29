package com.example.spyridonsaridakiscvapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class CountryInformationActivity extends AppCompatActivity {
    public LifeCycleHandler handler = new LifeCycleHandler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_information);
        handler.getContext(getApplicationContext());
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            registerActivityLifecycleCallbacks(handler);
        }
        TextView tvT = findViewById(R.id.tvCountryTitle);
        TextView tvContent = findViewById(R.id.tvCountiresText);
        Intent in = getIntent();
        String code = in.getStringExtra(MapsHostActivity.CODEFORINFO);
        if(code.equals("1")){
            tvT.setText("Greece");
            tvContent.setText("I have been in many places in Greece and it would\nnot be aesthetically pleasing to add markers\nFor" +
                    " all of them, here is a list with the places i have visited\n"+"•Paros island\n"+"•Mykonos island\n"+"•Aegina island\n" +
                    "•Kefallonia island\n"+"•Corfu island\n"+"•Syros island\n"+"•Tinos island\n"+"•Andros island\n"+"•Mount Athos\n"
                    +"•Larisa\n"+"•Volos\n"+"•Naflplio\n"+"•Chania\n"+"•Rethimno\n");
        }else if(code.equals("2")){
            tvT.setText("Cyprus");
            tvContent.setText("In my tenure as an Erasmus Student i visited all \nthe places shown on the Map");
        }
    }

    public void backToMap(View v){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            unregisterActivityLifecycleCallbacks(handler);
        }
        finish();
    }
}