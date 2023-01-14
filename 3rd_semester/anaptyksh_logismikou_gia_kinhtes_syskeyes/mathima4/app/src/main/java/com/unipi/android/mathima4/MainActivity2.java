package com.unipi.android.mathima4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity2 extends AppCompatActivity {
    EditText usernameField, passwordField;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        usernameField = findViewById(R.id.editTextTextPersonName2);
        passwordField = findViewById(R.id.editTextTextPersonName3);
        auth = FirebaseAuth.getInstance();
    }

    void showMessage(String title, String message){
        new AlertDialog.Builder(this).setTitle(title).setMessage(message).setCancelable(true).show();
    }

    public void signup(View view) {
        auth.createUserWithEmailAndPassword(usernameField.getText().toString(),
                passwordField.getText().toString())
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                       if(task.isSuccessful()) {
                           showMessage("Success", "User created!");
                       } else {
                           showMessage("Error", task.getException().getLocalizedMessage());
                       }
                    }
                });
    }
    public void signin(View view) {
        auth.signInWithEmailAndPassword(usernameField.getText().toString(),
                        passwordField.getText().toString())
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()) {
                            showMessage("Success", "Successful sign in!");
                        } else {
                            showMessage("Error", task.getException().getLocalizedMessage());
                        }
                    }
                });
    }
}