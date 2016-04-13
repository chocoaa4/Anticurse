package me.chocoaa.anticurse;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.java.JavaPlugin;

import net.md_5.bungee.api.ChatColor;

public class Anticurse extends JavaPlugin implements Listener {
	
	@EventHandler
	public void onPlayerChat(AsyncPlayerChatEvent e) {
		for (String word : e.getMessage().split(" ")) {
			if (getConfig().getStringList("badwords").contains(word)) {
				e.setCancelled(true);
				e.getPlayer().sendMessage(ChatColor.RED + "Don't curse!");
			}
		}
		
	}
	
	
	
	
	
	public void onEnable() {
		getConfig().options().copyDefaults(true);
		saveConfig();
		Bukkit.getServer().getPluginManager().registerEvents(this,  this);
		
	}

}
