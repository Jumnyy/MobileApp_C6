package com.example.nguyentanthien_mobile;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.nguyentanthien_mobile.Product;
import com.example.nguyentanthien_mobile.R;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {
    private final List<Product> productList;
    private final Context context;

    public ProductAdapter(Context context, List<Product> products) {
        this.context = context;
        this.productList = products;
    }

    public static class ProductViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView name, price;

        public ProductViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.product_image);
            name = itemView.findViewById(R.id.product_name);
            price = itemView.findViewById(R.id.product_price);
        }
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_product, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProductViewHolder holder, int position) {
        Product p = productList.get(position);
        holder.image.setImageResource(p.getImageResId());
        holder.name.setText(p.getName());
        holder.price.setText(formatCurrency(p.getPrice()));
    }

    private String formatCurrency(String priceString) {
        try {
            int amount = Integer.parseInt(priceString);
            return NumberFormat.getCurrencyInstance(new Locale("en", "US")).format(amount);
        } catch (NumberFormatException e) {
            return priceString;
        }
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

}