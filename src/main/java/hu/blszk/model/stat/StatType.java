package hu.blszk.model.stat;

import java.util.List;

public enum StatType {
    CriticalStrike,
    Expertise,
    Hit,
    Haste,
    Mastery,
    Agility,
    Stamina,
    Strength,
    Intelligence,
    Spirit,
    Dodge,
    Parry;

    private static final List<StatType> secondaryStats = List.of(Spirit, CriticalStrike, Mastery, Haste, Hit, Expertise, Dodge, Parry);
    private static final List<StatType> primaryStats = List.of(Agility, Strength, Stamina, Intelligence);

    public boolean isSecondary() {
        return secondaryStats.contains(this);
    }

    public boolean isPrimary() {
        return primaryStats.contains(this);
    }

    public static List<StatType> getPrimaryStats() {
        return primaryStats;
    }

    public static List<StatType> getSecondaryStats() {
        return List.of(CriticalStrike, Mastery, Haste, Hit, Expertise);
    }
}
