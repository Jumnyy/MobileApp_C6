package com.example.nguyentanthien_mobile;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {

    TextView textName, textPrice;
    ImageView imageProduct;
    RadioGroup radioGroupSize, radioGroupColor;
    Button btnAddToCart, btnOrderNow, btnBack, btnViewCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        // Ánh xạ view
        textName = findViewById(R.id.textProductName);
        textPrice = findViewById(R.id.textProductPrice);
        imageProduct = findViewById(R.id.imageProduct);
        radioGroupSize = findViewById(R.id.radioGroupSize);
        radioGroupColor = findViewById(R.id.radioGroupColor);
        btnAddToCart = findViewById(R.id.btnAddToCart);
        btnOrderNow = findViewById(R.id.btnOrderNow);
        btnBack = findViewById(R.id.btnBack);
        btnViewCart = findViewById(R.id.btnViewCart); // Thêm dòng này

        // Nhận dữ liệu từ Intent
        String name = getIntent().getStringExtra("name");
        String price = getIntent().getStringExtra("price");
        int imageResId = getIntent().getIntExtra("imageResId", R.drawable.shirt1);

        // Gán dữ liệu vào giao diện
        textName.setText(name);
        textPrice.setText(price);
        imageProduct.setImageResource(imageResId);

        // Xử lý nút thêm vào giỏ
        btnAddToCart.setOnClickListener(v -> {
            String size = getSelectedSize();
            String color = getSelectedColor();

            CartItem item = new CartItem(name, price, size, color, imageResId);
            CartManager.getInstance().addToCart(item);

            Toast.makeText(this, "Đã thêm vào giỏ!", Toast.LENGTH_SHORT).show();
        });

        // Xử lý nút đặt hàng
        btnOrderNow.setOnClickListener(v -> {
            String size = getSelectedSize();
            String color = getSelectedColor();

            // Chuyển sang OrderActivity
            Intent intent = new Intent(DetailActivity.this, OrderActivity.class);
            intent.putExtra("name", name);
            intent.putExtra("price", price);
            intent.putExtra("size", size);
            intent.putExtra("color", color);
            intent.putExtra("imageResId", imageResId);
            startActivity(intent);
        });

        // Nút quay lại
        btnBack.setOnClickListener(v -> finish());

        // Nút xem giỏ hàng
        btnViewCart.setOnClickListener(v -> {
            Intent intent = new Intent(DetailActivity.this, CartActivity.class);
            startActivity(intent);
        });
    }

    private String getSelectedSize() {
        int id = radioGroupSize.getCheckedRadioButtonId();
        if (id == -1) return "Chưa chọn";
        return ((RadioButton) findViewById(id)).getText().toString();
    }

    private String getSelectedColor() {
        int id = radioGroupColor.getCheckedRadioButtonId();
        if (id == -1) return "Chưa chọn";
        return ((RadioButton) findViewById(id)).getText().toString();
    }
}
