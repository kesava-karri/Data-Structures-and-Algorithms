package src;

import java.math.BigInteger;


public class BitManipulation {
    class PowerOfII {
        public boolean isPowerOfTwo(int n) {
            if (n <= 0) return false;
            int temp = n & n - 1;
            return temp == 0;
        }
    }



    class SingleNumberII {
        public int singleNumber(int[] nums) {
            int a, b;
            a = b = 0;
            int temp = a;
            for (int c : nums) {
                a = (a & ~b & ~c) | (~a & b & c);
                b = (~temp & b & ~c) | (~temp & ~b & c); // use temp since a is over-written
                temp = a; // update temp for next calculation of b
            }
            return a | b;
        }
    }

    class SingleNumber {
        public int singleNumber(int[] nums) {
            int ans = 0; // since 0 ^ a = a
            for (int i = 0; i < nums.length; i++) {
                ans ^= nums[i];
            }
            return ans;
        }
    }

    public class AddBinary {
        public String addBinary(String a, String b) {
            StringBuilder ans = new StringBuilder();
            int carry = 0;

            // Append 0s to make the lengths of strings equal
            int maxLength = Math.max(a.length(), b.length());
            while (a.length() < maxLength) {
                a = "0" + a;
            }
            while (b.length() < maxLength) {
                b = "0" + b;
            }

            // Full adder in circuits approach
            for (int i = maxLength - 1; i >= 0; i--) {
                int bitA = a.charAt(i) - '0';
                int bitB = b.charAt(i) - '0';

                // sum of full adder
                int sum = bitA ^ bitB ^ carry;
                // carry of full adder
                carry = (bitA & bitB) | ((bitA ^ bitB) & carry);

                // Append the current bit to the ans
                ans.insert(0, sum);
            }
            // If there's a carry left, append it to the ans
            if (carry > 0) {
                ans.insert(0, carry);
            }

            return ans.toString();
        }

        public String addBinaryAltApproach(String a, String b) {
            StringBuilder ans = new StringBuilder();

            int len1 = a.length();
            int len2 = b.length();
            int i = len1 - 1;
            int j = len2 - 1;
            int sum = 0;
            int carry = 0;

            while (i >= 0 && j >= 0) {
                // sum is the XOR of 2 bits and the carry
                sum = carry ^ (a.charAt(i--) - '0') ^ (b.charAt(j--) - '0');
                // carry is 1 if at least two of the three bits are 1
                carry = (carry & ((a.charAt(i + 1) - '0') | (b.charAt(j + 1) - '0'))) | ((a.charAt(i + 1) - '0') & (b.charAt(j + 1) - '0'));
                ans.insert(0, sum);
            }

            while (i >= 0) {
                // sum is the XOR of the bit and the carry
                sum = carry ^ (a.charAt(i--) - '0');
                // carry is 1 if both bits are 1
                carry &= (a.charAt(i + 1) - '0');
                ans.insert(0, sum);
            }

            while (j >= 0) {
                // sum is the XOR of the bit and the carry
                sum = carry ^ (b.charAt(j--) - '0');
                // carry is 1 if both bits are 1
                carry &= (b.charAt(j + 1) - '0');
                ans.insert(0, sum);
            }

            // If there's a carry left, append it to the result
            if (carry > 0) {
                ans.insert(0, carry);
            }

            return ans.toString();
        }

        public String addBinaryUsingBuiltIn(String a, String b) {
            BigInteger x = new BigInteger(a, 2);
            BigInteger y = new BigInteger(b, 2);
            return x.add(y).toString(2);
        }
    }
}
