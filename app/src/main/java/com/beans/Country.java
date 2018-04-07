package com.beans;


import com.google.gson.annotations.SerializedName;

public class Country {
    @SerializedName("id")
    private String id;

    @SerializedName("countryName")
    private String countryName;

    @SerializedName("population")
    private Integer population;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    public Country(String id, String countryName, Integer population) {
        this.id = id;
        this.countryName = countryName;
        this.population = population;
    }
}
