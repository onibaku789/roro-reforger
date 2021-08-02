package hu.blszk.model.gear;

import hu.blszk.model.stat.StatType;
import hu.blszk.model.stat.primary.PrimaryStat;
import hu.blszk.model.stat.secondary.SecondaryStat;

import java.util.List;
import java.util.Objects;

public class Gear {
    private final List<PrimaryStat> primaryStats;
    private final List<SecondaryStat> secondaryStats;
    private final String name;
    private boolean reforged;

    public Gear(String name, List<PrimaryStat> primaryStats,
                List<SecondaryStat> secondaryStats) {
        this.primaryStats = primaryStats;
        this.secondaryStats = secondaryStats;
        this.name = name;
    }

    public void reforge(StatType reforgeFrom, StatType reforgeTo) {
        if (!reforged) {
            SecondaryStat reforgeFromStat = getStatToReforge(reforgeFrom);
            SecondaryStat reforgedStat = new SecondaryStat((reforgeFromStat.getValue() * 0.4), reforgeTo);
            secondaryStats.add(reforgedStat);
            reforgeFromStat.changeValue(reforgeFromStat.getValue() * 0.6);
            reforged = true;
        }
    }

    // TODO: 8/2/2021 implement reset
    public void reset() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    private SecondaryStat getStatToReforge(StatType reforgeFrom) {
        return secondaryStats.stream()
                .filter(secondaryStat -> secondaryStat.getStatType().equals(reforgeFrom))
                .findFirst()
                .orElseThrow();
    }

    public List<SecondaryStat> getSecondaryStats() {
        return secondaryStats;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Gear gear)) return false;
        return reforged == gear.reforged
                && Objects.equals(primaryStats, gear.primaryStats)
                && Objects.equals(secondaryStats, gear.secondaryStats)
                && Objects.equals(name, gear.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(primaryStats, secondaryStats, name, reforged);
    }

    @Override
    public String toString() {
        return "Gear{" +
                "primaryStats=" + primaryStats +
                ", secondaryStats=" + secondaryStats +
                ", name='" + name + '\'' +
                ", isReforged=" + reforged +
                '}';
    }
}
