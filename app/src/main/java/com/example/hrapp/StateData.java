package com.example.hrapp;

public class StateData {

    private final String state;
    private final String recovered;
    private final String active;
    private final String deaths;
    private final String lastupdatedtime;
    private final String confirmed;


    public StateData(String state,String confirmed,String active,String deaths,String lastupdatedtime,String recovered){
        this.state = state;
        this.confirmed = confirmed;
        this.active = active;
        this.deaths = deaths;
        this.lastupdatedtime = lastupdatedtime;
        this.recovered = recovered;
    }

    public String getStateName() {
        return state;
    }

    public String getRecovered() {
        return recovered;
    }

    public String getActive() {
        return active;
    }

    public String getDeaths() {
        return deaths;
    }

    public String getLastupdatedtime() {
        return lastupdatedtime;
    }

    public String getConfirmed() {
        return confirmed;
    }
}
