package com.dasbikash.news_server.old_app.this_data.text_data;

@SuppressWarnings({"unused", "CanBeFinal"})
public final class TextData {

    private int mId;
    private String mContent;

    TextData(int id, String content) {
        mId = id;
        mContent = content;
    }

    public int getId() {
        return mId;
    }

    public String getContent() {
        return mContent;
    }

}
