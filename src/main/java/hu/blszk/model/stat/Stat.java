package hu.blszk.model.stat;

public interface Stat {
    double getValue();

    StatType getStatType();

    boolean isStatThisType(StatType statType);
}
