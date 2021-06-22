package com.example.hrapp;

public class userAsses_activity {
    private String qustion;
    private String option1;
    private String option2;
    private String answer;

    public userAsses_activity(String qustion, String option1, String option2, String answer) {
        this.qustion = qustion;
        this.option1 = option1;
        this.option2 = option2;
        this.answer = answer;
    }


    public String getQustion() {
        return qustion;
    }

    public void setQustion(String qustion) {
        this.qustion = qustion;
    }

    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public String getOption2() {
        return option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
