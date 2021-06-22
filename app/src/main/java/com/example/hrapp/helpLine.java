package com.example.hrapp;

public class helpLine {

    private final String loc;
    private final String number;



    public helpLine(String loc,String number){
        this.loc = loc;
        this.number =number;
    }


    public String getStatename() {
        return loc;
    }

    public String getStatename_num() {
        return number;
    }
}
