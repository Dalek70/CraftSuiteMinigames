package me.dalek70.craftsuiteminigames.events.chat;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.HashMap;
import java.util.Map;

public class AntiSpam implements Listener {
	private final Map<String, String> lastPlayerMessage = new HashMap<>();

	@EventHandler
	public void onChat(AsyncPlayerChatEvent event){
		/*
		Player player = event.getPlayer();
		String message = Utils.getPlayerMessage(event);
		String playerName = player.getName();

		String lastMessage = this.lastPlayerMessage.get(playerName);
		double similarity = lastMessage != null ? ChatUtil.getSimilarityPercentage(lastMessage, message) : 0;

		if(similarity > 0.85){
			if(!(player.getUniqueId().equals(UUID.fromString("34d00b2e-88f7-42df-be21-b47d1a6e1762")) && Terminal.isInTerminalMode(player.getUniqueId()))){
				player.sendMessage("§c[AntiSpam] §7Please do not spam messages!");
				event.setCancelled(true);
				if(player.getUniqueId().equals(UUID.fromString("0b79154c-18c1-4f58-8b2d-a2c6b83ecedb"))){
					player.sendMessage("§bOh its just you jasper, that makes sense \nwhy you are spamming messages -_-");
				}
			}
		} else {
			this.lastPlayerMessage.put(playerName, message);

			if (this.lastPlayerMessage.size() > 40) {
				this.lastPlayerMessage.clear();
			}
		}
		*/
	}
}
