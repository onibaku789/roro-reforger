package hu.blszk.model.gear;

import hu.blszk.model.stat.primary.PrimaryStat;
import hu.blszk.model.stat.secondary.SecondaryStat;

import java.util.List;

public class Gear {
    List<? super PrimaryStat> primaryStatList;
    List<? super SecondaryStat> secondaryStatList;

    public void addSecondaryStat(SecondaryStat secondaryStat){
        secondaryStatList.add(secondaryStat);
    }
    public void remove(SecondaryStat secondaryStat){
        secondaryStatList.remove(secondaryStat);
    }
   //TODOO find method

}
