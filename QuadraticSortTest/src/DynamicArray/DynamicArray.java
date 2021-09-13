package Arrays;

import java.util.Arrays;

public class DynamicArray<T> {
    private T[] data;
    private int DEFAULT_SIZE = 5;

    public static String wrongIndexError = "Index Out of range";
    public static String negativeArraySizeError = "Size of the array must be over -1";
    public static String noSuchElementError = "Value not found";

    public DynamicArray() {
        data = (T[]) new Object[DEFAULT_SIZE];
    }

    public DynamicArray(int size) {
        if (size < 0) {
            throw new RuntimeException(negativeArraySizeError);
        }

        data = (T[]) new Object[size];
    }

    public void resize(int newSize) {
        if (newSize < 0) {
            throw new RuntimeException(negativeArraySizeError);
        }

        this.data = Arrays.copyOf(data, newSize);
    }

    public void setValue(int index, T value) {

        if (index < 0 || index >= data.length) {
            throw  new RuntimeException(wrongIndexError);
        }

        data[index] = value;
    }

    public void removeValue(int index) {
        // makes new T[] array with one element less
        // copies all the values to that array until the given index
        // pops the given index value
        // appends the rest of the old array to the new array
        // assigns new array to the old array

        if (index >= data.length || index < 0) {
            throw new RuntimeException(wrongIndexError);
        }

        T[] newArray;
        newArray = (T[]) new Object[data.length - 1];

        for (int i = 0; i < index; i++) {
            newArray[i] = getValue(i);
        }

        for (int i = index; i < newArray.length; i++) {
            newArray[i] = getValue(i+1);
        }

        this.data = newArray;
    }

    public void insertValue(int index, T value) {
        // makes new T[] array with one additional empty element
        // copies all the values to that array until the given index
        // appends new value by inserting given value to the given index
        // appends the rest of the old array to the new array
        // extends old array with 1 empty element
        // assigns new array to the old array

        if (index >= data.length || index < 0) {
            throw new RuntimeException(wrongIndexError);
        }

        T[] newArray;
        newArray = (T[]) new Object[data.length + 1];

        for (int i = 0; i < index; i++) {
            newArray[i] = getValue(i);
        }

        newArray[index] = value;

        for (int i = index+1; i < newArray.length; i++) {
            newArray[i] = getValue(i-1);
        }

        this.data = newArray;
    }

    public void addValue(T value) {
        resize(data.length + 1);
        setValue(data.length - 1, value);
    }

    public T getValue(int index) {
        if (index < 0) {
            throw new RuntimeException(wrongIndexError);
        }

        if (index >= data.length) {
            return null;
        }

        return data[index];
    }

    public int getSize() {
        return data.length;
    }

    public int findFirst(T requiredElement) {
        int counter = 0;

        for (T element : this.data) {

            /* -- check if the element is null
            it is to prevent NullPointerException */
            boolean notNull = true;
            if (element == null) {
                notNull = false;
            }
            // -- /check if the element is null

            if (notNull && element.equals(requiredElement)) {
                return counter;
            }
            counter++;
        }

        throw  new RuntimeException(noSuchElementError);
    }

    public int findLast(T requiredElement) {
        int counter = 0;
        int rightIndex = -1;

        for (T element : this.data) {

            /* -- check if the element is null
            it is to prevent NullPointerException */
            boolean notNull = true;
            if (element == null) {
                notNull = false;
            }
            // -- /check if the element is null

            if (notNull && element.equals(requiredElement)) {
                rightIndex = counter;
            }
            counter++;
        }

        if (rightIndex < 0) {
            throw  new RuntimeException(noSuchElementError);
        }

        return rightIndex;
    }

    public void printAll() {
        for (T element : data) {
            System.out.println(element);
        }
    }
}