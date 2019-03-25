package com.dasbikash.news_server.old_app.edition_loader.bd_pratidin;


import com.dasbikash.news_server.old_app.database.NewsServerDBSchema;
import com.dasbikash.news_server.old_app.edition_loader.EditionLoaderBase;
import com.dasbikash.news_server.old_app.this_data.feature.Feature;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class BdPratidinEditionLoader extends EditionLoaderBase {

    //private static final String TAG = "StackTrace";
    private static final String TAG = "BdPEdLoader";

    private final String mSiteBaseAddress = "http://www.bd-pratidin.com";
    private static final int MAX_RERUN_COUNT_FOR_EMPTY_WITH_REPEAT_FOR_REGULAR_FEATURE = 3;

    @Override
    protected int getMaxReRunCountOnEmptyWithRepeat() {
        return MAX_RERUN_COUNT_FOR_EMPTY_WITH_REPEAT_FOR_REGULAR_FEATURE;
    }
    @Override
    protected String getSiteBaseAddress() {
        return mSiteBaseAddress;
    }

    @Override
    protected String getPageLink(Feature feature, int pageNumber) {
        if (pageNumber == 1){
            return feature.getLinkFormat().
                    replace("/"+NewsServerDBSchema.DEFAULT_LINK_TRAILING_FORMAT,"");
        }else{
            return super.getPageLink(feature,(pageNumber-1)*12);
        }
    }

    @Override
    protected String getArticlePublicationDatetimeFormat() {
        return null;
    }

    @Override
    protected Elements getPreviewBlocks() {
        return mEditionDocument.select(BdPratidinEditionParserInfo.ARTICLE_PREVIEW_BLOCK_SELECTOR);
    }

    @Override
    protected String getArticleLink(Element previewBlock) {
        return previewBlock.select(BdPratidinEditionParserInfo.ARTICLE_LINK_ELEMENT_SELECTOR).
                                    get(0).attr(BdPratidinEditionParserInfo.ARTICLE_LINK_TEXT_SELECTOR_TAG);
    }

    @Override
    protected String getArticlePreviewImageLink(Element previewBlock) {
        return previewBlock.select(BdPratidinEditionParserInfo.ARTICLE_PREVIEW_IMAGE_LINK_ELEMENT_SELECTOR).
                                    get(0).attr(BdPratidinEditionParserInfo.ARTICLE_PREVIEW_IMAGE_LINK_TEXT_SELECTOR_TAG);
    }

    @Override
    protected String getArticleTitle(Element previewBlock) {
        return previewBlock.select(BdPratidinEditionParserInfo.ARTICLE_TITLE_ELEMENT_SELECTOR).
                                    get(0).text();
    }

    @Override
    protected String getArticlePublicationDateString(Element previewBlock) {
        return null;
    }

    @Override
    protected String processArticleLink(String articleLink) {
        if ((!articleLink.matches("^http.+")) && (!articleLink.matches("^/.+"))){
            articleLink = "/"+articleLink;
        }
        return super.processArticleLink(articleLink);
    }

    @Override
    protected String processArticlePreviewImageLink(String previewImageLink) {
        if (previewImageLink.matches("^\\./.+")){
            previewImageLink = previewImageLink.substring(1);
        }
        return super.processArticlePreviewImageLink(previewImageLink);
    }
}