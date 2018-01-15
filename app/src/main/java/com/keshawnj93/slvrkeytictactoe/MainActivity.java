package com.keshawnj93.slvrkeytictactoe;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
    int[][] gameBoard = new int[3][3];
    ArrayList<Button> gameButtons;
    int gameState = 0; //0 = game in session. 1 = O wins. 2 = X wins 3 = tie
    int turn = 0; // 0 = O turn. 1 = X turn (AI is X)
    int Starter = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialize Buttons
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);

        gameButtons = new ArrayList<>(Arrays.asList(btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9));

        for (Button b: gameButtons){
            b.setOnClickListener(this);
            b.setTextSize(32);
        }

        //Set initial values for gameBoard
        resetGame();
    }

    @Override
    public void onClick(View v) {
        //The game logic
        if (gameState == 0){
            if (turn == 0) {
                boolean set;
                set = setButton(v);
                if (set) {
                    checkResult();
                    if (gameState == 0) {
                        aiGo();
                        checkResult();
                    }
                }
            }

            else if (turn == 1){
                aiGo();
                checkResult();
            }
        }

        else resetGame();
    }

    private boolean setButton(View v){
        //Set Buttons to X or O accordingly, and switch turn
        switch(v.getId()){
            case R.id.btn1:
                if (btn1.getText().toString().equals("")){
                    if (turn == 0){
                        btn1.setText("O");
                        turn = 1;
                        gameBoard[0][0] = 1;
                    }
                    else{
                        turn = 0;
                        btn1.setText("X");
                        gameBoard[0][0] = 2;
                    }
                    return true;
                } break;

            case R.id.btn2:
                if (btn2.getText().toString().equals("")){
                    if (turn == 0){
                        btn2.setText("O");
                        turn = 1;
                        gameBoard[0][1] = 1;
                    }
                    else{
                        turn = 0;
                        btn2.setText("X");
                        gameBoard[0][1] = 2;
                    }
                    return true;
                } break;

            case R.id.btn3:
                if (btn3.getText().toString().equals("")){
                    if (turn == 0){
                        btn3.setText("O");
                        turn = 1;
                        gameBoard[0][2] = 1;
                    }
                    else{
                        turn = 0;
                        btn3.setText("X");
                        gameBoard[0][2] = 2;
                    }
                    return true;
                } break;

            case R.id.btn4:
                if (btn4.getText().toString().equals("")){
                    if (turn == 0){
                        btn4.setText("O");
                        turn = 1;
                        gameBoard[1][0] = 1;
                    }
                    else{
                        turn = 0;
                        btn4.setText("X");
                        gameBoard[1][0] = 2;
                    }
                    return true;
                } break;

            case R.id.btn5:
                if (btn5.getText().toString().equals("")){
                    if (turn == 0){
                        btn5.setText("O");
                        turn = 1;
                        gameBoard[1][1] = 1;
                    }
                    else{
                        turn = 0;
                        btn5.setText("X");
                        gameBoard[1][1] = 2;
                    }
                    return true;
                } break;

            case R.id.btn6:
                if (btn6.getText().toString().equals("")){
                    if (turn == 0){
                        btn6.setText("O");
                        turn = 1;
                        gameBoard[1][2] = 1;
                    }
                    else{
                        turn = 0;
                        btn6.setText("X");
                        gameBoard[1][2] = 2;
                    }
                    return true;
                } break;

            case R.id.btn7:
                if (btn7.getText().toString().equals("")){
                    if (turn == 0){
                        btn7.setText("O");
                        turn = 1;
                        gameBoard[2][0] = 1;
                    }
                    else{
                        turn = 0;
                        btn7.setText("X");
                        gameBoard[2][0] = 2;
                    }
                    return true;
                } break;

            case R.id.btn8:
                if (btn8.getText().toString().equals("")){
                    if (turn == 0){
                        btn8.setText("O");
                        turn = 1;
                        gameBoard[2][1] = 1;
                    }
                    else{
                        turn = 0;
                        btn8.setText("X");
                        gameBoard[2][1] = 2;
                    }
                    return true;
                } break;

            case R.id.btn9:
                if (btn9.getText().toString().equals("")){
                    if (turn == 0){
                        btn9.setText("O");
                        turn = 1;
                        gameBoard[2][2] = 1;
                    }
                    else{
                        turn = 0;
                        btn9.setText("X");
                        gameBoard[2][2] = 2;
                    }
                    return true;
                } break;
        }

        return false;
    }

    private void checkResult(){
        if (gameBoard[0][0] != 0){
            //Top Horizontal
            if (gameBoard[0][0] == gameBoard[0][1] && gameBoard[0][1] == gameBoard[0][2]){
                btn1.setTextColor(Color.parseColor("#FF0000"));
                btn2.setTextColor(Color.parseColor("#FF0000"));
                btn3.setTextColor(Color.parseColor("#FF0000"));
                gameState = gameBoard[0][0];
            }

            //Left Vertical
            if (gameState == 0 && gameBoard[0][0] == gameBoard[1][0] && gameBoard[1][0] == gameBoard[2][0]){
                btn1.setTextColor(Color.parseColor("#FF0000"));
                btn4.setTextColor(Color.parseColor("#FF0000"));
                btn7.setTextColor(Color.parseColor("#FF0000"));
                gameState = gameBoard[0][0];
            }

            //Left Diagonal
            if (gameState == 0 && gameBoard[0][0] == gameBoard[1][1] && gameBoard[1][1] == gameBoard[2][2]){
                btn1.setTextColor(Color.parseColor("#FF0000"));
                btn5.setTextColor(Color.parseColor("#FF0000"));
                btn9.setTextColor(Color.parseColor("#FF0000"));
                gameState = gameBoard[0][0];
            }
        }

        if (gameState == 0 && gameBoard[0][2] != 0){
            //Right Vertical
            if (gameBoard[0][2] == gameBoard[1][2] && gameBoard[1][2] == gameBoard[2][2]){
                btn3.setTextColor(Color.parseColor("#FF0000"));
                btn6.setTextColor(Color.parseColor("#FF0000"));
                btn9.setTextColor(Color.parseColor("#FF0000"));
                gameState = gameBoard[0][2];
            }

            //Right Diagonal
            if (gameState == 0 && gameBoard[0][2] == gameBoard[1][1] && gameBoard[1][1] == gameBoard[2][0]){
                btn3.setTextColor(Color.parseColor("#FF0000"));
                btn5.setTextColor(Color.parseColor("#FF0000"));
                btn7.setTextColor(Color.parseColor("#FF0000"));
                gameState = gameBoard[0][2];
            }
        }

        //Middle Horizontal
        if (gameState == 0 && gameBoard[1][0] != 0 && gameBoard[1][0] == gameBoard[1][1] && gameBoard[1][1] == gameBoard[1][2]){
            btn4.setTextColor(Color.parseColor("#FF0000"));
            btn5.setTextColor(Color.parseColor("#FF0000"));
            btn6.setTextColor(Color.parseColor("#FF0000"));
            gameState = gameBoard[1][0];
        }

        //Bottom Horizontal
        if (gameState == 0 && gameBoard[2][0] != 0 && gameBoard[2][0] == gameBoard[2][1] && gameBoard[2][1] == gameBoard[2][2]){
            btn7.setTextColor(Color.parseColor("#FF0000"));
            btn8.setTextColor(Color.parseColor("#FF0000"));
            btn9.setTextColor(Color.parseColor("#FF0000"));
            gameState = gameBoard[2][0];
        }

        //Middle Vertical
        if (gameState == 0 && gameBoard[0][1] != 0 && gameBoard[0][1] == gameBoard[1][1] && gameBoard[1][1] == gameBoard[2][1]){
            btn2.setTextColor(Color.parseColor("#FF0000"));
            btn5.setTextColor(Color.parseColor("#FF0000"));
            btn8.setTextColor(Color.parseColor("#FF0000"));
            gameState = gameBoard[0][1];
        }

        //Tie
        if (gameState == 0){
            gameState = 3; // Assume Tie
            for (int[] e: gameBoard){
                for (int i = 0; i < 3 && gameState != 0; i++){
                    if (e[i] == 0){
                        gameState = 0; break; // Tie Disproven
                    }
                }
            }
        }
    }

    private void resetGame(){

        //Set initial values for gameBoard
        for(int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                gameBoard[i][j] = 0;
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

    private void aiGo(){
        Move best = minimax(gameBoard, 1);
        executeMove(best);
    }

    private Move minimax(int[][] newBoard, int player){
        Move move;
        int[] possibleMoves = new int[9];
        //Get available moves for AI
        int availableMoves = 0;

        for (int i = 0, k = 0; i < 3; i++){
            for (int j = 0; j < 3; j++, k++){
                if (newBoard[i][j] == 0){ // The AI can move here
                    possibleMoves[k] = 0;
                    availableMoves++;
                }

                else possibleMoves[k] = 1; // AI cannot move here

            }
        }

        //Check for terminal state
        if (winning(newBoard, 0)) { //Player wins
            move = new Move();
            move.score = -10;
            return move;
        }

        else if (winning(newBoard, 1)){ //AI wins
            move = new Move();
            move.score = 10;
            return move;
        }

        else if (availableMoves == 0){
            move = new Move();
            move.score = 0;
            return move;
        }


        ArrayList<Move> allMoves = new ArrayList<>();
        for (int i = 0, k = 0; i < 3; i++){
            for (int j = 0; j < 3; j++, k++){
                if (possibleMoves[k] == 0){
                    move = new Move();
                    move.i = i;
                    move.j = j;
                    newBoard[i][j] = player + 1;

                    if (player == 0){
                        Move result = minimax(newBoard, 1);
                        move.score = result.score;
                    }

                    else if (player == 1){
                        Move result = minimax(newBoard, 0);
                        move.score = result.score;
                    }

                    newBoard[i][j] = 0;

                    allMoves.add(move);
                }
            }
        }

        Move bestMove = new Move();
        if (player == 0){
            int bestScore = 9999;
            for (Move m : allMoves){
                if (m.score < bestScore){
                    bestScore = m.score;
                    bestMove = m;
                }
            }
        }

        else{
            int bestScore = -9999;
            for (Move m : allMoves){
                if (m.score > bestScore){
                    bestScore = m.score;
                    bestMove = m;
                }
            }
        }

        return bestMove;
    }

    private void executeMove(Move move){
        int check = move.i;
        switch (check){
            case 0:
                switch (move.j){
                    case 0:
                        btn1.setText("X");
                        gameBoard[0][0] = 2;
                        turn = 0; break;
                    case 1:
                        btn2.setText("X");
                        gameBoard[0][1] = 2;
                        turn = 0; break;
                    case 2:
                        btn3.setText("X");
                        gameBoard[0][2] = 2;
                        turn = 0; break;
                } break;
            case 1:
                switch (move.j){
                    case 0:
                        btn4.setText("X");
                        gameBoard[1][0] = 2;
                        turn = 0; break;
                    case 1:
                        btn5.setText("X");
                        gameBoard[1][1] = 2;
                        turn = 0; break;
                    case 2:
                        btn6.setText("X");
                        gameBoard[1][2] = 2;
                        turn = 0; break;
                } break;
            case 2:
                switch (move.j){
                    case 0:
                        btn7.setText("X");
                        gameBoard[2][0] = 2;
                        turn = 0; break;
                    case 1:
                        btn8.setText("X");
                        gameBoard[2][1] = 2;
                        turn = 0; break;
                    case 2:
                        btn9.setText("X");
                        gameBoard[2][2] = 2;
                        turn = 0; break;
                } break;
        }
    }

    private boolean winning(int[][] newBoard, int player){
        if (gameBoard[0][0] == player + 1){
            //Top Horizontal
            if (gameBoard[0][0] == gameBoard[0][1] && gameBoard[0][1] == gameBoard[0][2]){
                return true;
            }

            //Left Vertical
            if (gameState == 0 && gameBoard[0][0] == gameBoard[1][0] && gameBoard[1][0] == gameBoard[2][0]){
                return true;
            }

            //Left Diagonal
            if (gameState == 0 && gameBoard[0][0] == gameBoard[1][1] && gameBoard[1][1] == gameBoard[2][2]){
                return true;
            }
        }

        if (gameState == 0 && gameBoard[0][2] == player + 1){
            //Right Vertical
            if (gameBoard[0][2] == gameBoard[1][2] && gameBoard[1][2] == gameBoard[2][2]){
                return true;
            }

            //Right Diagonal
            if (gameBoard[0][2] == gameBoard[1][1] && gameBoard[1][1] == gameBoard[2][0]){
                return true;
            }
        }

        //Middle Horizontal
        if (gameState == 0 && gameBoard[1][0] == player + 1 && gameBoard[1][0] == gameBoard[1][1] && gameBoard[1][1] == gameBoard[1][2]){
            return true;
        }

        //Bottom Horizontal
        if (gameState == 0 && gameBoard[2][0] == player + 1 && gameBoard[2][0] == gameBoard[2][1] && gameBoard[2][1] == gameBoard[2][2]){
            return true;
        }

        //Middle Vertical
        if (gameState == 0 && gameBoard[0][1] == player + 1 && gameBoard[0][1] == gameBoard[1][1] && gameBoard[1][1] == gameBoard[2][1]){
            return true;
        }

        return false;
    }

}
