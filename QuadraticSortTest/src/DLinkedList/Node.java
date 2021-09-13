package DLinkedList;

public class Node<T> {
    public Node<T> next;
    public Node<T> prev;
    public T data;

    public Node(T value) {
        data = value;
    }
}