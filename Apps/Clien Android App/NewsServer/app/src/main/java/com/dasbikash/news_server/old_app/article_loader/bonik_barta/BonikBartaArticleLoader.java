package com.dasbikash.news_server.old_app.article_loader.bonik_barta;

import com.dasbikash.news_server.old_app.article_loader.ArticleLoaderBase;
import com.dasbikash.news_server.old_app.this_utility.display_utility.DisplayUtility;

import org.jsoup.select.Elements;

public class BonikBartaArticleLoader extends ArticleLoaderBase {

    //private static final String TAG = "StackTrace";
    //private static final String TAG = "BBArticleLoader";

    private final String mSiteBaseAddress = "http://bonikbarta.net";

    @Override
    protected String getSiteBaseAddress() {
        return mSiteBaseAddress;
    }

    @Override
    protected String processLink(String linkText) {
        linkText = linkText.replace("https","http");
        return super.processLink(linkText);
    }

    @Override
    protected Elements getArticleFragmentBlocks() {
        return mDocument.select(BonikBartaArticleParserInfo.ARTICLE_FRAGMENT_BLOCK_SELECTOR);
    }

    @Override
    protected String getParagraphImageCaptionSelector() {
        return null;
    }

    @Override
    protected String getParagraphImageCaptionSelectorAttr() {
        return null;
    }

    @Override
    protected String getParagraphImageLinkSelectorAttr() {
        return null;
    }

    @Override
    protected String getParagraphImageSelector() {
        return null;
    }

    @Override
    protected String getArticleModificationDateString() {

        Elements dateStringElements =
                mDocument.select(BonikBartaArticleParserInfo.ARTICLE_MODIFICATION_DATE_STRING_SELECTOR);

        if (dateStringElements != null && dateStringElements.size()==1) {
            String dateString = dateStringElements.get(0).text().trim();
            dateString = dateString.replace(BonikBartaArticleParserInfo.ARTICLE_MODIFICATION_DATE_CLEANER_SELECTOR,
                    BonikBartaArticleParserInfo.ARTICLE_MODIFICATION_DATE_CLEANER_REPLACEMENT).trim();
            dateString = DisplayUtility.banglaToEnglishDateString(dateString);
            return dateString;
        }
        return null;
    }

    @Override
    protected String[] getArticleModificationDateStringFormats() {
        return new String[]{BonikBartaArticleParserInfo.ARTICLE_MODIFICATION_DATE_STRING_FORMATS};
    }

    @Override
    protected String getFeaturedImageCaptionSelectorAttr() {
        return BonikBartaArticleParserInfo.FEATURED_IMAGE_CAPTION_SELECTOR_ATTR;
    }

    @Override
    protected String getFeaturedImageCaptionSelector() {
        return null;
    }

    @Override
    protected String getFeaturedImageLinkSelectorAttr() {
        return BonikBartaArticleParserInfo.FEATURED_IMAGE_LINK_SELECTOR;
    }

    @Override
    protected String getFeaturedImageSelector() {
        return BonikBartaArticleParserInfo.FEATURED_IMAGE_SELECTOR;
    }
}
