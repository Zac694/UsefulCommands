package com.github.zac694.usefulcommands.events;

import com.github.zac694.usefulcommands.util.Util;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){
        Bukkit.getOnlinePlayers().forEach(player -> {
            if (Util.main().getConfig("vanished").getStringList("vanish")
                    .contains(player.getUniqueId().toString())) {
                event.getPlayer().hidePlayer(Util.main(), player);
            }
        });
    }
}
