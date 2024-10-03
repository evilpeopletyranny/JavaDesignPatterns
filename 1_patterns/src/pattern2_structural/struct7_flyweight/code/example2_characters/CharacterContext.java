package pattern2_structural.struct7_flyweight.code.example2_characters;

public class CharacterContext {
    private final int x;
    private final int y;

    public CharacterContext(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Геттеры для внешнего состояния
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
