package me.dalek70.craftsuiteminigames.commands;

import me.dalek70.craftsuiteminigames.util.PackageUtil;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.mineacademy.fo.command.SimpleCommand;

public class ReadPackage extends SimpleCommand {

	public ReadPackage() {
		super("read_package");
		setDescription("Unpacks the package that you are holding.");
		setPermission("craftsuiteminigames.read_package");
	}

	@Override
	protected void onCommand() {
		checkConsole();
		Player player = getPlayer();

		ItemStack packageItem = player.getInventory().getItemInMainHand();

		// 1. Check if it's a book
		if (packageItem == null || packageItem.getType() != Material.BOOK) {
			player.sendMessage("§cYou must hold a package book in your main hand.");
			return;
		}

		// 2. Check if it actually contains stored data
		if (!PackageUtil.hasStoredItem(packageItem)) {
			player.sendMessage("§cThis book is not a package or has no stored item.");
			return;
		}

		ItemStack unpacked = PackageUtil.getItemFromBook(packageItem);

		// 3. Safety: Ensure deserialize didn't fail
		if (unpacked == null) {
			player.sendMessage("§cCould not read package contents! (Corrupted?)");
			return;
		}

		// 4. Remove package book and give item
		player.getInventory().removeItem(packageItem);
		player.getInventory().addItem(unpacked);

		player.sendMessage("§aPackage unpacked successfully!");
	}
}
