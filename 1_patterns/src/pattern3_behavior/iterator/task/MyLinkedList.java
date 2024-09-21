package pattern3_behavior.iterator.task;

import java.util.Objects;


/**
 * Ниже приведен пример собственной реализации класса LinkedList, который поддерживает паттерн Итератор с использованием
 * интерфейсов Iterable и Iterator. Итератор реализован с помощью анонимного класса в методе iterator().
 * <p>
 * LinkedList - реализация списка на основе связанных узлов
 *
 * @param <T> generic тип
 */
public class MyLinkedList<T> {
    /**
     * Внутренний класс узла, использующийся для хранения значений
     */
    private class Node {
        T data;
        Node next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    // Голова и хвост списка
    private Node head;
    private Node tail;
    private int size;

    /**
     * Конструктор по умолчанию
     */
    public MyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    /**
     * Добавление элемента к конце списка
     *
     * @param element элемент который будет добавлен
     */
    public void add(T element) {
        Objects.requireNonNull(element, "Элемент не может быть null");
        Node newNode = new Node(element);
        if (Objects.isNull(head)) head = newNode;
        else tail.next = newNode;

        tail = newNode;
        size++;
    }

    /**
     * Метод для получения элемента по индексу.
     *
     * @param index индекс по которому необходимо получить элемент
     * @return найденный по индексу элемент
     */
    public T get(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Индекс вне допустимого диапазона: " + index);

        Node current = head;
        for (int i = 0; i < index; i++) current = current.next;
        return current.data;
    }

    /**
     * Получение размерности списка
     *
     * @return размер списка
     */
    public int size() {
        return size;
    }
}

