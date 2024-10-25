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
    public class FindMinimumPathSum {
        public int minPathSum(int[][] grid) {
            int rows = grid.length, cols = grid[0].length;
            int[][] dp = new int[rows][cols];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    int currentGrid = grid[i][j];
                    int leftDP = j - 1 < 0 ? 0 : dp[i][j - 1];
                    int topDP = i - 1 < 0 ? 0 : dp[i-1][j];
                    int addOn;
                    if (i - 1 < 0 || j - 1 < 0) {
                        addOn = Math.max(leftDP, topDP);
                    } else {
                        addOn = Math.min(leftDP, topDP);
                    }
                    dp[i][j] = currentGrid + addOn;
                }
            }
            return dp[rows - 1][cols - 1];
        }
    }

    public class FindMaximumPathSum {
        public int maxPathSum(int[][] grid) {
        /*
            - Movement is limited to up or right
            Input:
            [[0,0,0,0,5]]
            [[0,1,1,1,0]]
            [[2,0,0,0,0]]

            Output:
            10
         */
            int rows = grid.length, cols = grid[0].length;
            int[][] dp = new int[rows][cols];
            for (int i = rows - 1; i >=0; i--) {
                for (int j = 0; j < cols; j++) {
                    // Assign current grid value
                    // then add prev dp value based on the curr position
                    int currentGrid = grid[i][j];
                    int leftDP = j - 1 < 0 ? 0 : dp[i][j - 1];
                    int bottomDP = i + 1 >= rows ? 0 : dp[i + 1][j];
                    dp[i][j] = Math.max(currentGrid + leftDP, currentGrid + bottomDP);

                }
            }
            // Since we're storing the max value at the destination
            return dp[0][cols - 1];
        }
    }

    public class HouseRobber {
        int[][] dp = new int[101][2];
        public int rob(int[] nums) {
            for (int i = 0; i < nums.length; i++) {
                Arrays.fill(dp[i], -1);
            }
            int isRobbed = 0;
            return f(nums, 0, isRobbed);
        }

        public int f(int[] nums, int currIndex, int isRobbed) {
            if (currIndex == nums.length) return 0;
            if (dp[currIndex][isRobbed] != -1) return dp[currIndex][isRobbed];

            int ans = 0;

            if (isRobbed == 1) {
                ans = f(nums, currIndex + 1, 0);
            } else {
                ans = Math.max(f(nums, currIndex + 1, 0), nums[currIndex] + f(nums, currIndex + 1, 1));
            }
            dp[currIndex][isRobbed] = ans;
            return ans;
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
