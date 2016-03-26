package com.yi.ziyue.activity;


import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TabHost;


import com.google.gson.Gson;
import com.yi.ziyue.R;
import com.yi.ziyue.base.BaseActivity;

import com.yi.ziyue.fragment.MeFragment;
import com.yi.ziyue.fragment.NewsFragment;
import com.yi.ziyue.fragment.ReadFragment;
import com.yi.ziyue.fragment.SeeFragment;
import com.yi.ziyue.fragment.ThemeFragment;
import com.yi.ziyue.fragment.WeatherFragment;
import com.yi.ziyue.net.NetHelper;
import com.yi.ziyue.net.VolleyNetListener;
import com.yi.ziyue.service.WeatherService;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import de.greenrobot.event.EventBus;

public class MainActivity extends BaseActivity {

    private TabHost tabHost;
    private Boolean isRun = true;

    @Override
    protected int setContent() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {

        tabHost = bindView(android.R.id.tabhost);
        tabHost.setup();
        TabHost.TabSpec news = tabHost.newTabSpec("news");
        news.setIndicator(getLayoutInflater().inflate(R.layout.tab_news, null));
        news.setContent(R.id.news_frame);
        tabHost.addTab(news);

        TabHost.TabSpec read = tabHost.newTabSpec("read");
        read.setIndicator(getLayoutInflater().inflate(R.layout.tab_read, null));
        read.setContent(R.id.read_frame);
        tabHost.addTab(read);

        TabHost.TabSpec theme = tabHost.newTabSpec("theme");
        theme.setIndicator(getLayoutInflater().inflate(R.layout.tab_theme, null));
        theme.setContent(R.id.theme_frame);
        tabHost.addTab(theme);

        TabHost.TabSpec weather = tabHost.newTabSpec("weather");
        View view = LayoutInflater.from(this).inflate(R.layout.tab_weather, null);
        weather.setIndicator(view);
        weather.setContent(R.id.weather_frame);
        tabHost.addTab(weather);


        TabHost.TabSpec see = tabHost.newTabSpec("see");
        see.setIndicator(getLayoutInflater().inflate(R.layout.tab_see, null));
        see.setContent(R.id.see_frame);
        tabHost.addTab(see);


        TabHost.TabSpec me = tabHost.newTabSpec("me");
        me.setIndicator(getLayoutInflater().inflate(R.layout.tab_me, null));
        me.setContent(R.id.me_frame);
        tabHost.addTab(me);


        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();

        transaction.replace(R.id.news_frame, new NewsFragment());
        transaction.replace(R.id.read_frame, new ReadFragment());
        transaction.replace(R.id.theme_frame, new ThemeFragment());
        transaction.replace(R.id.weather_frame, new WeatherFragment());
        transaction.replace(R.id.see_frame, new SeeFragment());
        transaction.replace(R.id.me_frame, new MeFragment());


        transaction.commit();

        //对标签进行监听 选中天气标签是切换页面并实现启动服务在后台播放音乐,切换出页面的时候停止服务关掉音乐
        //卧槽我太聪明了!
        tabListener();//标签点击事件监听

        //注册订阅者为当前activity对象
        EventBus.getDefault().register(this);


    }

    private void tabListener() {

        //天气标签监听
        tabHost.getTabWidget().getChildTabViewAt(3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                tabHost.setCurrentTab(3);
                Intent intent = new Intent(MainActivity.this, WeatherService.class);
                startService(intent);

            }
        });

        //新闻标签监听
        tabHost.getTabWidget().getChildTabViewAt(0).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!isRun) {

              tabHost.setCurrentTab(0);

                } else{

                    Intent intent = new Intent(MainActivity.this, WeatherService.class);
                    stopService(intent);
                    tabHost.setCurrentTab(0);
                }


            }
        });
        //阅读标签监听
        tabHost.getTabWidget().getChildTabViewAt(1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!isRun) {

                    tabHost.setCurrentTab(1);
                }
                else {

                    Intent intent = new Intent(MainActivity.this, WeatherService.class);
                    stopService(intent);
                    tabHost.setCurrentTab(1);
                }

            }
        });
        //话题标签监听
        tabHost.getTabWidget().getChildTabViewAt(2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!isRun) {

                    tabHost.setCurrentTab(2);
                } else {

                    Intent intent = new Intent(MainActivity.this, WeatherService.class);
                    stopService(intent);
                    tabHost.setCurrentTab(2);
                }

            }
        });

        //视听页面监听
        tabHost.getTabWidget().getChildTabViewAt(4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!isRun) {
                    tabHost.setCurrentTab(4);

                } else {

                    Intent intent = new Intent(MainActivity.this, WeatherService.class);
                    stopService(intent);
                    tabHost.setCurrentTab(4);
                }


            }
        });

        //我页面监听
        tabHost.getTabWidget().getChildTabViewAt(5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!isRun) {
                    tabHost.setCurrentTab(5);

                } else {

                    Intent intent = new Intent(MainActivity.this, WeatherService.class);
                    stopService(intent);
                    tabHost.setCurrentTab(5);
                }

            }
        });

    }

    @Override
    protected void initData() {


    }

    //EventBus 回调事假   不能刷新UI
    public void onEvent(Boolean isRun) {
        this.isRun = isRun;
        Log.d("Sysout","isRun" + isRun);

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
