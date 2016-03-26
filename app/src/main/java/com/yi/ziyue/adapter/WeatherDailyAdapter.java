package com.yi.ziyue.adapter;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.yi.ziyue.R;
import com.yi.ziyue.base.ListViewBaseAdapter;
import com.yi.ziyue.beans.WeatherBeans;

import java.util.List;

/**
 * Created by Yi on 16/3/21.
 */
public class WeatherDailyAdapter extends ListViewBaseAdapter<WeatherBeans.DailyForecastEntity> {


    public WeatherDailyAdapter(Context context, List<WeatherBeans.DailyForecastEntity> list) {
        super(context, list);
    }

    @Override
    protected int getItemResource() {
        return R.layout.weather_daily_listview;
    }

    @Override
    protected View getItemView(int position, ViewHolder holder, View convertView) {

        TextView dateTv = holder.getView(R.id.weather_daily_listView_date_tv);
        dateTv.setText(list.get(position).getDate());
        TextView maxTemp = holder.getView(R.id.weather_daily_listView_maxTemp_tv);
        maxTemp.setText("max " + list.get(position).getTmp().getMax() + "°");
        TextView minTemp = holder.getView(R.id.weather_daily_listView_minTemp_tv);
        minTemp.setText("min " + list.get(position).getTmp().getMin() + "°");
        TextView dirTv = holder.getView(R.id.weather_daily_listView_wind_dir_tv);
        dirTv.setText(list.get(position).getWind().getDir());
        TextView windLevelTv = holder.getView(R.id.weather_daily_listView_wind_level_tv);
        windLevelTv.setText(list.get(position).getWind().getSc() + "级");
        TextView windSpeedTv = holder.getView(R.id.weather_daily_listView_wind_speed_tv);
        windSpeedTv.setText("风速 " + list.get(position).getWind().getSpd());

        return convertView;
    }

}
