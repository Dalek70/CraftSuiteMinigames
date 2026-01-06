package me.dalek70.craftsuiteminigames.commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.mineacademy.fo.command.SimpleCommand;

public class GetBlockCommand extends SimpleCommand {

	public GetBlockCommand() {
		super("getblock");
		setDescription("Gets the type of block at the target location");
		setUsage("<world> <x> <y> <z>");
		setMinArguments(4);
		setPermission("craftsuiteminigames.getblock");
	}

	@Override
	protected void onCommand() {
		Block targetBlock = new Location(Bukkit.getWorld(args[0]), Integer.parseInt(args[1]), Integer.parseInt(args[2]), Integer.parseInt(args[3])).getBlock();
		tell("Block at " + args[1] + " " + args[2] + " " + args[3] + " in " + args[0] + " is: " + targetBlock.getType().name());
	}
}
