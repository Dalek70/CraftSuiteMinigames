package me.dalek70.craftsuiteminigames.commands;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.mineacademy.fo.command.SimpleCommand;

public class Fly extends SimpleCommand {

	public Fly() {
		super("fly");
		setDescription("Toggles if you can fly or not.");
		setUsage("<player>");
		setMinArguments(0);
		setPermission("craftsuiteminigames.fly");
	}

	@Override
	protected void onCommand() {
		checkConsole();
		Player playerSelf = getPlayer();
		if(args.length == 1){
			Player playerOther = Bukkit.getPlayer(args[0]);
			if(playerOther != null){
				playerOther.setAllowFlight(!playerOther.getAllowFlight());
				playerOther.sendMessage(playerOther.getAllowFlight() ? "§6Your flight has been enabled." : "§6Your flight has been disabled.");
				playerSelf.sendMessage(playerOther.getAllowFlight() ? ("§6You have enabled flight for §b" + playerOther.getName() + "§6.") : ("§6You have disabled flight for §b" + playerOther.getName() + "§6."));
			} else {
				playerSelf.sendMessage("§4Error: That player does not exist.");
			}
		} else {
			playerSelf.setAllowFlight(!playerSelf.getAllowFlight());
			playerSelf.sendMessage(playerSelf.getAllowFlight() ? "§6You have enabled flight." : "§6You have disabled flight.");
		}
	}
}
