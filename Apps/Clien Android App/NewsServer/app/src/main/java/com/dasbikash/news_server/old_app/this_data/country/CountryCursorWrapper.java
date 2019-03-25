package com.dasbikash.news_server.old_app.this_data.country;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.dasbikash.news_server.old_app.database.NewsServerDBSchema;

class CountryCursorWrapper extends CursorWrapper {

    private static final String TAG = "CountryCursorWrapper";

    CountryCursorWrapper(Cursor cursor) {
        super(cursor);
    }

    Country getInstance() {

        try {

            String name = getString(getColumnIndex(NewsServerDBSchema.CountryTable.Cols.Name.NAME));
            String countryCode = getString(getColumnIndex(NewsServerDBSchema.CountryTable.Cols.CodeName.NAME));
            int continentId = getInt(getColumnIndex(NewsServerDBSchema.CountryTable.Cols.ContinentId.NAME));
            String timeZoneId = getString(getColumnIndex(NewsServerDBSchema.CountryTable.Cols.TimeZoneId.NAME));

            if (continentId<1||
                name.trim().length()<1||
                timeZoneId.trim().length()<1 )   return null;

            return new Country(name,countryCode,continentId,timeZoneId) ;

        } catch (Exception ex){
            //Log.d("Error", ""+ex.getMessage());
            ex.printStackTrace();
            return null;
        }
    }
}
