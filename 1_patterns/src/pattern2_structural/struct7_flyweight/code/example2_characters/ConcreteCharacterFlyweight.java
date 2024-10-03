package pattern2_structural.struct7_flyweight.code.example2_characters;

public class ConcreteCharacterFlyweight implements CharacterFlyweight {
    private final char character;
    private final String font;
    private final int size;

    public ConcreteCharacterFlyweight(char character, String font, int size) {
        this.character = character;
        this.font = font;
        this.size = size;
    }

    @Override
    public void display(CharacterContext context) {
        System.out.println("Character: " + character + ", Font: " + font + ", Size: " + size +
                ", Position: (" + context.getX() + ", " + context.getY() + ")");
    }
}
