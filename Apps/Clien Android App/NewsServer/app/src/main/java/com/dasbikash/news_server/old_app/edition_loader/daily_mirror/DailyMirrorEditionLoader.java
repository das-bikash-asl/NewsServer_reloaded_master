package com.dasbikash.news_server.old_app.edition_loader.daily_mirror;

import com.dasbikash.news_server.old_app.edition_loader.EditionLoaderBase;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class DailyMirrorEditionLoader extends EditionLoaderBase {

    private static final String TAG = "DMEdLoader";

    private final String mSiteBaseAddress = "https://www.mirror.co.uk";
    private static final int MAX_RERUN_COUNT_FOR_EMPTY_WITH_REPEAT_FOR_REGULAR_FEATURE = 6;

    @Override
    protected int getMaxReRunCountOnEmptyWithRepeat() {
        return MAX_RERUN_COUNT_FOR_EMPTY_WITH_REPEAT_FOR_REGULAR_FEATURE;
    }

    @Override
    protected String getArticlePublicationDatetimeFormat() {
        return null;
    }

    @Override
    protected Elements getPreviewBlocks() {
        return mEditionDocument.select(DailyMirrorEditionParserInfo.ARTICLE_PREVIEW_BLOCK_SELECTOR);
    }

    Elements mArticleLinkBlocks;
    Element mArticleLinkBlock;

    @Override
    protected String getArticleLink(Element previewBlock) {
        mArticleLinkBlocks = previewBlock.select(DailyMirrorEditionParserInfo.ARTICLE_LINK_ELEMENT_SELECTOR);
        if (mArticleLinkBlocks.size() != 1) return null;
        mArticleLinkBlock = mArticleLinkBlocks.get(0);

        return mArticleLinkBlock.attr(DailyMirrorEditionParserInfo.ARTICLE_LINK_TEXT_SELECTOR_TAG);
    }

    @Override
    protected String getArticlePreviewImageLink(Element previewBlock) {
        return previewBlock.select(DailyMirrorEditionParserInfo.ARTICLE_PREVIEW_IMAGE_LINK_ELEMENT_SELECTOR).get(0).
                                    attr(DailyMirrorEditionParserInfo.ARTICLE_PREVIEW_IMAGE_LINK_TEXT_SELECTOR_TAG);
    }

    @Override
    protected String getArticleTitle(Element previewBlock) {
        return mArticleLinkBlock.text();
    }

    @Override
    protected String getArticlePublicationDateString(Element previewBlock) {
        return null;
    }

    @Override
    protected String getSiteBaseAddress() {
        return mSiteBaseAddress;
    }
}