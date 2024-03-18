package patterns.behavior.iterator.code;

public class MyListMain {
    public static void main(String[] args) {
        var myList = new MyList<String>();
        int size = 10;
        for (int i = 0; i < size; i++) myList.add("String" + (i+1));

        //Обход при помощи счетчика
        for (int i = 0; i < size; i++) System.out.println(myList.get(i));
        System.out.println();

//        //Обход итератором напрямую вызывая итератор
//        for (var iterator = myList.iterator(); iterator.myList(); ) System.out.println(iterator.next());
//        System.out.println();
//
//        //Обход в стиле for-each
//        //Возможен из-за интерфейса Iterable
//        for (var elem: myList) System.out.println(elem);
    }


}
