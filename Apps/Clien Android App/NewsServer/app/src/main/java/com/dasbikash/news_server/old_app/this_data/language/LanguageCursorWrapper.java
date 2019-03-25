package com.dasbikash.news_server.old_app.this_data.language;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.dasbikash.news_server.old_app.database.NewsServerDBSchema;

class LanguageCursorWrapper extends CursorWrapper {

    private static final String TAG = "LanguageCursorWrapper";

    LanguageCursorWrapper(Cursor cursor) {
        super(cursor);
    }

    Language getInstance() {

        try {

            int id = getInt(getColumnIndex(NewsServerDBSchema.LanguageTable.Cols.Id.NAME));
            String name = getString(getColumnIndex(NewsServerDBSchema.LanguageTable.Cols.Name.NAME));

            if (id<1||
                name.trim().length()<1)   return null;

            return new Language(id,name) ;

        } catch (Exception ex){
            //Log.d("Error", ""+ex.getMessage());
            ex.printStackTrace();
            return null;
        }
    }
}
