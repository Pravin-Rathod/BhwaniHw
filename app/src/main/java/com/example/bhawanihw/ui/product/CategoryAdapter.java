package com.example.bhawanihw.ui.product;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.bhawanihw.Model.Category;
import com.example.bhawanihw.R;

import java.util.List;

public class CategoryAdapter  extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>  {

    private Context mCtx;
    private Context productCtx;
    private List<Category> categoryList;

    public CategoryAdapter(Context mCtx, Context productCtx,List<Category> categoryList){
        this.mCtx=mCtx;
        this.categoryList=categoryList;
        this.productCtx=productCtx;
    }

    @NonNull
    @Override
    public CategoryAdapter.CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(mCtx);
        View view = layoutInflater.inflate(R.layout.layout_category,null);
        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryAdapter.CategoryViewHolder holder, int position) {
        final Category cat = categoryList.get(position);

        holder.categoryName.setText(cat.getCategoryName());
        Glide.with(mCtx).load(cat.getCategoryImageUrl()).diskCacheStrategy(DiskCacheStrategy.ALL).into(holder.getImage());
        holder.category.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatActivity activity = (AppCompatActivity) v.getContext();
                Fragment myFragment = new ItemFragment();
                Bundle data = new Bundle();//Use bundle to pass data
                data.putString("category", cat.getCategoryName().trim());//put string, int, etc in bundle with a key value
                myFragment.setArguments(data);
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, myFragment,"fragment_item").addToBackStack("fragment_category").commit();
            }
        });
    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder{

        ImageView categoryImage;
        TextView categoryName;
        TableLayout category;

        public CategoryViewHolder(@NonNull View categoryView) {
            super(categoryView);
            categoryName= categoryView.findViewById(R.id.categoryName);
            category = categoryView.findViewById(R.id.category);
            categoryImage = categoryView.findViewById(R.id.categoryImage);
        }
        public ImageView getImage(){ return this.categoryImage;}
    }
}

