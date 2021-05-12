package com.tha.nguyenminhchi.adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.tha.nguyenminhchi.R;
import com.tha.nguyenminhchi.model.Weather;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class MainAdapter extends RecyclerView.Adapter {
    private Activity activity;
    private List<Weather> listData;

    public  void reloadData(List<Weather> list){
        this.listData = list;
        this.notifyDataSetChanged();
    }

    public MainAdapter(Activity activity, List<Weather> listData) {
        this.activity = activity;
        this.listData = listData;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = activity.getLayoutInflater().inflate(R.layout.item_layout, parent, false);
        return new ForecastHolder(itemView);
    }

    //B4
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Weather model = listData.get(position);
        ForecastHolder vh = (ForecastHolder) holder;
        Glide.with(activity).load(convertIcon((int) model.getWeatherIcon())).into(vh.icon);
        vh.tvTime.setText(convertTime(model.getDateTime()));
        vh.tvTemp.setText(String.format("%s°", model.getTemperature().getValue()));

    }

    //B5
    @Override
    public int getItemCount() {
        return listData.size();
    }

    //B2
    public class ForecastHolder extends RecyclerView.ViewHolder {
        ImageView icon;
        TextView tvTime;
        TextView tvTemp;

        public ForecastHolder(@NonNull View itemView) {
            super(itemView);
            icon = itemView.findViewById(R.id.ivIcon);
            tvTime = itemView.findViewById(R.id.tvTime);
            tvTemp = itemView.findViewById(R.id.tvTemp);
        }
    }

    public String convertTime(String inputTime) {
        SimpleDateFormat inFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        Date date = null;
        try {
            date = inFormat.parse(inputTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        SimpleDateFormat outFormat = new SimpleDateFormat("ha");
        return outFormat.format(date);
    }
    public String convertIcon(int input){
        String Url = "https://developer.accuweather.com/sites/default/files/";
        if(input < 10){
            return  Url+"0"+input+"-s.png";
        }
        return  Url+input+"-s.png";
    }
}
