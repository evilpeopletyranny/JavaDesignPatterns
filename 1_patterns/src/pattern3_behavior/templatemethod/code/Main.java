package pattern3_behavior.templatemethod.code;

/**
 * Пример с честной и не честной сдачей ЛР.
 */
public class Main {
    public static void main(String[] args) {
        //Честная сдача
        //Не надо списывать
        //Не отправляют на переделку
        IPassLabWork passLW = new HonestlyPassSDPLabWork();
        passLW.pass();

        System.out.println("------------");

        //Неестная сдача
        //Списали
        //Отправляют на переделку
        passLW = new NoHonestlyPassSDPLabWork();
        passLW.pass();
    }
}
