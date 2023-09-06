import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

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
        System.out.println(PascalsTriangleQ4.bruteForce(5));

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