package com.monster2408.banbackwalk.commands;

import com.monster2408.banbackwalk.BanBackWalk;
import com.monster2408.banbackwalk.utils.api.MainAPI;
import com.monster2408.banbackwalk.utils.api.MsgAPI;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import xyz.mlserver.mc.util.command.CmdUtil;

public class BanBackWalkCmd implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 0) cmdUtil.send(sender, 1, true);
        else {
            if (args.length > 1) cmdUtil.send(sender, 1, true);
            else if (args[0].equalsIgnoreCase("reload")) {
                BanBackWalk.config.reloadConfig();
                MainAPI.load();
                sender.sendMessage(ChatColor.AQUA + MsgAPI.getReloadedConfig());
            } else if (args[0].equalsIgnoreCase("msg-reload")) {
                BanBackWalk.msgYml.reloadConfig();
                MsgAPI.load();
                sender.sendMessage(ChatColor.AQUA + MsgAPI.getReloadedMsgConfig());
            } else cmdUtil.send(sender, 1, true);
        }
        return false;
    }

    private static final CmdUtil cmdUtil = new CmdUtil()
            .addOP("/bbwalk reload", MsgAPI.getReloadConfigCommandDescription())
            .addOP("/bbwalk msg-reload", MsgAPI.getReloadMsgConfigCommandDescription())
            ;

}
