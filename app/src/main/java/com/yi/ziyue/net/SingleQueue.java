package com.yi.ziyue.net;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.yi.ziyue.base.BaseApplication;

/**
 * Created by Yi on 16/3/4.
 */
public class SingleQueue {

    private static SingleQueue singleQueue;
    private RequestQueue queue;

    private SingleQueue() {

        queue = Volley.newRequestQueue(BaseApplication.getContext());

    }

    public RequestQueue getQueue() {
        return queue;
    }

    public static SingleQueue getInstance() {
        if (singleQueue == null) {
            //synchronizd 能保证大括号的内部只有一个线程
            synchronized (SingleQueue.class) { //判断这个类里只有一个线程,判断()里是一个类
                if (singleQueue == null) {
                    singleQueue = new SingleQueue();
                }
            }
        }

        return singleQueue;
    }

    //还可以使用静态内部类的方式在静态内部类里获取本类对象,再对外通过静态内部类调用出本类对象





}
