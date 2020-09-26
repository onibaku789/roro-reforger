package hu.blszk.service.utility;

import hu.blszk.model.CharacterSummary;
import hu.blszk.model.Player;
import hu.blszk.model.stat.secondary.SecondaryStat;

public interface CharacterSummarizer {
    CharacterSummary summary(Player player);

}
