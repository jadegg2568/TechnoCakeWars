package ru.jadegg2568.technoCakeWars.game;

import org.bukkit.GameRule;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.BlockState;
import org.bukkit.block.data.BlockData;
import org.bukkit.entity.Entity;

import java.util.ArrayList;
import java.util.List;

public class GameWorld {

    private final Game game;
    private final World world;
    private final List<Location> changes = new ArrayList<>();

    public GameWorld(Game game, World world) {
        this.game = game;
        this.world = world;
    }

    public void setupRules() {
        world.setGameRule(GameRule.DO_MOB_SPAWNING, false);
        world.setGameRule(GameRule.MOB_GRIEFING, false);
        world.setGameRule(GameRule.DO_DAYLIGHT_CYCLE, false);
        world.setGameRule(GameRule.DO_WEATHER_CYCLE, false);
        world.setGameRule(GameRule.DO_FIRE_TICK, false);
        world.setGameRule(GameRule.DO_MOB_LOOT, false);
        world.setGameRule(GameRule.ANNOUNCE_ADVANCEMENTS, false);
    }

    public void deleteEntities() {
        for (Entity entity : world.getLivingEntities()) {
            entity.remove();
        }
        for (Entity entity : world.getEntities()) {
            entity.remove();
        }
    }

    public void saveChange(Location change) {
        if (!hasChange(change))
            changes.add(change);
    }

    public boolean hasChange(Location change) {
        for (Location change1 : changes) {
            if (areEqualLocations(change, change1))
                return true;
        }
        return false;
    }

    public void restoreChanges() {
        for (Location change : changes) {
            change.getBlock().setType(Material.AIR);
        }
    }

    private boolean areEqualLocations(Location loc1, Location loc2) {
        return loc1.getWorld().getName().equals(loc2.getWorld().getName()) &&
                loc1.getBlockX() == loc2.getBlockX() &&
                loc1.getBlockY() == loc2.getBlockY() &&
                loc1.getBlockZ() == loc2.getBlockZ();
    }
}
