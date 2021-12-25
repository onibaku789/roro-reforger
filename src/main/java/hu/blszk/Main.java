package hu.blszk;


import hu.blszk.model.gear.Gear;

public class Main {

    public static void main(String[] args) {
        CharacterDetailsReader reader = new CharacterDetailsReader();
        Gear gear = reader.readGearFromJson("src/main/resources/gear.json");
        System.out.println("gear = " + gear);
    }
}
