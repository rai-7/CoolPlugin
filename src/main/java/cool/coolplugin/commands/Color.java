package cool.coolplugin.commands;

import cool.coolplugin.commands.utilities.CommandUtilities;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import static cool.coolplugin.CoolPlugin.colorize;
import static cool.coolplugin.CoolPlugin.data;

public class Color extends CommandUtilities implements CommandExecutor {

    private static String color = null;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        isPlayer(sender);

        final String path = "players." + sender.getName().toLowerCase() + ".color";

        if (args.length <= 0) {
            sender.sendMessage(colorize("&aOptions: \n&cred, &6orange, &eyellow, &agreen, &9blue, &5purple, &bcyan, &3aqua, &4darkred, &dpink, &fwhite"));
            return true;
        }

        switch (args[0]) {
                case "reset":
                    color = "&a";
                    sender.sendMessage("Reset!");
                    break;
                case "red":
                    color = "&c";
                    sender.sendMessage(colorize("&cRed!"));
                    break;
                case "orange":
                    color = "&6";
                    sender.sendMessage(colorize("&6Orange!"));
                    break;
                case "yellow":
                    color = "&e";
                    sender.sendMessage(colorize("&eYellow!"));
                    break;
                case "green":
                    color = "&a";
                    sender.sendMessage(colorize("&aGreen!"));
                    break;
                case "blue":
                    color = "&9";
                    sender.sendMessage(colorize("&9Blue!"));
                    break;
                case "purple":
                    color = "&5";
                    sender.sendMessage(colorize("&5Purple!"));
                    break;
                case "cyan":
                    color = "&b";
                    sender.sendMessage(colorize("&bCyan!"));
                    break;
                case "aqua":
                    color = "&3";
                    sender.sendMessage(colorize("&3Aqua!"));
                    break;
                case "darkred":
                    color = "&4";
                    sender.sendMessage(colorize("&4Dark Red!"));
                    break;
                case "pink":
                    color = "&d";
                    sender.sendMessage(colorize("&dPink!"));
                    break;
                case "white":
                    color = "&f";
                    sender.sendMessage("White!");
            }

        data.getConfig().set(path, color);
        data.saveConfig();
        return true;
    }
}
