package com.yi.ziyue.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.yi.ziyue.R;
import com.yi.ziyue.beans.SearchResultBean;

import java.util.List;

/**
 * Created by Yi on 16/3/17.
 */
public class SearchResultAdapter extends BaseAdapter {

    private Context context;
    private SearchResultBean data;

    public SearchResultAdapter(Context context, SearchResultBean data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.getDoc().getResult().size();
    }

    @Override
    public Object getItem(int position) {
        return data.getDoc().getResult().get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ResultViewHolder holder = null;
        if (convertView == null) {
            holder = new ResultViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.search_result_listview, null);
            holder.title = (TextView) convertView.findViewById(R.id.search_result_listView_title_tv);
            holder.time = (TextView) convertView.findViewById(R.id.search_result_listView_time_tv);
            convertView.setTag(holder);

        } else {
            holder = (ResultViewHolder) convertView.getTag();
        }

        holder.title.setText(data.getDoc().getResult().get(position).getTitle());
        holder.time.setText(data.getDoc().getResult().get(position).getPtime());


        return convertView;
    }


    class ResultViewHolder {
        TextView title, time;

    }
}
