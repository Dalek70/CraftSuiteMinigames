package me.dalek70.craftsuiteminigames;

import me.dalek70.craftsuiteminigames.util.Utils;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerGameModeChangeEvent;
import org.mineacademy.fo.command.SimpleCommand;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public class Gamemode extends SimpleCommand implements Listener {
	private final Set<UUID> ignoreGamemodeEvent = new HashSet<>();
	private final List<String> creativeAliases = List.of("creative", "c", "gmc", "1", "cret");
	private final List<String> survivalAliases = List.of("survival", "s", "gms", "0", "surv");
	private final List<String> adventureAliases = List.of("adventure", "a", "gma", "2", "adve");
	private final List<String> spectatorAliases = List.of("spectator", "sp", "gmsp", "3", "spec");

	@EventHandler
	public void onGamemodeChange(PlayerGameModeChangeEvent event) {
		Player player = event.getPlayer();
		UUID uuid = player.getUniqueId();
		if (ignoreGamemodeEvent.contains(uuid)) {
			ignoreGamemodeEvent.remove(uuid);
			return;
		}
		if (Utils.isAllowed(player, "cs.silent")) {
			GameMode newMode = event.getNewGameMode();
			event.setCancelled(true);
			ignoreGamemodeEvent.add(uuid);
			player.setGameMode(newMode);
		}
	}

	@EventHandler
	public void onChat(AsyncPlayerChatEvent event){
		Player player = event.getPlayer();
		String message = Utils.getPlayerMessage(event);
		if(message.startsWith("!gamemode") || message.startsWith("gamemode")) {
			switch (message.split(" ")[1]) {
				case "creative", "c", "gmc", "1", "cret" -> player.setGameMode(GameMode.CREATIVE);
				case "survival", "s", "gms", "0", "surv" -> player.setGameMode(GameMode.SURVIVAL);
				case "adventure", "a", "gma", "2", "adve" -> player.setGameMode(GameMode.ADVENTURE);
				case "spectator", "sp", "gmsp", "3", "spec" -> player.setGameMode(GameMode.SPECTATOR);
				default -> player.sendMessage("§4Error: §cInvalid gamemode. Use creative, survival, adventure, or spectator. If you want to use the normal gamemode command use /minecraft:gamemode");
			}
		}
	}

	public Gamemode() {
		super("gamemode", List.of("gm", "mode", "gmode", "gamem", "gamemd", "gmd", "gmde"));
		setDescription("Changes your gamemode. If you want to use the normal gamemode command use /minecraft:gamemode");
		setUsage("<gamemode>");
		setMinArguments(1);
		setPermission("craftsuite.gamemode");
	}

	@Override
	protected void onCommand() {
		checkConsole();
		Player player = getPlayer();
		switch (args[0].toLowerCase()) {
			case "creative", "c", "gmc", "1", "cret" -> player.setGameMode(GameMode.CREATIVE);
			case "survival", "s", "gms", "0", "surv" -> player.setGameMode(GameMode.SURVIVAL);
			case "adventure", "a", "gma", "2", "adve" -> player.setGameMode(GameMode.ADVENTURE);
			case "spectator", "sp", "gmsp", "3", "spec" -> player.setGameMode(GameMode.SPECTATOR);
			default -> player.sendMessage("§4Error: §cInvalid gamemode. Use creative, survival, adventure, or spectator. If you want to use the normal gamemode command use /minecraft:gamemode");
		}
	}

	@Override
	protected List<String> tabComplete() {
		if (args.length == 1) {
			return List.of("creative", "survival", "adventure", "spectator", "c", "s", "a", "sp", "gmc", "gms", "gma", "gmsp", "1", "0", "2", "3", "cret", "surv", "adve", "spec");
		}
		return NO_COMPLETE;
	}
}
