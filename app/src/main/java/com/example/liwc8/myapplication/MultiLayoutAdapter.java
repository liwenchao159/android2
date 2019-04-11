package com.example.liwc8.myapplication;

import android.content.Context;
import android.content.pm.ProviderInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Created by liwc8 on 11/4/2019.
 */

public class MultiLayoutAdapter extends BaseAdapter {
    private static final int TYPE_BOOK = 0;
    private static final int TYPE_APP = 1;
    private Context mContext;
    private ArrayList<Object> mData = null;

    public MultiLayoutAdapter(Context mContext, ArrayList<Object> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    /**
     * 获取类型
     *
     * @param position
     * @return
     */
    @Override
    public int getItemViewType(int position) {
        if (mData.get(position) instanceof App) {
            return TYPE_APP;
        } else if (mData.get(position) instanceof Book) {
            return TYPE_BOOK;
        } else {
            return super.getItemViewType(position);
        }
    }

    /**
     * 获取类型个数
     *
     * @return
     */
    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        int type = getItemViewType(position);
        ViewHolder1 holder1 = null;
        ViewHolder2 holder2 = null;
        if (convertView == null) {
            switch (type) {
                case TYPE_APP:
                    holder1 = new ViewHolder1();
                    convertView = LayoutInflater.from(mContext).inflate(R.layout.item_one, parent, false);
                    holder1.img_icon = (ImageView) convertView.findViewById(R.id.imag_icon);
                    holder1.txt_name = (TextView) convertView.findViewById(R.id.txt_name);
                    convertView.setTag(R.id.Tag_App, holder1);
                    break;
                case TYPE_BOOK:
                    holder2 = new ViewHolder2();
                    convertView = LayoutInflater.from(mContext).inflate(R.layout.item_two, parent, false);
                    holder2.txt_bname = (TextView) convertView.findViewById(R.id.txt_bname);
                    holder2.txt_bauthor = (TextView) convertView.findViewById(R.id.txt_bauthor);
                    convertView.setTag(R.id.Tag_Book, holder2);
                    break;

            }
        } else {
            switch (type) {
                case TYPE_APP:
                    holder1 = (ViewHolder1) convertView.getTag(R.id.Tag_App);
                    break;
                case TYPE_BOOK:
                    holder2 = (ViewHolder2) convertView.getTag(R.id.Tag_Book);
                    break;
            }
        }
        Object obj = mData.get(position);
        switch (type) {
            case TYPE_APP:
                App app = (App) obj;
                if (app != null) holder1.img_icon.setImageResource(app.getIcon());
                if (app != null) holder1.txt_name.setText(app.getName());
                break;
            case TYPE_BOOK:
                Book book = (Book) obj;
                if (book != null) holder2.txt_bauthor.setText(book.getAuthor());
                if (book != null) holder2.txt_bname.setText(book.getName());
                break;
        }
        return convertView;
    }

    public static class ViewHolder1 {
        ImageView img_icon;
        TextView txt_name;
    }

    public static class ViewHolder2 {
        TextView txt_bname;
        TextView txt_bauthor;
    }
}
