package com.steamgames.steamgames.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/users")
public class UserGamesController {

    Logger logger = Logger.getLogger(UserGames.class.getName());
    private final UserGamesService service;

    @Autowired
    public UserGamesController(UserGamesService service) {
        this.service = service;
    }
    @GetMapping
    public ResponseEntity<List<UserGames>> getUsers() {
        List<UserGames> body = service.listUsers();
        logger.info(body.toString());
        return ResponseEntity.ok(body);
    }
}
