package ru.jadegg2568.technoCakeWars.game;

import org.bukkit.Color;

import java.util.List;

public record GameTeam(String name, Color color, List<GamePlayer> players, GameCake cake) {

    public boolean canRespawn() {
        return !cake.isEaten();
    }
}
