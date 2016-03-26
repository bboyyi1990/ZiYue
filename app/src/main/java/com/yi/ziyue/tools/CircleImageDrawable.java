package com.yi.ziyue.tools;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;

/**
 * Created by Yi on 16/3/12.
 */
public class CircleImageDrawable extends Drawable {

    private Paint paint;//画笔
    private Bitmap bitmap;//画布
    private int mWidth;//图片的宽度

    public CircleImageDrawable(Bitmap bitmap) {
        //初始化属性
        this.bitmap = bitmap;
        paint = new Paint();
        //构建一个 sharde 对象把画笔和图片绑定的作用
        BitmapShader shader = new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        paint.setShader(shader);
        //数学计算公式 Math  得到图片的宽高最小值
        mWidth = Math.min(bitmap.getWidth(), bitmap.getHeight());
    }

    @Override
    public void draw(Canvas canvas) {
        //画一个圆,                      圆心 半径 画笔
        canvas.drawCircle(mWidth / 2, mWidth / 2, mWidth / 2, paint);


    }

    @Override//设置透明度
    public void setAlpha(int alpha) {
        paint.setAlpha(alpha);
    }

    @Override//设置滤镜
    public void setColorFilter(ColorFilter colorFilter) {
        paint.setColorFilter(colorFilter);
    }

    @Override //设置透明度,这个方法 return 的没有明显的区别
    public int getOpacity() {
        return PixelFormat.TRANSLUCENT;
    }

    //这里还需要手动复写得到图片的宽高方法
    @Override
    public int getIntrinsicWidth() {
        return mWidth;
    }

    //!!!还要复写返回高方法
    @Override
    public int getIntrinsicHeight() {
        return mWidth;
    }

}
