package com.yi.ziyue.activity;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.yi.ziyue.R;
import com.yi.ziyue.beans.greendao.DaoMaster;
import com.yi.ziyue.beans.greendao.DaoSession;
import com.yi.ziyue.beans.greendao.DaoSingleton;
import com.yi.ziyue.beans.greendao.Student;
import com.yi.ziyue.beans.greendao.StudentDao;

import java.util.List;

/**
 * Created by Yi on 16/3/14.
 */
public class TestActivity extends AppCompatActivity {
    /**
     * 省略一些控件的声明
     */
    // 数据库
    private SQLiteDatabase db;
    // 管理者
    private DaoMaster mDaoMaster;
    // 会话
    private DaoSession mDaoSession;
    // 对应的表,由java代码生成的,对数据库内相应的表操作使用此对象
    private StudentDao studentDao;

    private DaoSingleton singleton = DaoSingleton.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_activity);

        initDatabase();

    }

    private void initDatabase() {

        // 初始化就这个顺序,记着吧 ^_^
        // 此DevOpenHelper类继承自SQLiteOpenHelper,第一个参数Context,第二个参数数据库名字,第三个参数CursorFactory
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "daodemo.db", null);
        db = helper.getWritableDatabase();
        mDaoMaster = new DaoMaster(db);
        mDaoSession = mDaoMaster.newSession();
        studentDao = mDaoSession.getStudentDao();


        studentDao.deleteAll();
//        studentDao.insert(new Student((long) 1, "标题", "内容"));
//        studentDao.insert(new Student((long) 2, "第二个数据标题", "第二条数据的内容"));
        List<Student> queryList = studentDao.queryBuilder().list();
        long id = studentDao.getKey(new Student((long) 2));

        studentDao.insertOrReplaceInTx();

        Log.d("!!!!!!", "id:" + id);
        Log.e("-----", queryList.size() + "");

    }
}
