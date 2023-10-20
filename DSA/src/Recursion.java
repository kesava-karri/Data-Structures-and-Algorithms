package src;

import java.math.BigInteger;
import java.util.Arrays;

public class Recursion {
    public class Factorial {
        public int solution(int n) {
            return factorial(n);
        }

        public int factorial(int n) {
            if (n <= 1) return 1;
            return n * factorial(n - 1);
        }
    }

    public class ValidPalindrome {
        public boolean isPalindrome(String s) {
            // Removing non-alphanumeric values
            s = s.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");
            int i = 0, j = s.length() - 1;
            return recursion(s, i, j);
        }

        public boolean recursion(String str, int i, int j) {
            if (i >= j) return true;
            return str.charAt(i) == str.charAt(j) && recursion(str, i + 1, j - 1);
        }
    }

    /**
     public class Palindrome {
     private final String str;

     public Palindrome(String str) {
     this.str = str;
     }

     public boolean solution(int i , int j) {
     if (i >= j) return true;
     return str.charAt(i) == str.charAt(j) && solution(i + 1, j - 1);
     }

     public boolean checkIfPalindrome(String str, int i, int j) {
     return false;
     }
     }*/

    public class ReverseAString {
        public String solution(String str) {
            int i = str.length() - 1;
            String ans = "";
            return reverseString(str, ans, i);
        }

        public String reverseString(String str, String ans, int i) {
            if (i < 0) return ans;
            String tempStr = String.valueOf(str.charAt(i));
            return reverseString(str, ans.concat(tempStr), --i);
        }
    }

    class ReverseString {
        public void approach1(char[] s) {
            recursion(s, 0, s.length - 1);
        }

        private void recursion(char[] s, int i, int j) {
            if (i >= j) return;
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            recursion(s, i+1, j-1);
        }
    }

    class PowerOfTwo {
        public boolean isPowerOfTwo(int n) {
            return divideByTwo(n);
        }

        private boolean divideByTwo(int i) {
            if (i == 0) return false;
            if (i == 1) return true;
            return i % 2 == 0 && divideByTwo(i / 2);
        }
    }

    public class CountGoodNumbers {
        public long givenMod = 1000000007;
        public int countGoodNumbers(long n) {
            long numOfEvenIndices = n % 2 == 0 ? n / 2 : n / 2 + 1;
            long numOfOddIndices = n / 2;
            return (int) ((f(5, numOfEvenIndices) % givenMod * f(4, numOfOddIndices) % givenMod) % givenMod);
        }

        public long f(long a, long i) {
            if (i == 0) return 1;
            if (i % 2 == 0) {
                long temp = f(a, i / 2);
                return (temp * temp) % givenMod;
            } else {
                return (a * f(a, i - 1)) % givenMod;
            }
        }
    }
}