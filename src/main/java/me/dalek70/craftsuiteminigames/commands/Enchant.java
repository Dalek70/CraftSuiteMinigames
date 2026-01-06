package me.dalek70.craftsuiteminigames.commands;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.mineacademy.fo.command.SimpleCommand;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Enchant extends SimpleCommand {

	public Enchant() {
		super("enchant");
		setDescription("Enchants items.");
		setUsage("<enchantment> <level>");
		setMinArguments(2);
		setPermission("craftsuiteminigames.enchant");
	}

	String[] enchantments = Arrays.stream(Enchantment.values())
			.filter(Objects::nonNull)
			.map(Enchantment::getKey)
			.map(NamespacedKey::getKey)
			.toArray(String[]::new);




	@Override
	protected void onCommand() {
		checkConsole();
		Player player = getPlayer();
		if(!player.getInventory().getItemInMainHand().getType().equals(Material.AIR)){
			ItemStack item = player.getInventory().getItemInMainHand();
			int itemSlot = player.getInventory().getHeldItemSlot();
			ItemMeta meta = item.getItemMeta();
			meta.addEnchant(Enchantment.getByName(args[0]), Integer.parseInt(args[1]), true);
			item.setItemMeta(meta);
			player.getInventory().setItem(itemSlot, item);
		} else {
			player.sendMessage("§4Error: You must holding a item in your hand to enchant it.");
		}
	}

	@Override
	protected List<String> tabComplete() {
		if (args.length == 1) {
			return completeLastWord(enchantments);
		}
		return NO_COMPLETE;
	}
}
