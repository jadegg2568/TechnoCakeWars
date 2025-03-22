package ru.jadegg2568.technoCakeWars.lobby;

import ru.jadegg2568.technoCakeWars.game.GamePlayer;

import java.util.List;

public class Lobby {

    private final LobbyConfig config;
    private final List<GamePlayer> players;

    public Lobby(LobbyConfig config, List<GamePlayer> players) {
        this.config = config;
        this.players = players;
    }

    public void addPlayer(GamePlayer player) {

    }

    public void removePlayer(GamePlayer player) {

    }
}
