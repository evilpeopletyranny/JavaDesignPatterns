package pattern3_behavior.behavior2_strategy.code.example2_sort;

import java.util.Collections;
import java.util.List;

public class AscendingSort implements SortStrategy {
    @Override
    public void sort(List<String> items) {
        Collections.sort(items);
        System.out.println("Сортировка по возрастанию: " + items);
    }
}
