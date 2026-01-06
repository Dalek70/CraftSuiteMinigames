package me.dalek70.craftsuiteminigames.commands;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.mineacademy.fo.Common;
import org.mineacademy.fo.command.SimpleCommand;

public class GamemodeCreative extends SimpleCommand {

	public GamemodeCreative() {
		super("gmc");
		setDescription("Changes your gamemode to creative.");
		setUsage("");
		setMinArguments(0);
		setPermission("craftsuiteminigames.gmc");
	}

	@Override
	protected void onCommand() {
		checkConsole();
		Player player = getPlayer();
		Common.runLater(() -> {player.setGameMode(GameMode.CREATIVE);});
	}
}
