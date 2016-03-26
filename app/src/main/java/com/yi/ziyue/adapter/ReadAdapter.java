package com.yi.ziyue.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.yi.ziyue.R;
import com.yi.ziyue.base.BaseApplication;
import com.yi.ziyue.fragment.SubscriptionFragment;
import com.yi.ziyue.fragment.RecommendFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yi on 16/3/9.
 */
public class ReadAdapter extends FragmentPagerAdapter {
    private List<Fragment> data = new ArrayList<>();
    private List<String> titles = new ArrayList<>();

    public ReadAdapter(FragmentManager fm) {
        super(fm);
        data.add(new RecommendFragment());
//        data.add(new SubscriptionFragment());
        titles.add("推荐阅读");
//        titles.add("我的订阅");

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
        View view = LayoutInflater.from(BaseApplication.getContext()).inflate(R.layout.tabs_read, null);
        TextView tv = (TextView) view.findViewById(R.id.read_tabs_tv);
        tv.setText(titles.get(position));
        return view;
    }
}
