package me.dalek70.craftsuiteminigames.util;

import me.dalek70.craftsuiteminigames.CraftSuiteMinigames;
import me.dalek70.craftsuiteminigames.Perm;
import org.bukkit.Location;
import org.bukkit.NamespacedKey;
import org.bukkit.World;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.entity.Player;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import java.util.*;

public class Utils {
	private static final Map<UUID, Location> backLocations = new HashMap<>();

	public static void setPlayerResourcePack(Player player, String url, String hash) {
		player.setResourcePack(url);
	}

	public static int countCapitalLetters(String input) {
		int count = 0;
		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			if (c >= 'A' && c <= 'Z') {
				count++;
			}
		}
		return count;
	}

	public static String[] splitString(String text){
		return text.split(" ");
	}

	public static String getPlayerMessage(AsyncPlayerChatEvent event){
		return event.getMessage();
	}

	public static void setBackLocation(UUID uuid, Location location) {
		backLocations.put(uuid, location);
	}

	public static Location getBackLocation(UUID uuid) {
		return backLocations.get(uuid);
	}

	public static void removeBackLocation(UUID uuid) {
		backLocations.remove(uuid);
	}

	public static Boolean isAllowed(Player player, String perm){
		if(!Perm.hasPerm(player, perm)){
			return false;
		} else {
			return true;
		}
	}

	public static Set<Block> getBlocksAroundLocation(Location centerLocation, int radius) {
		Set<Block> nearbyBlocks = new HashSet<>();

		World world = centerLocation.getWorld();
		if (world == null) {
			return nearbyBlocks;
		}

		double radiusSquared = radius * radius;

		for (int xOffset = -radius; xOffset <= radius; xOffset++) {
			for (int yOffset = -radius; yOffset <= radius; yOffset++) {
				for (int zOffset = -radius; zOffset <= radius; zOffset++) {

					double distanceSquared = (xOffset * xOffset) + (yOffset * yOffset) + (zOffset * zOffset);

					// Only include blocks within a spherical radius
					if (distanceSquared <= radiusSquared) {
						Location blockLocation = centerLocation.clone().add(xOffset, yOffset, zOffset);
						Block block = world.getBlockAt(blockLocation);
						nearbyBlocks.add(block);
					}
				}
			}
		}

		return nearbyBlocks;
	}

	public static Block[] getBlocksAroundLocationArray(Location centerLocation, int radius) {
		Set<Block> nearbyBlocks = new HashSet<>();

		World world = centerLocation.getWorld();
		if (world == null) {
			return new Block[0]; // return empty array if no world
		}

		double radiusSquared = radius * radius;

		for (int xOffset = -radius; xOffset <= radius; xOffset++) {
			for (int yOffset = -radius; yOffset <= radius; yOffset++) {
				for (int zOffset = -radius; zOffset <= radius; zOffset++) {

					double distanceSquared = (xOffset * xOffset) + (yOffset * yOffset) + (zOffset * zOffset);

					// Only include blocks within a spherical radius
					if (distanceSquared <= radiusSquared) {
						Location blockLocation = centerLocation.clone().add(xOffset, yOffset, zOffset);
						Block block = world.getBlockAt(blockLocation);
						nearbyBlocks.add(block);
					}
				}
			}
		}

		return nearbyBlocks.toArray(new Block[0]); // convert Set to Block[]
	}


	public static double checkDistance(Player player, Location targetLocation) {
		Location playerLocation = player.getLocation();
		double distance = playerLocation.distance(targetLocation);
		return distance;
	}

	public static String getData(ItemStack item, String keyName) {
		if (item == null || keyName == null) {
			return null;
		}

		if (!item.hasItemMeta()) {
			return null;
		}

		ItemMeta meta = item.getItemMeta();
		if (meta == null) {
			return null;
		}

		try {
			NamespacedKey key = new NamespacedKey(CraftSuiteMinigames.getInstance(), keyName);
			return meta.getPersistentDataContainer().get(key, PersistentDataType.STRING);
		} catch (Exception e) {
			return null;
		}
	}

	public static boolean setData(ItemStack item, String keyName, String value) {
		if (item == null || keyName == null) {
			return false;
		}

		try {
			ItemMeta meta = item.getItemMeta();
			if (meta == null) {
				return false;
			}

			NamespacedKey key = new NamespacedKey(CraftSuiteMinigames.getInstance(), keyName);
			PersistentDataContainer container = meta.getPersistentDataContainer();

			if (value == null) {
				if (container.has(key, PersistentDataType.STRING)) {
					container.remove(key);
				}
			} else {
				container.set(key, PersistentDataType.STRING, value);
			}

			return item.setItemMeta(meta);
		} catch (IllegalArgumentException e) {
			return false;
		}
	}

	public static Map<String, String> getAllData(ItemStack item) {
		Map<String, String> data = new HashMap<>();
		if (item == null || !item.hasItemMeta()) {
			return data;
		}

		ItemMeta meta = item.getItemMeta();
		if (meta == null) {
			return data;
		}

		try {
			PersistentDataContainer container = meta.getPersistentDataContainer();
			for (NamespacedKey key : container.getKeys()) {
				if (key == null || !key.getNamespace().equals(CraftSuiteMinigames.getInstance().getName())) {
					continue;
				}

				if (container.has(key, PersistentDataType.STRING)) {
					data.put(key.getKey(), container.get(key, PersistentDataType.STRING));
				}
			}
		} catch (Exception e) {
			// return whatever we got
		}

		return data;
	}

	public static void resetPlayer(Player player) {
		for (Attribute attribute : Attribute.values()) {
			AttributeInstance attributeInstance = player.getAttribute(attribute);
			if (attributeInstance != null) {
				// Remove each modifier
				attributeInstance.getModifiers().forEach(attributeInstance::removeModifier);
				// Optionally, reset to default value
				attributeInstance.setBaseValue(attributeInstance.getDefaultValue());
			}
		}
		player.setHealth(20);
	}

	public static void triggerBlockUpdate(Location loc) {
		BlockState state = loc.getBlock().getState();
		state.update(true, true); // force = true, applyPhysics = true
	}
}
