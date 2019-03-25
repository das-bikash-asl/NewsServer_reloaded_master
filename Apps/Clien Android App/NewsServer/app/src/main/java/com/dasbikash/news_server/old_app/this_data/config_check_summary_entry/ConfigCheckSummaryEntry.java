package com.dasbikash.news_server.old_app.this_data.config_check_summary_entry;

public final class ConfigCheckSummaryEntry {
    private int mId;
    private long mEntryTimeStamp;
    private String mReportText;

    ConfigCheckSummaryEntry(int id, long entryTimeStamp, String reportText) {
        mId = id;
        mEntryTimeStamp = entryTimeStamp;
        mReportText = reportText;
    }

    public int getId() {
        return mId;
    }

    public long getEntryTimeStamp() {
        return mEntryTimeStamp;
    }

    public String getReportText() {
        return mReportText;
    }
}
