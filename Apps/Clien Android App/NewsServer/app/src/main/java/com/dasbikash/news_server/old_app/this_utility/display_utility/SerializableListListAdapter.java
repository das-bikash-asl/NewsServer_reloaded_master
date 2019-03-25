package com.dasbikash.news_server.old_app.this_utility.display_utility;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import com.dasbikash.news_server.old_app.this_utility.NewsServerUtility;

import java.io.Serializable;
import java.util.ArrayList;

public class SerializableListListAdapter extends ArrayAdapter<Serializable> {

    ArrayList<Serializable> mSerializableItemList = new ArrayList<Serializable>();
    private Context mContext;
    private SerializableItemListDisplayCallbacks<Serializable> mCallBacksForReqActions;

    @SuppressLint("ResourceType")
    public SerializableListListAdapter(SerializableItemListDisplayCallbacks<Serializable>
                                               serializableItemListDisplayCallbacks){
        super(NewsServerUtility.getContext(),
                serializableItemListDisplayCallbacks.getIdForItemDisplay(),
                serializableItemListDisplayCallbacks.getSerializableItemListForDisplay());
        mSerializableItemList = serializableItemListDisplayCallbacks.getSerializableItemListForDisplay();
        mContext = NewsServerUtility.getContext();
        mCallBacksForReqActions = serializableItemListDisplayCallbacks;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        @SuppressLint("ResourceType")
        View view = inflater.inflate(mCallBacksForReqActions.getIdForItemDisplay(), parent, false);

        Serializable serializableItem = mSerializableItemList.get(position);

        if (serializableItem != null){

            TextView serializableItemTitleView = null;

            if (mCallBacksForReqActions.getIdOfItemTextView() !=0) {
                serializableItemTitleView = view.findViewById(mCallBacksForReqActions.getIdOfItemTextView());

                DisplayUtility.displayHtmlText
                        (serializableItemTitleView,
                                mCallBacksForReqActions.
                                        getTextStringForTextView(serializableItem));

                serializableItemTitleView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mCallBacksForReqActions.callBackForTextItemClickAction(serializableItem);
                    }
                });
            }

            ImageButton imageButton = null;

            if (mCallBacksForReqActions.getIdOfItemImageButton() !=0) {
                imageButton = view.findViewById(mCallBacksForReqActions.getIdOfItemImageButton());

                imageButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mCallBacksForReqActions.callBackForImageButtonItemClickAction(serializableItem);
                    }
                });
            }


            View seperator = null;
            if (mCallBacksForReqActions.getIdOfItemHorSeparator() !=0) {
                seperator = view.findViewById(mCallBacksForReqActions.getIdOfItemHorSeparator());
            }

            if (seperator!=null){
                if (position == mSerializableItemList.size()-1){
                    seperator.setVisibility(View.GONE);
                } else {
                    seperator.setVisibility(View.VISIBLE);
                }
            }
        } else {
            view.setVisibility(View.GONE);
        }

        return view;
    }

    @Nullable
    @Override
    public Serializable getItem(int position) {
        return super.getItem(position);
    }
}