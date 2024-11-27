package com.example.uhabit;

public class Habit {
    private String name;
    private String explanation;
    private String startDate;

    public Habit(String name, String explanation, String startDate) {
        this.name = name;
        this.explanation = explanation;
        this.startDate = startDate;
    }

    public String getName() {
        return name;
    }

    public String getExplanation() {
        return explanation;
    }

    public String getStartDate() {
        return startDate;
    }
}
