package hu.blszk.model.stat;

import hu.blszk.model.stat.primary.PrimaryStat;
import hu.blszk.model.stat.secondary.SecondaryStat;

public class StatFactory {

    public Stat createStat(Long value, String statTypeString) {
        StatType statType = StatType.valueOf(statTypeString);
        if (statType.isPrimary()) {
            return new PrimaryStat(value, statType);
        } else if (statType.isSecondary()) {
            return new SecondaryStat(value, statType);
        }
        throw new RuntimeException("No stat exists: " + statTypeString);
    }
}
