package com.monster2408.banbackwalk;

import com.monster2408.banbackwalk.commands.BanBackWalkCmd;
import com.monster2408.banbackwalk.listeners.BukkitPlayerJoinEvent;
import com.monster2408.banbackwalk.listeners.BukkitPlayerMoveEvent;
import com.monster2408.banbackwalk.utils.api.MainAPI;
import com.monster2408.banbackwalk.utils.api.MsgAPI;
import org.bukkit.plugin.java.JavaPlugin;
import xyz.mlserver.mc.util.CustomConfiguration;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;

public final class BanBackWalk extends JavaPlugin {

    public static CustomConfiguration config, msgYml;
    public static JavaPlugin plugin;

    @Override
    public void onEnable() {
        plugin = this;

        config = new CustomConfiguration(this);
        config.saveDefaultConfig();

        MainAPI.load();

        try {
            msgYml = new CustomConfiguration(this, MainAPI.getMsgConfigFileName());
        } catch (Exception ex) {
            if (MainAPI.isDebugMode()) ex.printStackTrace();
            msgYml = new CustomConfiguration(this, "message_en.yml");
        }
        msgYml.saveDefaultConfig();

        MsgAPI.load();

        getServer().getPluginManager().registerEvents(new BukkitPlayerJoinEvent(), this);
        getServer().getPluginManager().registerEvents(new BukkitPlayerMoveEvent(), this);

        Objects.requireNonNull(getCommand("bbwalk")).setExecutor(new BanBackWalkCmd());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
