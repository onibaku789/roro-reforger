package hu.blszk.service.utility;

import hu.blszk.model.CharacterSummary;
import hu.blszk.model.stat.secondary.SecondaryStat;

public interface ReforgeSuggester {
    SecondaryStat suggestSecondaryStatToReforge(CharacterSummary summary);

    SecondaryStat suggestSecondaryStatToBeReforged(CharacterSummary summary);
}
