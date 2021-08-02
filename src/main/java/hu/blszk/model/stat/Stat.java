package hu.blszk.model.stat;

public interface Stat {
    double getValue();

    StatType getStatType();

    void changeValue(double value);
}
