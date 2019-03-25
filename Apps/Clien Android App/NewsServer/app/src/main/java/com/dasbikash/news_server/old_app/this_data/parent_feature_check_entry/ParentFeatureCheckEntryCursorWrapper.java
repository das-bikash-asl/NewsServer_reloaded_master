package com.dasbikash.news_server.old_app.this_data.parent_feature_check_entry;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.dasbikash.news_server.old_app.database.NewsServerDBSchema;

class ParentFeatureCheckEntryCursorWrapper extends CursorWrapper {

    private static final String TAG = "StackTrace";

    ParentFeatureCheckEntryCursorWrapper(Cursor cursor) {
        super(cursor);
    }

    ParentFeatureCheckEntry getInstance() {

        try {
            int id = getInt(getColumnIndex(NewsServerDBSchema.ParentFeatureCheckLog.Cols.Id.NAME));
            long entryTimeStamp = getLong(getColumnIndex(NewsServerDBSchema.ParentFeatureCheckLog.Cols.EntryTs.NAME));
            int parentFeatureId = getInt(getColumnIndex(NewsServerDBSchema.ParentFeatureCheckLog.Cols.ParentFeatureId.NAME));
            int checkedFeatureId = getInt(getColumnIndex(NewsServerDBSchema.ParentFeatureCheckLog.Cols.CheckedFeatureId.NAME));
            boolean checkStatus =
                    getInt(getColumnIndex(NewsServerDBSchema.ParentFeatureCheckLog.Cols.CheckStatus.NAME)) ==
                            NewsServerDBSchema.POSITIVE_STATUS;


            if (id<1)   return null;

            return new ParentFeatureCheckEntry(id, entryTimeStamp,parentFeatureId,checkedFeatureId,checkStatus) ;

        } catch (Exception ex){
            ex.printStackTrace();
            //Log.d(TAG, "ConfigCheckSummaryEntryCursorWrapper: Error: "+ex.getMessage());
            return null;
        }
    }
}
