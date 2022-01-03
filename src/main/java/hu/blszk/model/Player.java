package hu.blszk.model;

import hu.blszk.model.gear.Gear;

import java.util.List;
import java.util.Objects;

public final class Player {
    private final List<Gear> gearList;

    public Player(List<Gear> gearList) {
        this.gearList = gearList;
    }

    public List<Gear> gearList() {
        return gearList;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (Player) obj;
        return Objects.equals(this.gearList, that.gearList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gearList);
    }

    @Override
    public String toString() {
        return "Player[" +
                "gearList=" + gearList + ']';
    }

}
