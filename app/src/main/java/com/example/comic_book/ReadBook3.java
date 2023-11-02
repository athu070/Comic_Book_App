package com.example.comic_book;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ReadBook3 extends AppCompatActivity {

    Button view;
    DatabaseReference database;
    String meassage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_book3);

        view = findViewById(R.id.view1);

        database = FirebaseDatabase.getInstance().getReference().child("pdf1");
        database.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                meassage = dataSnapshot.getValue(String.class);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(ReadBook3.this,"Error Loading PDF",Toast.LENGTH_SHORT).show();
            }
        });

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CharSequence options[] = new CharSequence[]{
                        "Download",
                        "View",
                        "Cancel"
                };
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                builder.setTitle("Choose One");
                builder.setItems(options, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        if (which == 0){
                            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(meassage));
                            startActivity(intent);
                        }
                        if (which == 1) {
                            Intent intent = new Intent(view.getContext(), BookView2.class);
                            intent.putExtra("url", meassage);
                            startActivity(intent);
                        }
                    }
                });
                builder.show();
            }
        });


    }
}