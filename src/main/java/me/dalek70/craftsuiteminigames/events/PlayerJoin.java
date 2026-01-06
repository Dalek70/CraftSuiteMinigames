package me.dalek70.craftsuiteminigames.events;

import me.dalek70.craftsuiteminigames.CraftSuiteMinigames;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin implements Listener {
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
		Player newPlayer = event.getPlayer();
		String playerName = newPlayer.getName();
		event.setJoinMessage("§bWelcome " + playerName + "!");
		CraftSuiteMinigames.playerStates.putIfAbsent(newPlayer.getUniqueId(), false);

	}
}
