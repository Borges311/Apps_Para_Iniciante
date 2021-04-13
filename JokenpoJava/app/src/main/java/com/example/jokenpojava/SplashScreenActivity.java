package com.example.jokenpojava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashScreenActivity extends AppCompatActivity {
    private ImageView img1, img2, img3;
    private TextView textJo, textKen, textPo;
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        getSupportActionBar().hide();
        img1 = findViewById(R.id.img1);
        img2 = findViewById(R.id.img2);
        img3 = findViewById(R.id.img3);

        textJo = findViewById(R.id.textJo);
        textKen = findViewById(R.id.textKen);
        textPo = findViewById(R.id.textPo);

        img1.setVisibility(View.GONE);
        textJo.setVisibility(View.GONE);

        img2.setVisibility(View.GONE);
        textKen.setVisibility(View.GONE);

        img3.setVisibility(View.GONE);
        textPo.setVisibility(View.GONE);


        boolean handler = new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                img1.setVisibility(View.VISIBLE);
                textJo.setVisibility(View.VISIBLE);
            }
        },1000);

        handler = new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                img2.setVisibility(View.VISIBLE);
                textKen.setVisibility(View.VISIBLE);
            }
        },2000);

        handler = new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                img3.setVisibility(View.VISIBLE);
                textPo.setVisibility(View.VISIBLE);
                Intent intent = new Intent(SplashScreenActivity.this, MainActivity.class);
                startActivity(intent);
            }
        }, 3000);

    }
 }
