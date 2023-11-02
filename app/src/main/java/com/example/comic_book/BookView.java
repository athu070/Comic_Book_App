package com.example.comic_book;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;
import com.google.firebase.database.DatabaseReference;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class BookView extends AppCompatActivity {

    String urls;
    PDFView pdfView;
    ProgressDialog dialog;
    DatabaseReference database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_view);

        pdfView = findViewById(R.id.abc);

        dialog = new ProgressDialog(this);
        dialog.setMessage("Loading..");
        dialog.show();

        urls = getIntent().getStringExtra("url");
        new RetrivePdfStream().execute(urls);

    }
    class RetrivePdfStream extends AsyncTask<String, Void, InputStream> {

        @Override
        protected InputStream doInBackground(String... strings) {
            InputStream inputStream = null;
            try {

                // adding url
                URL url = new URL(strings[0]);
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

                // if url connection response code is 200 means ok the execute
                if (urlConnection.getResponseCode() == 200) {
                    inputStream = new BufferedInputStream(urlConnection.getInputStream());
                }
            }
            // if error return null
            catch (IOException e) {
                return null;
            }
            return inputStream;
        }
        @Override
        // Here load the pdf and dismiss the dialog box
        protected void onPostExecute(InputStream inputStream) {
            pdfView.fromStream(inputStream).load();
            dialog.dismiss();
        }
    }
}