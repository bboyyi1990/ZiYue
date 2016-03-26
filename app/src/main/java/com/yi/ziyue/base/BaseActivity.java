package com.yi.ziyue.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;

import com.yi.ziyue.R;

import cn.jpush.android.api.JPushInterface;

/**
 * Created by Yi on 16/3/2.
 */
public abstract class BaseActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setContent());
        overridePendingTransition(R.anim.activity_enter, R.anim.activity_out);
        initData();
        initView();

    }

    @Override
    protected void onPause() {
        JPushInterface.onPause(this);
        super.onPause();
    }

    @Override
    protected void onResume() {
        JPushInterface.onResume(this);
        super.onResume();
    }

    protected abstract int setContent();//绑定布局

    protected abstract void initView();//绑定组件抽象方法

    protected abstract void initData();//加载数据抽象方法

    //
    protected <T extends View> T bindView(int id) {
        return (T) findViewById(id);
    }

}
