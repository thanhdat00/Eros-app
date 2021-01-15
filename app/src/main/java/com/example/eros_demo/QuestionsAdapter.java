package com.example.eros_demo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class QuestionsAdapter extends ArrayAdapter<Question> {


    public QuestionsAdapter(@NonNull Context context, int resource, @NonNull List<Question> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Question question = getItem(position);

        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.question_item,parent,false);
        }

        TextView textView = convertView.findViewById(R.id.no_question);
        //textView.setText("Question " + String.valueOf(position+1));
        textView.setText(question.getQuestion());

        return convertView;
    }
}
