package com.zvicraft.randomscommans;

import com.zvicraft.randomscommans.commands.randomCommnads;
import com.zvicraft.randomscommans.commands.reloadConfig;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;


public final class Randomscommans extends JavaPlugin {
    public static Randomscommans plugin;

    public static Plugin getPlugin() {
        return plugin;
    }
    @Override
    public void onEnable() {
        // Plugin startup logic
        loadConfig();
        plugin = this;

        getCommand("reloadconf").setExecutor(new reloadConfig());
        getCommand("random").setExecutor(new randomCommnads());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public void loadConfig() {
        getConfig().options().copyDefaults(true);
        saveDefaultConfig();
    }

    public void doSomethingWithTheData(String message, boolean something) {
    }
}
