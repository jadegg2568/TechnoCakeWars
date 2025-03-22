package ru.jadegg2568.technoCakeWars.game;

import org.bukkit.Location;
import org.bukkit.World;
import ru.jadegg2568.technoCakeWars.config.LocationType;

import java.util.EnumMap;

public record GameConfig(String name, World world, int startPlayers, int maximumPlayers, int teamCount, int playersPerTeam, EnumMap<LocationType, Location> locations) {

}
