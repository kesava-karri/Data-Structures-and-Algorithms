package tst;

import org.junit.Test;
import src.BubbleSort;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class BubbleSortTest {
    @Test
    public void testBubbleSorting() {
        BubbleSort o1 = new BubbleSort();
        int[] result = o1.bubbleSorting(new int[] { 64, 25, 12, 22, 11 });
        assertEquals(Arrays.toString(new int[] { 11, 12, 22, 25, 64 }), Arrays.toString(result));
    }
    @Test
    public void testBubbleSortingPartiallySortedArray() {
        BubbleSort o1 = new BubbleSort();
        int[] result = o1.bubbleSorting(new int[] { 12, 11, 22, 25, 64 });
        assertEquals(Arrays.toString(new int[] { 11, 12, 22, 25, 64 }), Arrays.toString(result));
    }
}
