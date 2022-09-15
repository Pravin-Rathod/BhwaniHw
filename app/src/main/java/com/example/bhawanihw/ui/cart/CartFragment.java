package com.example.bhawanihw.ui.cart;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bhawanihw.MainActivity;
import com.example.bhawanihw.R;

public class CartFragment extends Fragment {

    RecyclerView recyclerViewCart;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_cart, container, false);

        recyclerViewCart = root.findViewById(R.id.recyclerViewCart);
        recyclerViewCart.setHasFixedSize(true);
        recyclerViewCart.setLayoutManager(new LinearLayoutManager(root.getContext()));
        recyclerViewCart = root.findViewById(R.id.recyclerViewCart);

        CartItemAdapter adapter = new CartItemAdapter(root.getContext(), MainActivity.cartItemList);
        recyclerViewCart.setAdapter(adapter);

        return root;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //you can set the title for your toolbar here for different fragments different titles
        getActivity().setTitle("Cart");
    }
}