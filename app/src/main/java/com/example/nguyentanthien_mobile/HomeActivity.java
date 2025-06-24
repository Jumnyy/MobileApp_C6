package com.example.nguyentanthien_mobile;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {

    ImageView imageProduct1, imageProduct2, imageProduct3,imageProduct4, imageProduct5, imageProduct6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        imageProduct1 = findViewById(R.id.shirt1);
        imageProduct2 = findViewById(R.id.shirt2);
        imageProduct3 = findViewById(R.id.hat1);
        imageProduct4 = findViewById(R.id.hat2);
        imageProduct5 = findViewById(R.id.jacket1);
        imageProduct6 = findViewById(R.id.outerwear);

        imageProduct1.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, DetailActivity.class);
            intent.putExtra("name", "Tops");
            intent.putExtra("price", "$35");
            intent.putExtra("imageResId", R.drawable.shirt1);
            startActivity(intent);
        });

        imageProduct2.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, DetailActivity.class);
            intent.putExtra("name", "Tops");
            intent.putExtra("price", "$30");
            intent.putExtra("imageResId", R.drawable.shirt2);
            startActivity(intent);
        });
        imageProduct3.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, DetailActivity.class);
            intent.putExtra("name", "Hats");
            intent.putExtra("price", "$30");
            intent.putExtra("imageResId", R.drawable.hat1);
            startActivity(intent);
        });
        imageProduct4.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, DetailActivity.class);
            intent.putExtra("name", "Hats");
            intent.putExtra("price", "$30");
            intent.putExtra("imageResId", R.drawable.hat2);
            startActivity(intent);
        });
        imageProduct5.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, DetailActivity.class);
            intent.putExtra("name", "Jacket");
            intent.putExtra("price", "$30");
            intent.putExtra("imageResId", R.drawable.jacket1);
            startActivity(intent);
        });
        imageProduct6.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, DetailActivity.class);
            intent.putExtra("name", "OuterWear");
            intent.putExtra("price", "$30");
            intent.putExtra("imageResId", R.drawable.outerwear);
            startActivity(intent);
        });



    }
}
