package com.yi.ziyue.fragment;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.IBinder;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.nineoldandroids.view.ViewHelper;
import com.yi.ziyue.R;
import com.yi.ziyue.adapter.WeatherDailyAdapter;
import com.yi.ziyue.adapter.WeatherHourlyAdapter;
import com.yi.ziyue.base.BaseFragment;
import com.yi.ziyue.beans.WeatherBeans;
import com.yi.ziyue.net.NetHelper;
import com.yi.ziyue.net.VolleyNetListener;
import com.yi.ziyue.service.WeatherService;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import de.greenrobot.event.EventBus;

/**
 * Created by Yi on 16/3/3.
 */
public class WeatherFragment extends BaseFragment implements VolleyNetListener {

    private TextView condTv, tempTv, windDir, windLevel, drawerConfrontTv, drawerCarTv, drawerDressTv, illTv, sportTv, travelTv, ultravioletTv, musicKeepTv;
    private ImageView voiceIv;
    private Boolean isRun = false;
    private Boolean playing = !isRun;
    private RecyclerView hourlyRecyclerView;
    private WeatherHourlyAdapter adapter;
    private ListView dailyListView;
    private WeatherDailyAdapter listViewAdapter;
    private DrawerLayout drawerLayout;

    private Binder binder;
    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            binder = (Binder) service;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            binder = null;
        }
    };

    @Override
    protected int setContent() {
        return R.layout.fragment_weather;
    }

    @Override
    protected void initView() {

        drawerLayout = bindView(R.id.weather_drawerLayout);
        setDrawerLayoutEvent();//设置抽屉动画

        //背景音乐开关
        voiceIv = (ImageView) getView().findViewById(R.id.weather_void_img);
        voiceIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (playing) {
                    Intent intent = new Intent(getContext(), WeatherService.class);
                    getActivity().stopService(intent);
                    playing = !playing;
                } else {
                    Intent intent = new Intent(getContext(), WeatherService.class);
                    getActivity().startService(intent);
                    playing = !playing;
                }
            }
        });
    }

    private void setDrawerLayoutEvent() {

        drawerLayout.setDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {

                // 创建一个View的对象叫做mContent(就是内容的视图),要显示的是获取在0位置处的抽屉
                View mContent = drawerLayout.getChildAt(0);
                // 创建一个View的对象叫做mMenu,叫他跟我们的参数匹配
                View mMenu = drawerView;
                // 创建float类型的参数 scale(比例) 整体的比重
                float scale = 1 - slideOffset;//1就是比重是1,1-slideOffset就是滑动后剩下的比重
                // 同理  创建一个 右侧的比重 rightScale,因为你划出  所以会越来越大,那么右侧的比重就是 80%+整体比重的20%
                float rightScale = 0.8f + scale * 0.2f;
                // 判断 (根据Tag找到视图) 如果drawerView的tag是"LEFT",那么就执行语句
                if (drawerView.getTag().equals("LEFT")) {
                    // 创建一个左面的比重 ,这个值到时候可以自己设置,然后寻求效果
                    float leftScale = 1 - 0.3f * scale;
                    //这里的ViewHelper是引的jar包 叫做nineoldandroids - 2.4.0  大家可以在build的libs文件夹下找到它
                    // 设置各种效果,例如ViewHelper.setScaleX(view, float)
                    // 这里的view参数是大家想要移动哪个View就是你要在上面进行活动的界面,float参数就是要移动的距离 ,注意是浮点类型,
                    // 假如参考坐标最开始的中心位置是0,那么ViewHelper.setScaleX(view,100)就是把view向右移动100.
                    ViewHelper.setScaleX(mMenu, leftScale);//把mMenu横向的比重
                    ViewHelper.setScaleY(mMenu, leftScale);// 竖向的比重
                    ViewHelper.setAlpha(mMenu, 0.6f + 0.4f * (1 - scale));// Alpha就是透明度的意思
                    // 设置各种效果,例如ViewHelper.setTranslationX(view, float)
                    // 这里的view参数是大家想要移动哪个View就是你要在上面进行活动的界面,float参数就是要移动的距离 ,注意是浮点类型,
                    // 假如参考坐标最开始的中心位置是0,那么ViewHelper.setSTranslationX(view,100)就是把view向右移动100.
                    ViewHelper.setTranslationX(mContent,
                            mMenu.getMeasuredWidth() * (1 - scale));//把mContent向右移动 mMenu的宽*(1-scale);
                    ViewHelper.setPivotX(mContent, 0);// 把mContent为轴心向右旋转0
                    ViewHelper.setPivotY(mContent,
                            mContent.getMeasuredHeight() / 2);//把mContent为轴心向下旋转整个宽的1/2
                    mContent.invalidate();//使mContent无效,因为它移动到后面去了,不能再让他们还能点了

                    ViewHelper.setScaleX(mContent, rightScale);// 同上面的mMenu
                    ViewHelper.setScaleY(mContent, rightScale);
                } else {
                    ViewHelper.setTranslationX(mContent,
                            -mMenu.getMeasuredWidth() * slideOffset);
                    ViewHelper.setPivotX(mContent, mContent.getMeasuredWidth());
                    ViewHelper.setPivotY(mContent,
                            mContent.getMeasuredHeight() / 2);
                    mContent.invalidate();
                    ViewHelper.setScaleX(mContent, rightScale);
                    ViewHelper.setScaleY(mContent, rightScale);
                }


            }

            @Override
            public void onDrawerOpened(View drawerView) {

            }

            @Override
            public void onDrawerClosed(View drawerView) {

            }

            @Override
            public void onDrawerStateChanged(int newState) {

            }
        });


    }

    @Override
    protected void initData() {
        musicKeepTv = bindView(R.id.weather_drawerLayout_left_music_keep_tv);
        ultravioletTv = bindView(R.id.weather_drawerLayout_left_ultraviolet);
        travelTv = bindView(R.id.weather_drawerLayout_left_travel);
        sportTv = bindView(R.id.weather_drawerLayout_left_sport);
        illTv = bindView(R.id.weather_drawerLayout_left_illness);
        drawerDressTv = bindView(R.id.weather_drawerLayout_left_dress);
        drawerCarTv = bindView(R.id.weather_drawerLayout_left_car);
        drawerConfrontTv = bindView(R.id.weather_drawerLayout_left_confront);
        dailyListView = bindView(R.id.weather_listView_daily);

        windLevel = bindView(R.id.weather_now_wind_level);
        windDir = bindView(R.id.weather_now_wind_dir);
        tempTv = bindView(R.id.weather_now_temp_tv);
        condTv = bindView(R.id.weather_now_cond_tv);
        hourlyRecyclerView = bindView(R.id.weather_recyclerView_hourly);

        LinearLayoutManager gm = new LinearLayoutManager(getActivity());
        gm.setOrientation(LinearLayoutManager.HORIZONTAL);
        hourlyRecyclerView.setLayoutManager(gm);

        NetHelper netHelper = new NetHelper();
        netHelper.getInformation(WEATHER_URL, null, this);

    }

    @Override
    public void getSucceed(JSONObject jsonObject) {

        try {
            JSONArray array = jsonObject.getJSONArray("HeWeather data service 3.0");
            Gson gson = new Gson();
            final WeatherBeans beans = gson.fromJson(array.get(0).toString(), WeatherBeans.class);

            condTv.setText(beans.getNow().getCond().getTxt());
            tempTv.setText(beans.getNow().getTmp().toString() + "°");
            windDir.setText(beans.getNow().getWind().getDir());
            windLevel.setText(beans.getNow().getWind().getSc());


            adapter = new WeatherHourlyAdapter(beans);
            hourlyRecyclerView.setAdapter(adapter);

            listViewAdapter = new WeatherDailyAdapter(getContext(), beans.getDaily_forecast());
            dailyListView.setAdapter(listViewAdapter);

            drawerItemListener(beans); //抽屉布局里组件监听


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void drawerItemListener(final WeatherBeans beans) {

        drawerConfrontTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), beans.getSuggestion().getComf().getBrf() + "," + beans.getSuggestion().getComf().getTxt(), Toast.LENGTH_SHORT).show();
            }
        });


        drawerCarTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), beans.getSuggestion().getCw().getBrf() + "," + beans.getSuggestion().getCw().getTxt(), Toast.LENGTH_SHORT).show();
            }
        });

        drawerDressTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), beans.getSuggestion().getDrsg().getBrf() + "," + beans.getSuggestion().getDrsg().getTxt(), Toast.LENGTH_SHORT).show();
            }

        });
        illTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), beans.getSuggestion().getFlu().getBrf() + "," + beans.getSuggestion().getFlu().getTxt(), Toast.LENGTH_SHORT).show();
            }
        });
        sportTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), beans.getSuggestion().getSport().getBrf() + "," + beans.getSuggestion().getSport().getTxt(), Toast.LENGTH_SHORT).show();
            }
        });
        travelTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), beans.getSuggestion().getTrav().getBrf() + "," + beans.getSuggestion().getTrav().getTxt(), Toast.LENGTH_SHORT).show();
            }
        });
        ultravioletTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), beans.getSuggestion().getUv().getBrf() + "," + beans.getSuggestion().getUv().getTxt(), Toast.LENGTH_SHORT).show();
            }
        });

        //音乐播放模式改变
        musicKeepTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.yi.ziyue.WeatherBroadCastReceiver");
                getContext().sendBroadcast(intent);
        //TODO There is a bug to keep the music run
//                bindWeatherService(getContext());//绑定服务使服务一直存活
//                EventBus.getDefault().post(isRun);//发送 eventBus 去判断是否全局播放
//                isRun = !isRun;

            }
        });
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

    private void bindWeatherService(Context context) {


//        Intent intent = new Intent(context, WeatherService.class);
//
//        if (isRun) {
//            context.bindService(intent, connection, Context.BIND_AUTO_CREATE);
//
//            isRun = !isRun;
//        } else {
//          //  context.stopService(intent);
//            context.unbindService(connection);

//        }
    }

}
