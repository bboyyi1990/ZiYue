package com.yi.ziyue.base;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

/**
 * Created by Yi on 16/3/19.
 *
 */
public abstract class BaseRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    public enum Type {
        ITEM_TYPE_HEADER,
        ITEM_TYPE_CONTENT,
        ITEM_TYPE_BOTTOM
    }

    public int headerItemCount;//头行布局数目
    public int bottomItemCount;//尾行布局数目

    //set 方法
    public void setHeaderItemCount(int headerItemCount) {
        this.headerItemCount = headerItemCount;
    }

    public void setBottomItemCount(int bottomItemCount) {
        this.bottomItemCount = bottomItemCount;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return headerItemCount + bottomItemCount;
    }

    protected abstract int getContentItemCount();

    public boolean isHeaderView(int position) {
        return headerItemCount != 0 && position < headerItemCount;
    }

    public boolean isBottomView(int position) {
        return bottomItemCount != 0 && position >= getContentItemCount() + headerItemCount;
    }


    @Override
    public int getItemViewType(int position) {


        int dataItemCount = getContentItemCount();
        if (headerItemCount != 0 && position < headerItemCount) {
            return Type.ITEM_TYPE_HEADER.ordinal();
        } else if (bottomItemCount != 0 && position < headerItemCount) {
            return Type.ITEM_TYPE_BOTTOM.ordinal();
        } else {
            return Type.ITEM_TYPE_CONTENT.ordinal();
        }


    }
}
