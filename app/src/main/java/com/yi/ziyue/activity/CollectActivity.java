package com.yi.ziyue.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.yi.ziyue.R;
import com.yi.ziyue.adapter.CollectAdapter;
import com.yi.ziyue.base.BaseActivity;

/**
 * Created by Yi on 16/3/16.
 */
public class CollectActivity extends BaseActivity {

    private ImageView backIv;
    private RecyclerView recyclerView;
    private CollectAdapter adapter;

    @Override
    protected int setContent() {
        return R.layout.activity_collect;
    }

    @Override
    protected void initView() {
        recyclerView = bindView(R.id.collect_recyclerView);
        LinearLayoutManager gm = new LinearLayoutManager(this);
        gm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(gm);

        adapter = new CollectAdapter(this);

        recyclerView.setAdapter(adapter);

        backIv = bindView(R.id.collect_back_imageView);
        backIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    protected void initData() {


    }
}
