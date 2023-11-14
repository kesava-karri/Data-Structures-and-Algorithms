package src;

public class InsertionSort {
    public int[] insertionSorting(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int ele = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > ele) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = ele;
        }
        return arr;
    }
}
