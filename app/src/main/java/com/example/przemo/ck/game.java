package com.example.przemo.ck;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class game extends AppCompatActivity {

    Model model = new Model();
    Button resetBTN;

    public void resetG(View view) {
        ImageView i1 = (ImageView) findViewById(R.id.imageView1);
        i1.setImageResource(R.drawable.blank);
        ImageView i2 = (ImageView) findViewById(R.id.imageView2);
        i2.setImageResource(R.drawable.blank);
        ImageView i3 = (ImageView) findViewById(R.id.imageView3);
        i3.setImageResource(R.drawable.blank);
        ImageView i4 = (ImageView) findViewById(R.id.imageView4);
        i4.setImageResource(R.drawable.blank);
        ImageView i5 = (ImageView) findViewById(R.id.imageView5);
        i5.setImageResource(R.drawable.blank);
        ImageView i6 = (ImageView) findViewById(R.id.imageView6);
        i6.setImageResource(R.drawable.blank);
        ImageView i7 = (ImageView) findViewById(R.id.imageView7);
        i7.setImageResource(R.drawable.blank);
        ImageView i8 = (ImageView) findViewById(R.id.imageView8);
        i8.setImageResource(R.drawable.blank);
        ImageView i9 = (ImageView) findViewById(R.id.imageView9);
        i9.setImageResource(R.drawable.blank);
        resetBTN.setVisibility(View.INVISIBLE);

        model.resetGame();
    }

    public void click(View view) {
        resetBTN = (Button) findViewById(R.id.button);
        TextView textView = (TextView) findViewById(R.id.textView);
        model.click(view, textView, resetBTN);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
    }
}
