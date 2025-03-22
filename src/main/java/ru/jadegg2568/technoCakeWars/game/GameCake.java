package ru.jadegg2568.technoCakeWars.game;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.data.type.Cake;

public class GameCake {

    private final Location spawn;
    private Cake cake;
    private boolean isEaten;

    public GameCake(Location spawn) {
        this.spawn = spawn;
    }

    public boolean isAt(Location spawn1) {
        return spawn.getWorld().getName().equals(spawn1.getWorld().getName()) &&
                spawn.getBlockX() == spawn1.getBlockX() &&
                spawn.getBlockY() == spawn1.getBlockY() &&
                spawn.getBlockZ() == spawn1.getBlockZ();
    }

    public void place() {
        spawn.getBlock().setType(Material.CAKE);
        cake = (Cake) spawn.getBlock().getBlockData();
        isEaten = false;
    }

    public boolean deletePiece() {
        cake.setBites(cake.getBites() - 1);
        if (spawn.getBlock().getType() == Material.AIR)
            isEaten = true;
    }

    public boolean isEaten() {
        return isEaten;
    }
}
