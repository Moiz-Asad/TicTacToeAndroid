package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startActivity(new Intent(this,SplashScreen.class));
    }

    public void BuPlay(View view) {
        startActivity(new Intent(MainActivity.this,Game.class));
    }

    public void BuExit(View view) {
        finish();
    }

}