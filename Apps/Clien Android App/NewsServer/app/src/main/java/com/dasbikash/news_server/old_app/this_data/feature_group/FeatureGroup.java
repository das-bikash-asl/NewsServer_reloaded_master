package com.dasbikash.news_server.old_app.this_data.feature_group;

import java.io.Serializable;

public class FeatureGroup implements Serializable{
    private int mId;
    private String mTitle;
    private int mCategoryIdentifier;
    private boolean mActive;

    FeatureGroup(int id, String title, int categoryIdentifier,boolean active) {
        mId = id;
        mTitle = title;
        mCategoryIdentifier = categoryIdentifier;
        mActive = active;
    }

    public int getId() {
        return mId;
    }

    public String getTitle() {
        return mTitle;
    }

    public int getCategoryIdentifier() {
        return mCategoryIdentifier;
    }

    public boolean isActive() {
        return mActive;
    }
}
