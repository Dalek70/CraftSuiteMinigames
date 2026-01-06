package me.dalek70.craftsuiteminigames.commands;

import me.dalek70.craftsuiteminigames.util.Utils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.mineacademy.fo.command.SimpleCommand;

public class SetResourcePack extends SimpleCommand {
	public SetResourcePack() {
		super("setresourcepack");
		setDescription("Teleports you to your previous location.");
		setUsage("<url>");
		setMinArguments(1);
		setPermission("craftsuiteminigames.setresourcepack");
	}

	@Override
	protected void onCommand() {
		checkConsole();
		Player player = getPlayer();
		if(!Utils.isAllowed(player, "cs.setresourcepack"))
			return;
		for (Player playerToSetResourcePack : Bukkit.getOnlinePlayers()) {
			playerToSetResourcePack.setResourcePack(args[0]);
		}
	}
}
