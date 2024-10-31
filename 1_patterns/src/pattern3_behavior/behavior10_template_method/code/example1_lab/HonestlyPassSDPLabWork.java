package pattern3_behavior.behavior10_template_method.code.example1_lab;

/**
 * Честная сдача ЛР.
 * Не списываем и следовательно нам не надо исправлять замечания.
 */
public class HonestlyPassSDPLabWork extends PassLabWork {

    @Override
    public void writeProgram() {
        System.out.println("Честно написал программу.");
    }

    @Override
    public void writeReport() {
        System.out.println("Честно написал отчет");
    }

    @Override
    public void showProgram() {
        System.out.println("Показал свою честно написанную программу.");
    }

    @Override
    public void showReport() {
        System.out.println("Показал свой честно написанный отчет.");
    }
}
