package com.dasbikash.news_server.old_app.edition_loader.dawn_pak;

import com.dasbikash.news_server.old_app.edition_loader.EditionLoaderBase;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class DawnPakEditionLoader extends EditionLoaderBase {

    //*private static final String TAG = "StackTrace";
    private static final String TAG = "DawnEdLoader";

    private final String mSiteBaseAddress = "https://www.dawn.com";

    @Override
    protected String getSiteBaseAddress() {
        return mSiteBaseAddress;
    }

    @Override
    protected String getArticlePublicationDatetimeFormat() {
        return mFeature.getLinkVariablePartFormat();
    }

    @Override
    protected Elements getPreviewBlocks() {
        return mEditionDocument.select(DawnPakEditionParserInfo.ARTICLE_PREVIEW_BLOCK_SELECTOR);
    }

    @Override
    protected String getArticleLink(Element previewBlock) {
        return previewBlock.select(DawnPakEditionParserInfo.ARTICLE_LINK_ELEMENT_SELECTOR).get(0).
                                    attr(DawnPakEditionParserInfo.ARTICLE_LINK_TEXT_SELECTOR_TAG);
    }

    @Override
    protected String getArticlePreviewImageLink(Element previewBlock) {
        return null;
    }

    @Override
    protected String getArticleTitle(Element previewBlock) {
        return previewBlock.select(DawnPakEditionParserInfo.ARTICLE_TITLE_ELEMENT_SELECTOR).
                                    get(0).text();
    }

    @Override
    protected String getArticlePublicationDateString(Element previewBlock) {
        return mPageLink.substring(mPageLink.length()-mFeature.getLinkVariablePartFormat().length());
    }

}