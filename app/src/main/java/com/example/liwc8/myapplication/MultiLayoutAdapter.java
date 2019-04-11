package com.example.liwc8.myapplication;

import android.content.Context;
import android.content.pm.ProviderInfo;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Created by liwc8 on 11/4/2019.
 */

public class MultiLayoutAdapter extends BaseAdapter {
    private  static final  int TYPE_BOOK=0;
    private  static final  int TYPE_APP=1;
    private Context mContext;
    private ArrayList<Object> mData=null;
    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}
