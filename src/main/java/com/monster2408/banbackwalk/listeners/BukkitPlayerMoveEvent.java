package com.monster2408.banbackwalk.listeners;

import com.monster2408.banbackwalk.BanBackWalk;
import com.monster2408.banbackwalk.utils.api.MainAPI;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class BukkitPlayerMoveEvent implements Listener {

    private boolean isBackWalk(Location to, Location from, Player player) {
        Location loc = player.getLocation().clone();
        double yaw = loc.getYaw();
        if (-45 <= yaw && yaw < 45) { // Z--
            return (to.getBlockZ() < from.getBlockZ());
        } else if (45 <= yaw && yaw < 135) { // X++
            return (to.getBlockX() > from.getBlockX());
        } else if (-135 <= yaw && yaw < -45) { // X--
            return (to.getBlockX() < from.getBlockX());
        } else { // Z++
            return (to.getBlockZ() > from.getBlockZ());
        }
    }

    private static List<UUID> timeCoolList;

    @EventHandler
    public void on(PlayerMoveEvent e) {
        Player player = e.getPlayer();
        UUID uuid = player.getUniqueId();
        Location loc = player.getLocation().clone();
        Location to = e.getTo();
        Location from = e.getFrom();
        if (timeCoolList == null) timeCoolList = new ArrayList<>();
        if (isBackWalk(to, from, player) && !timeCoolList.contains(uuid)) {
            timeCoolList.add(uuid);
            if (loc.getWorld() == null) return;
            for (int n = 0; n < MainAPI.getExplosionTime(); n++) loc.getWorld().createExplosion(loc, MainAPI.getExplosionLevel());
            new BukkitRunnable() {
                @Override
                public void run() {
                    removeCoolTime(uuid);
                }
            }.runTaskLaterAsynchronously(BanBackWalk.plugin, MainAPI.getExplosionCoolTime()*20L);
        }
    }

    public static void removeCoolTime(UUID uuid) {
        if (timeCoolList == null) timeCoolList = new ArrayList<>();
        timeCoolList.remove(uuid);
    }


}
