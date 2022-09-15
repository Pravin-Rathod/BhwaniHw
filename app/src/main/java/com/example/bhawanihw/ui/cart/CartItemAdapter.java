package com.example.bhawanihw.ui.cart;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.bhawanihw.Model.CartItem;
import com.example.bhawanihw.R;

import java.io.File;
import java.net.URL;
import java.util.List;

public class CartItemAdapter extends RecyclerView.Adapter<CartItemAdapter.CartItemViewHolder> {

    private Context mCtx;
    private List<CartItem> itemList;

    public CartItemAdapter(Context mCtx, List<CartItem> itemList) {
        this.mCtx = mCtx;
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public CartItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.layout_cart_item, null);
        return new CartItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CartItemViewHolder holder, final int position) {
        CartItem item = itemList.get(position);

        holder.itemName.setText(item.getItemName());
        holder.itemPrice.setText(String.valueOf(item.getItemPrice()));
        holder.itemTotalPrice.setText(String.valueOf(item.getItemTotalPrice()));
        holder.itemQty.setText(String.valueOf(item.getItemQty()));
        Glide.with(mCtx).load(item.getItemUrl()).diskCacheStrategy(DiskCacheStrategy.ALL).into(holder.itemImage);

        holder.itemDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(mCtx)
                        .setCancelable(false)
                        .setMessage("Are you sure you want to remove this item from cart?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                itemList.remove(position);
                                notifyItemRemoved(position);
                            }
                        })

                        // A null listener allows the button to dismiss the dialog and take no further action.
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        }).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class CartItemViewHolder extends RecyclerView.ViewHolder {

        ImageView itemImage;
        TextView itemName,itemPrice,itemTotalPrice,itemQty;
        ImageButton itemDecr,itemIncr;
        CardView itemDelete;

        public CartItemViewHolder(@NonNull View itemView) {
            super(itemView);

            itemImage = itemView.findViewById(R.id.cartItemImage);
            itemName = itemView.findViewById(R.id.cartItemName);
            itemPrice = itemView.findViewById(R.id.cartItemPrice);
            itemTotalPrice = itemView.findViewById(R.id.cartItemTotalPrice);
            itemQty = itemView.findViewById(R.id.cartItemQty);
            itemDecr = itemView.findViewById(R.id.itemQtyDecr);
            itemIncr = itemView.findViewById(R.id.itemQtyIncr);
            itemDelete = itemView.findViewById(R.id.cartItemDelete);
        }

    }
}
