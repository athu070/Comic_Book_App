package com.example.comic_book;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class BuyOption extends AppCompatActivity {

    private TextView receiver_msg,receiver_msg1;
    private ImageView imageView;
    Button proceed;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_option);


        receiver_msg = findViewById(R.id.received_text);
        receiver_msg1 = findViewById(R.id.received_text1);
        imageView = findViewById(R.id.received_img);
        proceed = findViewById(R.id.proceeda);

        Intent intent = getIntent();
        String str = intent.getStringExtra("message_key");
        String str1 = intent.getStringExtra("message_key1");

        receiver_msg1.setText(str1);
        receiver_msg.setText(str);



        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            int resId = bundle.getInt("resId");
            imageView.setImageResource(resId);
        }

        proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(BuyOption.this,AddressSection.class);
                startActivity(intent1);
            }
        });

    }
}