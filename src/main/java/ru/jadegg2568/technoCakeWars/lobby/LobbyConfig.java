package ru.jadegg2568.technoCakeWars.lobby;

import org.bukkit.Location;
import org.bukkit.World;
import ru.jadegg2568.technoCakeWars.config.LocationType;

import java.util.Map;

public record LobbyConfig(String name, World world, int maximumPlayers, Map<LocationType, Location> locations) {

}