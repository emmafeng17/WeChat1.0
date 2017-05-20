package com.emma.chat.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.emma.chat.Model.AlbumBean;
import com.emma.chat.R;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by emma on 17/5/17.
 */

public class AlbumAdpter extends BaseAdapter {
    private List<AlbumBean> mListData;
    protected Context context;
    LayoutInflater mInflater;

    public AlbumAdpter(List<AlbumBean> mData, Context ctx) {
        context = ctx;
        mListData = mData;
    }

    @Override
    public int getCount() {
        return mListData.size() + 1;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

       // if (convertView == null)
            convertView = LayoutInflater.from(context).inflate(
                    R.layout.layout_item_album, parent, false);

        ImageView imageshare1 = (ImageView) convertView.findViewById(R.id.img_photo1);
        ImageView imageshare2 = (ImageView) convertView.findViewById(R.id.img_photo2);
        ImageView imageshare3 = (ImageView) convertView.findViewById(R.id.img_photo3);
        imageshare1.setAdjustViewBounds(true);
        imageshare2.setAdjustViewBounds(true);
        imageshare3.setAdjustViewBounds(true);


        if (position >= mListData.size()) {
            imageshare1.setImageResource(R.drawable.headself);
            imageshare2.setImageResource(R.drawable.headself);
            imageshare3.setImageResource(R.drawable.headself);

        } else {
            AlbumBean bean=mListData.get(position);

            TextView textmsg = (TextView) convertView.findViewById(R.id.txt_msg);
            textmsg.setText(bean.getContent());
            if (bean.getImage1()!=null){
                imageshare1.setImageBitmap(bean.getImage1());
            }
        }

        return convertView;
    }
}
