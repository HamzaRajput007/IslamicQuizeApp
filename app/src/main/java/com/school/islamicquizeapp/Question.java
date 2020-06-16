package com.school.islamicquizeapp;

public class Question {
    String questionStatement , optionOne , optionTwo , optionThree ,optionFour , rightOption;

    public Question(String questionStatement, String optionOne, String optionTwo, String optionThree, String optionFour , String rightOption) {
        this.questionStatement = questionStatement;
        this.optionOne = optionOne;
        this.optionTwo = optionTwo;
        this.optionThree = optionThree;
        this.optionFour = optionFour;
        this.rightOption = rightOption;
    }

    public String getQuestionStatement() {
        return questionStatement;
    }

    public String getOptionOne() {
        return optionOne;
    }

    public String getOptionTwo() {
        return optionTwo;
    }

    public String getOptionThree() {
        return optionThree;
    }

    public String getOptionFour() {
        return optionFour;
    }

    public String getRightOption(){
        return rightOption;
    }
}
