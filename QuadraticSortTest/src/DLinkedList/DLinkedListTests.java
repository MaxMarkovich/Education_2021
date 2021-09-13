package DLinkedList;

import org.junit.Rule;
import org.junit.Test;
import org.junit.Assert;
import org.junit.rules.ExpectedException;

public class DLinkedListTests extends Assert {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    // -- name --



    // -- /name --







    //  -- init tests --

    @Test
    public void list_create() {
        // positive test

        DLinkedList<Integer> list = new DLinkedList<Integer>();
    }

    @Test
    public void list_create_listSize() {
        // positive test

        DLinkedList<Integer> list = new DLinkedList<Integer>();

        int actual = list.size;
        int expected = 0;
        assertEquals(expected, actual);
    }

    //  -- /init tests --

    // -- push --

    @Test
    public void push_listSize() {
        // positive test

        DLinkedList<Integer> list = new DLinkedList<Integer>();

        list.push(1);

        int actual = list.size;
        int expected = 1;
        assertEquals(expected, actual);

        list.push(1);
        list.push(1);
        list.push(1);

        actual = list.size;
        expected = 4;
        assertEquals(expected, actual);
    }

    @Test
    public void push_value_proof() {
        // positive test

        DLinkedList<Integer> list = new DLinkedList<Integer>();

        list.push(1);
        list.push(2);
        list.push(3);
        list.push(4);

        Object expected = 1;
        Object actual = list.getValueByIndex(3);
        assertEquals(expected, actual);

        expected = 2;
        actual = list.getValueByIndex(2);
        assertEquals(expected, actual);

        expected = 3;
        actual = list.getValueByIndex(1);
        assertEquals(expected, actual);

        expected = 4;
        actual = list.getValueByIndex(0);
        assertEquals(expected, actual);
    }

    // -- /push --

    // -- append --

    @Test
    public void append_listSize() {
        // positive test

        DLinkedList<Integer> list = new DLinkedList<Integer>();

        list.append(1);

        int actual = list.size;
        int expected = 1;
        assertEquals(expected, actual);

        list.append(1);
        list.append(1);
        list.append(1);

        actual = list.size;
        expected = 4;
        assertEquals(expected, actual);
    }

    @Test
    public void append_value_proof() {
        // positive test

        DLinkedList<Integer> list = new DLinkedList<Integer>();

        list.append(1);
        list.append(2);
        list.append(3);
        list.append(4);

        Object expected = 1;
        Object actual = list.getValueByIndex(0);
        assertEquals(expected, actual);

        expected = 2;
        actual = list.getValueByIndex(1);
        assertEquals(expected, actual);

        expected = 3;
        actual = list.getValueByIndex(2);
        assertEquals(expected, actual);

        expected = 4;
        actual = list.getValueByIndex(3);
        assertEquals(expected, actual);
    }

    // -- /append --

    // -- isEmpty --

    @Test
    public void isEmpty_EmptyList() {
        // positive test

        DLinkedList<Integer> list = new DLinkedList<Integer>();

        boolean expected = true;
        boolean actual = list.isEmpty();
        assertEquals(expected, actual);
    }

    @Test
    public void isEmpty_NotEmptyList() {
        // positive test

        DLinkedList<Integer> list = new DLinkedList<Integer>();

        list.push(1);

        boolean expected = false;
        boolean actual = list.isEmpty();
        assertEquals(expected, actual);

        list.push(1);
        expected = false;
        actual = list.isEmpty();
        assertEquals(expected, actual);

        list.push(1);
        list.push(1);
        list.push(1);
        list.push(1);
        expected = false;
        actual = list.isEmpty();
        assertEquals(expected, actual);
    }

    // -- /isEmpty --

    // -- notEmpty --

    @Test
    public void notEmpty_EmptyList() {
        // positive test

        DLinkedList<Integer> list = new DLinkedList<Integer>();

        boolean expected = false;
        boolean actual = list.notEmpty();
        assertEquals(expected, actual);
    }

    @Test
    public void notEmpty_NotEmptyList() {
        // positive test

        DLinkedList<Integer> list = new DLinkedList<Integer>();

        list.push(1);

        boolean expected = true;
        boolean actual = list.notEmpty();
        assertEquals(expected, actual);

        list.push(1);
        expected = true;
        actual = list.notEmpty();
        assertEquals(expected, actual);

        list.push(1);
        list.push(1);
        list.push(1);
        list.push(1);
        expected = true;
        actual = list.notEmpty();
        assertEquals(expected, actual);
    }

    // -- /notEmpty --

    // -- getValueByIndex --

    @Test
    public void getValueByIndex_FirstIndex() {
        // positive test

        DLinkedList<Integer> list = new DLinkedList<Integer>();

        list.push(69420);

        Object expected = 69420;
        Object actual = list.getValueByIndex(0);
        assertEquals(expected, actual);
    }

    @Test
    public void getValueByIndex_LastIndex() {
        // positive test

        DLinkedList<Integer> list = new DLinkedList<Integer>();

        list.push(1);
        list.push(1);
        list.push(1);
        list.push(1);
        list.append(69420);

        Object expected = 69420;
        Object actual = list.getValueByIndex(4);
        assertEquals(expected, actual);
    }

    @Test
    public void getValueByIndex_MiddleIndex() {
        // positive test

        DLinkedList<Integer> list = new DLinkedList<Integer>();


        list.append(1);
        list.append(1);
        list.append(69420);
        list.append(69420);
        list.append(69420);
        list.append(1);

        Object expected = 69420;
        Object actual = list.getValueByIndex(2);
        assertEquals(expected, actual);

        expected = 69420;
        actual = list.getValueByIndex(3);
        assertEquals(expected, actual);

        expected = 69420;
        actual = list.getValueByIndex(4);
        assertEquals(expected, actual);
    }

    @Test
    public void getValueByIndex_NegativeIndex_ThrowsException() throws RuntimeException {
        // negative test

        thrown.expect(RuntimeException.class);
        thrown.expectMessage(DLinkedList.outOfRangeError);

        DLinkedList<Integer> list = new DLinkedList<Integer>();

        list.getValueByIndex(-1);
    }

    @Test
    public void getValueByIndex_IndexOutOfRange_ThrowsException() throws RuntimeException {
        // negative test

        thrown.expect(RuntimeException.class);
        thrown.expectMessage(DLinkedList.outOfRangeError);

        DLinkedList<Integer> list = new DLinkedList<Integer>();

        list.getValueByIndex(1000);
    }

    // -- /getValueByIndex --

    // -- setValueIndex --

    @Test
    public void setValueIndex() {
        // positive test

        DLinkedList<Integer> list = new DLinkedList<Integer>();

        list.append(1);
        list.append(1);
        list.append(1);
        list.append(1);

        list.setValueIndex(1, 228);

        Object expected = 228;
        Object actual = list.getValueByIndex(1);
        assertEquals(expected, actual);
    }

    @Test
    public void setValueIndex_FirstIndex() {
        // positive test

        DLinkedList<Integer> list = new DLinkedList<Integer>();

        list.append(1);
        list.append(1);
        list.append(1);
        list.append(1);

        list.setValueIndex(0, 228);

        Object expected = 228;
        Object actual = list.getValueByIndex(0);
        assertEquals(expected, actual);
    }

    @Test
    public void setValueIndex_MiddleIndex() {
        // positive test

        DLinkedList<Integer> list = new DLinkedList<Integer>();

        list.append(1);
        list.append(1);
        list.append(1);
        list.append(1);

        list.setValueIndex(1, 228);

        Object expected = 228;
        Object actual = list.getValueByIndex(1);
        assertEquals(expected, actual);
    }

    @Test
    public void setValueIndex_LastIndex() {
        // positive test

        DLinkedList<Integer> list = new DLinkedList<Integer>();

        list.append(1);
        list.append(1);
        list.append(1);
        list.append(1);

        list.setValueIndex(3, 228);

        Object expected = 228;
        Object actual = list.getValueByIndex(3);
        assertEquals(expected, actual);
    }

    @Test
    public void setValueIndex_NegativeIndex_ThrowsException() throws RuntimeException {
        // negative test

        thrown.expect(RuntimeException.class);
        thrown.expectMessage(DLinkedList.outOfRangeError);

        DLinkedList<Integer> list = new DLinkedList<Integer>();

        list.setValueIndex(-1, 243);
    }

    @Test
    public void setValueIndex_IndexOutOfRange_ThrowsException() throws RuntimeException {
        // negative test

        thrown.expect(RuntimeException.class);
        thrown.expectMessage(DLinkedList.outOfRangeError);

        DLinkedList<Integer> list = new DLinkedList<Integer>();

        list.setValueIndex(1000, 234);
    }

    // -- /setValueIndex --

    // -- getSize --

    @Test
    public void getSize_EmptyList() {
        // positive test

        DLinkedList<Integer> list = new DLinkedList<Integer>();

        int expected = 0;
        int actual = list.size;
        assertEquals(expected, actual);
    }

    @Test
    public void getSize_NotEmptyList() {
        // positive test

        DLinkedList<Integer> list = new DLinkedList<Integer>();

        list.append(1);

        int expected = 1;
        int actual = list.size;
        assertEquals(expected, actual);

        list.append(1);
        list.append(1);
        list.append(1);

        expected = 4;
        actual = list.size;
        assertEquals(expected, actual);
    }

    // -- /getSize --

    // -- findNodeFirst --

    @Test
    public void findNodeFirst_FirstNode() {
        // positive test

        DLinkedList<Integer> list = new DLinkedList<Integer>();

        list.append(228);
        list.append(1);
        list.append(1);
        list.append(1);
        list.append(1);

        Node expected = list.getNodeIndex(0);
        Node actual = list.findNodeFirst(228);
        assertEquals(expected, actual);
    }

    @Test
    public void findNodeFirst_MiddleNode() {
        // positive test

        DLinkedList<Integer> list = new DLinkedList<Integer>();

        list.append(1);
        list.append(1);
        list.append(228);
        list.append(1);
        list.append(1);

        Node expected = list.getNodeIndex(2);
        Node actual = list.findNodeFirst(228);
        assertEquals(expected, actual);
    }

    @Test
    public void findNodeFirst_LastNode() {
        // positive test

        DLinkedList<Integer> list = new DLinkedList<Integer>();

        list.append(1);
        list.append(1);
        list.append(1);
        list.append(1);
        list.append(228);

        Node expected = list.getNodeIndex(4);
        Node actual = list.findNodeFirst(228);
        assertEquals(expected, actual);
    }

    @Test
    public void findNodeFirst_NodeDoesntExist_ThrowsException() throws RuntimeException {
        // negative test

        thrown.expect(RuntimeException.class);
        thrown.expectMessage(DLinkedList.notFoundError);

        DLinkedList<Integer> list = new DLinkedList<Integer>();

        list.findNodeFirst(234234);
    }

    // -- /findNodeFirst --

    // -- removeFirstNodeValue --

    @Test
    public void removeFirstNodeValue_FirstNode() {
        // positive test

        DLinkedList<Integer> list = new DLinkedList<Integer>();

        list.append(228);
        list.append(1);
        list.append(1);
        list.append(1);
        list.append(1);

        list.removeFirstNodeValue(228);

        Object expected = 1;
        Object actual = list.getValueByIndex(0);
        assertEquals(expected, actual);
    }

    @Test
    public void removeFirstNodeValue_MiddleNode() {
        // positive test

        DLinkedList<Integer> list = new DLinkedList<Integer>();

        list.append(1);
        list.append(1);
        list.append(228);
        list.append(1);
        list.append(1);

        list.removeFirstNodeValue(228);

        Object expected = 1;
        Object actual = list.getValueByIndex(2);
        assertEquals(expected, actual);
    }

    @Test
    public void removeFirstNodeValue_LastNode() {
        // positive test

        DLinkedList<Integer> list = new DLinkedList<Integer>();

        list.append(1);
        list.append(1);
        list.append(1);
        list.append(228);
        list.append(1);

        list.removeFirstNodeValue(228);

        Object expected = 1;
        Object actual = list.getValueByIndex(3);
        assertEquals(expected, actual);
    }

    @Test
    public void removeFirstNodeValue_MultipleNodes() {
        // positive test

        DLinkedList<Integer> list = new DLinkedList<Integer>();

        list.append(1);
        list.append(1);
        list.append(1);
        list.append(228);
        list.append(1111);
        list.append(1);

        list.removeFirstNodeValue(228);

        Object expected = 1111;
        Object actual = list.getValueByIndex(3);
        assertEquals(expected, actual);
    }

    @Test
    public void removeFirstNodeValue_Size_Validation() {
        // positive test

        DLinkedList<Integer> list = new DLinkedList<Integer>();

        list.append(1);
        list.append(1);
        list.append(1);
        list.append(228);
        list.append(1111);
        list.append(1);

        list.removeFirstNodeValue(228);

        Object expected = 5;
        Object actual = list.size;
        assertEquals(expected, actual);
    }

    @Test
    public void removeFirstNodeValue_ObjectDoesntExist_ThrowsException() throws RuntimeException {
        // negative test

        thrown.expect(RuntimeException.class);
        thrown.expectMessage(DLinkedList.notFoundError);

        DLinkedList<Integer> list = new DLinkedList<Integer>();

        list.removeFirstNodeValue(234234);
    }

    // -- /removeFirstNodeValue --
}