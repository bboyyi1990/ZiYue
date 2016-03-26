package com.yi.ziyue.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.text.Spanned;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import com.yi.ziyue.R;
import com.yi.ziyue.activity.CollectContextActivity;
import com.yi.ziyue.base.BaseApplication;
import com.yi.ziyue.beans.greendao.DaoSingleton;
import com.yi.ziyue.beans.greendao.Student;
import com.yi.ziyue.beans.greendao.StudentDao;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yi on 16/3/16.
 */
public class CollectAdapter extends RecyclerView.Adapter<CollectAdapter.CollectViewHolder> {

    private DaoSingleton daoSingleton = DaoSingleton.getInstance();
    private StudentDao studentDao = daoSingleton.getPersonDao();
    private List<Student> data = new ArrayList<>();
    private Context context;

    public CollectAdapter(Context context) {
        this.context = context;
        data = studentDao.queryBuilder().list();

    }

    @Override
    public CollectViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new CollectViewHolder(LayoutInflater.from(context).inflate(R.layout.collect_recyelerview, parent, false));
    }

    @Override
    public void onBindViewHolder(CollectViewHolder holder, int position) {
        holder.title.setText(data.get(position).getTitle());
        String cont = data.get(position).getContent();
        Spanned t = Html.fromHtml(cont);
        holder.content.setText(t);
        holder.position = position;


    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class CollectViewHolder extends RecyclerView.ViewHolder {

        TextView title, content;
        RatingBar ratingBar;
        LinearLayout linearLayout;
        int position;

        public CollectViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.collect_RecyclerView_title);
            content = (TextView) itemView.findViewById(R.id.collect_recyclerView_content);
            ratingBar = (RatingBar) itemView.findViewById(R.id.collect_RatingBra);
            ratingBar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //TODO ratingBar set listener to save the value

                }
            });

            linearLayout = (LinearLayout) itemView.findViewById(R.id.collect_recyclerView_linearLayout);

            linearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String titl = data.get(position).getTitle();
                    String conte = data.get(position).getContent();

                    Intent intent = new Intent(context, CollectContextActivity.class);
                    intent.putExtra("titl", titl);
                    intent.putExtra("conte", conte);
                    context.startActivity(intent);

                }
            });


            linearLayout.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {

                    studentDao.delete(data.get(position));
                    data = studentDao.queryBuilder().list();
                    notifyDataSetChanged();

                    return false;
                }
            });
        }
    }
}
