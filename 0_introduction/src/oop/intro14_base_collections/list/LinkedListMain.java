package oop.intro14_base_collections.list;

import java.util.LinkedList;
import java.util.List;

public class LinkedListMain {
    public static void main(String[] args) {
        List<String> animals = new LinkedList<>();
        animals.add("Cat");
        animals.add("Dog");
        animals.add("Elephant");

        // Добавление элемента в начало списка
        animals.addFirst("Tiger");

        // Перебор элементов
        for (String animal : animals) System.out.println(animal);

        // Удаление первого элемента
        animals.removeFirst();
        System.out.println("После удаления первого: " + animals);
    }
}
