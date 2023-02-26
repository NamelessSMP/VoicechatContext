package ru.thecatrix.voicechatcontext;

import de.maxhenkel.voicechat.api.BukkitVoicechatService;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.UUID;

public final class VoicechatContext extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        BukkitVoicechatService service = getServer().getServicesManager().load(BukkitVoicechatService.class);
        if (service != null) {
            service.registerPlugin(new VoicechatApiPlugin());
        }
        if (getServer().getPluginManager().getPlugin("LuckPerms") != null) {
            new LuckpermsContextPlugin();
        }
        Bukkit.getPluginManager().registerEvents(this, this);
    }

    public static HashMap<UUID, Boolean> playerVoicechat = new HashMap<>();

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        playerVoicechat.put(event.getPlayer().getUniqueId(), false);
    }
}
