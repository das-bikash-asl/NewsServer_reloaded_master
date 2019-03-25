package com.dasbikash.news_server.old_app.this_utility;


import android.util.Log;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.X509TrustManager;

public final class URLConnectionHelper {

    private static final String TAG = "URLCon";
    public static final int CONNECTION_TIMEOUT_MILLIS = 60000;

    public static Document getJsopDocument(String pageUrl) {

        Document newDocument = null;

        //Log.d(TAG, "getJsopDocument: pageUrl: "+pageUrl);

        try {
            newDocument = Jsoup.connect(pageUrl).timeout(CONNECTION_TIMEOUT_MILLIS).followRedirects(true).get();
        } catch (Exception e) {
            //Log.d(TAG, "getJsopDocument: "+e.getMessage());
            e.printStackTrace();
        }
        return newDocument;
    }

}