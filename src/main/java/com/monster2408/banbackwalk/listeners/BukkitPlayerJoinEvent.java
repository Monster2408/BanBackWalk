package com.monster2408.banbackwalk.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class BukkitPlayerJoinEvent implements Listener {

    @EventHandler
    public void on(PlayerJoinEvent e) {
        BukkitPlayerMoveEvent.removeCoolTime(e.getPlayer().getUniqueId());
    }

}
