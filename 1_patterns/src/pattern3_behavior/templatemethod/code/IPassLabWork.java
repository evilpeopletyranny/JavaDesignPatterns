package pattern3_behavior.templatemethod.code;

/**
 * Описание алгоритма сдачи ЛР.
 */
public interface IPassLabWork {
    /**
     * Сдача ЛР
     * @return оценка за ЛР
     */
    Integer pass();

    /**
     * Списать
     */
    void writeOff();

    /**
     * Написать программу
     */
    void writeProgram();

    /**
     * Написать отчет
     */
    void writeReport();

    /**
     * Показать программу
     */
    void showProgram();

    /**
     * Показать отчет
     */
    void showReport();

    /**
     * Исправить замечания
     */
    void correctRemarks();
}
