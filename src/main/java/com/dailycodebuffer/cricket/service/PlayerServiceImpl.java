package com.dailycodebuffer.cricket.service;

import com.dailycodebuffer.cricket.entity.PlayerEntity;
import com.dailycodebuffer.cricket.exception.CricketAppServiceRuntimeException;
import com.dailycodebuffer.cricket.model.PlayerRequest;
import com.dailycodebuffer.cricket.model.PlayerResponse;
import com.dailycodebuffer.cricket.repository.PlayerRepository;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
@Profile("sql")
public class PlayerServiceImpl implements PlayerService{

    private static final Logger log = LogManager.getLogger(PlayerServiceImpl.class);
    @Autowired
    private PlayerRepository playerRepository;

    @Override
    public PlayerResponse addPlayer(PlayerRequest playerRequest) {

        log.info("Inside PlayerService Add Player Method Begins");

        PlayerEntity player = new PlayerEntity();
        PlayerResponse playerResponse = new PlayerResponse();
        BeanUtils.copyProperties(playerRequest, player);

        playerRepository.save(player);

        BeanUtils.copyProperties(player,playerResponse);
        log.info("Inside PlayerService Add Player Method Ends");
        return playerResponse;
    }

    @Override
    public List<PlayerResponse> getPlayers() {
        log.info("Get All Players");
        List<PlayerEntity> playerEntities = playerRepository.findAll();

        List<PlayerResponse> playerResponses = playerEntities
                .stream()
                .map(playerEntity -> {
                        PlayerResponse response = new PlayerResponse();
                    BeanUtils.copyProperties(playerEntity, response);
                    return response;
                })
                .collect(Collectors.toList());

        return playerResponses;
    }

    @Override
    public PlayerResponse getPlayerById(Integer playerId) {
        log.info("Fetching Player for the PlayerId: {}", playerId);

        PlayerEntity player = playerRepository.findById(playerId)
                .orElseThrow(
                        () -> new CricketAppServiceRuntimeException("Player not found with given Id:", "PLAYER_NOT_FOUND")
                );

        PlayerResponse playerResponse = new PlayerResponse();
        BeanUtils.copyProperties(player,playerResponse);
        return playerResponse;
    }

    @Override
    public String deletePlayerById(Integer playerId) {
        playerRepository.deleteById(playerId);
        return "Player with the Id: " + playerId + " is deleted successfully";
    }

    @Override
    public List<PlayerResponse> searchPlayers(String role) {
        log.info("Inside Search Player Method");
        List<PlayerEntity> playerEntities = playerRepository.findAllByRole(role);

        List<PlayerResponse> playerResponses = playerEntities
                .stream()
                .map(playerEntity -> {
                    PlayerResponse response = new PlayerResponse();
                    BeanUtils.copyProperties(playerEntity, response);
                    return response;
                })
                .collect(Collectors.toList());

        return playerResponses;
    }
}