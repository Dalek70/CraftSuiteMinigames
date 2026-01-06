package me.dalek70.craftsuiteminigames.commands;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.mineacademy.fo.command.SimpleCommand;


public class Spawn extends SimpleCommand {
	public Spawn() {
		super("spawn");
		setDescription("Takes you to the server spawn.");
		setPermission("craftsuiteminigames.spawn");
	}

	@Override
	protected void onCommand() {
		checkConsole();
		Player player = getPlayer();
		World world = Bukkit.getWorld("workingminigames");
		Location spawn = world.getSpawnLocation().set(world.getSpawnLocation().getX(), world.getSpawnLocation().getY(), world.getSpawnLocation().getZ());
		player.teleport(spawn);
		player.setGameMode(GameMode.ADVENTURE);
	}
}
