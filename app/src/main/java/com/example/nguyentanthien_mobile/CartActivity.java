package com.example.nguyentanthien_mobile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CartActivity extends AppCompatActivity {
    LinearLayout cartLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        cartLayout = findViewById(R.id.cartLayout);

        LayoutInflater inflater = LayoutInflater.from(this);

        for (CartItem item : CartManager.getInstance().getCartItems()) {
            LinearLayout itemView = (LinearLayout) inflater.inflate(R.layout.cart_item, cartLayout, false);

            ImageView img = itemView.findViewById(R.id.imgProduct);
            TextView name = itemView.findViewById(R.id.txtName);
            TextView sizeColor = itemView.findViewById(R.id.txtSizeColor);
            TextView price = itemView.findViewById(R.id.txtPrice);
            Button btnRemove = itemView.findViewById(R.id.btnRemove);
            Button btnBuyNow = itemView.findViewById(R.id.btnBuyNow);

            img.setImageResource(item.getImageResId());
            name.setText(item.getName());
            sizeColor.setText("Size " + item.getSize() + " - Màu " + item.getColor());
            price.setText(item.getPrice());

            btnRemove.setOnClickListener(v -> {
                CartManager.getInstance().removeItem(item);
                cartLayout.removeView(itemView);
                Toast.makeText(this, "Đã xóa sản phẩm", Toast.LENGTH_SHORT).show();
            });

            btnBuyNow.setOnClickListener(v -> {
                Toast.makeText(this, "Mua ngay: " + item.getName(), Toast.LENGTH_SHORT).show();
            });

            Button btnIncrease = itemView.findViewById(R.id.btnIncrease);
            Button btnDecrease = itemView.findViewById(R.id.btnDecrease);
            TextView txtQuantity = itemView.findViewById(R.id.txtQuantity);

            btnIncrease.setOnClickListener(v -> {
                int qty = Integer.parseInt(txtQuantity.getText().toString());
                txtQuantity.setText(String.valueOf(qty + 1));
            });

            btnDecrease.setOnClickListener(v -> {
                int qty = Integer.parseInt(txtQuantity.getText().toString());
                if (qty > 1) {
                    txtQuantity.setText(String.valueOf(qty - 1));
                }
            });

            cartLayout.addView(itemView);
        }
        Button btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(v -> finish());
    }
}
