package me.dalek70.craftsuiteminigames.commands;

import me.dalek70.craftsuiteminigames.util.Utils;
import org.bukkit.entity.Player;
import org.mineacademy.fo.command.SimpleCommand;

import java.util.ArrayList;
import java.util.List;

public class Toggle extends SimpleCommand {
	public Toggle() {
		super("toggle");
		setDescription("Toggles the thing.");
		setUsage("<thing>");
		setMinArguments(1);
		setPermission("craftsuiteminigames.toggle");
	}

	@Override
	protected void onCommand() {
		checkConsole();
		Player player = getPlayer();
		if (!Utils.isAllowed(player, "cs.toggle"))
			return;
		switch (args[0]) {
			case "Visible" -> {
				player.setInvisible(!player.isInvisible());
			}

			case "Glowing" -> {
				player.setGlowing(!player.isGlowing());
			}

			case "Gravity" -> {
				player.setGravity(!player.hasGravity());
			}
		}
	}

	@Override
	protected List<String> tabComplete() {
		if (args.length == 1) {
			return new ArrayList<>(List.of("Visible", "Glowing", "Gravity"));
		}
		return NO_COMPLETE;
	}
}
