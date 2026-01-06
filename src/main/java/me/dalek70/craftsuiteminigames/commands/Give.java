package me.dalek70.craftsuiteminigames.commands;

import me.dalek70.craftsuiteminigames.CraftSuiteMinigames;
import me.dalek70.craftsuiteminigames.Perm;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.util.Vector;
import org.mineacademy.fo.Common;
import org.mineacademy.fo.command.SimpleCommand;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Give extends SimpleCommand {

	public Give() {
		super("bettergive");
		setDescription("Gives you the item.");
		setUsage("<item>");
		setMinArguments(1);
		setPermission("craftsuiteminigames.bettergive");
	}

	@Override
	protected void onCommand() {
		checkConsole();
		Player player = getPlayer();
		ItemStack item;
		ItemMeta meta;
		if(args[0].equals("lightning_wand")){
			item = new ItemStack(Material.BLAZE_ROD);
			meta = item.getItemMeta();
			meta.setDisplayName("§bLightning Wand");
			item.setItemMeta(meta);
			player.getInventory().addItem(item);
		} else if(args[0].equals("ride_wand")){
			item = new ItemStack(Material.BLAZE_ROD);
			meta = item.getItemMeta();
			meta.setDisplayName("§dRide Wand");
			item.setItemMeta(meta);
			player.getInventory().addItem(item);
		} else if(args[0].equals("quicksand_wand")){
			item = new ItemStack(Material.BLAZE_ROD);
			meta = item.getItemMeta();
			meta.setDisplayName("§eQuicksand Wand");
			item.setItemMeta(meta);
			player.getInventory().addItem(item);
		} else if(args[0].equals("death_wand")) {
			item = new ItemStack(Material.BLAZE_ROD);
			meta = item.getItemMeta();
			meta.setDisplayName("§4Death Wand");
			item.setItemMeta(meta);
			player.getInventory().addItem(item);
		} else if(args[0].equals("kaboom_wand")) {
			item = new ItemStack(Material.BLAZE_ROD);
			meta = item.getItemMeta();
			meta.setDisplayName("§6Kaboom Wand");
			item.setItemMeta(meta);
			player.getInventory().addItem(item);
		} else if(args[0].equals("demo_co_wand")) {
			if(!Perm.hasPerm(player, "DemoCoWand")){
				player.sendMessage("§cYou are not allowed to get this tool!");
			} else {
				item = new ItemStack(Material.NETHERITE_AXE);
				meta = item.getItemMeta();
				meta.setDisplayName("§bDemo Co Demolition Tool");
				item.setItemMeta(meta);
				player.getInventory().addItem(item);
			}
		} else if(args[0].equals("glitch_wand")) {
			item = new ItemStack(Material.BREEZE_ROD);
			meta = item.getItemMeta();
			meta.setDisplayName("§dGlitch Wand");
			List<String> lore = new ArrayList<>();
			if(args.length == 2 && Integer.parseInt(args[1]) <= 90 && Integer.parseInt(args[1]) >= 1){
				lore.add("Glitch Power: " + args[1]);
			} else {
				lore.add("Glitch Power: " + 5);
			}
			meta.setLore(lore);
			PersistentDataContainer container = meta.getPersistentDataContainer();
			NamespacedKey key = new NamespacedKey(CraftSuiteMinigames.getInstance(), "glitch_power");
			if(args.length == 2 && Integer.parseInt(args[1]) <= 50 && Integer.parseInt(args[1]) >= 1){
				container.set(key, PersistentDataType.INTEGER, Integer.parseInt(args[1]));
			} else {
				container.set(key, PersistentDataType.INTEGER, 5);
			}
			item.setItemMeta(meta);
			player.getInventory().addItem(item);
		} else if(args[0].equals("video")){
			/*
			VideoPlayer video = null;
			if(args[1].equals("start")){
				switch(args[2]){
					case "tardis_crashes_11th_hour" -> {
						video = new VideoPlayer(TSRP.getInstance(), "maps/tardis_crashes_11th_hour", 0);

						for (Player playerToPlaySound : Bukkit.getOnlinePlayers()) {
							playerToPlaySound.playSound(player.getLocation(), Sound.MUSIC_DISC_FAR, 1.0f, 1.0f);
						}

						video.start(1);
					}

					case "all_the_doctors" -> {
						video = new VideoPlayer(TSRP.getInstance(), "maps/all_the_doctors", 1);
						for (Player playerToPlaySound : Bukkit.getOnlinePlayers()){
							player.playSound(player.getLocation(), Sound.MUSIC_DISC_PIGSTEP, 1.0f, 1.0f);
						}
						video.start(2);
					}
				}
			} else if(args[1].equals("stop")){
				video.stop();
				player.stopAllSounds();
			} else {
				player.sendMessage("§cInvalid argument! Use 'start' or 'stop'.");
			}
			*/
		} else if(args[0].equals("CreepBot_Blink")){
			/*
			CreepBot bot = new CreepBot();
			bot.startBlinking();
			 */
		} else if(args[0].equals("New_Video")){
			/*
			player.playSound(player.getLocation(), args[2], 1.0f, 1.0f);
			MapAnimatorMultiPart.animateInParts(3, args[1], player);

			 */
		} else if(args[0].equals("go_crazy")){
			Common.runTimer(0, 3, () -> {
				try {
					double x = Math.random() * 2 - 1; // Math.random() * 2 gives 0 to 2, minus 1 gives -1 to 1
					double y = Math.random() * 2 - 1;
					double z = Math.random() * 2 - 1;

					Bukkit.getEntity(UUID.fromString(args[1])).setVelocity(new Vector(x, y, z));

				} catch (Exception e) {
					Common.cancelTasks();
				}
			});
		} else if(args[0].equals("code")){

		} else {
			player.getInventory().addItem(new ItemStack(Material.valueOf(args[0].toUpperCase()), 1));
		}
	}

	@Override
	protected List<String> tabComplete() {
		if (args.length == 1) {
			List<String> suggestions = new ArrayList<>();
			suggestions.add("lightning_wand");
			suggestions.add("ride_wand");
			suggestions.add("quicksand_wand");
			suggestions.add("death_wand");
			suggestions.add("kaboom_wand");
			suggestions.add("glitch_wand");
			suggestions.add("demo_co_wand");
			for (Material material : Material.values()) {
				suggestions.add(material.name().toLowerCase());
			}
			String currentArg = args[0].toLowerCase();
			List<String> filtered = new ArrayList<>();
			for (String suggestion : suggestions) {
				if (suggestion.startsWith(currentArg)) {
					filtered.add(suggestion);
				}
			}
			return filtered;
		}
		return NO_COMPLETE;
	}
}
