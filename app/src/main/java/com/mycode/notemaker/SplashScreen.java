package com.mycode.notemaker;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

@SuppressLint("CustomSplashScreen")
public class SplashScreen extends AppCompatActivity {

    ImageView imageViewLogo, imageViewText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        imageViewLogo = findViewById(R.id.logoSplash);
        imageViewText = findViewById(R.id.textSplash);

        Animation alpha = AnimationUtils.loadAnimation(this, R.anim.alpha);
        imageViewText.startAnimation(alpha);

        Intent intent = new Intent(this, MainActivity.class);
        new Handler().postDelayed(()->{
            startActivity(intent);
            finish();
        }, 5000);
    }
}