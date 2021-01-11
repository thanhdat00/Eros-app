package com.example.eros_demo;

import java.util.List;

public class User {
    String userName;
    String phoneNumber;
    String location;
    List<Question> questionList;

    public User(String userName, String phoneNumber, String location, List<Question> questionList) {
        this.userName = userName;
        this.phoneNumber = phoneNumber;
        this.location = location;
        this.questionList = questionList;
    }

    public String getUserName() {
        return userName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getLocation() {
        return location;
    }

    public List<Question> getQuestionList() {
        return questionList;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setQuestionList(List<Question> questionList) {
        this.questionList = questionList;
    }

}
