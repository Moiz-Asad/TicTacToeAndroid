package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        ImageView splash = findViewById(R.id.logo);
        splash.startAnimation(AnimationUtils.loadAnimation(this,R.anim.rotate));

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                SplashScreen.this.finish();
            }
        },5000);

    }
}