package Queue;
import DLinkedList.*;

public class Queue<T> {
    private final DLinkedList<T> list = new DLinkedList<T>();
    private int size = 0;

    public void enqueue(T value){
        list.append(value);
        size++;
    }

    public void unenqueue(){
        list.removeNode(0);
        size--;
    }

    public int getSize() {
        return size;
    }

    public T peek() {
        return list.getNodeIndex(0).data;
    }

    public void printAll() {
        list.printAll();
    }
}