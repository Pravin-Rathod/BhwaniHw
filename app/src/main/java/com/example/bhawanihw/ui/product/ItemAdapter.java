package com.example.bhawanihw.ui.product;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.bhawanihw.Model.Item;
import com.example.bhawanihw.R;

import java.util.List;

public class ItemAdapter  extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder>{

    private Context mCtx;
    private List<Item> itemList;

    public ItemAdapter(Context mCtx, List<Item> itemList){
        this.mCtx=mCtx;
        this.itemList=itemList;
    }

    @NonNull
    @Override
    public ItemAdapter.ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(mCtx);
        View view = layoutInflater.inflate(R.layout.layout_item,null);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemAdapter.ItemViewHolder holder, int position) {
        final Item item = itemList.get(position);
        holder.textViewItemId.setText(item.getItemId());
        holder.textViewItemName.setText(item.getItemName());
        holder.textViewItemPrice.setText(item.getItemPrice());
        Glide.with(mCtx).load(item.getItemImageUrl()).diskCacheStrategy(DiskCacheStrategy.ALL).into(holder.getImage());

        holder.item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatActivity activity = (AppCompatActivity) v.getContext();
                Fragment myFragment = new AddProductFragment();
                Bundle data = new Bundle();//Use bundle to pass data
                data.putString("itemId", item.getItemId().trim());//put string, int, etc in bundle with a key value
                myFragment.setArguments(data);
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, myFragment,"fragment_addproduct").addToBackStack("fragment_item").commit();
            }
        });
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder{

        ImageView itemImage;
        TextView textViewItemId,textViewItemName,textViewItemPrice;
        RelativeLayout item;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewItemId= itemView.findViewById(R.id.itemId);
            textViewItemName = itemView.findViewById(R.id.itemName);
            textViewItemPrice = itemView.findViewById(R.id.itemPrice);
            itemImage = itemView.findViewById(R.id.itemImage);
            item = itemView.findViewById(R.id.recyclerViewItem);
        }
        public ImageView getImage(){ return this.itemImage;}
    }
}
