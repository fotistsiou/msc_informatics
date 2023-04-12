package com.unipi.android.storyfy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    String success_1, success_2, error_1, error_2;
    EditText emailSingUpField, emailSignInField, passwordSignUpField, passwordConfirmField, passwordSignInField;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        success_1 = getResources().getString(R.string.success_1);
        success_2 = getResources().getString(R.string.success_2);
        error_1 = getResources().getString(R.string.error_1);
        error_2 = getResources().getString(R.string.error_2);

        emailSingUpField = findViewById(R.id.editTextTextEmailAddress);
        emailSignInField = findViewById(R.id.editTextTextEmailAddress2);
        passwordSignUpField = findViewById(R.id.editTextTextPassword);
        passwordConfirmField = findViewById(R.id.editTextTextPassword2);
        passwordSignInField = findViewById(R.id.editTextTextPassword3);
        auth = FirebaseAuth.getInstance();
    }

    void showMessage(String title, String message) {
        new AlertDialog.Builder(this).setTitle(title).setMessage(message).setCancelable(true).show();
    }

    void clearSignUpFields() {
        emailSingUpField.getText().clear();
        passwordSignUpField.getText().clear();
        passwordConfirmField.getText().clear();
    }

    void clearSignInFields() {
        emailSignInField.getText().clear();
        passwordSignInField.getText().clear();
    }

    public void signup(View view) {
        String email = emailSingUpField.getText().toString();
        String pass = passwordSignUpField.getText().toString();
        String passConf = passwordConfirmField.getText().toString();
        if (!email.isEmpty() && !pass.isEmpty() && !passConf.isEmpty()) {
            if (pass.equals(passConf)) {
                auth.createUserWithEmailAndPassword(email,pass)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful()) {
                                    Toast.makeText(MainActivity.this, success_1, Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(MainActivity.this , MainActivity2.class);
                                    String dataToSent = emailSingUpField.getText().toString();
                                    intent.putExtra("email", dataToSent);
                                    startActivity(intent);
                                    clearSignUpFields();
                                } else {
                                    showMessage("Error", task.getException().getLocalizedMessage());
                                    clearSignUpFields();
                                }
                            }
                        });
            } else {
                showMessage("Error", error_1);
                clearSignUpFields();
            }
        } else {
            showMessage("Error", error_2);
        }
    }

    public void signin(View view) {
        String email = emailSignInField.getText().toString();
        String pass = passwordSignInField.getText().toString();
        if (!email.isEmpty() && !pass.isEmpty()) {
            auth.signInWithEmailAndPassword(email,pass)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()) {
                                Toast.makeText(MainActivity.this, success_2, Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(MainActivity.this , MainActivity2.class);
                                String dataToSent = emailSignInField.getText().toString();
                                intent.putExtra("email", dataToSent);
                                startActivity(intent);
                                clearSignInFields();
                            } else {
                                showMessage("Error", task.getException().getLocalizedMessage());
                                clearSignInFields();
                            }
                        }
                    });
        } else {
            showMessage("Error", error_2);
        }
    }
}