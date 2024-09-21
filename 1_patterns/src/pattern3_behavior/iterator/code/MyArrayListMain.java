package pattern3_behavior.iterator.code;

import java.util.Iterator;

public class MyArrayListMain {
    public static void main(String[] args) {
        MyArrayList<String> customList = new MyArrayList<>();
        customList.add("Яблоко");
        customList.add("Банан");
        customList.add("Апельсин");

        // Используем for-each для перебора элементов, благодаря реализации Iterable
        for (String fruit : customList) {
            System.out.println(fruit);
        }

        // Используем явный итератор для перебора элементов
        Iterator<String> iterator = customList.iterator();
        while (iterator.hasNext()) {
            System.out.println("Из итератора: " + iterator.next());
        }
    }
}
