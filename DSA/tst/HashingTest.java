package tst;

import org.junit.Test;
import src.Hashing;
import src.Hashing.ConsecutiveArrayEle;
import src.Hashing.FirstUniqueCharacterInAString;
import src.Hashing.LargestSubArrayWSumZero;
import src.Hashing.MaxPointsOnALine;
import src.Hashing.WordLadder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class HashingTest {
    Hashing obj = new Hashing();

    @Test
    public void testFirstUniqueCharacterInAString() {
        // Arrange
        FirstUniqueCharacterInAString o = obj.new FirstUniqueCharacterInAString();
        String s0 = "leetcode";
        String s1 = "aabb";

        // Act
        int result0 = o.firstUniqChar(s0);
        int result1 = o.firstUniqChar(s1);

        // Assert
        assertEquals(0, result0);
        assertEquals(-1, result1);
    }
    @Test
    public void testWordLadder() {
        WordLadder o1 =obj.new WordLadder();
        List<String> words = new ArrayList(Arrays.asList("ce", "mo", "ko", "me", "co"));
        assertEquals(4, o1.ladderLength("be", "ko", words));
    }

    @Test
    public void testMaxPointsOnALine() {
        MaxPointsOnALine o1 = obj.new MaxPointsOnALine();

        assertEquals(4, o1.maxPoints(new int[][] {{1,1},{3,2},{5,3},{4,1},{2,3},{1,4}}));
        assertEquals(3, o1.maxPoints(new int[][] {{1,1},{2,2},{3,3}}));
    }

    @Test
    public void testConsectuiveArrayEle() {
        ConsecutiveArrayEle o1 = obj.new ConsecutiveArrayEle();

        // case: single element
        assertTrue(o1.areConsecutives(new long[] {54}, 1));

        // case: all equal
        assertFalse(o1.areConsecutives(new long[] {2, 2, 2}, 3));

        // sample case
        assertTrue(o1.areConsecutives(new long[] {5, 4, 2, 1, 3}, 5));
    }
    @Test
    public void testLargestSubArrayWSumZero() {
        LargestSubArrayWSumZero o1 = obj.new LargestSubArrayWSumZero();
        assertEquals(5, o1.maxLen(new int[] {15,-2,2,-8,1,7,10,23}, 8));
    }
}
