package tst;

import org.junit.Test;
import src.BitManipulation;
import src.BitManipulation.AddBinary;
import src.BitManipulation.MaxPossibleNumByBinaryConcatenation;

import java.lang.reflect.Array;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class BitManipulationTest {
    BitManipulation obj = new BitManipulation();
    @Test
    public void testMaxPossibleNumByBinaryConcatenation() {
        // Arrange
        int[] nums = new int[]{1, 2, 3};
        int[] nums2 = new int[]{2, 8, 16};
        int[] nums3 = new int[]{1, 18, 27};

        // Act
        MaxPossibleNumByBinaryConcatenation o = obj.new MaxPossibleNumByBinaryConcatenation();
        int result = o.maxGoodNumber(nums);
        int result2 = o.maxGoodNumber(nums2);
        int result3 = o.maxGoodNumber(nums3);

        // Assert
        assertEquals(30, result);
        assertEquals(1296, result2);
        assertEquals(1906, result3);
    }

    @Test
    public void testAddBinary() {
        // Arrange
        String a = "10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101";
        String b = "110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011";
        String sum = "110111101100010011000101110110100000011101000101011001000011011000001100011110011010010011000000000";

        // Act
        AddBinary o1 = obj.new AddBinary();
        String result = o1.addBinaryUsingBuiltIn(a, b);

        // Assert
        assertEquals(sum, result);
    }
}
