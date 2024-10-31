package pattern3_behavior.behavior10_template_method.code.example1_lab;

/**
 * Нечестная сдача ЛР.
 * Списали работу, препод это заметил и отправил на исправление :)
 */
public class NoHonestlyPassSDPLabWork extends PassLabWork {
    @Override
    public void writeOff() {
        System.out.println("Гениально списал работу, думая что никто не заметит.");
    }

    @Override
    public void writeProgram() {
        System.out.println("Сделал вид, что программу написал я.");
    }

    @Override
    public void writeReport() {
        System.out.println("Что-то добавил в чужой отчет, чтобы не было видно, что я списал.");
    }

    @Override
    public void showProgram() {
        System.out.println("Показал \"свою\" программу.");
    }

    @Override
    public void showReport() {
        System.out.println("Показал \"свой\" отчет.");
    }

    @Override
    public void correctRemarks() {
        System.out.println("Препод гад заметил списывание и отправил на переделку.");
    }
}
