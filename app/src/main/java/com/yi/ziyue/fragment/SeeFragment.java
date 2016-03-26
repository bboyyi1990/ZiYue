package com.yi.ziyue.fragment;

import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.google.gson.Gson;
import com.yi.ziyue.R;
import com.yi.ziyue.adapter.SeeAdapter;
import com.yi.ziyue.base.BaseFragment;
import com.yi.ziyue.beans.SeeBean;
import com.yi.ziyue.net.NetHelper;
import com.yi.ziyue.net.VolleyNetListener;

import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Yi on 16/3/11.
 */
public class SeeFragment extends BaseFragment implements VolleyNetListener {

    private RecyclerView recyclerView;
    private SeeAdapter adapter;


    @Override
    protected int setContent() {
        return R.layout.fragment_see;
    }

    @Override
    protected void initView() {
        recyclerView = bindView(R.id.see_recyclerView);

        LinearLayoutManager gm = new LinearLayoutManager(getActivity());
        gm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(gm);
    }

    @Override
    protected void initData() {
        NetHelper netHelper = new NetHelper();
        netHelper.getInformationString(SEE_URL, null, this);
    }

    @Override
    public void getSucceed(JSONObject jsonObject) {

    }

    @Override
    public void getSucceedString(String s) {
        Gson gson = new Gson();
        SeeBean seeBean = gson.fromJson(s, SeeBean.class);

        adapter = new SeeAdapter(seeBean, getContext());
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void getFailed(String s) {

    }

    @Override
    public void getSucceedArrayList(ArrayList arrayList) {

    }
}
