package com.example.wonderlist;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v4.app.ShareCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.TextureView;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

import java.util.Random;

public class SplashActivity extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;
    private LinearLayout linearLayout;
    private Button dashboardBtn;
    private AssetManager assetManager;
    private TextView view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        firebaseAuth = FirebaseAuth.getInstance();
        linearLayout = (LinearLayout) findViewById(R.id.linearLayout);
        Random r = new Random();
        assetManager = this.getApplicationContext().getAssets();
        view = (TextView) findViewById(R.id.mainAppTitle);
        Typeface tf = Typeface.createFromAsset(getApplicationContext().getAssets(), "fonts/JosefinSans-Regular.ttf");
        view.setTypeface(tf);
        view.setTextColor(Color.WHITE);
        /*
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
        */
        Button goHome = (Button) findViewById(R.id.buttonHome);
        dashboardBtn = (Button) findViewById(R.id.dashboard);
        dashboardBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SplashActivity.this, HomePage.class));
            }
        });
    }

    public void onClick(View view) {
        if (firebaseAuth.getCurrentUser() != null) {
            finish();
            startActivity(new Intent(SplashActivity.this, HomePage.class));
        }
        else {
            Intent intent = new Intent(this, RegisterActivity.class);
            startActivity(intent);
        }
    }
}
