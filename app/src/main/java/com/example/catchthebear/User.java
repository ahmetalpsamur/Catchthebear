package com.example.catchthebear;

public class User {
    private String name;
    private int score;
    
    public User(String name,int score)
    {
        this.name = name;
        this.score = score;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }
}
