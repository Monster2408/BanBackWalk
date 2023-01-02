package com.monster2408.banbackwalk;

import org.bukkit.plugin.java.JavaPlugin;
import xyz.mlserver.mc.util.CustomConfiguration;

public final class BanBackWalk extends JavaPlugin {

    public static CustomConfiguration config;

    @Override
    public void onEnable() {
        config = new CustomConfiguration(this);
        config.saveDefaultConfig();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
