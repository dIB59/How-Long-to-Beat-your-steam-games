package com.steamgames.steamgames.model;

import jakarta.persistence.*;

@Entity
public class UserGames {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String personaName;
    private String steamId;
    private int numberOfGames;
    private int totalPlaytime;
    private int timeToPlayAllGames;

    public int getTimeToPlayAllGames() {
        return timeToPlayAllGames;
    }

    public void setTimeToPlayAllGames(int timeToPlayAllGames) {
        this.timeToPlayAllGames = timeToPlayAllGames;
    }

    public int getTotalPlaytime() {
        return totalPlaytime;
    }

    public void setTotalPlaytime(int totalPlaytime) {
        this.totalPlaytime = totalPlaytime;
    }

    public Long getId() {
        return id;
    }

    public int getNumberOfGames() {
        return numberOfGames;
    }

    public void setNumberOfGames(int numberOfGames) {
        this.numberOfGames = numberOfGames;
    }

    public String getSteamId() {
        return steamId;
    }

    public void setSteamId(String steamId) {
        this.steamId = steamId;
    }

    public String getPersonaName() {
        return personaName;
    }

    public void setPersonaName(String personname) {
        this.personaName = personname;
    }

    public UserGames(String steamId, int numberOfGames, String personaName, int totalPlaytime, int timeToPlayAllGames) {
        this.steamId = steamId;
        this.numberOfGames = numberOfGames;
        this.personaName = personaName;
        this.totalPlaytime = totalPlaytime;
        this.timeToPlayAllGames = timeToPlayAllGames;
    }

    public UserGames() {
    }
}
