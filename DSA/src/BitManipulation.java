package src;

import java.math.BigInteger;
import java.util.Arrays;


public class BitManipulation {
    public class MaxPossibleNumByBinaryConcatenation {
        public int maxGoodNumber(int[] nums) {
            // The length of nums is always 3
            // So the total permutations would be 3! = 6
            int result = -1;
            for (int i = 0; i < nums.length; i++) {
                for (int j = 0; j < nums.length; j++) {
                    if (j != i) {
                        for (int k = 0; k < nums.length; k++) {
                            if (k != j && k != i) {
                                StringBuilder temp = new StringBuilder();
                                temp.append(intToBinary(nums[i]));
                                temp.append(intToBinary(nums[j]));
                                temp.append(intToBinary(nums[k]));
                                result = Math.max(result, Integer.parseInt(temp.toString(), 2));
                            }
                        }
                    }
                }
            }
            return result;
        }
        private String intToBinary(int i) {
            return Integer.toBinaryString(i);
        }
    }

    class MissingNumber {
        public int missingNumber(int[] nums) {
            int n = nums.length, i = 0, ans = 0;
            for (i = 0; i < n; i++) {
                ans = ans ^ i ^ nums[i];
            }
            // when ans = 0 after iteration it implies that no number is missing
            // within the given range, so the only missing should be n;
            // or when some missing number exists then we xor with n
            // cancelling the n & to get that num :)
            return ans ^ n;
        }
    }

    public class ReverseBits {
        // you need treat n as an unsigned value
        public int reverseBits(int n) {
            int ans = 0;
            for (int i = 0; i < 32; i++) {
                // shift one bit to make space for new bit
                ans = ans << 1;
                // get the last bit from n;
                int temp = n & 1;
                // the new bit has zero & or operation with anything from the last bit of n would result in that bit and also kind of replacing the last bit
                ans = ans | temp;
                // unsigned right shift to ignore the value that has been used
                n = n >>> 1;
            }
            return ans;
        }
    }

    public class NumberOf1Bits {
        // you need to treat n as an unsigned value
        public int hammingWeight(int n) {
            int ans = 0;
            while (n != 0) {
                // get last bit, all other bits would become zeroes
                if ((n & 1) == 1) ans++;
                // unsigned right shift by 1 bit
                n = n >>> 1;
            }
            return ans;
        }
    }

    class PowerOfII {
        public boolean isPowerOfTwo(int n) {
            if (n <= 0) return false;
            int temp = n & n - 1;
            return temp == 0;
        }
    }

    class SingleNumberIII {
        public int[] singleNumber(int[] nums) {
            int n = nums.length;
            if (n == 2) return nums;

            int a = 0;
            for (int num : nums) {
                a ^= num;
            }

            // find the position of ith bit where those 2 numbers have set & unset bit
            a &= -a;

            // Since we know the ith bit, we can divide those 2 single occuring numbers into 2 groups and xor
            int ans1 = 0, ans2 = 0;
            for (int num : nums) {
                if ((a & num) == 0) ans1 ^= num;
                else {
                    ans2 ^= num;
                }
            }
            return new int[] { ans1, ans2 };
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
