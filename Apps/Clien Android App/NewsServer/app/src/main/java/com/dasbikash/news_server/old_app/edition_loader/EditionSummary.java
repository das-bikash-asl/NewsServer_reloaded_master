package com.dasbikash.news_server.old_app.edition_loader;

import android.annotation.SuppressLint;

import java.util.HashMap;

public final class EditionSummary {

    @SuppressWarnings("unused")
    private String mEditionURL;
    @SuppressLint("UseSparseArrays")
    private HashMap<Integer,String> mArticleLinks = new HashMap<>();
    @SuppressLint("UseSparseArrays")
    private HashMap<Integer,String> mArticleTitles = new HashMap<>();
    @SuppressLint("UseSparseArrays")
    private HashMap<Integer,String> mArticlePreviewImageLinks = new HashMap<>();
    @SuppressLint("UseSparseArrays")
    private HashMap<Integer,Long> mArticlePublicationTimeStamp = new HashMap<>();
    @SuppressLint("UseSparseArrays")
    private HashMap<Integer,Long> mArticleLastModificationTimeStamp = new HashMap<>();

    public void setEditionURL(String editionURL) {
        mEditionURL = editionURL;
    }

    public HashMap<Integer,String> getArticleLinks() {
        return mArticleLinks;
    }

    public HashMap<Integer,String> getArticleTitles() {
        return mArticleTitles;
    }

    public HashMap<Integer,String> getArticlePreviewImageLinks() {
        return mArticlePreviewImageLinks;
    }

    public HashMap<Integer, Long> getArticlePublicationTimeStamp() {
        return mArticlePublicationTimeStamp;
    }

    public HashMap<Integer, Long> getArticleLastModificationTimeStamp() {
        return mArticleLastModificationTimeStamp;
    }
}
