package tst;

import org.junit.Test;
import src.MergeSort;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class MergeSortTest {
    @Test
    public void testMergeSorting() {
        MergeSort o1 = new MergeSort();
        int[] result = o1.mergeSorting(new int[] { 64, 25, 12, 22, 11 });
        assertEquals(Arrays.toString(new int[] { 11, 12, 22, 25, 64 }), Arrays.toString(result));
    }
}
