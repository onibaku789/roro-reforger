package hu.blszk;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import hu.blszk.model.gear.Gear;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class CharacterDetailsReader {

    public Gear readGearFromJson(String fileName) {
        Gson g = new GsonBuilder().create();
        try {
            return g.fromJson(new JsonReader(new FileReader(fileName)), Gear.class);
        } catch (FileNotFoundException e) {
            System.err.println("Couldn't find character details json!");
            throw new RuntimeException(e);
        }
    }
}
