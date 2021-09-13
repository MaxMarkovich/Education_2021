package NLogNSort;
import java.util.Arrays;

public class NLogNSort {

    public void sort(int[] array)
    {
        boolean sorted = true;
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i+1]) {
                sorted = false;
            }
        }

        if (sorted) {
            return;
        }

        heapsort(array);
    }

    private int[] heapsort(int[] array) {
        buildheap(array);
        for (int i = array.length - 1; i >= 0; i--) {
            swap(array, i, 0);
            restoreheap(array, i, 0);
        }
        return array;
    }

    private void buildheap(int[] array) {
        int middle = (array.length / 2) - 1;

        for (int i = middle; i > -1; i--) {
            restoreheap(array, (array.length - 1), i);
        }
    }

    private void restoreheap(int[] data, int size, int index) {
        int left = ((2 * index) + 1);
        int right = ((2 * index) + 2);
        int max = index;

        if ((left < size) && (data[left] > data[index])) {
            max = left;
        }

        if ((right < size) && (data[right] > data[max])) {
            max = right;
        }

        if (max != index) {
            swap(data, index, max);
            restoreheap(data, size, max);
        }
    }


    private void swap(int[] data, int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }
}