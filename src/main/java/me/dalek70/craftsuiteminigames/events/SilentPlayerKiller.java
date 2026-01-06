package me.dalek70.craftsuiteminigames.events;

import me.dalek70.craftsuiteminigames.util.Utils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class SilentPlayerKiller implements Listener {
	// >:D
	@EventHandler
	public void onChat(AsyncPlayerChatEvent event){
		String message = event.getMessage().toLowerCase();
		Player player = event.getPlayer();
		if(Utils.isAllowed(player, "cs.muhahah_kill")) {
			if(message.startsWith("!sethealth ")) {
				event.setCancelled(true);
				String[] splitMessage = Utils.splitString(message);
				try {
					Player playerToKill = Bukkit.getPlayer(splitMessage[1]);
					playerToKill.setHealth(Integer.parseInt(splitMessage[2]));
				} catch (Exception e) {
					if(e.toString().equals("java.lang.NullPointerException: Cannot invoke \"org.bukkit.entity.Player.setHealth(double)\" because \"playerToKill\" is null")) {
						player.sendMessage("§4Error: §cPlayer does not exist or is offline.");
					} else if(e.toString().startsWith("java.lang.IllegalArgumentException: Health value")) {
						player.sendMessage("§4Error: §cHealth value must be between 0 and 20.");
					}
				}
			} else if(message.startsWith("!kill")) {
				event.setCancelled(true);
				try {
					Player playerToKill = Bukkit.getPlayer(message.substring(6));
					playerToKill.setHealth(0);
				} catch (NullPointerException e) {
					player.sendMessage("§4Error: §cPlayer does not exist or is offline.");
				}
			}
		}
	}
}
