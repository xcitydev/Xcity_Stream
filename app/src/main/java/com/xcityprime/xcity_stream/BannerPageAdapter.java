package com.xcityprime.xcity_stream;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;

import java.util.List;

public class BannerPageAdapter extends PagerAdapter {
    Context mContext;
    List<BannerMovies> bannerMovieList;

    public BannerPageAdapter(Context mContext, List<BannerMovies> bannerMovieList) {
        this.mContext = mContext;
        this.bannerMovieList = bannerMovieList;
    }

    @Override
    public int getCount() {
        return bannerMovieList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.banner_items, null);
        final ImageView imageView = view.findViewById(R.id.banner_items);

        // Time to glide
        Glide.with(mContext).load(bannerMovieList.get(position).getImageUrl()).into(imageView);
        container.addView(view);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(mContext, MovieDetails.class);
                i.putExtra("MovieId", bannerMovieList.get(position).getId());
                i.putExtra("MovieName", bannerMovieList.get(position).getMovieName());
                i.putExtra("ImageUrl", bannerMovieList.get(position).getImageUrl());
                i.putExtra("FileUrl", bannerMovieList.get(position).getFileUrl());
                mContext.startActivity(i);
            }
        });
        return view;
    }
}
