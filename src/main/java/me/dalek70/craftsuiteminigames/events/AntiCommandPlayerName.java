package me.dalek70.craftsuiteminigames.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import java.util.UUID;

public class AntiCommandPlayerName implements Listener {
	@EventHandler
	public void onCommand(PlayerCommandPreprocessEvent event) {
		Player player = event.getPlayer();
		String message = event.getMessage();
		if (message.contains("VortexTraveler") || message.contains("aceofshadows") || message.contains("Dalek70")) {
			if (player.getUniqueId().equals(UUID.fromString("0b79154c-18c1-4f58-8b2d-a2c6b83ecedb"))) {
				event.setCancelled(true);
			}
		}
	}
}
