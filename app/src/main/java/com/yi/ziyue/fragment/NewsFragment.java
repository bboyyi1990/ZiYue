package com.yi.ziyue.fragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.design.widget.TabLayout;
import android.view.View;
import android.widget.ImageView;


import com.google.gson.Gson;
import com.yi.ziyue.R;
import com.yi.ziyue.activity.Hour24Activity;
import com.yi.ziyue.activity.SearchActivity;
import com.yi.ziyue.adapter.NewsAdapter;
import com.yi.ziyue.base.BaseActivity;
import com.yi.ziyue.base.BaseApplication;
import com.yi.ziyue.base.BaseFragment;
import com.yi.ziyue.beans.NewsTitleBeans;
import com.yi.ziyue.net.NetHelper;
import com.yi.ziyue.net.VolleyNetListener;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yi on 16/3/3.
 */
public class NewsFragment extends BaseFragment implements VolleyNetListener, View.OnClickListener {

    private NewsTitleBeans beans;
    private List<Fragment> newsFragmentBeansData = new ArrayList<>();//装新闻分页的碎片集合
    private List<String> titles = new ArrayList<>();//装标签集合
    private NetHelper netHelper;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private NewsAdapter adapter;
    private ImageView search, hour24;


    @Override
    protected int setContent() {
        return R.layout.fragment_news;
    }

    @Override
    protected void initView() {

        tabLayout = bindView(R.id.tablayout);
        viewPager = bindView(R.id.news_viewpager);
        search = bindView(R.id.news_bar_imageView_search);
        search.setOnClickListener(this);
        hour24 = bindView(R.id.news_bar_imageView_24hour);
        hour24.setOnClickListener(this);
    }

    @Override
    protected void initData() {

        netHelper = new NetHelper();
        netHelper.getInformation(TABS_URL, null, this);
    }

    @Override
    public void getSucceed(JSONObject jsonObject) {
        Gson gson = new Gson();
        beans = gson.fromJson(jsonObject.toString(), NewsTitleBeans.class);


        //遍历实体类里的数组数据获得标签同时加入复用 Fragment
        for (int i = 0; i < beans.getTList().size() - 20; i++) { //这里循环标签个数减40是为了减少标签,多了太卡
            titles.add(beans.getTList().get(i).getTname());
            //通过getinstance 方法获得需要加载的Fragment界面并在方法里加载界面的时候对 Fragment 进行一个 bundle 的传值把解析的 tid 传递到我们复用的 Fragment里面
            newsFragmentBeansData.add(getInstance(beans.getTList().get(i).getTid()));
        }

        adapter = new NewsAdapter(getFragmentManager(), newsFragmentBeansData, titles);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setSelectedTabIndicatorColor(Color.WHITE);

        //tableLayout加载标签的视图
        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            TabLayout.Tab tab = tabLayout.getTabAt(i);
            if (tab != null) {
                tab.setCustomView(adapter.getTabView(i));
            }
        }
        viewPager.setCurrentItem(1);
        viewPager.setCurrentItem(0);
    }

    @Override
    public void getSucceedString(String s) {

    }


    @Override
    public void getFailed(String s) {
    }

    @Override
    public void getSucceedArrayList(ArrayList arrayList) {

    }


    //bundle传递数据的方法
    public static Fragment getInstance(String s) {
        Bundle bundle = new Bundle();
        bundle.putString("tid", s);
        Fragment newsCaseFragment = new NewsCaseFragment();
        newsCaseFragment.setArguments(bundle);
        return newsCaseFragment;
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.news_bar_imageView_search:
                Intent searchIntent = new Intent(BaseApplication.getContext(), SearchActivity.class);
                startActivity(searchIntent);
                break;

            case R.id.news_bar_imageView_24hour:
                Intent intentHour = new Intent(getActivity(), Hour24Activity.class);
                startActivity(intentHour);
                break;
        }
    }
}
