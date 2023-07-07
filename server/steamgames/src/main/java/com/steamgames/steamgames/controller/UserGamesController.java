package com.steamgames.steamgames.controller;

import com.steamgames.steamgames.model.AddUserDTO;
import com.steamgames.steamgames.model.UserGames;
import com.steamgames.steamgames.service.UserGamesService;
import org.apache.catalina.realm.AuthenticatedUserRealm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public ResponseEntity<?> addUser(@RequestBody AddUserDTO userPost) {
        try {
            UserGames body = service.addUser(userPost.userId());
            logger.info(body.toString());
            return ResponseEntity.ok(body);
        } catch (NumberFormatException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("id") long userId) {
        System.out.println(userId);
        service.deleteUser(userId);
        return ResponseEntity.noContent().build();
    }
}
