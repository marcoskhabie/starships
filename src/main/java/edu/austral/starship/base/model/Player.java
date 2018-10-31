package edu.austral.starship.base.model;

public class Player {
    private int lives;
    private String name;
    private int score;

    public Player(int lives, String name, int score) {
        this.lives = lives;
        this.name = name;
        this.score = score;
    }

    public Player(String name) {
        this.lives=3;
        this.name=name;
        this.score=0;
    }

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
