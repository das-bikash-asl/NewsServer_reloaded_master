package com.dasbikash.news_server.old_app.edition_loader.daily_sun;


import com.dasbikash.news_server.old_app.edition_loader.EditionLoaderBase;
import com.dasbikash.news_server.old_app.this_data.feature.Feature;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class DailySunEditionLoader extends EditionLoaderBase {

    private static final String TAG = "StackTrace";
    //private static final String TAG = "NewAgeEditionLoader";

    private final String mSiteBaseAddress = "http://www.daily-sun.com";

    @Override
    protected String getPageLink(Feature feature, int pageNumber) {
        return super.getPageLink(feature, (pageNumber-1)*DailySunEditionParserInfo.ARTICLE_PREVIEW_COUNT_PER_PAGE);
    }

    @Override
    protected String getSiteBaseAddress() {
        return mSiteBaseAddress;
    }

    @Override
    protected String processArticleLink(String articleLink) {
        if (articleLink.matches("^\\./.+")){
            articleLink = articleLink.substring(1);
        }
        return super.processArticleLink(articleLink);
    }

    @Override
    protected String getArticlePublicationDatetimeFormat() {
        return null;
    }

    @Override
    protected Elements getPreviewBlocks() {
        //Log.d(TAG, "getPreviewBlocks: Page: "+mPageLink);
        return mEditionDocument.select(DailySunEditionParserInfo.ARTICLE_PREVIEW_BLOCK_SELECTOR);
    }

    @Override
    protected String getArticleLink(Element previewBlock) {
        return previewBlock.select(DailySunEditionParserInfo.ARTICLE_LINK_ELEMENT_SELECTOR).get(0).
                                    attr(DailySunEditionParserInfo.ARTICLE_LINK_TEXT_SELECTOR_TAG);
    }

    @Override
    protected String getArticlePreviewImageLink(Element previewBlock) {
        return previewBlock.select(DailySunEditionParserInfo.ARTICLE_PREVIEW_IMAGE_LINK_ELEMENT_SELECTOR).get(0).
                                    attr(DailySunEditionParserInfo.ARTICLE_PREVIEW_IMAGE_LINK_TEXT_SELECTOR_TAG);
    }

    @Override
    protected String getArticleTitle(Element previewBlock) {
        String articleTitle = previewBlock.select(DailySunEditionParserInfo.ARTICLE_TITLE_ELEMENT_SELECTOR).
                                    get(0).text();
        return articleTitle;
    }

    @Override
    protected String getArticlePublicationDateString(Element previewBlock) {
        return null;
    }
}