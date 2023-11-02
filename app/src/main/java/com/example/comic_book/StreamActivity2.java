package com.example.comic_book;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class StreamActivity2 extends AppCompatActivity {

    RecyclerView  Mrecyclerview1;
    RecyclerView adapter;
    FirebaseDatabase database2, database1;
    DatabaseReference reference1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stream2);

        Mrecyclerview1 = findViewById(R.id.RecylerView);



        Mrecyclerview1.setHasFixedSize(true);


        Mrecyclerview1.setLayoutManager(new LinearLayoutManager(this));


        database2 = FirebaseDatabase.getInstance();


        reference1 = database2.getReference("Video2");



    }

    @Override
    protected void onStart() {
        super.onStart();


        FirebaseRecyclerAdapter<member2, ViewHolder2> firebaseRecyclerAdapter2 =
                new FirebaseRecyclerAdapter<member2, ViewHolder2>(
                        member2.class,
                        R.layout.row2,
                        ViewHolder2.class,
                        reference1
                ) {
                    @Override
                    protected void populateViewHolder(ViewHolder2 viewHolder2, member2 member2, int i) {
                        viewHolder2.setVideo1(getApplication(), member2.getTitle1(), member2.getUrl1());
                    }
                };
        Mrecyclerview1.setAdapter(firebaseRecyclerAdapter2);


    }




}

