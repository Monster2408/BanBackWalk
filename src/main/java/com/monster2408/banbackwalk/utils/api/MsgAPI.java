package com.monster2408.banbackwalk.utils.api;

import com.monster2408.banbackwalk.BanBackWalk;

public class MsgAPI {

    private static String reloadConfigCommandDescription;
    private static String reloadedConfig;
    private static String reloadMsgConfigCommandDescription;
    private static String reloadedMsgConfig;

    public static void load() {
        reloadConfigCommandDescription = BanBackWalk.msgYml.getConfig().getString(
                "reload-config-command-description", "Reload config.yml.");
        reloadedConfig = BanBackWalk.msgYml.getConfig().getString(
                "config-reloaded", "Reloaded config.yml.");
        reloadMsgConfigCommandDescription = BanBackWalk.msgYml.getConfig().getString(
                "reload-msg-config-command-description", "Reload message.yml.");
        reloadedMsgConfig = BanBackWalk.msgYml.getConfig().getString(
                "config-msg-reloaded", "Reloaded message.yml.");
    }

    public static String getReloadMsgConfigCommandDescription() {
        return reloadMsgConfigCommandDescription;
    }

    public static String getReloadedConfig() {
        return reloadedConfig;
    }

    public static String getReloadConfigCommandDescription() {
        return reloadConfigCommandDescription;
    }

    public static String getReloadedMsgConfig() {
        return reloadedMsgConfig;
    }
}
