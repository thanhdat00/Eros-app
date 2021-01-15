package com.example.eros_demo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;

public class Matching extends AppCompatActivity implements View.OnClickListener {
    private ArrayList<Question> questions = new ArrayList<Question>() ;
    int curentPos = 1;
    ProgressBar progressBar;
    TextView tv_progress, tv_question, tv_answerA,tv_answerB,tv_answerC,tv_answerD;
    Button btn_submit;
    private int mSelectedOptionPosition;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matching);
        initComponents();
        setQuestion();

        tv_answerA.setOnClickListener(this);
        tv_answerB.setOnClickListener(this);
        tv_answerC.setOnClickListener(this);
        tv_answerD.setOnClickListener(this);


        btn_submit.setOnClickListener(this);




    }

    private void setQuestion() {
        Question question = questions.get(curentPos-1);
        tv_progress.setText(String.valueOf(curentPos) + "/5");
        progressBar.setProgress(curentPos-1);

        defaultOptionView();

        tv_question.setText(question.getQuestion());

        tv_answerA.setText(question.getAnswerA());
        tv_answerB.setText(question.getAnswerB());
        tv_answerC.setText(question.getAnswerC());
        tv_answerD.setText(question.getAnswerD());
    }

    private void initComponents() {
        progressBar = findViewById(R.id.progressBar);
        tv_progress = findViewById(R.id.tv_progress);

        tv_question = findViewById(R.id.tv_question);
        tv_answerA = findViewById(R.id.tv_answer_A);
        tv_answerB = findViewById(R.id.tv_answer_B);
        tv_answerC = findViewById(R.id.tv_answer_C);
        tv_answerD = findViewById(R.id.tv_answer_D);

        btn_submit = findViewById(R.id.btn_submit);
        questions.add(new Question(
                "WHO PLAYS THE ROLE OF TONY STARK IN MCU",
                "Robert Downey,Jr.",
                "Christ Evans",
                "Christ Hemsworth",
                "Mark Ruffalo",
                "A"));

        questions.add(new Question(
                "Which thing is alive?",
                "Table",
                "Dog",
                "Rock",
                "Chair",
                "B"
        ));

        questions.add(new Question(
                "Do you like this app?",
                "So so",
                "Not at all",
                "Maybe",
                "Yes",
                "D"
        ));

        questions.add(new Question(
                "What is your country?",
                "Vietnam",
                "Laos",
                "Campuchia",
                "Phillipin",
                "D"
        ));

        questions.add(new Question(
                "Which kind of food you like?",
                "Chicken",
                "Fish",
                "Fruit",
                "Vegetable",
                "B"
        ));
    }


    private void defaultOptionView(){
        ArrayList<TextView> options = new ArrayList<>();
        options.add(tv_answerA);
        options.add(tv_answerB);
        options.add(tv_answerC);
        options.add(tv_answerD);

        for (int i = 0; i < options.size(); i++){
            options.get(i).setTextColor(Color.parseColor("#7a8089"));
            options.get(i).setTypeface(Typeface.DEFAULT);
            options.get(i).setBackground(ContextCompat.getDrawable(this,R.drawable.default_option_border_bg));
        }


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_answer_A:
                selectdOptionView(tv_answerA,1);
                break;

            case R.id.tv_answer_B:
                selectdOptionView(tv_answerB,2);
                break;
            case R.id.tv_answer_C:
                selectdOptionView(tv_answerC,3);
                break;
            case R.id.tv_answer_D:
                selectdOptionView(tv_answerD,4);
                break;
            case R.id.btn_submit:
                curentPos++;
                if (curentPos <= questions.size())
                    setQuestion();

        }

    }

    private void selectdOptionView(TextView tv, int selectedNum){
       defaultOptionView();
       mSelectedOptionPosition = selectedNum;

        tv.setTextColor(Color.parseColor("#363a43"));
        tv.setTypeface(tv.getTypeface(), Typeface.BOLD);
        tv.setBackground(ContextCompat.getDrawable(this,R.drawable.selected_option_border_bg));

    }
}