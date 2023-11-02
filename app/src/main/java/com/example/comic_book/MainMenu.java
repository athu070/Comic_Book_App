package com.example.comic_book;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager2.widget.ViewPager2;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.squareup.picasso.Picasso;

import java.util.HashMap;
import java.util.Map;

public class MainMenu extends AppCompatActivity {

    ImageView imageView1,imageView2,imageView3,imageView4,imageView6,imageView7,imageView8;
    ImageView imageView9,imageView10,imageView11,imageView12,imageView13,imageView14;
    ImageView imageView15,imageView16,imageView17;
    Button btn1,btn2,view,bk,pf;
    DatabaseReference database;
    String meassage;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        imageView15 = findViewById(R.id.imgg1);
        imageView16 = findViewById(R.id.imgg2);
        imageView17 = findViewById(R.id.imgg3);

        imageView1 = findViewById(R.id.img1);
        imageView2 = findViewById(R.id.img2);
        imageView3 = findViewById(R.id.img3);
        imageView4 = findViewById(R.id.img4);
        imageView6 = findViewById(R.id.img6);
        imageView7 = findViewById(R.id.img7);
        imageView8 = findViewById(R.id.img8);
        imageView9 = findViewById(R.id.img9);
        imageView10 = findViewById(R.id.img10);
        imageView11 = findViewById(R.id.img11);
        imageView12 = findViewById(R.id.img12);
        imageView13 = findViewById(R.id.img13);
        imageView14 = findViewById(R.id.img14);

        //Code for getting photos from Firebase

        FirebaseFirestore db = FirebaseFirestore.getInstance();
        CollectionReference collectionRef = db.collection("Marvel");
        CollectionReference collectionRef2 = db.collection("Manga");
        CollectionReference collectionRef3 = db.collection("Chacha");
        CollectionReference collectionRef4 = db.collection("Naruto");
        CollectionReference collectionRef5 = db.collection("Adver");

        collectionRef.get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                for (QueryDocumentSnapshot document : queryDocumentSnapshots){
                    String data = document.getString("img1");
                    String data1 = document.getString("img2");
                    String data2 = document.getString("img3");
                    String data3 = document.getString("img4");
                    Picasso.get().load(data).into(imageView1);
                    Picasso.get().load(data1).into(imageView2);
                    Picasso.get().load(data2).into(imageView3);
                    Picasso.get().load(data3).into(imageView4);
                }
            }
        });

        collectionRef2.get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                for (QueryDocumentSnapshot document : queryDocumentSnapshots){
                    String data1 = document.getString("img2");
                    String data2 = document.getString("img3");
                    String data3 = document.getString("img4");
                    Picasso.get().load(data1).into(imageView6);
                    Picasso.get().load(data2).into(imageView7);
                    Picasso.get().load(data3).into(imageView8);
                }
            }
        });

        collectionRef3.get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                for (QueryDocumentSnapshot document : queryDocumentSnapshots){
                    String data = document.getString("img1");
                    String data1 = document.getString("img2");
                    String data2 = document.getString("img3");
                    Picasso.get().load(data).into(imageView9);
                    Picasso.get().load(data1).into(imageView10);
                    Picasso.get().load(data2).into(imageView11);
                }
            }
        });

        collectionRef4.get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                for (QueryDocumentSnapshot document : queryDocumentSnapshots){
                    String data = document.getString("img1");
                    String data1 = document.getString("img2");
                    String data2 = document.getString("img3");
                    Picasso.get().load(data).into(imageView12);
                    Picasso.get().load(data1).into(imageView13);
                    Picasso.get().load(data2).into(imageView14);
                }
            }
        });

        collectionRef5.get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                for (QueryDocumentSnapshot document : queryDocumentSnapshots){
                    String data = document.getString("img1");
                    String data1 = document.getString("img2");
                    String data2 = document.getString("img3");
                    Picasso.get().load(data).into(imageView15);
                    Picasso.get().load(data1).into(imageView16);
                    Picasso.get().load(data2).into(imageView17);
                }
            }
        });


        imageView1 = findViewById(R.id.img1);
        imageView2 = findViewById(R.id.img2);
        btn1 = findViewById(R.id.stream1);
        bk = findViewById(R.id.bk1);

        //Code For Pdf Viewer

//        view = findViewById(R.id.view);
//
//        database = FirebaseDatabase.getInstance().getReference().child("pdf");
//        database.addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                meassage = dataSnapshot.getValue(String.class);
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//                Toast.makeText(MainMenu.this,"Error Loading PDF",Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        view.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                CharSequence options[] = new CharSequence[]{
//                        "Download",
//                        "View",
//                        "Cancel"
//                };
//                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
//                builder.setTitle("Choose One");
//                builder.setItems(options, new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int which) {
//                        if (which == 0){
//                            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(meassage));
//                            startActivity(intent);
//                        }
//                        if (which == 1) {
//                            Intent intent = new Intent(view.getContext(), BookActivity.class);
//                            intent.putExtra("url", meassage);
//                            startActivity(intent);
//                        }
//                    }
//                });
//                builder.show();
//            }
//        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainMenu.this,Streamming.class);
                startActivity(intent);
            }
        });



        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainMenu.this,Marvel1.class);
                startActivity(intent);
            }
        });

        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainMenu.this,Marvel2.class);
                startActivity(intent);
            }
        });

        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainMenu.this,Marvel3.class);
                startActivity(intent);
            }
        });

        imageView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainMenu.this,Manga1.class);
                startActivity(intent);
            }
        });

        imageView7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainMenu.this,Manga2.class);
                startActivity(intent);
            }
        });

        imageView9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainMenu.this,Chacha1.class);
                startActivity(intent);
            }
        });

        imageView10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainMenu.this,Chacha2.class);
                startActivity(intent);
            }
        });

        imageView12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainMenu.this,Naruto1.class);
                startActivity(intent);
            }
        });



        bk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainMenu.this,BookActivity.class);
                startActivity(intent);
            }
        });

        pf = findViewById(R.id.profile);

        pf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainMenu.this,Profile.class);
                startActivity(intent);
            }
        });
    }

}