package com.dasbikash.news_server.old_app.this_utility;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.ShareCompat;

import com.dasbikash.news_server.R;

import java.text.SimpleDateFormat;
import java.util.TimeZone;

@SuppressWarnings("ConstantConditions")
public abstract class OptionsIntentBuilderUtility {

    private static String getAppLink(Context context){
        return  "<a href=\"https://play.google.com/store/apps/details?id="+
                context.getPackageName()+
                "\">"+context.getResources().getString(R.string.app_name)+
                "</a>";
    }

    public static Intent getEmailDeveloperIntent(Activity activity){
        return ShareCompat.IntentBuilder.from(activity)
                .setType("text/html")
                .setSubject(activity.getResources().getString(R.string.email_developer_subject))
                .addEmailTo(activity.getResources().getString(R.string.developer_email_address))
                .setChooserTitle(activity.getResources().getString(R.string.email_com_chooser_text))
                .createChooserIntent();
    }

    public static Intent getShareAppIntent(Activity activity){
        return ShareCompat.IntentBuilder.from(activity)
                .setType("text/plain")
                .setSubject(activity.getResources().getString(R.string.email_share_app_subject))
                .setChooserTitle(activity.getResources().getString(R.string.share_app_chooser_text))
                .setText(getAppLink(activity))
                .createChooserIntent();
    }

}
