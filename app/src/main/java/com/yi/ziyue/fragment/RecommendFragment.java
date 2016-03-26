package com.yi.ziyue.fragment;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.yi.ziyue.R;
import com.yi.ziyue.activity.ReadContentActivity;
import com.yi.ziyue.adapter.NewsListViewAdapter;
import com.yi.ziyue.adapter.RecommendListAdapter;
import com.yi.ziyue.base.BaseFragment;
import com.yi.ziyue.beans.RecommendListBeans;
import com.yi.ziyue.net.NetHelper;
import com.yi.ziyue.net.VolleyNetListener;

import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Yi on 16/3/9.
 */
public class RecommendFragment extends BaseFragment implements VolleyNetListener<RecommendListBeans>, AdapterView.OnItemClickListener {
    private ListView listView;
    private RecommendListAdapter adapter;
    private ArrayList<RecommendListBeans> data = new ArrayList<>();

    @Override
    protected int setContent() {
        return R.layout.fragment_recommend;
    }

    @Override
    protected void initView() {
        listView = bindView(R.id.read_recommend_listview);
        listView.setOnItemClickListener(this);
    }

    @Override
    protected void initData() {

        NetHelper netHelper = new NetHelper();
        netHelper.getInfo(RECOMMEND_HEAD_URL, "推荐", RECOMMEND_END_URL, RecommendListBeans.class, this);

        String url = RECOMMEND_HEAD_URL + "推荐" + RECOMMEND_END_URL;
        Log.d("RecommendFragment", url);

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
    public void getSucceedArrayList(ArrayList<RecommendListBeans> recommendListBeanses) {
        data = recommendListBeanses;
        adapter = new RecommendListAdapter(recommendListBeanses);
        listView.setAdapter(adapter);
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        String docId = data.get(position).getDocid();
        Intent intent = new Intent(getContext(), ReadContentActivity.class);
        intent.putExtra("docId", docId);
        getContext().startActivity(intent);

       // ReadContentActivity.jumpReadContentActivity(getContext(), docId);
    }
}

