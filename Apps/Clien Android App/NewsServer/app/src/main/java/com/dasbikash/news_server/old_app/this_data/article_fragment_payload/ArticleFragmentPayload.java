package com.dasbikash.news_server.old_app.this_data.article_fragment_payload;

public class ArticleFragmentPayload {

    private Integer mTextDataId;
    private Integer mImageDataId;

    ArticleFragmentPayload(Integer textDataId, Integer imageDataId) {
        mTextDataId = textDataId;
        mImageDataId = imageDataId;
    }

    public Integer getTextDataId() {
        return mTextDataId;
    }

    public Integer getImageDataId() {
        return mImageDataId;
    }

    public void setImageDataId(Integer imageDataId) {
        mImageDataId = imageDataId;
    }
}
