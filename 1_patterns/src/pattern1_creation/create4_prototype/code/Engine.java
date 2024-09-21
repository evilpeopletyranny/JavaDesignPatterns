package pattern1_creation.create4_prototype.code;

/**
 * Класс двигателя
 * Обратите внимание, что раз данный класс - record, то
 * методы toString, equals и hashCode для него по умолчанию переопределяются
 * правильно.
 * Это пригодиться при реализации данных методов в классе Auto
 *
 * @param hp     лошадиные силы
 * @param volume объекм
 */
public record Engine(Integer hp,
                     Integer volume) implements Cloneable {
    /**
     * Метод копирования.
     * <p>
     * super.clone(); - выполянет поверхностное копирование.
     * И поскольку в классе двигателя все поля являются примитивами
     * поверхностного копирования достаточно.
     *
     * @return копия двигателя
     * @throws CloneNotSupportedException копируемые объекты не поддерживают Cloneable
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
