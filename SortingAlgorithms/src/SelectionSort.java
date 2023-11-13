package src;

import util.MyUtilityClass;

public class SelectionSort {
    public int[] selectionSorting(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            int min_index = i;
            for (int j = i + 1; j < len; j++) {
                if (arr[j] < arr[min_index]) min_index = j;
            }
            MyUtilityClass.swap(arr, i, min_index);
        }
        return arr;
    }
}
