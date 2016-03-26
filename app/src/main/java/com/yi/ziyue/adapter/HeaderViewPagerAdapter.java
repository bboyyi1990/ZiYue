package com.yi.ziyue.adapter;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by Yi on 16/3/5.
 */
public class HeaderViewPagerAdapter extends PagerAdapter {
    List<ImageView> imageViewList;

    public HeaderViewPagerAdapter(List<ImageView> imageViewList) {
        this.imageViewList = imageViewList;
    }


    @Override
    public int getCount() {
        return imageViewList.size();
    }

    @Override//判断是否由对象生成界面
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override//销毁 position 位置的视图
    public void destroyItem(View container, int position, Object object) {
        ((ViewPager) container).removeView(imageViewList.get(position));

    }

    //返回显示的 view 对象
    public Object instantiateItem(View container, int position) {

        ((ViewPager) container).addView(imageViewList.get(position));
        return imageViewList.get(position);
    }


}
