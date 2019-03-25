package com.dasbikash.news_server.old_app.this_data.text_data;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.dasbikash.news_server.old_app.database.NewsServerDBSchema;

class TextDataCursorWrapper extends CursorWrapper {

    private static final String TAG = "TextDataCursorWrapper";

    TextDataCursorWrapper(Cursor cursor) {
        super(cursor);
    }

    TextData getInstance() {

        try {

            int id = getInt(getColumnIndex(NewsServerDBSchema.TextTable.Cols.Id.NAME));
            String content = getString(getColumnIndex(NewsServerDBSchema.TextTable.Cols.Content.NAME));

            if (id<1)   return null;

            return new TextData(id,content) ;

        } catch (Exception ex){
            //Log.d("Error:", ""+ex.getMessage());
            ex.printStackTrace();
            return null;
        }
    }
}
