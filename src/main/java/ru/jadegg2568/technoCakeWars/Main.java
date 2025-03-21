package ru.jadegg2568.technoCakeWars;

import org.bukkit.plugin.java.JavaPlugin;
import ru.jadegg2568.technoCakeWars.config.ConfigManager;
import ru.jadegg2568.technoCakeWars.game.GameManager;

public final class Main extends JavaPlugin {

    private ConfigManager configManager;
    private GameManager gameManager;

    @Override
    public void onEnable() {
        configManager = new ConfigManager(this);
        gameManager = new GameManager(this);
    }

    @Override
    public void onDisable() {

    }
}
