package com.example.eros_demo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

import org.w3c.dom.Text;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class CreateQuestionActivity extends AppCompatActivity implements View.OnClickListener {
    private Button addQuestionBtn;
    private ArrayList<Question> questions;
    private TextInputEditText question;
    private TextInputEditText answerA;
    private TextInputEditText answerB;
    private TextInputEditText answerC;
    private TextInputEditText answerD;
    private String result;
    private ArrayList<TextView> options = new ArrayList<>();
    private TextView tv_A, tv_B, tv_C, tv_D;

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

        tv_A.setOnClickListener(this);
        tv_B.setOnClickListener(this);
        tv_C.setOnClickListener(this);
        tv_D.setOnClickListener(this);

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

        options.add((TextView)findViewById(R.id.tv_A));
        options.add((TextView)findViewById(R.id.tv_B));
        options.add((TextView)findViewById(R.id.tv_C));
        options.add((TextView)findViewById(R.id.tv_D));

        tv_A = findViewById(R.id.tv_A);
        tv_B = findViewById(R.id.tv_B);
        tv_C = findViewById(R.id.tv_C);
        tv_D = findViewById(R.id.tv_D);

        result = "";
    }

    private void defaultOptionView(){
        for (int i = 0; i < options.size(); i++){
            options.get(i).setTextColor(Color.parseColor("#7a8089"));
            options.get(i).setTypeface(Typeface.DEFAULT);
            options.get(i).setBackground(ContextCompat.getDrawable(this,R.drawable.default_option_border_bg));
        }
    }

    private void selectdOptionView(TextView tv){
        defaultOptionView();
        result = tv.getText().toString();

        tv.setTextColor(Color.parseColor("#363a43"));
        tv.setTypeface(tv.getTypeface(), Typeface.BOLD);
        tv.setBackground(ContextCompat.getDrawable(this,R.drawable.selected_option_border_bg));

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_A:
                selectdOptionView(tv_A);
                break;
            case R.id.tv_B:
                selectdOptionView(tv_B);
                break;
            case R.id.tv_C:
                selectdOptionView(tv_C);
                break;
            case R.id.tv_D:
                selectdOptionView(tv_D);
                break;
        }
    }
}