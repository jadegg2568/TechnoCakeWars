package ru.jadegg2568.technoCakeWars.config;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.ConfigurationSection;
import ru.jadegg2568.technoCakeWars.Main;
import ru.jadegg2568.technoCakeWars.game.GameConfig;
import ru.jadegg2568.technoCakeWars.lobby.LobbyConfig;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;

public class ConfigManager {

    private Main main;
    private Configuration configuration;

    public ConfigManager(Main main) {
        this.main = main;
        load();
    }

    public void load() {
        main.getConfig().options().copyDefaults(true);
        main.saveDefaultConfig();

        LobbyConfig lobbyConfig = null;
        ConfigurationSection lobbySection = main.getConfig().getConfigurationSection("lobby");
        if (lobbySection != null) {
            String name = lobbySection.getString( "name", "lobby");
            String world = lobbySection.getString( "world", "world");
            int maximumPlayers = lobbySection.getInt("maximumPlayers", 3);
            EnumMap<LocationType, Location> locations = new EnumMap<>(LocationType.class);

            for (LocationType type : LocationType.values()) {
                String path = name + ".locations." + type.name();
                if (lobbySection.contains(path)) {
                    Location location = lobbySection.getLocation(path);
                    locations.put(type, location);
                }
            }
            lobbyConfig = new LobbyConfig(name, Bukkit.getWorld(world), maximumPlayers, locations);
        }

        List<GameConfig> gameConfigs = new ArrayList<>();
        ConfigurationSection gamesSection = main.getConfig().getConfigurationSection("games");
        if (gamesSection != null) {
            for (String name : gamesSection.getKeys(false)) {
                String world = gamesSection.getString(name + ".world", "world");
                int startPlayers = gamesSection.getInt(name + ".startPlayers", 3);
                int maximumPlayers = gamesSection.getInt(name + ".maximumPlayers", 4);
                int teamCount = gamesSection.getInt(name + ".teamCount", 4);
                int playersPerTeam = gamesSection.getInt(name + ".playersPerTeam", 4);
                EnumMap<LocationType, Location> locations = new EnumMap<>(LocationType.class);

                for (LocationType type : LocationType.values()) {
                    String path = name + ".locations." + type.name();
                    if (gamesSection.contains(path)) {
                        Location location = gamesSection.getLocation(path);
                        locations.put(type, location);
                    }
                }
                GameConfig gameConfig = new GameConfig(name, Bukkit.getWorld(world), startPlayers, maximumPlayers, teamCount, playersPerTeam, locations);
                gameConfigs.add(gameConfig);
            }
        }

        this.configuration = new Configuration(lobbyConfig, gameConfigs);
    }

    public Configuration getConfiguration() {
        return configuration;
    }
}

