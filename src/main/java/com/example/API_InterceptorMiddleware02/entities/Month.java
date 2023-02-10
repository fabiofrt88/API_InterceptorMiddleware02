package com.example.API_InterceptorMiddleware02.entities;


public class Month {
    private Integer MonthNumber;

    private String englishName;

    private String italianName;

    private String germanName;

    public Month(){}

    public Month(Integer monthNumber, String englishName, String italianName, String germanName) {
        MonthNumber = monthNumber;
        this.englishName = englishName;
        this.italianName = italianName;
        this.germanName = germanName;
    }

    public Integer getMonthNumber() {
        return MonthNumber;
    }

    public void setMonthNumber(Integer monthNumber) {
        MonthNumber = monthNumber;
    }

    public String getEnglishName() {
        return englishName;
    }

    public void setEnglishName(String englishName) {
        this.englishName = englishName;
    }

    public String getItalianName() {
        return italianName;
    }

    public void setItalianName(String italianName) {
        this.italianName = italianName;
    }

    public String getGermanName() {
        return germanName;
    }

    public void setGermanName(String germanName) {
        this.germanName = germanName;
    }
}
