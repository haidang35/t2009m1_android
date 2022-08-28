package com.example.recycleviewapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class ProductAdapterActivity extends AppCompatActivity {
    private List<Product> productList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_adapter);
        generateData();
        ProductAdapter productAdapter = new ProductAdapter(this, productList);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 2);
        RecyclerView recyclerView = findViewById(R.id.rvProductList);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(productAdapter);
    }

    public void generateData() {
        productList.add(new Product(1, "Product 1", R.drawable.product_thumbnail_1, 30000));
        productList.add(new Product(2, "Product 2", R.drawable.product_thumbnail_2, 35000));
        productList.add(new Product(3, "Product 3", R.drawable.product_thumbnail_3, 40000));
        productList.add(new Product(4, "Product 4", R.drawable.product_thumbnail_4, 45000));
        productList.add(new Product(5, "Product 5", R.drawable.product_thumbnail_5, 55000));
    }
}