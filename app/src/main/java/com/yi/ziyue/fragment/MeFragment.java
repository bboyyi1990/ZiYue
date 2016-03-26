package com.yi.ziyue.fragment;

import android.content.Intent;
import android.content.res.Resources;
import android.gesture.Gesture;
import android.gesture.GestureLibraries;
import android.gesture.GestureLibrary;
import android.gesture.GestureOverlayView;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.qr_codescan.MipcaActivityCapture;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import com.yi.ziyue.BuildConfig;
import com.yi.ziyue.R;
import com.yi.ziyue.activity.CollectActivity;
import com.yi.ziyue.activity.LoginActivity;
import com.yi.ziyue.activity.RadioActivity;
import com.yi.ziyue.base.BaseFragment;
import com.yi.ziyue.tools.CircleImageDrawable;

import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * Created by Yi on 16/3/3.
 */
public class MeFragment extends BaseFragment {
    private final static int SCANNIN_GREQUEST_CODE = 1;
    private TextView textView, resultTv;
    private ImageView resultIv;
    public static final int REQUEST_CODE = 10086;//跳转传值请求码
    public static final int PHOTO_REQUEST_CODE = 120;//图片请求码
    private String name;
    private String headURL;
    private SimpleDraweeView headSimpleView;
    private LinearLayout linearLayoutCollect, linearLayoutRadio, linearLayoutScan;

    @Override
    protected int setContent() {
        return R.layout.fragment_me;
    }


    @Override
    protected void initView() {
        resultIv = bindView(R.id.scan_result_iv);
        resultTv = bindView(R.id.scan_result_tv);
        linearLayoutRadio = bindView(R.id.me_layout_radio);
        linearLayoutRadio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), RadioActivity.class);
                startActivity(intent);
            }
        });
        linearLayoutCollect = bindView(R.id.me_layout_collect);

        linearLayoutCollect.setOnClickListener(new View.OnClickListener() {
            @Override//跳转收藏页
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), CollectActivity.class);
                startActivity(intent);
            }
        });
        headSimpleView = bindView(R.id.me_headPicture_SimpleDraweeView);
        textView = bindView(R.id.login_textView);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivityForResult(intent, REQUEST_CODE);

            }
        });

        linearLayoutScan = bindView(R.id.scan_layout);
        linearLayoutScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(), MipcaActivityCapture.class);
                startActivityForResult(intent, SCANNIN_GREQUEST_CODE);

            }
        });


//     圆形图片方法
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.head_picture_back);
        CircleImageDrawable circleImageView = new CircleImageDrawable(bitmap);
        headSimpleView.setImageDrawable(circleImageView);

        //点击图获取系统的 uri
        headSimpleView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.addCategory(Intent.CATEGORY_OPENABLE);
                intent.setType("image/*");
                //判读不同 sdk 版本号 获取不同的 Action
                if (Build.VERSION.SDK_INT < 19) {
                    intent.setAction(Intent.ACTION_GET_CONTENT);
                } else {
                    intent.setAction(Intent.ACTION_OPEN_DOCUMENT);
                }
                startActivityForResult(intent, PHOTO_REQUEST_CODE);

            }
        });

    }

    @Override
    protected void initData() {

    }

    //接收返回值方法
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE && resultCode == 7758) {

            name = data.getStringExtra("name");
            headURL = data.getStringExtra("head");
            textView.setText(name);
            GenericDraweeHierarchy hierarchy = GenericDraweeHierarchyBuilder.newInstance(Resources.getSystem()).setRoundingParams(RoundingParams.asCircle()).build();
            headSimpleView.setHierarchy(hierarchy);
            headSimpleView.setImageURI(Uri.parse(headURL));

        } else if (requestCode == SCANNIN_GREQUEST_CODE && resultCode == MipcaActivityCapture.RESULT_OK) {

            Bundle bundle = data.getExtras();
            String result = bundle.getString("result");
            Bitmap bitmap = bundle.getParcelable("bitmap");
            Log.d("&&&&&&&", result);
            resultTv.setText(result);
            resultIv.setImageBitmap(bitmap);
        } else if (requestCode == PHOTO_REQUEST_CODE) {
            Uri uri = data.getData();
            InputStream inputStream = null;
            try {
                //使用内容提供者获取图片
                inputStream = getContext().getContentResolver().openInputStream(uri);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
            CircleImageDrawable circleImageView = new CircleImageDrawable(bitmap);
            headSimpleView.setImageDrawable(circleImageView);
        }
    }
}