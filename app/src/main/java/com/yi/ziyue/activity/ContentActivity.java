package com.yi.ziyue.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.text.Spanned;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.yi.ziyue.R;
import com.yi.ziyue.base.BaseActivity;
import com.yi.ziyue.base.BaseApplication;
import com.yi.ziyue.beans.ContentBeans;
import com.yi.ziyue.beans.greendao.DaoSingleton;
import com.yi.ziyue.beans.greendao.Student;
import com.yi.ziyue.beans.greendao.StudentDao;
import com.yi.ziyue.net.NetHelper;
import com.yi.ziyue.net.VolleyNetListener;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

import java.util.ArrayList;
import java.util.List;

import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.onekeyshare.OnekeyShare;

/**
 * Created by Yi on 16/3/14.
 */
public class ContentActivity extends BaseActivity implements VolleyNetListener {

    private String postId;
    private String titles;
    private TextView textView;
    private Toolbar toolbar;
    private String content;
    private String url;

    @Override
    protected int setContent() {
        return R.layout.activity_content;

    }

    @Override
    protected void initView() {

        Intent intent = getIntent();
        String posid = intent.getStringExtra("postId");
        String tit = intent.getStringExtra("title");
        titles = tit;
        postId = posid;

        textView = bindView(R.id.content_textView);
        toolbar = bindView(R.id.content_toolBar);
        toolbar.setTitle(titles);
        toolbar.setBackgroundColor(Color.RED);
        toolbar.setNavigationIcon(R.mipmap.back);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ContentActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });


        url = "http://c.3g.163.com/nc/article/" + postId + "/full.html";

        NetHelper netHelper = new NetHelper();
        netHelper.getInformation(url, null, this);

    }

    @Override
    protected void initData() {

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.context_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.content_menu_collect:

                //把信息加入数据库 context , title;

                DaoSingleton daoSingleton = DaoSingleton.getInstance();
                StudentDao studentDao = daoSingleton.getPersonDao();


                Student student = new Student();
                student.setContent(content);
                student.setTitle(titles);
                //判断数据库里是否存在装标题内容的集合 如果集合为0则存入数据库.如果已经存在则不再次添加
                List<Student> data = studentDao.queryBuilder().where(StudentDao.Properties.Title.eq(student.getTitle())).list();
                if (data.size() == 0) {
                    studentDao.insert(student);
                    Toast.makeText(ContentActivity.this, "收藏成功", Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(ContentActivity.this, "收藏内容已经存在", Toast.LENGTH_SHORT).show();
                }


                break;

            case R.id.content_menu_share:

                showShare();//分享方法

                break;
        }

        return super.onOptionsItemSelected(item);
    }

    private void showShare() {

        ShareSDK.initSDK(this);
        OnekeyShare oks = new OnekeyShare();
        //关闭sso授权
        oks.disableSSOWhenAuthorize();

        // 分享时Notification的图标和文字  2.5.9以后的版本不调用此方法
        //oks.setNotification(R.drawable.ic_launcher, getString(R.string.app_name));
        // title标题，印象笔记、邮箱、信息、微信、人人网和QQ空间使用
        // oks.setTitle(getString(R.string.share));
        // titleUrl是标题的网络链接，仅在人人网和QQ空间使用
        oks.setTitleUrl(url);
        // text是分享文本，所有平台都需要这个字段
        oks.setText("我是分享文本");
        // imagePath是图片的本地路径，Linked-In以外的平台都支持此参数
        //oks.setImagePath("/sdcard/test.jpg");//确保SDcard下面存在此张图片
        // url仅在微信（包括好友和朋友圈）中使用
        oks.setUrl("http://sharesdk.cn");
        // comment是我对这条分享的评论，仅在人人网和QQ空间使用
        oks.setComment("我是测试评论文本");
        // site是分享此内容的网站名称，仅在QQ空间使用
        oks.setSite(getString(R.string.app_name));
        // siteUrl是分享此内容的网站地址，仅在QQ空间使用
        oks.setSiteUrl(url);
        // 启动分享GUI
        oks.show(this);
    }

    @Override
    public void getSucceed(JSONObject jsonObject) {

        try {
            JSONObject object = jsonObject.getJSONObject(postId);
            Gson gson = new Gson();
            ContentBeans bean = gson.fromJson(object.toString(), ContentBeans.class);
            content = bean.getBody();

            Spanned t = Html.fromHtml(content);
            textView.setText(t);

        } catch (JSONException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void getSucceedString(String s) {

    }

    @Override
    public void getFailed(String s) {

    }

    @Override
    public void getSucceedArrayList(ArrayList arrayList) {

    }
}