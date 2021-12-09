package com.github.zac694.usefulcommands.events;

import com.github.zac694.usefulcommands.util.Util;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){
        if(ConfigHandler.getData().getStringList("vanish").contains(event.getPlayer().getUniqueId().toString())){
            Bukkit.getOnlinePlayers().forEach(player -> event.getPlayer().hidePlayer(UsefulCommands.getMainClass(), player));
        }
        Bukkit.getOnlinePlayers().forEach(player -> {
            if (Util.main().getConfig("vanished").getStringList("vanish")
                    .contains(player.getUniqueId().toString())) {
                event.getPlayer().hidePlayer(Util.main(), player);
            }
        });
    }
}
