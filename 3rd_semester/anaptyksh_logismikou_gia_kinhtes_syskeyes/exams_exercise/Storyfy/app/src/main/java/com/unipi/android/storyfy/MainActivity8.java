package com.unipi.android.storyfy;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;
import java.util.Arrays;
import java.util.Collections;

public class MainActivity8 extends AppCompatActivity {
    // Get strings from strings.xml | Step 1
    String story_label, views_label, story_title_1, story_title_2, story_title_3, story_title_4, story_title_5;

    // Display statistics | Step 1
    TextView statistics, favorites;
    String current_email;
    SQLiteDatabase db;

    // Display favorite stories | Step 1
    SortingViews[] sortingViews = new SortingViews[5];
    String favorite_stories;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main8);

        // Get strings from strings.xml | Step 2
        story_label = getResources().getString(R.string.story_label);
        views_label = getResources().getString(R.string.views_label);
        story_title_1 = getResources().getString(R.string.story_title_1);
        story_title_2 = getResources().getString(R.string.story_title_2);
        story_title_3 = getResources().getString(R.string.story_title_3);
        story_title_4 = getResources().getString(R.string.story_title_4);
        story_title_5 = getResources().getString(R.string.story_title_5);

        // Display statistics | Step 2
        statistics = findViewById(R.id.textView23);
        statistics.setMovementMethod(new ScrollingMovementMethod());
        favorites = findViewById(R.id.textView24);
        favorites.setMovementMethod(new ScrollingMovementMethod());
        Intent intent = getIntent();
        current_email = intent.getStringExtra("email");
        db = openOrCreateDatabase("StatsDB.db", MODE_PRIVATE, null);
        Cursor cursor = db.rawQuery("SELECT * FROM Stats WHERE Email = ?",new String[]{ current_email });
        StringBuilder builder = new StringBuilder();
        while (cursor.moveToNext()){
            switch (cursor.getString(2)) {
                case "story1":
                    // Display statistics | Step 3
                    builder.append(story_label).append(story_title_1).append("\n");
                    builder.append(views_label).append(cursor.getInt(3)).append("\n\n");
                    // Display favorite stories | Step 2
                    sortingViews[0] = new SortingViews(story_title_1, cursor.getInt(3));
                    break;
                case "story2":
                    // Display statistics | Step 3
                    builder.append(story_label).append(story_title_2).append("\n");
                    builder.append(views_label).append(cursor.getInt(3)).append("\n\n");
                    // Display favorite stories | Step 2
                    sortingViews[1] = new SortingViews(story_title_2, cursor.getInt(3));
                    break;
                case "story3":
                    // Display statistics | Step 3
                    builder.append(story_label).append(story_title_3).append("\n");
                    builder.append(views_label).append(cursor.getInt(3)).append("\n\n");
                    // Display favorite stories | Step 2
                    sortingViews[2] = new SortingViews(story_title_3, cursor.getInt(3));
                    break;
                case "story4":
                    // Display statistics | Step 3
                    builder.append(story_label).append(story_title_4).append("\n");
                    builder.append(views_label).append(cursor.getInt(3)).append("\n\n");
                    // Display favorite stories | Step 2
                    sortingViews[3] = new SortingViews(story_title_4, cursor.getInt(3));
                    break;
                case "story5":
                    // Display statistics | Step 3
                    builder.append(story_label).append(story_title_5).append("\n");
                    builder.append(views_label).append(cursor.getInt(3)).append("\n\n");
                    // Display favorite stories | Step 2
                    sortingViews[4] = new SortingViews(story_title_5, cursor.getInt(3));
                    break;
                default:
                    break;
            }
        }
        cursor.close();

        // Display statistics | Step 3
        statistics.setText(builder.toString());

        // Display favorite stories | Step 3
        // Descending order by views
        Arrays.sort(sortingViews, Collections.reverseOrder());
        // Check if the first story of sorted list have greater than 0 views. All stories has 0 views if a user redirect to statistics page before click a story button.
        if (sortingViews[0].getViews() > 0) {
            // Insert  the first story of the array to favorite_stories
            favorite_stories = story_label + sortingViews[0].getStory() + "\n" + views_label + sortingViews[0].getViews() + "\n\n";
            // Check if exist stories with same views with first story of sorted list and add them on "favorite_stories"
            int max = sortingViews[0].getViews();
            for (int i = 1; i < 5; i++) {
                if (max == sortingViews[i].getViews()) {
                    favorite_stories += story_label + sortingViews[i].getStory() + "\n" + views_label + sortingViews[i].getViews() + "\n\n";
                }
            }
        } else {
            favorite_stories = null;
        }
        // Display favorite stories
        favorites.setText(favorite_stories);
    }
}