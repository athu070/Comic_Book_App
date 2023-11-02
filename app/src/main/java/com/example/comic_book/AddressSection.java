package com.example.comic_book;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.razorpay.Checkout;
import com.razorpay.PaymentResultListener;

import org.json.JSONException;
import org.json.JSONObject;

public class AddressSection extends AppCompatActivity implements PaymentResultListener {

    Button paybtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address_section);

        paybtn = findViewById(R.id.pay);

        paybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                pay();

            }
        });


    }

    private void pay() {
        Checkout co = new Checkout();

        JSONObject object = new JSONObject();

        try {
            object.put("name","Atharva Sonawane");
            object.put("description","Best platform for Comic Books");
            object.put("image","https://firebasestorage.googleapis.com/v0/b/cocomo-90e12.appspot.com/o/IMG-20230129-WA0031.jpg?alt=media&token=9aa0fd52-0f06-4ae2-bcd8-22ddea9775ab");
            object.put("amount","30000");

            JSONObject prefill = new JSONObject();
            prefill.put("contact","9028447785");
            prefill.put("email","athu070@protonmail.com");
            object.put("prefill", prefill);

            co.open(AddressSection.this,object);

        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onPaymentSuccess(String s) {
        Toast.makeText(this, "Payment Success", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPaymentError(int i, String s) {
        Toast.makeText(this, "Something went wrong", Toast.LENGTH_SHORT).show();
    }
}