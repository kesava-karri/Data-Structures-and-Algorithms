package tst;

import org.junit.Test;
import src.Sorting;
import src.Sorting.MergeIntervals;
import src.Sorting.SortColors;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class SortingTest {
    Sorting obj = new Sorting();

    @Test
    public void testMergeIntervals() {
        MergeIntervals o1 = obj.new MergeIntervals();
        int[][] result = o1.merge(new int[][] {{1,6},{5,8}});
        assertEquals(Arrays.deepToString(new int[][] {{1,8}}), Arrays.deepToString(result));
    }

    @Test
    public void testSortColors() {
        SortColors o1 = obj.new SortColors();
        int[] nums = new int[] {2, 1, 2};
        o1.sortColors(nums);
        assertEquals(Arrays.toString(new int[] {1, 2, 2}), Arrays.toString(nums));
    }
//    SortColors
//    [2,1,2]
//    Expected: [1,2,2]


//    MergeIntervals
//    [[1,6],[5,8]]
//    Expected [[1,8]]
}
