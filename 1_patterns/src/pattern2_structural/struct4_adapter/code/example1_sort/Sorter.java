package pattern2_structural.struct4_adapter.code.example1_sort;

/**
 * Интерфейс, которому мы должны следовать.
 */
public interface Sorter {
    /**
     * Сортировка массива чисел
     */
    int[] sort(int... numbers);
}
