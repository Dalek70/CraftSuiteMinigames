package me.dalek70.craftsuiteminigames;

import me.dalek70.craftsuiteminigames.util.Utils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerTeleportEvent;

public class BackSave implements Listener {
	@EventHandler
	public void onPlayerTeleport(PlayerTeleportEvent event) {
		Player player = event.getPlayer();
		Utils.setBackLocation(player.getUniqueId(), player.getLocation());
	}

	@EventHandler
	public void onPlayerDeath(PlayerDeathEvent event) {
		Player player = event.getEntity();
		Utils.setBackLocation(player.getUniqueId(), player.getLocation());
	}
}
