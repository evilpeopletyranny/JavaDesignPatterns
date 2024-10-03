package pattern2_structural.struct7_flyweight.code.example2_characters;

import java.util.HashMap;
import java.util.Map;

public class CharacterFlyweightFactory {
    private static final Map<String, CharacterFlyweight> flyweights = new HashMap<>();

    public static CharacterFlyweight getCharacter(char character, String font, int size) {
        String key = character + "-" + font + "-" + size;
        if (!flyweights.containsKey(key)) {
            flyweights.put(key, new ConcreteCharacterFlyweight(character, font, size));
            System.out.println("Creating new Flyweight for: " + key);
        }
        return flyweights.get(key);
    }

    public static int getFlyweightCount() {
        return flyweights.size();
    }
}