package com.yi.ziyue.adapter;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import com.yi.ziyue.R;
import com.yi.ziyue.activity.ThemeContentActivity;
import com.yi.ziyue.base.BaseApplication;
import com.yi.ziyue.beans.ThemeBean;

/**
 * Created by Yi on 16/3/11.
 */
public class ThemeAdapter extends RecyclerView.Adapter<ThemeAdapter.ThemeViewHolder> {
    private ThemeBean themeBean;
    private Context context;

    public ThemeAdapter(ThemeBean themeBean, Context context) {
        this.themeBean = themeBean;
        this.context = context;
    }

    @Override
    public ThemeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ThemeViewHolder(LayoutInflater.from(BaseApplication.getContext()).inflate(R.layout.recyclerview_theme, parent, false));
    }

    @Override
    public void onBindViewHolder(ThemeViewHolder holder, int position) {
        holder.picture.setImageURI(Uri.parse(themeBean.getData().getExpertList().get(position).getPicurl()));
        holder.name.setText(themeBean.getData().getExpertList().get(position).getName());
        holder.title.setText(themeBean.getData().getExpertList().get(position).getTitle());
        holder.alias.setText(themeBean.getData().getExpertList().get(position).getAlias());
        holder.classification.setText(themeBean.getData().getExpertList().get(position).getClassification());
        holder.concernCount.setText(String.valueOf(themeBean.getData().getExpertList().get(position).getConcernCount()) + "关注");
        holder.questionCount.setText(String.valueOf(themeBean.getData().getExpertList().get(position).getQuestionCount()) + "提问");
        holder.position = position;
        //设置图片是圆形图片
        GenericDraweeHierarchy hierarchy = GenericDraweeHierarchyBuilder.newInstance(Resources.getSystem()).setRoundingParams(RoundingParams.asCircle()).build();
        holder.headPicture.setHierarchy(hierarchy);
        holder.headPicture.setImageURI(Uri.parse(themeBean.getData().getExpertList().get(position).getHeadpicurl()));

    }

    @Override
    public int getItemCount() {
        return themeBean.getData().getExpertList().size();
    }

    //缓存类
    public class ThemeViewHolder extends RecyclerView.ViewHolder {
        SimpleDraweeView picture;
        TextView name, title, alias, classification, questionCount, concernCount;
        SimpleDraweeView headPicture;
        LinearLayout linearLayout;
        int position;

        public ThemeViewHolder(View itemView) {
            super(itemView);
            headPicture = (SimpleDraweeView) itemView.findViewById(R.id.theme_recyclerView_cardView_picurl);
            picture = (SimpleDraweeView) itemView.findViewById(R.id.theme_recyclerView_cardView_headPicurl);
            name = (TextView) itemView.findViewById(R.id.theme_recyclerView_cardView_name_tv);
            title = (TextView) itemView.findViewById(R.id.theme_recyclerView_cardView_title_tv);
            alias = (TextView) itemView.findViewById(R.id.theme_recyclerView_cardView_alias_tv);
            classification = (TextView) itemView.findViewById(R.id.theme_recyclerView_cardView_classification_tv);
            questionCount = (TextView) itemView.findViewById(R.id.theme_recyclerView_cardView_questionCount_tv);
            concernCount = (TextView) itemView.findViewById(R.id.theme_recyclerView_cardView_concernCount);
            linearLayout = (LinearLayout) itemView.findViewById(R.id.theme_recyclerView_LinearLayout);

            //行布局监听
            linearLayout.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    String id = themeBean.getData().getExpertList().get(position).getExpertId();
                    String alias = themeBean.getData().getExpertList().get(position).getAlias();
                    String title = String.valueOf(themeBean.getData().getExpertList().get(position).getConcernCount());
                    Intent intent = new Intent(context, ThemeContentActivity.class);
                    intent.putExtra("id", id);
                    intent.putExtra("alias", alias);
                    intent.putExtra("title", title);
                    context.startActivity(intent);
                }
            });
        }
    }
}
