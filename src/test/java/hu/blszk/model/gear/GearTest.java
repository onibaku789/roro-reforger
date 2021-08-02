package hu.blszk.model.gear;

import hu.blszk.model.stat.StatFactory;
import hu.blszk.model.stat.StatType;
import hu.blszk.model.stat.secondary.SecondaryStat;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static hu.blszk.model.stat.StatType.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GearTest {

    private static StatFactory factory;
    private Gear underTest;

    private static Stream<Arguments> source() {
        return Stream.of(
                Arguments.of(Arrays.asList(factory.createStat(100, Mastery),
                        factory.createStat(100, Haste)), Haste, CriticalStrike),
                Arguments.of(Arrays.asList(factory.createStat(100, Mastery),
                        factory.createStat(100, Haste)), Haste, CriticalStrike)
        );
    }

    @BeforeAll
    public static void setUp() {
        factory = new StatFactory();
    }

    @AfterEach
    void tearDown() {
        underTest = null;
    }

    @MethodSource("source")
    @ParameterizedTest
    void reforge(List<SecondaryStat> statsActual, StatType from, StatType to) {
        //GIVEN
        List<SecondaryStat> stats = new ArrayList<>(statsActual);
        underTest = new Gear("test", null, stats);
        Optional<Double> reforgedFrom = getValueWithType(from);
        //WHEN
        underTest.reforge(from, to);
        Optional<Double> actualFrom = getValueWithType(from);
        Optional<Double> actualTo = getValueWithType(to);
        //THEN
        assertTrue(underTest.getSecondaryStats().stream()
                .anyMatch(secondaryStat -> secondaryStat.getStatType().equals(to)));

        double reforgedFromValue = reforgedFrom.get();
        assertEquals(reforgedFromValue * 0.6, actualFrom.get());
        assertEquals(reforgedFromValue * 0.4, actualTo.get());
    }

    @Test
    @Disabled
    void reset() {
    }

    private Optional<Double> getValueWithType(StatType statType) {
        return underTest.getSecondaryStats()
                .stream()
                .filter(secondaryStat -> secondaryStat.getStatType().equals(statType))
                .findFirst()
                .map(SecondaryStat::getValue);
    }
}
