package Stack;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
public class StackTests {

    @Test
    public void init_test() {
        Stack<Integer> stacky = new Stack<Integer>();
    }

    @Test
    public void getsize_test() {
        Stack<Integer> stacky = new Stack<Integer>();
        int expected = 0;

        int actualValue = stacky.getSize();
        assertEquals(expected, actualValue);

        stacky.push(1);
        expected = 1;
        actualValue = stacky.getSize();
        assertEquals(expected, actualValue);
    }

    @Test
    public void push_size_justify() {
        Stack<Integer> stacky = new Stack<Integer>();
        int expected = 1;

        stacky.push(1);

        int actualValue = stacky.getSize();
        assertEquals(expected, actualValue);
    }

    @Test
    public void push_data_justify() {
        Stack<Integer> stacky = new Stack<Integer>();
        Object expected = 1;

        stacky.push(1);

        Object actualValue = stacky.peek();
        assertEquals(expected, actualValue);
    }

    @Test
    public void pop_size_justify() {
        Stack<Integer> stacky = new Stack<Integer>();
        int expected = 0;

        stacky.push(1);
        stacky.pop();

        int actualValue = stacky.getSize();
        assertEquals(expected, actualValue);

        stacky.push(1);
        stacky.push(1);
        stacky.push(1);
        stacky.pop();
        expected = 2;
        actualValue = stacky.getSize();
        assertEquals(expected, actualValue);

        stacky.push(1);
        stacky.push(1);
        stacky.push(1);
        stacky.pop();
        stacky.pop();
        expected = 3;
        actualValue = stacky.getSize();
        assertEquals(expected, actualValue);
    }

    @Test
    public void pop_data_justify() {
        Stack<Integer> stacky = new Stack<Integer>();
        Object expected = 1;

        stacky.push(1);
        stacky.push(2);
        stacky.pop();

        Object actualValue = stacky.peek();
        assertEquals(expected, actualValue);

        stacky.push(111);
        stacky.push(222);
        stacky.push(333);
        stacky.pop();
        expected = 222;
        actualValue = stacky.peek();
        assertEquals(expected, actualValue);

        stacky.push(444);
        stacky.push(555);
        stacky.push(666);
        stacky.pop();
        stacky.pop();
        expected = 444;
        actualValue = stacky.peek();
        assertEquals(expected, actualValue);
    }

    @Test
    public void peek_data_test() {
        Stack<Integer> stacky = new Stack<Integer>();
        Object expected = 1;

        stacky.push(1);

        Object actualValue = stacky.peek();
        assertEquals(expected, actualValue);
    }

    @Test
    public void isEmpty_true() {
        Stack<Integer> stacky = new Stack<Integer>();
        boolean expected = true;

        boolean actualValue = stacky.isEmpty();
        assertEquals(expected, actualValue);
    }

    @Test
    public void isEmpty_false() {
        Stack<Integer> stacky = new Stack<Integer>();
        boolean expected = false;

        stacky.push(1);

        boolean actualValue = stacky.isEmpty();
        assertEquals(expected, actualValue);
    }
}