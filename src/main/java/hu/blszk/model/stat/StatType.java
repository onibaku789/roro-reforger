package hu.blszk.model.stat;

import java.util.stream.Stream;

public enum StatType {
    CriticalStrike,
    Expertise,
    Hit,
    Haste,
    Mastery,
    Agility,
    Stamina,
    Strength,
    Intelligence;
    // TODO: 8/2/2021 missing stats
    private static final Stream<StatType> primaryStats = Stream.of(Agility, Strength, Stamina, Intelligence);
    private static final Stream<StatType> secondaryStats = Stream.of(CriticalStrike, Mastery, Haste, Hit, Expertise);

    public boolean isSecondary() {
        return secondaryStats.anyMatch(statType -> statType.equals(this));
    }

    public boolean isPrimary() {
        return primaryStats.anyMatch(statType -> statType.equals(this));
    }
}
