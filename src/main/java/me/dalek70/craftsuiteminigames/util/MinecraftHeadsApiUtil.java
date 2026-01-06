package me.dalek70.craftsuiteminigames.util;

import com.google.gson.*;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.profile.PlayerProfile;
import org.bukkit.profile.PlayerTextures;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.UUID;
import java.util.logging.Level;

public final class MinecraftHeadsApiUtil {
    private static final String API_URL = "https://minecraft-heads.com/api/v2/heads/search";
    private static final Gson GSON = new GsonBuilder().setLenient().create();

    private MinecraftHeadsApiUtil() {}

    /**
     * Gets a custom head from minecraft-heads.com by its ID
     *
     * @param id The ID of the head from minecraft-heads.com
     * @return ItemStack PLAYER_HEAD with the custom texture, or plain head if failed
     */
    public static ItemStack getHeadById(int id) {
        try {
            String url = "https://minecraft-heads.com/api/v2/head/" + id;
            JsonElement json = fetchJsonFromUrl(URI.create(url));

            if (json != null && json.isJsonObject()) {
                JsonObject obj = json.getAsJsonObject();
                if (obj.has("texture")) {
                    ItemStack head = createHeadFromValue(obj.get("texture").getAsString());
                    if (obj.has("name")) {
                        setHeadName(head, obj.get("name").getAsString());
                    }
                    return head;
                }
            }
        } catch (Exception e) {
            Bukkit.getLogger().log(Level.WARNING, "Failed to fetch head with ID " + id, e);
        }

        return new ItemStack(Material.PLAYER_HEAD);
    }

    /**
     * Searches for a head on minecraft-heads.com and returns the first result
     *
     * @param search The search query
     * @return ItemStack PLAYER_HEAD with the custom texture, or plain head if not found
     */
    public static ItemStack searchAndGetFirstHead(String search) {
        try {
            String encodedSearch = URLEncoder.encode(search, StandardCharsets.UTF_8);
            String url = API_URL + "?query=" + encodedSearch;

            // Add API headers
            HttpURLConnection conn = (HttpURLConnection) URI.create(url).toURL().openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("Accept", "application/json");

            JsonElement json = GSON.fromJson(
                new BufferedReader(new InputStreamReader(conn.getInputStream())),
                JsonElement.class
            );

            if (json != null && json.isJsonArray()) {
                JsonArray results = json.getAsJsonArray();
                if (results.size() > 0) {
                    JsonObject firstResult = results.get(0).getAsJsonObject();
                    if (firstResult.has("texture")) {
                        ItemStack head = createHeadFromValue(firstResult.get("texture").getAsString());
                        if (firstResult.has("name")) {
                            setHeadName(head, firstResult.get("name").getAsString());
                        }
                        return head;
                    }
                }
            }
        } catch (Exception e) {
            Bukkit.getLogger().log(Level.WARNING, "Failed to search for head: " + search, e);
        }

        return new ItemStack(Material.PLAYER_HEAD);
    }

    private static JsonElement fetchJsonFromUrl(URI uri) throws Exception {
        HttpURLConnection conn = (HttpURLConnection) uri.toURL().openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-Type", "application/json");
        conn.setRequestProperty("Accept", "application/json");

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
            return GSON.fromJson(reader, JsonElement.class);
        } finally {
            conn.disconnect();
        }
    }

    /**
     * Creates a player head from a base64 texture string or URL
     *
     * @param value The base64 texture string or URL
     * @return ItemStack PLAYER_HEAD with the custom texture
     */
    public static ItemStack createHeadFromValue(String value) {
        ItemStack head = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta meta = (SkullMeta) head.getItemMeta();

        if (meta == null) return head;

        try {
            PlayerProfile profile = Bukkit.createPlayerProfile(UUID.randomUUID());
            PlayerTextures textures = profile.getTextures();

            // If it's a base64 string, decode it to get the URL
            if (value.length() > 100) {  // Likely base64
                try {
                    String decoded = new String(Base64.getDecoder().decode(value));
                    JsonObject textureJson = GSON.fromJson(decoded, JsonObject.class);
                    String textureUrl = textureJson.getAsJsonObject("textures")
                            .getAsJsonObject("SKIN")
                            .get("url").getAsString();
                    textures.setSkin(new URL(textureUrl));
                } catch (Exception e) {
                    // If decoding fails, try as direct URL
                    if (value.startsWith("http")) {
                        textures.setSkin(new URL(value));
                    } else {
                        Bukkit.getLogger().warning("Invalid texture value: " + value);
                        return head;
                    }
                }
            } else if (value.startsWith("http")) {
                // Direct URL
                textures.setSkin(new URL(value));
            } else {
                Bukkit.getLogger().warning("Invalid texture value: " + value);
                return head;
            }

            profile.setTextures(textures);
            meta.setOwnerProfile(profile);
            head.setItemMeta(meta);
        } catch (Exception e) {
            Bukkit.getLogger().log(Level.WARNING, "Failed to apply texture to head: " + e.getMessage(), e);
        }

        return head;
    }

    private static void setHeadName(ItemStack head, String name) {
        SkullMeta meta = (SkullMeta) head.getItemMeta();
        if (meta != null) {
            meta.setDisplayName(name);
            head.setItemMeta(meta);
        }
    }
}
