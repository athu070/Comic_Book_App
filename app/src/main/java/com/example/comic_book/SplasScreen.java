package com.example.comic_book;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Pair;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplasScreen extends AppCompatActivity {

    private static int DELAY_TIME = 4000;
    Animation topAnim, bottomAnim;
    ImageView imageView;
    TextView app_name;

    Handler h = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splas_screen);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        topAnim = AnimationUtils.loadAnimation(this,R.anim.top_animation);
        bottomAnim = AnimationUtils.loadAnimation(this,R.anim.bottom_animation);

        imageView = findViewById(R.id.imageview2);
        app_name = findViewById(R.id.app_name);

        imageView.setAnimation(topAnim);
        app_name.setAnimation(bottomAnim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent i = new Intent(SplasScreen.this,login.class);

                Pair[] pairs = new Pair[2];
                pairs[0] = new Pair(imageView,"splash_image");
                pairs[1] = new Pair(app_name,"splash_text");

                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(SplasScreen.this,pairs);
                startActivity(i,options.toBundle());

            }
        },DELAY_TIME);


    }
}