package behavior.iterator.code;

import java.util.NoSuchElementException;

public class MyList<E> {
    private int counter = 0;        //текущее число элементов
    private Node<E> head = null;    //указатель на первый элемент

    /**
     * Класс узла
     * @param <E> тип узла
     */
    private class Node<E> {
        private final E value;          //значение
        private Node<E> nextNode;       //ссылка на следующий элемент
        Node(E value, Node<E> next) {
            this.value = value;
            this.nextNode = next;
        }
    }

    /**
     * Добавление элемента
     * @param element элемент, который будет добавлен
     */
    public void add(E element) {
        head = new Node(element, head);
        counter++;
    }

    /**
     * @return размерность структуры
     */
    public int size() {
        return counter;
    }

    /**
     * @param element элемент для удаления
     * @return был ли удален элемент
     */
    public boolean remove(E element) {
        Node<E> previous = null;
        var tempNode = head;
        while (tempNode != null) {
            if (element.equals(tempNode.value)) {
                if (previous == null)
                    head = tempNode.nextNode;
                else
                    previous.nextNode = tempNode.nextNode;
                counter--;
                return true;
            }
            previous = tempNode;
            tempNode = previous.nextNode;
        }
        return false;
    }

    /**
     * Получение элемента
     * @param index элемента, который необходимо получить
     * @return элемент
     */
    public E get(int index) {
        if (index < 0 || index >= counter)
            throw new NoSuchElementException(index + " Size "
                    + counter);
        var tempNode = head;
        for (var i = 0; i < index; i++)
            tempNode = tempNode.nextNode;
        return tempNode.value;
    }
}
