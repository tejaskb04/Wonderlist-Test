package com.example.wonderlist;

import android.content.Intent;
import android.support.v4.app.ShareCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.google.firebase.auth.FirebaseAuth;

import java.util.Random;

public class SplashActivity extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;
    private LinearLayout linearLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        firebaseAuth = FirebaseAuth.getInstance();
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

        Button goHome = (Button) findViewById(R.id.buttonHome);
    }

    public void onClick(View view){
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
