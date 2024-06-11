package com.diabetestracker.enums;

public enum Level {
    NORMAL(70, 140, "Your glycemic level is normal. Keep maintaining your healthy lifestyle." ),
    HYPOGLYCEMIA(Double.NEGATIVE_INFINITY, 70, "Your glycemic level is low. Consider consuming some carbohydrates."),
    HYPERGLYCEMIA(140, Double.POSITIVE_INFINITY, "Your glycemic level is high. Consider consulting your healthcare provider.");

    private final double minLevel;""
    private final double maxLevel;
    private final String defaultConseil;

    Level(double minLevel, double maxLevel, String defaultConseil) {
        this.minLevel = minLevel;
        this.maxLevel = maxLevel;
        this.defaultConseil = defaultConseil;
    }

    public double getMinLevel() {
        return minLevel;
    }

    public double getMaxLevel() {
        return maxLevel;
    }

    public String getDefaultConseil() {
        return defaultConseil;
    }

    public static Level fromValue(double value) {
        for (Level level : Level.values()) {
            if (value >= level.minLevel && value < level.maxLevel) {
                return level;
            }
        }
        throw new IllegalArgumentException("Invalid glycemic level: " + value);
    }
}
