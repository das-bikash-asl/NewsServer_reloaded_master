package com.dasbikash.news_server.old_app.this_data.feature_group_entry;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.dasbikash.news_server.old_app.database.NewsServerDBSchema;

public class FeatureGroupEntryCursorWrapper extends CursorWrapper {

    private static final String TAG = "FeatureGroupEntryCursorWrapper";

    FeatureGroupEntryCursorWrapper(Cursor cursor) {
        super(cursor);
    }

    FeatureGroupEntry getInstance() {

        try {

            int id = getInt(getColumnIndex(NewsServerDBSchema.FeatureGroupEntryTable.Cols.Id.NAME));
            int featureGroupId = getInt(getColumnIndex(NewsServerDBSchema.FeatureGroupEntryTable.Cols.GroupId.NAME));
            int featureId = getInt(getColumnIndex(NewsServerDBSchema.FeatureGroupEntryTable.Cols.MemberFeatureId.NAME));

            if (id<1 || featureGroupId<1 || featureId<1)   return null;

            return new FeatureGroupEntry(id,featureGroupId,featureId) ;

        } catch (Exception ex){
            //Log.d("Error", ""+ex.getMessage());
            ex.printStackTrace();
            return null;
        }
    }
}
