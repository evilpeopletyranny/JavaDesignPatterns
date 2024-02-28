package LR2.collections;

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
    }
}
