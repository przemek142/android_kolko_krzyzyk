package com.example.przemo.ck;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class Model {
    private ImageView imageView;
    private int currentPlayer = 1;
    int[] gameStatus = {0, 0, 0, 0, 0, 0, 0, 0, 0};
    int[][] winningOptions = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {2, 4, 6}};
    int tag;
    boolean gameRunning = true;
    TextView textView;
    Button resetBTN;

    public void setCurrentPlayer() {
        if (currentPlayer == 1) {
            this.currentPlayer = 2;
        } else {
            this.currentPlayer = 1;
        }
    }

    public void setImage() {

        if (currentPlayer == 1) {
            imageView.setImageResource(R.drawable.circle);
            gameStatus[tag] = 1;
        } else if (currentPlayer == 2) {
            imageView.setImageResource(R.drawable.cross);
            gameStatus[tag] = 2;

        }
    }

    public void winner() {
        for (int i = 0; i < winningOptions.length; i++) {
            if (gameStatus[winningOptions[i][0]] == gameStatus[winningOptions[i][1]] &&
                    gameStatus[winningOptions[i][1]] == gameStatus[winningOptions[i][2]] &&
                    gameStatus[winningOptions[i][0]] != 0) {
                if (gameStatus[winningOptions[i][0]] == 2)
                    textView.setText("Wygrał krzyżyk");
                else
                    textView.setText("Wygrał kółko");
                textView.setVisibility(View.VISIBLE);
                gameRunning = false;
                resetBTN.setVisibility(View.VISIBLE);

            }
        }
        int free = 0;
        for (int i = 0; i < gameStatus.length; i++) {
            if (gameStatus[i] != 0)
                free++;
        }
        if (gameRunning && free == 9) {
            textView.setText("Remis");
            textView.setVisibility(View.VISIBLE);
            gameRunning = false;
            resetBTN.setVisibility(View.VISIBLE);

        }
    }

    public void resetGame() {

        textView.setVisibility(View.INVISIBLE);
        gameRunning = true;
        for (int i = 0; i < gameStatus.length; i++) {
            gameStatus[i] = 0;
        }
    }

    public void click(View view, TextView textView, Button resetBTN) {
        this.resetBTN = resetBTN;
        this.textView = textView;
        imageView = (ImageView) view;
        Log.i("aaaaaaaaaaaaclick", imageView.getTag().toString());
        setCurrentPlayer();
        tag = Integer.parseInt(imageView.getTag().toString());
        if (gameStatus[tag] == 0 && gameRunning)
            setImage();
        winner();
    }
}
