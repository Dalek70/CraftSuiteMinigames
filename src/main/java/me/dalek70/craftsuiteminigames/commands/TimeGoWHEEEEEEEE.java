package me.dalek70.craftsuiteminigames.commands;

import com.Zrips.CMI.CMI;
import me.dalek70.craftsuiteminigames.CraftSuiteMinigames;
import me.dalek70.craftsuiteminigames.util.Utils;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitTask;
import org.mineacademy.fo.Common;
import org.mineacademy.fo.command.SimpleCommand;

public class TimeGoWHEEEEEEEE extends SimpleCommand {

	// Store running task for toggle
	private static BukkitTask runningTask = null;

	public TimeGoWHEEEEEEEE() {
		super("timegowheeeeeeee");
		setDescription("Makes the time go crazy weird.");
		setPermission("craftsuiteminigames.crazytime");
	}

	@Override
	protected void onCommand() {
		checkConsole();
		Player player = getPlayer();
		World world = player.getWorld();

		if(!Utils.isAllowed(player, "cs.crazytime"))
			return;
		if (runningTask != null) {
			// Cancel the task if running, toggle off
			runningTask.cancel();
			runningTask = null;
			return;
		}

		// Start the timer and store task reference
		boolean[] forward = {true};
		int[] ticks = {0};
		int[] maxTicks = {0};

		runningTask = Common.runTimer(0, 1, () -> {
			long time = world.getTime();

			if (maxTicks[0] == 0 || ticks[0] >= maxTicks[0]) {
				forward[0] = !forward[0];
				ticks[0] = 0;
				maxTicks[0] = 20 + (int) (Math.random() * 100);
			}

			int change = forward[0] ? 300 : -300;
			long newTime = (time + change + 24000) % 24000;
			world.setTime(newTime);
			ticks[0]++;
		});
	}
}
