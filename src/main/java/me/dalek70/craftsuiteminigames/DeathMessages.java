package me.dalek70.craftsuiteminigames;

import org.bukkit.GameMode;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerDeathEvent;

public class DeathMessages implements Listener {
	@EventHandler
	public void onPlayerDeath(PlayerDeathEvent event) {
		String playerName = event.getEntity().getName();
		EntityDamageEvent.DamageCause cause = event.getEntity().getLastDamageCause().getCause();
		boolean isInCreative = event.getEntity().getGameMode().equals(GameMode.CREATIVE);
		boolean isInSpectator = event.getEntity().getGameMode().equals(GameMode.SPECTATOR);
		boolean isInSurvival = event.getEntity().getGameMode().equals(GameMode.SURVIVAL);
		switch (cause) {
			case FALL -> event.setDeathMessage(playerName + " fell. You know its not good to fall, right?");
			case LAVA -> event.setDeathMessage(playerName + " hoped in a lava bath. You know they are not that safe.");
			case DRAGON_BREATH -> event.setDeathMessage(playerName + " died from the dragon's terrible breath. Brush your teeth, Ender Dragon!");
			case FIRE, FIRE_TICK -> event.setDeathMessage(playerName + " was cooked to death. Fire burns players, not just your house!");
			case CUSTOM -> event.setDeathMessage(playerName + " died in a custom way......... WHAT?");
			case VOID -> {
				switch (event.getEntity().getGameMode()) {
					case CREATIVE, SPECTATOR -> event.setDeathMessage(playerName + " fell into the void. Why don't you just fly out of there?");
					case SURVIVAL -> event.setDeathMessage(playerName + " fell into the void with no hope and died. It's a bad idea to go into the void.");
					case ADVENTURE -> event.setDeathMessage(playerName + " fell into the void. Why are you even down there? Just don't.");
				}
			}
			case CRAMMING -> event.setDeathMessage(playerName + " died scared by too many entities. Why did you even cause that?");
			case CAMPFIRE -> event.setDeathMessage(playerName + " got cooked to perfection by a campfire. Campfires are for food, not you!");
			case DROWNING -> event.setDeathMessage(playerName + " thought they were a fish and tried to breathe underwater. But you're not, so you drowned.");
			case FREEZE -> event.setDeathMessage(playerName + " froze to death. You know its not good to get too cold, right?");
			case LIGHTNING -> event.setDeathMessage(playerName + " was struck by angry clouds. Or maybe a Lightning Wand? Either way, you died.");
			case MAGIC -> event.setDeathMessage(playerName + " died from magic. You know magic is not real, so just ignore it.");
			case SONIC_BOOM -> event.setDeathMessage(playerName + " was erased when a warden tore reality apart. Don't make it angry again!");
		}
	}
}
