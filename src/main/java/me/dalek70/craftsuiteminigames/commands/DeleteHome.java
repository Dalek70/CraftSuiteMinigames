package me.dalek70.craftsuiteminigames.commands;

import me.dalek70.craftsuiteminigames.Database;
import org.bukkit.entity.Player;
import org.mineacademy.fo.command.SimpleCommand;

import java.util.List;

public class DeleteHome extends SimpleCommand {

	public DeleteHome() {
		super("deletehome");
		setDescription("Deletes a saved home.");
		setUsage("<name>");
		setMinArguments(1);
		setPermission("craftsuiteminigames.deletehome");
	}

	@Override
	protected void onCommand() {
		checkConsole();
		Player player = getPlayer();
		if (args.length == 1) {
			if (Database.listHomes(player.getUniqueId()).contains(args[0])) {
				Database.deleteHome(player.getUniqueId(), args[0]);
				player.sendMessage("§6Deleted the home §b" + args[0] + "§6.");
			} else {
				player.sendMessage("§4Error: That home does not exist.");
			}
		}
	}

	@Override
	protected List<String> tabComplete() {
		if (args.length == 1) {
			return completeLastWord(Database.listHomes(getPlayer().getUniqueId()));
		}
		return NO_COMPLETE;
	}
}
