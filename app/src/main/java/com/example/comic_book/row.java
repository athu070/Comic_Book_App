package com.example.comic_book;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.ui.PlayerView;

public class row extends AppCompatActivity {

    boolean fullscreen = false;
    ImageView fullscreenButton;
    private PlayerView playerView;
    private SimpleExoPlayer player;
    private String url;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_row);

        playerView = findViewById(R.id.exoplayer_view1);
        textView = findViewById(R.id.Titletv);

        fullscreenButton = playerView.findViewById(R.id.exoplayer_fullscreen_icon);

        Intent intent = getIntent();
        url = intent.getExtras().getString("ur");
        String title = intent.getExtras().getString("nam");

        textView.setText(title);

        fullscreenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (fullscreen){
                    fullscreenButton.setImageDrawable(ContextCompat.getDrawable(row.this,R.drawable.fullscreen));
                    getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_VISIBLE);
                    if (getSupportActionBar() != null){
                        getSupportActionBar().show();
                    }
                    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
                    LinearLayout.LayoutParams params = (LinearLayout.LayoutParams)playerView.getLayoutParams();
                    params.width = params.MATCH_PARENT;
                    params.height = (int) (200 * getApplicationContext().getResources().getDisplayMetrics().density);
                    playerView.setLayoutParams(params);
                    fullscreen = false;
                }else {
                    fullscreenButton.setImageDrawable(ContextCompat.getDrawable(row.this,R.drawable.fullscreen_exit));
                    getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                    | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
                    if (getSupportActionBar() != null){
                        getSupportActionBar().hide();
                    }
                    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
                    LinearLayout.LayoutParams params = (LinearLayout.LayoutParams)playerView.getLayoutParams();
                    params.width = params.MATCH_PARENT;
                    params.height = params.MATCH_PARENT;
                    playerView.setLayoutParams(params);
                    fullscreen = true;
                }
            }
        });

    }
}