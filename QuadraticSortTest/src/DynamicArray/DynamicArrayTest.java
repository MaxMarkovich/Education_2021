package Arrays;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class DynamicArrayTests extends Assert {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    //  -- init tests --

    @Test
    public void init_DefaultArraySize() {
        // positive test

        DynamicArray dArr = new DynamicArray();

        int actualValue = dArr.getSize();

        assertEquals(5, actualValue);
    }

    @Test
    public void init_CustomArraySize_Validation() {
        // positive test

        DynamicArray dArr = new DynamicArray(10);

        int actualValue = dArr.getSize();

        assertEquals(10, actualValue);
    }

    @Test
    public void init_CustomArraySize_NegativeSize_ThrowsException() throws RuntimeException {
        // negative test

        thrown.expect(RuntimeException.class);
        thrown.expectMessage(DynamicArray.negativeArraySizeError);

        DynamicArray dArr = new DynamicArray(-1);
    }

    @Test
    public void init_CustomArraySize_ZeroSize_ThrowsException() throws RuntimeException {
        // negative test

        thrown.expect(RuntimeException.class);
        thrown.expectMessage(DynamicArray.negativeArraySizeError);

        DynamicArray dArr = new DynamicArray(0);
    }

    //  -- /init tests --


    //  -- set tests --

    @Test
    public void setValueInt_value_Validation() {
        // positive test

        DynamicArray dArr = new DynamicArray();

        dArr.setValue(1, 69420);
        Object actualValue = dArr.getValue(1);

        assertEquals(69420, actualValue);
    }

    @Test
    public void setValueString_value_Validation() {
        // positive test

        DynamicArray dArr = new DynamicArray();

        dArr.setValue(1, "69420");
        Object actualValue = dArr.getValue(1);

        assertEquals("69420", actualValue);
    }

    @Test
    public void setValue_IndexGreaterThanArrayLength_ThrowsException() throws RuntimeException {
        // negative test

        thrown.expect(RuntimeException.class);
        thrown.expectMessage(DynamicArray.wrongIndexError);

        DynamicArray dArr = new DynamicArray();
        dArr.setValue(10, "lala");
    }

    @Test
    public void setValue_IndexNegative_ThrowsException() throws RuntimeException {
        // negative test

        thrown.expect(RuntimeException.class);
        thrown.expectMessage(DynamicArray.wrongIndexError);

        DynamicArray dArr = new DynamicArray();
        dArr.setValue(-1, "lala");
    }

    //  -- /set tests --


    //  -- resize tests --
    @Test
    public void resize_arraySize_Validation() {
        // positive test

        DynamicArray dArr = new DynamicArray();

        dArr.resize(69420);
        int actualValue = dArr.getSize();

        assertEquals(69420, actualValue);
    }

    @Test
    public void resize_NegativeSize_ThrowsException() throws RuntimeException {
        // negative test

        thrown.expect(RuntimeException.class);
        thrown.expectMessage(DynamicArray.negativeArraySizeError);

        DynamicArray dArr = new DynamicArray();
        dArr.resize(-1);
    }

    @Test
    public void resize_ZeroSize_ThrowsException() throws RuntimeException {
        // negative test

        thrown.expect(RuntimeException.class);
        thrown.expectMessage(DynamicArray.negativeArraySizeError);

        DynamicArray dArr = new DynamicArray();
        dArr.resize(0);
    }

    //  -- /resize tests --


    //  -- get tests --

    @Test
    public void getValue_value_Validation() {
        // positive test

        DynamicArray dArr = new DynamicArray();

        dArr.setValue(1, 69420);
        Object actualValue = dArr.getValue(1);

        assertEquals(69420, actualValue);
    }

    @Test
    public void getValue_IndexNegative_ThrowsException() throws RuntimeException {
        // negative test

        thrown.expect(RuntimeException.class);
        thrown.expectMessage(DynamicArray.wrongIndexError);

        DynamicArray dArr = new DynamicArray();
        dArr.getValue(-1);
    }

    @Test
    public void getValue_IndexGreaterThanArraySize_ThrowsException() throws RuntimeException {
        // negative test

        thrown.expect(RuntimeException.class);
        thrown.expectMessage(DynamicArray.wrongIndexError);

        DynamicArray dArr = new DynamicArray();
        dArr.getValue(dArr.getSize() + 1);
    }

    @Test
    public void getSize_arraySize_Validation() {
        // positive test

        DynamicArray dArr = new DynamicArray(69420);

        int actualValue = dArr.getSize();

        assertEquals(69420, actualValue);
    }

    //  -- /get tests --


    //  -- findFirst tests --

    @Test
    public void findFirst_int() {
        // positive test

        DynamicArray dArr = new DynamicArray();

        dArr.setValue(1, 69420);
        int actualValue = dArr.findFirst(69420);

        assertEquals(1, actualValue);
    }

    @Test
    public void findFirst_NotExisting_ThrowsException() throws RuntimeException {
        // negative test

        thrown.expect(RuntimeException.class);
        thrown.expectMessage(DynamicArray.noSuchElementError);

        DynamicArray dArr = new DynamicArray();
        dArr.findFirst("haha");
    }

    //  -- /findFirst tests --


    //  -- findLast tests --

    @Test
    public void findLast_int() {
        // positive test

        DynamicArray dArr = new DynamicArray();

        dArr.setValue(1, 69420);
        int actualValue = dArr.findLast(69420);

        assertEquals(1, actualValue);
    }

    @Test
    public void findLast_NotExisting_ThrowsException() throws RuntimeException {
        // negative test

        thrown.expect(RuntimeException.class);
        thrown.expectMessage(DynamicArray.noSuchElementError);

        DynamicArray dArr = new DynamicArray();
        dArr.findLast("haha");
    }

    //  -- /findLast tests --


    //  -- addValue tests --

    @Test
    public void addValue_arraySize_Validation() {
        // positive test

        DynamicArray dArr = new DynamicArray(10);

        dArr.addValue(1);
        int actualValue = dArr.getSize();

        assertEquals(11, actualValue);
    }

    @Test
    public void addValue_Index_Validation() {
        // positive test

        DynamicArray dArr = new DynamicArray(5);

        dArr.addValue(1);
        int actualValue = dArr.findFirst(1);

        assertEquals(5, actualValue);
    }

    @Test
    public void addValue_Value_Validation() {
        // positive test

        DynamicArray dArr = new DynamicArray(5);

        dArr.addValue(1);
        Object actualValue = dArr.getValue(5);

        assertEquals(1, actualValue);
    }

    //  -- /addValue tests --


    //  -- insertValue tests --

    @Test
    public void insertValue_arraySize_Validation() {
        // positive test

        DynamicArray dArr = new DynamicArray(6);
        dArr.setValue(0, "garbage");
        dArr.setValue(1, "garbage");
        dArr.setValue(2, "gotcha");
        dArr.setValue(3, 2);
        dArr.setValue(4, "garbage");

        dArr.insertValue(2, 69420);
        int actualValue = dArr.getSize();

        assertEquals(7, actualValue);
    }

    @Test
    public void insertValue_insertedElementIndex_Validation() {
        // positive test

        DynamicArray dArr = new DynamicArray(6);
        dArr.setValue(0, "garbage");
        dArr.setValue(1, "garbage");
        dArr.setValue(2, "gotcha");
        dArr.setValue(3, 2);
        dArr.setValue(4, "garbage");

        dArr.insertValue(2, 69420);
        int actualValue = dArr.findFirst(69420);

        assertEquals(2, actualValue);
    }

    @Test
    public void insertValue_value_Validation() {
        // positive test

        DynamicArray dArr = new DynamicArray(6);
        dArr.setValue(0, "garbage");
        dArr.setValue(1, "garbage");
        dArr.setValue(2, "gotcha");
        dArr.setValue(3, 2);
        dArr.setValue(4, "garbage");

        dArr.insertValue(2, 69420);
        Object actualValue = dArr.getValue(2);

        assertEquals(69420, actualValue);
    }

    @Test
    public void insertValue_NegativeIndex_ThrowsException() throws RuntimeException {
        // negative test

        thrown.expect(RuntimeException.class);
        thrown.expectMessage(DynamicArray.wrongIndexError);

        DynamicArray dArr = new DynamicArray();
        dArr.setValue(0, "garbage");
        dArr.setValue(1, "garbage");
        dArr.setValue(2, "gotcha");
        dArr.setValue(3, 2);
        dArr.setValue(4, "garbage");

        dArr.insertValue(-1, 69420);
    }

    @Test
    public void insertValue_IndexGreaterArrayLength_ThrowsException() throws RuntimeException {
        // negative test

        thrown.expect(RuntimeException.class);
        thrown.expectMessage(DynamicArray.wrongIndexError);

        DynamicArray dArr = new DynamicArray(10);
        dArr.setValue(0, "garbage");
        dArr.setValue(1, "garbage");
        dArr.setValue(2, "gotcha");
        dArr.setValue(3, 2);
        dArr.setValue(4, "garbage");

        dArr.insertValue(11, 69420);
    }

    @Test
    public void insertValue_IndexEqualsArrayLength_ThrowsException() throws RuntimeException {
        // negative test

        thrown.expect(RuntimeException.class);
        thrown.expectMessage(DynamicArray.wrongIndexError);

        DynamicArray dArr = new DynamicArray(10);
        dArr.setValue(0, "garbage");
        dArr.setValue(1, "garbage");
        dArr.setValue(2, "gotcha");
        dArr.setValue(3, 2);
        dArr.setValue(4, "garbage");

        dArr.insertValue(10, 69420);
    }

    //  -- /insertValue tests --


    //  -- removeValue tests --

    @Test
    public void removeValue_arraySize_Validation() {
        // positive test

        DynamicArray dArr = new DynamicArray(6);
        dArr.setValue(0, "garbage");
        dArr.setValue(1, "garbage");
        dArr.setValue(2, "gotcha");
        dArr.setValue(3, 2);
        dArr.setValue(4, "garbage");

        dArr.removeValue(2);
        int actualValue = dArr.getSize();

        assertEquals(5, actualValue);
    }

    @Test
    public void removeValue_value_Validation() {
        // positive test

        DynamicArray dArr = new DynamicArray(6);
        dArr.setValue(0, "garbage");
        dArr.setValue(1, "garbage");
        dArr.setValue(2, 69420);
        dArr.setValue(3, 2);
        dArr.setValue(4, "garbage");

        dArr.removeValue(2);
        Object actualValue = dArr.getValue(2);

        assertEquals(2, actualValue);
    }

    @Test
    public void removeValue_removedElementIndex_Validation() throws RuntimeException {
        // negative test

        thrown.expect(RuntimeException.class);
        thrown.expectMessage(DynamicArray.noSuchElementError);

        DynamicArray dArr = new DynamicArray(6);
        dArr.setValue(0, "garbage");
        dArr.setValue(1, "garbage");
        dArr.setValue(2, "gotcha");
        dArr.setValue(3, 2);
        dArr.setValue(4, "garbage");

        dArr.removeValue(2);
        int actualValue = dArr.findFirst(69420);
    }

    @Test
    public void removeValue_NegativeIndex_ThrowsException() throws RuntimeException {
        // negative test

        thrown.expect(RuntimeException.class);
        thrown.expectMessage(DynamicArray.wrongIndexError);

        DynamicArray dArr = new DynamicArray();
        dArr.setValue(0, "garbage");
        dArr.setValue(1, "garbage");
        dArr.setValue(2, "gotcha");
        dArr.setValue(3, 2);
        dArr.setValue(4, "garbage");

        dArr.removeValue(-1);
    }

    @Test
    public void removeValue_IndexGreaterArrayLength_ThrowsException() throws RuntimeException {
        // negative test

        thrown.expect(RuntimeException.class);
        thrown.expectMessage(DynamicArray.wrongIndexError);

        DynamicArray dArr = new DynamicArray(10);
        dArr.setValue(0, "garbage");
        dArr.setValue(1, "garbage");
        dArr.setValue(2, "gotcha");
        dArr.setValue(3, 2);
        dArr.setValue(4, "garbage");

        dArr.removeValue(11);
    }

    @Test
    public void removeValue_IndexEqualsArrayLength_ThrowsException() throws RuntimeException {
        // negative test

        thrown.expect(RuntimeException.class);
        thrown.expectMessage(DynamicArray.wrongIndexError);

        DynamicArray dArr = new DynamicArray(10);
        dArr.setValue(0, "garbage");
        dArr.setValue(1, "garbage");
        dArr.setValue(2, "gotcha");
        dArr.setValue(3, 2);
        dArr.setValue(4, "garbage");

        dArr.removeValue(10);
    }

    //  -- /removeValue tests --
}