package hu.blszk.model;

import hu.blszk.model.gear.Gear;

import java.util.List;

public record Player(List<Gear> gearList) {
}
