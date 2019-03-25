package com.dasbikash.news_server.old_app.this_data.image_data;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.dasbikash.news_server.old_app.database.NewsServerDBSchema;

class ImageDataCursorWrapper extends CursorWrapper {

    private static final String TAG = "TextDataCursorWrapper";

    ImageDataCursorWrapper(Cursor cursor) {
        super(cursor);
    }

    ImageData getInstance() {

        try {

            int id = getInt(getColumnIndex(NewsServerDBSchema.ImageTable.Cols.Id.NAME));
            String link = getString(getColumnIndex(NewsServerDBSchema.ImageTable.Cols.WebLink.NAME));
            String diskLocation = getString(getColumnIndex(NewsServerDBSchema.ImageTable.Cols.DiskLocation.NAME));
            String altText = getString(getColumnIndex(NewsServerDBSchema.ImageTable.Cols.AltText.NAME));
            double sizeKB = getDouble(getColumnIndex(NewsServerDBSchema.ImageTable.Cols.SizeKB.NAME));

            if (id == 0 ||
                id == -1 ||
                link == null)   return null;

            return new ImageData(id,link,diskLocation,altText,sizeKB) ;

        } catch (Exception ex){
            //Log.d("Error:", ""+ex.getMessage());
            ex.printStackTrace();
            return null;
        }
    }
}