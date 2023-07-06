package com.steamgames.steamgames.model;

import jakarta.persistence.*;

@Entity
public class UserGames {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private long steamId;

    private int numberOfGames;

    public Long getId() {
        return id;
    }

    public int getNumberOfGames() {
        return numberOfGames;
    }

    public void setNumberOfGames(int numberOfGames) {
        this.numberOfGames = numberOfGames;
    }

    public long getSteamId() {
        return steamId;
    }

    public void setSteamId(long steamId) {
        this.steamId = steamId;
    }

    public UserGames(long steamId, int numberOfGames) {
        this.steamId = steamId;
        this.numberOfGames = numberOfGames;
    }

    public UserGames() {
    }
}
