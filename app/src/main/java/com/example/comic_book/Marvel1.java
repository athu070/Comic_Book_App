package com.example.comic_book;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.squareup.picasso.Picasso;

import java.io.ByteArrayOutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;

public class Marvel1 extends AppCompatActivity {

    Button cart1,prise;
    ImageView imageView1;
    TextView name,priceb,titlea;

    FirebaseAuth auth;
    private FirebaseFirestore firestore;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marvel1);


        name = findViewById(R.id.namet);
        prise = findViewById(R.id.prise);

        firestore = FirebaseFirestore.getInstance();
        auth = FirebaseAuth.getInstance();

        priceb = findViewById(R.id.txtview1);
        titlea = findViewById(R.id.namet);

//        cart1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                addedToCart();
//            }
//        });
        prise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = priceb.getText().toString();
                String str1 = titlea.getText().toString();
                Intent intent = new Intent(getApplicationContext(), BuyOption.class);
                intent.putExtra("message_key", str);
                intent.putExtra("message_key1", str1);
                intent.putExtra("resId", R.drawable.a9);
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
//        final HashMap<String,Object> cartMap = new HashMap<>();
//
//        cartMap.put("ProductName",name.getText().toString());
//        cartMap.put("ProductPrice",prise.getText().toString());
//        cartMap.put("currentTime",saveCurrentTime);
//        cartMap.put("currentDate",saveCurrentDate);
//
//
//
//        firestore.collection("User")
//                .add(cartMap)
//                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
//                    @Override
//                    public void onSuccess(DocumentReference documentReference) {
//                        Toast.makeText(Marvel1.this, "Successfully added", Toast.LENGTH_SHORT).show();
//                        finish();
//                    }
//                }).addOnFailureListener(new OnFailureListener() {
//                    @Override
//                    public void onFailure(@NonNull Exception e) {
//                        Toast.makeText(Marvel1.this, "Failed", Toast.LENGTH_SHORT).show();
//
//                    }
//                });


//        firestore.collection("AddToCart").document(auth.getCurrentUser().getUid())
//                .collection("CurrentUser").add(cartMap).addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
//                    @Override
//                    public void onComplete(@NonNull Task<DocumentReference> task) {
//                        Toast.makeText(Marvel1.this,"Added To Cart",Toast.LENGTH_SHORT);
//                        finish();
//                    }
//                });



}