package com.example.tictactoe;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Game extends AppCompatActivity {
    private Button[] Grid = new Button[9];
    private int NoOfTurns = 0;
    private int Turn = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
    }

    private void SetupGrid()
    {
        Grid[0] =  findViewById(R.id.B1);
        Grid[1] =  findViewById(R.id.B2);
        Grid[2] =  findViewById(R.id.B3);
        Grid[3] =  findViewById(R.id.B4);
        Grid[4] =  findViewById(R.id.B5);
        Grid[5] =  findViewById(R.id.B6);
        Grid[6] =  findViewById(R.id.B7);
        Grid[7] =  findViewById(R.id.B8);
        Grid[8] =  findViewById(R.id.B9);
    }
    String Win;
    public  void Play(View view) {
        Button B = (Button) view;
        if(!B.getText().equals("X") && !B.getText().equals("O")) {
            if (Turn == 1) {
                B.setText("X");
                Turn++;
                NoOfTurns++;
                TakeTurn("X");
            }
            else {
                B.setText("O");
                Turn--;
                NoOfTurns++;
                TakeTurn("O");
            }
        }
    }
    private void Draw()
    {
        if(NoOfTurns >= 9)
        {
            Intent WINNER = new Intent(this, Winner.class);
            Win = "D";
            WINNER.putExtra("WName", Win);
            startActivity(WINNER);
            finish();
        }
    }
    private void TakeTurn(String D)
    {
        if (IsWin().equals(D)) {
            Win = D;
            Intent WINNER = new Intent(this, Winner.class);
            WINNER.putExtra("WName", Win);
            startActivity(WINNER);
            finish();
        }
        else
        {
            Draw();
        }
    }
    private String IsWin()
    {
        SetupGrid();
        if(HorizontalCheck("X") || VerticalCheck("X") || DiagonalCheck("X"))
        {
            return "X";
        }
        else if(HorizontalCheck("O") || VerticalCheck("O") || DiagonalCheck("O"))
        {
            return "O";
        }
        else
        {
            return "N";
        }
    }
    private boolean DiagonalCheck(String IN)
    {
        if(Grid[0].getText() == IN && Grid[4].getText() == IN && Grid[8].getText() == IN)
        {
            return true;
        }
        else return Grid[2].getText() == IN && Grid[4].getText() == IN && Grid[6].getText() == IN;
    }
    private boolean HorizontalCheck(String IN)
    {
        if(Grid[0].getText() == IN && Grid[1].getText() == IN && Grid[2].getText() == IN)
        {
            return true;
        }
        else if(Grid[3].getText() == IN && Grid[4].getText() == IN && Grid[5].getText() == IN){
            return true;
        }
        else return Grid[6].getText() == IN && Grid[7].getText() == IN && Grid[8].getText() == IN;
    }
    private boolean VerticalCheck(String IN)
    {
        if(Grid[0].getText() == IN && Grid[3].getText() == IN && Grid[6].getText() == IN){
            return true;
        }
        else if(Grid[1].getText() == IN && Grid[4].getText() == IN && Grid[7].getText() == IN){
            return true;
        }
        else return Grid[2].getText() == IN && Grid[5].getText() == IN && Grid[8].getText() == IN;
    }

}














