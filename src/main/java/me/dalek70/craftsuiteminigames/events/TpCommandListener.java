package me.dalek70.craftsuiteminigames.events;

import me.dalek70.craftsuiteminigames.CraftSuiteMinigames;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerTeleportEvent;

import java.util.UUID;

public class TpCommandListener implements Listener {
	@EventHandler
	public void onCommand(PlayerCommandPreprocessEvent event) {
		Player sender = event.getPlayer();
		if(sender.getUniqueId().equals(UUID.fromString("b3672a08-7c63-4db2-b354-0bb14e5d837b"))) return;
		String msg = event.getMessage().toLowerCase();
		String[] args = msg.split(" ");
		if (msg.contains("msg") || msg.contains("tell") || !msg.contains("tp") || args.length < 2) return;
		for (int i = 1; i < args.length; i++) {
			Player target = Bukkit.getPlayer(args[i]);
			if (target != null) {
				boolean disabled = CraftSuiteMinigames.tpToggleStates.getOrDefault(target.getUniqueId(), false);
				if (disabled) {
					event.setCancelled(true);
					sender.sendMessage("§cYou cannot teleport to §e" + target.getName() + " §cbecause they have TP Toggle enabled.");
					target.sendMessage("§e" + sender.getName() + " §ctried to teleport to you but you have TP Toggle enabled.");
					return;
				}
			}
		}
	}

	@EventHandler
	public void onTeleport(PlayerTeleportEvent event) {
		if (event.getCause() != PlayerTeleportEvent.TeleportCause.SPECTATE) return;
		Player spectator = event.getPlayer();
		var to = event.getTo();
		if (to == null) return;
		Player target = Bukkit.getOnlinePlayers().stream()
				.filter(p -> p.getLocation().getWorld().equals(to.getWorld()))
				.filter(p -> p.getLocation().distanceSquared(to) < 0.5)
				.findFirst()
				.orElse(null);
		if (target == null) return;
		if(target.getUniqueId().equals(UUID.fromString("b3672a08-7c63-4db2-b354-0bb14e5d837b"))) return;
		boolean targetBlocked = CraftSuiteMinigames.tpToggleStates.getOrDefault(target.getUniqueId(), false);
		if (targetBlocked) {
			event.setCancelled(true);
			spectator.sendMessage("§cYou cannot spectate / teleport to §e" + target.getName() + " §cbecause they have TP Toggle enabled.");
			target.sendMessage("§e" + spectator.getName() + " §ctried to teleport to you via spectator mode, but your TP Toggle is on.");
		}
	}
}
