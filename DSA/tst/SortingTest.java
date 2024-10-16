package tst;

import org.junit.Test;
import src.Sorting;
import src.Sorting.InversionCount;
import src.Sorting.MergeIntervals;
import src.Sorting.SortColors;
import src.Sorting.TopKFrequentWords;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SortingTest {
    Sorting obj = new Sorting();

    @Test
    public void testTopKFrequentWords() {
        // Arrange
        TopKFrequentWords o = obj.new TopKFrequentWords();
        String[] words0 = new String[]{"i","love","leetcode","i","love","coding"};
        int k0 = 2;
        String[] words1 = new String[]{"the","day","is","sunny","the","the","the","sunny","is","is"};
        int k1 = 4;
        List<String> expected0 = new ArrayList<> (Arrays.asList("i", "love"));
        String[] expected1 = new String[]{"the", "is", "sunny", "day"};
        // Act
        List<String> result0 = o.topKFrequent(words0, k0);
        List<String> result1 = o.topKFrequent(words1, k1);
        // Assert
        assertEquals(expected0.toString(), result0.toString());
        assertEquals(Arrays.toString(expected1), result1.toString());
    }
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
