package com.yi.ziyue.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.yi.ziyue.R;
import com.yi.ziyue.base.BaseApplication;
import com.yi.ziyue.beans.SeeBean;

/**
 * Created by Yi on 16/3/11.
 */
public class SeeAdapter extends RecyclerView.Adapter<SeeAdapter.SeeViewHolder> {
    private SeeBean seeBean;
    private Context context;

    public SeeAdapter(SeeBean seeBean, Context context) {
        this.seeBean = seeBean;
        this.context = context;
    }

    @Override
    public SeeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new SeeViewHolder(LayoutInflater.from(BaseApplication.getContext()).inflate(R.layout.recyclerview_see, parent, false));
    }

    @Override
    public void onBindViewHolder(final SeeViewHolder holder, int position) {
        // videoView 需要一个系统管理者  系统的管理者与绑定
        holder.videoView.setVideoURI(Uri.parse(seeBean.getVideoList().get(position).getMp4_url()));
        MediaController mediaController = new MediaController(context);//控制进度条
        holder.videoView.setMediaController(mediaController);
        holder.videoView.requestFocus();//获得焦点
        // holder.videoView.start();//自动播放

        holder.title.setText(seeBean.getVideoList().get(position).getTitle());
        holder.description.setText(seeBean.getVideoList().get(position).getDescription());
        holder.lenght.setText(String.valueOf(seeBean.getVideoList().get(position).getLength()) + "s");
        holder.playCount.setText(String.valueOf(seeBean.getVideoList().get(position).getPlayCount()) + "次");
        holder.simpleDraweeView.setImageURI(Uri.parse(seeBean.getVideoList().get(position).getCover()));//设置默认显示图片
        holder.simpleDraweeView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.simpleDraweeView.setVisibility(View.INVISIBLE);
            }
        });
    }

    @Override
    public int getItemCount() {
        return seeBean.getVideoList().size();
    }

    class SeeViewHolder extends RecyclerView.ViewHolder {
        VideoView videoView;
        TextView title, description, lenght, playCount;
        SimpleDraweeView simpleDraweeView;


        public SeeViewHolder(View itemView) {
            super(itemView);
            videoView = (VideoView) itemView.findViewById(R.id.see_videoview);
            title = (TextView) itemView.findViewById(R.id.see_title_tv);
            description = (TextView) itemView.findViewById(R.id.see_description_tv);
            lenght = (TextView) itemView.findViewById(R.id.see_length_tv);
            playCount = (TextView) itemView.findViewById(R.id.see_playCount);
            simpleDraweeView = (SimpleDraweeView) itemView.findViewById(R.id.see_simpleDraweeView);
        }
    }
}
