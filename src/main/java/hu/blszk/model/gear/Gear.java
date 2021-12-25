package hu.blszk.model.gear;

import hu.blszk.model.stat.StatType;
import hu.blszk.model.stat.primary.PrimaryStat;
import hu.blszk.model.stat.secondary.SecondaryStat;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Gear {
    private final List<PrimaryStat> primaryStats;
    private final List<SecondaryStat> secondaryStats;
    private final String name;
    private final boolean reforged;
    //TODO type?

    public Gear(String name, List<PrimaryStat> primaryStats,
                List<SecondaryStat> secondaryStats) {
        this.name = name;
        this.primaryStats = primaryStats;
        this.secondaryStats = secondaryStats;
        this.reforged = false;
    }

    public Gear(Gear gear, List<SecondaryStat> secondaryStats) {
        this.primaryStats = gear.primaryStats;
        this.secondaryStats = secondaryStats;
        this.name = gear.name;
        this.reforged = true;
    }

    public Gear reforge(StatType reforgeFrom, StatType reforgeTo) {
        if (!reforged) {
            return new Gear(this, reforgeHelper(reforgeFrom, reforgeTo));
        }
        throw new RuntimeException();
    }

    private List<SecondaryStat> reforgeHelper(StatType reforgeFrom, StatType reforgeTo) {
        SecondaryStat reforgeFromStat = getStatToReforge(reforgeFrom);
        SecondaryStat reforgedStat = new SecondaryStat((reforgeFromStat.getValue() * 0.4), reforgeTo);
        SecondaryStat reforgedFrom = new SecondaryStat((reforgeFromStat.getValue() * 0.6), reforgeFrom);
        return Stream.concat(getSecondaryStatsWithoutReforgedFrom(reforgeFrom),Stream.of(reforgedStat,reforgedFrom))
                .collect(Collectors.toList());
    }

    private Stream<SecondaryStat> getSecondaryStatsWithoutReforgedFrom(StatType reforgeFrom) {
        return secondaryStats.stream().filter(secondaryStat -> !secondaryStat.isStatThisType(reforgeFrom));
    }

    // TODO: 8/2/2021 implement reset
    public void reset() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    private SecondaryStat getStatToReforge(StatType reforgeFrom) {
        return secondaryStats.stream()
                .filter(secondaryStat -> secondaryStat.isStatThisType(reforgeFrom))
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
