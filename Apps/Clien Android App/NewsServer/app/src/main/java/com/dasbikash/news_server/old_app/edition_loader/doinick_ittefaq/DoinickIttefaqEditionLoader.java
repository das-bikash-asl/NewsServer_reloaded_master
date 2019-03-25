package com.dasbikash.news_server.old_app.edition_loader.doinick_ittefaq;

import com.dasbikash.news_server.old_app.edition_loader.EditionLoaderBase;
import com.dasbikash.news_server.old_app.this_utility.display_utility.DisplayUtility;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class DoinickIttefaqEditionLoader extends EditionLoaderBase {

    //private static final String TAG = "StackTrace";
    private static final String TAG = "DIttefaqEdLoader";

    private final String mSiteBaseAddress = "http://www.ittefaq.com.bd";

    @Override
    protected String getSiteBaseAddress() {
        return mSiteBaseAddress;
    }

    @Override
    protected String getArticlePublicationDatetimeFormat() {
        return DoinickIttefaqEditionParserInfo.ARTICLE_PUBLICATION_DATE_TIME_FORMAT;
    }

    @Override
    protected Elements getPreviewBlocks() {
        return mEditionDocument.select(DoinickIttefaqEditionParserInfo.ARTICLE_PREVIEW_BLOCK_SELECTOR);
    }
    Element mArticleLinkElement;

    @Override
    protected String getArticleLink(Element previewBlock) {

        return previewBlock.select(DoinickIttefaqEditionParserInfo.ARTICLE_LINK_ELEMENT_SELECTOR).get(0).
                attr(DoinickIttefaqEditionParserInfo.ARTICLE_LINK_TEXT_SELECTOR_TAG);
    }

    @Override
    protected String getArticlePreviewImageLink(Element previewBlock) {
        return previewBlock.select(DoinickIttefaqEditionParserInfo.ARTICLE_PREVIEW_IMAGE_LINK_ELEMENT_SELECTOR).get(0).
                attr(DoinickIttefaqEditionParserInfo.ARTICLE_PREVIEW_IMAGE_LINK_TEXT_SELECTOR_TAG);
    }

    @Override
    protected String processArticlePreviewImageLink(String previewImageLink) {
        if (!previewImageLink.matches(".+?url\\(.+?\\).+")){
            return null;
        }
        previewImageLink = (previewImageLink.split("url\\("))[1];
        previewImageLink = (previewImageLink.split("\\)"))[0];
        return super.processArticlePreviewImageLink(previewImageLink);
    }

    @Override
    protected String getArticleTitle(Element previewBlock) {

        return previewBlock.select(DoinickIttefaqEditionParserInfo.ARTICLE_TITLE_ELEMENT_SELECTOR).
                                get(0).text();
    }

    @Override
    protected String getArticlePublicationDateString(Element previewBlock) {
        String articlePublicationDateString = previewBlock.select(DoinickIttefaqEditionParserInfo.ARTICLE_PUBLICATION_DATE_ELEMENT_SELECTOR).
                                                    get(0).text();
        return DisplayUtility.banglaToEnglishDateString(articlePublicationDateString);
    }
}