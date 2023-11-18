package com.example.spyridonsaridakiscvapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class CountryInformationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_information);
        TextView tvT = findViewById(R.id.tvCountryTitle);
        Intent in = getIntent();
        String code = in.getStringExtra(MapsHostActivity.CODEFORINFO);
        if(code.equals("1")){
            tvT.setText("Greece");
        }else if(code.equals("2")){
            tvT.setText("Cyprus");
        }
    }

    public void backToMap(View v){
        finish();
    }
}