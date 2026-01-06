package me.dalek70.craftsuiteminigames;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;

public class RainbowArmor {
	// Rainbow gradient colors - 40 colors for each transition
	private static final int[] RAINBOW_COLORS = generateRainbowGradient();

	private static int colorIndex = 0;
	private static int colorDirection = 1; // 1 for forward, -1 for reverse
	private static final int COLOR_SKIP = 30; // Skip this many colors for faster animation

	private static int[] generateRainbowGradient() {
		int totalColors = 1200; // Much larger gradient for smooth transitions
		int[] colors = new int[totalColors];

		// Generate smooth rainbow gradient through HSV color space
		for (int i = 0; i < totalColors; i++) {
			float hue = (float) i / totalColors; // 0.0 to 1.0
			colors[i] = hsvToRgb(hue, 1.0f, 1.0f); // Full saturation and brightness
		}

		return colors;
	}

	private static int hsvToRgb(float hue, float saturation, float value) {
		int h = (int) (hue * 6);
		float f = hue * 6 - h;
		float p = value * (1 - saturation);
		float q = value * (1 - f * saturation);
		float t = value * (1 - (1 - f) * saturation);

		float r, g, b;
		switch (h % 6) {
			case 0: r = value; g = t; b = p; break;
			case 1: r = q; g = value; b = p; break;
			case 2: r = p; g = value; b = t; break;
			case 3: r = p; g = q; b = value; break;
			case 4: r = t; g = p; b = value; break;
			case 5: r = value; g = p; b = q; break;
			default: r = g = b = 0; break;
		}

		int red = (int) (r * 255);
		int green = (int) (g * 255);
		int blue = (int) (b * 255);

		return (red << 16) | (green << 8) | blue;
	}


	public static void startRainbowArmor() {
		Bukkit.getScheduler().runTaskTimerAsynchronously(CraftSuiteMinigames.getInstance(), () -> {
			// Update color index with skip and direction
			colorIndex += colorDirection * COLOR_SKIP;

			// Reverse direction at boundaries
			if (colorIndex >= RAINBOW_COLORS.length - 1) {
				colorIndex = RAINBOW_COLORS.length - 1;
				colorDirection = -1;
			} else if (colorIndex <= 0) {
				colorIndex = 0;
				colorDirection = 1;
			}

			int currentColor = RAINBOW_COLORS[colorIndex];

			for (Player player : Bukkit.getOnlinePlayers()) {
				if (player.hasPermission("craftsuiteminigames.rainbowarmor")) {
					ItemStack[] armorContents = player.getInventory().getArmorContents();
					for (int i = 0; i < armorContents.length; i++) {
						ItemStack item = armorContents[i];
						if (item != null && isLeatherArmor(item) && hasCorrectName(item)) {
							armorContents[i] = colorLeatherArmor(item, currentColor);
						}
					}
					player.getInventory().setArmorContents(armorContents);
				}
			}
		}, 0L, 20L); // Runs every second
	}

	private static boolean isLeatherArmor(ItemStack item) {
		Material material = item.getType();
		return material == Material.LEATHER_HELMET ||
		       material == Material.LEATHER_CHESTPLATE ||
		       material == Material.LEATHER_LEGGINGS ||
		       material == Material.LEATHER_BOOTS;
	}

	private static boolean hasCorrectName(ItemStack item) {
		if (item.hasItemMeta() && item.getItemMeta().hasDisplayName()) {
			String displayName = item.getItemMeta().getDisplayName();
			return displayName.equals("Vortex's Cool Rainbow timey vortexy armor");
		}
		return false;
	}

	private static ItemStack colorLeatherArmor(ItemStack item, int hexColor) {
		ItemStack coloredItem = item.clone();
		if (coloredItem.hasItemMeta() && coloredItem.getItemMeta() instanceof LeatherArmorMeta) {
			LeatherArmorMeta meta = (LeatherArmorMeta) coloredItem.getItemMeta();
			Color color = Color.fromBGR(hexColor);
			meta.setColor(color);
			coloredItem.setItemMeta(meta);
		}
		return coloredItem;
	}
}
