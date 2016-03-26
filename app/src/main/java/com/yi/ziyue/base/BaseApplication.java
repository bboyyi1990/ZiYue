package com.yi.ziyue.base;

import android.app.Application;
import android.content.Context;

import com.facebook.drawee.backends.pipeline.Fresco;

import cn.jpush.android.api.JPushInterface;

/**
 * Created by Yi on 16/3/2.
 */
public class BaseApplication extends Application {
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        Fresco.initialize(context);//千万别忘
        JPushInterface.init(this);
        JPushInterface.setDebugMode(true);

    }

    public static Context getContext() {
        return context;
    }


}
