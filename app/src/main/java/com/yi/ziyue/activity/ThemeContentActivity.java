package com.yi.ziyue.activity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.google.gson.Gson;
import com.yi.ziyue.R;
import com.yi.ziyue.adapter.ThemeContentAdapter;
import com.yi.ziyue.base.BaseActivity;
import com.yi.ziyue.beans.ThemeContentBean;
import com.yi.ziyue.net.NetHelper;
import com.yi.ziyue.net.VolleyNetListener;

import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Yi on 16/3/17.
 */
public class ThemeContentActivity extends BaseActivity implements VolleyNetListener {

    private TextView alias, concernCount, titleTv, nameTv, description, question, answer;
    private SimpleDraweeView picture, headPicture;
    public static String id, title, count;
    private ListView listView;
    private ThemeContentAdapter adapter;


    @Override
    protected int setContent() {
        return R.layout.activity_theme_content;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        Intent intent = getIntent();
        title = intent.getStringExtra("title");
        id = intent.getStringExtra("id");
        count = intent.getStringExtra("alias");

        alias = bindView(R.id.theme_content_alias);
        alias.setText(title);
        concernCount = bindView(R.id.theme_content_concernCount);
        concernCount.setText(count + " 关注");
        picture = bindView(R.id.theme_content_picurl);
        headPicture = bindView(R.id.theme_content_headpicurl);
        nameTv = bindView(R.id.theme_content_name);
        titleTv = bindView(R.id.theme_content_title);
        description = bindView(R.id.theme_content_description);
        question = bindView(R.id.theme_content_questionCount);
        answer = bindView(R.id.theme_content_answerCount);
        listView = bindView(R.id.theme_content_listview);

        String url = "http://c.m.163.com/newstopic/qa/" + id + ".html";
        Log.d("ThemeContentActivity", url);

        NetHelper netHelper = new NetHelper();
        netHelper.getInformationString(url, null, this);
    }

    @Override
    public void getSucceed(JSONObject jsonObject) {

    }

    @Override
    public void getSucceedString(String s) {

        Gson gson = new Gson();
        ThemeContentBean bean = gson.fromJson(s, ThemeContentBean.class);
        picture.setImageURI(Uri.parse(bean.getData().getExpert().getPicurl()));
        headPicture.setImageURI(Uri.parse(bean.getData().getExpert().getHeadpicurl()));
        nameTv.setText(bean.getData().getExpert().getName());
        titleTv.setText(bean.getData().getExpert().getTitle());
        description.setText(bean.getData().getExpert().getDescription());
        question.setText(String.valueOf(bean.getData().getExpert().getQuestionCount()) + "问题");
        answer.setText(String.valueOf(bean.getData().getExpert().getAnswerCount()) + "回答");

        adapter = new ThemeContentAdapter(bean, this);
        listView.setAdapter(adapter);

    }

    @Override
    public void getFailed(String s) {

    }

    @Override
    public void getSucceedArrayList(ArrayList arrayList) {

    }


}
