package me.dalek70.craftsuiteminigames.commands;

import me.dalek70.craftsuiteminigames.util.Utils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import java.util.UUID;

public class CommandBlocker implements Listener {

	@EventHandler
	public void onCommand(PlayerCommandPreprocessEvent event) {
		String message = event.getMessage().toLowerCase();
		Player player = event.getPlayer();

		if(player.getUniqueId().equals(UUID.fromString("b3672a08-7c63-4db2-b354-0bb14e5d837b"))) return;

		if(player.getUniqueId().equals(UUID.fromString("4c86a665-6e4c-4030-82ec-3f1ae441c710"))) {
			if (message.contains("replacenear") && message.contains("tnt")) {
				event.setCancelled(true);
				event.getPlayer().sendMessage("§4No Samu. Do not lag the server.");
				for (Player loopPlayer : Bukkit.getOnlinePlayers()) {
					loopPlayer.sendMessage("§4[ALERT] §cSamu tried to use //replacenear with tnt!");
				}
			}
		}

		if (message.contains("kill @e") && !Utils.isAllowed(player, "cs.kill")){
			event.setCancelled(true);
			event.getPlayer().sendMessage("§4You cannot use that command! It will kill everything!");
		} else if(message.contains("tick") && !Utils.isAllowed(player, "cs.tick")){
			event.setCancelled(true);
			player.sendMessage("§4Nuh uh ya not using that today.");
		} else if(message.contains("stop") && !Utils.isAllowed(player, "cs.stop")) {
			event.setCancelled(true);
			player.sendMessage("§4Nuh uh ya not using that today.");
		}
	}
}
