package com.github.zac694.usefulcommands.commands;

import com.github.zac694.usefulcommands.ConfigHandler;
import dev.jorel.commandapi.CommandAPICommand;
import dev.jorel.commandapi.CommandPermission;
import dev.jorel.commandapi.arguments.PlayerArgument;
import org.bukkit.entity.Player;

public class Feed {
    public static void register(){
        new CommandAPICommand("feed")
                .withArguments(new PlayerArgument("target"))
                .withPermission(CommandPermission.fromString("usefulcommands.feed.others"))
                .executes((sender, args) -> {
                    ((Player)args[0]).setFoodLevel(20);
                    ((Player)args[0]).sendMessage(ConfigHandler.getConfig().getString("OutputPrefix") + "You have been fed");
                    sender.sendMessage(ConfigHandler.getConfig().getString("OutputPrefix") + ((Player)args[0]).getName() + " has been fed");
                }).register();
        new CommandAPICommand("feed")
                .withPermission(CommandPermission.fromString("usefulcommands.feed"))
                .executesPlayer((sender, args) -> {
                    sender.setFoodLevel(20);
                    sender.sendMessage(ConfigHandler.getConfig().getString("OutputPrefix") + "You have been fed");
                }).register();
    }
}
