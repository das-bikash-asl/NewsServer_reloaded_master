package com.dasbikash.news_server.old_app.this_data.article_fragment;

import com.dasbikash.news_server.old_app.this_data.image_data.ImageData;
import com.dasbikash.news_server.old_app.this_data.text_data.TextData;
import com.dasbikash.news_server.old_app.this_data.article.Article;

@SuppressWarnings({"CanBeFinal", "unused"})
public final class ArticleFragment {

    private TextData mTextData;
    private ImageData mImageData;
    private Article mArticle;
    private int mArticleFragmentId;

    ArticleFragment(int articleFragmentId, Article article, TextData textData,ImageData imageData) {
        mTextData = textData;
        mImageData = imageData;
        mArticle = article;
        mArticleFragmentId = articleFragmentId;
    }

    public TextData getTextData() {
        return mTextData;
    }

    public ImageData getImageData() {
        return mImageData;
    }

    @SuppressWarnings("unused")
    public Article getArticle() {
        return mArticle;
    }

    public int getArticleFragmentId() {
        return mArticleFragmentId;
    }
}
