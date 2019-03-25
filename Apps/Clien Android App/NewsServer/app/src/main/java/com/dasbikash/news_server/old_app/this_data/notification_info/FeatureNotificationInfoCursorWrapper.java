package com.dasbikash.news_server.old_app.this_data.notification_info;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.dasbikash.news_server.old_app.database.NewsServerDBSchema;

import java.util.ArrayList;

import static com.dasbikash.news_server.old_app.database.NewsServerDBSchema.ITEM_ACTIVE_FLAG;

class FeatureNotificationInfoCursorWrapper extends CursorWrapper {

    //private static final String TAG = "StackTrace";
    private static final String TAG = "FeatureNotificationInfoCursorWrapper";

    FeatureNotificationInfoCursorWrapper(Cursor cursor) {
        super(cursor);
    }

    FeatureNotificationInfo getInstance() {

        try {
            int featureId = getInt(getColumnIndex(NewsServerDBSchema.NotificationInfoTable.Cols.FeatureId.NAME));
            int isActiveFlag = getInt(getColumnIndex(NewsServerDBSchema.NotificationInfoTable.Cols.IsActive.NAME));
            boolean active = (isActiveFlag == ITEM_ACTIVE_FLAG ? true:false);
            String inclusionFilter = getString(getColumnIndex(NewsServerDBSchema.NotificationInfoTable.Cols.InclusionFilter.NAME));
            String exclusionFilter = getString(getColumnIndex(NewsServerDBSchema.NotificationInfoTable.Cols.ExclusionFilter.NAME));


            ArrayList<String> inclusionFilterKeywordList = new ArrayList<>();
            ArrayList<String> exclusionFilterKeywordList = new ArrayList<>();

            for (String inclusionKeyword :
                    inclusionFilter.split
                            (NewsServerDBSchema.NOTIFICATION_FILTER_INFO_SEPERATOR)) {
                inclusionFilterKeywordList.add(inclusionKeyword);
            }

            for (String exclusionKeyword :
                    exclusionFilter.split
                            (NewsServerDBSchema.NOTIFICATION_FILTER_INFO_SEPERATOR)) {
                exclusionFilterKeywordList.add(exclusionKeyword);
            }



            if (featureId<1)   return null;


            return new FeatureNotificationInfo(featureId,active,inclusionFilterKeywordList,exclusionFilterKeywordList);

        } catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }

}
