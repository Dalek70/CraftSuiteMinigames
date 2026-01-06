package me.dalek70.craftsuiteminigames.commands;

import org.bukkit.entity.Player;
import org.mineacademy.fo.command.SimpleCommand;

import java.util.Comparator;
import java.util.List;

public class GetUUID extends SimpleCommand {

	public GetUUID() {
		super("uuid", List.of("getuuid", "id"));
		setDescription("");
		setUsage("");
		setMinArguments(0);
		setPermission("craftsuiteminigames.uuid");
	}

	@Override
	protected void onCommand() {
		checkConsole();
		Player player = getPlayer();
		sender.sendMessage(player.getWorld().getNearbyEntities(player.getLocation(), 10, 10, 10).stream().filter(e -> !(e instanceof Player)).min(Comparator.comparingDouble(e -> e.getLocation().distanceSquared(player.getLocation()))).orElse(null).getUniqueId().toString());
	}
}
