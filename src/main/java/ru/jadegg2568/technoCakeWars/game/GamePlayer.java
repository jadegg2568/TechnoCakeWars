package ru.jadegg2568.technoCakeWars.game;

import net.kyori.adventure.text.Component;
import org.bukkit.GameMode;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class GamePlayer {

    private final String name;
    private final Player p;
    private boolean isSpectator;

    public GamePlayer(String name, Player p) {
        this.name = name;
        this.p = p;
        this.isSpectator = false;
    }

    public boolean isOnline() {
        return p != null && p.isOnline();
    }

    public void sendMessage(Component component) {
        p.sendMessage(component);
    }

    public void sendTitle(String title, String subtitle, int fadeIn, int fadeTime, int fadeOut) {
        p.sendTitle(title, subtitle, fadeIn, fadeTime, fadeOut);
    }

    public void sendActionBar(Component component) {
        p.sendActionBar(component);
    }

    public void playSound(Sound sound) {
        p.playSound(p.getLocation(), sound, 1, 1);
    }

    public void playSound(Sound sound, float volume, float pitch) {
        p.playSound(p.getLocation(), sound, volume, pitch);
    }

    public void setSpectator(boolean set) {
        this.isSpectator = set;
        p.setGameMode(set ? GameMode.SPECTATOR : GameMode.SURVIVAL);
    }

    public boolean isSpectator() {
        return isSpectator;
    }

    public String getName() {
        return name;
    }

    public Player getPlayer() {
        return p;
    }
}
