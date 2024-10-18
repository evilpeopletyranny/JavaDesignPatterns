package pattern3_behavior.behavior2_strategy.code.example2_sort;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Sorter sorter = new Sorter();
        List<String> items = Stream.of("яблоко", "банан", "киви", "апельсин", "груша")
                .collect(Collectors.toList());

        // Сортировка по возрастанию (лексикограф. порядок)
        sorter.setStrategy(new AscendingSort());
        sorter.sort(items);

        // Сортировка по убыванию (лексикограф. порядок)
        sorter.setStrategy(new DescendingSort());
        sorter.sort(items);

        // Сортировка по длине
        sorter.setStrategy(new LengthSort());
        sorter.sort(items);
    }
}
