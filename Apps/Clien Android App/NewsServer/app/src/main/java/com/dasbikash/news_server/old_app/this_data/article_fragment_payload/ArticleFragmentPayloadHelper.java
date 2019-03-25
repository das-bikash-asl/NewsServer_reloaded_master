package com.dasbikash.news_server.old_app.this_data.article_fragment_payload;

public abstract class ArticleFragmentPayloadHelper {

    public static ArticleFragmentPayload getInstance(Integer textDataId, Integer imageDataId){

        if (textDataId == null && imageDataId == null){
            return null;
        }
        return new ArticleFragmentPayload(textDataId,imageDataId);
    }

    public static ArticleFragmentPayload getInstanceByTextDataId(Integer textDataId){
        if (textDataId < 1){
            return null;
        }
        return getInstance(textDataId,null);
    }

    public static ArticleFragmentPayload getInstanceByImageDataId(Integer imageDataId){
        if (imageDataId == 0 || imageDataId==-1){
            return null;
        }
        return getInstance(null,imageDataId);
    }
}
