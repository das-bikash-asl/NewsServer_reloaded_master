package com.dasbikash.news_server.old_app.article_loader;

import android.content.Intent;


import com.dasbikash.news_server.old_app.this_data.article.Article;
import com.dasbikash.news_server.old_app.this_data.newspaper.Newspaper;
import com.dasbikash.news_server.old_app.this_utility.NewsServerUtility;
import com.dasbikash.news_server.old_app.this_utility.NetConnectivityUtility;

import java.util.ArrayList;
import java.util.List;

public class ArticleLoaderHelper {

    private static final String TAG = "ArticleLoaderBase";
    
    private static ArticleLoaderHelper sArticleLoaderHelper;

    private final List<Intent> mIntentList = new ArrayList<>();
    
    private static ArticleLoaderHelper getArticleLoaderHelper(){
        if (sArticleLoaderHelper ==null){
            sArticleLoaderHelper = new ArticleLoaderHelper();
        }
        return sArticleLoaderHelper;
    }

    public static boolean placeArticleDownloadRequestWithHighPriority(Article article, Newspaper newspaper) {

        if (!NetConnectivityUtility.isConnected() ||
                article == null ||
                newspaper == null ||
                article.getId() <1 ||
                newspaper.getId() <1 ){
            //Log.d(TAG, "placeArticleDownloadRequestWithHighPriority: false");
            return false;
        }
        //Log.d(TAG, "placeArticleDownloadRequestWithHighPriority: article: "+article.getTitle()+" newspaper: "+newspaper.getName());

        Intent intent = ArticleLoaderService.formIntent(article,newspaper);

        if (intent!=null) {
            synchronized (getArticleLoaderHelper().mIntentList) {
                getArticleLoaderHelper().mIntentList.add(0,intent);
            }
        }

        NewsServerUtility.getContext().startService(intent);

        return true;
    }

    public static boolean placeArticleDownloadRequest(Article article, Newspaper newspaper) {

        if (!NetConnectivityUtility.isConnected() ||
                article.getId() <1 ||
                newspaper.getId() <1 ){
            //Log.d(TAG, "placeArticleDownloadRequest: false");
            return false;
        }
        //Log.d(TAG, "placeArticleDownloadRequest: article: "+article.getTitle()+" newspaper: "+newspaper.getName());

        Intent intent = ArticleLoaderService.formIntent(article,newspaper);

        if (intent!=null) {
            synchronized (getArticleLoaderHelper().mIntentList) {
                getArticleLoaderHelper().mIntentList.add(intent);
            }
        }

        NewsServerUtility.getContext().startService(intent);

        return true;
    }

    public static Intent getNextIntent() {
        //Log.d(TAG, "getNextIntent: ");

        Intent intent=null;

        synchronized (getArticleLoaderHelper().mIntentList){

            if (getArticleLoaderHelper().mIntentList.size()>0){
                intent = getArticleLoaderHelper().mIntentList.get(0);
                getArticleLoaderHelper().mIntentList.remove(0);
            }
        }

        return intent;
    }

    static void removeLoaderHelper(){
        sArticleLoaderHelper=null;
    }
}
