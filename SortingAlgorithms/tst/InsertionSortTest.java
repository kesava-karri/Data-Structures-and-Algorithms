package tst;

import org.junit.Test;
import src.InsertionSort;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class InsertionSortTest {
    @Test
    public void testInsertionSorting() {
        InsertionSort o1 = new InsertionSort();
        int[] result = o1.insertionSorting(new int[] { 64, 25, 12, 22, 11 });
        assertEquals(Arrays.toString(new int[] { 11, 12, 22, 25, 64 }), Arrays.toString(result));
    }
}
