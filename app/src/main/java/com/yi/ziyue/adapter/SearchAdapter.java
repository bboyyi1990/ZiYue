package com.yi.ziyue.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yi.ziyue.R;
import com.yi.ziyue.base.BaseApplication;
import com.yi.ziyue.beans.SearchHotBean;

/**
 * Created by Yi on 16/3/13.
 */
public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.SearchViewHolder> {

    private SearchHotBean searchHotBean;

    public SearchAdapter(SearchHotBean searchHotBean) {
        this.searchHotBean = searchHotBean;
    }



    @Override
    public SearchViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new SearchViewHolder(LayoutInflater.from(BaseApplication.getContext()).inflate(R.layout.search_recyclerview, parent, false));
    }

    @Override
    public void onBindViewHolder(SearchViewHolder holder, int position) {

        holder.textView.setText(searchHotBean.getHotWordList().get(position).getHotWord().toString());
        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO Pass values to search EditText
            }
        });
    }

    @Override
    public int getItemCount() {
        return searchHotBean.getHotWordList().size();
    }

    class SearchViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        public SearchViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.search_recyclerView_text);
        }
    }
}
