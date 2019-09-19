package com.example.score;

public class Score {
    private int id;
    private String name;
    private String room;
    private int score;
    private String date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Score() {
    }

    public Score(int id, String name, String room, int score, String date) {

        this.name = name;
        this.room = room;
        this.score = score;

    }
}
