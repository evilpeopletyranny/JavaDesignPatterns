package patterns.creational.singleton.code;

public class Main {
    public static void main(String[] args) {
        Database db1 = Database.getInstance();
        Database db2 = Database.getInstance();

        //Обратите внимание, что при выводе будет один и тот же адрес в памяти
        System.out.println("db1: " + db1);
        System.out.println("db2: " + db2);

        //Проверка по ссылкам будет true
        System.out.println("db1 == db2? " + (db1 == db2));
    }
}
