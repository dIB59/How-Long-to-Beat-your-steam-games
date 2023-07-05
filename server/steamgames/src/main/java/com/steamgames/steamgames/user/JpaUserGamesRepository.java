package com.steamgames.steamgames.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaUserGamesRepository extends JpaRepository<UserGames, Long> {
}
