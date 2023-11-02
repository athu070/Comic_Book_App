package com.example.comic_book;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StreamVideo1 extends AppCompatActivity {

    Button stream;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stream_video1);

        stream = findViewById(R.id.view);

        stream.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StreamVideo1.this,StreamActivity.class);
                startActivity(intent);
            }
        });

    }
}