package com.dasbikash.news_server.old_app.this_data.continent;

public class Continent {

    private int mId;
    private String mName;

    Continent(int id, String name) {
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
