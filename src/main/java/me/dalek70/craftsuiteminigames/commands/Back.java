package me.dalek70.craftsuiteminigames.commands;

import me.dalek70.craftsuiteminigames.util.Utils;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.mineacademy.fo.command.SimpleCommand;

public class Back extends SimpleCommand {
	public Back() {
		super("back");
		setDescription("Teleports you to your previous location.");
		setUsage("back");
		setMinArguments(0);
		setPermission("craftsuiteminigames.back");
	}

	@Override
	protected void onCommand() {
		checkConsole();
		Player player = getPlayer();
		Location location = Utils.getBackLocation(player.getUniqueId());

		if(location != null){
			player.setFallDistance(0);
			player.teleport(location);
			player.sendMessage("§6You have been teleported to your previous location.");
		} else {
			player.sendMessage("§4Error: You have no previous location.");
		}
	}
}
