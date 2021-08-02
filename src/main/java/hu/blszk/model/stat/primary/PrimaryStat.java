package hu.blszk.model.stat.primary;

import hu.blszk.model.stat.Stat;
import hu.blszk.model.stat.StatType;

import java.util.Objects;

public class PrimaryStat implements Stat {
    private final double value;
    private final StatType statType;

    public PrimaryStat(double value, StatType statType) {
        this.value = value;
        this.statType = statType;
    }

    @Override
    public double getValue() {
        return value;
    }

    @Override
    public StatType getStatType() {
        return statType;
    }

    @Override
    public void changeValue(double value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String toString() {
        return "PrimaryStat{" +
                "statType=" + statType +
                ", value=" + value +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PrimaryStat that)) return false;
        return Double.compare(that.value, value) == 0 && statType == that.statType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(statType, value);
    }

    public double value() {
        return value;
    }

    public StatType statType() {
        return statType;
    }


}
