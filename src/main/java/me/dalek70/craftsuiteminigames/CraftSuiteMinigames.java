package me.dalek70.craftsuiteminigames;

import com.Zrips.CMI.CMI;
import org.bukkit.Bukkit;
import org.mineacademy.fo.Common;
import org.mineacademy.fo.plugin.SimplePlugin;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public final class CraftSuiteMinigames extends SimplePlugin {
	public static final Map<UUID, Boolean> playerStates = new HashMap<>();
	public static final Map<UUID, Boolean> tpToggleStates = new HashMap<>();
	public static final Map<UUID, Boolean> commandToggleStates = new HashMap<>();

	@Override
	protected void onPluginStop() {
		Common.log("CraftSuite shutting down");
	}

	public static CMI cmi = CMI.getInstance();


    @Override
    protected void onPluginStart() {
		// RecipeDatasetUtil.exportAllRecipes();
		HoverBoots.startChecking();
        Database.setDatabaseFolder(getDataFolder());
        // make the perms.yml file if it doesn't alraedy exist
        File permFile = new File(getDataFolder(), "perms.yml");
        if (!permFile.exists()) {
            try {
                if (!permFile.createNewFile()) {
                    Common.log("Failed to create perms.yml");
                }
            } catch (IOException e) {
                Common.log("Error creating perms.yml: " + e.getMessage());
            }
        }
        File balancesFile = new File(getDataFolder(), "balances.yml");
        if (!balancesFile.exists()) {
            try {
                if (!balancesFile.createNewFile()) {
                    Common.log("Failed to create balances.yml");
                }
            } catch (IOException e) {
                Common.log("Error creating balances.yml: " + e.getMessage());
            }
        }

        // register all commands and events
        Registering.registerCommandsStartup();
        Registering.registerEventsStartup();

        // start checking all players to see if they are allowed to have items that are in their inventory
        ItemPerm.startChecking();

		RainbowArmor.startRainbowArmor();

		Bukkit.getPluginManager().disablePlugins();
		Bukkit.getPluginManager().clearPlugins();
    }

    /**
     * Return the instance of this plugin
     * @return The plugin instance
     */
    public static CraftSuiteMinigames getInstance() {
        return (CraftSuiteMinigames) SimplePlugin.getInstance();
    }

    public File getFolder() {
        return getDataFolder();
    }
}
