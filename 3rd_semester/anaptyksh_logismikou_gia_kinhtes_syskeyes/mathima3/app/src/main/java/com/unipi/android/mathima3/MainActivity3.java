package com.unipi.android.mathima3;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {
    EditText countryName, countryCapital, countryPopulation;
    // Connect with DB Step 1
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        countryName = findViewById(R.id.editTextTextPersonName3);
        countryCapital = findViewById(R.id.editTextTextPersonName4);
        countryPopulation = findViewById(R.id.editTextTextPersonName5);

        // Connect with DB Step 2
        db = openOrCreateDatabase("CountryDB.db", MODE_PRIVATE, null);
        // db.execSQL("Drop table Country");
        db.execSQL("CREATE TABLE IF NOT EXISTS Country(" +
                "CountryID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "CountryName TEXT UNIQUE NOT NULL," +
                "CountryCapital TEXT NOT NULL," +
                "CountryPopulation integer" +
                ")");
        db.execSQL("INSERT OR IGNORE INTO Country(CountryName,CountryCapital,CountryPopulation) values (" +
                "'Greece','Athens',10678632)");
        db.execSQL("INSERT OR IGNORE INTO Country(CountryName,CountryCapital,CountryPopulation) values (" +
                "'Ukraine','Kyiv',41130432)");
        db.execSQL("INSERT OR IGNORE INTO Country(CountryName,CountryCapital,CountryPopulation) values (" +
                "'Spain','Madrid',47326687)");
    }

    private void showMessage(String title, String message){
        new AlertDialog.Builder(this)
                .setTitle(title)
                .setMessage(message)
                .setCancelable(true)
                .show();
    }

    // SELECT -> rawQuery()
    public void readAll(View view) {
        // Object Cursor = ειναι data set, δεχεται απο ενα string μεχρι συνεννωση array
        Cursor cursor = db.rawQuery("SELECT * FROM Country",null);
        // StringBuilder = Κανει append και οχι νεο object όπως το String
        StringBuilder builder = new StringBuilder();
        while (cursor.moveToNext()){
            builder.append("Country name: ").append(cursor.getString(1)).append("\n");
            builder.append("Country capital: ").append(cursor.getString(2)).append("\n");
            builder.append("Country population: ").append(cursor.getInt(3)).append("\n\n");
        }
        cursor.close();
        showMessage("Countries",builder.toString());
    }

    // Insert -> execSQL()
    public void save(View view) {
        String name = countryName.getText().toString();
        String capital = countryCapital.getText().toString();
        Integer population = Integer.valueOf(countryPopulation.getText().toString());
        // First parameter = Query
        // Second parameter = Object
        db.execSQL("INSERT INTO Country(CountryName,CountryCapital,CountryPopulation) VALUES (?,?,?)",
                new Object[]{name, capital, population});
        Toast.makeText(this, "Data Saved to Database!", Toast.LENGTH_SHORT).show();
    }
}