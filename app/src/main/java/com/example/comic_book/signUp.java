package com.example.comic_book;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class signUp extends AppCompatActivity {

    EditText email,pass;
    Button register;

    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        email = findViewById(R.id.EmailR);
        pass = findViewById(R.id.PassR);
        register = findViewById(R.id.RegisterR);

        mAuth = FirebaseAuth.getInstance();

        register.setOnClickListener(view ->{
            createUser();
        });


    }
    private void createUser(){
        String emaill = email.getText().toString();
        String password = pass.getText().toString();

        if (TextUtils.isEmpty(emaill)){
            email.setError("Email cannot be empty");
            email.requestFocus();
        }else if (TextUtils.isEmpty(password)){
            pass.setError("Password cannot be empty");
            pass.requestFocus();
        }else {
            mAuth.createUserWithEmailAndPassword(emaill,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isComplete()){
                        Toast.makeText(signUp.this,"User Registered successfully",Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(signUp.this,login.class));
                    }else {
                        Toast.makeText(signUp.this,"Registration error: "+task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}