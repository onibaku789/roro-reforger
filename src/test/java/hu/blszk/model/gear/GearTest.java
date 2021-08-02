package hu.blszk.model.gear;

import hu.blszk.model.stat.StatType;
import hu.blszk.model.stat.secondary.SecondaryStat;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static hu.blszk.model.stat.StatType.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class GearTest {

    private Gear underTest;


    private static Stream<Arguments> source() {
        return Stream.of(Arguments.of(
                Arrays.asList(new SecondaryStat(100, Mastery),
                        new SecondaryStat(100, Haste)
                ),

                Arrays.asList(new SecondaryStat(100, Mastery),
                        new SecondaryStat(60, Haste),
                        new SecondaryStat(40, CriticalStrike)
                ), Haste, CriticalStrike),

                Arguments.of(Arrays.asList(new SecondaryStat(100, Haste),
                        new SecondaryStat(100, Mastery)),

                        Arrays.asList(new SecondaryStat(60, Haste),
                                new SecondaryStat(100, Mastery),
                                new SecondaryStat(40, CriticalStrike))
                        , Haste, CriticalStrike)
        );
    }

    @AfterEach
    void tearDown() {
        underTest = null;
    }

    @MethodSource("source")
    @ParameterizedTest
    void reforge(List<SecondaryStat> statsActual, List<SecondaryStat> expected, StatType from, StatType to) {
        //GIVEN
        List<SecondaryStat> stats = new ArrayList<>(statsActual);

        underTest = new Gear("test", null, stats);
        //WHEN
        underTest.reforge(from, to);
        //THEN
        assertEquals(expected, underTest.getSecondaryStats());

    }

    @Test
    @Disabled
    void reset() {
    }
}
