package me.dalek70.craftsuiteminigames.test;

import com.destroystokyo.paper.ClientOption;
import com.destroystokyo.paper.Title;
import com.destroystokyo.paper.block.TargetBlockInfo;
import com.destroystokyo.paper.entity.TargetEntityInfo;
import com.destroystokyo.paper.profile.PlayerProfile;
import io.papermc.paper.connection.PlayerGameConnection;
import io.papermc.paper.datacomponent.DataComponentType;
import io.papermc.paper.entity.LookAnchor;
import io.papermc.paper.entity.PlayerGiveResult;
import io.papermc.paper.entity.TeleportFlag;
import io.papermc.paper.math.Position;
import io.papermc.paper.threadedregions.scheduler.EntityScheduler;
import io.papermc.paper.world.damagesource.CombatTracker;
import net.kyori.adventure.bossbar.BossBar;
import net.kyori.adventure.key.Key;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.util.TriState;
import net.md_5.bungee.api.chat.BaseComponent;
import org.bukkit.*;
import org.bukkit.advancement.Advancement;
import org.bukkit.advancement.AdvancementProgress;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.block.*;
import org.bukkit.block.data.BlockData;
import org.bukkit.block.sign.Side;
import org.bukkit.conversations.Conversation;
import org.bukkit.conversations.ConversationAbandonedEvent;
import org.bukkit.damage.DamageSource;
import org.bukkit.entity.*;
import org.bukkit.entity.memory.MemoryKey;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityRegainHealthEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerResourcePackStatusEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.inventory.*;
import org.bukkit.map.MapView;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.permissions.PermissionAttachmentInfo;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.util.BoundingBox;
import org.bukkit.util.RayTraceResult;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Range;
import org.jetbrains.annotations.Unmodifiable;
import org.jetbrains.annotations.UnmodifiableView;
import org.jspecify.annotations.Nullable;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.time.Duration;
import java.time.Instant;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class PlayerObjTest {
	public static void test() {
		Player player = new Player() {
			@Override
			public <T extends Projectile> @NotNull T launchProjectile(@NotNull Class<? extends T> aClass) {
				return null;
			}

			@Override
			public <T extends Projectile> @NotNull T launchProjectile(@NotNull Class<? extends T> aClass, @org.jetbrains.annotations.Nullable Vector vector) {
				return null;
			}

			@Override
			public <T extends Projectile> @NotNull T launchProjectile(@NotNull Class<? extends T> aClass, @org.jetbrains.annotations.Nullable Vector vector, @org.jetbrains.annotations.Nullable Consumer<? super T> consumer) {
				return null;
			}

			@Override
			public void sendPluginMessage(@NotNull Plugin plugin, @NotNull String s, byte @NotNull [] bytes) {

			}

			@Override
			public @NotNull Set<String> getListeningPluginChannels() {
				return Set.of();
			}

			@Override
			public @NotNull PersistentDataContainer getPersistentDataContainer() {
				return null;
			}

			@Override
			public boolean isOp() {
				return false;
			}

			@Override
			public void setOp(boolean b) {

			}

			@Override
			public boolean isPermissionSet(@NotNull String s) {
				return false;
			}

			@Override
			public boolean isPermissionSet(@NotNull Permission permission) {
				return false;
			}

			@Override
			public boolean hasPermission(@NotNull String s) {
				return false;
			}

			@Override
			public boolean hasPermission(@NotNull Permission permission) {
				return false;
			}

			@Override
			public @NotNull PermissionAttachment addAttachment(@NotNull Plugin plugin, @NotNull String s, boolean b) {
				return null;
			}

			@Override
			public @NotNull PermissionAttachment addAttachment(@NotNull Plugin plugin) {
				return null;
			}

			@Override
			public @org.jetbrains.annotations.Nullable PermissionAttachment addAttachment(@NotNull Plugin plugin, @NotNull String s, boolean b, int i) {
				return null;
			}

			@Override
			public @org.jetbrains.annotations.Nullable PermissionAttachment addAttachment(@NotNull Plugin plugin, int i) {
				return null;
			}

			@Override
			public void removeAttachment(@NotNull PermissionAttachment permissionAttachment) {

			}

			@Override
			public void recalculatePermissions() {

			}

			@Override
			public @NotNull Set<PermissionAttachmentInfo> getEffectivePermissions() {
				return Set.of();
			}

			@Override
			public void setMetadata(@NotNull String s, @NotNull MetadataValue metadataValue) {

			}

			@Override
			public @NotNull List<MetadataValue> getMetadata(@NotNull String s) {
				return List.of();
			}

			@Override
			public boolean hasMetadata(@NotNull String s) {
				return false;
			}

			@Override
			public void removeMetadata(@NotNull String s, @NotNull Plugin plugin) {

			}

			@Override
			public @org.jetbrains.annotations.Nullable Component customName() {
				return null;
			}

			@Override
			public void customName(@org.jetbrains.annotations.Nullable Component component) {

			}

			@Override
			public @org.jetbrains.annotations.Nullable String getCustomName() {
				return "";
			}

			@Override
			public void setCustomName(@org.jetbrains.annotations.Nullable String s) {

			}

			@Override
			public <T> @Nullable T getData(DataComponentType.Valued<T> valued) {
				return null;
			}

			@Override
			public <T> @Nullable T getDataOrDefault(DataComponentType.Valued<? extends T> valued, @Nullable T t) {
				return null;
			}

			@Override
			public boolean hasData(DataComponentType dataComponentType) {
				return false;
			}

			@Override
			public void damage(double v) {

			}

			@Override
			public void damage(double v, @org.jetbrains.annotations.Nullable Entity entity) {

			}

			@Override
			public void damage(double v, @NotNull DamageSource damageSource) {

			}

			@Override
			public double getHealth() {
				return 0;
			}

			@Override
			public void setHealth(double v) {

			}

			@Override
			public void heal(double v, EntityRegainHealthEvent.@NotNull RegainReason regainReason) {

			}

			@Override
			public double getAbsorptionAmount() {
				return 0;
			}

			@Override
			public void setAbsorptionAmount(double v) {

			}

			@Override
			public double getMaxHealth() {
				return 0;
			}

			@Override
			public void setMaxHealth(double v) {

			}

			@Override
			public void resetMaxHealth() {

			}

			@Override
			public @org.jetbrains.annotations.Nullable AttributeInstance getAttribute(@NotNull Attribute attribute) {
				return null;
			}

			@Override
			public void registerAttribute(@NotNull Attribute attribute) {

			}

			@Override
			public TriState getFrictionState() {
				return null;
			}

			@Override
			public void setFrictionState(TriState triState) {

			}

			@Override
			public @NotNull Map<String, Object> serialize() {
				return Map.of();
			}

			@Override
			public @UnmodifiableView Iterable<? extends BossBar> activeBossBars() {
				return null;
			}

			@Override
			public Component displayName() {
				return null;
			}

			@Override
			public void displayName(@Nullable Component component) {

			}

			@Override
			public boolean isOnline() {
				return false;
			}

			@Override
			public boolean isConnected() {
				return false;
			}

			@Override
			public double getEyeHeight() {
				return 0;
			}

			@Override
			public double getEyeHeight(boolean b) {
				return 0;
			}

			@Override
			public @NotNull Location getEyeLocation() {
				return null;
			}

			@Override
			public @NotNull List<Block> getLineOfSight(@org.jetbrains.annotations.Nullable Set<Material> set, int i) {
				return List.of();
			}

			@Override
			public @NotNull Block getTargetBlock(@org.jetbrains.annotations.Nullable Set<Material> set, int i) {
				return null;
			}

			@Override
			public @org.jetbrains.annotations.Nullable Block getTargetBlock(int i, TargetBlockInfo.@NotNull FluidMode fluidMode) {
				return null;
			}

			@Override
			public @org.jetbrains.annotations.Nullable BlockFace getTargetBlockFace(int i, TargetBlockInfo.@NotNull FluidMode fluidMode) {
				return null;
			}

			@Override
			public @org.jetbrains.annotations.Nullable BlockFace getTargetBlockFace(int i, @NotNull FluidCollisionMode fluidCollisionMode) {
				return null;
			}

			@Override
			public @org.jetbrains.annotations.Nullable TargetBlockInfo getTargetBlockInfo(int i, TargetBlockInfo.@NotNull FluidMode fluidMode) {
				return null;
			}

			@Override
			public @org.jetbrains.annotations.Nullable Entity getTargetEntity(int i, boolean b) {
				return null;
			}

			@Override
			public @org.jetbrains.annotations.Nullable TargetEntityInfo getTargetEntityInfo(int i, boolean b) {
				return null;
			}

			@Override
			public @org.jetbrains.annotations.Nullable RayTraceResult rayTraceEntities(int i, boolean b) {
				return null;
			}

			@Override
			public @NotNull List<Block> getLastTwoTargetBlocks(@org.jetbrains.annotations.Nullable Set<Material> set, int i) {
				return List.of();
			}

			@Override
			public @org.jetbrains.annotations.Nullable Block getTargetBlockExact(int i) {
				return null;
			}

			@Override
			public @org.jetbrains.annotations.Nullable Block getTargetBlockExact(int i, @NotNull FluidCollisionMode fluidCollisionMode) {
				return null;
			}

			@Override
			public @org.jetbrains.annotations.Nullable RayTraceResult rayTraceBlocks(double v) {
				return null;
			}

			@Override
			public @org.jetbrains.annotations.Nullable RayTraceResult rayTraceBlocks(double v, @NotNull FluidCollisionMode fluidCollisionMode) {
				return null;
			}

			@Override
			public int getRemainingAir() {
				return 0;
			}

			@Override
			public void setRemainingAir(int i) {

			}

			@Override
			public int getMaximumAir() {
				return 0;
			}

			@Override
			public void setMaximumAir(int i) {

			}

			@Override
			public @org.jetbrains.annotations.Nullable ItemStack getItemInUse() {
				return null;
			}

			@Override
			public int getItemInUseTicks() {
				return 0;
			}

			@Override
			public void setItemInUseTicks(int i) {

			}

			@Override
			public int getArrowCooldown() {
				return 0;
			}

			@Override
			public void setArrowCooldown(int i) {

			}

			@Override
			public int getArrowsInBody() {
				return 0;
			}

			@Override
			public void setArrowsInBody(int i, boolean b) {

			}

			@Override
			public void setNextArrowRemoval(@Range(from = 0L, to = 2147483647L) int i) {

			}

			@Override
			public int getNextArrowRemoval() {
				return 0;
			}

			@Override
			public int getBeeStingerCooldown() {
				return 0;
			}

			@Override
			public void setBeeStingerCooldown(int i) {

			}

			@Override
			public int getBeeStingersInBody() {
				return 0;
			}

			@Override
			public void setBeeStingersInBody(int i) {

			}

			@Override
			public void setNextBeeStingerRemoval(@Range(from = 0L, to = 2147483647L) int i) {

			}

			@Override
			public int getNextBeeStingerRemoval() {
				return 0;
			}

			@Override
			public int getMaximumNoDamageTicks() {
				return 0;
			}

			@Override
			public void setMaximumNoDamageTicks(int i) {

			}

			@Override
			public double getLastDamage() {
				return 0;
			}

			@Override
			public void setLastDamage(double v) {

			}

			@Override
			public int getNoDamageTicks() {
				return 0;
			}

			@Override
			public void setNoDamageTicks(int i) {

			}

			@Override
			public int getNoActionTicks() {
				return 0;
			}

			@Override
			public void setNoActionTicks(int i) {

			}

			@Override
			public @org.jetbrains.annotations.Nullable Player getKiller() {
				return null;
			}

			@Override
			public void setKiller(@org.jetbrains.annotations.Nullable Player player) {

			}

			@Override
			public boolean addPotionEffect(@NotNull PotionEffect potionEffect) {
				return false;
			}

			@Override
			public boolean addPotionEffect(@NotNull PotionEffect potionEffect, boolean b) {
				return false;
			}

			@Override
			public boolean addPotionEffects(@NotNull Collection<PotionEffect> collection) {
				return false;
			}

			@Override
			public boolean hasPotionEffect(@NotNull PotionEffectType potionEffectType) {
				return false;
			}

			@Override
			public @org.jetbrains.annotations.Nullable PotionEffect getPotionEffect(@NotNull PotionEffectType potionEffectType) {
				return null;
			}

			@Override
			public void removePotionEffect(@NotNull PotionEffectType potionEffectType) {

			}

			@Override
			public @NotNull Collection<PotionEffect> getActivePotionEffects() {
				return List.of();
			}

			@Override
			public boolean clearActivePotionEffects() {
				return false;
			}

			@Override
			public boolean hasLineOfSight(@NotNull Entity entity) {
				return false;
			}

			@Override
			public boolean hasLineOfSight(@NotNull Location location) {
				return false;
			}

			@Override
			public boolean getRemoveWhenFarAway() {
				return false;
			}

			@Override
			public void setRemoveWhenFarAway(boolean b) {

			}

			@Override
			public EntityEquipment getEquipment() {
				return null;
			}

			@Override
			public void setCanPickupItems(boolean b) {

			}

			@Override
			public boolean getCanPickupItems() {
				return false;
			}

			@Override
			public boolean isLeashed() {
				return false;
			}

			@Override
			public @NotNull Entity getLeashHolder() throws IllegalStateException {
				return null;
			}

			@Override
			public boolean setLeashHolder(@org.jetbrains.annotations.Nullable Entity entity) {
				return false;
			}

			@Override
			public boolean isGliding() {
				return false;
			}

			@Override
			public void setGliding(boolean b) {

			}

			@Override
			public boolean isSwimming() {
				return false;
			}

			@Override
			public void setSwimming(boolean b) {

			}

			@Override
			public boolean isRiptiding() {
				return false;
			}

			@Override
			public void setRiptiding(boolean b) {

			}

			@Override
			public boolean isSleeping() {
				return false;
			}

			@Override
			public boolean isClimbing() {
				return false;
			}

			@Override
			public void setAI(boolean b) {

			}

			@Override
			public boolean hasAI() {
				return false;
			}

			@Override
			public void attack(@NotNull Entity entity) {

			}

			@Override
			public void swingMainHand() {

			}

			@Override
			public void swingOffHand() {

			}

			@Override
			public void playHurtAnimation(float v) {

			}

			@Override
			public void setCollidable(boolean b) {

			}

			@Override
			public boolean isCollidable() {
				return false;
			}

			@Override
			public @NotNull Set<UUID> getCollidableExemptions() {
				return Set.of();
			}

			@Override
			public <T> @org.jetbrains.annotations.Nullable T getMemory(@NotNull MemoryKey<T> memoryKey) {
				return null;
			}

			@Override
			public <T> void setMemory(@NotNull MemoryKey<T> memoryKey, @org.jetbrains.annotations.Nullable T t) {

			}

			@Override
			public @org.jetbrains.annotations.Nullable Sound getHurtSound() {
				return null;
			}

			@Override
			public @org.jetbrains.annotations.Nullable Sound getDeathSound() {
				return null;
			}

			@Override
			public @NotNull Sound getFallDamageSound(int i) {
				return null;
			}

			@Override
			public @NotNull Sound getFallDamageSoundSmall() {
				return null;
			}

			@Override
			public @NotNull Sound getFallDamageSoundBig() {
				return null;
			}

			@Override
			public @NotNull Sound getDrinkingSound(@NotNull ItemStack itemStack) {
				return null;
			}

			@Override
			public @NotNull Sound getEatingSound(@NotNull ItemStack itemStack) {
				return null;
			}

			@Override
			public boolean canBreatheUnderwater() {
				return false;
			}

			@Override
			public @NotNull EntityCategory getCategory() {
				return null;
			}

			@Override
			public int getArrowsStuck() {
				return 0;
			}

			@Override
			public void setArrowsStuck(int i) {

			}

			@Override
			public int getShieldBlockingDelay() {
				return 0;
			}

			@Override
			public void setShieldBlockingDelay(int i) {

			}

			@Override
			public float getSidewaysMovement() {
				return 0;
			}

			@Override
			public float getUpwardsMovement() {
				return 0;
			}

			@Override
			public float getForwardsMovement() {
				return 0;
			}

			@Override
			public void startUsingItem(@NotNull EquipmentSlot equipmentSlot) {

			}

			@Override
			public void completeUsingActiveItem() {

			}

			@Override
			public @NotNull ItemStack getActiveItem() {
				return null;
			}

			@Override
			public void clearActiveItem() {

			}

			@Override
			public int getActiveItemRemainingTime() {
				return 0;
			}

			@Override
			public void setActiveItemRemainingTime(@Range(from = 0L, to = 2147483647L) int i) {

			}

			@Override
			public boolean hasActiveItem() {
				return false;
			}

			@Override
			public int getActiveItemUsedTime() {
				return 0;
			}

			@Override
			public @NotNull EquipmentSlot getActiveItemHand() {
				return null;
			}

			@Override
			public String getName() {
				return "TestPlayer";
			}

			@Override
			public PlayerInventory getInventory() {
				return null;
			}

			@Override
			public Inventory getEnderChest() {
				return null;
			}

			@Override
			public MainHand getMainHand() {
				return null;
			}

			@Override
			public boolean setWindowProperty(InventoryView.Property property, int i) {
				return false;
			}

			@Override
			public int getEnchantmentSeed() {
				return 0;
			}

			@Override
			public void setEnchantmentSeed(int i) {

			}

			@Override
			public InventoryView getOpenInventory() {
				return null;
			}

			@Override
			public @Nullable InventoryView openInventory(Inventory inventory) {
				return null;
			}

			@Override
			public @Nullable InventoryView openWorkbench(@Nullable Location location, boolean b) {
				return null;
			}

			@Override
			public @Nullable InventoryView openEnchanting(@Nullable Location location, boolean b) {
				return null;
			}

			@Override
			public void openInventory(InventoryView inventoryView) {

			}

			@Override
			public @Nullable InventoryView openMerchant(Villager villager, boolean b) {
				return null;
			}

			@Override
			public @Nullable InventoryView openMerchant(Merchant merchant, boolean b) {
				return null;
			}

			@Override
			public @Nullable InventoryView openAnvil(@Nullable Location location, boolean b) {
				return null;
			}

			@Override
			public @Nullable InventoryView openCartographyTable(@Nullable Location location, boolean b) {
				return null;
			}

			@Override
			public @Nullable InventoryView openGrindstone(@Nullable Location location, boolean b) {
				return null;
			}

			@Override
			public @Nullable InventoryView openLoom(@Nullable Location location, boolean b) {
				return null;
			}

			@Override
			public @Nullable InventoryView openSmithingTable(@Nullable Location location, boolean b) {
				return null;
			}

			@Override
			public @Nullable InventoryView openStonecutter(@Nullable Location location, boolean b) {
				return null;
			}

			@Override
			public void closeInventory(InventoryCloseEvent.Reason reason) {

			}

			@Override
			public ItemStack getItemInHand() {
				return null;
			}

			@Override
			public void setItemInHand(@Nullable ItemStack itemStack) {

			}

			@Override
			public ItemStack getItemOnCursor() {
				return null;
			}

			@Override
			public void setItemOnCursor(@Nullable ItemStack itemStack) {

			}

			@Override
			public boolean hasCooldown(Material material) {
				return false;
			}

			@Override
			public int getCooldown(Material material) {
				return 0;
			}

			@Override
			public void setCooldown(Material material, int i) {

			}

			@Override
			public void setHurtDirection(float v) {

			}

			@Override
			public void knockback(double v, double v1, double v2) {

			}

			@Override
			public void broadcastSlotBreak(@NotNull EquipmentSlot equipmentSlot) {

			}

			@Override
			public void broadcastSlotBreak(@NotNull EquipmentSlot equipmentSlot, @NotNull Collection<Player> collection) {

			}

			@Override
			public @NotNull ItemStack damageItemStack(@NotNull ItemStack itemStack, int i) {
				return null;
			}

			@Override
			public void damageItemStack(@NotNull EquipmentSlot equipmentSlot, int i) {

			}

			@Override
			public float getBodyYaw() {
				return 0;
			}

			@Override
			public void setBodyYaw(float v) {

			}

			@Override
			public boolean canUseEquipmentSlot(@NotNull EquipmentSlot equipmentSlot) {
				return false;
			}

			@Override
			public @NotNull CombatTracker getCombatTracker() {
				return null;
			}

			@Override
			public boolean isDeeplySleeping() {
				return false;
			}

			@Override
			public boolean hasCooldown(ItemStack itemStack) {
				return false;
			}

			@Override
			public int getCooldown(ItemStack itemStack) {
				return 0;
			}

			@Override
			public void setCooldown(ItemStack itemStack, int i) {

			}

			@Override
			public int getCooldown(Key key) {
				return 0;
			}

			@Override
			public void setCooldown(Key key, int i) {

			}

			@Override
			public int getSleepTicks() {
				return 0;
			}

			@Override
			public @Nullable Location getPotentialRespawnLocation() {
				return null;
			}

			@Override
			public @Nullable FishHook getFishHook() {
				return null;
			}

			@Override
			public boolean sleep(Location location, boolean b) {
				return false;
			}

			@Override
			public void wakeup(boolean b) {

			}

			@Override
			public void startRiptideAttack(int i, float v, @Nullable ItemStack itemStack) {

			}

			@Override
			public Location getBedLocation() {
				return null;
			}

			@Override
			public GameMode getGameMode() {
				return null;
			}

			@Override
			public void setGameMode(GameMode gameMode) {

			}

			@Override
			public boolean isBlocking() {
				return false;
			}

			@Override
			public boolean isHandRaised() {
				return false;
			}

			@Override
			public boolean isJumping() {
				return false;
			}

			@Override
			public void setJumping(boolean b) {

			}

			@Override
			public void playPickupItemAnimation(@NotNull Item item, int i) {

			}

			@Override
			public float getHurtDirection() {
				return 0;
			}

			@Override
			public int getExpToLevel() {
				return 0;
			}

			@Override
			public @Nullable Entity releaseLeftShoulderEntity() {
				return null;
			}

			@Override
			public @Nullable Entity releaseRightShoulderEntity() {
				return null;
			}

			@Override
			public float getAttackCooldown() {
				return 0;
			}

			@Override
			public boolean discoverRecipe(NamespacedKey namespacedKey) {
				return false;
			}

			@Override
			public int discoverRecipes(Collection<NamespacedKey> collection) {
				return 0;
			}

			@Override
			public boolean undiscoverRecipe(NamespacedKey namespacedKey) {
				return false;
			}

			@Override
			public int undiscoverRecipes(Collection<NamespacedKey> collection) {
				return 0;
			}

			@Override
			public boolean hasDiscoveredRecipe(NamespacedKey namespacedKey) {
				return false;
			}

			@Override
			public Set<NamespacedKey> getDiscoveredRecipes() {
				return Set.of();
			}

			@Override
			public @Nullable Entity getShoulderEntityLeft() {
				return null;
			}

			@Override
			public void setShoulderEntityLeft(@Nullable Entity entity) {

			}

			@Override
			public @Nullable Entity getShoulderEntityRight() {
				return null;
			}

			@Override
			public void setShoulderEntityRight(@Nullable Entity entity) {

			}

			@Override
			public String getDisplayName() {
				return "";
			}

			@Override
			public void setDisplayName(@Nullable String s) {

			}

			@Override
			public void playerListName(@Nullable Component component) {

			}

			@Override
			public Component playerListName() {
				return null;
			}

			@Override
			public @Nullable Component playerListHeader() {
				return null;
			}

			@Override
			public @Nullable Component playerListFooter() {
				return null;
			}

			@Override
			public String getPlayerListName() {
				return "";
			}

			@Override
			public void setPlayerListName(@Nullable String s) {

			}

			@Override
			public int getPlayerListOrder() {
				return 0;
			}

			@Override
			public void setPlayerListOrder(int i) {

			}

			@Override
			public @Nullable String getPlayerListHeader() {
				return "";
			}

			@Override
			public @Nullable String getPlayerListFooter() {
				return "";
			}

			@Override
			public void setPlayerListHeader(@Nullable String s) {

			}

			@Override
			public void setPlayerListFooter(@Nullable String s) {

			}

			@Override
			public void setPlayerListHeaderFooter(@Nullable String s, @Nullable String s1) {

			}

			@Override
			public void setCompassTarget(Location location) {

			}

			@Override
			public Location getCompassTarget() {
				return null;
			}

			@Override
			public @Nullable InetSocketAddress getAddress() {
				return null;
			}

			@Override
			public int getProtocolVersion() {
				return 0;
			}

			@Override
			public @Nullable InetSocketAddress getVirtualHost() {
				return null;
			}

			@Override
			public @Nullable InetSocketAddress getHAProxyAddress() {
				return null;
			}

			@Override
			public boolean isTransferred() {
				return false;
			}

			@Override
			public CompletableFuture<byte @Nullable []> retrieveCookie(NamespacedKey namespacedKey) {
				return null;
			}

			@Override
			public void storeCookie(NamespacedKey namespacedKey, byte[] bytes) {

			}

			@Override
			public void transfer(String s, int i) {

			}

			@Override
			public boolean isConversing() {
				return false;
			}

			@Override
			public void acceptConversationInput(@NotNull String s) {

			}

			@Override
			public boolean beginConversation(@NotNull Conversation conversation) {
				return false;
			}

			@Override
			public void abandonConversation(@NotNull Conversation conversation) {

			}

			@Override
			public void abandonConversation(@NotNull Conversation conversation, @NotNull ConversationAbandonedEvent conversationAbandonedEvent) {

			}

			@Override
			public void sendRawMessage(String s) {

			}

			@Override
			public void sendRawMessage(@org.jetbrains.annotations.Nullable UUID uuid, @NotNull String s) {

			}

			@Override
			public void kickPlayer(@Nullable String s) {

			}

			@Override
			public void kick() {

			}

			@Override
			public void kick(@Nullable Component component, PlayerKickEvent.Cause cause) {

			}

			@Override
			public <E extends BanEntry<? super PlayerProfile>> @Nullable E ban(@Nullable String s, @Nullable Date date, @Nullable String s1, boolean b) {
				return null;
			}

			@Override
			public <E extends BanEntry<? super PlayerProfile>> @Nullable E ban(@Nullable String s, @Nullable Instant instant, @Nullable String s1, boolean b) {
				return null;
			}

			@Override
			public <E extends BanEntry<? super PlayerProfile>> @Nullable E ban(@Nullable String s, @Nullable Duration duration, @Nullable String s1, boolean b) {
				return null;
			}

			@Override
			public @Nullable BanEntry<InetAddress> banIp(@Nullable String s, @Nullable Date date, @Nullable String s1, boolean b) {
				return null;
			}

			@Override
			public @Nullable BanEntry<InetAddress> banIp(@Nullable String s, @Nullable Instant instant, @Nullable String s1, boolean b) {
				return null;
			}

			@Override
			public @Nullable BanEntry<InetAddress> banIp(@Nullable String s, @Nullable Duration duration, @Nullable String s1, boolean b) {
				return null;
			}

			@Override
			public void chat(String s) {

			}

			@Override
			public boolean performCommand(String s) {
				return false;
			}

			@Override
			public @NotNull Location getLocation() {
				return null;
			}

			@Override
			public @org.jetbrains.annotations.Nullable Location getLocation(@org.jetbrains.annotations.Nullable Location location) {
				return null;
			}

			@Override
			public void setVelocity(@NotNull Vector vector) {

			}

			@Override
			public @NotNull Vector getVelocity() {
				return null;
			}

			@Override
			public double getHeight() {
				return 0;
			}

			@Override
			public double getWidth() {
				return 0;
			}

			@Override
			public @NotNull BoundingBox getBoundingBox() {
				return null;
			}

			@Override
			public boolean isOnGround() {
				return false;
			}

			@Override
			public boolean isInWater() {
				return false;
			}

			@Override
			public @NotNull World getWorld() {
				return null;
			}

			@Override
			public boolean isSneaking() {
				return false;
			}

			@Override
			public void setSneaking(boolean b) {

			}

			@Override
			public void setPose(@NotNull Pose pose, boolean b) {

			}

			@Override
			public boolean hasFixedPose() {
				return false;
			}

			@Override
			public @NotNull SpawnCategory getSpawnCategory() {
				return null;
			}

			@Override
			public boolean isInWorld() {
				return false;
			}

			@Override
			public @org.jetbrains.annotations.Nullable String getAsString() {
				return "";
			}

			@Override
			public @org.jetbrains.annotations.Nullable EntitySnapshot createSnapshot() {
				return null;
			}

			@Override
			public @NotNull Entity copy() {
				return null;
			}

			@Override
			public @NotNull Entity copy(@NotNull Location location) {
				return null;
			}

			@Override
			public boolean isSprinting() {
				return false;
			}

			@Override
			public void setSprinting(boolean b) {

			}

			@Override
			public void saveData() {

			}

			@Override
			public void loadData() {

			}

			@Override
			public void setSleepingIgnored(boolean b) {

			}

			@Override
			public boolean isSleepingIgnored() {
				return false;
			}

			@Override
			public void setBedSpawnLocation(@Nullable Location location) {

			}

			@Override
			public void setRespawnLocation(@Nullable Location location) {

			}

			@Override
			public void setBedSpawnLocation(@Nullable Location location, boolean b) {

			}

			@Override
			public void setRespawnLocation(@Nullable Location location, boolean b) {

			}

			@Override
			public Collection<EnderPearl> getEnderPearls() {
				return List.of();
			}

			@Override
			public Input getCurrentInput() {
				return null;
			}

			@Override
			public void playNote(Location location, byte b, byte b1) {

			}

			@Override
			public void playNote(Location location, Instrument instrument, Note note) {

			}

			@Override
			public void playSound(Location location, Sound sound, float v, float v1) {

			}

			@Override
			public void playSound(Location location, String s, float v, float v1) {

			}

			@Override
			public void playSound(Location location, Sound sound, SoundCategory soundCategory, float v, float v1) {

			}

			@Override
			public void playSound(Location location, String s, SoundCategory soundCategory, float v, float v1) {

			}

			@Override
			public void playSound(Location location, Sound sound, SoundCategory soundCategory, float v, float v1, long l) {

			}

			@Override
			public void playSound(Location location, String s, SoundCategory soundCategory, float v, float v1, long l) {

			}

			@Override
			public void playSound(Entity entity, Sound sound, float v, float v1) {

			}

			@Override
			public void playSound(Entity entity, String s, float v, float v1) {

			}

			@Override
			public void playSound(Entity entity, Sound sound, SoundCategory soundCategory, float v, float v1) {

			}

			@Override
			public void playSound(Entity entity, String s, SoundCategory soundCategory, float v, float v1) {

			}

			@Override
			public void playSound(Entity entity, Sound sound, SoundCategory soundCategory, float v, float v1, long l) {

			}

			@Override
			public void playSound(Entity entity, String s, SoundCategory soundCategory, float v, float v1, long l) {

			}

			@Override
			public void stopSound(Sound sound) {

			}

			@Override
			public void stopSound(String s) {

			}

			@Override
			public void stopSound(Sound sound, @Nullable SoundCategory soundCategory) {

			}

			@Override
			public void stopSound(String s, @Nullable SoundCategory soundCategory) {

			}

			@Override
			public void stopSound(SoundCategory soundCategory) {

			}

			@Override
			public void stopAllSounds() {

			}

			@Override
			public void playEffect(Location location, Effect effect, int i) {

			}

			@Override
			public <T> void playEffect(Location location, Effect effect, @Nullable T t) {

			}

			@Override
			public boolean breakBlock(Block block) {
				return false;
			}

			@Override
			public void sendBlockChange(Location location, Material material, byte b) {

			}

			@Override
			public void sendBlockChange(Location location, BlockData blockData) {

			}

			@Override
			public void sendBlockChanges(Collection<BlockState> collection) {

			}

			@Override
			public void sendBlockDamage(Location location, float v) {

			}

			@Override
			public void sendMultiBlockChange(Map<? extends Position, BlockData> map) {

			}

			@Override
			public void sendBlockDamage(Location location, float v, Entity entity) {

			}

			@Override
			public void sendBlockDamage(Location location, float v, int i) {

			}

			@Override
			public void sendEquipmentChange(LivingEntity livingEntity, EquipmentSlot equipmentSlot, @Nullable ItemStack itemStack) {

			}

			@Override
			public void sendEquipmentChange(LivingEntity livingEntity, Map<EquipmentSlot, @Nullable ItemStack> map) {

			}

			@Override
			public void sendSignChange(Location location, @Nullable List<? extends Component> list, DyeColor dyeColor, boolean b) throws IllegalArgumentException {

			}

			@Override
			public void sendSignChange(Location location, @Nullable String @Nullable [] strings) throws IllegalArgumentException {

			}

			@Override
			public void sendSignChange(Location location, @Nullable String @Nullable [] strings, DyeColor dyeColor) throws IllegalArgumentException {

			}

			@Override
			public void sendSignChange(Location location, @Nullable String @Nullable [] strings, DyeColor dyeColor, boolean b) throws IllegalArgumentException {

			}

			@Override
			public void sendBlockUpdate(Location location, TileState tileState) throws IllegalArgumentException {

			}

			@Override
			public void sendPotionEffectChange(LivingEntity livingEntity, PotionEffect potionEffect) {

			}

			@Override
			public void sendPotionEffectChangeRemove(LivingEntity livingEntity, PotionEffectType potionEffectType) {

			}

			@Override
			public void sendMap(MapView mapView) {

			}

			@Override
			public void showWinScreen() {

			}

			@Override
			public boolean hasSeenWinScreen() {
				return false;
			}

			@Override
			public void setHasSeenWinScreen(boolean b) {

			}

			@Override
			public void sendActionBar(String s) {

			}

			@Override
			public void sendActionBar(char c, String s) {

			}

			@Override
			public void sendActionBar(BaseComponent... baseComponents) {

			}

			@Override
			public void setPlayerListHeaderFooter(BaseComponent @Nullable [] baseComponents, BaseComponent @Nullable [] baseComponents1) {

			}

			@Override
			public void setPlayerListHeaderFooter(@Nullable BaseComponent baseComponent, @Nullable BaseComponent baseComponent1) {

			}

			@Override
			public void setTitleTimes(int i, int i1, int i2) {

			}

			@Override
			public void setSubtitle(BaseComponent[] baseComponents) {

			}

			@Override
			public void setSubtitle(BaseComponent baseComponent) {

			}

			@Override
			public void showTitle(@Nullable BaseComponent[] baseComponents) {

			}

			@Override
			public void showTitle(@Nullable BaseComponent baseComponent) {

			}

			@Override
			public void showTitle(@Nullable BaseComponent[] baseComponents, @Nullable BaseComponent[] baseComponents1, int i, int i1, int i2) {

			}

			@Override
			public void showTitle(@Nullable BaseComponent baseComponent, @Nullable BaseComponent baseComponent1, int i, int i1, int i2) {

			}

			@Override
			public void sendTitle(Title title) {

			}

			@Override
			public void updateTitle(Title title) {

			}

			@Override
			public void hideTitle() {

			}

			@Override
			public void sendHurtAnimation(float v) {

			}

			@Override
			public void sendLinks(ServerLinks serverLinks) {

			}

			@Override
			public void addCustomChatCompletions(Collection<String> collection) {

			}

			@Override
			public void removeCustomChatCompletions(Collection<String> collection) {

			}

			@Override
			public void setCustomChatCompletions(Collection<String> collection) {

			}

			@Override
			public void updateInventory() {

			}

			@Override
			public @Nullable GameMode getPreviousGameMode() {
				return null;
			}

			@Override
			public void setPlayerTime(long l, boolean b) {

			}

			@Override
			public long getPlayerTime() {
				return 0;
			}

			@Override
			public long getPlayerTimeOffset() {
				return 0;
			}

			@Override
			public boolean isPlayerTimeRelative() {
				return false;
			}

			@Override
			public void resetPlayerTime() {

			}

			@Override
			public void setPlayerWeather(WeatherType weatherType) {

			}

			@Override
			public @Nullable WeatherType getPlayerWeather() {
				return null;
			}

			@Override
			public void resetPlayerWeather() {

			}

			@Override
			public int getExpCooldown() {
				return 0;
			}

			@Override
			public void setExpCooldown(int i) {

			}

			@Override
			public void giveExp(int i, boolean b) {

			}

			@Override
			public int applyMending(int i) {
				return 0;
			}

			@Override
			public void giveExpLevels(int i) {

			}

			@Override
			public float getExp() {
				return 0;
			}

			@Override
			public void setExp(float v) {

			}

			@Override
			public int getLevel() {
				return 0;
			}

			@Override
			public void setLevel(int i) {

			}

			@Override
			public int getTotalExperience() {
				return 0;
			}

			@Override
			public void setTotalExperience(int i) {

			}

			@Override
			public @Range(from = 0L, to = 2147483647L) int calculateTotalExperiencePoints() {
				return 0;
			}

			@Override
			public void setExperienceLevelAndProgress(@Range(from = 0L, to = 2147483647L) int i) {

			}

			@Override
			public int getExperiencePointsNeededForNextLevel() {
				return 0;
			}

			@Override
			public void sendExperienceChange(float v) {

			}

			@Override
			public void sendExperienceChange(float v, int i) {

			}

			@Override
			public boolean getAllowFlight() {
				return false;
			}

			@Override
			public void setAllowFlight(boolean b) {

			}

			@Override
			public void setFlyingFallDamage(TriState triState) {

			}

			@Override
			public TriState hasFlyingFallDamage() {
				return null;
			}

			@Override
			public void hidePlayer(Player player) {

			}

			@Override
			public void hidePlayer(Plugin plugin, Player player) {

			}

			@Override
			public void showPlayer(Player player) {

			}

			@Override
			public void showPlayer(Plugin plugin, Player player) {

			}

			@Override
			public boolean canSee(Player player) {
				return false;
			}

			@Override
			public void hideEntity(Plugin plugin, Entity entity) {

			}

			@Override
			public void showEntity(Plugin plugin, Entity entity) {

			}

			@Override
			public boolean canSee(Entity entity) {
				return false;
			}

			@Override
			public boolean isListed(Player player) {
				return false;
			}

			@Override
			public boolean unlistPlayer(Player player) {
				return false;
			}

			@Override
			public boolean listPlayer(Player player) {
				return false;
			}

			@Override
			public boolean isFlying() {
				return false;
			}

			@Override
			public void setFlying(boolean b) {

			}

			@Override
			public void setFlySpeed(float v) throws IllegalArgumentException {

			}

			@Override
			public void setWalkSpeed(float v) throws IllegalArgumentException {

			}

			@Override
			public float getFlySpeed() {
				return 0;
			}

			@Override
			public float getWalkSpeed() {
				return 0;
			}

			@Override
			public void setTexturePack(String s) {

			}

			@Override
			public void setResourcePack(String s) {

			}

			@Override
			public void setResourcePack(String s, byte @Nullable [] bytes) {

			}

			@Override
			public void setResourcePack(String s, byte @Nullable [] bytes, @Nullable String s1) {

			}

			@Override
			public void setResourcePack(String s, byte @Nullable [] bytes, boolean b) {

			}

			@Override
			public void setResourcePack(String s, byte @Nullable [] bytes, @Nullable String s1, boolean b) {

			}

			@Override
			public void setResourcePack(UUID uuid, String s, byte @Nullable [] bytes, @Nullable String s1, boolean b) {

			}

			@Override
			public void setResourcePack(UUID uuid, String s, byte @Nullable [] bytes, @Nullable Component component, boolean b) {

			}

			@Override
			public PlayerResourcePackStatusEvent.@Nullable Status getResourcePackStatus() {
				return null;
			}

			@Override
			public void addResourcePack(UUID uuid, String s, byte @Nullable [] bytes, @Nullable String s1, boolean b) {

			}

			@Override
			public void removeResourcePack(UUID uuid) {

			}

			@Override
			public void removeResourcePacks() {

			}

			@Override
			public Scoreboard getScoreboard() {
				return null;
			}

			@Override
			public void setScoreboard(Scoreboard scoreboard) throws IllegalArgumentException, IllegalStateException {

			}

			@Override
			public @Nullable WorldBorder getWorldBorder() {
				return null;
			}

			@Override
			public void setWorldBorder(@Nullable WorldBorder worldBorder) {

			}

			@Override
			public void sendHealthUpdate(double v, int i, float v1) {

			}

			@Override
			public void sendHealthUpdate() {

			}

			@Override
			public boolean isHealthScaled() {
				return false;
			}

			@Override
			public void setHealthScaled(boolean b) {

			}

			@Override
			public void setHealthScale(double v) throws IllegalArgumentException {

			}

			@Override
			public double getHealthScale() {
				return 0;
			}

			@Override
			public @Nullable Entity getSpectatorTarget() {
				return null;
			}

			@Override
			public void setSpectatorTarget(@Nullable Entity entity) {

			}

			@Override
			public void sendTitle(@Nullable String s, @Nullable String s1) {

			}

			@Override
			public void sendTitle(@Nullable String s, @Nullable String s1, int i, int i1, int i2) {

			}

			@Override
			public void resetTitle() {

			}

			@Override
			public void spawnParticle(Particle particle, Location location, int i) {

			}

			@Override
			public void spawnParticle(Particle particle, double v, double v1, double v2, int i) {

			}

			@Override
			public <T> void spawnParticle(Particle particle, Location location, int i, @Nullable T t) {

			}

			@Override
			public <T> void spawnParticle(Particle particle, double v, double v1, double v2, int i, @Nullable T t) {

			}

			@Override
			public void spawnParticle(Particle particle, Location location, int i, double v, double v1, double v2) {

			}

			@Override
			public void spawnParticle(Particle particle, double v, double v1, double v2, int i, double v3, double v4, double v5) {

			}

			@Override
			public <T> void spawnParticle(Particle particle, Location location, int i, double v, double v1, double v2, @Nullable T t) {

			}

			@Override
			public <T> void spawnParticle(Particle particle, double v, double v1, double v2, int i, double v3, double v4, double v5, @Nullable T t) {

			}

			@Override
			public void spawnParticle(Particle particle, Location location, int i, double v, double v1, double v2, double v3) {

			}

			@Override
			public void spawnParticle(Particle particle, double v, double v1, double v2, int i, double v3, double v4, double v5, double v6) {

			}

			@Override
			public <T> void spawnParticle(Particle particle, Location location, int i, double v, double v1, double v2, double v3, @Nullable T t) {

			}

			@Override
			public <T> void spawnParticle(Particle particle, double v, double v1, double v2, int i, double v3, double v4, double v5, double v6, @Nullable T t) {

			}

			@Override
			public <T> void spawnParticle(Particle particle, Location location, int i, double v, double v1, double v2, double v3, @Nullable T t, boolean b) {

			}

			@Override
			public <T> void spawnParticle(Particle particle, double v, double v1, double v2, int i, double v3, double v4, double v5, double v6, @Nullable T t, boolean b) {

			}

			@Override
			public AdvancementProgress getAdvancementProgress(Advancement advancement) {
				return null;
			}

			@Override
			public int getClientViewDistance() {
				return 0;
			}

			@Override
			public Locale locale() {
				return null;
			}

			@Override
			public int getPing() {
				return 0;
			}

			@Override
			public String getLocale() {
				return "";
			}

			@Override
			public boolean getAffectsSpawning() {
				return false;
			}

			@Override
			public void setAffectsSpawning(boolean b) {

			}

			@Override
			public int getViewDistance() {
				return 0;
			}

			@Override
			public void setViewDistance(int i) {

			}

			@Override
			public int getSimulationDistance() {
				return 0;
			}

			@Override
			public void setSimulationDistance(int i) {

			}

			@Override
			public int getSendViewDistance() {
				return 0;
			}

			@Override
			public void setSendViewDistance(int i) {

			}

			@Override
			public void updateCommands() {

			}

			@Override
			public void openBook(ItemStack itemStack) {

			}

			@Override
			public void openSign(Sign sign) {

			}

			@Override
			public void openSign(Sign sign, Side side) {

			}

			@Override
			public boolean dropItem(boolean b) {
				return false;
			}

			@Override
			public @Nullable Item dropItem(int i, int i1, boolean b, @Nullable Consumer<Item> consumer) {
				return null;
			}

			@Override
			public @Nullable Item dropItem(EquipmentSlot equipmentSlot, int i, boolean b, @Nullable Consumer<Item> consumer) {
				return null;
			}

			@Override
			public @Nullable Item dropItem(ItemStack itemStack, boolean b, @Nullable Consumer<Item> consumer) {
				return null;
			}

			@Override
			public float getExhaustion() {
				return 0;
			}

			@Override
			public void setExhaustion(float v) {

			}

			@Override
			public float getSaturation() {
				return 0;
			}

			@Override
			public void setSaturation(float v) {

			}

			@Override
			public int getFoodLevel() {
				return 0;
			}

			@Override
			public void setFoodLevel(int i) {

			}

			@Override
			public int getSaturatedRegenRate() {
				return 0;
			}

			@Override
			public void setSaturatedRegenRate(int i) {

			}

			@Override
			public int getUnsaturatedRegenRate() {
				return 0;
			}

			@Override
			public void setUnsaturatedRegenRate(int i) {

			}

			@Override
			public int getStarvationRate() {
				return 0;
			}

			@Override
			public void setStarvationRate(int i) {

			}

			@Override
			public @Nullable Location getLastDeathLocation() {
				return null;
			}

			@Override
			public void setLastDeathLocation(@Nullable Location location) {

			}

			@Override
			public @Nullable Firework fireworkBoost(ItemStack itemStack) {
				return null;
			}

			@Override
			public void openVirtualSign(Position position, Side side) {

			}

			@Override
			public void showDemoScreen() {

			}

			@Override
			public boolean isAllowingServerListings() {
				return false;
			}

			@Override
			public PlayerProfile getPlayerProfile() {
				return null;
			}

			@Override
			public boolean isBanned() {
				return false;
			}

			@Override
			public <E extends BanEntry<? super PlayerProfile>> @Nullable E ban(@Nullable String s, @Nullable Date date, @Nullable String s1) {
				return null;
			}

			@Override
			public <E extends BanEntry<? super PlayerProfile>> @Nullable E ban(@Nullable String s, @Nullable Instant instant, @Nullable String s1) {
				return null;
			}

			@Override
			public <E extends BanEntry<? super PlayerProfile>> @Nullable E ban(@Nullable String s, @Nullable Duration duration, @Nullable String s1) {
				return null;
			}

			@Override
			public boolean isWhitelisted() {
				return false;
			}

			@Override
			public void setWhitelisted(boolean b) {

			}

			@Override
			public @Nullable Player getPlayer() {
				return null;
			}

			@Override
			public long getFirstPlayed() {
				return 0;
			}

			@Override
			public long getLastPlayed() {
				return 0;
			}

			@Override
			public boolean hasPlayedBefore() {
				return false;
			}

			@Override
			public long getLastLogin() {
				return 0;
			}

			@Override
			public long getLastSeen() {
				return 0;
			}

			@Override
			public @Nullable Location getRespawnLocation(boolean b) {
				return null;
			}

			@Override
			public void incrementStatistic(Statistic statistic) throws IllegalArgumentException {

			}

			@Override
			public void decrementStatistic(Statistic statistic) throws IllegalArgumentException {

			}

			@Override
			public void incrementStatistic(Statistic statistic, int i) throws IllegalArgumentException {

			}

			@Override
			public void decrementStatistic(Statistic statistic, int i) throws IllegalArgumentException {

			}

			@Override
			public void setStatistic(Statistic statistic, int i) throws IllegalArgumentException {

			}

			@Override
			public int getStatistic(Statistic statistic) throws IllegalArgumentException {
				return 0;
			}

			@Override
			public void incrementStatistic(Statistic statistic, Material material) throws IllegalArgumentException {

			}

			@Override
			public void decrementStatistic(Statistic statistic, Material material) throws IllegalArgumentException {

			}

			@Override
			public int getStatistic(Statistic statistic, Material material) throws IllegalArgumentException {
				return 0;
			}

			@Override
			public void incrementStatistic(Statistic statistic, Material material, int i) throws IllegalArgumentException {

			}

			@Override
			public void decrementStatistic(Statistic statistic, Material material, int i) throws IllegalArgumentException {

			}

			@Override
			public void setStatistic(Statistic statistic, Material material, int i) throws IllegalArgumentException {

			}

			@Override
			public void incrementStatistic(Statistic statistic, EntityType entityType) throws IllegalArgumentException {

			}

			@Override
			public void decrementStatistic(Statistic statistic, EntityType entityType) throws IllegalArgumentException {

			}

			@Override
			public int getStatistic(Statistic statistic, EntityType entityType) throws IllegalArgumentException {
				return 0;
			}

			@Override
			public void incrementStatistic(Statistic statistic, EntityType entityType, int i) throws IllegalArgumentException {

			}

			@Override
			public void decrementStatistic(Statistic statistic, EntityType entityType, int i) {

			}

			@Override
			public void setStatistic(Statistic statistic, EntityType entityType, int i) {

			}

			@Override
			public void setPlayerProfile(PlayerProfile playerProfile) {

			}

			@Override
			public float getCooldownPeriod() {
				return 0;
			}

			@Override
			public float getCooledAttackStrength(float v) {
				return 0;
			}

			@Override
			public void resetCooldown() {

			}

			@Override
			public <T> T getClientOption(ClientOption<T> clientOption) {
				return null;
			}

			@Override
			public void sendOpLevel(byte b) {

			}

			@Override
			public void addAdditionalChatCompletions(Collection<String> collection) {

			}

			@Override
			public void removeAdditionalChatCompletions(Collection<String> collection) {

			}

			@Override
			public @Nullable String getClientBrandName() {
				return "";
			}

			@Override
			public void setRotation(float v, float v1) {

			}

			@Override
			public boolean teleport(@NotNull Location location, PlayerTeleportEvent.@NotNull TeleportCause teleportCause, @NotNull TeleportFlag @NotNull ... teleportFlags) {
				return false;
			}

			@Override
			public void lookAt(double v, double v1, double v2, @NotNull LookAnchor lookAnchor) {

			}

			@Override
			public boolean teleport(@NotNull Location location) {
				return false;
			}

			@Override
			public boolean teleport(@NotNull Location location, PlayerTeleportEvent.@NotNull TeleportCause teleportCause) {
				return false;
			}

			@Override
			public boolean teleport(@NotNull Entity entity) {
				return false;
			}

			@Override
			public boolean teleport(@NotNull Entity entity, PlayerTeleportEvent.@NotNull TeleportCause teleportCause) {
				return false;
			}

			@Override
			public @NotNull CompletableFuture<Boolean> teleportAsync(@NotNull Location location, PlayerTeleportEvent.@NotNull TeleportCause teleportCause, @NotNull TeleportFlag @NotNull ... teleportFlags) {
				return null;
			}

			@Override
			public @NotNull List<Entity> getNearbyEntities(double v, double v1, double v2) {
				return List.of();
			}

			@Override
			public int getEntityId() {
				return 0;
			}

			@Override
			public int getFireTicks() {
				return 0;
			}

			@Override
			public int getMaxFireTicks() {
				return 0;
			}

			@Override
			public void setFireTicks(int i) {

			}

			@Override
			public void setVisualFire(boolean b) {

			}

			@Override
			public void setVisualFire(@NotNull TriState triState) {

			}

			@Override
			public boolean isVisualFire() {
				return false;
			}

			@Override
			public @NotNull TriState getVisualFire() {
				return null;
			}

			@Override
			public int getFreezeTicks() {
				return 0;
			}

			@Override
			public int getMaxFreezeTicks() {
				return 0;
			}

			@Override
			public void setFreezeTicks(int i) {

			}

			@Override
			public boolean isFrozen() {
				return false;
			}

			@Override
			public void setInvisible(boolean b) {

			}

			@Override
			public boolean isInvisible() {
				return false;
			}

			@Override
			public void setNoPhysics(boolean b) {

			}

			@Override
			public boolean hasNoPhysics() {
				return false;
			}

			@Override
			public boolean isFreezeTickingLocked() {
				return false;
			}

			@Override
			public void lockFreezeTicks(boolean b) {

			}

			@Override
			public void remove() {

			}

			@Override
			public boolean isDead() {
				return false;
			}

			@Override
			public boolean isValid() {
				return false;
			}

			@Override
			public void sendMessage(@NotNull String s) {

			}

			@Override
			public void sendMessage(@NotNull String... strings) {

			}

			@Override
			public void sendMessage(@org.jetbrains.annotations.Nullable UUID uuid, @NotNull String s) {

			}

			@Override
			public void sendMessage(@org.jetbrains.annotations.Nullable UUID uuid, @NotNull String... strings) {

			}

			@Override
			public @NotNull Server getServer() {
				return null;
			}

			@Override
			public boolean isPersistent() {
				return false;
			}

			@Override
			public void setPersistent(boolean b) {

			}

			@Override
			public @org.jetbrains.annotations.Nullable Entity getPassenger() {
				return null;
			}

			@Override
			public boolean setPassenger(@NotNull Entity entity) {
				return false;
			}

			@Override
			public @NotNull List<Entity> getPassengers() {
				return List.of();
			}

			@Override
			public boolean addPassenger(@NotNull Entity entity) {
				return false;
			}

			@Override
			public boolean removePassenger(@NotNull Entity entity) {
				return false;
			}

			@Override
			public boolean isEmpty() {
				return false;
			}

			@Override
			public boolean eject() {
				return false;
			}

			@Override
			public @NotNull ItemStack getPickItemStack() {
				return null;
			}

			@Override
			public float getFallDistance() {
				return 0;
			}

			@Override
			public void setFallDistance(float v) {

			}

			@Override
			public void setLastDamageCause(@org.jetbrains.annotations.Nullable EntityDamageEvent entityDamageEvent) {

			}

			@Override
			public @org.jetbrains.annotations.Nullable EntityDamageEvent getLastDamageCause() {
				return null;
			}

			@Override
			public @NotNull UUID getUniqueId() {
				return null;
			}

			@Override
			public int getTicksLived() {
				return 0;
			}

			@Override
			public void setTicksLived(int i) {

			}

			@Override
			public void playEffect(@NotNull EntityEffect entityEffect) {

			}

			@Override
			public @NotNull EntityType getType() {
				return null;
			}

			@Override
			public @NotNull Sound getSwimSound() {
				return null;
			}

			@Override
			public @NotNull Sound getSwimSplashSound() {
				return null;
			}

			@Override
			public @NotNull Sound getSwimHighSpeedSplashSound() {
				return null;
			}

			@Override
			public boolean isInsideVehicle() {
				return false;
			}

			@Override
			public boolean leaveVehicle() {
				return false;
			}

			@Override
			public @org.jetbrains.annotations.Nullable Entity getVehicle() {
				return null;
			}

			@Override
			public void setCustomNameVisible(boolean b) {

			}

			@Override
			public boolean isCustomNameVisible() {
				return false;
			}

			@Override
			public void setVisibleByDefault(boolean b) {

			}

			@Override
			public boolean isVisibleByDefault() {
				return false;
			}

			@Override
			public @NotNull Set<Player> getTrackedBy() {
				return Set.of();
			}

			@Override
			public boolean isTrackedBy(@NotNull Player player) {
				return false;
			}

			@Override
			public void setGlowing(boolean b) {

			}

			@Override
			public boolean isGlowing() {
				return false;
			}

			@Override
			public void setInvulnerable(boolean b) {

			}

			@Override
			public boolean isInvulnerable() {
				return false;
			}

			@Override
			public boolean isSilent() {
				return false;
			}

			@Override
			public void setSilent(boolean b) {

			}

			@Override
			public boolean hasGravity() {
				return false;
			}

			@Override
			public void setGravity(boolean b) {

			}

			@Override
			public int getPortalCooldown() {
				return 0;
			}

			@Override
			public void setPortalCooldown(int i) {

			}

			@Override
			public @NotNull Set<String> getScoreboardTags() {
				return Set.of();
			}

			@Override
			public boolean addScoreboardTag(@NotNull String s) {
				return false;
			}

			@Override
			public boolean removeScoreboardTag(@NotNull String s) {
				return false;
			}

			@Override
			public @NotNull PistonMoveReaction getPistonMoveReaction() {
				return null;
			}

			@Override
			public @NotNull BlockFace getFacing() {
				return null;
			}

			@Override
			public @NotNull Pose getPose() {
				return null;
			}

			@Override
			public void lookAt(Entity entity, LookAnchor lookAnchor, LookAnchor lookAnchor1) {

			}

			@Override
			public void showElderGuardian(boolean b) {

			}

			@Override
			public int getWardenWarningCooldown() {
				return 0;
			}

			@Override
			public void setWardenWarningCooldown(int i) {

			}

			@Override
			public int getWardenTimeSinceLastWarning() {
				return 0;
			}

			@Override
			public void setWardenTimeSinceLastWarning(int i) {

			}

			@Override
			public int getWardenWarningLevel() {
				return 0;
			}

			@Override
			public void setWardenWarningLevel(int i) {

			}

			@Override
			public void increaseWardenWarningLevel() {

			}

			@Override
			public Duration getIdleDuration() {
				return null;
			}

			@Override
			public void resetIdleDuration() {

			}

			@Override
			public @Unmodifiable Set<Long> getSentChunkKeys() {
				return Set.of();
			}

			@Override
			public @Unmodifiable Set<Chunk> getSentChunks() {
				return Set.of();
			}

			@Override
			public boolean isChunkSent(long l) {
				return false;
			}

			@Override
			public Spigot spigot() {
				return null;
			}

			@Override
			public @NotNull Component name() {
				return null;
			}

			@Override
			public @NotNull Component teamDisplayName() {
				return null;
			}

			@Override
			public @org.jetbrains.annotations.Nullable Location getOrigin() {
				return null;
			}

			@Override
			public boolean fromMobSpawner() {
				return false;
			}

			@Override
			public CreatureSpawnEvent.@NotNull SpawnReason getEntitySpawnReason() {
				return null;
			}

			@Override
			public boolean isUnderWater() {
				return false;
			}

			@Override
			public boolean isInRain() {
				return false;
			}

			@Override
			public boolean isInLava() {
				return false;
			}

			@Override
			public boolean isTicking() {
				return false;
			}

			@Override
			public @NotNull Set<Player> getTrackedPlayers() {
				return Set.of();
			}

			@Override
			public boolean spawnAt(@NotNull Location location, CreatureSpawnEvent.@NotNull SpawnReason spawnReason) {
				return false;
			}

			@Override
			public boolean isInPowderedSnow() {
				return false;
			}

			@Override
			public double getX() {
				return 0;
			}

			@Override
			public double getY() {
				return 0;
			}

			@Override
			public double getZ() {
				return 0;
			}

			@Override
			public float getPitch() {
				return 0;
			}

			@Override
			public float getYaw() {
				return 0;
			}

			@Override
			public boolean collidesAt(@NotNull Location location) {
				return false;
			}

			@Override
			public boolean wouldCollideUsing(@NotNull BoundingBox boundingBox) {
				return false;
			}

			@Override
			public @NotNull EntityScheduler getScheduler() {
				return null;
			}

			@Override
			public @NotNull String getScoreboardEntryName() {
				return "";
			}

			@Override
			public void broadcastHurtAnimation(@NotNull Collection<Player> collection) {

			}

			@Override
			public void sendEntityEffect(EntityEffect entityEffect, Entity entity) {

			}

			@Override
			public PlayerGiveResult give(Collection<ItemStack> collection, boolean b) {
				return null;
			}

			@Override
			public int getDeathScreenScore() {
				return 0;
			}

			@Override
			public void setDeathScreenScore(int i) {

			}

			@Override
			public PlayerGameConnection getConnection() {
				return null;
			}
		};
	}
}
