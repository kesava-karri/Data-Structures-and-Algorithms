package tst;

import org.junit.Test;
import src.RecursionAndStacks;
import src.RecursionAndStacks.CountGoodNumbers;
import src.RecursionAndStacks.Factorial;
import src.RecursionAndStacks.LargestRectangleInHistogram;
import src.RecursionAndStacks.NearestLargestElementOnLeft;
import src.RecursionAndStacks.NearestSmallestElementOnLeft;
import src.RecursionAndStacks.NearestSmallestElementOnRight;
import src.RecursionAndStacks.ReverseAString;
import src.RecursionAndStacks.ValidPalindrome;
import util.MyUtilityClass;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class RecursionAndStacksTest {
    RecursionAndStacks recursionObj = new RecursionAndStacks();

    @Test
    public void testMinNonZeroProduct() {
        System.out.println(MyUtilityClass.productOfInclusiveRange(2, 6));
        MyUtilityClass.printBinaryRepresentation(4);
    }

    @Test
    public void testNearestLargestElementOnLeft() {
        NearestLargestElementOnLeft o1 = recursionObj.new NearestLargestElementOnLeft();
        System.out.println(o1.solution(new int[] {1, 6, 4, 10, 2, 5}));
    }
    @Test
    public void testLargestRectangleInHistogram() {
        LargestRectangleInHistogram o1 = recursionObj.new LargestRectangleInHistogram();
        o1.brokenApproach(new int[] {0, 9}); // Expected: 9, Output: 0;
    }

    @Test
    public void testNearestSmallestElementOnRight() {
        NearestSmallestElementOnRight o1 = recursionObj.new NearestSmallestElementOnRight();
        System.out.println(o1.solution(new int[] {1, 6, 4, 10, 2, 5}));
    }

    @Test
    public void testNearestSmallestElementOnLeft() {
        NearestSmallestElementOnLeft o1 = recursionObj.new NearestSmallestElementOnLeft();
        assertEquals(Arrays.asList(-1, 1, 1, 4, 1, 2), o1.solution(new int[] {1, 6, 4, 10, 2, 5}));
        assertEquals(Arrays.asList(-1, -1,-1,-1,-1,-1,-1), o1.solution(new int[] {19, 19, 19, 19, 19, 19, 19}));
    }

    @Test
    public void testCountGoodNumbers() {
        CountGoodNumbers o1 = recursionObj.new CountGoodNumbers();
        System.out.println(o1.countGoodNumbers(50));
//        System.out.println(o1.countGoodNumbers(BigInteger.valueOf((BigInteger) 806166225460393)));
    }
    @Test
    public void testReverseAString() {
        String str = "Keshav";
        ReverseAString o1 = recursionObj.new ReverseAString();
        assertEquals("vahseK", o1.solution(str));
    }

    @Test
    public void testPalindrome() {
        String oddLengthStr = "ABCABACBA";
        String oddLengthStrNonP = "ABC";
        String evenLengthStr = "ABCAACBA";
        String evenLengthStrNonP = "race a car";
        String s = "A man, a plan, a canal: Panama";
        String singleSpace = " ";



        ValidPalindrome o1 = recursionObj.new ValidPalindrome();
        assertTrue(o1.isPalindrome(s));
        assertTrue(o1.isPalindrome(singleSpace));

        assertTrue(o1.isPalindrome(oddLengthStr));
        assertTrue(o1.isPalindrome(evenLengthStr));
        assertFalse(o1.isPalindrome(oddLengthStrNonP));
        assertFalse(o1.isPalindrome(evenLengthStrNonP));
    }
    /**@Test
    public void testPalindrome() {
        String str = "ABCABACBA";
        Palindrome o1 = recursionObj.new Palindrome(str);
        int i = 0, j = str.length() - 1;
        assertTrue(o1.solution(i, j));
    }*/

    @Test
    public void testFactorial() {
        Factorial o1 = recursionObj.new Factorial();
        assertEquals(120, o1.solution(5));
        assertEquals(720, o1.solution(6));
    }
}
