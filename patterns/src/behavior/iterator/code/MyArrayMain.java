package behavior.iterator.code;

public class MyArrayMain {
    public static void main(String[] args) {
        var myArray = new MyArray<String>();
        int size = 10;
        for (int i = 0; i < size; i++) myArray.add("String" + (i + 1));
        System.out.println("Элементов в структуре: " + myArray.size());

        //Обход при помощи счетчика
        for (int i = 0; i < size; i++) System.out.println(myArray.get(i));
        System.out.println();

        //Обход итератором напрямую вызывая итератор
        for (var iterator = myArray.iterator(); iterator.hasNext(); ) System.out.println(iterator.next());
        System.out.println();

        //Обход в стиле for-each
        //Возможен из-за интерфейса Iterable
        for (var elem: myArray) System.out.println(elem);
    }
}
