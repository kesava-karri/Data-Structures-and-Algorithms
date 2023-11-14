package src;

import java.util.Arrays;

public class MergeSort {
    public int[] mergeSorting(int[] arr) {
        divideAndMerge(arr, 0, arr.length - 1);
        return arr;
    }

    private void divideAndMerge(int[] arr, int start, int end) {
        // divide as in divide & conquer :)
        if (start >= end) return;

        int mid = (start + end) / 2;

        divideAndMerge(arr, start, mid);
        divideAndMerge(arr, mid + 1, end);
        merge(arr, start, mid, end);
        System.out.println(Arrays.toString(arr));
    }

    private void merge(int[] arr, int start, int mid, int end) {
        // conquer
        int[] temp = new int[arr.length];
        int i = start;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= end) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        // There's a chance when one of the sorted halves reaches its end
        // So we also check the arrays individually
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        while (j <= end) {
            temp[k++] = arr[j++];
        }

        k = 0;
        for (i = start; i <= end; i++) {
            arr[i] = temp[k++];
        }
    }
}
