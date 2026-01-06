package me.dalek70.craftsuiteminigames.commands;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.mineacademy.fo.Common;
import org.mineacademy.fo.command.SimpleCommand;

public class GamemodeSurvival extends SimpleCommand {

	public GamemodeSurvival() {
		super("gms");
		setDescription("Changes your gamemode to survival.");
		setUsage("");
		setMinArguments(0);
		setPermission("craftsuiteminigames.gms");
	}

	@Override
	protected void onCommand() {
		checkConsole();
		Player player = getPlayer();
		Common.runLater(() -> {player.setGameMode(GameMode.SURVIVAL);});
	}
}
