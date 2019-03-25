package com.dasbikash.news_server.old_app.article_loader.the_financial_express;

public abstract class TheFinancialExpressArticleParserInfo {

    static final String FEATURED_IMAGE_SELECTOR = ".card-image img";
    static final String FEATURED_IMAGE_LINK_SELECTOR_ATTR = "data-src";
    static final String FEATURED_IMAGE_CAPTION_SELECTOR = ".card-image .card-title-black";

    static final String ARTICLE_FRAGMENT_BLOCK_SELECTOR = "#content-part p";

    static final String PARAGRAPH_IMAGE_SELECTOR = "img";
    static final String PARAGRAPH_IMAGE_LINK_SELECTOR_ATTR = "data-src";
    static final String PARAGRAPH_IMAGE_CAPTION_SELECTOR_ATTR = "alt";

    static final String ARTICLE_MODIFICATION_DATE_STRING_SELECTOR = "span.p3";
    static final String ARTICLE_MODIFICATION_DATE_STRING_FORMATS = "MMMM dd, yyyy HH:mm:ss";
}
