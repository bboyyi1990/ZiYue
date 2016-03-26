package com.yi.ziyue.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.yi.ziyue.R;
import com.yi.ziyue.beans.RadioBean;

/**
 * Created by Yi on 16/3/17.
 */
public class RadioAdapter extends BaseAdapter {

    private Context context;
    private RadioBean data;

    public RadioAdapter(Context context, RadioBean data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.getCList().size();
    }

    @Override
    public Object getItem(int position) {
        return data.getCList().get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        RadioViewHolder holder = null;
        if (convertView == null) {
            holder = new RadioViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.radio_listview, null);
            holder.classNameTv = (TextView) convertView.findViewById(R.id.listitem_radio_className_text);
            holder.classHeadPicture = (SimpleDraweeView) convertView.findViewById(R.id.listitem_radio_class_head_picture);
            holder.contentPictureFirst = (SimpleDraweeView) convertView.findViewById(R.id.listitem_radio_content_picture_one);
            holder.contentTextFirst = (TextView) convertView.findViewById(R.id.listitem_radio_content_text_one);
            holder.contentPictureSecond = (SimpleDraweeView) convertView.findViewById(R.id.listitem_radio_content_picture_two);
            holder.contentTextSecond = (TextView) convertView.findViewById(R.id.listitem_radio_content_text_two);
            holder.contentPictureThird = (SimpleDraweeView) convertView.findViewById(R.id.listitem_radio_content_picture_three);
            holder.contentTextThird = (TextView) convertView.findViewById(R.id.listitem_radio_content_text_three);


            convertView.setTag(holder);
        } else {
            holder = (RadioViewHolder) convertView.getTag();
            holder.classNameTv.setText(data.getCList().get(position).getCname());
            holder.classHeadPicture.setImageURI(Uri.parse(data.getCList().get(position).getTList().get(0).getRadio().getImgsrc()));
            holder.contentPictureFirst.setImageURI(Uri.parse(data.getCList().get(position).getTList().get(0).getRadio().getImgsrc()));
            holder.contentTextFirst.setText(data.getCList().get(position).getTList().get(0).getRadio().getTitle());
            holder.contentPictureSecond.setImageURI(Uri.parse(data.getCList().get(position).getTList().get(1).getRadio().getImgsrc()));
            holder.contentTextSecond.setText(data.getCList().get(position).getTList().get(1).getRadio().getTitle());
            holder.contentPictureThird.setImageURI(Uri.parse(data.getCList().get(position).getTList().get(2).getRadio().getImgsrc()));
            holder.contentTextThird.setText(data.getCList().get(position).getTList().get(2).getRadio().getTitle());

        }
        return convertView;
    }

    class RadioViewHolder {
        TextView classNameTv, contentTextFirst, contentTextSecond, contentTextThird;
        SimpleDraweeView classHeadPicture, contentPictureFirst, contentPictureSecond, contentPictureThird;

    }
}
