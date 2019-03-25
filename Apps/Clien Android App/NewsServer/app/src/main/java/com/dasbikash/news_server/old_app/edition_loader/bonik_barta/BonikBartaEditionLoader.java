package com.dasbikash.news_server.old_app.edition_loader.bonik_barta;


import com.dasbikash.news_server.old_app.edition_loader.EditionLoaderBase;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class BonikBartaEditionLoader extends EditionLoaderBase {

    //private static final String TAG = "StackTrace";
    private static final String TAG = "BBEdLoader";

    private final String mSiteBaseAddress = "http://bonikbarta.net";

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
        return mEditionDocument.select(BonikBartaEditionParserInfo.ARTICLE_PREVIEW_BLOCK_SELECTOR);
    }

    @Override
    protected String getArticleLink(Element previewBlock) {
        return previewBlock.select(BonikBartaEditionParserInfo.ARTICLE_LINK_ELEMENT_SELECTOR).get(0).
                                    attr(BonikBartaEditionParserInfo.ARTICLE_LINK_TEXT_SELECTOR_TAG);
    }

    @Override
    protected String getArticlePreviewImageLink(Element previewBlock) {
        return previewBlock.select(BonikBartaEditionParserInfo.ARTICLE_PREVIEW_IMAGE_LINK_ELEMENT_SELECTOR).get(0).
                                    attr(BonikBartaEditionParserInfo.ARTICLE_PREVIEW_IMAGE_LINK_TEXT_SELECTOR_TAG);
    }

    @Override
    protected String getArticleTitle(Element previewBlock) {
        return previewBlock.select(BonikBartaEditionParserInfo.ARTICLE_TITLE_ELEMENT_SELECTOR).
                                    get(0).text();
    }

    @Override
    protected String getArticlePublicationDateString(Element previewBlock) {
        return null;
    }

    @Override
    protected String processArticlePreviewImageLink(String previewImageLink) {
        return super.processArticlePreviewImageLink(previewImageLink.replace("https","http"));
    }

    @Override
    protected String processArticleLink(String articleLink) {
        return super.processArticleLink(articleLink.replace("https","http"));
    }

}