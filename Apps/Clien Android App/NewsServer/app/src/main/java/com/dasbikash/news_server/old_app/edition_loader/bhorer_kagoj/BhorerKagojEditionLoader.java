package com.dasbikash.news_server.old_app.edition_loader.bhorer_kagoj;


import com.dasbikash.news_server.old_app.edition_loader.EditionLoaderBase;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class BhorerKagojEditionLoader extends EditionLoaderBase {

    //private static final String TAG = "StackTrace";
    private static final String TAG = "BKEdLoader";

    private final String mSiteBaseAddress = "http://www.bhorerkagoj.com";
    @Override
    protected String getSiteBaseAddress() {
        return mSiteBaseAddress;
    }

    @Override
    protected String getArticlePublicationDatetimeFormat() {
        return null;
    }

    @Override
    protected Elements getPreviewBlocks() {
        return mEditionDocument.select(BhorerKagojEditionParserInfo.ARTICLE_PREVIEW_BLOCK_SELECTOR);
    }

    @Override
    protected String getArticleLink(Element previewBlock) {
        return previewBlock.select(BhorerKagojEditionParserInfo.ARTICLE_LINK_ELEMENT_SELECTOR).get(0).
                                    attr(BhorerKagojEditionParserInfo.ARTICLE_LINK_TEXT_SELECTOR_TAG);
    }

    @Override
    protected String getArticlePreviewImageLink(Element previewBlock) {

        String previewImageLink = previewBlock.select(BhorerKagojEditionParserInfo.ARTICLE_PREVIEW_IMAGE_LINK_ELEMENT_SELECTOR).
                                                        get(0).attr(BhorerKagojEditionParserInfo.ARTICLE_PREVIEW_IMAGE_LINK_TEXT_SELECTOR_TAG1);

        if (previewImageLink == null || previewImageLink.trim().length() == 0){
            previewImageLink = previewBlock.select(BhorerKagojEditionParserInfo.ARTICLE_PREVIEW_IMAGE_LINK_ELEMENT_SELECTOR).
                                                        get(0).attr(BhorerKagojEditionParserInfo.ARTICLE_PREVIEW_IMAGE_LINK_TEXT_SELECTOR_TAG2);
        }

        return previewImageLink;
    }

    @Override
    protected String getArticleTitle(Element previewBlock) {
        return previewBlock.select(BhorerKagojEditionParserInfo.ARTICLE_TITLE_ELEMENT_SELECTOR).
                                        get(0).text();
    }

    @Override
    protected String getArticlePublicationDateString(Element previewBlock) {
        return null;
    }

    @Override
    protected String processArticleLink(String articleLink) {
        if (articleLink.matches("^\\./.+")){
            articleLink= articleLink.substring(1);
        }
        return super.processArticleLink(articleLink);
    }

}