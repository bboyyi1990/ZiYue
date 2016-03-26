package com.yi.ziyue.fragment;

import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.google.gson.Gson;
import com.yi.ziyue.BuildConfig;
import com.yi.ziyue.R;
import com.yi.ziyue.adapter.ThemeAdapter;
import com.yi.ziyue.base.BaseActivity;
import com.yi.ziyue.base.BaseFragment;
import com.yi.ziyue.beans.ThemeBean;
import com.yi.ziyue.net.NetHelper;
import com.yi.ziyue.net.VolleyNetListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Yi on 16/3/3.
 */
public class ThemeFragment extends BaseFragment implements VolleyNetListener<ThemeBean> {
    private RecyclerView recyclerView;
    private ThemeAdapter adapter;

    @Override
    protected int setContent() {
        return R.layout.fragment_theme;
    }

    @Override
    protected void initView() {
        recyclerView = bindView(R.id.theme_recyclerView);

        LinearLayoutManager gm = new LinearLayoutManager(getActivity());
        gm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(gm);
    }

    @Override
    protected void initData() {
        NetHelper netHelper = new NetHelper();
        netHelper.getInformationString(THEME_URL, null, this);
    }

    @Override
    public void getSucceed(JSONObject jsonObject) {

    }

    @Override
    public void getSucceedString(String s) {

        Gson gson = new Gson();
        ThemeBean themeBean = gson.fromJson(s, ThemeBean.class);
        //初始化适配器把实体类传过去
        adapter = new ThemeAdapter(themeBean, getContext());
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void getFailed(String s) {

    }

    @Override
    public void getSucceedArrayList(ArrayList<ThemeBean> themeBeans) {

    }


}
