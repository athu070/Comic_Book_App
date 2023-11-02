package com.example.comic_book;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class login extends AppCompatActivity {

    EditText Email,Pass;
    Button login;
    TextView signup;

    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Email = findViewById(R.id.EmailL);
        Pass = findViewById(R.id.PassL);
        login = findViewById(R.id.loginL);
        signup = findViewById(R.id.signup);

        mAuth = FirebaseAuth.getInstance();

        login.setOnClickListener(view ->{
            loginUser();
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(login.this,signUp.class);
                startActivity(intent);
            }
        });

    }

    private void loginUser(){
        String emaill = Email.getText().toString();
        String password = Pass.getText().toString();

        if (TextUtils.isEmpty(emaill)){
            Email.setError("Email cannot be empty");
            Email.requestFocus();
        }else if (TextUtils.isEmpty(password)){
            Pass.setError("Password cannot be empty");
            Pass.requestFocus();
        }else {
            mAuth.signInWithEmailAndPassword(emaill,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        Toast.makeText(login.this,"User Logged in successfully",Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(login.this,MainMenu.class));
                    }else {
                        Toast.makeText(login.this,"Registration error: "+task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

}