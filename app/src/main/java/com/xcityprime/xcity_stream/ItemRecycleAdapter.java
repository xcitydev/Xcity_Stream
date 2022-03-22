package com.xcityprime.xcity_stream;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class ItemRecycleAdapter extends RecyclerView.Adapter<ItemRecycleAdapter.MyViewHolder> {

    Context mContext;
    List<CategoryItem> categoryItems;

    public ItemRecycleAdapter(Context mContext, List<CategoryItem> categoryItems) {
        this.mContext = mContext;
        this.categoryItems = categoryItems;
    }

    @NonNull
    @Override
    public ItemRecycleAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.cat_rec_item_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemRecycleAdapter.MyViewHolder holder, final int position) {
        Glide.with(mContext).load(categoryItems.get(position).getImageUrl()).into(holder.imageViewCategory);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(mContext, MovieDetails.class);
                i.putExtra("MovieId", categoryItems.get(position).getId());
                i.putExtra("MovieName", categoryItems.get(position).getMovieName());
                i.putExtra("ImageUrl", categoryItems.get(position).getImageUrl());
                i.putExtra("FileUrl", categoryItems.get(position).getFileUrl());
                mContext.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return categoryItems.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageViewCategory;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageViewCategory = itemView.findViewById(R.id.item_Image);
        }
    }
}
