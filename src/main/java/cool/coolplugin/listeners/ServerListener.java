package cool.coolplugin.listeners;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;

import static cool.coolplugin.CoolPlugin.colorize;
import static cool.coolplugin.CoolPlugin.data;

public class ServerListener implements Listener {

    public static String checkPrefix(OfflinePlayer player) {
        if (player.isOp()) {
            return colorize("&c&lOp&r ");
        }
        return null;
    }
    
    @EventHandler
    public void chatFormat (AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();
        String path = "players." + player.getUniqueId().toString()  + ".color";
        String prefix = "";

        // Give prefix if the player is op
        if (!(data.getConfig().get(path) == null)) {
            event.setFormat(colorize(prefix + data.getConfig().get(path) + player.getDisplayName() + "&7: &r" + event.getMessage()));
        } else {
            event.setFormat(colorize(prefix + "&a" + player.getDisplayName() + "&7: &r" + event.getMessage()));
        }
    }

    @EventHandler
    public void playerJoinEvent (PlayerJoinEvent event) {
        Player player = event.getPlayer();

        // Apply changes to data.yml and save
        data.getConfig().set("uuids." + player.getName().toLowerCase() + ".uuid", player.getUniqueId().toString());
        data.saveConfig();
    }
}