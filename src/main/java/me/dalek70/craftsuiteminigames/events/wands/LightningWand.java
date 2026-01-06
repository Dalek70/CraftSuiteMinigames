package me.dalek70.craftsuiteminigames.events.wands;

import me.dalek70.craftsuiteminigames.Perm;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class LightningWand implements Listener {
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent event) {
		if(event.getPlayer().getInventory().getItemInMainHand().getItemMeta() != null){
			ItemStack item = event.getPlayer().getInventory().getItemInMainHand();
			ItemMeta meta = item.getItemMeta();
			if (event.getClickedBlock() != null) {
				Location spawnLocation = event.getClickedBlock().getLocation();
				if(Perm.hasPerm(event.getPlayer(), "TSRP.lightning_wand") && meta != null && "§bLightning Wand".equals(meta.getDisplayName()) && item.getType().equals(Material.BLAZE_ROD)){
					Entity entity = event.getPlayer().getWorld().spawnEntity(spawnLocation, EntityType.LIGHTNING_BOLT);
				}
			}
		}
	}
}
