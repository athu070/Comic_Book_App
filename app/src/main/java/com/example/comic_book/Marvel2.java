package com.example.comic_book;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;

public class Marvel2 extends AppCompatActivity {

    Button price1,buy;
    TextView titlea,price;
    FirebaseAuth auth;

    ImageView img;
    private FirebaseFirestore firestore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marvel2);


        titlea = findViewById(R.id.name1);
        buy = findViewById(R.id.buy1);
        price = findViewById(R.id.pricebu);

        firestore = FirebaseFirestore.getInstance();
        auth = FirebaseAuth.getInstance();

        buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = price.getText().toString();
                String str1 = titlea.getText().toString();
                Intent intent = new Intent(getApplicationContext(), BuyOption.class);
                intent.putExtra("message_key", str);
                intent.putExtra("message_key1", str1);
                intent.putExtra("resId", R.drawable.a10);
                startActivity(intent);
            }
        });

    }

//    private void addedToCart() {
//
//        String saveCurrentDate, saveCurrentTime;
//        Calendar calFordate = Calendar.getInstance();
//
//        SimpleDateFormat currentDate = new SimpleDateFormat("MM dd, yyyy");
//        saveCurrentDate = currentDate.format(calFordate.getTime());
//
//        SimpleDateFormat currentTime = new SimpleDateFormat("HH:mm:ss a");
//        saveCurrentTime = currentTime.format(calFordate.getTime());
//
//        final HashMap<String, Object> cartMap = new HashMap<>();
//
//        cartMap.put("ProductName", name1.getText().toString());
//        cartMap.put("ProductPrice", price1.getText().toString());
//        cartMap.put("currentTime", saveCurrentTime);
//        cartMap.put("currentDate", saveCurrentDate);
//
//
//        firestore.collection("User")
//                .add(cartMap)
//                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
//                    @Override
//                    public void onSuccess(DocumentReference documentReference) {
//                        Toast.makeText(Marvel2.this, "Successfully added", Toast.LENGTH_SHORT).show();
//                        finish();
//                    }
//                }).addOnFailureListener(new OnFailureListener() {
//                    @Override
//                    public void onFailure(@NonNull Exception e) {
//                        Toast.makeText(Marvel2.this, "Failed", Toast.LENGTH_SHORT).show();
//
//                    }
//                });


}