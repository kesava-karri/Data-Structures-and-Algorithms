package test;

import org.junit.Test;

import src.SlidingWindow.FindAllAnagrams;
import src.SlidingWindow.LongestSubstringWithoutRepeatingCharacters;
import src.SlidingWindow.MaxSumOfkConsecutive;
import src.SlidingWindow.SubstringsOfSizeThreeWithDistinctCharacters;

import static org.junit.Assert.assertEquals;

public class SlidingWindowTest {
    // Please refrain from checking the outputs of a same class together since the classes are static and might result
    // in unexpected behavior

    /* Constructor Injection */
    public SlidingWindowTest() {
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
