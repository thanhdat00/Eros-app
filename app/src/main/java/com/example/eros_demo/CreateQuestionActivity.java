package com.example.eros_demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;

import org.w3c.dom.Text;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class CreateQuestionActivity extends AppCompatActivity {
    private Button addQuestionBtn;
    private ArrayList<Question> questions;
    private TextInputEditText question;
    private TextInputEditText answerA;
    private TextInputEditText answerB;
    private TextInputEditText answerC;
    private TextInputEditText answerD;
    private String result;
    private Button btnA;
    private Button btnB;
    private Button btnC;
    private Button btnD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_question);
        initComponent();

        addQuestionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Question newQuestion = new Question(question.getText().toString(), answerA.getText().toString(), answerB.getText().toString(),
                        answerC.getText().toString(), answerD.getText().toString(), result);

                questions.add(newQuestion);

                Intent intent = new Intent();
                intent.putExtra("question_list_back", questions);
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        btnA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnA.setBackgroundColor((0x00000000));
                result = btnA.getText().toString();
            }
        });
    }

    private void initComponent() {
        Intent intent = getIntent();
        questions = (ArrayList<Question>) intent.getSerializableExtra("question_list");
        addQuestionBtn = findViewById(R.id.btn_add_question);
        question = findViewById(R.id.content_text);
        answerA = findViewById(R.id.answer_A);
        answerB = findViewById(R.id.answer_B);
        answerC = findViewById(R.id.answer_C);
        answerD = findViewById(R.id.answer_D);
        btnA = findViewById(R.id.result_A);
        btnB = findViewById(R.id.result_B);
        btnC = findViewById(R.id.result_C);
        btnD = findViewById(R.id.result_D);
        result = "";
    }
}