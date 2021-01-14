package com.example.eros_demo.Question;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.eros_demo.R;

public class CreateQuestionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_question);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .setReorderingAllowed(true)
                    .add(R.id.question_form, QuestionFragment.class, null)
                    .commit();
        }
    }
}