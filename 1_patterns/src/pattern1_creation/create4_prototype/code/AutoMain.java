package pattern1_creation.create4_prototype.code;

public class AutoMain {
    /**
     * Пример использования прототипа (копирования) на большом
     * и сложно объекте.
     */
    public static void main(String[] args) {
        //Конструктор на 10 параметров это сложно, много и страшно
        Auto blackAuto = new Auto(
                "Vasya",
                "Mercedez",
                new Engine(300, 5),
                Gearbox.AUTOMATIC,
                Color.BLACK,
                0,
                4,
                4,
                0,
                6000000L
        );

        //Для создания такого же автомобиля, но красного цвета
        //дабы не использовать гиганский конктуртор, в котором еще можно и ошибок наделать
        //воспользуемся копированием
        Auto redAuto = null;
        try {
            redAuto = (Auto) blackAuto.clone();      //скопировали
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        //Проверим, что после копирования получили одинаковые объекты
        System.out.println("Автомобили одинаковые? " + blackAuto.equals(redAuto));

        redAuto.setColor(Color.RED);        //в скопированном авто поменяли цвет
        System.out.println(redAuto);

        //Таким образом при помощи прототипа (копирования) мы создали схожие объекты
        //В обход сложных методов конфигурирования.
        //Возможно пример не очень показательный и блоки try/catch все портят,
        //но это учебный пример. В реальном мире оно может пригодиться :)
    }
}
