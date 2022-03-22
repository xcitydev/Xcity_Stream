package com.xcityprime.xcity_stream;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AllCategoryAdapter extends RecyclerView.Adapter<AllCategoryAdapter.CategoryViewHolder> {
    Context mContext;
    List<AllCategory> allCategories;

    public AllCategoryAdapter(Context mContext, List<AllCategory> allCategories) {
        this.mContext = mContext;
        this.allCategories = allCategories;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CategoryViewHolder(LayoutInflater.from(mContext).inflate(R.layout.main_rec_row, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, final int position) {
        holder.allCategoryTextView.setText(allCategories.get(position).getCategoryTitle());

        setRecycler(holder.recyclerViewCategory, allCategories.get(position).getCategoryItemsList());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, ""+allCategories.get(position).categoryTitle, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return allCategories.size();
    }

    public static class CategoryViewHolder extends RecyclerView.ViewHolder {

        TextView allCategoryTextView;
        RecyclerView recyclerViewCategory;
        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            allCategoryTextView = itemView.findViewById(R.id.allCategoryTextView);
            recyclerViewCategory = itemView.findViewById(R.id.itemRecycle);
        }
    }

    public void setRecycler(RecyclerView recyclerViewCategory1, List<CategoryItem> allCategories2){
        ItemRecycleAdapter itemRecycleAdapter = new ItemRecycleAdapter(mContext, allCategories2);
        recyclerViewCategory1.setLayoutManager(new LinearLayoutManager(mContext, RecyclerView.HORIZONTAL, false));
        recyclerViewCategory1.setAdapter(itemRecycleAdapter);
    }
}
