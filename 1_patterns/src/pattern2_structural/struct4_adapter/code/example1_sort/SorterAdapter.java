package pattern2_structural.struct4_adapter.code.example1_sort;

import java.util.ArrayList;
import java.util.List;

/**
 * Реализация адаптера.
 * Реализовывая необходимый интерфейс (Sorter) мы используем внешний
 * API (SorterExternalProduct).
 */
public class SorterAdapter implements Sorter {
    private final SorterExternalProduct externalProduct = new SorterExternalProduct();

    /**
     * Реализуем необходимый функционал, используя внешний API.
     * <p>
     * Суть адаптера в данном случае том, что мы адаптировали внешний API в виде
     * функции сортировки Листа к текущему интерфейсу.
     */
    @Override
    public int[] sort(int... numbers) {
        List<Integer> numberList = new ArrayList<>();
        for (var number : numbers) numberList.add(number);
        var sortedList = externalProduct.sort(numberList);
        for (var i = 0; i < sortedList.size(); i++) numbers[i] = sortedList.get(i);
        return numbers;
    }
}
