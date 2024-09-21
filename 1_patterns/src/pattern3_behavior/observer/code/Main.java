package pattern3_behavior.observer.code;

public class Main {
    public static void main(String[] args) {
        //Создали церковь
        var catholicChurch = new CatholicChurch();

        //Создали прихожан и зарегистрировали их в церки
        new Parishioner("Мартин Лютер", catholicChurch);
        new Parishioner("Жан Кальвин", catholicChurch);

        //В церкви вышла новость - подписичики о ней узнали
        catholicChurch.setNewsChurch("Инквизиция была ошибкой... месса Mea Culpa 12 марта 2000 года");
    }
}