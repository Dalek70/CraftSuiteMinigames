package me.dalek70.craftsuiteminigames;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.mineacademy.fo.Common;

public class HoverBoots{
	public static void startChecking() {
		Common.runTimer(0, () -> {
			for (Player player : Bukkit.getOnlinePlayers()) {
				ItemStack boots = player.getInventory().getBoots();
				if(boots != null && boots.getType().equals(Material.IRON_BOOTS) && boots.getItemMeta().getDisplayName().equals("§bHover Boots")) {
					player.getWorld().spawnParticle(Particle.FIREWORK, player.getLocation().clone().add(0, 0.1, 0), 1, 0, 0, 0, 0);
					player.setFallDistance(0);
					player.setGravity(false);
				} else {
					player.setGravity(true);
				}
			}
		});
	}
}
