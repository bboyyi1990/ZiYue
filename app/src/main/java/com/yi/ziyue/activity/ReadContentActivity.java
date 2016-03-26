package com.yi.ziyue.activity;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.KeyEvent;
import android.webkit.WebView;

import com.google.gson.Gson;
import com.yi.ziyue.R;
import com.yi.ziyue.base.BaseActivity;
import com.yi.ziyue.beans.ReadContentBeans;
import com.yi.ziyue.net.NetHelper;
import com.yi.ziyue.net.VolleyNetListener;

import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Yi on 16/3/16.
 */
public class ReadContentActivity extends BaseActivity {

    private WebView webView;


    @Override
    protected int setContent() {
        return R.layout.activity_read_content;
    }

    @Override
    protected void initView() {

        webView = bindView(R.id.read_content_webView);
        Intent intent = getIntent();
        String docId = intent.getStringExtra("docId");
        String url = "http://c.m.163.com/nc/article/" + docId + "/full.html";
        webView.loadUrl(url);
    }

    @Override
    protected void initData() {

    }


}
