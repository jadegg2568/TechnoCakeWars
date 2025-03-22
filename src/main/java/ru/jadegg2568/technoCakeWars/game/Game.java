package ru.jadegg2568.technoCakeWars.game;

import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Game {

    private final GameConfig config;
    private final GameWorld world;
    private final List<GamePlayer> players = new ArrayList<>();
    private final List<GameTeam> teams = new ArrayList<>();
    private final AtomicInteger time = new AtomicInteger(0);
    private GameState state = GameState.DISABLED;
    private BukkitRunnable runnable;

    public Game(GameConfig config) {
        this.config = config;
        this.world = new GameWorld(this, config.world());
    }

    public void setup() {
        world.setupRules();
        world.deleteEntities();
    }

    public void unsetup() {
        new ArrayList<>(players).forEach(this::removePlayer);
        world.deleteEntities();
    }

    public void setState(GameState state) {

    }

    public void addPlayer(GamePlayer player) {

    }

    public void removePlayer(GamePlayer player) {

    }

    public List<GamePlayer> getOnlinePlayers() {
        return players.stream()
                .filter(player -> !player.isSpectator())
                .toList();
    }

    public List<GamePlayer> getSpectators() {
        return players.stream()
                .filter(GamePlayer::isSpectator)
                .toList();
    }

    public boolean hasPlayer(GamePlayer player) {
        return players.contains(player);
    }

    public int getOnline() {
        return getOnlinePlayers().size();
    }

    public boolean isWaiting() {
        return state == GameState.WAITING || state == GameState.STARTING;
    }

    public boolean inGame() {
        return state == GameState.PLAYING;
    }

    public GameConfig getConfig() {
        return config;
    }

    public List<GamePlayer> getPlayers() {
        return players;
    }

    public GameState getState() {
        return state;
    }

    public AtomicInteger getTime() {
        return time;
    }
}
