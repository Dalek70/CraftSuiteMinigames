package me.dalek70.craftsuiteminigames.commands;


import org.bukkit.entity.Player;
import org.mineacademy.fo.command.SimpleCommand;

public class Rules extends SimpleCommand {
	public Rules() {
		super("rules");
		setDescription("Teleports you to your previous location.");
		setUsage("<page>");
	}

	@Override
	protected void onCommand() {
		Player player = getPlayer();
		int page = 0;
		String[] rules = {
				// Page 1: Rules 1–9
				"§6Rules §e1–9\n" +
						"§71. Be respectful to all players.\n" +
						"§72. No cheating or using exploits.\n" +
						"§73. No griefing other players' builds.\n" +
						"§74. Keep chat friendly and non-offensive.\n" +
						"§75. No advertising other servers.\n" +
						"§76. Do not spam chat or commands.\n" +
						"§77. Follow staff instructions at all times.\n" +
						"§78. No inappropriate skins or usernames.\n" +
						"§79. Do not interfere with other players’ minigames.",

				// Page 2: Rules 10–19
				"§6Rules §e10–19\n" +
						"§710. Use only use mods that don't give a unfair advantage\n" +
						"§711. Respect private regions and builds.\n" +
						"§712. No impersonating staff members.\n" +
						"§713. Report bugs and exploits to staff.\n" +
						"§714. No offensive builds or banners.\n" +
						"§715. Keep chat English-only for global channels.\n" +
						"§716. PvP only where allowed.\n" +
						"§717. Don’t request ranks or items from staff.\n" +
						"§718. Follow the Minecraft EULA.\n" +
						"§719. Enjoy the server and help others have fun!"
		};


		if (args.length > 0) {
			try {
				page = Integer.parseInt(args[0]) - 1;
				player.sendMessage("§e--- §6Server Rules §7(§bPage " + page + " §7)§e---");
				player.sendMessage(rules[page]);
			} catch (NumberFormatException e) {
				tell("Please provide a valid page number.");
				return;
			}
		} else {
			player.sendMessage("§e--- §6Server Rules §7(§bPage " + page + " §7)§e---");
			player.sendMessage(rules[page]);
		}
	}
}
