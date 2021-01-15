package com.example.eros_demo;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class CreateProfileActivity extends AppCompatActivity {
    EditText nameEditText;
    EditText ageEditText;
    EditText phoneEditText;
    EditText locationEditText;
    Button submitButton,addQuestionButton;
    String userID;
    ListView question_lv ;
    int REQUEST_CODE = 100;
    ArrayList<Question> questions;
    QuestionsAdapter questionArrayAdapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_profile);
        initComponent();

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"okey", Toast.LENGTH_LONG).show();

                String name = nameEditText.getText().toString();
                String age = ageEditText.getText().toString();
                String phoneNumber = phoneEditText.getText().toString();
                String location = locationEditText.getText().toString();

                User user = new User(name, phoneNumber, location, questions);

                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("user_profile/"+ userID);
                myRef.child("name").setValue(user.getUserName());
                myRef.child("phone").setValue(user.getPhoneNumber());
                myRef.child("location").setValue(user.getLocation());

                List<Question> questionList1 = user.getQuestionList();

                for (int i = 0; i < questionList1.size(); i++){
                    myRef.child("question").child(String.valueOf(i)).child("q").setValue(questionList1.get(i).getQuestion());
                    myRef.child("question").child(String.valueOf(i)).child("a").setValue(questionList1.get(i).getAnswerA());
                    myRef.child("question").child(String.valueOf(i)).child("b").setValue(questionList1.get(i).getAnswerB());
                    myRef.child("question").child(String.valueOf(i)).child("c").setValue(questionList1.get(i).getAnswerC());
                    myRef.child("question").child(String.valueOf(i)).child("d").setValue(questionList1.get(i).getAnswerD());
                    myRef.child("question").child(String.valueOf(i)).child("res").setValue(questionList1.get(i).getResult());
                }

                Intent intent = new Intent(CreateProfileActivity.this, SwipeTest.class);
                startActivity(intent);
                finish();
            }
        });

        addQuestionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CreateProfileActivity.this, CreateQuestionActivity.class);
                intent.putExtra("question_list", questions);
                startActivityForResult(intent, REQUEST_CODE);

            }
        });
    }

    private void initComponent() {
        questions = new ArrayList<>();
        nameEditText = findViewById(R.id.name_edit_text);
        ageEditText = findViewById(R.id.age_edit_text);
        phoneEditText = findViewById(R.id.phone_edit_text);
        locationEditText = findViewById(R.id.location_edit_text);

        submitButton = findViewById(R.id.submit_button);
        addQuestionButton = findViewById(R.id.add_question_button);
        userID = getIntent().getStringExtra("UserID");
        question_lv = findViewById(R.id.lv_questionsList);
        initListView();
    }

    private void initListView() {
        questionArrayAdapter = new QuestionsAdapter(this, R.layout.question_item,questions);
        question_lv.setAdapter(questionArrayAdapter);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                questions = (ArrayList<Question>) data.getSerializableExtra("question_list_back");
                initListView();
            }
        }
    }
}