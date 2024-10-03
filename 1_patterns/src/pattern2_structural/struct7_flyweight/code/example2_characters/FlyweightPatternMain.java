package pattern2_structural.struct7_flyweight.code.example2_characters;

public class FlyweightPatternMain {
    public static void main(String[] args) {
        String text = "HELLO HELLO";
        String font = "Arial";
        int size = 12;

        int x = 0;
        int y = 0;

        for (char c : text.toCharArray()) {
            CharacterFlyweight flyweight = CharacterFlyweightFactory.getCharacter(c, font, size);
            CharacterContext context = new CharacterContext(x, y);
            flyweight.display(context);
            x += 10; // Увеличение позиции по оси X
        }

        System.out.println("Total Flyweight objects created: " + CharacterFlyweightFactory.getFlyweightCount());
    }
}
