package Deck;

import DLinkedList.DLinkedList;

public class Deck<T> {
    DLinkedList<T> list = new DLinkedList<T>();

    public void add_front(T value) {
        list.append(value);
    }

    public void add_back(T value) {
        list.push(value);
    }

    public void pop_front() {
        if (list.size-1 < 0) {
            // exceptions preventer

            return;
        }

        list.removeNode(list.size - 1);
    }

    public void pop_back() {
        if (list.size-1 < 0) {
            // exceptions preventer

            return;
        }

        list.removeNode(0);
    }


    public T peek_front() {

        if (list.size-1 < 0) {
            // to prevent exceptions

            return null;
        }

        return list.getValueByIndex(list.size-1);
    }

    public T peek_back() {

        if (list.size-1 < 0) {
            // to prevent exceptions

            return null;
        }

        return list.getValueByIndex(0);
    }

    public int get_size() {
        return list.size;
    }
}