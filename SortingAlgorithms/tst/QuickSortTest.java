package tst;

import org.junit.Test;
import src.QuickSort;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class QuickSortTest {
    @Test
    public void testQuickSorting() {
        // Arrange
        QuickSort o1 = new QuickSort();

        // Act
        int[] result1 = o1.quickSorting(new int[] { 64, 25, 12, 22, 11 });
        int[] result2 = o1.quickSorting(new int[] { 10, 14, 64, 25, 12, 11, 22 , 16, 15});

        // Assert
        assertEquals(Arrays.toString(new int[] { 11, 12, 22, 25, 64 }),
                Arrays.toString(result1));
        assertEquals(Arrays.toString(new int[] { 10, 11, 12, 14, 15, 16, 22, 25, 64 }),
                Arrays.toString(result2));
    }
}
