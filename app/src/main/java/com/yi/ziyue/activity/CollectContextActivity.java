package com.yi.ziyue.activity;

import android.content.Context;
import android.content.Intent;
import android.text.Html;
import android.text.Spanned;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.yi.ziyue.R;
import com.yi.ziyue.base.BaseActivity;

/**
 * Created by Yi on 16/3/16.
 */
public class CollectContextActivity extends BaseActivity {

    private ImageView backIv;
    private TextView title, content;
    private String titles, contents;

    @Override
    protected int setContent() {
        return R.layout.activity_collect_context;
    }

    @Override
    protected void initView() {

        Intent intent = getIntent();
        titles = intent.getStringExtra("titl");
        contents = intent.getStringExtra("conte");

        backIv = bindView(R.id.collect_content_back_imageView);
        backIv.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                finish();
            }
        });

        title = bindView(R.id.collect_content_title_text);
        content = bindView(R.id.collect_content_content_text);
        title.setText(titles);
        Spanned t = Html.fromHtml(contents);
        content.setText(t);
    }

    @Override
    protected void initData() {

    }


}
