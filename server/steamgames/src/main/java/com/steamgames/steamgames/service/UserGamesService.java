package com.steamgames.steamgames.service;

import com.steamgames.steamgames.fetcher.HlbtFetcher;
import com.steamgames.steamgames.fetcher.SteamUserFetcher;
import com.steamgames.steamgames.model.GameRecord;
import com.steamgames.steamgames.model.SteamUserDataResponse;
import com.steamgames.steamgames.model.UserGames;
import com.steamgames.steamgames.model.hlbt.Data;
import com.steamgames.steamgames.model.hlbt.HlbtResponseRecord;
import com.steamgames.steamgames.model.usersummary.SteamUserSummaryDataResponse;
import com.steamgames.steamgames.repository.UserGamesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.stream.IntStream;

@Service
public class UserGamesService {

    UserGamesRepository repo;
    SteamUserFetcher fetcher;
    HlbtFetcher hlbtFetcher;

    @Autowired
    public UserGamesService(UserGamesRepository repo,
                            SteamUserFetcher fetcher,
                            HlbtFetcher hlbtFetcher) {
        this.repo = repo;
        this.fetcher = fetcher;
        this.hlbtFetcher = hlbtFetcher;
    }

    public List<UserGames> listUsers() {
        return repo.listUsers();
    }

    public UserGames addUser(String steamId) {
        long steamIdL = Long.parseLong(steamId);
        SteamUserDataResponse userData = fetcher.fetchSteamUserGamesData(steamIdL);
        SteamUserSummaryDataResponse.ResponseData.Player player = fetcher.fetchSteamUserSummaryData(steamIdL).response().players().get(0);

        int totalPlayTime = userData.response().games().stream()
                .mapToInt(GameRecord::playtimeForever)
                .sum()/60;

        Mono<Integer> timeToPlayAllGames = Flux.fromIterable(userData.response().games())
                .flatMap(game -> {
                    Mono<HlbtResponseRecord> hlbtResponseMono = hlbtFetcher.fetchHlbtData(game.name());
                    return hlbtResponseMono.flatMapMany(hlbtResponse -> Flux.fromIterable(hlbtResponse.data()))
                            .map(Data::comp_plus)
                            .reduce(Integer::sum)
                            .defaultIfEmpty(0);
                })
                .reduce(Integer::sum)
                .defaultIfEmpty(0);

        if (userData.response().games() == null) {
            UserGames usergames = new UserGames(steamIdL,
                    -1,
                    player.personaname(),
                    -1,
                    -1);
            repo.saveUserGames(usergames);
            return usergames;
        }

        int timeToPlayAllGamesInList = timeToPlayAllGames.block();

        UserGames usergames = new UserGames(steamIdL,
                userData.response().game_count(),
                player.personaname(),
                totalPlayTime,
                timeToPlayAllGamesInList);

        repo.saveUserGames(usergames);
        return usergames;
    }

    public void deleteUser(long userId) {
        repo.deleteUserById(userId);
    }
}
