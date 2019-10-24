package com.example.thinkanumber;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{


    private Button btnPlus, btnMinus, btnSend;
    private TextView textTipp;
    private ImageView heart1, heart2, heart3, heart4, heart5;
    private Random r;
    private int Eletek, gondoltSzam, tipp;
    private static List<ImageView> eletek;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        btnSend.setOnClickListener(this);
        btnPlus.setOnClickListener(this);
        btnMinus.setOnClickListener(this);

    }

    private void init(){
        btnPlus = findViewById(R.id.buttonPlus);
        btnMinus = findViewById(R.id.buttonMinus);
        btnSend = findViewById(R.id.buttonSend);
        textTipp = findViewById(R.id.textTipp);
        heart1 = findViewById(R.id.heart1);
        heart2 = findViewById(R.id.heart2);
        heart3 = findViewById(R.id.heart3);
        heart4 = findViewById(R.id.heart4);
        heart5 = findViewById(R.id.heart5);

        //eletek.add(heart1);
        //eletek.add(heart2);
        //eletek.add(heart3);
        //eletek.add(heart4);
        //eletek.add(heart5);
        Random r = new Random();
        gondoltSzam = r.nextInt(10);
        Eletek = 5;
        tipp = 0;
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.buttonPlus:
                if (tipp<10){
                    tipp++;
                    textTipp.setText(""+ tipp);
                }
                break;
            case R.id.buttonMinus:
                if (tipp>1){
                    tipp--;
                    textTipp.setText(""+tipp);
                }
                break;
            case R.id.buttonSend:
                if (tipp>gondoltSzam)
                {
                    Toast.makeText(MainActivity.this, "Lejjebb", Toast.LENGTH_SHORT).show();
                } else
                if (tipp<gondoltSzam)
                {
                    Toast.makeText(MainActivity.this, "Feljebb", Toast.LENGTH_SHORT).show();
                } else
                if (tipp==gondoltSzam)
                {
                    Toast.makeText(MainActivity.this, "Nyertél", Toast.LENGTH_SHORT).show();
                    //gondoltSzam = r.nextInt(10);
                    tipp=0;
                    textTipp.setText(""+tipp);
                }
                break;
        }

    }
}
