package com.dasbikash.news_server.old_app.this_data.newspaper;

import java.io.Serializable;

public class Newspaper implements Serializable{
    private int mId;
    private String mName;
    private String mCountryName;
    private int mLanguageId;
    private boolean mActive;

    Newspaper(int id, String name, String countryName, int languageId, boolean active) {
        mId = id;
        mName = name;
        mCountryName = countryName;
        mLanguageId = languageId;
        mActive = active;
    }

    public int getId() {
        return mId;
    }

    public String getName() {
        return mName;
    }

    public String getCountryName() {
        return mCountryName;
    }

    public int getLanguageId() {
        return mLanguageId;
    }

    public boolean isActive() {
        return mActive;
    }
}
