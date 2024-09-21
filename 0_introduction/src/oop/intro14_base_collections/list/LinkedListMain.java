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
        animals.add("Tiger");

        // Перебор элементов
        for (String animal : animals) System.out.println(animal);

        // Удаление первого элемента
        animals.remove(animals.size()-1);
        System.out.println("После удаления первого: " + animals);
    }
}
