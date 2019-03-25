package com.dasbikash.news_server.old_app.this_data.feature_group_entry;

public class FeatureGroupEntry {
    private int mId;
    private int mFeatureGroupId;
    private int mFeatureId;

    FeatureGroupEntry(int id, int featureGroupId, int featureId) {
        mId = id;
        mFeatureGroupId = featureGroupId;
        mFeatureId = featureId;
    }

    public int getId() {
        return mId;
    }

    public int getFeatureGroupId() {
        return mFeatureGroupId;
    }

    public int getFeatureId() {
        return mFeatureId;
    }
}
