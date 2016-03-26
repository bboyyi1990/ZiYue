package com.yi.ziyue.activity;

import android.content.Intent;
import android.content.SharedPreferences;

import com.yi.ziyue.R;
import com.yi.ziyue.base.BaseActivity;
import com.yi.ziyue.base.BaseApplication;

/**
 * Created by Yi on 16/3/2.
 */
public class WelcomeActivity extends BaseActivity {


    @Override
    protected int setContent() {
        return R.layout.activity_welcome;
    }

    @Override
    protected void initView() {
        SharedPreferences sharedPreferences = getSharedPreferences("welcome", MODE_PRIVATE);
        if (sharedPreferences.getBoolean("isFirst", true)) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(2000);
                        Intent intent = new Intent(BaseApplication.getContext(), GuideActivity.class);
                        startActivity(intent);
                        finish();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();

            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putBoolean("isFirst", false);
            editor.commit();
        } else {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(2000);
                        Intent intent = new Intent(BaseApplication.getContext(), MainActivity.class);
                        startActivity(intent);
                        finish();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }

    }

    @Override
    protected void initData() {

    }
}
