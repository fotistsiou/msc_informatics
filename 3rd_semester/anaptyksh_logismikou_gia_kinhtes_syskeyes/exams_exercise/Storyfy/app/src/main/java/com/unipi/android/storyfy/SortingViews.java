package com.unipi.android.storyfy;

import androidx.annotation.NonNull;

public class SortingViews implements Comparable<SortingViews> {
    private String story;
    private int views;

    public SortingViews(String story, int views) {
        this.story = story;
        this.views = views;
    }

    public String getStory() {
        return story;
    }

    public int getViews() {
        return views;
    }

    @Override
    public int compareTo(@NonNull SortingViews sortingViews) {
        return this.views - sortingViews.views;
    }
}
