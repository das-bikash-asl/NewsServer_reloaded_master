package com.dasbikash.news_server.old_app.this_data.language;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.dasbikash.news_server.old_app.database.NewsServerDBSchema;
import com.dasbikash.news_server.old_app.this_data.newspaper.Newspaper;
import com.dasbikash.news_server.old_app.this_utility.NewsServerUtility;

import java.util.ArrayList;

public abstract class LanguageHelper {

    private static final String TAG = "LanguageHelper";

    private static ArrayList<Language> getLanguagesBySql(String sqlForLanguages){

        ArrayList<Language> languages = new ArrayList<>();

        SQLiteDatabase dbCon = NewsServerUtility.getDatabaseCon();

        try (Cursor cursor = dbCon.rawQuery(sqlForLanguages,null)){
            if (cursor.getCount() == 0){
                return languages;
            }
            cursor.moveToFirst();
            do {
                languages.add(new LanguageCursorWrapper(cursor).getInstance());
                cursor.moveToNext();
            }while (!cursor.isAfterLast());
        } catch (Exception ex){
            //Log.d("Error", ""+ex.getMessage());
            ex.printStackTrace();
        }

        return languages;
    }

    public static ArrayList<Language> getAllLanguages(){

        String sqlForLanguages = "SELECT * FROM "+NewsServerDBSchema.LanguageTable.NAME;

        return getLanguagesBySql(sqlForLanguages);
    }

    public static Language findLanguageForNewspaper(Newspaper newspaper){

        String sqlForLanguage = "SELECT * FROM "+NewsServerDBSchema.LanguageTable.NAME+
                                    " WHERE "+
                                    NewsServerDBSchema.LanguageTable.Cols.Id.NAME+
                                    " = "+
                                    newspaper.getLanguageId();

        ArrayList<Language> languages = getLanguagesBySql(sqlForLanguage);

        if (languages.size()==1){
            return languages.get(0);
        } else {
            return null;
        }
    }


}
