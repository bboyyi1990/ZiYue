package com.yi.ziyue.beans.greendao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.yi.ziyue.base.BaseApplication;

/**
 * Created by Yi on 16/3/14.
 */
public class DaoSingleton {

    private static final String DATABASE_NAME = "daodemo.db";

    private volatile static DaoSingleton instance;

    private SQLiteDatabase db;
    private DaoMaster daoMaster;
    private DaoSession daoSession;
    private Context context;
    private DaoMaster.DevOpenHelper helper;
    private StudentDao personDao;

    private DaoSingleton() {
        context = BaseApplication.getContext();
    }

    public static DaoSingleton getInstance() {
        if (instance == null) {
            synchronized (DaoSingleton.class) {
                if (instance == null) {
                    instance = new DaoSingleton();
                }
            }
        }
        return instance;
    }

    public DaoMaster.DevOpenHelper getHelper() {
        if (helper == null) {
            helper = new DaoMaster.DevOpenHelper(context, DATABASE_NAME, null);
        }
        return helper;
    }

    private SQLiteDatabase getDb() {
        if (db == null) {
            db = getHelper().getWritableDatabase();
        }
        return db;
    }

    private DaoMaster getDaoMaster() {
        if (daoMaster == null) {
            daoMaster = new DaoMaster(getDb());
        }
        return daoMaster;
    }

    public DaoSession getDaoSession() {
        if (daoSession == null) {
            daoSession = getDaoMaster().newSession();
        }
        return daoSession;
    }

    public StudentDao getPersonDao() {
        if (personDao == null) {
            personDao = getDaoSession().getStudentDao();
        }
        return personDao;
    }
}
