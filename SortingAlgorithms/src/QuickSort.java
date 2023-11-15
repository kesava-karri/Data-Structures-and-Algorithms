package src;

import static util.MyUtilityClass.swap;

public class QuickSort {
    public int[] quickSorting(int[] arr) {
        // Choosing last element as our pivot ele
        // Please note that Quick Sort is used for smaller arrays
        int n = arr.length;
        // Once the pivot is set at its correct pos,
        // Arrange the left & right arrays of the pivot ele using divide & conquer
        divideAndPivot(arr, 0, n - 1);
        return arr;
    }

    private void divideAndPivot(int[] arr, int low, int high) {
        if (low > high) return;

        int pivotIdx = findPivotIdx(arr, low, high);
        divideAndPivot(arr, low, pivotIdx - 1); // left array
        divideAndPivot(arr, pivotIdx + 1, high); // right array
    }

    private static int findPivotIdx(int[] arr, int pos, int pivotIdx) {
        for (int i = pos; i <= arr.length - 1; i++) {
            if (arr[i] < arr[pivotIdx]) pos++;
        }
        swap(arr, pivotIdx, pos);
        return pos;
    }
}
