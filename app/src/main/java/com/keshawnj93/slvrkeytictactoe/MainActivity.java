package com.keshawnj93.slvrkeytictactoe;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
    int[][] gameCheck = new int[3][3];
    ArrayList<Button> gameButtons;
    int gameState = 0; //0 = game in session. 1 = O wins. 2 = X wins 3 = tie
    int turn = 0; // 0 = O turn. 1 = X turn
    int Starter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Set initial values for gameCheck
        for(int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                gameCheck[i][j] = 0;
            }
        }

        //Initialize Buttons
        btn1 = (Button)findViewById(R.id.btn1);
        btn2 = (Button)findViewById(R.id.btn2);
        btn3 = (Button)findViewById(R.id.btn3);
        btn4 = (Button)findViewById(R.id.btn4);
        btn5 = (Button)findViewById(R.id.btn5);
        btn6 = (Button)findViewById(R.id.btn6);
        btn7 = (Button)findViewById(R.id.btn7);
        btn8 = (Button)findViewById(R.id.btn8);
        btn9 = (Button)findViewById(R.id.btn9);

        gameButtons = new ArrayList<Button>(Arrays.asList(btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9));

        for (Button b: gameButtons){
            b.setOnClickListener(this);
            b.setTextSize(32);

        }
    }

    @Override
    public void onClick(View v) {
        //The game logic
        if (gameState == 0){
            setButton(v);
            checkResult();
        }

        else resetGame();
    }

    private void setButton(View v){
        //Set Buttons to X or O accordingly, and switch turn
        switch(v.getId()){
            case R.id.btn1:
                if (btn1.getText().toString().equals("")){
                    if (turn == 0){
                        btn1.setText("O");
                        turn = 1;
                        gameCheck[0][0] = 1;
                    }
                    else{
                        turn = 0;
                        btn1.setText("X");
                        gameCheck[0][0] = 2;
                    }
                } break;

            case R.id.btn2:
                if (btn2.getText().toString().equals("")){
                    if (turn == 0){
                        btn2.setText("O");
                        turn = 1;
                        gameCheck[0][1] = 1;
                    }
                    else{
                        turn = 0;
                        btn2.setText("X");
                        gameCheck[0][1] = 2;
                    }
                } break;

            case R.id.btn3:
                if (btn3.getText().toString().equals("")){
                    if (turn == 0){
                        btn3.setText("O");
                        turn = 1;
                        gameCheck[0][2] = 1;
                    }
                    else{
                        turn = 0;
                        btn3.setText("X");
                        gameCheck[0][2] = 2;
                    }
                } break;

            case R.id.btn4:
                if (btn4.getText().toString().equals("")){
                    if (turn == 0){
                        btn4.setText("O");
                        turn = 1;
                        gameCheck[1][0] = 1;
                    }
                    else{
                        turn = 0;
                        btn4.setText("X");
                        gameCheck[1][0] = 2;
                    }
                } break;

            case R.id.btn5:
                if (btn5.getText().toString().equals("")){
                    if (turn == 0){
                        btn5.setText("O");
                        turn = 1;
                        gameCheck[1][1] = 1;
                    }
                    else{
                        turn = 0;
                        btn5.setText("X");
                        gameCheck[1][1] = 2;
                    }
                } break;

            case R.id.btn6:
                if (btn6.getText().toString().equals("")){
                    if (turn == 0){
                        btn6.setText("O");
                        turn = 1;
                        gameCheck[1][2] = 1;
                    }
                    else{
                        turn = 0;
                        btn6.setText("X");
                        gameCheck[1][2] = 2;
                    }
                } break;

            case R.id.btn7:
                if (btn7.getText().toString().equals("")){
                    if (turn == 0){
                        btn7.setText("O");
                        turn = 1;
                        gameCheck[2][0] = 1;
                    }
                    else{
                        turn = 0;
                        btn7.setText("X");
                        gameCheck[2][0] = 2;
                    }
                } break;

            case R.id.btn8:
                if (btn8.getText().toString().equals("")){
                    if (turn == 0){
                        btn8.setText("O");
                        turn = 1;
                        gameCheck[2][1] = 1;
                    }
                    else{
                        turn = 0;
                        btn8.setText("X");
                        gameCheck[2][1] = 2;
                    }
                } break;

            case R.id.btn9:
                if (btn9.getText().toString().equals("")){
                    if (turn == 0){
                        btn9.setText("O");
                        turn = 1;
                        gameCheck[2][2] = 1;
                    }
                    else{
                        turn = 0;
                        btn9.setText("X");
                        gameCheck[2][2] = 2;
                    }
                } break;
        }
    }

    private void checkResult(){
        if (gameCheck[0][0] != 0){
            //Top Horizontal
            if (gameCheck[0][0] == gameCheck[0][1] && gameCheck[0][1] == gameCheck[0][2]){
                btn1.setTextColor(Color.parseColor("#FF0000"));
                btn2.setTextColor(Color.parseColor("#FF0000"));
                btn3.setTextColor(Color.parseColor("#FF0000"));
                gameState = gameCheck[0][0];
            }

            //Left Vertical
            if (gameState == 0 && gameCheck[0][0] == gameCheck[1][0] && gameCheck[1][0] == gameCheck[2][0]){
                btn1.setTextColor(Color.parseColor("#FF0000"));
                btn4.setTextColor(Color.parseColor("#FF0000"));
                btn7.setTextColor(Color.parseColor("#FF0000"));
                gameState = gameCheck[0][0];
            }

            //Left Diagonal
            if (gameState == 0 && gameCheck[0][0] == gameCheck[1][1] && gameCheck[1][1] == gameCheck[2][2]){
                btn1.setTextColor(Color.parseColor("#FF0000"));
                btn5.setTextColor(Color.parseColor("#FF0000"));
                btn9.setTextColor(Color.parseColor("#FF0000"));
                gameState = gameCheck[0][0];
            }
        }

        if (gameState == 0 && gameCheck[0][2] != 0){
            //Right Vertical
            if (gameCheck[0][2] == gameCheck[1][2] && gameCheck[1][2] == gameCheck[2][2]){
                btn3.setTextColor(Color.parseColor("#FF0000"));
                btn6.setTextColor(Color.parseColor("#FF0000"));
                btn9.setTextColor(Color.parseColor("#FF0000"));
                gameState = gameCheck[0][2];
            }

            //Right Diagonal
            if (gameState == 0 && gameCheck[0][2] == gameCheck[1][1] && gameCheck[1][1] == gameCheck[2][0]){
                btn3.setTextColor(Color.parseColor("#FF0000"));
                btn5.setTextColor(Color.parseColor("#FF0000"));
                btn7.setTextColor(Color.parseColor("#FF0000"));
                gameState = gameCheck[0][2];
            }
        }

        //Middle Horizontal
        if (gameState == 0 && gameCheck[1][0] != 0 && gameCheck[1][0] == gameCheck[1][1] && gameCheck[1][1] == gameCheck[1][2]){
            btn4.setTextColor(Color.parseColor("#FF0000"));
            btn5.setTextColor(Color.parseColor("#FF0000"));
            btn6.setTextColor(Color.parseColor("#FF0000"));
            gameState = gameCheck[1][0];
        }

        //Bottom Horizontal
        if (gameState == 0 && gameCheck[2][0] != 0 && gameCheck[2][0] == gameCheck[2][1] && gameCheck[2][1] == gameCheck[2][2]){
            btn7.setTextColor(Color.parseColor("#FF0000"));
            btn8.setTextColor(Color.parseColor("#FF0000"));
            btn9.setTextColor(Color.parseColor("#FF0000"));
            gameState = gameCheck[2][0];
        }

        //Middle Vertical
        if (gameState == 0 && gameCheck[0][1] != 0 && gameCheck[0][1] == gameCheck[1][1] && gameCheck[1][1] == gameCheck[2][1]){
            btn2.setTextColor(Color.parseColor("#FF0000"));
            btn5.setTextColor(Color.parseColor("#FF0000"));
            btn8.setTextColor(Color.parseColor("#FF0000"));
            gameState = gameCheck[0][1];
        }

        //Tie
        if (gameState == 0){
            gameState = 3; // Assume Tie
            for (int[] e: gameCheck){
                for (int i = 0; i < 3 && gameState != 0; i++){
                    if (e[i] == 0){
                        gameState = 0; break; // Tie Disproven
                    }
                }
            }
        }
    }

    private void resetGame(){

        //Set initial values for gameCheck
        for(int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                gameCheck[i][j] = 0;
            }
        }

        //Reset Buttons
        for (Button b: gameButtons){
            b.setText("");
            b.setTextColor(Color.parseColor("#000000"));
        }

        Starter = ++Starter % 2;
        turn = Starter;
        gameState = 0;
    }


}
