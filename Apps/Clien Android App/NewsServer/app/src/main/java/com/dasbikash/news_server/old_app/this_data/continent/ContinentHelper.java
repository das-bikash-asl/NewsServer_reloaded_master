package com.dasbikash.news_server.old_app.this_data.continent;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.dasbikash.news_server.old_app.database.NewsServerDBSchema;
import com.dasbikash.news_server.old_app.this_data.country.Country;
import com.dasbikash.news_server.old_app.this_utility.NewsServerUtility;

import java.util.ArrayList;

public abstract class ContinentHelper {

    private static final String TAG = "ContinentHelper";

    private static ArrayList<Continent> getContinentsBySql(String sqlForContinents){

        ArrayList<Continent> continents = new ArrayList<>();

        SQLiteDatabase dbCon = NewsServerUtility.getDatabaseCon();

        try (Cursor cursor = dbCon.rawQuery(sqlForContinents,null)){
            if (cursor.getCount() == 0){
                return continents;
            }
            cursor.moveToFirst();
            do {
                continents.add(new ContinentCursorWrapper(cursor).getInstance());
                cursor.moveToNext();
            }while (!cursor.isAfterLast());
        } catch (Exception ex){
            //Log.d("Error", ""+ex.getMessage());
            ex.printStackTrace();
        }

        return continents;
    }

    public static ArrayList<Continent> getAllContinents(){

        String sqlForContinents = "SELECT * FROM "+NewsServerDBSchema.ContinentTable.NAME;

        return getContinentsBySql(sqlForContinents);
    }

    public static Continent findContinentForCountry(Country country){

        String sqlForContinent = "SELECT * FROM "+NewsServerDBSchema.ContinentTable.NAME+
                                    " WHERE "+
                                    NewsServerDBSchema.ContinentTable.Cols.Id.NAME+
                                    " = "+
                                    country.getContinentId();

        ArrayList<Continent> continents = getContinentsBySql(sqlForContinent);

        if (continents.size()==1){
            return continents.get(0);
        } else {
            return null;
        }
    }

}
