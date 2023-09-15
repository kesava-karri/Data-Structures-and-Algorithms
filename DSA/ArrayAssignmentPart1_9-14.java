import java.lang.Math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Set;

class RotateImageQ15 {
    static void approach1(int[][] matrix) {
        int len = matrix.length;

        // Transpose
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (i != j && i < j) { // to not double swap the condition i < j is added
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
        }

        // swap columns
        for (int i = 0; i < len; i++) {
            int j = 0;
            int k = len - 1;
            while (j < k) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][k];
                matrix[i][k] = temp;
                j++;
                k--;
            }
        }

        for (int[] subArray: matrix) {
            System.out.println(Arrays.toString(subArray));
        }
    }
}

class FourSumQ14 {
    static List<List<Integer>> approach1(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        int len = nums.length;
        Arrays.sort(nums); 

        for (int i = 0; i < len - 3; i++) {
            for (int j = i + 1; j < len - 2; j++) {
                int k = j + 1;
                int l = len - 1;

                while (k < l) {

                    long sum = (long) nums[i] + nums[j] + nums[k] + nums[l];
                    if (sum == target) {
                        List<Integer> tempArray = new ArrayList<>();
                        Collections.addAll(tempArray, nums[i], nums[j], nums[k], nums[l]);
                        set.add(tempArray);

                        while (k < l && nums[k] == nums[k + 1]) {
                            k++;
                        }

                        while (k < l && nums[l] == nums[l - 1]) {
                            l--;
                        }
                        k++;
                        l--;
                    } else if (sum > target) {
                        l--;
                    } else {
                        k++;
                    }
                }
            }
        }

        set.stream().forEach(subArray -> result.add(subArray));
        return result;
    }
}

class ThreeSumClosestQ13 {
    static int approach1(int[] nums, int target) {
        Arrays.sort(nums);
        int len = nums.length;
        // int min = 
        int result = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < len - 2; i++) {
            int j = i + 1;
            int k = len - 1;

            while(j < k) {
                int currentSum = nums[i] + nums[j] + nums[k];
                int absDiff = Math.abs(target - currentSum);

                if (absDiff < Math.abs(target - result)) {
                    result = currentSum;
                }

                if (currentSum < target) {
                    j++;
                } else {
                    k--;
                }
            }
        }

        return result;
    }

    static int brokenApproach(int[] nums, int target) {
        // Exceeds Time Limit
        List<Integer> sumArray = new ArrayList<>();
        int len = nums.length;
        for (int i = 0; i < len - 2; i++) {
            for (int j = i + 1; j < len - 1; j++) {
                for (int k = j + 1; k < len; k++) {
                    sumArray.add(nums[i] + nums[j] + nums[k]);
                }
            }
        }
        System.out.println(sumArray);
        int min = Integer.MAX_VALUE;
        int result = Integer.MAX_VALUE;

        for (int sum: sumArray) {
            int absDiff = Math.abs(sum - target);
            if (absDiff < min) {
                min = absDiff;
                result = sum;
            }
        }
        return result;
    }
}

class ThreeSumSmallerQ12 {
    static int approach1(int[] nums, int target) {
        int len = nums.length;
        Arrays.sort(nums);
        int count = 0;

        for (int i = 0; i < len - 2; i++) {
            int j = i + 1;
            int k = len - 1;

            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];

                if (sum < target) {
                    count += k - j; // since even the biggest element nums[k] is added and still less than target, and as it's sorted every element between j & k will also satisfy the condition.
                    j++;
                } else if (sum >= target) {
                    k--;
                }
            }
        }
        return count;
    }
}

class ThreeSumQ11 {
    static List<List<Integer>> solution(int[] nums) {
        int len = nums.length;
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);

        for (int i = 0; i < len - 2; i++) {
            // if same adjacent element is present then it might already have been added
            // to the triplet, so skip it
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int tempSum = nums[i];
            int j = i + 1;
            int k = len - 1;

            while (j < k) {
                // System.out.println("Values at i: " + nums[i] + " j: " + nums[j] + " k: " + nums[k]);
                List<Integer> triplet = new ArrayList<Integer>();
                if (nums[j] + nums[k] == - tempSum) {
                    triplet.add(Integer.valueOf(nums[i]));
                    triplet.add(Integer.valueOf(nums[j]));
                    triplet.add(Integer.valueOf(nums[k]));
                    result.add(triplet);
                    while (j < k && nums[j] == nums[j + 1]) {
                        j++;
                    }

                    while (j < k && nums[k] == nums[k - 1]) {
                        k--;
                    }

                    k--;
                    j++;
                } else if (nums[j] + nums[k] > - tempSum) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return result;
    }

    static List<List<Integer>> brokenApproach(int[] nums) {
        int len = nums.length;
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);

        for (int i = 0; i < len; i++) {
            int tempSum = nums[i];
            int j = i+1;
            int k = len - 1;

            while (j < k) {
            List<Integer> triplet = new ArrayList<Integer>();
                if (i == j) {
                    j++;
                }
                if (i == k) {
                    k--;
                }
                System.out.println("Values at i: " + nums[i] + " j: " + nums[j] + " k: " + nums[k]);
                if (nums[j] + nums[k] == - tempSum) {
                    triplet.add(Integer.valueOf(nums[i]));
                    triplet.add(Integer.valueOf(nums[j]));
                    triplet.add(Integer.valueOf(nums[k]));
                    result.add(triplet);
                    k--;
                    j++;
                    continue;
                } else if (nums[j] + nums[k] > tempSum) {
                    k--;
                } else {
                    j++;
                }
            }
        }

        // remove duplicates
        Set<Set<Integer>> setToAvoidDuplicates = new HashSet<>();
        List<List<Integer>> resultNoDuplicates = new ArrayList<>();
        for (List<Integer> subArray: result) {
            Set<Integer> innerSet = new HashSet<>(subArray);
            if (!setToAvoidDuplicates.contains(innerSet)) {
                resultNoDuplicates.add(subArray);
                setToAvoidDuplicates.add(innerSet);
            }
        }

        return resultNoDuplicates;
    }
}

class MissingRangesQ10 {
    static List<String> approach1(int[] nums, int lower, int upper) {
        // assuming nums[0] is lower & having a pointer to first element;
        int last = 0;
        List<String> result = new ArrayList<>();
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[last] + 1 == nums[i]) {
                last = i;
                continue;
            }
            result.add(getRange(nums[last], nums[i]));
            last = i;
        }
        if (nums[last] != upper) {
            result.add(getRange(nums[last], upper + 1));
        }
        return result;
    }

    private static String getRange(int lastValue, int currentValue) {
        if (lastValue + 1 == currentValue - 1) {
            return String.valueOf(lastValue + 1);
        } 
        return String.valueOf(lastValue + 1)  + "->" + String.valueOf(currentValue - 1);
    }
}

class MajorityElementIIQ9 {
    // Return elements occuring more than n/3 times
    static List<Integer> approach1(int[] nums) {
        HashMap<Integer, Integer> frequencyMap = new HashMap<Integer, Integer>();
        List<Integer> result = new ArrayList<Integer>();
        for (int num : nums) {
            frequencyMap.putIfAbsent(num, 0);
            frequencyMap.put(num, frequencyMap.get(num) + 1);
        }

        frequencyMap.entrySet().forEach(set -> {
            if (set.getValue() > nums.length/3) {
                result.add(set.getKey());
            }
        });
        return result;
    }
}

class MajorityElementQ8 {
    static int usingSorting(int[] nums) {
        // since it is given that the majority element always exists & occurs more than n/2 times
        // Based on the array size the mid index will always have our majority element since it needs to occur more than n/2 times
        Arrays.sort(nums);
        int len = nums.length;
        return len % 2 != 0 ? nums[len/2] : nums[len/2 - 1];
    }
}

class BestTimeToBuyAndSellStockIIQ7 {
    static int approach2(int[] prices) {
        int length = prices.length;
        int maxProfit = 0;

        for (int i = 1; i < length; i++) {
            // If the next element is greater than current then it is a profit
            // and in turn lead to maxProfit than buying it once & waiting for the max price to sell it.
            int currentProfit = prices[i] - prices[i-1];
            if (currentProfit > 0) {
                maxProfit = maxProfit + currentProfit;
            }
        }
        return maxProfit;
    }

    static int approach1(int[] prices) {
        // Fails for [1, 2, 3, 4, 5]
        int maxProfit = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            int currentPrice = prices[i];
            if (currentPrice < min || min == 0) {
                min = currentPrice;
            } else if (currentPrice > min && min != 0) {
                maxProfit = maxProfit + currentPrice - min;
                min = 0;
            }
        }
        return maxProfit;
    }
}

class BestTimeToBuyAndSellStocksQ6 {
    static int solution(int[] prices) {
        int min = prices[0];
        int len = prices.length;
        int[] profits = new int[len];

        for (int i = 0; i < len; i++) {
            profits[i] = prices[i] - min;
            if (min > prices[i]) {
                min = prices[i];
            }
        }

        int maxProfit = -1;

        for (int profit: profits) {
            if (profit > maxProfit) {
                maxProfit = profit;
            }
        }

        return maxProfit;
    }

    static int bruteForce(int[] prices) {
        // TLE - 'cause given constraint is 1 <= prices.length <= 10^5 and TC goes upto 10^10 
        // which is over 10^8 & throws Time Limit Exceeded (TLE)
        int length = prices.length;
        int maxProfit = -1;

        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                int currentProfit = prices[j] - prices[i];
                if (currentProfit > maxProfit) {
                    maxProfit = currentProfit;
                }
            }
        }
        return maxProfit > 0 ? maxProfit : 0;
    }
}

class PascalsTriangleQ5 {
    static List<Integer> bruteForce(int rowIndex) {
        int[][] result = new int[rowIndex + 1][rowIndex + 1];
        for (int line = 0; line <= rowIndex; line++) {
            int[] temp = new int[line + 1];
            for (int i = 0; i <= line; i++) {
                if (i == 0 || i == line) {
                    temp[i] = 1;
                } else {
                    temp[i] = result[line - 1][i - 1] + result[line - 1][i];
                }
            }
            result[line] = temp;
        }
        int[] necessaryRow = result[rowIndex];
        return Arrays.stream(necessaryRow).map(i -> Integer.valueOf(i)).boxed().collect(Collectors.toList());
    }
}

class PascalsTriangleQ4 {
    static List<List<Integer>> check(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        System.out.println(result);

        for (int line = 0; line < numRows; line++) {
            int[] temp = new int[line + 1];
            for (int i = 0; i <= line; i++) {
                System.out.println("line: " + line + "\ti: " + i);
                if (i == 0 || i == line) {
                    temp[i] = 1;
                } else {
                    temp[i] = result.get(line - 1).get(i - 1) + result.get(line - 1).get(i);
                }
            }
            System.out.println(temp);
            // result.set(line, Arrays.asList(temp));
        }
        return result;
    }

    static List<List<Integer>> bruteForce(int numRows) {
        // TC: O(n*n); SC: O(n*n)
        int[][] result = new int[numRows][numRows];
        for (int line = 0; line < numRows; line++) {
            int[] temp = new int[line + 1];
            for (int i = 0; i <= line; i++) {
                if (i == 0 || i == line) {
                    temp[i] = 1;
                } else {
                    temp[i] = result[line - 1][i - 1] + result[line - 1][i];
                }
            }
            result[line] = temp;
        }
        return Arrays.stream(result)
                .map(row -> Arrays.stream(row).boxed().collect(Collectors.toList()))
                .collect(Collectors.toList());
    }
}

class MergeSortedArrayQ3 {
    static void solution(int[] nums1, int m, int[] nums2, int n) {
        // TC: O(nlogn); SC: O(1)
        int j = 0;
        for (int i = m; i < m + n; i++) {
            nums1[i] = nums2[j];
            j++;
        }
        Arrays.sort(nums1);
    }

    static void attempt1(int[] nums1, int m, int[] nums2, int n) {
        int i = 0;
        int j = 0;

        if (n == 0) {
            System.out.println(Arrays.toString(nums1));
            return;
        }
        if (m == 0) {
            while (n-- > 0) {
                nums1[n] = nums2[n];
                System.out.println(Arrays.toString(nums1));
                return;
            }
        }

        for (int k = 0; k < m; k++) {
            if (nums1[i] <= nums2[j]) {
                i++;
            } else if (nums2[j] < nums1[i]) {
                int temp = nums1[i];
                nums1[i] = nums2[j];
                nums2[j] = temp;
            }
            System.out.println("nums1: " + Arrays.toString(nums1));
            System.out.println("nums2: " + Arrays.toString(nums2));
        }

        for (int p = m; p < m + n; p++) {
            nums1[p] = nums2[j];
            j++;
        }
        System.out.println(Arrays.toString(nums1));
    }

    static void notAccepted(int[] nums1, int m, int[] nums2, int n) {
        List<Integer> result = new ArrayList<Integer>();
        int i = 0;
        int j = 0;

        if (n == 0) {
            System.out.println(Arrays.toString(nums1));
            return;
        }
        if (m == 0) {
            nums1 = nums2;
            System.out.println(Arrays.toString(nums1));
            return;
        }

        for (int k = 0; k < m + n; k++) {
            if (nums1[i] == 0) {
                result.add(nums2[j]);
                j++;
            } else if (nums1[i] <= nums2[j]) {
                result.add(k, nums1[i]);
                i++;
            } else if (nums2[j] < nums1[i]) {
                result.add(k, nums2[j]);
                j++;
            }
        }
        for (int k = 0; k < m + n; k++) {
            nums1[k] = result.get(k);
        }
        // nums1 = result.stream().mapToInt(Integer::intValue).toArray();
        System.out.println(Arrays.toString(nums1));
    }
}

class TwoSumIIQ2 {
    // Note: Given array is sorted in non-decreasing order & it's 1-indexed array
    // Your solution must use only constant extra space.

    static int[] usingTwoPointers(int[] numbers, int target) {
        // TC: O(n); SC: O(1)
        int length = numbers.length;
        int i = 0;
        int j = length - 1;

        while (i < j && j > -1) {
            int sum = numbers[i] + numbers[j];
            if (sum == target) {
                break;
            } else if (sum > target) {
                j -= 1;
            } else {
                i += 1;
            }
        }
        return new int[] { i + 1, j + 1 };
    }

    // Omitting bruteForce which is nested loops & also uses constant space
}

class TwoSumQ1 {
    static int[] usingHashMap(int[] nums, int target) {
        // TC: O(n); SC: O(n)
        HashMap<Integer, Integer> occurenceMap = new HashMap<Integer, Integer>();

        for (int num : nums) {
            if (occurenceMap.get(num) == null) {
                occurenceMap.put(num, 1);
            } else {
                occurenceMap.put(num, occurenceMap.get(num) + 1);
            }
        }

        int i = 0;
        int currentNum = 0;
        int numNeeded = 0;

        for (i = 0; i < nums.length; i++) {
            currentNum = nums[i];
            numNeeded = target - currentNum;
            if (occurenceMap.get(numNeeded) != null) {
                if (numNeeded != currentNum && occurenceMap.get(numNeeded) > 0) {
                    break;
                }
                if (numNeeded == currentNum && occurenceMap.get(numNeeded) > 1) {
                    break;
                }
            }
        }

        int secondIndex = -1;

        for (int k = 0; k < nums.length; k++) {
            if (numNeeded == nums[k] & k != i) {
                secondIndex = k;
            }
        }

        return new int[] { i, secondIndex };
    }

    static int[] usingBinarySearch(int[] nums, int target) {
        // TC: O(nlogn); SC: O(n)
        // hasn't been properly implemented - tech debt
        int low = 1;
        int high = nums.length - 1;
        int[] temp = Arrays.copyOf(nums, nums.length);
        Arrays.sort(nums);

        // Assigning random numbers
        int currNum = 0;
        int numToBeSearched = 0;

        forLoop: for (int i = 0; i < nums.length; i++) {
            currNum = nums[i];
            numToBeSearched = target - currNum;
            while (low <= high) {
                int mid = (low + high) / 2;
                int middleNum = nums[mid];
                if (middleNum == numToBeSearched) {
                    currNum = nums[i];
                    numToBeSearched = nums[mid];
                    break forLoop;
                } else if (middleNum > numToBeSearched) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }

        // To find the actual index
        int firstIndex = -1;
        int secondIndex = -1;
        System.out.println(currNum + "\t" + numToBeSearched);
        for (int k = 0; k < temp.length; k++) {
            if (currNum == temp[k] && firstIndex == -1) {
                firstIndex = k;
            } else if (numToBeSearched == temp[k]) {
                secondIndex = k;
            }
        }
        return new int[] { firstIndex, secondIndex };
    }

    static int[] usingTwoPointers(int[] nums, int target) {
        // Time: O(nlogn); Auxiliary Space: O(n)

        // Need to sort & use 2 pointers at extremes
        // But sorting compromises the indices
        int[] temp = Arrays.copyOf(nums, nums.length);
        Arrays.sort(temp);
        int i = 0;
        int j = temp.length - 1;

        while (i < j) {
            if (temp[i] + temp[j] == target) {
                break;
            } else if (temp[i] + temp[j] > target) {
                j--;
            } else {
                i++;
            }
        }

        int firstNumInSortedArray = temp[i];
        int secondNumInSortedArray = temp[j];

        // To find the actual index
        int firstIndex = -1;
        int secondIndex = -1;
        for (int k = 0; k < nums.length; k++) {
            if (firstNumInSortedArray == nums[k] && firstIndex == -1) {
                firstIndex = k;
            } else if (secondNumInSortedArray == nums[k]) {
                secondIndex = k;
            }
        }
        return new int[] { firstIndex, secondIndex };
    }

    int[] bruteForce(int[] nums, int target) {
        // Time Complexity: O(n^2) // Auxiliary Space: O(1)
        int i = 0;
        int j = 0;

        outerLoop: for (i = 0; i < nums.length - 1; i++) {
            int currentNum = nums[i];
            for (j = i + 1; j < nums.length; j++) {
                if (target == currentNum + nums[j]) {
                    break outerLoop;
                }
            }
        }
        int[] result = new int[] { i, j };
        return result;
    }
}

class Main {
    public static void main(String[] args) {
        RotateImageQ15.approach1(new int[][] { { 1,2,3 }, {4,5,6},{7,8,9}});
        RotateImageQ15.approach1(new int[][] { { 5,1,9,11 }, {2,4,8,10 },{13,3,6,7},{15,14,12,16}});
        
        // System.out.println(FourSumQ14.approach1(new int[] { 1,0,-1,0,-2,2 }, 0));
        // System.out.println(FourSumQ14.approach1(new int[] { 1000000000,1000000000,1000000000,1000000000 }, -294967296));
        // System.out.println(FourSumQ14.approach1(new int[] { 1, 2, 3, 4 }, 10));

        // System.out.println(ThreeSumClosestQ13.approach1(new int[] { 4,0,5,-5,3,3,0,-4,-5 }, -2));
        // System.out.println(ThreeSumClosestQ13.approach1(new int[] { -1, 2, 1, -4 }, 1));
        // System.out.println(ThreeSumClosestQ13.approach1(new int[] { 0,0,0 }, 1));
        
        // System.out.println(ThreeSumSmallerQ12.approach1(new int[] { -2, 0, 1, 3 }, 2));
        // System.out.println(ThreeSumSmallerQ12.approach1(new int[] { -2,0,-1,3 }, 2));

        // System.out.println(threeSumQ11.solution(new int[] { -1,0,1,2,-1,-4 }));
        // System.out.println(threeSumQ11.solution(new int[] { -1,0,1 }));
        // System.out.println(threeSumQ11.solution(new int[] { -2,0,1,1,2 }));
        // System.out.println(threeSumQ11.solution(new int[] { -1,0,1,0 }));
        // System.out.println(threeSumQ11.solution(new int[] { 1,-1,-1,0 }));

        // System.out.println(MissingRangesQ10.approach1(new int[] { 0, 1, 3, 50, 75 }, 0, 99));
        // System.out.println(MissingRangesQ10.approach1(new int[] { 0, 1, 2, 3, 7 }, 0, 7));

        // System.out.println(MajorityElementIIQ9.approach1(new int[] {2, 1, 1, 1}));
        
        // System.out.println(MajorityElementQ8.usingSorting(new int[] {2, 1, 1, 1}));

        // System.out.println(BestTimeToBuyAndSellStockIIQ7.approach2(new int[] { 7, 1, 5, 3, 6, 4 }));
        // System.out.println(BestTimeToBuyAndSellStockIIQ7.approach2(new int[] { 1,2,3,4,5 }));
        // System.out.println(BestTimeToBuyAndSellStockIIQ7.approach2(new int[] { 7,6,4,3,1 }));
        
        // System.out.println(BestTimeToBuyAndSellStocksQ6.solution(new int[] { 7, 1, 5, 3, 6, 4 }));
        // System.out.println(BestTimeToBuyAndSellStocksQ6.solution(new int[] { 2,1,4 }));
        // System.out.println(BestTimeToBuyAndSellStocksQ6.bruteForce(new int[] { 7, 1, 5, 3, 6, 4 }));

        // System.out.println(PascalsTriangleQ5.bruteForce(3));
        // System.out.println(PascalsTriangleQ5.bruteForce(0));
        // System.out.println(PascalsTriangleQ5.bruteForce(1));

        // System.out.println(PascalsTriangleQ4.bruteForce(5));

        // MergeSortedArrayQ3.bruteForce(new int[] { 1, 2, 3, 0, 0, 0 }, 3, new int[] { 2, 5, 6 }, 3);
        // MergeSortedArrayQ3.bruteForce(new int[] { 1 }, 1, new int[] {}, 0);
        // MergeSortedArrayQ3.bruteForce(new int[] { 0 }, 0, new int[] { 1 }, 1);
        // MergeSortedArrayQ3.bruteForce(new int[] { 4,5,6,0,0,0 }, 3, new int[] { 1,2,3 }, 3);
        // MergeSortedArrayQ3.solution(new int[] { 4, 5, 6, 0, 0, 0 }, 3, new int[] { 1, 2, 3 }, 3);

        // System.out.println(Arrays.toString(TwoSumIIQ2.usingTwoPointers(new int[] { 2, 7, 11, 15 }, 9)));
        // System.out.println(Arrays.toString(TwoSumIIQ2.usingTwoPointers(new int[] { 2, 3, 4 }, 6)));
        // System.out.println(Arrays.toString(TwoSumIIQ2.usingTwoPointers(new int[] { -1, 0 }, -1)));
        // System.out.println(Arrays.toString(TwoSumIIQ2.usingTwoPointers(new int[] { 5, 25, 75 }, 100)));

        // System.out.println(Arrays.toString(TwoSumQ1.usingHashMap(new int[] { 2, 7, 11, 15 }, 9)));
        // System.out.println(Arrays.toString(TwoSumQ1.usingHashMap(new int[] { 3, 2, 4 }, 6)));
        // System.out.println(Arrays.toString(TwoSumQ1.usingHashMap(new int[] { 2, 5, 5, 11 }, 6)));

        // System.out.println(Arrays.toString(TwoSumQ1.usingBinarySearch(new int[] { 2, 7, 11, 15 }, 9)));
        // System.out.println(Arrays.toString(TwoSumQ1.usingBinarySearch(new int[] { 3, 2, 4 }, 6)));
        // System.out.println(Arrays.toString(TwoSumQ1.usingBinarySearch(new int[] { 2, 5, 5, 11 }, 6)));

        // System.out.println(Arrays.toString(TwoSumQ1.usingBinarySearch(new int[] { 3, 3 }, 6)));

        // System.out.println(Arrays.toString(TwoSumQ1.usingTwoPointers(new int[] { 2, 7, 11, 15 }, 9)));

        // TwoSumQ1 q1 = new TwoSumQ1();
        // System.out.println(Arrays.toString(q1.bruteForce(new int[] { 2,7,11,15 }, 9)));
        // System.out.println(Arrays.toString(q1.bruteForce(new int[] { 3, 2, 4 }, 6)));
        // System.out.println(Arrays.toString(q1.bruteForce(new int[] { 3, 3 }, 6)));
    }
}