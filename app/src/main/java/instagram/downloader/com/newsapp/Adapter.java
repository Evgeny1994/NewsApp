package instagram.downloader.com.newsapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.bumptech.glide.Glide;

import org.ocpsoft.prettytime.PrettyTime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import instagram.downloader.com.newsapp.Model.Articles;


/**
 * Created by Евгений on 17.04.2023.
 */

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    Context context;
    List<Articles> articles;

    public Adapter(Context context, List<Articles> articles) {
        this.context = context;
        this.articles = articles;
    }

    @Override
    public Adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.items, null, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(Adapter.ViewHolder holder, int position) {
        final Articles a = articles.get(position);
        //holder.tvTitle.setText(a.getTitle());



    }


    @Override
    public int getItemCount() {
        return articles.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView cityName, tempValue, pressureValue, timeSunrise, timeSunrisezah;


        public ViewHolder(View itemView) {
            super(itemView);
            cityName = itemView.findViewById(R.id.cityName);
            tempValue = itemView.findViewById(R.id.tempValue);
            pressureValue = itemView.findViewById(R.id.pressureValue);
            timeSunrise = itemView.findViewById(R.id.timeSunrise);
            timeSunrisezah = itemView.findViewById(R.id.timeSunrisezah);
        }
    }


    private String dateTime(String t) {
        PrettyTime prettyTime = new PrettyTime(new Locale(getCountry()));
        String time = null;
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm", Locale.ENGLISH);
            Date date = simpleDateFormat.parse(t);
            time = prettyTime.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return time;

    }


    public String getCountry() {
        //Locale locale = Locale.getDefault();
        //String country = locale.getCountry();

        String country = "us";
        return country.toLowerCase();
    }


}

