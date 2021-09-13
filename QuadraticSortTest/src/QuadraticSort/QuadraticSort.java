package QuadraticSort;

import java.util.Arrays;

public class QuadraticSort {
    public void sort(int[] data)       // Arrays.sort(data); // Replace this
    {
        for (int i =0; i < data.length; i++)
        {
            int min = data[i];
            int imin = i;
            for (int j = i + 1; j < data.length; j++)
            {
                if (data[j] < min)
                {
                    min = data[j];
                    imin = j;
                }
            }
            int N = data[i];
            data[i] = min;
            data[imin] = N;
        }
    }
}
