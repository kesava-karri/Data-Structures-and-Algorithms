package src;

import util.MyUtilityClass;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Hashtable;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DynamicProgramming {
    int[][] dp = new int[101][2];
    public class HouseRobber {
        public int solution(int[] nums) {
            for (int[] row : dp) {
                Arrays.fill(row, -1);
            }
            MyUtilityClass.print2DArray(dp);
            return - 1;
        }
    }

    public class FibonacciSeries {
        Hashtable<Integer, Integer> dp = new Hashtable<>();
        List<Integer> dpArr;
        public int dpAlt(int n) {
            dpArr = new ArrayList<Integer>(Collections.nCopies(n + 1, -1));
            return f(n);
        }
        private int f(int n) {
            if (n == 0) return 0;
            if (n == 1) return 1;
            if (dpArr.get(n) != -1) return dpArr.get(n);
            int res = f(n - 1) + f(n - 2);
            dpArr.add(n, res);
            return res;
        }

        public int dp(int n) {
            return fib(n);
        }
        private int fib(int n) {
            if (n == 0) return 0;
            if (n == 1) return 1;
            if (dp.containsKey(n)) return dp.get(n);
            int res = fib(n - 1) + fib(n - 2);
            dp.put(n, res);
            return res;
        }

        public int recursiveApproach(int n) {
            if (n == 0) return 0;
            if (n == 1) return 1;
            return recursiveApproach(n - 1) + recursiveApproach(n - 2);
        }
        public int recursiveAltApproach(int n) {
            if (n == 0) return 0;
            if (n == 1) return 1;
            int count = 0;
            int first = 0;
            count++;
            int second = 1;
            count++;
            System.out.print(first +" ");
            System.out.print(second +" ");

            return recursionUsingCounter(first, second, n, count);
        }
        private int recursionUsingCounter(int first, int second, int n, int count) {
            int newNum = first + second;
            if (count == n) return newNum;
            System.out.print(newNum +" ");

            first = second;
            second = newNum;
            return recursionUsingCounter(first, second, n, ++count);
        }

        public int iterativeApproach(int n) {
            int first = 0;
            int second = 1;
            int newNum = 0;
            System.out.print(first +" ");
            System.out.print(second +" ");
            for (int i = 2; i < n; i++) {
                newNum = first + second;
                System.out.print(newNum +" ");
                first = second;
                second = newNum;
            }
            return newNum;
        }
    }

    public class ClimbStairs {
        public int dpBottomUp(int n) {
            // Bottom Up approach
            int[] dpArr = new int[n+1];
            Arrays.fill(dpArr, -1);
            int count = 1;
            int ans = 1;
            return recursionBU(n, count, dpArr, ans);
        }
        private int recursionBU(int n, int count, int[] dpArr, int ans) {
            if (count >= n) return ans;
            if (n == 2) return 2;
            if (n == 1) return 1;
            if (dpArr[count] != -1) return dpArr[count];
            ans = recursionBU(n, count+1, dpArr, ans) + recursionBU(n, count+2, dpArr, ans);
            dpArr[count] = ans;
            return ans;
        }

        public int dpTopDown(int n) {
            // Top-down approach
            int[] dp = new int[n + 1];
            // size can also be n, but for better readability in storing the values the size is chosen n+1
            Arrays.fill(dp, -1);
            return recursionTD(n, dp);
        }
        public int recursionTD(int n, int[] dp) {
            if (n == 2) return 2; // since 2 ways of climbing 2 steps
            if (n == 1) return 1;
            if (dp[n] != -1) return dp[n];
            int ans = recursionTD(n - 1, dp) + recursionTD(n - 2, dp);
            dp[n] = ans;
            return ans;
        }
    }
}
