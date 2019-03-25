package com.dasbikash.news_server.old_app.this_data.feature_group;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.dasbikash.news_server.old_app.database.NewsServerDBSchema;

import static com.dasbikash.news_server.old_app.database.NewsServerDBSchema.ITEM_ACTIVE_FLAG;

public class FeatureGroupCursorWrapper extends CursorWrapper {

    private static final String TAG = "FeatureGroupCursorWrapper";

    FeatureGroupCursorWrapper(Cursor cursor) {
        super(cursor);
    }

    FeatureGroup getInstance() {

        try {

            int id = getInt(getColumnIndex(NewsServerDBSchema.FeatureGroupTable.Cols.Id.NAME));
            int categoryIdentifier = getInt(getColumnIndex(NewsServerDBSchema.FeatureGroupTable.Cols.GroupCategoryidentifier.NAME));
            String title = getString(getColumnIndex(NewsServerDBSchema.FeatureGroupTable.Cols.Title.NAME));
            int isActiveFlag = getInt(getColumnIndex(NewsServerDBSchema.FeatureGroupTable.Cols.IsActive.NAME));
            boolean active = (isActiveFlag == ITEM_ACTIVE_FLAG ? true:false);

            if (id<1||
                title.trim().length()<1 )   return null;

            return new FeatureGroup(id,title,categoryIdentifier,active) ;

        } catch (Exception ex){
            //Log.d("Error", ""+ex.getMessage());
            ex.printStackTrace();
            return null;
        }
    }
}
