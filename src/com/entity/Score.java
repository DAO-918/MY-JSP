package com.entity;

public class Score {
    private double english;
    private double math;

    @Override
    public String toString() {
        return "Score{" +
                "english=" + english +
                ", math=" + math +
                '}';
    }

    public Score() {
    }

    public Score(double english, double math) {
        this.english = english;
        this.math = math;
    }

    public double getEnglish() {
        return english;
    }

    public void setEnglish(double english) {
        this.english = english;
    }

    public double getMath() {
        return math;
    }

    public void setMath(double math) {
        this.math = math;
    }
}
