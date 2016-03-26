package com.yi.ziyue.base;

import android.content.Context;
import android.view.View;

import com.yi.ziyue.R;
import com.yi.ziyue.beans.NewsListBeans;

import java.util.List;

/**
 * Created by Yi on 16/3/19.
 */
public class TestAdapter extends ListViewBaseAdapter<NewsListBeans> {


    public TestAdapter(Context context, List<NewsListBeans> list) {
        super(context, list);
    }

    //绑定行布局文件
    @Override
    protected int getItemResource() {
        return 0;
    }

    @Override//绑定组件
    protected View getItemView(int position, ViewHolder holder, View convertView) {

        //在这里初始化组件并赋值
        View v = holder.getView(R.id.actionbarLayoutId);
        list.get(position);
        v.setTag("");
        //可以直接在这个对 convertView进行监听

        return convertView;
    }
}
