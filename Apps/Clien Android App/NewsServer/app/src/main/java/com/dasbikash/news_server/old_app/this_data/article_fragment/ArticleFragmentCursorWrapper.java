package com.dasbikash.news_server.old_app.this_data.article_fragment;

import android.database.Cursor;
import android.database.CursorWrapper;


import com.dasbikash.news_server.old_app.database.NewsServerDBSchema;
import com.dasbikash.news_server.old_app.this_data.article.Article;
import com.dasbikash.news_server.old_app.this_data.image_data.ImageData;
import com.dasbikash.news_server.old_app.this_data.image_data.ImageDataHelper;
import com.dasbikash.news_server.old_app.this_data.text_data.TextData;
import com.dasbikash.news_server.old_app.this_data.text_data.TextDataHelper;

class ArticleFragmentCursorWrapper extends CursorWrapper {

    private static final String TAG = "ArticleFragmentCursorWrapper";

    ArticleFragmentCursorWrapper(Cursor cursor) {
        super(cursor);
    }

    ArticleFragment getInstance(Article article) {

        if (article == null) return null;

        try {

            int id = getInt(getColumnIndex(NewsServerDBSchema.ArticleFragmentTable.Cols.Id.NAME));

            int textDataId = 0;
            try {
                textDataId = getInt(getColumnIndex(NewsServerDBSchema.ArticleFragmentTable.Cols.TextId.NAME));
            } catch (Exception e) {
                e.printStackTrace();
            }

            int imageDataId = 0;
            try {
                imageDataId = getInt(getColumnIndex(NewsServerDBSchema.ArticleFragmentTable.Cols.ImageId.NAME));
            } catch (Exception e) {
                e.printStackTrace();
            }

            TextData textData = TextDataHelper.findTextDataById(textDataId);
            ImageData imageData = ImageDataHelper.findImageDataById(imageDataId);

            if (id == 0 ||
                (textData == null && imageData == null))   return null;

            return new ArticleFragment(id,article,textData,imageData) ;

        } catch (Exception ex){
            //Log.d("Error:", ""+ex.getMessage());
            ex.printStackTrace();
            return null;
        }
    }
}