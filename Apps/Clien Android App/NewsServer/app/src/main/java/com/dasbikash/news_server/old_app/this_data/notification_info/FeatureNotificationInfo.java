package com.dasbikash.news_server.old_app.this_data.notification_info;

import java.util.ArrayList;

public class FeatureNotificationInfo {

    private int mFeatureId;
    private boolean mActive;
    private ArrayList<String> mInclusionFilterKeywords;
    private ArrayList<String> mExclusionFilterKeywords;

    FeatureNotificationInfo(int featureId, boolean active,
                                   ArrayList<String> inclusionFilterKeywords,
                                   ArrayList<String> exclusionFilterKeywords) {
        mFeatureId = featureId;
        mActive = active;
        mInclusionFilterKeywords = inclusionFilterKeywords;
        mExclusionFilterKeywords = exclusionFilterKeywords;
    }

    public int getFeatureId() {
        return mFeatureId;
    }

    public boolean isActive() {
        return mActive;
    }

    public ArrayList<String> getInclusionFilterKeywords() {
        return mInclusionFilterKeywords;
    }

    public ArrayList<String> getExclusionFilterKeywords() {
        return mExclusionFilterKeywords;
    }
}
