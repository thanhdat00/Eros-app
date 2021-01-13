package com.example.eros_demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

public class Login extends AppCompatActivity {
    ImageView facebook_login, gmail_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initComponent();
    }

    private void initComponent() {
        gmail_login = findViewById(R.id.iv_gmail_login);
    }
}