package com.yi.ziyue.adapter;

import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.yi.ziyue.R;
import com.yi.ziyue.base.BaseApplication;
import com.yi.ziyue.beans.RecommendListBeans;

import java.util.ArrayList;

/**
 * Created by Yi on 16/3/9.
 */
public class RecommendListAdapter extends BaseAdapter {

    private ArrayList<RecommendListBeans> datas = new ArrayList<>();

    public RecommendListAdapter(ArrayList<RecommendListBeans> datas) {
        this.datas = datas;
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public Object getItem(int position) {
        return datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ListViewHolder listViewHolder = null;
        if (convertView == null) {
            listViewHolder = new ListViewHolder();
            convertView = LayoutInflater.from(BaseApplication.getContext()).inflate(R.layout.listview_read_recommend, parent, false);
            listViewHolder.simpleDraweeView = (SimpleDraweeView) convertView.findViewById(R.id.read_recommend_simpleView);
            listViewHolder.title = (TextView) convertView.findViewById(R.id.read_recommend_title_textView);
            listViewHolder.origin = (TextView) convertView.findViewById(R.id.read_recommend_origin_textView);
            convertView.setTag(listViewHolder);
        } else {
            listViewHolder = (ListViewHolder) convertView.getTag();
        }


        try {
            listViewHolder.simpleDraweeView.setImageURI(Uri.parse(datas.get(position).getImgsrc().toString()));
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

        listViewHolder.title.setText(datas.get(position).getTitle());
        listViewHolder.origin.setText(datas.get(position).getSource());

        return convertView;
    }

    class ListViewHolder {
        SimpleDraweeView simpleDraweeView;
        TextView title, origin;
    }


}
