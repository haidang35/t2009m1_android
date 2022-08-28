package com.example.recycleviewapp;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter {
    private Activity activity;
    private List<Product> productList;

    public ProductAdapter(Activity activity, List<Product> productList) {
        this.activity = activity;
        this.productList = productList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = activity.getLayoutInflater().inflate(R.layout.product_item, parent, false);
        ProductAdapter.ProductHolder productHolder = new ProductHolder(view);
        return productHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ProductAdapter.ProductHolder productHolder = (ProductAdapter.ProductHolder) holder;
        Product product = productList.get(position);
        productHolder.ivThumbnail.setImageResource(product.getThumbnail());
        productHolder.tvName.setText(product.getName());
        productHolder.tvPrice.setText(String.valueOf(product.getPrice()));
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public class ProductHolder extends RecyclerView.ViewHolder {
        ImageView ivThumbnail;
        TextView tvName;
        TextView tvPrice;

        public ProductHolder(@NonNull View itemView) {
            super(itemView);
            ivThumbnail = itemView.findViewById(R.id.ivThumbnail);
            tvName = itemView.findViewById(R.id.tvName);
            tvPrice = itemView.findViewById(R.id.tvPrice);
        }
    }
}
