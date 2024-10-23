package tst;

import org.junit.Test;
import src.Arrays_;
import src.Arrays_.IntersectionOfTwoArraysIIQ9;
import src.Arrays_.SecondSmallestNumber;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class ArraysTest_ {
    Arrays_ obj = new Arrays_();

    @Test
    public void testIntersectionOfTwoArraysIIQ9() {
        // Arrange
        int[] nums1 = new int[] {4,9,5};
        int[] nums2 = new int[] {9,4,9,8,4};
        // Act
        IntersectionOfTwoArraysIIQ9 o = obj.new IntersectionOfTwoArraysIIQ9();
        int[] result = o.intersect(nums1, nums2);

        // For comparison, we're sorting the result
        // as it can be of any order
        Arrays.sort(result);
        // Assert
        assertEquals(Arrays.toString(new int[] {4, 9}), Arrays.toString(result));
    }

    @Test
    public void testSecondSmallestNumber() {
        // Arrange
        int[] arr = new int[] {2, 4, 3, 5, 6};
        int[] arr1 = new int[] {1, 1, 1};
        // Act
        SecondSmallestNumber o = obj.new SecondSmallestNumber();
        // Assert
        assertEquals(3, o.secondSmallestNum(arr));
        assertEquals(-1, o.secondSmallestNum(arr1));
    }
}
