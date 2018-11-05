package edu.austral.starship.base.model;

import edu.austral.starship.base.util.Type;

public class Player {
    private int lives;
    private String name;
    private int score;
    private Type type;

    public Player(int lives, String name, int score) {
        this.lives = lives;
        this.name = name;
        this.score = score;
    }


    public Player(String name,Type type) {
        this.lives=3;
        this.name=name;
        this.score=0;
        this.type=type;
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

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
