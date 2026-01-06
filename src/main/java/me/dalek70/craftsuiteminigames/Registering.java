package me.dalek70.craftsuiteminigames;

import me.dalek70.craftsuiteminigames.commands.*;
import me.dalek70.craftsuiteminigames.events.*;
import me.dalek70.craftsuiteminigames.events.chat.AntiCap;
import me.dalek70.craftsuiteminigames.events.chat.ChangeCustomPerm;
import me.dalek70.craftsuiteminigames.events.wands.*;

import static org.mineacademy.fo.Common.registerEvents;
import static org.mineacademy.fo.remain.Remain.registerCommand;

public class Registering {
	public static void registerEventsStartup() {
		registerEvents(new BackSave());
		registerEvents(new LightningWand());
		registerEvents(new RideWand());
		registerEvents(new DeathWand());
		registerEvents(new AntiCap());
		registerEvents(new PlayerJoin());
		registerEvents(new CommandBlocker());
		// BYE BYE ANTI SPAM. I HATE YOU SO MUCH. IDK WHY I DID'T TURN YOU OFF BEFORE.
		// registerEvents(new AntiSpam()); // I hate this dam thing
		registerEvents(new DeathMessages());
		registerEvents(new Gamemode());
		registerEvents(new SilentPlayerKiller());
		registerEvents(new ChangeCustomPerm());
		registerEvents(new TpCommandListener());
		registerEvents(new AntiCommandPlayerName());
		registerEvents(new NoCommandBlock());
	}

	public static void registerCommandsStartup() {
		registerCommand(new FlySpeed());
		registerCommand(new Fly());
		registerCommand(new Home());
		registerCommand(new SaveHome());
		registerCommand(new DeleteHome());
		registerCommand(new Ping());
		registerCommand(new FillInventory());
		registerCommand(new GamemodeCreative());
		registerCommand(new GamemodeSurvival());
		registerCommand(new GamemodeSpectator());
		registerCommand(new Give());
		registerCommand(new Back());
		registerCommand(new Toggle());
		registerCommand(new Music());
		registerCommand(new SetResourcePack());
		registerCommand(new TimeGoWHEEEEEEEE());
		registerCommand(new Enchant());
		registerCommand(new GetUUID());
		registerCommand(new GetBlockCommand());
		registerCommand(new Head());
		registerCommand(new TpToggle());
		registerCommand(new ReadPackage());
		registerCommand(new CreatePackage());
		registerCommand(new Rules());
		registerCommand(new Spawn());
	}
}
