package com.yi.ziyue.activity;

import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.yi.ziyue.R;
import com.yi.ziyue.adapter.SearchAdapter;
import com.yi.ziyue.base.BaseActivity;
import com.yi.ziyue.beans.SearchHotBean;
import com.yi.ziyue.net.NetHelper;
import com.yi.ziyue.net.VolleyNetListener;

import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Yi on 16/3/12.
 */
public class SearchActivity extends BaseActivity implements View.OnClickListener, VolleyNetListener {
    private ImageView backIv;
    private RecyclerView recyclerView;
    private SearchAdapter adapter;
    private Button searchButton;
    private EditText content;
    private TextView historyTv;


    @Override
    protected int setContent() {
        return R.layout.activity_search;
    }

    @Override
    protected void initView() {
        historyTv = bindView(R.id.search_history_tv);//TODO set history value
        backIv = bindView(R.id.search_back);
        backIv.setOnClickListener(this);
        searchButton = bindView(R.id.search_btn);
        searchButton.setOnClickListener(this);
        content = bindView(R.id.search_editText);

        content.setTextColor(getResources().getColor(R.color.news_content_color));

        recyclerView = bindView(R.id.search_recyclerView);
        GridLayoutManager gm = new GridLayoutManager(this, 3);
        gm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(gm);


    }

    @Override
    protected void initData() {
        NetHelper netHelper = new NetHelper();
        netHelper.getInformationString(SEARCH_HOT, null, this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.search_back:
                Intent i = new Intent(SearchActivity.this, MainActivity.class);
                startActivity(i);
                break;
            case R.id.search_btn:

                String con = content.getText().toString();
                if (!con.equals("")) {
                    content.setText("");
                    SearchResultActivity.jumpSearchResultActivity(this, con);
                } else {
                    Toast.makeText(SearchActivity.this, "请输入内容", Toast.LENGTH_SHORT).show();
                }

                break;
        }
    }

    @Override
    public void getSucceed(JSONObject jsonObject) {

    }

    @Override
    public void getSucceedString(String s) {
        Gson gson = new Gson();
        SearchHotBean searchHotBean = gson.fromJson(s, SearchHotBean.class);
        adapter = new SearchAdapter(searchHotBean);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void getFailed(String s) {

    }

    @Override
    public void getSucceedArrayList(ArrayList arrayList) {

    }
}
