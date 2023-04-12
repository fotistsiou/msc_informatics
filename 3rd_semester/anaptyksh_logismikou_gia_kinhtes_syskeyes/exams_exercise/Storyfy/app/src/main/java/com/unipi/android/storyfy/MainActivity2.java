package com.unipi.android.storyfy;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {
    // Welcome message with user email | Step 1
    TextView textView1;

    // Image fetching | Step 1
    ImageView imageView1, imageView2, imageView3, imageView4, imageView5;
    StorageReference storageReference;

    // Create statistics | Step 1
    String current_email;
    int views_story_1, views_story_2, views_story_3, views_story_4, views_story_5, exist_email;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        // Welcome message with user email | Step 2
        textView1 = findViewById(R.id.textView4);
        Intent intent = getIntent();
        current_email = intent.getStringExtra("email");
        textView1.setText(textView1.getText().toString() + ", " + current_email + "!");

        // Image fetching | Step 2
        imageView1 = findViewById(R.id.imageView);
        imageView2 = findViewById(R.id.imageView2);
        imageView3 = findViewById(R.id.imageView3);
        imageView4 = findViewById(R.id.imageView4);
        imageView5 = findViewById(R.id.imageView5);
        storageReference = FirebaseStorage.getInstance().getReference();
        StorageReference image1 = storageReference.child("story_image_1.png");
        StorageReference image2 = storageReference.child("story_image_2.png");
        StorageReference image3 = storageReference.child("story_image_3.png");
        StorageReference image4 = storageReference.child("story_image_4.png");
        StorageReference image5 = storageReference.child("story_image_5.png");
        try {
            File localFile = File.createTempFile("tempImage", "png");
            image1.getFile(localFile).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
                    imageView1.setImageBitmap(BitmapFactory.decodeFile(localFile.getAbsolutePath()));
                }
            });
            image2.getFile(localFile).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
                    imageView2.setImageBitmap(BitmapFactory.decodeFile(localFile.getAbsolutePath()));
                }
            });
            image3.getFile(localFile).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
                    imageView3.setImageBitmap(BitmapFactory.decodeFile(localFile.getAbsolutePath()));
                }
            });
            image4.getFile(localFile).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
                    imageView4.setImageBitmap(BitmapFactory.decodeFile(localFile.getAbsolutePath()));
                }
            });
            image5.getFile(localFile).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
                    imageView5.setImageBitmap(BitmapFactory.decodeFile(localFile.getAbsolutePath()));
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Create statistics | Step 2
        db = openOrCreateDatabase("StatsDB.db", MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS Stats(" +
                "ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "Email TEXT," +
                "Story TEXT," +
                "Views INTEGER" +
                ")");
        Cursor cursor = db.rawQuery("SELECT * FROM Stats",null);
        while (cursor.moveToNext()) {
            if (cursor.getString(1).equals(current_email)) {
                exist_email = 1;
                switch (cursor.getString(2)) {
                    case "story1":
                        views_story_1 = cursor.getInt(3);
                        break;
                    case "story2":
                        views_story_2 = cursor.getInt(3);
                        break;
                    case "story3":
                        views_story_3 = cursor.getInt(3);
                        break;
                    case "story4":
                        views_story_4 = cursor.getInt(3);
                        break;
                    case "story5":
                        views_story_5 = cursor.getInt(3);
                        break;
                    default:
                        break;
                }
            }
        }
        if (exist_email == 0) {
            db.execSQL("INSERT OR IGNORE INTO Stats(Email,Story,Views) values (" +
                   "'" + current_email + "'" + ",'story1',0)");
            db.execSQL("INSERT OR IGNORE INTO Stats(Email,Story,Views) values (" +
                    "'" + current_email + "'" + ",'story2',0)");
            db.execSQL("INSERT OR IGNORE INTO Stats(Email,Story,Views) values (" +
                    "'" + current_email + "'" + ",'story3',0)");
            db.execSQL("INSERT OR IGNORE INTO Stats(Email,Story,Views) values (" +
                    "'" + current_email + "'" + ",'story4',0)");
            db.execSQL("INSERT OR IGNORE INTO Stats(Email,Story,Views) values (" +
                    "'" + current_email + "'" + ",'story5',0)");
        }
        cursor.close();
    }

    public void goStory1(View view) {
        // Create statistics | Step 3
        views_story_1++;
        Cursor cursor = db.rawQuery("SELECT ID FROM Stats WHERE Email = ? AND Story = 'story1'",new String[]{ current_email });
        while (cursor.moveToNext()) {
            ContentValues views = new ContentValues();
            views.put("Views", views_story_1);
            db.update("Stats", views, "ID = ?", new String[]{cursor.getString(0)});
        }
        cursor.close();

        // Go to Story 1
        startActivity(new Intent(MainActivity2.this, MainActivity3.class));
    }
    public void goStory2(View view) {
        // Create statistics | Step 3
        views_story_2++;
        Cursor cursor = db.rawQuery("SELECT ID FROM Stats WHERE Email = ? AND Story = 'story2'",new String[]{ current_email });
        while (cursor.moveToNext()) {
            ContentValues views = new ContentValues();
            views.put("Views", views_story_2);
            db.update("Stats", views, "ID = ?", new String[]{cursor.getString(0)});
        }
        cursor.close();

        // Go to Story 2
        startActivity(new Intent(MainActivity2.this, MainActivity4.class));
    }
    public void goStory3(View view) {
        // Create statistics | Step 3
        views_story_3++;
        Cursor cursor = db.rawQuery("SELECT ID FROM Stats WHERE Email = ? AND Story = 'story3'",new String[]{ current_email });
        while (cursor.moveToNext()) {
            ContentValues views = new ContentValues();
            views.put("Views", views_story_3);
            db.update("Stats", views, "ID = ?", new String[]{cursor.getString(0)});
        }
        cursor.close();

        // Go to Story 3
        startActivity(new Intent(MainActivity2.this, MainActivity5.class));
    }
    public void goStory4(View view) {
        // Create statistics | Step 3
        views_story_4++;
        Cursor cursor = db.rawQuery("SELECT ID FROM Stats WHERE Email = ? AND Story = 'story4'",new String[]{ current_email });
        while (cursor.moveToNext()) {
            ContentValues views = new ContentValues();
            views.put("Views", views_story_4);
            db.update("Stats", views, "ID = ?", new String[]{cursor.getString(0)});
        }
        cursor.close();

        // Go to Story 4
        startActivity(new Intent(MainActivity2.this, MainActivity6.class));
    }
    public void goStory5(View view) {
        // Create statistics | Step 3
        views_story_5++;
        Cursor cursor = db.rawQuery("SELECT ID FROM Stats WHERE Email = ? AND Story = 'story5'",new String[]{ current_email });
        while (cursor.moveToNext()) {
            ContentValues views = new ContentValues();
            views.put("Views", views_story_5);
            db.update("Stats", views, "ID = ?", new String[]{cursor.getString(0)});
        }
        cursor.close();

        // Go to Story 5
        startActivity(new Intent(MainActivity2.this, MainActivity7.class));
    }

    // Go to Statistics with recognize speech
    public void speech(View view) {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Please say something");
        startActivityForResult(intent, 123);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 123 && resultCode == RESULT_OK) {
            ArrayList<String> recognizeResult = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
            if (recognizeResult.contains("open")) {
                Intent intent = new Intent(MainActivity2.this , MainActivity8.class);
                String dataToSent = current_email;
                intent.putExtra("email", dataToSent);
                startActivity(intent);
            }
        }
    }

    // Go to Statistics with click
    public void goStat(View view) {
        Intent intent = new Intent(MainActivity2.this , MainActivity8.class);
        String dataToSent = current_email;
        intent.putExtra("email", dataToSent);
        startActivity(intent);
    }
}