package me.dalek70.craftsuiteminigames.commands;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.mineacademy.fo.command.SimpleCommand;

public class Ping extends SimpleCommand {

	public Ping() {
		super("ping");
		setDescription("Tells you your ping.");
		setUsage("<player>");
		setMinArguments(0);
	}

	@Override
	protected void onCommand() {
		checkConsole();
		Player player = getPlayer();
		if(args.length == 0){
			player.sendMessage("§6Your ping is §b" + player.getPing() + "§6ms.");
		} else if(args.length == 1) {
			if(Bukkit.getPlayer(args[0]) != null) {
				player.sendMessage("§b" + args[0] + "§6's ping is §b" + Bukkit.getPlayer(args[0]).getPing() + "§6ms");
			} else {
				player.sendMessage("§4Error: That player does not exist.");
			}
		}
	}
}
