package me.dalek70.craftsuiteminigames.events;

import me.dalek70.craftsuiteminigames.util.Utils;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class NoCommandBlock implements Listener {
	@EventHandler
	public void onCommandBlockPlace(BlockPlaceEvent event) {
		Block block = event.getBlock();
		if(block != null) {
			if (block.getType().name().contains("COMMAND_BLOCK")) {
				if(Utils.isAllowed(event.getPlayer(), "cs.cmd_block")) return;
				event.setCancelled(true);
				event.getPlayer().sendMessage("§cPlacing command blocks is disabled on this server.");
			}
		}
	}

	@EventHandler
	public void onCommandBlockInteract(PlayerInteractEvent event) {
		Block block = event.getClickedBlock();
		if(block != null) {
			if(block.getType().name().contains("COMMAND_BLOCK")) {
				if(Utils.isAllowed(event.getPlayer(), "cs.cmd_block")) return;
				event.setCancelled(true);
				event.getPlayer().sendMessage("§cInteracting with command blocks is disabled on this server.");
			}
		}
	}
}
