package com.yi.ziyue.activity;

import android.content.Intent;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ViewFlipper;


import com.yi.ziyue.R;
import com.yi.ziyue.base.BaseActivity;

/**
 * Created by Yi on 16/3/2.
 */
public class GuideActivity extends BaseActivity {

    private ViewFlipper viewFlipper;
    private float startX = 0, endX = 0;//起始点位置对象


    @Override
    protected int setContent() {
        return R.layout.activity_guide;
    }

    @Override
    protected void initView() {

        viewFlipper = bindView(R.id.guide_flipper);
        setLeftAnimation();
        viewFlipper.startFlipping();//自动轮播方法
        viewFlipper.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                // ViewFlipper::showNext();  //显示下一个视图
                // ViewFlipper::showPrevious(); //显示上一个视图
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        startX = event.getX();
                        break;
                    case MotionEvent.ACTION_UP:
                        endX = event.getX();
                        if (startX - endX > 0) {
                            //左滑
                            setLeftAnimation();
                            viewFlipper.showNext();
                        } else if (startX == endX) {//点击跳转
                            Intent intent = new Intent(GuideActivity.this, MainActivity.class);
                            startActivity(intent);
                            finish();

                        } else {
                            //右滑
                            setRightAnimation();
                            viewFlipper.showPrevious();
                        }
                        break;
                }

                return true;

            }
        });
    }

    @Override
    protected void initData() {

    }


    public void setLeftAnimation() {
        viewFlipper.setInAnimation(AnimationUtils.loadAnimation(this,
                R.anim.push_left_in));
        viewFlipper.setOutAnimation(AnimationUtils.loadAnimation(this,
                R.anim.push_left_out));

    }

    public void setRightAnimation() {
        viewFlipper.setInAnimation(AnimationUtils.loadAnimation(this,
                R.anim.push_right_in));
        viewFlipper.setOutAnimation(AnimationUtils.loadAnimation(this,
                R.anim.push_right_out));

    }
}
