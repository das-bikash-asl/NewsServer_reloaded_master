package com.dasbikash.news_server.old_app.this_data.config_check_summary_entry;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.dasbikash.news_server.old_app.database.NewsServerDBSchema;

class ConfigCheckSummaryEntryCursorWrapper extends CursorWrapper {

    private static final String TAG = "StackTrace";

    ConfigCheckSummaryEntryCursorWrapper(Cursor cursor) {
        super(cursor);
    }

    ConfigCheckSummaryEntry getInstance() {

        try {
            int id = getInt(getColumnIndex(NewsServerDBSchema.ConfigIntegrityCheckReportTable.Cols.Id.NAME));
            long entryTimeStamp = getLong(getColumnIndex(NewsServerDBSchema.ConfigIntegrityCheckReportTable.Cols.EntryTs.NAME));
            String reportText = getString(getColumnIndex(NewsServerDBSchema.ConfigIntegrityCheckReportTable.Cols.ReportDetails.NAME));

            if (id<1)   return null;

            return new ConfigCheckSummaryEntry(id, entryTimeStamp,reportText) ;

        } catch (Exception ex){
            ex.printStackTrace();
            //Log.d(TAG, "ConfigCheckSummaryEntryCursorWrapper: Error: "+ex.getMessage());
            return null;
        }
    }
}
