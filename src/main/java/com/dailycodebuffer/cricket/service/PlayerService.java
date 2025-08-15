package com.dailycodebuffer.cricket.service;

import com.dailycodebuffer.cricket.model.PlayerRequest;
import com.dailycodebuffer.cricket.model.PlayerResponse;

import java.util.List;

public interface PlayerService {

    PlayerResponse addPlayer(PlayerRequest playerRequest);

    List<PlayerResponse> getPlayers();

    PlayerResponse getPlayerById(Integer playerId);

    String deletePlayerById(Integer playerId);

    List<PlayerResponse> searchPlayers(String role);
}