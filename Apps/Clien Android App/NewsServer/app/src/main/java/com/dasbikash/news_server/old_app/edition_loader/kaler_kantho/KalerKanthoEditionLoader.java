package com.dasbikash.news_server.old_app.edition_loader.kaler_kantho;


import com.dasbikash.news_server.old_app.edition_loader.EditionLoaderBase;
import com.dasbikash.news_server.old_app.this_data.feature.Feature;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class KalerKanthoEditionLoader extends EditionLoaderBase {

    //private static final String TAG = "StackTrace";
    private static final String TAG = "KKEdLoader";
    public static final int ARTICLE_PREVIEW_COUNT_PER_PAGE = 18;

    private final String mSiteBaseAddress = "http://www.kalerkantho.com";
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
        return super.getPageLink(feature,(pageNumber-1)*ARTICLE_PREVIEW_COUNT_PER_PAGE);
    }

    @Override
    protected String getArticlePublicationDatetimeFormat() {
        return null;
    }

    @Override
    protected Elements getPreviewBlocks() {
        return mEditionDocument.select(KalerKanthoEditionParserInfo.ARTICLE_PREVIEW_BLOCK_SELECTOR);
    }

    @Override
    protected String getArticleLink(Element previewBlock) {
        return previewBlock.select(KalerKanthoEditionParserInfo.ARTICLE_LINK_ELEMENT_SELECTOR).get(0).
                                    attr(KalerKanthoEditionParserInfo.ARTICLE_LINK_TEXT_SELECTOR_TAG);
    }

    @Override
    protected String getArticlePreviewImageLink(Element previewBlock) {
        return previewBlock.select(KalerKanthoEditionParserInfo.ARTICLE_PREVIEW_IMAGE_LINK_ELEMENT_SELECTOR).
                                        get(0).attr(KalerKanthoEditionParserInfo.ARTICLE_PREVIEW_IMAGE_LINK_TEXT_SELECTOR_TAG);
    }

    @Override
    protected String getArticleTitle(Element previewBlock) {
        return previewBlock.select(KalerKanthoEditionParserInfo.ARTICLE_TITLE_ELEMENT_SELECTOR).
                                    get(0).text();
    }

    @Override
    protected String getArticlePublicationDateString(Element previewBlock) {
        return null;
    }

    @Override
    protected String processArticleLink(String articleLink) {
        if (articleLink.matches("^\\./.+")){
            articleLink =  articleLink.substring(1);
        }
        return super.processArticleLink(articleLink);
    }
}