package tst;

import org.junit.Test;
import src.Hashing;
import src.Hashing.LargestSubArrayWSumZero;

import static org.junit.Assert.assertEquals;

public class HashingTest {
    Hashing obj = new Hashing();
    @Test
    public void testLargestSubArrayWSumZero() {
        LargestSubArrayWSumZero o1 = obj.new LargestSubArrayWSumZero();
        assertEquals(5, o1.maxLen(new int[] {15,-2,2,-8,1,7,10,23}, 8));
    }
}
