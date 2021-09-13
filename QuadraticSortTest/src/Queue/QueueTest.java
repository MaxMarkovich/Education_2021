package Queue;

import Stack.Stack;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class QueueTests {

    @Test
    public void getsize_test() {
        Queue<Integer> queue = new Queue<Integer>();
        int expected = 0;

        int actualValue = queue.getSize();
        assertEquals(expected, actualValue);

        queue.enqueue(1);
        expected = 1;
        actualValue = queue.getSize();
        assertEquals(expected, actualValue);
    }

    @Test
    public void enqueue_size_justify() {
        Queue<Integer> queue = new Queue<Integer>();
        int expected = 1;

        queue.enqueue(1);

        int actualValue = queue.getSize();
        assertEquals(expected, actualValue);
    }

    @Test
    public void enqueue_data_justify() {
        Queue<Integer> queue = new Queue<Integer>();
        int expected = 1;

        queue.enqueue(1);

        Object actualValue = queue.peek();
        assertEquals(expected, actualValue);
    }

    @Test
    public void unenqueue_size_justify() {
        Queue<Integer> queue = new Queue<Integer>();
        int expected = 0;

        queue.enqueue(1);
        queue.unenqueue();

        int actualValue = queue.getSize();
        assertEquals(expected, actualValue);

        queue.enqueue(1);
        queue.enqueue(1);
        queue.enqueue(1);
        queue.unenqueue();
        expected = 2;
        actualValue = queue.getSize();
        assertEquals(expected, actualValue);

        queue.enqueue(1);
        queue.enqueue(1);
        queue.enqueue(1);
        queue.unenqueue();
        queue.unenqueue();
        expected = 3;
        actualValue = queue.getSize();
        assertEquals(expected, actualValue);
    }

    @Test
    public void unenqueue_data_justify() {
        Queue<Integer> queue = new Queue<Integer>();
        int expected = 2;

        queue.enqueue(1);
        queue.enqueue(2);
        queue.unenqueue();

        int actualValue = queue.peek();
        assertEquals(expected, actualValue);

        queue.enqueue(111);
        queue.enqueue(222);
        queue.enqueue(333);
        queue.unenqueue();
        expected = 111;
        actualValue = queue.peek();
        assertEquals(expected, actualValue);

        queue.enqueue(444);
        queue.enqueue(555);
        queue.enqueue(666);
        queue.unenqueue();
        queue.unenqueue();
        expected = 333;
        actualValue = queue.peek();
        assertEquals(expected, actualValue);
    }