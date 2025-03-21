package ru.jadegg2568.technoCakeWars.config;

import ru.jadegg2568.technoCakeWars.game.GameConfig;
import ru.jadegg2568.technoCakeWars.lobby.LobbyConfig;

import java.util.List;

public record Configuration(LobbyConfig config, List<GameConfig> gameConfigs) {

}
