package src;

import java.util.Arrays;

import static util.MyUtilityClass.swap;

public class BubbleSort {
    public int[] bubbleSorting(int[] arr) {
        int len = arr.length;

        for (int i = 0; i < len - 1; i++) {
            // At some point when the array is completely sorted or initially sorted,
            // for the entire pass (iteration) if no swap has happened, it would mean that array is/has been already sorted
            // So the isSwapped flag is used to check that
            boolean isSwapped = false;
            for (int j = 0; j + 1 < len - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    isSwapped = true;
                    swap(arr, j, j+1);
                }
            }
            if (!isSwapped) break;
        }
        return arr;
    }
}
