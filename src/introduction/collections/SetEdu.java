package introduction.collections;

import java.util.HashSet;
import java.util.Set;

public class SetEdu {
    public static void main(String[] args) {
        //Создание Set
        Set<String> set = new HashSet<>();

        //Добавление элементов
        set.add("Marina");
        set.add("Sveta");
        set.add("Ivan");
        set.add("Ivan");    //второй Ivan не добавиться

        //Проверка, что в множестве содержаться элементы
        System.out.println("Есть ли Marina в множестве: " + set.contains("Marina"));
        System.out.println("Кол-во элеменетов в множестве: " + set.size());
        for (var name: set) System.out.println(name);
    }
}
