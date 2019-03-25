package com.dasbikash.news_server.old_app.edition_loader.anando_bazar;

class AnandoBazarEditionParserInfo {

    static final String ARTICLE_PREVIEW_BLOCK_SELECTOR[] = {"article",".leadstory"};

    static final String ARTICLE_LINK_ELEMENT_SELECTOR[] = {".image-placeholder a",".leadstoryheading a"};
    static final String ARTICLE_LINK_TEXT_SELECTOR_TAG[] = {"href","href"};

    static final String ARTICLE_PREVIEW_IMAGE_LINK_ELEMENT_SELECTOR[] =
                        {".image-placeholder img","img[data-original]"};
    static final String ARTICLE_PREVIEW_IMAGE_LINK_TEXT_SELECTOR_TAG[] =
                        {"src","data-original"};

    static final String ARTICLE_TITLE_ELEMENT_SELECTOR[] = {"h3",".leadstoryheading a"};

    static final String ARTICLE_PUBLICATION_DATE_ELEMENT_SELECTOR[] = {".date-arc"};
    static final String ARTICLE_PUBLICATION_DATE_TIME_FORMAT = "dd MMMM, yyyy HH:mm:ss";
}
