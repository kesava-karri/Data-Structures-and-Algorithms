package tst;

import org.junit.Ignore;
import org.junit.Test;

import org.junit.jupiter.api.Disabled;
import src.SlidingWindow;
import src.SlidingWindow.ContainsDuplicateIIIQ3;
import src.SlidingWindow.ContainsDuplicateIIQ2;
import src.SlidingWindow.ContainsDuplicateIQ1;
import src.SlidingWindow.FindAllAnagrams;
import src.SlidingWindow.LongestSubstringKRepeatingCharactersQ5;
import src.SlidingWindow.LongestSubstringWithoutRepeatingCharacters;
import src.SlidingWindow.MaxSumOfkConsecutive;
import src.SlidingWindow.SlidingWindowMaximumQ4;
import src.SlidingWindow.SubstringsOfSizeThreeWithDistinctCharacters;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SlidingWindowTest {
    // Please refrain from checking the outputs of a same class together since the classes are static and might result
    // in unexpected behavior
    SlidingWindow slidingWindow = new SlidingWindow();
    /* Constructor Injection */
    public SlidingWindowTest() {
    }

    @Test
    public void testLongestSubstringKRepeatingCharactersQ5() {
        LongestSubstringKRepeatingCharactersQ5 o1 = slidingWindow.new LongestSubstringKRepeatingCharactersQ5();
        System.out.println(o1.approach("aaabb", 3));

        LongestSubstringKRepeatingCharactersQ5 o2 = slidingWindow.new LongestSubstringKRepeatingCharactersQ5();
        System.out.println(o2.approach("ababacb", 3));
    }

    @Test
    public void testSlidingWindowMaximumQ4() {
        SlidingWindowMaximumQ4 o1 = slidingWindow.new SlidingWindowMaximumQ4();
        assertTrue(Arrays.equals(new int[] {3, 3, 5, 5, 6, 7}, o1.approach(new int[] { 1,3,-1,-3,5,3,6,7 }, 3)));

        SlidingWindowMaximumQ4 o2 = slidingWindow.new SlidingWindowMaximumQ4();
        assertTrue(Arrays.equals(new int[] { 1,-1 }, o2.approach(new int[] { 1,-1 }, 1)));
    }

    @Test
    public void testContainsDuplicateIIIQ3() {
//        ContainsDuplicateIIIQ3 o3 = slidingWindow.new ContainsDuplicateIIIQ3();
//        assertTrue(o3.approach1(new int[] {1,0,1,1}, 1, 2));
/*
        ContainsDuplicateIIIQ3 o2 = slidingWindow.new ContainsDuplicateIIIQ3();
        assertTrue(o2.approach1(new int[] {1,2,3,1}, 3, 0));
*/
        ContainsDuplicateIIIQ3 o1 = slidingWindow.new ContainsDuplicateIIIQ3();
        assertFalse(o1.approach1(new int[] {1,5,9,1,5,9}, 2, 3));
    }

    @Test
    @Ignore
    public void testContainsDuplicateIIQ2() {
        ContainsDuplicateIIQ2 o1 = slidingWindow.new ContainsDuplicateIIQ2();
        assertTrue(o1.approach(new int[] { 1, 2, 3, 1 }, 3));

        ContainsDuplicateIIQ2 o2 = slidingWindow.new ContainsDuplicateIIQ2();
        assertTrue(o2.approach(new int[] { 1,0,1,1 }, 1));

//        System.out.println(ContainsDuplicateIIQ2.approach(new int[] { 1,2,3,4,5,6,1 }, 3));
        ContainsDuplicateIIQ2 o3 = slidingWindow.new ContainsDuplicateIIQ2();
        assertFalse(o3.approach(new int[] { 1,2,3,4,5,1 }, 3));

        ContainsDuplicateIIQ2 o4 = slidingWindow.new ContainsDuplicateIIQ2();
//        System.out.println(ContainsDuplicateIIQ2.approach(new int[] { 1,2,3,1,2,3 }, 2));
        assertFalse(o4.approach(new int[] { 1,2,3,1,2,3 }, 2));

        ContainsDuplicateIIQ2 o5 = slidingWindow.new ContainsDuplicateIIQ2();
        assertTrue(o5.approach(new int[] { 99, 99 }, 2));
    }

    @Test
    public void testContainsDuplicate() {
        assertTrue(ContainsDuplicateIQ1.solution(new int[] { 1, 2, 3, 1 }));
        assertFalse(ContainsDuplicateIQ1.solution(new int[] { 1,2,3,4 }));
        assertTrue(ContainsDuplicateIQ1.solution(new int[] { 1,1,1,3,3,4,3,2,4,2 }));
    }

    @Test
    public void testFindAllAnagrams() {
        /*
        Having all outputs of FindAllAnagrams might result in unexpected result, since static fields are used which are class variables, so they get modified :)
         */

//        System.out.println(FindAllAnagrams.approach1("aaa", "aaaa"));
//        System.out.println(FindAllAnagrams.approach1("cbaebabacd", "abc"));
        System.out.println(FindAllAnagrams.approach1("abab", "ab"));
//        System.out.println(FindAllAnagrams.approach1("baa", "aa"));
    }

    @Test
    public void testLongestSubstringWithoutRepeatingCharacters() {
        System.out.println(LongestSubstringWithoutRepeatingCharacters.solution("abcabcbb"));
        /*
        System.out.println(LongestSubstringWithoutRepeatingCharacters.solution(" "));
        System.out.println(LongestSubstringWithoutRepeatingCharacters.solution("au"));
        System.out.println(LongestSubstringWithoutRepeatingCharacters.solution("aab"));
         */
    }

    @Test
    public void testSubstringsOfSizeThreeWithDistinctCharacters() {
//        System.out.println(SubstringsOfSizeThreeWithDistinctCharacters.solution("xyzzaz"));
        System.out.println(SubstringsOfSizeThreeWithDistinctCharacters.solution("aababcabc"));
    }

    @Test
    public void testThisMaxSumOfkConsecutive() {
        int result = MaxSumOfkConsecutive.solution(new int[] { 100, 200, 300, 400 }, 2);
        assertEquals(700, result);
    }
}
