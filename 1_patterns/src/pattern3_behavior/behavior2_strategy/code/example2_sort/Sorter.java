package pattern3_behavior.behavior2_strategy.code.example2_sort;

import java.util.List;
import java.util.Objects;

public class Sorter {
    private SortStrategy strategy;

    public void setStrategy(SortStrategy strategy) {
        this.strategy = strategy;
    }

    public void sort(List<String> items) {
        if (Objects.isNull(strategy)) throw new IllegalStateException("SortStrategy не установлена.");
        strategy.sort(items);
    }
}
