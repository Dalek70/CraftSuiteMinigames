package me.dalek70.craftsuiteminigames.events.chat;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class AntiCap implements Listener {
	@EventHandler
	public void onChat(AsyncPlayerChatEvent event) {
		/* String playerMessage = event.getMessage();
		if (countCapitalLetters(playerMessage) > 9 && !playerMessage.startsWith("!") && !playerMessage.startsWith("?")) {
			if(!(event.getPlayer().getUniqueId().equals(UUID.fromString("34d00b2e-88f7-42df-be21-b47d1a6e1762")) && Terminal.isInTerminalMode(event.getPlayer().getUniqueId()))){
				event.getPlayer().sendMessage("§cToo many caps!");
				for (Player player : Bukkit.getOnlinePlayers()) {
					player.sendMessage("<" + event.getPlayer().getName() + "> " + playerMessage.toLowerCase());
				}
				event.setCancelled(true);
			}
		} */
	}
}
