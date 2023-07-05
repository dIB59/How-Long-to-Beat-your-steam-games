package com.steamgames.steamgames.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserGamesService {

    UserGamesRepository repo;

    @Autowired
    public UserGamesService(UserGamesRepository repo) {
        this.repo = repo;
    }

    public List<UserGames> listUsers() {
        return repo.listUsers();
    }
}
