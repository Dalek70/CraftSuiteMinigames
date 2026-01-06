package me.dalek70.craftsuiteminigames.commands;

import me.dalek70.craftsuiteminigames.Database;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.mineacademy.fo.command.SimpleCommand;

import java.util.List;

public class Home extends SimpleCommand {

	public Home() {
		super("home");
		setDescription("Teleports you to the home.");
		setUsage("<name>");
		setMinArguments(1);
		setPermission("craftsuiteminigames.home");
	}

	@Override
	protected void onCommand() {
		checkConsole();
		Player player = getPlayer();
		if(args.length == 1){
			Location homeLocation = Database.loadHome(player.getUniqueId(), args[0]);
			if(homeLocation != null){
				player.setFallDistance(0);
				player.teleport(homeLocation);
				player.sendMessage("§6Teleported to saved home §b" + args[0] + "§6 at §bX: " + homeLocation.getBlockX() + " Y: " + homeLocation.getBlockY() + " Z: " +homeLocation.getBlockZ() + "§6.");
			} else {
				player.sendMessage("§4Error: That home does not exist.");
			}
		}
	}

	@Override
	protected List<String> tabComplete() {
		if (args.length == 1) {
			return completeLastWord(Database.listHomes(getPlayer().getUniqueId()));
		}
		return NO_COMPLETE;
	}
}
