package com.yi.ziyue.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yi.ziyue.R;
import com.yi.ziyue.base.BaseApplication;
import com.yi.ziyue.beans.WeatherBeans;

/**
 * Created by Yi on 16/3/21.
 */
public class WeatherHourlyAdapter extends RecyclerView.Adapter<WeatherHourlyAdapter.HourlyViewHolder> {

    private WeatherBeans beans;

    public WeatherHourlyAdapter(WeatherBeans beans) {
        this.beans = beans;
    }

    @Override
    public HourlyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new HourlyViewHolder(LayoutInflater.from(BaseApplication.getContext()).inflate(R.layout.weather_hourly_recyclerview, null));
    }

    @Override
    public void onBindViewHolder(HourlyViewHolder holder, int position) {
        String date = beans.getHourly_forecast().get(position).getDate();
        String hour = date.substring(10, 16);
        holder.dateTv.setText(hour);
        holder.tempTv.setText(beans.getHourly_forecast().get(position).getTmp() + "°");
        holder.dirTv.setText(beans.getHourly_forecast().get(position).getWind().getDir());
        holder.speedTv.setText("风速 " + beans.getHourly_forecast().get(position).getWind().getSpd());
    }

    @Override
    public int getItemCount() {
        return beans.getHourly_forecast().size();
    }

    class HourlyViewHolder extends RecyclerView.ViewHolder {
        private TextView dateTv, tempTv, dirTv, speedTv;

        public HourlyViewHolder(View itemView) {
            super(itemView);
            dateTv = (TextView) itemView.findViewById(R.id.weather_hourly_recyclerView_date_tv);
            tempTv = (TextView) itemView.findViewById(R.id.weather_hourly_recyclerView_temp_tv);
            dirTv = (TextView) itemView.findViewById(R.id.weather_hourly_recyclerView_dir_tv);
            speedTv = (TextView) itemView.findViewById(R.id.weather_hourly_recyclerView_speed_tv);
        }
    }
}
