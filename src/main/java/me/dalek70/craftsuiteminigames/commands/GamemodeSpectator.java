package me.dalek70.craftsuiteminigames.commands;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.mineacademy.fo.Common;
import org.mineacademy.fo.command.SimpleCommand;

public class GamemodeSpectator extends SimpleCommand {

	public GamemodeSpectator() {
		super("gmsp");
		setDescription("Changes your gamemode to spectator.");
		setUsage("");
		setMinArguments(0);
		setPermission("craftsuiteminigames.gmsp");
	}

	@Override
	protected void onCommand() {
		checkConsole();
		Player player = getPlayer();
		Common.runLater(() -> {player.setGameMode(GameMode.SPECTATOR);});
	}
}
