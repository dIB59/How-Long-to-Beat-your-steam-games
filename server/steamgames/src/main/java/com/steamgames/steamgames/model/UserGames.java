package com.steamgames.steamgames.model;

import jakarta.persistence.*;

@Entity
public class UserGames {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String personaName;
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

    public String getPersonaName() {
        return personaName;
    }

    public void setPersonaName(String personname) {
        this.personaName = personname;
    }

    public UserGames(long steamId, int numberOfGames, String personaName) {
        this.steamId = steamId;
        this.numberOfGames = numberOfGames;
        this.personaName = personaName;
    }

    public UserGames() {
    }
}
