package tst;

//import src.Arrays_.SecondSmallestNumber;

import org.junit.Test;
import src.Arrays_;
import src.Arrays_.SecondSmallestNumber;

import static org.junit.Assert.assertEquals;

public class ArraysTest_ {
    Arrays_ obj = new Arrays_();

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
