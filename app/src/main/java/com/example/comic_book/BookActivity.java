package com.example.comic_book;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.github.barteksc.pdfviewer.PDFView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class BookActivity extends AppCompatActivity {

    String urls;
    PDFView pdfView;
    ProgressDialog dialog;
    DatabaseReference database;

    ImageView img1,img2,img3,img4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);


        img1 = findViewById(R.id.img1);
        img2 = findViewById(R.id.img2);
        img3 = findViewById(R.id.img5);
        img4 = findViewById(R.id.img6);

        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BookActivity.this,ReadBook1.class);
                startActivity(intent);
            }
        });

        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BookActivity.this,ReadBook2.class);
                startActivity(intent);
            }
        });

        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BookActivity.this,ReadBook3.class);
                startActivity(intent);
            }
        });

        img4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BookActivity.this,ReadBook4.class);
                startActivity(intent);
            }
        });

//
//        pdfView = findViewById(R.id.abc);
//
//        dialog = new ProgressDialog(this);
//        dialog.setMessage("Loading..");
//        dialog.show();
//
//        urls = getIntent().getStringExtra("url");
//        new RetrivePdfStream().execute(urls);

    }

//    class RetrivePdfStream extends AsyncTask<String, Void, InputStream> {
//
//        @Override
//        protected InputStream doInBackground(String... strings) {
//            InputStream inputStream = null;
//            try {
//
//                // adding url
//                URL url = new URL(strings[0]);
//                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
//
//                // if url connection response code is 200 means ok the execute
//                if (urlConnection.getResponseCode() == 200) {
//                    inputStream = new BufferedInputStream(urlConnection.getInputStream());
//                }
//            }
//            // if error return null
//            catch (IOException e) {
//                return null;
//            }
//            return inputStream;
//        }
//        @Override
//        // Here load the pdf and dismiss the dialog box
//        protected void onPostExecute(InputStream inputStream) {
//            pdfView.fromStream(inputStream).load();
//            dialog.dismiss();
//        }
//    }
}