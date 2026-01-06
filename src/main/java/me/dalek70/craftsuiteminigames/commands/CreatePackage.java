package me.dalek70.craftsuiteminigames.commands;

import me.dalek70.craftsuiteminigames.util.PackageUtil;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.mineacademy.fo.command.SimpleCommand;

public class CreatePackage extends SimpleCommand {

	public CreatePackage() {
		super("create_package");
		setDescription("Creates a package with the item that you are holding.");
		setPermission("craftsuiteminigames.create_package");
	}

	@Override
	protected void onCommand() {
		checkConsole();
		Player player = getPlayer();

		ItemStack itemInMain = player.getInventory().getItemInMainHand();
		ItemStack itemInOff = player.getInventory().getItemInOffHand();

		// --- CHECK 1: Off-hand must be a normal BOOK ---
		if (itemInOff == null || itemInOff.getType() != Material.BOOK) {
			player.sendMessage("§cYou need to hold a normal book in your off-hand.");
			return;
		}

		// --- CHECK 2: Main hand must contain something ---
		if (itemInMain == null || itemInMain.getType() == Material.AIR) {
			player.sendMessage("§cYou need to hold an item in your main hand to package it.");
			return;
		}

		// --- STORE ITEM IN OFF-HAND BOOK DIRECTLY ---
		PackageUtil.storeItemInBook(itemInOff, itemInMain);

		// --- REMOVE MAIN HAND ITEM ONLY ---
		player.getInventory().removeItem(itemInMain);

		// --- SUCCESS MESSAGE ---
		player.sendMessage("§aPackage created successfully!");
	}
}
