package hu.blszk.model.stat;

import hu.blszk.model.stat.primary.PrimaryStat;
import hu.blszk.model.stat.secondary.SecondaryStat;

public class StatFactory {

    public Stat createStat(double value, StatType statType) {
        if (statType.isPrimary()) {
            return new PrimaryStat(value, statType);
        } else if (statType.isSecondary()) {
            return new SecondaryStat(value, statType);
        }
        throw new RuntimeException("Stat doesn't exist " + statType);
    }
}
