package pattern2_structural.adapter.code.sort;

/**
 * Интерфейс, которому мы должны следовать.
 */
public interface Sorter {
    /**
     * Сортировка массива чисел
     */
    int[] sort(int... numbers);
}
