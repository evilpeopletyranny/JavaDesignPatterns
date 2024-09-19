package oop.intro14_base_collections.list;

import java.util.ArrayList;
import java.util.List;

public class ArrayListMain {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);

        // Вывод элементов через цикл for-each
        for (int number : numbers) System.out.println(number);


        // Удаление элемента
        numbers.remove(1); // Удаление элемента на позиции 1 (значение 20)
        System.out.println("После удаления: " + numbers);
    }
}