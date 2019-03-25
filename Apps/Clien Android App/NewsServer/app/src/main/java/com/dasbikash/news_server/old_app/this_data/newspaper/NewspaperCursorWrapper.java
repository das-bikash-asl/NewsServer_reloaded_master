package com.dasbikash.news_server.old_app.this_data.newspaper;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.dasbikash.news_server.old_app.database.NewsServerDBSchema;

import static com.dasbikash.news_server.old_app.database.NewsServerDBSchema.ITEM_ACTIVE_FLAG;

class NewspaperCursorWrapper extends CursorWrapper {

    private static final String TAG = "NewspaperCursorWrapper";
    //private static final String TAG = "StackTrace";

    NewspaperCursorWrapper(Cursor cursor) {
        super(cursor);
    }

    Newspaper getInstance() {

        try {

            int id = getInt(getColumnIndex(NewsServerDBSchema.NewsPaperTable.Cols.Id.NAME));
            String name = getString(getColumnIndex(NewsServerDBSchema.NewsPaperTable.Cols.Name.NAME));
            String countryName = getString(getColumnIndex(NewsServerDBSchema.NewsPaperTable.Cols.CountryName.NAME));
            int languageId = getInt(getColumnIndex(NewsServerDBSchema.NewsPaperTable.Cols.LanguageId.NAME));
            int isActiveFlag = getInt(getColumnIndex(NewsServerDBSchema.NewsPaperTable.Cols.IsActive.NAME));
            boolean active = (isActiveFlag == ITEM_ACTIVE_FLAG ? true:false);



            if (id<1 ||
                languageId<1 ||
                name.trim().length()<1||
                countryName.trim().length()<1)   return null;

            return new Newspaper(id,name,countryName,languageId,active) ;

        } catch (Exception ex){
            //Log.d("Error:", ""+ex.getMessage());
            ex.printStackTrace();
            return null;
        }
    }
}
