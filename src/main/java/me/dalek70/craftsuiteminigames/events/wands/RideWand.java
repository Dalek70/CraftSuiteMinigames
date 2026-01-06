package me.dalek70.craftsuiteminigames.events.wands;

import me.dalek70.craftsuiteminigames.Perm;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class RideWand implements Listener {
	@EventHandler
	public void onRightClick(final PlayerInteractEntityEvent event) {
		Entity entity = event.getRightClicked();
		ItemStack item = event.getPlayer().getInventory().getItemInMainHand();
		ItemMeta meta = item.getItemMeta();
		Player player = event.getPlayer();
		if(Perm.hasPerm(player, "TSRP.ride_wand") && meta != null && "§dRide Wand".equals(meta.getDisplayName()) && item.getType().equals(Material.BLAZE_ROD)){
			entity.addPassenger(player);
		}
	}
}
