package me.dalek70.craftsuiteminigames.commands;

import me.dalek70.craftsuiteminigames.Database;
import org.bukkit.entity.Player;
import org.mineacademy.fo.command.SimpleCommand;

public class SaveHome extends SimpleCommand {

	public SaveHome() {
		super("savehome");
		setDescription("Saves a new home that can be teleported to later.");
		setUsage("<name>");
		setMinArguments(1);
		setPermission("craftsuiteminigames.savehome");
	}

	@Override
	protected void onCommand() {
		checkConsole();
		Player player = getPlayer();
		if(args.length == 1){
			if(!Database.listHomes(player.getUniqueId()).contains(args[0])){
				Database.saveHome(player.getUniqueId(), args[0], player.getLocation());
				player.sendMessage("§6Saved the home §b" + args[0] + "§6.");
			} else {
				player.sendMessage("§4Error: That home already exists.");
			}
		}
	}
}
