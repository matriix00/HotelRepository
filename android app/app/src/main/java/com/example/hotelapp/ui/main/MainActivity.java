package com.example.hotelapp.ui.main;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hotelapp.R;
import com.example.hotelapp.ui.Login;


public class MainActivity extends AppCompatActivity {

    Animation topAnim,botAnim;
    ImageView imgv;
    TextView logo,slogan;
    public static int SPLASH_SCREEN = 3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        imgv = findViewById(R.id.imageHotel);
        logo = findViewById(R.id.logo);
        slogan = findViewById(R.id.slogan);
        topAnim =AnimationUtils.loadAnimation(this,R.anim.top_anim);
        botAnim = AnimationUtils.loadAnimation(this,R.anim.bottom_anim);

        imgv.setAnimation(topAnim);
        logo.setAnimation(botAnim);
        slogan.setAnimation(botAnim);

        new Handler(Looper.getMainLooper()).postDelayed(() -> {
            Intent i = new Intent(MainActivity.this, Login.class);
            Pair[] pairs = new Pair[2];
            pairs[0] = new Pair<View,String>(imgv,"logo_image");
            pairs[1] = new Pair<View,String>(logo,"logo_text");
            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this,pairs);
            startActivity(i,options.toBundle());
            finish();

        },SPLASH_SCREEN);

    }
}