package com.example.nguyentanthien_mobile;

import java.util.ArrayList;
import java.util.List;

public class CartManager {
    private static CartManager instance;
    private final List<CartItem> cartItems;

    private CartManager() {
        cartItems = new ArrayList<>();
    }

    public static CartManager getInstance() {
        if (instance == null) {
            instance = new CartManager();
        }
        return instance;
    }

    public void addToCart(CartItem item) {
        cartItems.add(item);
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void removeItem(CartItem item) {
        cartItems.remove(item);
    }

    public void buyNow(CartItem item) {
        // Xử lý mua ngay: thường là chuyển qua màn hình thanh toán chỉ với item này
        // Ở đây chỉ là ví dụ log hoặc xử lý đơn giản
        List<CartItem> buyNowList = new ArrayList<>();
        buyNowList.add(item);

        // Giả lập thanh toán
//        processCheckout(buyNowList);
    }

//    private void processCheckout(List<CartItem> itemsToCheckout) {
//        // Placeholder: xử lý thanh toán cho danh sách item
//        for (CartItem item : itemsToCheckout) {
//            System.out.println("Processing checkout for: " + item.getProductName());
//        }
//
//        // Có thể thêm logic xoá khỏi giỏ nếu cần
//    }
}
//