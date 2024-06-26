package com.zvicraft.randomscommans.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.Random;

import static com.zvicraft.randomscommans.Randomscommans.plugin;
import static com.zvicraft.randomscommans.utils.Utils.colorChat;

public class randomCommnads implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        // Check if the command sender is a player
        if (commandSender.hasPermission("randomCommand.randomcommand")) {

            if (!(commandSender instanceof Player)) {
                commandSender.sendMessage("Only players can execute this command.");
                return true;
            }

            Player player = Bukkit.getPlayer(Bukkit.getName());
            List<String> list = plugin.getConfig().getStringList("random.titels");

            Random rand = new Random();

            // Loop through all messages in the list and send a random onea to the player
            int randomIndex = rand.nextInt(list.size());
            String randomElement = list.get(randomIndex);
            String randomitemsI = randomElement;
            for (Player pl : Bukkit.getOnlinePlayers()) {
                // send  'player' title
                pl.sendTitle(colorChat(plugin.getConfig().getString("titel-alert")), colorChat(randomitemsI));
            }
            
            String thsd = "\n" + plugin.getConfig().getString("brodcast-thas") + "\n";
            Bukkit.broadcastMessage(colorChat( thsd + plugin.getConfig().getString("titel-brodcast") + "\n" + randomitemsI + thsd));
        }
        else{
            commandSender.sendMessage(colorChat("&cYou don't have permission to random command."));

        }
        return true;
    }
}
