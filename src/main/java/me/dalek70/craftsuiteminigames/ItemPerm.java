package me.dalek70.craftsuiteminigames;

import me.dalek70.craftsuiteminigames.util.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.mineacademy.fo.Common;

public class ItemPerm {
	private static boolean isNuclearSlime(ItemStack item) {
		if (item.getType() != Material.SLIME_BALL) return false;
		if (!item.hasItemMeta()) return false;

		ItemMeta meta = item.getItemMeta();
		return meta.hasDisplayName() && meta.getDisplayName().equals("§aNuclear Slime");
	}


	public static void startChecking() {
		ItemStack nuclearSlime = new ItemStack(Material.SLIME_BALL);
		ItemMeta nuclearSlimemeta = nuclearSlime.getItemMeta();
		nuclearSlimemeta.setDisplayName("§aNuclear Slime");
		nuclearSlimemeta.addEnchant(Enchantment.LUCK_OF_THE_SEA, 1, true);
		nuclearSlimemeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		nuclearSlime.setItemMeta(nuclearSlimemeta);

		Common.runTimer(1, () -> {
			for (Player player : Bukkit.getOnlinePlayers()) {
				if (!Utils.isAllowed(player, "nuclear_slime")) {
					for (ItemStack item : player.getInventory().getContents()) {
						if (item == null) continue;
						if (isNuclearSlime(item)) {
							player.getInventory().removeItem(item);
							player.sendMessage("§cYou are not allowed to have nuclear slime!");
							break;
						}
					}
				}
			}
		});

	}
}
