package com.steamgames.steamgames.service;

import com.steamgames.steamgames.fetcher.SteamUserFetcher;
import com.steamgames.steamgames.model.SteamUserDataResponse;
import com.steamgames.steamgames.model.UserGames;
import com.steamgames.steamgames.repository.UserGamesRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserGamesService {

    UserGamesRepository repo;

    SteamUserFetcher fetcher;

    @Autowired
    public UserGamesService(UserGamesRepository repo) {
        this.repo = repo;
        this.fetcher = new SteamUserFetcher();
    }

    public List<UserGames> listUsers() {
        return repo.listUsers();
    }

    public UserGames addUser(String steamId) {
        long steamIdL = Long.parseLong(steamId);
        SteamUserDataResponse userData = fetcher.fetchSteamUserData(steamIdL);
        UserGames usergames = new UserGames(steamIdL, userData.response().game_count());
        repo.saveUserGames(usergames);
        return null;
    }
}
