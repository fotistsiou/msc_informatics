package com.unipi.android.mppl21079_exercise2;

import androidx.appcompat.app.AppCompatActivity;
import android.app.AlertDialog;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    EditText countryName, countryCapital, countryPopulation;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        countryName = findViewById(R.id.editTextTextPersonName);
        countryCapital = findViewById(R.id.editTextTextPersonName2);
        countryPopulation = findViewById(R.id.editTextTextPersonName3);
        db = openOrCreateDatabase("CountryDB", MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS Country(" +
                "CountryId INTEGER PRIMARY KEY AUTOINCREMENT," +
                "CountryName TEXT UNIQUE NOT NULL," +
                "CountryCapital TEXT UNIQUE NOT NULL," +
                "CountryPopulation INTEGER NOT NULL" +
                ")");
    }

    /* Show Message method */
    private void showMessage(String title, String message) {
        new  AlertDialog.Builder(this)
                .setTitle(title)
                .setMessage(message)
                .setCancelable(true)
                .show();
    }

    /* Clear EditText Fields */
    private void clearFields() {
        countryName.getText().clear();
        countryCapital.getText().clear();
        countryPopulation.getText().clear();
    }

    /* Save Method */
    public void save(View view) {
        String name = countryName.getText().toString();
        String capital = countryCapital.getText().toString();
        Integer population = Integer.valueOf(countryPopulation.getText().toString());
        db.execSQL("INSERT INTO Country(CountryName, CountryCapital, CountryPopulation) VALUES (?, ?, ?)",
                   new Object[]{name, capital, population});
        Toast.makeText(this, "Congrats! Country saved.", Toast.LENGTH_SHORT).show();
        clearFields();
    }

    /* Read All Method*/
    public void readAll(View view) {
        Cursor cursor = db.rawQuery("SELECT * FROM Country", null);
        StringBuilder builder = new StringBuilder();
        while (cursor.moveToNext()) {
            builder.append("Country Name: ").append(cursor.getString(1)).append("\n");
            builder.append("Country Capital: ").append(cursor.getString(2)).append("\n");
            builder.append("Country Population: ").append(cursor.getInt(3)).append("\n\n");
        }
        cursor.close();
        showMessage("Countries", builder.toString());
    }

    /* Search Method */
    public void search(View view) {
        if (!countryName.getText().toString().isEmpty()) {
            int flag = 0;
            String name = countryName.getText().toString();
            Cursor cursor = db.rawQuery("SELECT * FROM Country", null);
            StringBuilder builder = new StringBuilder();
            while (cursor.moveToNext()) {
                if (Objects.equals(cursor.getString(1), name)) {
                    flag = 1;
                    builder.append("The country '").append(cursor.getString(1)).append("' was found!\n");
                    builder.append("Has ").append(cursor.getString(2)).append(" as its capital.\n");
                    builder.append("Its population is ").append(cursor.getInt(3)).append(".");
                    showMessage("Search A Country", builder.toString());
                    break;
                }
            }
            cursor.close();
            if (flag == 0) {
                showMessage("Search A Country", name + " was not found in the list.");
            }
            clearFields();
        } else {
            showMessage("Search A Country", "Please, fill country name.");
        }
    }

    /* Edit Method */
    public void edit(View view) {
        if (!countryName.getText().toString().isEmpty() && !countryCapital.getText().toString().isEmpty() && !countryPopulation.getText().toString().isEmpty()) {
            int flag = 0;
            String name = countryName.getText().toString();
            String capital = countryCapital.getText().toString();
            Integer population = Integer.valueOf(countryPopulation.getText().toString());
            Cursor cursor = db.rawQuery("SELECT * FROM Country", null);
            while (cursor.moveToNext()) {
                if (Objects.equals(cursor.getString(1), name)) {
                    flag = 1;
                    String id = cursor.getString(0);
                    ContentValues cv = new ContentValues();
                    cv.put("CountryName",name);
                    cv.put("CountryCapital",capital);
                    cv.put("CountryPopulation",population);
                    db.update("Country", cv, "CountryId = ?", new String[]{id});
                    showMessage("Edit A Country",name + " was updated! Congrats!");
                }
            }
            cursor.close();
            if (flag == 0) {
                showMessage("Edit A Country", name + " was not found in the list.");
            }
            clearFields();
        } else {
            showMessage("Edit A Country", "Please, Fill all fields.");
        }
    }

    /* Delete Method */
    public void delete(View view) {
        if (!countryName.getText().toString().isEmpty()) {
            int flag = 0;
            String name = countryName.getText().toString();
            Cursor cursor = db.rawQuery("SELECT * FROM Country", null);
            while (cursor.moveToNext()) {
                if (Objects.equals(cursor.getString(1), name)) {
                    flag = 1;
                    String id = cursor.getString(0);
                    db.delete("Country", "CountryId = ?", new String[]{id});
                    showMessage("Delete A Country",name + " was deleted! Congrats!");
                }
            }
            cursor.close();
            if (flag == 0) {
                showMessage("Delete A Country", name + " was not found in the list.");
            }
            clearFields();
        } else {
            showMessage("Delete A Country", "Please, fill country name.");
        }
    }
}