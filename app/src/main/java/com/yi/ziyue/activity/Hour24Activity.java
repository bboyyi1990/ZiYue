package com.yi.ziyue.activity;

import android.content.Intent;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import com.google.gson.Gson;
import com.yi.ziyue.R;
import com.yi.ziyue.adapter.Hour24Adapter;
import com.yi.ziyue.base.BaseActivity;
import com.yi.ziyue.beans.Hour24Bean;
import com.yi.ziyue.net.NetHelper;
import com.yi.ziyue.net.VolleyNetListener;

import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Yi on 16/3/12.
 */
public class Hour24Activity extends BaseActivity implements VolleyNetListener<Hour24Bean> {

    private ListView listView;
    private Hour24Adapter adapter;
    private Toolbar toolbar;


    @Override
    protected int setContent() {
        return R.layout.activity_hour24;
    }

    @Override
    protected void initView() {
        listView = (ListView) findViewById(R.id.hour24_listview);
        toolbar = (Toolbar) findViewById(R.id.hour24_toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("子曰:中午不睡,下午崩溃");
        toolbar.setNavigationIcon(R.mipmap.back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Hour24Activity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void initData() {

        NetHelper netHelper = new NetHelper();
        netHelper.getInfo(HOUR_24_HEAD, HOUR_24_TID, HOUR_24_END, Hour24Bean.class, this);
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
    public void getSucceedArrayList(ArrayList<Hour24Bean> hour24Beans) {
        adapter = new Hour24Adapter(hour24Beans);
        listView.setAdapter(adapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        // TODO jump to Content Activity show the content

        return super.onOptionsItemSelected(item);
    }
}
