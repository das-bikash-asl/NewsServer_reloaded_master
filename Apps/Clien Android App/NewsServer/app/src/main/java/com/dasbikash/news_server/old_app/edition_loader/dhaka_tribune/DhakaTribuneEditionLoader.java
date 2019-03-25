package com.dasbikash.news_server.old_app.edition_loader.dhaka_tribune;

import com.dasbikash.news_server.old_app.edition_loader.EditionLoaderBase;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class DhakaTribuneEditionLoader extends EditionLoaderBase {

    //private static final String TAG = "StackTrace";
    private static final String TAG = "DhkTEdLoader";

    private final String mSiteBaseAddress = "https://www.dhakatribune.com";
    
    private static final int MAX_RERUN_COUNT_FOR_EMPTY_WITH_REPEAT_FOR_REGULAR_FEATURE = 6;

    @Override
    protected int getMaxReRunCountOnEmptyWithRepeat() {
        return MAX_RERUN_COUNT_FOR_EMPTY_WITH_REPEAT_FOR_REGULAR_FEATURE;
    }

    @Override
    protected String getSiteBaseAddress() {
        return mSiteBaseAddress;
    }

    @Override
    protected String getArticlePublicationDatetimeFormat() {
        return DhakaTribuneEditionParserInfo.ARTICLE_PUBLICATION_DATE_TIME_FORMAT;
    }

    @Override
    protected Elements getPreviewBlocks() {
        return mEditionDocument.select(DhakaTribuneEditionParserInfo.ARTICLE_PREVIEW_BLOCK_SELECTOR);
    }

    @Override
    protected String getArticleLink(Element previewBlock) {
        return previewBlock.select(DhakaTribuneEditionParserInfo.ARTICLE_LINK_ELEMENT_SELECTOR).get(0).
                                    attr(DhakaTribuneEditionParserInfo.ARTICLE_LINK_TEXT_SELECTOR_TAG);
    }

    @Override
    protected String getArticlePreviewImageLink(Element previewBlock) {
        return previewBlock.select(DhakaTribuneEditionParserInfo.ARTICLE_PREVIEW_IMAGE_LINK_ELEMENT_SELECTOR).get(0).
                                    attr(DhakaTribuneEditionParserInfo.ARTICLE_PREVIEW_IMAGE_LINK_TEXT_SELECTOR_TAG);
    }

    @Override
    protected String getArticleTitle(Element previewBlock) {
        return previewBlock.select(DhakaTribuneEditionParserInfo.ARTICLE_TITLE_ELEMENT_SELECTOR).
                                    get(0).text();
    }

    @Override
    protected String getArticlePublicationDateString(Element previewBlock) {
        return previewBlock.select(DhakaTribuneEditionParserInfo.ARTICLE_PUBLICATION_DATE_ELEMENT_SELECTOR).
                                    get(0).text().trim();
    }
}