package com.example.nguyentanthien_mobile;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.graphics.Insets;

import java.util.ArrayList;
import java.util.List;

public class ProductListActivity extends AppCompatActivity {

    private TextView tvCategoryTitle;
    private RecyclerView recyclerProducts;
    private List<Product> productList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        tvCategoryTitle = findViewById(R.id.tvCategoryTitle);
        recyclerProducts = findViewById(R.id.recyclerProducts);

        String category = getIntent().getStringExtra("category");
        tvCategoryTitle.setText("Danh mục: " + category);

        // Tạo danh sách sản phẩm
        productList = new ArrayList<>();
        productList.add(new Product("Hats", "Hat", "$22", R.drawable.hat1));
        productList.add(new Product("Shirt", "Shirt", "$35", R.drawable.shirt1));
        productList.add(new Product("Shirt", "Shirt", "$28", R.drawable.shirt2));
        productList.add(new Product("Jacket", "Jacket", "$62", R.drawable.jacket1));
        productList.add(new Product("Outerwear", "Outerwear", "$55", R.drawable.outerwear));
        productList.add(new Product("Hats", "Hat", "$21", R.drawable.hat2));

        // Lọc theo danh mục
        List<Product> filtered = new ArrayList<>();
        for (Product p : productList) {
            if (category.equals("all") || p.getCategory().equalsIgnoreCase(category)) {
                filtered.add(p);
            }
        }

        // Gắn adapter
        ProductAdapter adapter = new ProductAdapter(this, filtered);
        recyclerProducts.setLayoutManager(new LinearLayoutManager(this));
        recyclerProducts.setAdapter(adapter);
    }
}