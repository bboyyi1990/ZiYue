package com.yi.ziyue.adapter;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.yi.ziyue.R;
import com.yi.ziyue.base.BaseApplication;
import com.yi.ziyue.beans.Hour24Bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yi on 16/3/12.
 */
public class Hour24Adapter extends BaseAdapter {

    List<Hour24Bean> data = new ArrayList<>();

    public Hour24Adapter(List<Hour24Bean> data) {
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Hour24ViewHolder viewHolder = null;
        if (convertView == null) {
            viewHolder = new Hour24ViewHolder();
            convertView = LayoutInflater.from(BaseApplication.getContext()).inflate(R.layout.listview_hour_layout, null);
            viewHolder.picture = (SimpleDraweeView) convertView.findViewById(R.id.hour24_listview_simpleDraweeView);
            viewHolder.title = (TextView) convertView.findViewById(R.id.hour24_listview_title_text);
            viewHolder.context = (TextView) convertView.findViewById(R.id.hour24_listview_content_text);
            viewHolder.replyCount = (TextView) convertView.findViewById(R.id.hour24_listview_replyCount);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (Hour24ViewHolder) convertView.getTag();
        }
        viewHolder.picture.setImageURI(Uri.parse(data.get(position).getImgsrc()));
        viewHolder.title.setText(data.get(position).getTitle());
        viewHolder.context.setText(data.get(position).getDigest());
        viewHolder.replyCount.setText(data.get(position).getReplyCount() + "跟帖");

        return convertView;
    }

    class Hour24ViewHolder {
        SimpleDraweeView picture;
        TextView title, context, replyCount;
    }
}

