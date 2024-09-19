package behavior.iterator.code;

import java.util.Iterator;

/**
 * Ниже приведен пример собственной реализации класса ArrayList, который поддерживает паттерн Итератор, используя
 * интерфейсы Iterable и Iterator. Итератор реализован с помощью анонимного класса в методе iterator().
 * <p>
 * ArrayList - реализация списка на основе массива.
 *
 * @param <T> generic тип
 */
public class MyArrayList<T> implements Iterable<T> {
    private T[] elements;                               //массив для хранения элементов
    private int size = 0;                               //
    private static final int DEFAULT_CAPACITY = 10;

    /**
     * Конструктор без параметров, создает массив с размером по умолчанию.
     */
    public MyArrayList() {
        elements = (T[]) new Object[DEFAULT_CAPACITY]; // Создаем массив с размером по умолчанию
    }

    /**
     * Добавление элемента в список
     *
     * @param element который будет добавлен
     */
    public void add(T element) {
        if (size == elements.length) resize(); // Увеличиваем массив, если места недостаточно
        elements[size++] = element;
    }

    /**
     * Метод для поулчения элемента по индексу.
     *
     * @param index индекс по которому необходимо получить элемент
     * @return найденный по индекс элементу если такой имеется
     */
    public T get(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Индекс вне допустимого диапазона: " + index);
        return elements[index];
    }

    /**
     * Метод получения размера коллекции.
     *
     * @return размер списка
     */
    public int size() {
        return size;
    }

    /**
     * Метод для увеличения размерности списка.
     * Увеличение списка в 2 раза.
     */
    private void resize() {
        T[] newArray = (T[]) new Object[elements.length * 2];              // Увеличиваем размер массива вдвое
        System.arraycopy(elements, 0, newArray, 0, size);   // Копирование элементов в массив большего размера
        elements = newArray;
    }

    /**
     * Реализация Итератор при помощи анонимного класса
     *
     * @return итератор списка
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            private int currentIndex = 0;   //По умолчанию начинаем итерацию с нулевого элемента

            /**
             * Проверка сущесвтуюет ли следующий элемент
             * (Проверка что не выгшли за границы массива)
             * @return true, если в границах массива иначе false.
             */
            @Override
            public boolean hasNext() {
                return currentIndex < size; // Проверяем, есть ли еще элементы для итерации
            }

            /**
             * Получение текущего элемента итератора.
             * @return возаращает элемент списка
             */
            @Override
            public T next() {
                if (!hasNext()) throw new IllegalStateException("Больше нет элементов");
                return elements[currentIndex++]; // Возвращаем текущий элемент и увеличиваем индекс
            }

            /**
             * Операция удаления элемента.
             * По умолчанию итератораторы не поддерживают данную операцию.
             */
            @Override
            public void remove() {
                throw new UnsupportedOperationException("Удаление не поддерживается");
            }
        };
    }
}