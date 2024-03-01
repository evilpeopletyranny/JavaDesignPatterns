package introduction.collections;

import java.util.*;

public class MapEdu {
    public static void main(String[] args) {
        //Создание Мапы
        //Ключ - String
        //Значение - Integer
        Map<String, Integer> map = new HashMap<>();

        //Добавление
        map.put("H", 1);
        map.put("e", 1);
        map.put("l", 2);
        map.put("o", 1);

        //Получение по ключу
        map.get("H");

        //Получение множества ключей
        Set<String> keys = map.keySet();
        for (var key: keys) System.out.println(key);

        //Получение списка значений
        Collection<Integer> values = map.values();
        for (var val: values) System.out.println(val);
    }
}
