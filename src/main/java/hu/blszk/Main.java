package hu.blszk;


import hu.blszk.model.gear.Gear;
import hu.blszk.model.stat.StatType;
import hu.blszk.model.stat.secondary.SecondaryStat;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {

    static List<List<Gear>> lists = new ArrayList<>();
    static List<List<Gear>> states = new ArrayList<>();

    public static void main(String[] args) {
        CharacterDetailsReader reader = new CharacterDetailsReader();
        List<Gear> toon = reader.readGearFromJson("src/main/resources/gear.json");
        Instant start = Instant.now();
        for (Gear gear : toon) {
            List<SecondaryStat> secondaryStats = gear.getSecondaryStats();
            List<StatType> statsToReforge = StatType.getSecondaryStats().stream()
                    .filter(statType -> secondaryStats.stream()
                            .map(SecondaryStat::statType)
                            .noneMatch(statType1 -> statType1.equals(statType)))
                    .toList();

            List<Gear> gears = new ArrayList<>();
            gears.add(gear);
            for (SecondaryStat secondaryStat : secondaryStats) {
                for (StatType statType : statsToReforge) {
                    Gear reforge = gear.reforge(secondaryStat.getStatType(), statType);
                    gears.add(reforge);
                }
            }
            lists.add(gears);
        }


        nemtom(new LinkedList<>(), lists.size() - 1);
        Instant finish = Instant.now();

        for (List<Gear> state : states) {
            System.out.println(state);
        }

        System.out.println("execute time: " + Duration.between(start, finish).toMillis());
    }

    public static void nemtom(List<Gear> currentGear, int counter) {
        List<Gear> gears = lists.get(counter);
        for (int i = 0, gearsSize = gears.size(); i < gearsSize; i++) {
            Gear gear = gears.get(i);
            List<Gear> newGear = new LinkedList<>(currentGear);
            newGear.add(gear);
            System.out.println("counter = " + counter + ", i: " + i);
            if (counter <= 0) {
                states.add(newGear);
            } else {
                nemtom(newGear, counter - 1);
            }
        }
    }

}
