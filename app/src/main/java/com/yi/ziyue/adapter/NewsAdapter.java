package com.yi.ziyue.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.yi.ziyue.R;
import com.yi.ziyue.base.BaseApplication;

import java.util.List;

/**
 * Created by Yi on 16/3/3.
 */
public class NewsAdapter extends FragmentPagerAdapter {
    private List<Fragment> data;
    private List<String> titles;

    public NewsAdapter(FragmentManager fm, List<Fragment> data, List<String> titles) {
        super(fm);

        this.data = data;
        this.titles = titles;
    }

    @Override
    public Fragment getItem(int position) {
        return data.get(position);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    public View getTabView(int position) {
        View view = LayoutInflater.from(BaseApplication.getContext()).inflate(R.layout.tabs_news, null);
        TextView tv = (TextView) view.findViewById(R.id.news_tabs_tv);
        tv.setText(titles.get(position));
        return view;
    }

}
