package com.dailycodebuffer.cricket.controller;

import com.dailycodebuffer.cricket.model.PlayerRequest;
import com.dailycodebuffer.cricket.model.PlayerResponse;
import com.dailycodebuffer.cricket.service.PlayerService;
import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/player")
@Log4j2
public class PlayerController {

    private static final Logger log = LogManager.getLogger(PlayerController.class);
    @Autowired
    private PlayerService playerService;

    @PostMapping
    public ResponseEntity<PlayerResponse> addPlayer(@Valid @RequestBody PlayerRequest playerRequest) {
        log.info("Inside PlayerController AddPlayer Method");
        PlayerResponse playerResponse = playerService.addPlayer(playerRequest);
        return new ResponseEntity<>(playerResponse, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<PlayerResponse>> getPlayers() {
        List<PlayerResponse> playerResponses = playerService.getPlayers();
        return  new ResponseEntity<>(playerResponses, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlayerResponse> getPlayerById(@PathVariable("id") Integer playerId) {
        PlayerResponse response = playerService.getPlayerById(playerId);
        return  new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePlayerById(@PathVariable("id") Integer playerId) {
        String message = playerService.deletePlayerById(playerId);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<List<PlayerResponse>> searchPlayers(
            @RequestParam("role") String role
    ) {
        List<PlayerResponse> playerResponses = playerService.searchPlayers(role);
        return new ResponseEntity<>(playerResponses, HttpStatus.OK);
    }
}
