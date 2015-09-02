package com.games.evdoo.pinballgame;

public class Player {

    private String playerName;
    private String playerCity;
    private int playerScore;

    public Player(String name, String city) {
        this.playerName = name;
        this.playerCity = city;
        this.playerScore = 0;
    }

    public Player(String name, String city, int score) {
        this.playerName = name;
        this.playerCity = city;
        this.playerScore = score;
    }

    public void setPlayerName(String name) {
        this.playerName = name;
    }

    public void setPlayerScore(int score) {
        this.playerScore = score;
    }

    public String getPlayerName() {
        return this.playerName;
    }

    public String getPlayerCity() {
        return this.playerCity;
    }

    public int getPlayerScore() {
        return this.playerScore;
    }
}