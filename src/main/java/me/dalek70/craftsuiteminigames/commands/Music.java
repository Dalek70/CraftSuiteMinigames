package me.dalek70.craftsuiteminigames.commands;

import me.dalek70.craftsuiteminigames.menus.DiscPlayer;
import org.bukkit.entity.Player;
import org.mineacademy.fo.command.SimpleCommand;

public class Music extends SimpleCommand {
	public Music() {
		super("music");
		setDescription("Teleports you to your previous location.");
		setMinArguments(0);
		setPermission("craftsuiteminigames.music");
	}

	@Override
	protected void onCommand() {
		checkConsole();
		Player player = getPlayer();
		DiscPlayer.open(player);
	}
}
