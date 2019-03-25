package com.dasbikash.news_server.old_app.article_loader.dawn_pak;

import com.dasbikash.news_server.old_app.article_loader.ArticleLoaderBase;

import org.jsoup.select.Elements;

public class DawnPakArticleLoader extends ArticleLoaderBase {

    private static final String TAG = "StackTrace";

    private final String mSiteBaseAddress = "https://www.dawn.com";

    @Override
    protected String getSiteBaseAddress() {
        return mSiteBaseAddress;
    }

    @Override
    protected int getReqFeaturedImageCount() {
        return DawnPakArticleParserInfo.REQUIRED_FEATURED_IMAGE_COUNT;
    }

    @Override
    protected int getReqFeaturedImageIndex() {
        return DawnPakArticleParserInfo.REQUIRED_FEATURED_IMAGE_INDEX;
    }

    @Override
    protected String getFeaturedImageCaptionSelectorAttr() {
        return DawnPakArticleParserInfo.FEATURED_IMAGE_CAPTION_SELECTOR_ATTR;
    }

    @Override
    protected String getFeaturedImageCaptionSelector() {
        return null;
    }

    @Override
    protected String getFeaturedImageLinkSelectorAttr() {
        return DawnPakArticleParserInfo.FEATURED_IMAGE_LINK_SELECTOR;
    }

    @Override
    protected String getFeaturedImageSelector() {
        return DawnPakArticleParserInfo.FEATURED_IMAGE_SELECTOR;
    }

    @Override
    protected String getArticleModificationDateString() {
        return null;
    }

    @Override
    protected String[] getArticleModificationDateStringFormats() {
        return new String[0];
    }

    @Override
    protected Elements getArticleFragmentBlocks() {
        return mDocument.select(DawnPakArticleParserInfo.ARTICLE_FRAGMENT_BLOCK_SELECTOR);
    }

    @Override
    protected String getParagraphImageSelector() {
        return DawnPakArticleParserInfo.PARAGRAPH_IMAGE_SELECTOR;
    }

    @Override
    protected String getParagraphImageLinkSelectorAttr() {
        return DawnPakArticleParserInfo.PARAGRAPH_IMAGE_LINK_SELECTOR_ATTR;
    }

    @Override
    protected String getParagraphImageCaptionSelector() {
        return DawnPakArticleParserInfo.PARAGRAPH_IMAGE_CAPTION_SELECTOR;
    }

    @Override
    protected String getParagraphImageCaptionSelectorAttr() {
        return null;
    }
}
