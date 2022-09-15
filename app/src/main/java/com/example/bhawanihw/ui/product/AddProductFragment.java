package com.example.bhawanihw.ui.product;

import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.bhawanihw.MainActivity;
import com.example.bhawanihw.Model.CartItem;
import com.example.bhawanihw.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class AddProductFragment extends Fragment {

    ImageView itemImage;
    TextView itemName,itemPrice;
    EditText itemQty;
    Button addItem;
    String url;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        final View root = inflater.inflate(R.layout.fragment_addproduct_layout, container, false);

        String itemId = getArguments().getString("itemId");
        getJSON("http://192.168.43.227/bhawanihw/additem_fetch.php?itemid="+itemId,root);

        itemName = root.findViewById(R.id.addItemName);
        itemImage = root.findViewById(R.id.addItemImage);
        itemPrice = root.findViewById(R.id.addItemPrice);
        itemQty = root.findViewById(R.id.addItemQty);

        addItem = root.findViewById(R.id.addItem);
        addItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!TextUtils.isEmpty(itemQty.getText().toString())) {
                    String name = itemName.getText().toString();
                    double price = Double.parseDouble(itemPrice.getText().toString());
                    int qty = Integer.parseInt(itemQty.getText().toString());
                    double tp = qty * price;

                    Toast.makeText(root.getContext(),"Item has been added to the cart",Toast.LENGTH_SHORT).show();

                    CartItem item = new CartItem(name,price,tp,qty,url);
                    MainActivity.cartItemList.add(item);

                    AppCompatActivity activity = (AppCompatActivity) v.getContext();
                    activity.getSupportFragmentManager().popBackStack();
                }
                else
                    itemQty.setError("Enter Quantity");
            }
        });
        return root;
    }

    private void getJSON(final String urlWebService, final View root) {

        class GetJSON extends AsyncTask<Void, Void, String> {

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }


            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                try {
                    loadIntoRecyclerView(s,root);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            protected String doInBackground(Void... voids) {
                try {
                    URL url = new URL(urlWebService);
                    HttpURLConnection con = (HttpURLConnection) url.openConnection();
                    StringBuilder sb = new StringBuilder();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(con.getInputStream()));
                    String json;
                    while ((json = bufferedReader.readLine()) != null) {
                        sb.append(json + "\n");
                    }
                    return sb.toString().trim();
                } catch (Exception e) {
                    return null;
                }
            }
        }
        GetJSON getJSON = new GetJSON();
        getJSON.execute();
    }

    private void loadIntoRecyclerView(String json,View root) throws JSONException {
        JSONArray jsonArray = new JSONArray(json);


        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject obj = jsonArray.getJSONObject(i);
            itemName.setText(obj.getString("item_name"));
            itemPrice.setText(obj.getString("item_price"));
            url = obj.getString("image_url");
            Glide.with(root.getContext()).load(obj.getString("image_url")).diskCacheStrategy(DiskCacheStrategy.ALL).into(itemImage);
        }
    }
}
