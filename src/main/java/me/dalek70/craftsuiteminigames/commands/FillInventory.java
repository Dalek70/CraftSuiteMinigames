package me.dalek70.craftsuiteminigames.commands;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.mineacademy.fo.command.SimpleCommand;

import java.util.Arrays;
import java.util.List;

public class FillInventory extends SimpleCommand {

	public FillInventory() {
		super("fillinv");
		setDescription("Fills your inventory with the item.");
		setUsage("<item> <amount>");
		setMinArguments(2);
		setPermission("craftsuiteminigames.fillinv");
	}

	@Override
	protected void onCommand() {
		checkConsole();
		Player player = getPlayer();
		try {
			int amount = Integer.parseInt(args[1]);
			Inventory inventory = player.getInventory();
			String material = args[0].toUpperCase();
			for(int i = 0; i < inventory.getSize(); i++){
				inventory.setItem(i, new ItemStack(Material.valueOf(material), amount));
			}
		} catch (IllegalArgumentException e) {
			System.out.println("§cOops, an error occurred when " + player.getName() + " was trying to run a command: §4" + e.toString());
			player.sendMessage("§cOops, an error occurred: §4" + e.toString());
		}
	}

	@Override
	protected List<String> tabComplete() {
		if (args.length == 1)
			return Arrays.asList(Material.values()).stream().map(mat -> mat.name().toLowerCase()).toList();
		return NO_COMPLETE;
	}
}
