package com.example.eros_demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Matching_success extends AppCompatActivity {

    private Button backToMainScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matching_success);

        backToMainScreen = findViewById(R.id.btn_keep_swipe);

        backToMainScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Matching_success.this, SwipeTest.class);
                startActivity(intent);
                finish();
            }
        });
    }
}