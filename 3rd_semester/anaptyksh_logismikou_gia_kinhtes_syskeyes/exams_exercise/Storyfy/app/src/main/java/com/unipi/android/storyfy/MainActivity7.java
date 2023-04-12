package com.unipi.android.storyfy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.File;
import java.io.IOException;

public class MainActivity7 extends AppCompatActivity {
    ImageView imageView;
    StorageReference storageReference;

    TextView outputStoryText, outputMoralText;
    FirebaseDatabase database;
    DatabaseReference reference, reference2;

    MyTTS myTTS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);

        imageView = findViewById(R.id.imageView10);
        storageReference = FirebaseStorage.getInstance().getReference();
        StorageReference image = storageReference.child("story_image_5.png");
        try {
            File localFile = File.createTempFile("tempImage", "png");
            image.getFile(localFile).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
                    imageView.setImageBitmap(BitmapFactory.decodeFile(localFile.getAbsolutePath()));
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

        outputStoryText = findViewById(R.id.textView20);
        outputMoralText = findViewById(R.id.textView36);
        outputStoryText.setMovementMethod(new ScrollingMovementMethod());
        outputMoralText.setMovementMethod(new ScrollingMovementMethod());
        database = FirebaseDatabase.getInstance();
        reference = database.getReference("story5/text");
        reference2 = database.getReference("story5/moral");
        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                outputStoryText.setText(snapshot.getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                outputStoryText.setText(error.getMessage());
            }
        });
        reference2.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                outputMoralText.setText(snapshot.getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                outputMoralText.setText(error.getMessage());
            }
        });

        myTTS = new MyTTS(this);
    }

    public void listen5(View view) {
        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                myTTS.speak(snapshot.getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                outputStoryText.setText(error.getMessage());
            }
        });
    }
}