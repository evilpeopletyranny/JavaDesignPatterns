package behavior.iterator.code;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Структура, хранящая элементы в массиве
 *
 * Интефейс Iterable испольузется для обхода стуктуры при помощи итератора в стиле for-each
 */
public class MyArray<E> implements Iterable<E>{
    private int counter = 0;        //счетчки элементов
    private int extendingVal = 8;   //магическое число - начальный размер и расширение
    private Object[] elements = new Object[extendingVal];   //массив элементов

    /**
     * Добавление элемента в структуру
     * @param element то, что будет добавляться в стуктуру
     */
    public void add(E element) {
        //расширение при необходимости
        if (counter == elements.length) {
            var tempArray = new Object[counter + extendingVal];
            System.arraycopy(elements, 0, tempArray, 0, counter);
            elements = tempArray;
        }
        elements[counter] = element;
        counter++;
    }

    /**
     * @return количество элементов
     */
    public int size() {
        return counter;
    }

    /**
     * @param index индекс элемента
     * @return элемент
     */
    public E get(int index) {
        return (E) elements[index];
    }

    /**
     * Удаление элемента
     * @param index элемента для удаления
     */
    public void remove(int index) {
        if ((index <= counter) && (counter > 0)
                && (index >= 0)) {
            if (index != counter)
                System.arraycopy(elements, index + 1,
                        elements, index,
                        elements.length - 1 - index);
            elements[counter--] = null;
        }
    }

    /**
     * Итератор.
     * Для простоты и лаконичности Итератор объявляется как анонимный класс.
     * При реализации интерфейса Iterable мы должны перегрузить метод iterator()
     * @return итератор по стуктуре
     */
    @Override
    public Iterator<E> iterator() {
        //создание анонимного класса на основе интерфейса
        return new Iterator<>() {
            //ВАЖНО! Отсчет в итераторе начинается как бы вне массива
            private int position = -1;

            /**
             * Проверка имеется ли следующий элемент
             */
            @Override
            public boolean hasNext() {
                return (position < size()) && elements[position + 1] != null;
            }

            /**
             * @return следующий элемент
             */
            @Override
            public E next() {
                position++;
                if (position >= size() || elements[position] == null) throw new NoSuchElementException("No more data");
                var value = (E) elements[position];
                return value;
            }

            /**
             * В основном итераторы не поддерживают удаление.
             */
            @Override
            public void remove() {
                throw new
                        UnsupportedOperationException();
            }
        };
    }
}
