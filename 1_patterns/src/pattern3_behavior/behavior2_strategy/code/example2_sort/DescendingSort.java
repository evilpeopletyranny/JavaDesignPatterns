package pattern3_behavior.behavior2_strategy.code.example2_sort;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DescendingSort implements SortStrategy {
    @Override
    public void sort(List<String> items) {
        Collections.sort(items, Comparator.reverseOrder());
        System.out.println("Сортировка по убыванию: " + items);
    }
}
