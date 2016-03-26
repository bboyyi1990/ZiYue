package com.yi.ziyue.activity;

import android.widget.ListView;

import com.google.gson.Gson;
import com.yi.ziyue.R;
import com.yi.ziyue.adapter.RadioAdapter;
import com.yi.ziyue.base.BaseActivity;
import com.yi.ziyue.beans.RadioBean;
import com.yi.ziyue.net.NetHelper;
import com.yi.ziyue.net.VolleyNetListener;

import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Yi on 16/3/17.
 */
public class RadioActivity extends BaseActivity implements VolleyNetListener {
    private ListView listView;
    private RadioAdapter adapter;

    @Override
    protected int setContent() {
        return R.layout.activity_radio;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        listView = bindView(R.id.radio_listView);

        NetHelper netHelper = new NetHelper();
        netHelper.getInformationString(RADIO_URL, null, this);
    }

    @Override
    public void getSucceed(JSONObject jsonObject) {

    }

    @Override
    public void getSucceedString(String s) {

        Gson gson = new Gson();
        RadioBean bean = gson.fromJson(s, RadioBean.class);
        adapter = new RadioAdapter(this, bean);
        listView.setAdapter(adapter);


    }

    @Override
    public void getFailed(String s) {

    }

    @Override
    public void getSucceedArrayList(ArrayList arrayList) {

    }
}
