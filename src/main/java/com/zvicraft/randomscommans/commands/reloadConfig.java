package com.zvicraft.randomscommans.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

import static com.zvicraft.randomscommans.Randomscommans.plugin;
import static com.zvicraft.randomscommans.utils.Utils.colorChat;


public class reloadConfig implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (commandSender.hasPermission("randomCommand.reloadconf")) {
            plugin.reloadConfig();
            commandSender.sendMessage(colorChat("&aConfiguration reloaded successfully."));
        } else {
            commandSender.sendMessage(colorChat("&cYou don't have permission to reload the configuration."));
        }
        return true;

    }
}
