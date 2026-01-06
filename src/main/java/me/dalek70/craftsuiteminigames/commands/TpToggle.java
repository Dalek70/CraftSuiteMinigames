package me.dalek70.craftsuiteminigames.commands;

import me.dalek70.craftsuiteminigames.CraftSuiteMinigames;
import org.bukkit.entity.Player;
import org.mineacademy.fo.command.SimpleCommand;

public class TpToggle extends SimpleCommand {
	public TpToggle() {
		super("tptoggle");
		setDescription("Toggle if a player can tp to you or not");
		setUsage("");
		setMinArguments(0);
		setPermission("craftsuiteminigames.tptoggle");
	}

	@Override
	protected void onCommand() {
		checkConsole();
		Player player = getPlayer();
		if(CraftSuiteMinigames.tpToggleStates.containsKey(player.getUniqueId())) {
			boolean isOnRightNow = CraftSuiteMinigames.tpToggleStates.get(player.getUniqueId());
			CraftSuiteMinigames.tpToggleStates.replace(player.getUniqueId(), !isOnRightNow);
			tell("§aTpToggle set to " + (!isOnRightNow ? "TRUE" : "FALSE"));
		} else {
			CraftSuiteMinigames.tpToggleStates.put(player.getUniqueId(), true);
			tell("§aTpToggle set to TRUE");
		}
	}
}
