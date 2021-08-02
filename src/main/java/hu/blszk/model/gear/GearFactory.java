package hu.blszk.model.gear;

import hu.blszk.model.stat.StatFactory;

public record GearFactory(StatFactory statFactory) {

    public Gear createGear(String text) {
        return null;
    }
}
