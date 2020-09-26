package hu.blszk.service.reforger;

import hu.blszk.model.CharacterSummary;
import hu.blszk.model.gear.Gear;

public interface Reforger {

    void reforge(CharacterSummary summary, Gear gear);
}
