package com.unipi.android.mathima5;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;

public class MainActivity4 extends AppCompatActivity {
    // Firebase Realtime Storage
    ImageView imageView;
    StorageReference storageReference;

    // Request
    TextView textView3;
    RequestQueue requestQueue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        // Firebase Realtime Storage
        imageView = findViewById(R.id.imageView);
        storageReference = FirebaseStorage.getInstance().getReference();

        // Request
        textView3 = findViewById(R.id.textView5);
        requestQueue = Volley.newRequestQueue(this);
    }

    // Firebase Realtime Storage
    public void go3(View view) {
        StorageReference image1 = storageReference.child("download.png");
        try {
            File localFile = File.createTempFile("tempImage", "png");
            image1.getFile(localFile).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
                    imageView.setImageBitmap(BitmapFactory.decodeFile(localFile.getAbsolutePath()));
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Request
    // Display the whole json text as response
    public void go5(View view){
        String url = "https://api.chucknorris.io/jokes/random";
        StringRequest stringRequest = new StringRequest(
                Request.Method.GET,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        textView3.setText(response.toString());
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        textView3.setText(error.getLocalizedMessage());
                    }
                }
        );
        requestQueue.add(stringRequest);
    }
    // Display a part of json text as response
    public void go6(View view){
        String url = "https://api.chucknorris.io/jokes/random";
        StringRequest stringRequest = new StringRequest(
                Request.Method.GET,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        textView3.setText(response.substring(0,30));
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        textView3.setText(error.getLocalizedMessage());
                    }
                }
        );
        requestQueue.add(stringRequest);
    }
    // Display a value of json text as response
    public void go7(View view){
        String url = "https://api.chucknorris.io/jokes/random";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.GET,
                url,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            String courseName = response.getString("value");
                            textView3.setText(courseName);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        textView3.setText(error.getLocalizedMessage());
                    }
                }
        );
        requestQueue.add(jsonObjectRequest);
    }
}