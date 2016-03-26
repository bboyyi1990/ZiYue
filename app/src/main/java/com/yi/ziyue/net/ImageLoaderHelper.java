package com.yi.ziyue.net;


import android.graphics.Bitmap;
import android.widget.ImageView;


import com.nostra13.universalimageloader.core.DisplayImageOptions;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.yi.ziyue.R;
import com.yi.ziyue.base.BaseApplication;

/**
 * Created by wyc on 16/3/5.
 */
public class ImageLoaderHelper {

    public static final int IMG_LOAD_DELAY = 200;
    private static ImageLoaderHelper imageLoaderHelper;
    private ImageLoader imageLoader;
    // 显示图片的设置
    private DisplayImageOptions options;

    public static ImageLoaderHelper getInstance() {

        if (imageLoaderHelper == null)
            imageLoaderHelper = new ImageLoaderHelper();
        return imageLoaderHelper;
    }

    public ImageLoaderHelper() {
        init();
    }

    /**
     * 配置 imagloader 基本信息
     */
    private void init() {
        options = new DisplayImageOptions.Builder()
                .showStubImage(R.mipmap.eee)
                .showImageForEmptyUri(R.mipmap.eee)
                .showImageOnFail(R.mipmap.eee)
                .delayBeforeLoading(IMG_LOAD_DELAY)
                .cacheInMemory(true)
                .cacheOnDisc(true)
                .bitmapConfig(Bitmap.Config.RGB_565)     //设置图片的解码类型
                .build();
        imageLoader = ImageLoader.getInstance();
        imageLoader.init(ImageLoaderConfiguration.createDefault(BaseApplication.getContext()));
    }

    /**
     * 加载图片
     *
     * @param url
     * @param imageView
     */
    public void loadImage(String url, ImageView imageView) {
        url = url.trim();
        imageLoader.displayImage(url, imageView, options);
    }


}
