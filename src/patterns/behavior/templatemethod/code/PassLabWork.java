package patterns.behavior.templatemethod.code;

/**
 * Абстрактный алгоритм сдачи ЛР.
 * Определяет общий алгоритм сдачи, а также некоторые шаги.
 */
public abstract class PassLabWork implements IPassLabWork {
    /**
     * Общий алгоритм сдачи
     * Определили как final - метод нельзя переопределить
     *
     * @return оценка за лр
     */
    @Override
    public final Integer pass() {
        writeOff();         //списали
        writeProgram();     //"написали" программу
        writeReport();      //"написали" отчет
        showProgram();      //показали программу
        showReport();       //показали отчет
        correctRemarks();   //исправили ошибки
        return 41;
    }

    @Override
    public void writeOff() {
        //заглушка
        //хук - необязательный метод
        //списывать не обязательно :)
    }

    @Override
    public void correctRemarks() {
        //заглушка
        //хук - необязательный метод
        //Возможно всё хорошо с первого раза
    }
}
