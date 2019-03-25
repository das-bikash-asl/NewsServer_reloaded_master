package com.dasbikash.news_server.old_app.this_data.parent_feature_check_entry;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.dasbikash.news_server.old_app.database.NewsServerDBSchema;
import com.dasbikash.news_server.old_app.this_utility.NewsServerUtility;

import java.util.ArrayList;

public abstract class ParentFeatureCheckEntryHelper {

    private static final String TAG = "StackTrace";

    public static ArrayList<ParentFeatureCheckEntry> getParentFeatureCheckEntries(){

        ArrayList<ParentFeatureCheckEntry>
                parentFeatureCheckEntries = new ArrayList<>();

        String sqlForParentFeatureCheckEntries =
                "SELECT * FROM "+NewsServerDBSchema.ParentFeatureCheckLog.NAME+
                        " ORDER BY "+NewsServerDBSchema.ParentFeatureCheckLog.Cols.Id.NAME+" DESC;";

        SQLiteDatabase dbCon = NewsServerUtility.getDatabaseCon();

        try (Cursor cursor = dbCon.rawQuery(sqlForParentFeatureCheckEntries,null)){
            if (cursor.getCount() > 0) {
                cursor.moveToFirst();
                do {
                    parentFeatureCheckEntries.add(new ParentFeatureCheckEntryCursorWrapper(cursor).getInstance());
                    cursor.moveToNext();
                } while (!cursor.isAfterLast());
            }
        } catch (Exception ex){
            //Log.d(TAG,"ParentFeatureCheckEntryHelper: Error: "+ex.getMessage());
            ex.printStackTrace();
        }

        return parentFeatureCheckEntries;
    }
}
