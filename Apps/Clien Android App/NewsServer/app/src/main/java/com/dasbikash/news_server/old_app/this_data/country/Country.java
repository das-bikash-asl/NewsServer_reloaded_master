package com.dasbikash.news_server.old_app.this_data.country;

public class Country {

    private String mName;
    private String mCountryCode;
    private int mContinentId;
    private String mTimeZone;

    Country(String name, String countryCode, int continentId, String timeZone) {
        mName = name;
        mCountryCode = countryCode;
        mContinentId = continentId;
        mTimeZone = timeZone;
    }

    public String getName() {
        return mName;
    }

    public String getCountryCode() {
        return mCountryCode;
    }

    public int getContinentId() {
        return mContinentId;
    }

    public String getTimeZone() {
        return mTimeZone;
    }
}
