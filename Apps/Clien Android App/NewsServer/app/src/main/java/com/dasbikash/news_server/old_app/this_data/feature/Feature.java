package com.dasbikash.news_server.old_app.this_data.feature;

import java.io.Serializable;

public final class Feature implements Serializable{

    private int mId;
    private int mNewsPaperId;
    private int mParentFeatureId;
    private String mTitle;
    private boolean mWeekly;
    private int mWeeklyPublicationDay;
    private String mLinkFormat;
    private String mLinkVariablePartFormat;
    private String mFirstEditionDateString;
    private boolean mActive;
    private boolean mFavourite;

    public Feature(int id, int newsPaperId, int parentFeatureId, String title, boolean weekly,
                   int weeklyPublicationDay, String linkFormat, String linkVariablePartFormat,
                   String firstEditionDateString,boolean active,boolean favourite) {
        mId = id;
        mNewsPaperId = newsPaperId;
        mParentFeatureId = parentFeatureId;
        mTitle = title;
        mWeekly = weekly;
        mWeeklyPublicationDay = weeklyPublicationDay;
        mLinkFormat = linkFormat;
        mLinkVariablePartFormat = linkVariablePartFormat;
        mFirstEditionDateString = firstEditionDateString;
        mActive = active;
        mFavourite = favourite;
    }

    public int getId() {
        return mId;
    }

    public int getNewsPaperId() {
        return mNewsPaperId;
    }

    public int getParentFeatureId() {
        return mParentFeatureId;
    }

    public String getTitle() {
        return mTitle;
    }

    public boolean isWeekly() {
        return mWeekly;
    }

    public int getWeeklyPublicationDay() {
        return mWeeklyPublicationDay;
    }

    public String getLinkFormat() {
        return mLinkFormat;
    }

    public String getLinkVariablePartFormat() {
        return mLinkVariablePartFormat;
    }

    public String getFirstEditionDateString() {
        return mFirstEditionDateString;
    }

    public boolean isActive() {
        return mActive;
    }

    public boolean isFavourite() {
        return mFavourite;
    }
}
