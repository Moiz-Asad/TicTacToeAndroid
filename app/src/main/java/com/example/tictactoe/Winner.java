package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Winner extends AppCompatActivity {

    TextView Msg;
    TextView WinNam;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winner);
        // Referencing
        WinNam = findViewById(R.id.WinnerName);
        Msg = findViewById(R.id.Message);

        Bundle Data = getIntent().getExtras();

        assert Data != null;
        String WinName = Data.getString("WName");
        assert WinName != null;
        if(!WinName.equals("D")) {
            WinNam.setText(WinName);
        }
        else{
            WinNam.setText(" ");
            Msg.setText("Match Draw!");
        }
    }

    public void CloseWindow(View view) {
        finish();
    }
}