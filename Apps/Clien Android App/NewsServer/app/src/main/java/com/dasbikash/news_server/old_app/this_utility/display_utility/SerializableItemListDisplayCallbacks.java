package com.dasbikash.news_server.old_app.this_utility.display_utility;

import android.support.annotation.IdRes;

import java.util.ArrayList;

public interface SerializableItemListDisplayCallbacks<Serializable> {
    @IdRes
    int getListViewId();
    @IdRes int getRecyclerViewId();
    int getIdForItemDisplay();
    @IdRes int getIdOfItemTextView();
    @IdRes int getIdOfItemHorSeparator();
    @IdRes int getIdOfItemImageButton();
    int getRVDisplayThresholdCount();
    ArrayList<Serializable> getSerializableItemListForDisplay();
    String getTextStringForTextView(Serializable serializableItem);
    void callBackForTextItemClickAction(Serializable serializableItem);
    void callBackForImageButtonItemClickAction(Serializable serializableItem);
}