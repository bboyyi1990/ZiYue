package com.yi.ziyue.activity;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.yi.ziyue.R;
import com.yi.ziyue.base.BaseActivity;

import java.util.HashMap;

import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.tencent.qzone.QZone;

/**
 * Created by Yi on 16/3/15.
 */
public class LoginActivity extends BaseActivity implements View.OnClickListener {

    private ImageView qqLogin, xinlangLogin, back;
    public static final int RESULT_CODE = 7758;


    @Override
    protected int setContent() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView() {
        back = bindView(R.id.login_back);
        back.setOnClickListener(this);
        qqLogin = bindView(R.id.qq_login_imageView);
        xinlangLogin = bindView(R.id.xinlang_login_imageView);
        qqLogin.setOnClickListener(this);
        xinlangLogin.setOnClickListener(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.qq_login_imageView:

                //第三方登录
                ShareSDK.initSDK(v.getContext());
                Platform platform = ShareSDK.getPlatform(QZone.NAME);
                if (platform.isAuthValid()) {
                    platform.removeAccount();
                }
                platform.setPlatformActionListener(new PlatformActionListener() {
                    @Override
                    public void onComplete(Platform platform, int i, HashMap<String, Object> hashMap) {
                        //在这里获取用户名和头像

                        String head = platform.getDb().getUserIcon();//获取的头像是 URL 的头像地址
                        String name = platform.getDb().getUserName();

                        // 把第三方登录的用户名和头像 String 类型的 URL 传递回我页面
                        //带返回码的跳转传值
                        Intent intent = new Intent();
                        intent.putExtra("name", name);
                        intent.putExtra("head", head);
                        setResult(RESULT_CODE, intent);
                        finish(); // 不打的话没有跳转

                    }

                    @Override
                    public void onError(Platform platform, int i, Throwable throwable) {

                    }

                    @Override
                    public void onCancel(Platform platform, int i) {


                    }
                });

                platform.SSOSetting(false);
                platform.showUser(null);


                break;
            case R.id.xinlang_login_imageView:


                break;

            case R.id.login_back:
                finish();
                break;
        }
    }
}
