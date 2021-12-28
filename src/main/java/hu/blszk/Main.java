package hu.blszk;


import hu.blszk.model.gear.Gear;
import hu.blszk.model.stat.StatType;
import hu.blszk.model.stat.secondary.SecondaryStat;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
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
            List<StatType> statsToReforge = StatType.getSecondaryStats().stream().filter(statType -> secondaryStats.stream().map(SecondaryStat::statType).noneMatch(statType1 -> statType1.equals(statType))).toList();

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


        nemtom(new ArrayList<>(), 0);
        Instant finish = Instant.now();

        for (List<Gear> state : states) {
            System.out.println(state);
            System.out.println("\n");
        }

        System.out.println("execute time: " + Duration.between(start, finish).toMillis());
    }

    public static void nemtom(List<Gear> currentGear, int counter) {
        List<Gear> gears = new ArrayList<>(lists.get(counter));
        int size = gears.size();
        for (int i = 0; i < size; i++) {
            List<Gear> nemtom2323 = new ArrayList<>();
            nemtom2323.add(gears.remove(0));
            nemtom2323.addAll(currentGear);
            if (lists.size() - 1 <= counter) {
                states.add(nemtom2323);
            } else {
                nemtom(nemtom2323, counter + 1);
            }
        }
    }


}
