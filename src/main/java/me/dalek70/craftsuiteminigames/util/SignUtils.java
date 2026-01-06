package me.dalek70.craftsuiteminigames.util;

import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.block.sign.Side;
import org.bukkit.block.sign.SignSide;

import java.util.ArrayList;
import java.util.List;

public class SignUtils {

	private static final String LINE_SEPARATOR = "\n";
	private static final int MAX_LINE_LENGTH = 15;

	/**
	 * Reads all lines from the sign on the specified side and returns them as a single string.
	 * Lines are joined with \n.
	 */
	public static String getSignText(Location loc, Side side) {
		Block block = loc.getBlock();
		if (!(block.getState() instanceof Sign)) return null;
		Sign sign = (Sign) block.getState();
		SignSide signSide = sign.getSide(side);
		String[] lines = signSide.getLines();

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 4; i++) {
			String line = (i < lines.length && lines[i] != null) ? lines[i] : "";
			sb.append(line);
			if (i < 3) sb.append(LINE_SEPARATOR);
		}
		return sb.toString();
	}

	/**
	 * Sets the sign text from a single string. Splits the string into 4 lines at \n.
	 * Each line is truncated to MAX_LINE_LENGTH characters.
	 */
	public static void setSignText(Location loc, Side side, String text, boolean waxed) {
		Block block = loc.getBlock();
		if (!(block.getState() instanceof Sign)) return;

		Sign sign = (Sign) block.getState();
		SignSide signSide = sign.getSide(side);

		text = text.replace("\r", "").replace("\n", " "); // treat newlines as spaces
		for (int i = 0; i < 4; i++) {
			int start = i * MAX_LINE_LENGTH;
			int end = Math.min(start + MAX_LINE_LENGTH, text.length());
			String line = start < text.length() ? text.substring(start, end) : "";
			signSide.setLine(i, line);
		}

		if (waxed) sign.setWaxed(true);
		sign.update(true);
	}

	/**
	 * Splits a long text across multiple signs.
	 * Each sign: 4 lines, 15 chars per line.
	 */
	/**
	 * Sets a long text across multiple signs vertically.
	 * 4 lines per sign, 15 chars per line.
	 * Avoid splitting words across lines if possible.
	 */
	public static void setTextAcrossSigns(Location[] signs, String text, boolean waxed) {
		if (signs == null || signs.length == 0) return;

		// Clean up text
		text = text.replace("\r", "").replace("\n", " ").trim();

		int maxCharsPerLine = MAX_LINE_LENGTH;
		int maxLinesPerSign = 4;

		List<String> lines = new ArrayList<>();
		String[] words = text.split(" ");

		StringBuilder currentLine = new StringBuilder();

		for (String word : words) {
			if (currentLine.length() + word.length() + (currentLine.length() > 0 ? 1 : 0) <= maxCharsPerLine) {
				if (currentLine.length() > 0) currentLine.append(" ");
				currentLine.append(word);
			} else {
				// line full, push and start new line
				lines.add(currentLine.toString());
				currentLine = new StringBuilder(word);
			}
		}
		if (currentLine.length() > 0) lines.add(currentLine.toString());

		int lineIndex = 0;
		for (Location loc : signs) {
			Block block = loc.getBlock();
			if (!(block.getState() instanceof Sign)) continue;

			Sign sign = (Sign) block.getState();
			SignSide side = sign.getSide(Side.FRONT);

			for (int i = 0; i < maxLinesPerSign; i++) {
				if (lineIndex < lines.size()) {
					side.setLine(i, lines.get(lineIndex));
					lineIndex++;
				} else {
					side.setLine(i, "");
				}
			}

			if (waxed) sign.setWaxed(true);
			sign.update(true);

			if (lineIndex >= lines.size()) break; // done
		}
	}

}
