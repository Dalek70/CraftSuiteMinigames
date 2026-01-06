package me.dalek70.craftsuiteminigames.menus;

import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;
import org.mineacademy.fo.menu.Menu;
import org.mineacademy.fo.menu.button.Button;
import org.mineacademy.fo.menu.model.ItemCreator;
import org.mineacademy.fo.remain.CompMaterial;

import java.util.ArrayList;
import java.util.List;

public class DiscPlayer extends Menu {

    private float controlValue = 1.0f;  // Default value

    public DiscPlayer() {
        setTitle("Click a music disc to play it.");
        setSize(27);
    }

    @Override
    public List<Button> getButtonsToAutoRegister() {
        List<Button> buttons = new ArrayList<>();

        createButton(buttons, CompMaterial.MUSIC_DISC_13, "&b13", 0, Sound.MUSIC_DISC_13);
        createButton(buttons, CompMaterial.MUSIC_DISC_CAT, "&bCat", 1, Sound.MUSIC_DISC_CAT);
        createButton(buttons, CompMaterial.MUSIC_DISC_BLOCKS, "&bBlocks", 2, Sound.MUSIC_DISC_BLOCKS);
        createButton(buttons, CompMaterial.MUSIC_DISC_CHIRP, "&bChirp", 3, Sound.MUSIC_DISC_CHIRP);
        createButton(buttons, CompMaterial.MUSIC_DISC_FAR, "&bFar", 4, Sound.MUSIC_DISC_FAR);
        createButton(buttons, CompMaterial.MUSIC_DISC_MALL, "&bMall", 5, Sound.MUSIC_DISC_MALL);
        createButton(buttons, CompMaterial.MUSIC_DISC_MELLOHI, "&bMellohi", 6, Sound.MUSIC_DISC_MELLOHI);
        createButton(buttons, CompMaterial.MUSIC_DISC_STAL, "&bStal", 7, Sound.MUSIC_DISC_STAL);
        createButton(buttons, CompMaterial.MUSIC_DISC_STRAD, "&bStrad", 8, Sound.MUSIC_DISC_STRAD);
        createButton(buttons, CompMaterial.MUSIC_DISC_WARD, "&bWard", 9, Sound.MUSIC_DISC_WARD);
        createButton(buttons, CompMaterial.MUSIC_DISC_11, "&b11", 10, Sound.MUSIC_DISC_11);
        createButton(buttons, CompMaterial.MUSIC_DISC_WAIT, "&bWait", 11, Sound.MUSIC_DISC_WAIT);
        createButton(buttons, CompMaterial.MUSIC_DISC_CREATOR, "&bCreator", 12, Sound.MUSIC_DISC_CREATOR);
        createButton(buttons, CompMaterial.MUSIC_DISC_CREATOR_MUSIC_BOX, "&bCreator (Music Box)", 13, Sound.MUSIC_DISC_CREATOR_MUSIC_BOX);
        createButton(buttons, CompMaterial.MUSIC_DISC_PRECIPICE, "&bPrecipice", 14, Sound.MUSIC_DISC_PRECIPICE);
        createButton(buttons, CompMaterial.MUSIC_DISC_OTHERSIDE, "&bOtherside", 15, Sound.MUSIC_DISC_OTHERSIDE);
        createButton(buttons, CompMaterial.MUSIC_DISC_RELIC, "&bRelic", 16, Sound.MUSIC_DISC_RELIC);
        createButton(buttons, CompMaterial.MUSIC_DISC_5, "&b5", 17, Sound.MUSIC_DISC_5);
        createButton(buttons, CompMaterial.MUSIC_DISC_PIGSTEP, "&bPigstep", 18, Sound.MUSIC_DISC_PIGSTEP);
        createButton(buttons, CompMaterial.MUSIC_DISC_TEARS, "&bTears", 19, Sound.MUSIC_DISC_TEARS);
        createButton(buttons, CompMaterial.MUSIC_DISC_LAVA_CHICKEN, "&bLava Chicken", 20, Sound.MUSIC_DISC_LAVA_CHICKEN);


        // Add stop sound button
        buttons.add(new Button() {
            @Override
            public void onClickedInMenu(Player player, Menu menu, ClickType click) {
                player.stopAllSounds();
                player.sendMessage("§cStopped all sounds!");
            }

            @Override
            public ItemStack getItem() {
                return ItemCreator.of(CompMaterial.BARRIER.toItem())
                        .name("&cStop All Sounds")
                        .lore("&7Click to stop all playing sounds")
                        .make();
            }

            @Override
            public int getSlot() {
                return 25; // Next to the speed controller
            }
        });

        // Add control button at the end
        buttons.add(new Button() {
            @Override
            public void onClickedInMenu(Player player, Menu menu, ClickType click) {
                if (click == ClickType.LEFT) {
                    controlValue += 0.1f;
                    restartMenu("Click a music disc to play it.");
                } else if (click == ClickType.RIGHT) {
                    controlValue -= 0.1f;
                    restartMenu("Click a music disc to play it.");
                }
            }

            @Override
            public ItemStack getItem() {
                return ItemCreator.of(CompMaterial.REPEATER.toItem())
                        .name("&eSpeed: &f" + String.format("%.1f", controlValue))
                        .lore("&7Left-click to increase speed",
                                "&7Right-click to decrease speed")
                        .make();
            }

            @Override
            public int getSlot() {
                return 26; // Last slot in the menu
            }
        });

        return buttons;
    }

    private void createButton(List<Button> buttons, CompMaterial material, String name, int slot, Sound sound) {
        buttons.add(new Button() {
            @Override
            public void onClickedInMenu(Player player, Menu menu, ClickType click) {
                player.playSound(player.getLocation(), sound, 1.0f, controlValue);
                player.closeInventory();
            }

            @Override
            public ItemStack getItem() {
                return ItemCreator.of(material.toItem())
                        .name(name)
                        .make();
            }

            @Override
            public int getSlot() {
                return slot;
            }
        });
    }

    public static void open(Player player) {
        new DiscPlayer().displayTo(player);
    }

    public float getControlValue() {
        return controlValue;
    }
}