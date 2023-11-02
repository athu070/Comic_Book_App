package com.example.comic_book;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class StreamActivity extends AppCompatActivity {

    RecyclerView Mrecyclerview, Mrecyclerview2;

    FirebaseDatabase database, database1;
    DatabaseReference reference, reference1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stream);



        Mrecyclerview = findViewById(R.id.recylerview_video);
        //Mrecyclerview2 = findViewById(R.id.recylerview_video2);

        Mrecyclerview.setHasFixedSize(true);
        //Mrecyclerview2.setHasFixedSize(true);

        Mrecyclerview.setLayoutManager(new LinearLayoutManager(this));
        //Mrecyclerview2.setLayoutManager(new LinearLayoutManager(this));

        database = FirebaseDatabase.getInstance();
        //database1 = FirebaseDatabase.getInstance();

        reference = database.getReference("Video");
        //reference1 = database.getReference("Video2");


    }

    @Override
    protected void onStart() {
        super.onStart();


        FirebaseRecyclerAdapter<member, ViewHolder> firebaseRecyclerAdapter =
                new FirebaseRecyclerAdapter<member, ViewHolder>(
                        member.class,
                        R.layout.activity_row,
                        ViewHolder.class,
                        reference
                ) {
                    @Override
                    protected void populateViewHolder(ViewHolder viewHolder, member member, int i) {
                        viewHolder.setVideo(getApplication(), member.getTitle(), member.getUrl());
                    }
                };
        Mrecyclerview.setAdapter(firebaseRecyclerAdapter);

//        FirebaseRecyclerAdapter<member, ViewHolder2> firebaseRecyclerAdapter2 =
//                new FirebaseRecyclerAdapter<member, ViewHolder2>(
//                        member.class,
//                        R.layout.row,
//                        ViewHolder2.class,
//                        reference1
//                ) {
//                    @Override
//                    protected void populateViewHolder(ViewHolder2 viewHolder2, member member, int i) {
//                        viewHolder2.setVideo1(getApplication(), member.getTitle(), member.getUrl());
//                    }
//                };
//        Mrecyclerview2.setAdapter(firebaseRecyclerAdapter2);

    }




}

