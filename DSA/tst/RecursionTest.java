package tst;

import org.junit.Test;
import src.Recursion;
import src.Recursion.CountGoodNumbers;
import src.Recursion.Factorial;
import src.Recursion.ReverseAString;
import src.Recursion.ValidPalindrome;

import java.math.BigInteger;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class RecursionTest {
    Recursion recursionObj = new Recursion();

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
