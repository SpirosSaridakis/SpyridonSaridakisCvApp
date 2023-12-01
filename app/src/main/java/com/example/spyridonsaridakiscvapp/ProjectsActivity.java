package com.example.spyridonsaridakiscvapp;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Application;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ProjectsActivity extends AppCompatActivity {

    public LifeCycleHandler handler = new LifeCycleHandler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_projects);
        handler.getContext(getApplicationContext());
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            registerActivityLifecycleCallbacks(handler);
        }
        Boolean isWbFull=false;
        WebView wb = findViewById(R.id.wvProfile);
        wb.setWebViewClient(new WebViewClient());
        TextView tvProfile = findViewById(R.id.tvProfileTitle);
        tvProfile.setText("Github Profile");
        TextView tvProfileDesc = findViewById(R.id.tvProfileDesc);
        tvProfileDesc.setText("This is my github profile. I have been using github for over a year " +
                "now and i have created a lot of different projects, in this screen I will be showcasing " +
                "the most important projects I have worked on.");
        wb.loadUrl("https://github.com/SpirosSaridakis");
        CheckBox cbProfile = findViewById(R.id.cbProfile);
        cbProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    changeWebViewHeight(wb);
            }
        });
        Boolean isWbp1Full=false;
        WebView wbp1 = findViewById(R.id.wvProject1);
        wbp1.setWebViewClient(new WebViewClient());
        TextView tvpT = findViewById(R.id.tvTitleProject);
        tvpT.setText("Project Padanian Bank");
        TextView tvpD = findViewById(R.id.tvProjectDesc);
        tvpD.setText("In this project, we were tasked with creating a website of our choice " +
                "we created a website that uses c# as the backend(.Net core webAPI) and cshtml and c# view for " +
                "the front end.");
        wbp1.loadUrl("https://github.com/SpirosSaridakis/BankingApp");
        CheckBox cbP = findViewById(R.id.cbP);
        cbP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeWebViewHeight(wbp1);
            }
        });

        Boolean isWbp2Full=false;
        TextView tvp1T = findViewById(R.id.tvTitleProject1);
        tvp1T.setText("Project Padanian Earthquake Adventure");
        TextView tvp1D = findViewById(R.id.tvProjectDesc1);
        tvp1D.setText("For this project, we were tasked with creating a video game. We made a serious game that " +
                "teaches the player what to do in a case of an earthquake. We used the Unity game engine and C# for" +
                " the scripting.");
        WebView wbp2 = findViewById(R.id.wvProject2);
        wbp2.setWebViewClient(new WebViewClient());
        wbp2.loadUrl("https://github.com/SpirosSaridakis/PadanianEarthquakeAdventure");
        CheckBox cbP1 = findViewById(R.id.cbP1);
        cbP1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeWebViewHeight(wbp2);
            }
        });

        Boolean isWbp3Full=false;
        TextView tvp2T = findViewById(R.id.tvTitleProject2);
        tvp2T.setText("Erasmus Budget App");
        TextView tvp2D = findViewById(R.id.tvProjectDesc2);
        tvp2D.setText("For this project, I built a basic mobile application to help me keep track of my expenses while " +
                "I was in Cyprus. I used Android studio with the Kotlin programming language.");
        WebView wbp3 = findViewById(R.id.wvProject3);
        wbp3.setWebViewClient(new WebViewClient());
        wbp3.loadUrl("https://github.com/SpirosSaridakis/ErasmusBudgetApp");
        CheckBox cbP2 = findViewById(R.id.cbP2);
        cbP2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeWebViewHeight(wbp3);
            }
        });
    }

    public void changeWebViewHeight(View wb){
        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) wb.getLayoutParams();
        if(params.height==ViewGroup.LayoutParams.WRAP_CONTENT){
            params.height= 0;
        }else{
            params.height=ViewGroup.LayoutParams.WRAP_CONTENT;
        }
        wb.setLayoutParams(params);

    }

    public void backToND(View v){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            unregisterActivityLifecycleCallbacks(handler);
        }
        finish();
    }


}