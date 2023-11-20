package tst;

import org.junit.Test;
import src.Sorting;
import src.Sorting.InversionCount;
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

    @Test
    public void testInversionCount() {
        InversionCount o1 = obj.new InversionCount();
        long[] nums = new long[] {2, 4, 1, 3, 5};

        assertEquals(3, o1.inversionCount(nums, nums.length));
    }
}
