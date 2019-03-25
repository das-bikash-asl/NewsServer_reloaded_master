package com.dasbikash.news_server.old_app.this_data.language;

public class Language {
    private int mId;
    private String mName;

    Language(int id, String name) {
        mId = id;
        mName = name;
    }

    public int getId() {
        return mId;
    }

    public String getName() {
        return mName;
    }
}
