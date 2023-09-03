import java.util.Arrays;
import java.util.HashMap;

class TwoSumQ1 {
    static int[] usingHashMap(int[] nums, int target) {
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
        // hasn't been properly implemented
        int low = 0;
        int high = nums.length - 1;
        int[] temp = Arrays.copyOf(nums, nums.length);
        Arrays.sort(nums);

        // Assigning random numbers
        int currNum = 0;
        int numToBeSearched = 0;
        int i = 0;

        forLoop: for (i = 0; i < nums.length; i++) {
            currNum = nums[i];
            numToBeSearched = target - currNum;
            int mid = (low + high) / 2;
            int middleNum = nums[mid];
            while (low < high) {
                if (middleNum == numToBeSearched) {
                    currNum = nums[i];
                    numToBeSearched = nums[mid];
                    break forLoop;
                } else if (middleNum > numToBeSearched) {
                    high = mid;
                } else {
                    low = mid;
                }
            }
        }

        // To find the actual index
        int secondIndex = -1;
        for (int k = 0; k < temp.length; k++) {
            if (numToBeSearched == nums[k] && k != i) {
                secondIndex = k;
                break;
            }
        }
        return new int[] { i, secondIndex };
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
        // System.out.println(Arrays.toString(TwoSumQ1.usingHashMap(new int[] { 2, 7, 11, 15 }, 9)));
        // System.out.println(Arrays.toString(TwoSumQ1.usingHashMap(new int[] { 3, 2, 4 }, 6)));
        System.out.println(Arrays.toString(TwoSumQ1.usingHashMap(new int[] { 2, 5, 5, 11 }, 6)));

        // System.out.println(Arrays.toString(TwoSumQ1.usingBinarySearch(new int[] { 2, 7, 11, 15 }, 9)));
        // System.out.println(Arrays.toString(TwoSumQ1.usingBinarySearch(new int[] { 3, 2, 4 }, 6)));
        // System.out.println(Arrays.toString(TwoSumQ1.usingBinarySearch(new int[] { 3, 3 }, 6)));

        // System.out.println(Arrays.toString(TwoSumQ1.usingTwoPointers(new int[] { 2, 7, 11, 15 }, 9)));

        // TwoSumQ1 q1 = new TwoSumQ1();
        // System.out.println(Arrays.toString(q1.bruteForce(new int[] { 2,7,11,15 }, 9)));
        // System.out.println(Arrays.toString(q1.bruteForce(new int[] { 3, 2, 4 }, 6)));
        // System.out.println(Arrays.toString(q1.bruteForce(new int[] { 3, 3 }, 6)));
    }
}