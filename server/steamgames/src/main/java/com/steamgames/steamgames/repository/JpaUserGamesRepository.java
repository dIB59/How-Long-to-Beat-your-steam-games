package com.steamgames.steamgames.repository;

import com.steamgames.steamgames.model.UserGames;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaUserGamesRepository extends JpaRepository<UserGames, Long> {
}
