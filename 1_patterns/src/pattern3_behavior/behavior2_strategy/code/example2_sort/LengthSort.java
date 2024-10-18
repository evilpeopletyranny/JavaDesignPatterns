package pattern3_behavior.behavior2_strategy.code.example2_sort;

import java.util.Comparator;
import java.util.List;

public class LengthSort implements SortStrategy {
    @Override
    public void sort(List<String> items) {
        items.sort(Comparator.comparingInt(String::length));
        System.out.println("Сортировка по длине: " + items);
    }
}
