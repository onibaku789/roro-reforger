package hu.blszk.service.reforger;

import hu.blszk.model.CharacterSummary;
import hu.blszk.model.gear.Gear;
import hu.blszk.model.stat.secondary.SecondaryStat;
import hu.blszk.service.utility.ReforgeSuggester;

public class DefaultReforger implements Reforger {
    private ReforgeSuggester reforgeSuggester;

    @Override
    public void reforge(CharacterSummary summary, Gear gear) {
        SecondaryStat suggestedStatToReforge = reforgeSuggester.suggestSecondaryStatToReforge(summary);
        SecondaryStat suggestedStatFromReforge = reforgeSuggester.suggestSecondaryStatToBeReforged(summary);


    }
}


