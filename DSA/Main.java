import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class MoveZeroesQ8 {
    public static void approach1(int[] nums) {
        // Time Complexity: O(n)
        // Auxiliary space: O(1)
        int ptr = 0; // A pointer at the starting Index; also behaves as non zero counter
        int length = nums.length;
        for (int num : nums) {
            if (num != 0) {
                nums[ptr] = num;
                ptr++;
            }
        }

        int availableZeroes = length - ptr;
        while (availableZeroes > 0) {
            nums[length - 1] = 0;
            availableZeroes--;
            length--;
        }
        System.out.println(Arrays.toString(nums));
    }
}

class MajorityElementQ7 {
    public static int altApproach(int[] nums) {
        // Time Complexity: O(n)
        // Space Complexity: O(n)
        Map<Integer, Integer> occurenceMap = new HashMap<Integer, Integer>();
        int occurenceNeeded = nums.length / 2;
        // In this approach we are avoiding both containsKey & containsValue which take most time.
        for (int num : nums) {
            occurenceMap.putIfAbsent(num, 0);
            occurenceMap.put(num, occurenceMap.get(num) + 1);
            if (occurenceMap.get(num) > occurenceNeeded) {
                return num;
            }
        }
        return -1;
    }

    public static int bruteForce(int[] nums) {
        // Time complexity: O(n* (n + n)) ~ O(n^2)
        // Space complexity: O(n)
        Map<Integer, Integer> occurenceMap = new HashMap<Integer, Integer>();
        int occurenceNeeded = nums.length / 2;
        for (int num : nums) {
            if (!occurenceMap.containsKey(num)) { // O(n)
                occurenceMap.put(num, 0);
            } else {
                occurenceMap.put(num, occurenceMap.get(num) + 1);
            }
            if (occurenceMap.containsValue(occurenceNeeded)) { // O(n)
                return num;
            }
        }
        return -1;
    }
}

class TransposeMatrixQ6 {
    public static int[][] bruteForce(int[][] matrix) {
        // Time Complexity: O(n * m); Space Complexity: O(m * n)
        int rows = matrix.length;
        int columns = matrix[0].length;
        int[][] transposeMatrix = new int[columns][rows]; // old rows would be new columns

        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                transposeMatrix[column][row] = matrix[row][column];
            }
        }
        return transposeMatrix;
    }
}

class ThreeConsecutiveOddsQ5 {
    public static boolean altApproach(int[] arr) {
        // Time Complexity: O(n); Space Complexity: O(1)
        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i - 1] % 2 != 0
                    && arr[i] % 2 != 0
                    && arr[i + 1] % 2 != 0) {
                return true;
            }
        }
        return false;
    }

    public static boolean bruteForce(int[] arr) {
        // Time Complexity: O(n); Space Complexity: O(1)
        int oddNumCounter = 0;
        for (int num : arr) {
            if (num % 2 != 0) {
                oddNumCounter++;
                if (oddNumCounter == 3) {
                    return true;
                }
            } else {
                oddNumCounter = 0;
            }
        }
        return false;
    }
}

class MinimumAbsoluteDifferenceQ4 {
    public static List<List<Integer>> builtins(int[] arr) {
        // Time Complexity: O(nlogn + n) ≈ O(nlogn)
        // Space Complexity: O(n)
        int minDifference = Integer.MAX_VALUE;
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        Arrays.sort(arr); // nlogn
        for (int i = 1; i < arr.length; i++) { // n
            int currentDiffernce = arr[i] - arr[i - 1];
            if (currentDiffernce > minDifference) {
                continue;
            } else if (currentDiffernce < minDifference) {
                result.clear();
                minDifference = currentDiffernce;
            }
            result.add(Arrays.asList(arr[i - 1], arr[i]));
        }
        return result;
    }
}

class JewelsAndStonesQ3 {
    public static int solution(String jewels, String stones) {
        // Time Complexity: O(n + m) -> n, m are lengths of jewels & stones respectively.
        // Space Complexity: O(n) -> n is length of jewels
        int jewelsInStones = 0;
        Map<Character, Integer> JewelsMap = new HashMap<Character, Integer>();

        for (int i = 0; i < jewels.length(); i++) {
            char jewel = jewels.charAt(i);
            if (!JewelsMap.containsKey(jewel)) {
                JewelsMap.put(jewel, 0);
            }
        }

        for (int i = 0; i < stones.length(); i++) {
            if (JewelsMap.containsKey(stones.charAt(i))) {
                jewelsInStones += 1;
            }
        }
        return jewelsInStones;
    }

    public static int builtins(String jewels, String stones) {
        // Time Complexity: O(n * m); n, m are jewels & stones length respectively
        // Space Complexity: O(1)
        int jewelsInStones = 0;
        for (String jewel : jewels.split("")) {
            for (String stone : stones.split("")) {
                if (stone.equals(jewel)) {
                    jewelsInStones++;
                }
            }
        }
        return jewelsInStones;
    }
}

class RunningSumQ2 {
    public static int[] solution(int[] nums) {
        // Time Complexity: O(n); Space Complexity: O(1)
        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] + temp;
            temp = nums[i];
        }
        return nums;
    }
}

class MaximumWealthQ1 {
    public static int bruteForce(int[][] accounts) {
        // Time Complexity: O(n * m) ; n is the length of individual accounts, m is length of accounts array
        // Space Complexity: O(n)
        /*
         * Note that only static things (let it be variables or methods) 
         * can be accessed thru the class name, non-static things need an instance to be accessed :)
         */
        int maxWealth = Integer.MIN_VALUE;
        for (int[] account : accounts) { // space complexity can be reduced by using for loop instead of for each here

            int bankWealth = 0;
            for (int i = 0; i < account.length; i++) {
                bankWealth += account[i];
            }
            if (bankWealth > maxWealth) {
                maxWealth = bankWealth;
            }
        }
        return maxWealth;
    }

    public static int builtins(int[][] accounts) {
        // System.out.println(Arrays.deepToString(accounts)); // To print multi-dimensional array

        int maxWealth = Integer.MIN_VALUE;
        int[] individualBankWealth = Arrays.stream(accounts).mapToInt(account -> Arrays.stream(account).sum())
                .toArray();
        // System.out.println(Arrays.toString(Arrays.stream(accounts).map(i -> IntStream.of(i).sum()).toArray()));

        for (int tempWealth : individualBankWealth) {
            if (tempWealth > maxWealth) {
                maxWealth = tempWealth;
            }
        }

        // System.out.println(Arrays.toString(
        //         IntStream.range(0, accounts.length).map(i -> IntStream.of(accounts[i]).sum()).toArray()));
        return maxWealth;
    }
}

class Main {
    public static void main(String[] args) {
        MoveZeroesQ8.approach1(new int[] { 0, 1, 0, 3, 12 });
        MoveZeroesQ8.approach1(new int[] { 0 });

        // System.out.println(MajorityElementQ7.bruteForce(new int[] { 3, 2, 3 }));
        // System.out.println(MajorityElementQ7.bruteForce(new int[] { 2, 2, 1, 1, 1, 2, 2 }));
        // System.out.println(MajorityElementQ7.altApproach(new int[] { 3, 2, 3 }));
        // System.out.println(MajorityElementQ7.altApproach(new int[] { 2, 2, 1, 1, 1, 2, 2 }));

        // System.out.println(Arrays
        //         .deepToString(TransposeMatrixQ6.bruteForce(new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } })));
        // System.out.println(Arrays
        //         .deepToString(TransposeMatrixQ6.bruteForce(new int[][] { { 1, 2, 3 }, { 4, 5, 6 } })));

        // System.out.println(ThreeConsecutiveOddsQ5.bruteForce(new int[] { 2, 6, 4, 1 }));
        // System.out.println(ThreeConsecutiveOddsQ5.bruteForce(new int[] { 1, 2, 34, 3, 4, 5, 7, 23, 12 }));
        // System.out.println(ThreeConsecutiveOddsQ5.bruteForce(new int[] { 1, 2, 1, 1 }));
        // System.out.println(ThreeConsecutiveOddsQ5.altApproach(new int[] { 2, 6, 4, 1 }));
        // System.out.println(ThreeConsecutiveOddsQ5.altApproach(new int[] { 1, 2, 34, 3, 4, 5, 7, 23, 12 }));
        // System.out.println(ThreeConsecutiveOddsQ5.altApproach(new int[] { 1, 2, 1, 1 }));

        // System.out.println(MinimumAbsoluteDifferenceQ4.builtins(new int[] { 4, 2, 1, 3 }));
        // System.out.println(MinimumAbsoluteDifferenceQ4.builtins(new int[] { 1, 3, 6, 10, 15 }));
        // System.out.println(MinimumAbsoluteDifferenceQ4.builtins(new int[] { 3, 8, -10, 23, 19, -4, -14, 27 }));

        // System.out.println(JewelsAndStonesQ3.solution("aA", "aAAbbbb"));
        // System.out.println(JewelsAndStonesQ3.solution("z", "ZZ"));
        // System.out.println(JewelsAndStonesQ3.builtins("aA", "aAAbbbb"));
        // System.out.println(JewelsAndStonesQ3.builtins("z", "ZZ"));

        // System.out.println(Arrays.toString(RunningSumQ2.solution(new int[] { 1, 2, 3, 4 })));
        // System.out.println(Arrays.toString(RunningSumQ2.solution(new int[] { 1, 1, 1, 1, 1 })));
        // System.out.println(Arrays.toString(RunningSumQ2.solution(new int[] { 3, 1, 2, 10, 1 })));

        // System.out.println(MaximumWealthQ1.bruteForce(new int[][] { { 1, 2, 3 }, { 3, 2, 1 } }));
        // System.out.println(MaximumWealthQ1.bruteForce(new int[][] { { 1, 5 }, { 7, 3 }, { 3, 5 } }));
        // System.out.println(MaximumWealthQ1.bruteForce(new int[][] { { 2, 8, 7 }, { 7, 1, 3 }, { 1, 9, 5 } }));
        // System.out.println(MaximumWealthQ1.builtins(new int[][] { { 1, 2, 3 }, { 3, 2, 1 } }));
        // System.out.println(MaximumWealthQ1.builtins(new int[][] { { 1, 5 }, { 7, 3 }, { 3, 5 } }));
        // System.out.println(MaximumWealthQ1.builtins(new int[][] { { 2, 8, 7 }, { 7, 1, 3 }, { 1, 9, 5 } }));
    }
}
