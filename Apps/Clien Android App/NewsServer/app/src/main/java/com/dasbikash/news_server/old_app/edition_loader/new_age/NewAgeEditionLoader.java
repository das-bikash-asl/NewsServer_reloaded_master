package com.dasbikash.news_server.old_app.edition_loader.new_age;


import com.dasbikash.news_server.old_app.edition_loader.EditionLoaderBase;
import com.dasbikash.news_server.old_app.this_data.feature.Feature;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class NewAgeEditionLoader extends EditionLoaderBase {

    private static final String TAG = "StackTrace";
    //private static final String TAG = "NewAgeEditionLoader";

    private final String mSiteBaseAddress = "http://www.newagebd.net";

    @Override
    protected String getPageLink(Feature feature, int pageNumber) {
        return super.getPageLink(feature, (pageNumber-1)*NewAgeEditionParserInfo.ARTICLE_PREVIEW_COUNT_PER_PAGE);
    }

    @Override
    protected String getSiteBaseAddress() {
        return mSiteBaseAddress;
    }

    @Override
    protected String getArticlePublicationDatetimeFormat() {
        return NewAgeEditionParserInfo.ARTICLE_PUBLICATION_DATE_TIME_FORMAT;
    }

    @Override
    protected Elements getPreviewBlocks() {
        //Log.d(TAG, "getPreviewBlocks: Page: "+mPageLink);
        Elements articleBlockContainers =
                mEditionDocument.select(NewAgeEditionParserInfo.ARTICLE_PREVIEW_BLOCK_CONTAINER);
        if (articleBlockContainers.size()>0){
            Elements previewBlocks = articleBlockContainers.get(0).select(
                    NewAgeEditionParserInfo.ARTICLE_PREVIEW_BLOCK_SELECTOR
            );
            return previewBlocks;
        }
        return null;
    }

    @Override
    protected String getArticleLink(Element previewBlock) {
        return previewBlock.select(NewAgeEditionParserInfo.ARTICLE_LINK_ELEMENT_SELECTOR).get(0).
                                    attr(NewAgeEditionParserInfo.ARTICLE_LINK_TEXT_SELECTOR_TAG);
    }

    @Override
    protected String getArticlePreviewImageLink(Element previewBlock) {
        return previewBlock.select(NewAgeEditionParserInfo.ARTICLE_PREVIEW_IMAGE_LINK_ELEMENT_SELECTOR).get(0).
                                    attr(NewAgeEditionParserInfo.ARTICLE_PREVIEW_IMAGE_LINK_TEXT_SELECTOR_TAG);
    }

    @Override
    protected String getArticleTitle(Element previewBlock) {
        String articleTitle = previewBlock.select(NewAgeEditionParserInfo.ARTICLE_TITLE_ELEMENT_SELECTOR).
                                    get(0).text();
        return articleTitle;
    }

    @Override
    protected String getArticlePublicationDateString(Element previewBlock) {

        String fullDateString = previewBlock.select(
                NewAgeEditionParserInfo.ARTICLE_PUBLICATION_DATE_ELEMENT_SELECTOR).
                get(0).text();

        String dateString =
                fullDateString.replaceAll(
                        NewAgeEditionParserInfo.ARTICLE_PUBLICATION_DATE_TIME_CLEANER_REGEX,
                        NewAgeEditionParserInfo.ARTICLE_PUBLICATION_DATE_TIME_REPLACER
                );
        return dateString;
    }
}