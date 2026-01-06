package me.dalek70.craftsuiteminigames.commands;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.mineacademy.fo.command.SimpleCommand;

public class FlySpeed extends SimpleCommand {

	public FlySpeed() {
		super("flyspeed");
		setDescription("Sets your flyspeed to change how fast you fly.");
		setUsage("<speed> <player>");
		setMinArguments(1);
		setPermission("craftsuiteminigames.flyspeed");
	}

	@Override
	protected void onCommand() {
		checkConsole();
		float playerFlySpeed = Float.parseFloat(args[0]);
		Player player = getPlayer();
		if(args.length == 2){
			if(Bukkit.getPlayer(args[1]) != null) {
				if(playerFlySpeed >= 0 && playerFlySpeed <= 10){
					Bukkit.getPlayer(args[1]).setFlySpeed(playerFlySpeed / 10);
					if(!Bukkit.getPlayer(args[1]).equals(player)){
						player.sendMessage("§6You have set " + Bukkit.getPlayer(args[1]).getName() + "'s fly speed to §b" + playerFlySpeed);
						Bukkit.getPlayer(args[1]).sendMessage("§6You fly speed has been set to §b" + playerFlySpeed);
					} else {
						player.sendMessage("§6Your fly speed has been set to §b" + playerFlySpeed);
					}
				} else {
					player.sendMessage("§4Error: Range must be from 0 - 10.");
				}
			} else {
				player.sendMessage("§4Error: That player does not exist.");
			}
		} else if(playerFlySpeed >= 0 && playerFlySpeed <= 10){
			player.setFlySpeed(playerFlySpeed / 10);
			player.sendMessage("§6Your fly speed has been set to §b" + playerFlySpeed);
		} else {
			player.sendMessage("§4Error: Range must be from 0 - 10.");
		}
	}
}
