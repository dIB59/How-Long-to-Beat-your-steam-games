//package com.steamgames.steamgames.user;
//
//import jakarta.persistence.*;
//
//@Entity
//@Table(name = "game")
//public class Game {
//    @Id
//    @Column(name = "id", nullable = false)
//    private Long id;
//
//    @ManyToOne
//    @JoinColumn(name = "user_games_id")
//    private UserGames userGames;
//
//    public Long getId() {
//        return id;
//    }
//
//    public UserGames getUserGames() {
//        return userGames;
//    }
//
//    public void setUserGames(UserGames userGames) {
//        this.userGames = userGames;
//    }
//}