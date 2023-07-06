package com.steamgames.steamgames.repository;

import com.steamgames.steamgames.model.UserGames;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserGamesRepository {

    JpaUserGamesRepository repo;
    @Autowired
    public UserGamesRepository(JpaUserGamesRepository repo) {
        this.repo = repo;
    }

    public List<UserGames> listUsers() {
        return repo.findAll();
    }

    public void saveUserGames(UserGames userGames) {
        System.out.println(userGames);
        repo.save(userGames);
    }
}
