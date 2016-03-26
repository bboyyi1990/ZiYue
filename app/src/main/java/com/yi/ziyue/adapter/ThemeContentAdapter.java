package com.yi.ziyue.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.yi.ziyue.R;
import com.yi.ziyue.beans.ThemeContentBean;

/**
 * Created by Yi on 16/3/17.
 */
public class ThemeContentAdapter extends BaseAdapter {
    private ThemeContentBean bean;
    private Context context;

    public ThemeContentAdapter(ThemeContentBean bean, Context context) {
        this.bean = bean;
        this.context = context;
    }

    @Override
    public int getCount() {
        return bean.getData().getLatestList().size();
    }

    @Override
    public Object getItem(int position) {
        return bean.getData().getLatestList().get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ThemeContentViewHolder viewHolder = null;
        if (convertView == null) {
            viewHolder = new ThemeContentViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.theme_content_listview, null);
            viewHolder.questionUserHeadPicture = (SimpleDraweeView) convertView.findViewById(R.id.item_theme_content_userHeadPicUrl);
            viewHolder.answerUserHeadPicture = (SimpleDraweeView) convertView.findViewById(R.id.item_theme_content_answerHeadPicUrl);
            viewHolder.questionTv = (TextView) convertView.findViewById(R.id.item_theme_content_question_tv);
            viewHolder.answerUserNameTv = (TextView) convertView.findViewById(R.id.item_theme_content_answer_usename_tv);
            viewHolder.answerContentTv = (TextView) convertView.findViewById(R.id.item_theme_content_answer_content_tv);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ThemeContentViewHolder) convertView.getTag();
        }

        viewHolder.questionUserHeadPicture.setImageURI(Uri.parse(bean.getData().getLatestList().get(position).getQuestion().getUserHeadPicUrl()));
        viewHolder.answerUserHeadPicture.setImageURI(Uri.parse(bean.getData().getLatestList().get(position).getAnswer().getSpecialistHeadPicUrl()));
        viewHolder.questionTv.setText(bean.getData().getLatestList().get(position).getQuestion().getContent());
        viewHolder.answerUserNameTv.setText(bean.getData().getLatestList().get(position).getAnswer().getSpecialistName());
        viewHolder.answerContentTv.setText(bean.getData().getLatestList().get(position).getAnswer().getContent());
        return convertView;
    }

   private class ThemeContentViewHolder {
        SimpleDraweeView questionUserHeadPicture, answerUserHeadPicture;
        TextView questionTv, answerUserNameTv, answerContentTv,time;

    }
}
