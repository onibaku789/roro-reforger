package hu.blszk.model.stat.secondary;

import hu.blszk.model.stat.Stat;

import java.util.Objects;

public abstract class SecondaryStat extends Stat {
    private boolean isReforgedTo;
    private boolean isReforgedFrom;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SecondaryStat)) return false;
        SecondaryStat that = (SecondaryStat) o;
        return isReforgedTo == that.isReforgedTo &&
                isReforgedFrom == that.isReforgedFrom;
    }

    @Override
    public int hashCode() {
        return Objects.hash(isReforgedTo, isReforgedFrom);
    }

    public boolean isReforgedTo() {
        return isReforgedTo;
    }

    public void setReforgedTo(boolean reforgedTo) {
        isReforgedTo = reforgedTo;
    }

    public boolean isReforgedFrom() {
        return isReforgedFrom;
    }

    public void setReforgedFrom(boolean reforgedFrom) {
        isReforgedFrom = reforgedFrom;
    }
}
