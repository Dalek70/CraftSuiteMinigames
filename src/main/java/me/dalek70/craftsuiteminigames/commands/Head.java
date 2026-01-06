package me.dalek70.craftsuiteminigames.commands;

import me.dalek70.craftsuiteminigames.util.MinecraftHeadsApiUtil;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.mineacademy.fo.command.SimpleCommand;

import java.util.List;

public class Head extends SimpleCommand {
	public Head() {
		super("head", List.of("headdatabase", "hd", "gethead"));
		setDescription("Gives you the head");
		setUsage("<head dev string>");
		setMinArguments(1);
		setPermission("craftsuiteminigames.head");
	}

	@Override
	protected void onCommand() {
		checkConsole();
		Player player = getPlayer();
		ItemStack head = MinecraftHeadsApiUtil.createHeadFromValue(args[0]);
		player.getInventory().addItem(head);
		tell("The head has been given to you.");
	}
}
