package com.monster2408.banbackwalk.utils.api;

import com.monster2408.banbackwalk.BanBackWalk;
import xyz.mlserver.mc.util.CustomConfiguration;

public class MainAPI {

    private static float explosionLevel;
    private static int explosionTime;
    private static int explosionCoolTime;

    private static String msgConfigFileName;

    private static boolean debugMode;

    public static void load() {
        explosionLevel = BanBackWalk.config.getConfig().getInt("explosion-level", 1);
        explosionTime = BanBackWalk.config.getConfig().getInt("explosion-time", 3);
        explosionCoolTime = BanBackWalk.config.getConfig().getInt("explosion-cool-time", 3);
        String fileName = BanBackWalk.config.getConfig().getString("message-config-file-name", "message_en.yml");
        if (msgConfigFileName != null) {
            if (!msgConfigFileName.equalsIgnoreCase(fileName)) {
                msgConfigFileName = fileName;
                try {
                    BanBackWalk.msgYml = new CustomConfiguration(BanBackWalk.plugin, MainAPI.getMsgConfigFileName());
                } catch (Exception ex) {
                    if (MainAPI.isDebugMode()) ex.printStackTrace();
                    BanBackWalk.msgYml = new CustomConfiguration(BanBackWalk.plugin, "message_en.yml");
                }
                BanBackWalk.msgYml.saveDefaultConfig();
                MsgAPI.load();
            }
        } else {
            msgConfigFileName = fileName;
        }
        debugMode = BanBackWalk.config.getConfig().getBoolean("debug", false);
    }

    public static float getExplosionLevel() {
        return explosionLevel;
    }

    public static int getExplosionCoolTime() {
        return explosionCoolTime;
    }

    public static int getExplosionTime() {
        return explosionTime;
    }

    public static String getMsgConfigFileName() {
        return msgConfigFileName;
    }

    public static boolean isDebugMode() {
        return debugMode;
    }
}
