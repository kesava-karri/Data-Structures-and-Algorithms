import java.lang.StringBuilder;
import java.lang.Integer;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class RemoveElementQ7 {
    static int approach1(int[] nums, int val) {
        // Fill the first elements with non val elements
        // Have the pointer to fill in those elements
        int ptr = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                int temp = nums[i];
                nums[i] = nums[ptr];
                nums[ptr] = temp;
                ptr++;
            }
        }

        System.out.println(Arrays.toString(nums));
        return ptr;
    }
}

class RangeSumQuery2DImmutableQ6 {
    private int[][] matrix;

    public RangeSumQuery2DImmutableQ6(int[][] matrix) {
        this.matrix = matrix;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for (int i = row1; i <= row2; i++) {
            for (int j = col1; j <= col2; j++) {
                sum += matrix[i][j];
            }
        }
        return sum;
    }
}

class RangeSumQueryImmutableQ5 {
    private int[] nums;

    public RangeSumQueryImmutableQ5(int[] nums) {
        this.nums = nums;
    }
    
    public int sumRange(int left, int right) {
        int sum = 0;
        for (int i = left; i <= right; i++) {
            sum += nums[i];
        }
        return sum;
    }
}

class SummaryRangesQ4 {
    static List<String> approach1(int[] nums) {
        int start = 0;
        int track = 0;
        int len = nums.length;
        int i = 1;

        List<String> ranges = new ArrayList<>();

        for (i = 1; i < len; i++) {
            if (nums[i] - nums[track] == 1) {
                track = i;
                if (i == len - 1 && start != track) {
                    ranges.add(new StringBuilder(nums[start] + "->" + nums[track]).toString());
                }
            } else {
                if (start == track) {
                    StringBuilder sb = new StringBuilder();
                    ranges.add(sb.append(nums[start]).toString());
                } else {
                    ranges.add(new StringBuilder(nums[start] + "->" + nums[track]).toString());
                }
                start = i;
                track = i;
            }
        }

        // To handle the last element without a range
        if (start == track && start == i - 1 && nums.length != 0) {
            StringBuilder temp = new StringBuilder();
            ranges.add(temp.append(nums[i - 1]).toString());
        }
        return ranges;
    }
}

class ContainsDuplicateIIQ3 {
    static boolean approach1(int[] nums, int k) {
        Map<Integer, Integer> lastIndexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int currentNum = nums[i];
            if (lastIndexMap.containsKey(currentNum)) {
                if (Math.abs(lastIndexMap.get(currentNum) - i) <= k) {
                    return true;
                }
            }
            lastIndexMap.put(currentNum, i);
        }
        return false;
    }

    static boolean brokenApproach(int[] nums, int k) {
        // to preserve the indices
        List<Integer> copyOfNums = 
            Arrays.stream(nums).boxed().collect(Collectors.toList());
        Arrays.sort(nums);

        int ptr = 0;
        int value = -1;
        // Find duplicate value
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[ptr]) {
                ptr = i;
            } else {
                value = nums[i];
            }
        }

        int firstIndex = copyOfNums.indexOf(value);
        int lastIndex = copyOfNums.lastIndexOf(value);

        // Use those indices to tell if it satisfies the given condition,
        // But I think this loop wouldn't take this into account when the previous element is different
        // and thus making it broken appraoch.
        while (firstIndex < lastIndex) {
            if (Math.abs(firstIndex - lastIndex) <= k
                && copyOfNums.get(lastIndex) == copyOfNums.get(firstIndex)) {
                return true;
            }
            lastIndex--;
        }
        return false;
    }
}

class ContainsDuplicateQ2 {
    static boolean approach1(int[] nums) {
        Arrays.sort(nums);
        int ptr = 0; // pointer to see if duplicates exist
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[ptr]) {
                return true;
            } else { // If current element not equal to tracking number then the number being tracked doesn't have duplicate since we have sorted it. :)
                ptr = i;
            }
        }
        return false;
    }
}

class MoveZeroesQ1 {
    static void approach1(int[] nums) {
        int ptr = 0;
        int zeroCounter = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] == 0) {
                zeroCounter++;
            } else {
                nums[ptr] = nums[i];
                ptr++;
            }
        }

        while (zeroCounter > 0) {
            nums[len - 1] = 0;
            len--;
            zeroCounter--;
        }
        // System.out.println(Arrays.toString(nums));
    }
}

class Main {
    public static void main(String[] args) {
        System.out.println(RemoveElementQ7.approach1(new int[] { 0,1,2,2,3,0,4,2 }, 2));

        // RangeSumQuery2DImmutableQ6 q6Obj = new RangeSumQuery2DImmutableQ6(new int[][] {
        //     {3, 0, 1, 4, 2 }, {5, 6, 3, 2, 1}, {1, 2, 0, 1, 5}, {4, 1, 0, 1, 7}, {1, 0, 3, 0, 5}
        // });
        // System.out.println(q6Obj.sumRegion(2, 1, 4, 3));

        // RangeSumQueryImmutableQ5 q5Obj = new RangeSumQueryImmutableQ5(new int[] {-2, 0, 3, -5, 2, -1});
        // System.out.println(q5Obj.sumRange(0, 2));

        // System.out.println(SummaryRangesQ4.approach1(new int[] { 0,2,3,4,6,8,9 }));
        // System.out.println(SummaryRangesQ4.approach1(new int[] { 0,1,2,4,5,7 }));
        // System.out.println(SummaryRangesQ4.approach1(new int[] { }));
        // System.out.println(SummaryRangesQ4.approach1(new int[] { 42 }));
        // System.out.println(SummaryRangesQ4.approach1(new int[] {-3, -1, 0, 3}));
        // System.out.println(SummaryRangesQ4.approach1(new int[] {1, 3, 5, 7, 9}));

        // System.out.println(ContainsDuplicateIIQ3.approach1(new int[] {1,2,3,1,2,3}, 2));
        // System.out.println(ContainsDuplicateIIQ3.approach1(new int[] {1,2,3,1}, 3));

        // ContainsDuplicateQ2.approach1(new int[] {1,2,3,1});

        // MoveZeroesQ1.approach1(new int[] { 0,1,0,3,12 });
    }
}