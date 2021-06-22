package com.example.hrapp;

public class CountryData {

    private final String country;
    private final String recovered;
    private final String active;
    private final String deaths;
    private final String cases;

    public  CountryData (String country,String recovered,String active,String deaths,String confirmed){
        this.country = country;
        this.active = active;
        this.recovered = recovered;
        this.deaths = deaths;
        this.cases= confirmed;
    }

    public String getCountry() {
        return country;
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

    public String getConfirmed() {
        return cases;
    }
}
