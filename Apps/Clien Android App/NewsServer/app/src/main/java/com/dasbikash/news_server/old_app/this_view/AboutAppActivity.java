package com.dasbikash.news_server.old_app.this_view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.dasbikash.news_server.R;
import com.dasbikash.news_server.old_app.this_utility.display_utility.DisplayUtility;

public class AboutAppActivity extends AppCompatActivity {

    TextView mAboutAppText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_app);

        mAboutAppText = findViewById(R.id.about_app_text);

        DisplayUtility.displayHtmlText(
                mAboutAppText,
                getResources().getString(R.string.about_app_text)
        );
    }


    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

}
