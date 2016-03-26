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
import com.yi.ziyue.beans.NewsListBeans;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yi on 16/3/5.
 */
public class NewsListViewAdapter extends BaseAdapter {

    private List<NewsListBeans> newsListBeans = new ArrayList<>();


    public NewsListViewAdapter(List<NewsListBeans> newsListBean) {
                   newsListBean.remove(0);
        this.newsListBeans =  newsListBean;
    }

    //自定义添加数据的方法
    public void addData(ArrayList<NewsListBeans> datas) {
        newsListBeans.addAll(datas);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return newsListBeans.size();
    }

    @Override
    public Object getItem(int position) {
        return newsListBeans.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        NewsViewHolder newsViewHolder = null;
        if (convertView == null) {
            newsViewHolder = new NewsViewHolder();
            convertView = LayoutInflater.from(BaseApplication.getContext()).inflate(R.layout.listview_news, parent, false);
            newsViewHolder.titleTv = (TextView) convertView.findViewById(R.id.news_listview_TitleTv);
            newsViewHolder.contentTv = (TextView) convertView.findViewById(R.id.news_listview_contentTv);
            newsViewHolder.simpleDraweeView = (SimpleDraweeView) convertView.findViewById(R.id.news_listView_simple);
            convertView.setTag(newsViewHolder);
        } else {
            newsViewHolder = (NewsViewHolder) convertView.getTag();
        }
        newsViewHolder.titleTv.setText(newsListBeans.get(position).getTitle());
        newsViewHolder.contentTv.setText(newsListBeans.get(position).getDigest());
        newsViewHolder.simpleDraweeView.setImageURI(Uri.parse(newsListBeans.get(position).getImgsrc()));

        return convertView;
    }


    class NewsViewHolder {
        TextView titleTv, contentTv;
        SimpleDraweeView simpleDraweeView;

    }
}
