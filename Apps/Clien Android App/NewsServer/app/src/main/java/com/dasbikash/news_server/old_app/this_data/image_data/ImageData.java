package com.dasbikash.news_server.old_app.this_data.image_data;

import java.io.Serializable;

@SuppressWarnings("CanBeFinal")
public class ImageData implements Serializable{

    private int mId;
    private String mLink;
    private String mDiskLocation;
    private String mAltText;
    private double  mSizeKB;

    ImageData(int id, String link, String diskLocation, String altText, double sizeKB) {
        mId = id;
        mLink = link;
        mDiskLocation = diskLocation;
        mAltText = altText;
        mSizeKB = sizeKB;
    }

    public int getId() {
        return mId;
    }

    public String getLink() {
        return mLink;
    }

    public String getDiskLocation() {
        return mDiskLocation;
    }

    public String getAltText() {
        return mAltText;
    }

    public double getSizeKB() {
        return mSizeKB;
    }
}
