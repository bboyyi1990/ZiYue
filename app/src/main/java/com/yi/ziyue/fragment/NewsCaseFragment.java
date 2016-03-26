package com.yi.ziyue.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.jorge.circlelibrary.ImageCycleView;
import com.yi.ziyue.R;
import com.yi.ziyue.activity.ContentActivity;
import com.yi.ziyue.adapter.NewsListViewAdapter;
import com.yi.ziyue.base.BaseApplication;
import com.yi.ziyue.base.BaseFragment;
import com.yi.ziyue.beans.NewsListBeans;
import com.yi.ziyue.net.ImageLoaderHelper;
import com.yi.ziyue.net.NetHelper;
import com.yi.ziyue.net.VolleyNetListener;

import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Yi on 16/3/4.
 */
public class NewsCaseFragment extends BaseFragment implements VolleyNetListener<NewsListBeans> {
    private ListView listView;
    private SwipeRefreshLayout swipeRefreshLayout;//下拉刷新组件,包裹需要刷新的显示组件
    private NewsListViewAdapter adapter;
    private String tid; //网址 tid
    private ImageCycleView imageCycleView; //轮播图
    private ArrayList<NewsListBeans> data = new ArrayList<>();
    private boolean isBottom = true;//定义判断 listview 是否在最底部
    private int itemId = 0;//上拉加载的数据个数
    private static final int REFRESH_COMPLETE = 0X110;//刷新线程的 what
    //装轮播图标题的集合
    private ArrayList<String> imageDescList = new ArrayList<>();
    //装轮播图 URL 的集合
    private ArrayList<String> urlList = new ArrayList<>();
    //下拉刷新的 Handler
    private Handler newsHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case REFRESH_COMPLETE:
                    adapter.notifyDataSetChanged();
                    initData();
                    swipeRefreshLayout.setRefreshing(false);
                    Toast.makeText(getActivity(), "刷新成功", Toast.LENGTH_SHORT).show();
            }
        }
    };
    private NetHelper helper;

    @Override
    protected int setContent() {
        return R.layout.fragment_newscase;
    }

    @Override
    protected void initView() {
        //listview
        listView = bindView(R.id.news_listview);
        swipeRefreshLayout = bindView(R.id.news_swipeRefreshLayout);
        setListViewHead();//加载第一个 listView 的布局

        //listView 行布局监听
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String postId = data.get(position - 1).getPostid();
                String title = data.get(position - 1).getTitle();

                Intent intent = new Intent(BaseApplication.getContext(), ContentActivity.class);
                intent.putExtra("postId", postId);
                intent.putExtra("title", title);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void initData() {
        //定义一个 bundle 对象来接传递过来的 tid
        Bundle bundle = getArguments();
        tid = (String) bundle.get("tid");

        helper = new NetHelper();
        helper.getInfo(NEXT_HEAD_URL, tid, NEXT_END_URL, NewsListBeans.class, this);
        String s = NEXT_HEAD_URL + tid + NEXT_END_URL;
        //下拉刷新组件刷新监听
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                newsHandler.sendEmptyMessage(REFRESH_COMPLETE);
            }
        });


        //上拉加载 监听 listview 的滑动监听 实现加载
        listView.setOnScrollChangeListener(new View.OnScrollChangeListener() {
            @Override
            public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {

                if (listView.getLastVisiblePosition() == data.size() && isBottom) {
                    itemId += 5;
                    helper.getInfo(NEXT_HEAD_URL, tid, "/" + itemId + "-20.html", NewsListBeans.class, new VolleyNetListener() {
                        @Override
                        public void getSucceed(JSONObject jsonObject) {

                        }

                        @Override
                        public void getSucceedString(String s) {

                        }

                        @Override
                        public void getFailed(String s) {

                        }

                        @Override
                        public void getSucceedArrayList(ArrayList arrayList) {
                            adapter.addData(arrayList);//适配器自定义方法添加数据
                        }
                    });
                    isBottom = false;
                } else if (listView.getLastVisiblePosition() != data.size() - 1) {
                    isBottom = true;
                }

            }
        });
    }

    private void setListViewHead() {
        View v = LayoutInflater.from(BaseApplication.getContext()).inflate(R.layout.listview_news_header, null);
        imageCycleView = (ImageCycleView) v.findViewById(R.id.news_head_circleImageView);
        listView.addHeaderView(v);//设置头布局
    }

    @Override
    public void getSucceed(JSONObject jsonObject) {

    }

    @Override
    public void getSucceedString(String s) {

    }

    @Override
    public void getFailed(String s) {

    }

    @Override
    public void getSucceedArrayList(ArrayList<NewsListBeans> newsListBeans) {

        data = newsListBeans;
        //装轮播图标题的集合
        // imageDescList ;
        //装轮播图 URL 的集合
        //  urlList = new ArrayList<>();
        if (newsListBeans.get(0).getAds() != null) {
            for (int i = 0; i < newsListBeans.get(0).getAds().size(); i++) {
                urlList.add(newsListBeans.get(0).getAds().get(i).getImgsrc());
                imageDescList.add(newsListBeans.get(0).getAds().get(i).getTitle());
            }
        } else {
            urlList.add(newsListBeans.get(0).getImgsrc());
            imageDescList.add(newsListBeans.get(0).getTitle());
        }

        initCarsueView();//载入轮播图数据的方法

        adapter = new NewsListViewAdapter(newsListBeans);

        listView.setAdapter(adapter);


    }

    private void initCarsueView() {

        ImageCycleView.ImageCycleViewListener mADCycleViewListener = new ImageCycleView.ImageCycleViewListener() {
            @Override
            public void displayImage(String imageURL, ImageView imageView) {
                //载入图片
                ImageLoaderHelper.getInstance().loadImage(imageURL, imageView);
            }

            @Override//轮播图监听事件
            public void onImageClick(int position, View imageView) {
                String docId = data.get(0).getDocid();
                String titles = data.get(0).getTitle();
                Intent intent = new Intent(getActivity(), ContentActivity.class);
                intent.putExtra("postId", docId);
                intent.putExtra("title", titles);
                startActivity(intent);

            }
        };

        //imageCycleView 设置资源 标题集合 url 集合 和 轮播图的监听事件
        imageCycleView.setImageResources(imageDescList, urlList, mADCycleViewListener);
        //开始轮播方法 判断只有一个图片的时候不轮播
        if (urlList.size() == 1) {
            imageCycleView.pushImageCycle();
        } else {
            imageCycleView.startImageCycle();
        }
    }

}

