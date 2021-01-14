package com.example.eros_demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class CreateProfileActivity extends AppCompatActivity {
    EditText nameEditText;
    EditText ageEditText;
    EditText phoneEditText;
    EditText questionEditText;
    EditText locationEditText;
    EditText answerA;
    EditText answerB;
    EditText answerC;
    EditText answerD;
    EditText resultEditText;
    Button submitButton,addQuestionButton;
    String userID;
    ListView question_lv ;
    int REQUEST_CODE = 100;
    ArrayList<Question> questions = null;
    ArrayAdapter<Question> questionArrayAdapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_profile);
        initComponent();


        questions = new ArrayList<Question>();

        questionArrayAdapter = new QuestionsAdapter(this, 0,questions);
        question_lv.setAdapter(questionArrayAdapter);


        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"okey", Toast.LENGTH_LONG).show();

                String name = nameEditText.getText().toString();
                String age = ageEditText.getText().toString();
                String phoneNumber = phoneEditText.getText().toString();
                String location = locationEditText.getText().toString();
//                String question = questionEditText.getText().toString();
//                String A = answerA.getText().toString();
//                String B = answerB.getText().toString();
//                String C = answerC.getText().toString();
//                String D = answerD.getText().toString();
//                String res = resultEditText.getText().toString();
//
//                Question question1 = new Question(question, A, B ,C ,D, res);
//                List<Question> questionList = new ArrayList<>();
                //questionList.add(question1);

//                User user = new User(name, phoneNumber, location, questionList);
//
//                FirebaseDatabase database = FirebaseDatabase.getInstance();
//                DatabaseReference myRef = database.getReference("user_profile/"+ userID);
//                myRef.child("name").setValue(user.getUserName());
//                myRef.child("phone").setValue(user.getPhoneNumber());

                //List<Question> questionList1 = user.getQuestionList();

//                for (int i = 0; i < questionList1.size(); i++){
//                    myRef.child("question").child(String.valueOf(i)).child("q").setValue(questionList1.get(i).getQuestion());
//                    myRef.child("question").child(String.valueOf(i)).child("a").setValue(questionList1.get(i).getAnswerA());
//                }

            }
        });

        addQuestionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CreateProfileActivity.this, CreateQuestionActivity.class);
                startActivityForResult(intent, REQUEST_CODE);

            }
        });
    }

    private void initComponent() {
        nameEditText = findViewById(R.id.name_edit_text);
        ageEditText = findViewById(R.id.age_edit_text);
        phoneEditText = findViewById(R.id.phone_edit_text);
        locationEditText = findViewById(R.id.location_edit_text);
//        questionEditText = findViewById(R.id.question_edit_text);
//        answerA = findViewById(R.id.answer_A);
//        answerB = findViewById(R.id.answer_B);
//        answerC = findViewById(R.id.answer_C);
//        answerD = findViewById(R.id.answer_D);
//        resultEditText = findViewById(R.id.result_edit_text);
        submitButton = findViewById(R.id.submit_button);
        addQuestionButton = findViewById(R.id.add_question_button);
        Bundle bundle = getIntent().getExtras();
        userID = bundle.getString("UserID");
        question_lv = findViewById(R.id.lv_questionsList);


    }


//    public void onClickSubmit(View view) {
//
//        String name = nameEditText.toString();
//        String age = ageEditText.toString();
//        String phoneNumber = phoneEditText.toString();
//        String location = locationEditText.toString();
//        String question = questionEditText.toString();
//        String A = answerA.toString();
//        String B = answerB.toString();
//        String C = answerC.toString();
//        String D = answerD.toString();
//        String res = resultEditText.toString();
//
//        Question question1 = new Question(question, A, B ,C ,D, res);
//        List<Question> questionList = null;
//        questionList.add(question1);
//
//        User user = new User(name, phoneNumber, location, questionList);
//
////        FirebaseDatabase database = FirebaseDatabase.getInstance();
////        DatabaseReference myRef = database.getReference("message22");
////
////        myRef.setValue("Hello, World!");
//    }
}