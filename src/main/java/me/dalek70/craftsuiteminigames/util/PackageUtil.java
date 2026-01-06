package me.dalek70.craftsuiteminigames.util;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.io.BukkitObjectInputStream;
import org.bukkit.util.io.BukkitObjectOutputStream;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Base64;

public final class PackageUtil {

	private static final org.bukkit.NamespacedKey KEY_STORED_ITEM =
			new org.bukkit.NamespacedKey(JavaPlugin.getProvidingPlugin(PackageUtil.class), "stored_item");

	// Serialize ItemStack into Base64
	public static String serializeItemStack(ItemStack item) {
		try {
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			BukkitObjectOutputStream dataOutput = new BukkitObjectOutputStream(outputStream);

			dataOutput.writeObject(item);
			dataOutput.close();
			String s = Base64.getEncoder().encodeToString(outputStream.toByteArray());
			System.out.println("Bytes: " + s.getBytes().length + ", KB: " + (s.getBytes().length / 1024.0) + ", MB: " + (s.getBytes().length / 1024.0 / 1024.0));
			return s;
		} catch (Exception e) {
			throw new IllegalStateException("Failed to serialize item", e);
		}
	}

	// Deserialize ItemStack from Base64
	public static ItemStack deserializeItemStack(String base64) {
		try {
			byte[] data = Base64.getDecoder().decode(base64);
			ByteArrayInputStream inputStream = new ByteArrayInputStream(data);
			BukkitObjectInputStream dataInput = new BukkitObjectInputStream(inputStream);

			ItemStack item = (ItemStack) dataInput.readObject();
			dataInput.close();

			return item;
		} catch (Exception e) {
			throw new IllegalStateException("Failed to deserialize item", e);
		}
	}

	public static ItemStack storeItemInBook(ItemStack book, ItemStack item) {
		if (book == null || book.getType() != Material.BOOK)
			throw new IllegalArgumentException("Must be a normal book");

		ItemMeta meta = book.getItemMeta();
		if (meta == null) {
			meta = Bukkit.getItemFactory().getItemMeta(Material.BOOK);
		}

		PersistentDataContainer pdc = meta.getPersistentDataContainer();
		pdc.set(KEY_STORED_ITEM, PersistentDataType.STRING, serializeItemStack(item));

		book.setItemMeta(meta);

		return book;
	}

	public static ItemStack getItemFromBook(ItemStack book) {
		if (book == null || book.getItemMeta() == null) return null;

		PersistentDataContainer pdc = book.getItemMeta().getPersistentDataContainer();
		String base64 = pdc.get(KEY_STORED_ITEM, PersistentDataType.STRING);

		if (base64 == null) return null;
		return deserializeItemStack(base64);
	}

	public static boolean hasStoredItem(ItemStack book) {
		if (book == null || book.getItemMeta() == null) return false;

		return book.getItemMeta().getPersistentDataContainer().has(KEY_STORED_ITEM, PersistentDataType.STRING);
	}

	public static void clearStoredItem(ItemStack book) {
		if (book == null || book.getItemMeta() == null) return;

		ItemMeta meta = book.getItemMeta();
		meta.getPersistentDataContainer().remove(KEY_STORED_ITEM);
		book.setItemMeta(meta);
	}
}
