package tst;

import org.junit.Test;
import src.SelectionSort;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class SelectionSortTest {
    @Test
    public void testSelectionSorting() {
        SelectionSort obj = new SelectionSort();
        int[] result = obj.selectionSorting(new int[] { 64, 25, 12, 22, 11 });
        assertEquals(Arrays.toString(new int[] { 11, 12, 22, 25, 64 }), Arrays.toString(result));
    }
}
