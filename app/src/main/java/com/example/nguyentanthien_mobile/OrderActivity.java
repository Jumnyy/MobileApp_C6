package com.example.nguyentanthien_mobile;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class OrderActivity extends AppCompatActivity {
    EditText edtName, edtPhone, edtAddress, edtNote;
    Button btnConfirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        edtName = findViewById(R.id.edtName);
        edtPhone = findViewById(R.id.edtPhone);
        edtAddress = findViewById(R.id.edtAddress);
        edtNote = findViewById(R.id.edtNote);
        btnConfirm = findViewById(R.id.btnConfirmOrder);

        btnConfirm.setOnClickListener(v -> {
            // Xử lý logic đặt hàng ở đây
            Toast.makeText(this, "Đặt hàng thành công!", Toast.LENGTH_SHORT).show();
            finish(); // Quay lại sau khi xác nhận
        });
    }
}
