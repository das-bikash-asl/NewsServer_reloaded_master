package com.dasbikash.news_server.old_app.this_data.continent;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.dasbikash.news_server.old_app.database.NewsServerDBSchema;

class ContinentCursorWrapper extends CursorWrapper {

    private static final String TAG = "ContinentCursorWrapper";

    ContinentCursorWrapper(Cursor cursor) {
        super(cursor);
    }

    Continent getInstance() {

        try {
            int id = getInt(getColumnIndex(NewsServerDBSchema.ContinentTable.Cols.Id.NAME));
            String name = getString(getColumnIndex(NewsServerDBSchema.ContinentTable.Cols.Name.NAME));

            if (id<1||
                name.trim().length()<1 )   return null;

            return new Continent(id, name) ;

        } catch (Exception ex){
            //Log.d("Error", ""+ex.getMessage());
            ex.printStackTrace();
            return null;
        }
    }
}
