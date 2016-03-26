package com.yi.ziyue.base;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by Yi on 16/3/19.
 */
public abstract class ListViewBaseAdapter<T> extends BaseAdapter {

    protected Context context;
    protected List<T> list;

    public ListViewBaseAdapter(Context context, List<T> list) {
        this.context = context;
        this.list = list;


    }

    public void addData(List<T> list) {
        this.list = list;
        notifyDataSetChanged();
    }

//    private boolean isLenght() {
//        return;
//    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public T getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    protected abstract int getItemResource();

    protected abstract View getItemView(int position, ViewHolder holder, View convertView);


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(getItemResource(), null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        return getItemView(position, holder, convertView);
    }

    protected class ViewHolder {
        private SparseArray<View> views = new SparseArray<>();
        private View convertView;

        public ViewHolder(View convertView) {
            this.convertView = convertView;
        }


        public <T extends View> T getView(int resId) {
            View view = views.get(resId);
            if (view == null) {
                view = convertView.findViewById(resId);
                views.put(resId, view);
            }
            return (T) view;
        }
    }
}
