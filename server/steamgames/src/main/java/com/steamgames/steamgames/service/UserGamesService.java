package com.steamgames.steamgames.service;

import com.steamgames.steamgames.fetcher.SteamUserFetcher;
import com.steamgames.steamgames.model.SteamUserDataResponse;
import com.steamgames.steamgames.model.UserGames;
import com.steamgames.steamgames.model.usersummary.SteamUserSummaryDataResponse;
import com.steamgames.steamgames.repository.UserGamesRepository;
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
        SteamUserDataResponse userData = fetcher.fetchSteamUserGamesData(steamIdL);
        SteamUserSummaryDataResponse.ResponseData.Player player = fetcher.fetchSteamUserSummaryData(steamIdL).response().players().get(0);
        System.out.println(userData);
        System.out.println(userData.response().game_count());
        UserGames usergames = new UserGames(steamIdL, userData.response().game_count(), player.personaname());
        repo.saveUserGames(usergames);
        return usergames;
    }

    public void deleteUser(long userId) {
        repo.deleteUserById(userId);
    }
}
