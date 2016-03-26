package com.yi.ziyue.receiver;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.graphics.BitmapFactory;
import android.os.Binder;
import android.os.IBinder;

import com.yi.ziyue.R;
import com.yi.ziyue.service.WeatherService;

import de.greenrobot.event.EventBus;


/**
 * Created by Yi on 16/3/22.
 */
public class WeatherBroadCastReceiver extends BroadcastReceiver {

    private Binder binder;
    private ServiceConnection connection;
    private Boolean isRun = true;


    @Override
    public void onReceive(Context context, Intent intent) {

        showNotify(context);//弹出通知
        // bindWeatherService(context);

        //TODO send eventBus to (Main Activity)change the judge whether service stop
        //EventBus.getDefault().post(isRun);
        isRun = !isRun;
    }

    private void bindWeatherService(Context context) {


        connection = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                binder = (Binder) service;
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {
                binder = null;
            }
        };
        Intent intent = new Intent(context, WeatherService.class);

        if (isRun) {
            context.bindService(intent, connection, Context.BIND_AUTO_CREATE);

            isRun = !isRun;
        } else {
            context.unbindService(connection);
        }
    }

    private void showNotify(Context context) {

        Notification.Builder builder = new Notification.Builder(context);
        builder.setLargeIcon(BitmapFactory.decodeResource(context.getResources(), R.mipmap.eee));
        builder.setSmallIcon(R.mipmap.eee);
        builder.setContentTitle("子曰:").setContentText("背景音乐状态改变");

        builder.setAutoCancel(true);//设置点击一次通知自动消失

        //通过 bulder 建立一个对象
        Notification notification = builder.build();
        //获取Notification 对象
        NotificationManager manager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(0, notification);
    }
}
