package com.yi.ziyue.activity;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.yi.ziyue.BuildConfig;
import com.yi.ziyue.R;
import com.yi.ziyue.adapter.SearchResultAdapter;
import com.yi.ziyue.base.BaseActivity;
import com.yi.ziyue.beans.SearchResultBean;
import com.yi.ziyue.net.NetHelper;
import com.yi.ziyue.net.VolleyNetListener;

import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Yi on 16/3/17.
 */
public class SearchResultActivity extends BaseActivity implements VolleyNetListener {
    private static String content;
    private TextView keyWord, baike;
    private ListView listView;
    private SearchResultAdapter adapter;


    public static void jumpSearchResultActivity(Context context, String content) {
        Intent intent = new Intent(context, SearchResultActivity.class);
        context.startActivity(intent);
        SearchResultActivity.content = content;
    }

    @Override
    protected int setContent() {
        return R.layout.activity_search_result;
    }

    @Override
    protected void initView() {
        listView = bindView(R.id.search_result_listView);
    }

    @Override
    protected void initData() {

        keyWord = bindView(R.id.search_result_keyWord_tv);
        baike = bindView(R.id.search_result_baike_tv);
        String url = "http://c.m.163.com/search/comp/MA%3D%3D/20/" + content + ".html?deviceId=NjIxRUNGMzItQUUzMi00M0I5LTg3NkYtQkMxOTNDOUQ0REIy&version=NS41LjM%3D&channel=5aS05p2h";
        Log.d("SearchResultActivity", url);
        NetHelper netHelper = new NetHelper();
        netHelper.getInformationString(url, null, this);

    }

    @Override
    public void getSucceed(JSONObject jsonObject) {

    }

    @Override
    public void getSucceedString(String s) {
        Gson gson = new Gson();
        SearchResultBean bean = gson.fromJson(s, SearchResultBean.class);
        keyWord.setText(content);
        //服务器数据消失!!!
        baike.setText(bean.getBaike().getDigest());

        adapter = new SearchResultAdapter(this, bean);
        listView.setAdapter(adapter);
    }

    @Override
    public void getFailed(String s) {

    }

    @Override
    public void getSucceedArrayList(ArrayList arrayList) {

    }
}
