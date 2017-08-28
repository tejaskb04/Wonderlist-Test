package com.example.wonderlist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;

import java.util.Random;

public class SplashActivity extends AppCompatActivity {

    private LinearLayout linearLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        linearLayout = (LinearLayout) findViewById(R.id.linearLayout);
        Random r = new Random();
        int backgroundNumber = r.nextInt(3) + 1;
        System.out.println(backgroundNumber);
        if (backgroundNumber == 1) {
            linearLayout.setBackgroundResource(R.drawable.background_1);
        }
        else if (backgroundNumber == 2) {
            linearLayout.setBackgroundResource(R.drawable.background_2);
        }
        else {
            linearLayout.setBackgroundResource(R.drawable.background_3);
        }
    }
}
