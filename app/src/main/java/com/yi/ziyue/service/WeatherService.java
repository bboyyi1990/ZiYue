package com.yi.ziyue.service;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.provider.MediaStore;
import android.support.annotation.Nullable;

import com.yi.ziyue.R;

/**
 * Created by Yi on 16/3/18.
 */
public class WeatherService extends Service {

    private MediaPlayer player;
    private WeatherBinder binder = new WeatherBinder();

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {


        player = MediaPlayer.create(this, R.raw.weather_voice);
        player.start();

        return super.onStartCommand(intent, flags, startId);

    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }


    public class WeatherBinder extends Binder {

    }

    @Override
    public void onDestroy() {
        player.stop();
        super.onDestroy();


    }
}


