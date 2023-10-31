package src;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

import util.MyUtilityClass.ListNode;
import util.MyUtilityClass;

import static util.MyUtilityClass.printLinkedList;

public class RecursionAndStacks {

    public class SwapNodesInPairs {
        public ListNode swapPairs(ListNode head) {
            // i/p: 1 -> 2 -> 3 -> 4 -> 5 -> 6
            // o/p: 2 -> 1 -> 4 -> 3 -> 6 -> 5
            if (head == null || head.next == null) return head;
            ListNode dummy = head.next;
            ListNode prev = new ListNode(-1, head);
            ListNode curr = head;
            ListNode nextNode = curr.next;
            f(prev, curr, nextNode);
            return dummy;
        }

        public void f(ListNode prev, ListNode curr, ListNode next) {
            if (curr == null || next == null) return;
            ListNode temp = next.next;
            next.next = curr;
            curr.next = temp;
            prev.next = next;
            prev = curr;
            curr = temp;
            if (temp != null) {
                next = temp.next;
            }
            f(prev, curr, next);
        }
    }

    public class MinNonZeroProduct {
        public long givenMod = 1_000_000_007;
        public int solution(int p) {
            // To represent 2^p we need p number of digits in base 2 :)
            // conclusion: After doing the math on paper, looks like we need to make one of the 2 numbers to 1 to get the min. product.
            // And since they could be turned into pairs of 1 & corresponding value 1 less than 2^p - 1.

            // Eg: when p = 4 => return 15 * (1 * 14)^7
            // 7 is 14/2 number of pairs of 1 & 14

            long end = (long)Math.pow(2, p) - 1;
            long temp = end - 1;
            long pairedNum = pow(temp, temp/2);
            return (int)((end % givenMod) * pairedNum % givenMod);
        }

        public long pow(long a, long i) {
            if (i == 0) return 1;

            long newVal = ((a % givenMod) * (a % givenMod)) % givenMod;
            if (i % 2 == 0) {
                return pow(newVal, i/2) % givenMod;
            } else {
                return ((pow(newVal, i/2) % givenMod) * (a % givenMod)) % givenMod;
            }

        }
    }

    public class myPow {
        public double solution(double x, int n) {
            // When negative powers exist, reciprocate the x
            if (n < 0) {
                x = 1 / x;
                n = -n;
            }
            return pow(x, n);
        }
        public double pow(double x, int n) {
            if (n == 0) return 1;

            double temp = pow(x, n/2);
            if (n % 2 == 0) {
                return temp * temp;
            } else {
                return x * temp * temp;
            }
        }

        public double brokenApproach(double x, int n) {
            return pow1(x, n);
        }
        public double pow1(double x, int n) {
            if (n == 0) return 1;
            if (n % 2 == 0) {
                double temp = pow1(x, n/2);
                return temp * temp;
            } else {
                return x * pow1(x, n - 1); // Throws StackOverflow error here
            }
        }

        public double approach(double x, int n) {
            return Math.pow(x, n);
        }
    }

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

        public boolean solution(int n) {
            // Follow-up: No loop/recursion
            // Note that all powers of 2 would have only 1 bit as 1 in the binary representation
            // and the rest are zeros

            // Using Brian Kernighan’s Algorithm
            if (n <= 0) return false;
            int temp = n & n -1;
            return temp == 0;
        }

        public boolean altApproach(int n) {
            /*
            Time complexity: O(logn) - since we'll only loop over 32 bits, the for loop runs for constant time
            and the log n comes from Integer.toBinaryString(n);
            Space complexity: O(1)
             */
            if (n < 0) return false;

            String binaryString = Integer.toBinaryString(n);
            int numOfOnes = 0;

            // Since n is int, it could only have atmost 32 bits, so constant time.
            for (int i = 0; i < binaryString.length(); i++) {
                if (binaryString.charAt(i) == '1') {
                    numOfOnes += 1;
                    if (numOfOnes > 1) return false;
                }
            }
            return numOfOnes == 1;
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

    public class NearestSmallestElementOnLeft {
        public List<Integer> solution(int[] nums) {
            // nums = [1, 6, 4, 10, 2, 5]
            // ans  = [-1, 1, 1, 4, 1, 2]
            Stack<Integer> stack = new Stack<>();

            ArrayList<Integer> arr = new ArrayList<>();
            arr.add(-1); // since the first element has no elements to its left
            stack.push(nums[0]); // pushing the first element since no element its left

            for (int i = 1; i < nums.length; i++) {
                while (!stack.empty() && stack.peek() >= nums[i]) {
                    stack.pop();
                }
                if (stack.empty()) arr.add(-1);
                else arr.add(stack.peek());
                stack.push(nums[i]);
//                printStack(stack);
            }

            return arr;
        }
    }

    public class NearestSmallestElementOnRight {
        public List<Integer> solution(int[] nums) {
            Stack<Integer> stack = new Stack<>();
            int n = nums.length;
            int[] ans = new int[n];
            // since right most element wouldn't have anything on it's right
            ans[n - 1] = -1;
            stack.push(nums[n - 1]);

            for (int i = n - 2; i >=0; i--) {
                while (!stack.empty() && nums[i] < stack.peek()) {
                    stack.pop();
                }
                if (stack.empty()) ans[i] = -1;
                else ans[i] = stack.peek();
                stack.push(nums[i]);
//                printStack(stack);
            }

            return Arrays.stream(ans).boxed().collect(Collectors.toList());
        }
    }

    public class LargestRectangleInHistogram {
        public int solution(int[] heights) {
            Stack<Integer> stack = new Stack<>();
            int len = heights.length;
            if (len == 1) return heights[0];
            int[] smallestOnLeft = new int[len];

            // Smallest to figure out the max our current rectangle could stretch upto
            smallestOnLeft[0] = -1;
            stack.push(0);
            // Finding nearest smallest on the left
            for (int i = 1; i < len; i++) {
                while (!stack.empty() && heights[i] <= heights[stack.peek()]) {
                    stack.pop();
                }
                if (stack.empty()) smallestOnLeft[i] = -1;
                else smallestOnLeft[i] = stack.peek();
                stack.push(i);
            }

            stack.clear();
            // Finding nearest smallest on the right
            int[] smallestOnRight = new int[len];
            smallestOnRight[len - 1] = len; // len + 1 for easy calculation of width
            stack.push(len - 1);

            for (int i = len - 2; i >= 0; i--) {
                while (!stack.empty() && heights[i] <= heights[stack.peek()]) {
                    stack.pop();
                }
                if (stack.empty()) smallestOnRight[i] = len;
                else smallestOnRight[i] = stack.peek();
                stack.push(i);
            }

            int ans = 0;
            int area = 0;
            for (int i = 0; i < len; i++) {
                area = heights[i] * (smallestOnRight[i] - smallestOnLeft[i] - 1);
                ans = area > ans ? area : ans;
            }
            return ans;
        }

        public int brokenApproach(int[] heights) {
            Stack<Integer> stack = new Stack<>();
            int len = heights.length;
            if (len == 1) return heights[0];
            int[] smallestOnLeft = new int[len];

            smallestOnLeft[0] = -1;
            stack.push(heights[0]);
            // Finding nearest smallest on the left
            for (int i = 1; i < len; i++) {
                while (!stack.empty() && heights[i] < stack.peek()) {
                    stack.pop();
                }
                if (stack.empty()) smallestOnLeft[i] = -1;
                else smallestOnLeft[i] = stack.peek();
                stack.push(heights[i]);
            }

            stack.clear();
            // Finding nearest smallest on the right
            int[] smallestOnRight = new int[len];
            smallestOnRight[len - 1] = -1;
            stack.push(heights[len - 1]);

            for (int i = len - 2; i >= 0; i--) {
                while (!stack.empty() && heights[i] < stack.peek()) {
                    stack.pop();
                }
                if (stack.empty()) smallestOnRight[i] = -1;
                else smallestOnRight[i] = stack.peek();
                stack.push(heights[i]);
            }

            int ans = 0;
            int area = 0;
            for (int i = 0; i < len; i++) {
                area = Math.max(smallestOnLeft[i], smallestOnRight[i]) * 2;
                // This below here, is incorrect, there's a need to store the indices as well which would help to find the actual width :)
                // times 2 cause the width of each histogram is 1 unit and the histogram we take is nearest smallest element to form proper rectanlge width max area.
                ans = area > ans ? area : ans;
            }
            return ans;
        }
    }

    public class NearestLargestElementOnLeft {
        public List<Integer> solution(int[] nums) {
            Stack<Integer> stack = new Stack<>();
            int[] ans = new int[nums.length];
            ans[0] = -1;
            stack.push(nums[0]);
            for (int i = 1; i < nums.length; i++) {
                while (!stack.empty() && nums[i] > stack.peek()) {
                    stack.pop();
                }
                if (stack.empty()) ans[i] = -1;
                else ans[i] = stack.peek();
                stack.push(nums[i]);
            }
            return Arrays.stream(ans).boxed().collect(Collectors.toList());
        }
    }

    // Helper methods
    public void printStack(Stack<Integer> s) {
        System.out.print("------stack start ------\n");
        printStackRecursion(s);
        System.out.print("------stack end ------\n\n");
    }

    private void printStackRecursion(Stack<Integer> s) {
        if (s.empty()) return;
        int x = s.peek();
        s.pop();
        System.out.println(x);
        printStackRecursion(s);
        s.push(x);
    }
}