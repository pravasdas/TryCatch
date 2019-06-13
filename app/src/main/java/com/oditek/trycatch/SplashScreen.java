package com.oditek.trycatch;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SplashScreen extends AppCompatActivity {
    ImageView splash;
    Animation animZoomIn;
    private static int SPLASH_TIME_LENGTH = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        animZoomIn = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);
        splash = (ImageView) findViewById(R.id.logo);
        splash.setVisibility(View.VISIBLE);
        splash.startAnimation(animZoomIn);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent in = new Intent(SplashScreen.this, MyLocationUsingHelper.class);
                startActivity(in);
            }
        }, SPLASH_TIME_LENGTH);
    }
}
