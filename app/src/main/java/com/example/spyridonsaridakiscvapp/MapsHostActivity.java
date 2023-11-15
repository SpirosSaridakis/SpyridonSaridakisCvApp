package com.example.spyridonsaridakiscvapp;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.spyridonsaridakiscvapp.databinding.ActivityMapsHost2Binding;

public class MapsHostActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMapsHost2Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsHost2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Intent in = getIntent();
        Bundle bund = in.getExtras();
        String country = bund.getString("country");
        String code = bund.getString("code");
        TextView tv = findViewById(R.id.tvMapsCountry);
        tv.setText(country);

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
        }

        return super.onOptionsItemSelected(item);
    }


}