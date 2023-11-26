package com.example.spyridonsaridakiscvapp;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import androidx.navigation.ui.AppBarConfiguration;


import com.example.spyridonsaridakiscvapp.databinding.ActivityMapsHost2Binding;

public class MapsHostActivity extends AppCompatActivity {

    public static final String CODEFORINFO= "";
    private AppBarConfiguration appBarConfiguration;
    private ActivityMapsHost2Binding binding;
    private MapsFragment map = new MapsFragment();

    private static int countryDisplayed =0;
    public LifeCycleHandler handler = new LifeCycleHandler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMapsHost2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        handler.getContext(getApplicationContext());
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            registerActivityLifecycleCallbacks(handler);
        }
        Intent in = getIntent();
        Bundle bund = in.getExtras();
        String country = bund.getString("country");
        String code = bund.getString("code");
        TextView tv = findViewById(R.id.tvMapsCountry);
        tv.setText(country);
        if(country.equals("Greece")){
            Bundle mapsBund = new Bundle();
            int countryCode = 1;
            mapsBund.putInt("code", countryCode);
            map.setArguments(mapsBund);
            countryDisplayed=1;
        }else if(country.equals("Cyprus")){
            Bundle mapsBund = new Bundle();
            int countryCode = 2;
            mapsBund.putInt("code", countryCode);
            map.setArguments(mapsBund);
            countryDisplayed = 2;
        }

        getSupportFragmentManager().beginTransaction().replace(R.id.mapContainer,map).commit();

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Press home to go back to the selection screen", Snackbar.LENGTH_LONG)
                        .setAnchorView(R.id.fab)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_maphost, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.menu_home) {
            finish();
        } else if (id == R.id.menu_information) {
            Intent in = new Intent(this, CountryInformationActivity.class);
            String code = ""+countryDisplayed;
            in.putExtra(CODEFORINFO,code);
            startActivity(in);
        }

        return super.onOptionsItemSelected(item);
    }


}