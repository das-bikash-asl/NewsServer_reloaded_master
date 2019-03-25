package com.dasbikash.news_server.old_app.this_data.parent_feature_check_entry;

public final class ParentFeatureCheckEntry {
    private int mId;
    private long mEntryTimeStamp;
    private int mParentFeatureId;
    private int mCheckedFeatureId;
    private boolean mCheckStatus;

    ParentFeatureCheckEntry(int id, long entryTimeStamp, int parentFeatureId,
                            int checkedFeatureId, boolean checkStatus) {
        mId = id;
        mEntryTimeStamp = entryTimeStamp;
        mParentFeatureId = parentFeatureId;
        mCheckedFeatureId = checkedFeatureId;
        mCheckStatus = checkStatus;
    }

    public int getId() {
        return mId;
    }

    public long getEntryTimeStamp() {
        return mEntryTimeStamp;
    }

    public int getParentFeatureId() {
        return mParentFeatureId;
    }

    public int getCheckedFeatureId() {
        return mCheckedFeatureId;
    }

    public boolean isCheckStatus() {
        return mCheckStatus;
    }
}
