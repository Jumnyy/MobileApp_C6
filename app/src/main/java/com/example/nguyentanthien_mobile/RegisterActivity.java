package com.example.nguyentanthien_mobile;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    EditText etPhone, etPassword, etConfirmPassword;
    Button btnRegister;
    TextView tvMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etPhone = findViewById(R.id.etPhone);
        etPassword = findViewById(R.id.etPassword);
        etConfirmPassword = findViewById(R.id.etConfirmPassword);
        btnRegister = findViewById(R.id.btnRegister);
        tvMessage = findViewById(R.id.tvMessage);

        btnRegister.setOnClickListener(v -> {
            String phone = etPhone.getText().toString().trim();
            String password = etPassword.getText().toString();
            String confirmPassword = etConfirmPassword.getText().toString();

            if (phone.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                tvMessage.setText("Vui lòng điền đầy đủ thông tin.");
                return;
            }

            if (!phone.matches("\\d{0,4}")) {
                tvMessage.setText("Số điện thoại không hợp lệ.");
                return;
            }

            if (!password.equals(confirmPassword)) {
                tvMessage.setText("Mật khẩu không khớp.");
                return;
            }

            tvMessage.setTextColor(getResources().getColor(android.R.color.holo_green_dark));
            Toast.makeText(RegisterActivity.this, "Đăng ký thành công!", Toast.LENGTH_SHORT).show();

            finish();
        });
        Button btn = findViewById(R.id.btnBackToMain);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}