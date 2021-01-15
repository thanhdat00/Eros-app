package com.example.eros_demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;


public class CreateQuestionActivity extends AppCompatActivity {
    private Button addQuestionBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_question);
        initComponent();
    }

    private void initComponent() {

    }
}