package com.dasbikash.news_server.old_app.this_view;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;

import com.dasbikash.news_server.R;
import com.dasbikash.news_server.old_app.this_data.article.Article;
import com.dasbikash.news_server.old_app.this_data.article_fragment.ArticleFragment;
import com.dasbikash.news_server.old_app.this_data.article_fragment.ArticleFragmentHelper;
import com.dasbikash.news_server.old_app.this_data.feature.Feature;
import com.dasbikash.news_server.old_app.this_data.feature.FeatureHelper;
import com.dasbikash.news_server.old_app.this_data.image_data.ImageData;
import com.dasbikash.news_server.old_app.this_data.newspaper.Newspaper;
import com.dasbikash.news_server.old_app.this_data.newspaper.NewspaperHelper;
import com.dasbikash.news_server.old_app.this_utility.NewsServerUtility;

import java.util.ArrayList;
import java.util.List;

public class ArticleImageListActivity extends AppCompatActivity {

    private static final String EXTRA_CURRENT_IMAGE_ID =
            "com.dasbikash.prothomalofeatures.ArticleImageListActivity.current_imageid";
    private static final String EXTRA_CURRENT_ARTICLE =
            "com.dasbikash.prothomalofeatures.ArticleImageListActivity.current_article";

    private Article mArticle;
    private Newspaper mNewspaper;
    @SuppressWarnings("CanBeFinal")
    private List<ImageData> mImageDataList = new ArrayList<>();
    private int mCurrentPosition;


    public static Intent newIntent(Context packageContext, int currentImageId, Article currentArticle) {
        Intent intent = new Intent(packageContext, ArticleImageListActivity.class);
        intent.putExtra(EXTRA_CURRENT_IMAGE_ID, currentImageId);
        intent.putExtra(EXTRA_CURRENT_ARTICLE, currentArticle);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }else {
            getWindow().setStatusBarColor(Color.parseColor(getResources().getString(R.string.colorPrimaryDark2)));
        }

        setContentView(R.layout.fragment_view_pager);

        int currentImageId=0;
        Intent dataIntent = getIntent();

        if (dataIntent.hasExtra(EXTRA_CURRENT_IMAGE_ID) && dataIntent.hasExtra(EXTRA_CURRENT_ARTICLE)) {
            currentImageId = dataIntent.getIntExtra(EXTRA_CURRENT_IMAGE_ID,0);//getArguments().getInt(ARG_CURRENT_IMAGE_ID);
            mArticle = (Article) dataIntent.getSerializableExtra(EXTRA_CURRENT_ARTICLE);
        } else {
            finish();
        }
        Feature feature = FeatureHelper.findFeatureById(mArticle.getFeatureId());
        mNewspaper = NewspaperHelper.findNewspaperById(feature.getNewsPaperId());

        List<ArticleFragment> articleFragmentList = ArticleFragmentHelper.findFragmentsForArticle(mArticle);

        if (articleFragmentList!=null && articleFragmentList.size()>0) {
            for (ArticleFragment articleFragment:
                    articleFragmentList) {
                ImageData imageData =articleFragment.getImageData();
                if (imageData!=null) {
                    mImageDataList.add(imageData);
                }
            }
        } else {
            finish();
        }

        ViewPager viewPager = findViewById(R.id.view_pager);

        FragmentManager fragmentManager = getSupportFragmentManager();

        viewPager.setAdapter(new FragmentStatePagerAdapter(fragmentManager) {
            @Override
            public Fragment getItem(int position) {
                return ArticleImageFragment.newInstance(mImageDataList.get(position),mNewspaper);
            }
            @Override
            public int getCount() {
                return mImageDataList.size();
            }
        });

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int position) {
                mCurrentPosition = position;
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });

        mCurrentPosition = 0;

        for (;mCurrentPosition<mImageDataList.size();mCurrentPosition++){
            if (mImageDataList.get(mCurrentPosition).getId() == currentImageId) break;
        }

        setActionBarTitle();

        viewPager.setCurrentItem(mCurrentPosition);
    }

    private void setActionBarTitle() {
        /*SimpleDateFormat simpleDateFormat =new SimpleDateFormat(getResources().getString(R.string.display_date_format_short));
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone(
                TimeZone.getDefault().getID()//getResources().getString(R.string.default_time_zone)
        ));*/
        getSupportActionBar().setTitle(mArticle.getTitle());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_layout_basic,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return NewsServerUtility.handleBasicOptionMenuItemActions(item,ArticleImageListActivity.this);
    }
}
