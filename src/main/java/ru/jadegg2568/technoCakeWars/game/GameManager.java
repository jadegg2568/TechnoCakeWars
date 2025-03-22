package ru.jadegg2568.technoCakeWars.game;

import ru.jadegg2568.technoCakeWars.Main;
import ru.jadegg2568.technoCakeWars.lobby.LobbyConfig;

import java.util.*;

public class GameManager {

    private final Main main;
    private final List<GamePlayer> players = new ArrayList<>();
    private final Map<String, Game> existingGames = new HashMap<>();
    private final LobbyConfig lobby;

    public GameManager(Main main) {
        this.main = main;
    }

    public void registerPlayer(GamePlayer player) {
        players.add(player);
    }

    public void unregisterPlayer(GamePlayer player) {
        players.remove(player);
    }

    public void registerGame(Game game) {
        existingGames.put(game.getConfig().name(), game);
    }

    public void unregisterGame(String name) {
        existingGames.remove(name);
    }

    public Game getBestGame() {
        return existingGames.values().stream()
                .filter(game -> game.isWaiting() && game.getOnline() < game.getConfig().maximumPlayers())
                .min(Comparator.comparingInt(Game::getOnline)).orElse(null);
    }

    public Map<String, Game> getGames() {
        return existingGames;
    }

    public List<GamePlayer> getPlayers() {
        return players;
    }
}
