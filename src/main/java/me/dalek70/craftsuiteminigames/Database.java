package me.dalek70.craftsuiteminigames;

import org.bukkit.Bukkit;
import org.bukkit.Location;

import java.io.File;
import java.sql.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class Database{

	private static Connection connection;
	private static File dbFile;

	public static void setDatabaseFolder(File folder) {
		if (!folder.exists()) folder.mkdirs();
		dbFile = new File(folder, "homes.db");
	}

	private static void connectIfNeeded() {
		if (connection != null) return;

		try {
			if (dbFile == null) {
				dbFile = new File("homes.db");
			}
			String url = "jdbc:sqlite:" + dbFile.getAbsolutePath();
			connection = DriverManager.getConnection(url);
			createTables();

			Runtime.getRuntime().addShutdownHook(new Thread(() -> {
				try {
					if (connection != null && !connection.isClosed()) {
						connection.close();
					}
				} catch (SQLException ignored) {

				}
			}));

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Could not connect to SQLite database");
		}
	}

	private static void createTables() throws SQLException {
		String sql = """
            CREATE TABLE IF NOT EXISTS homes (
                player_uuid TEXT NOT NULL,
                home_name TEXT NOT NULL,
                world TEXT NOT NULL,
                x REAL NOT NULL,
                y REAL NOT NULL,
                z REAL NOT NULL,
                yaw REAL NOT NULL,
                pitch REAL NOT NULL,
                PRIMARY KEY(player_uuid, home_name)
            );
            """;
		try (Statement stmt = connection.createStatement()) {
			stmt.execute(sql);
		}
	}

	public static void saveHome(UUID playerUUID, String homeName, Location loc) {
		connectIfNeeded();

		String sql = "INSERT OR REPLACE INTO homes (player_uuid, home_name, world, x, y, z, yaw, pitch) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		try (PreparedStatement ps = connection.prepareStatement(sql)) {
			ps.setString(1, playerUUID.toString());
			ps.setString(2, homeName.toLowerCase());
			ps.setString(3, loc.getWorld().getName());
			ps.setDouble(4, loc.getX());
			ps.setDouble(5, loc.getY());
			ps.setDouble(6, loc.getZ());
			ps.setFloat(7, loc.getYaw());
			ps.setFloat(8, loc.getPitch());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static Location loadHome(UUID playerUUID, String homeName) {
		connectIfNeeded();

		String sql = "SELECT * FROM homes WHERE player_uuid = ? AND home_name = ?";
		try (PreparedStatement ps = connection.prepareStatement(sql)) {
			ps.setString(1, playerUUID.toString());
			ps.setString(2, homeName.toLowerCase());
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					return new Location(
							Bukkit.getWorld(rs.getString("world")),
							rs.getDouble("x"),
							rs.getDouble("y"),
							rs.getDouble("z"),
							rs.getFloat("yaw"),
							rs.getFloat("pitch")
					);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static Set<String> listHomes(UUID playerUUID) {
		connectIfNeeded();

		Set<String> homes = new HashSet<>();
		String sql = "SELECT home_name FROM homes WHERE player_uuid = ?";
		try (PreparedStatement ps = connection.prepareStatement(sql)) {
			ps.setString(1, playerUUID.toString());
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					homes.add(rs.getString("home_name"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return homes;
	}

	public static boolean deleteHome(UUID playerUUID, String homeName) {
		connectIfNeeded();

		String sql = "DELETE FROM homes WHERE player_uuid = ? AND home_name = ?";
		try (PreparedStatement ps = connection.prepareStatement(sql)) {
			ps.setString(1, playerUUID.toString());
			ps.setString(2, homeName.toLowerCase());
			int affectedRows = ps.executeUpdate();
			return affectedRows > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
