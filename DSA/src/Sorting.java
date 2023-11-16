package src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static util.MyUtilityClass.swap;

public class Sorting {
    public class MergeIntervals {
        public int[][] merge(int[][] intervals) {
            // sort based on first element of each inner array
            Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

            List<List<Integer>> ans = new ArrayList<>();
            ans.add(Arrays.asList(intervals[0][0], intervals[0][1]));

            for (int i = 1; i < intervals.length; i++) {
                List<Integer> previous = ans.get(ans.size() - 1);
                if (previous.get(1) >= intervals[i][0]) {
                    previous.set(1, Math.max(previous.get(1), intervals[i][1]));
                } else {
                    ans.add(Arrays.asList(intervals[i][0], intervals[i][1]));
                }
            }

            return ans.stream()
                    .map(i -> i.stream().mapToInt(Integer::intValue).toArray())
                    .toArray(int[][]::new);
        }

        public int[][] brokenApproach(int[][] intervals) {
            // [[1,3],[2,6],[8,10],[15,18]]
            // Actual: [[1,6],[8,10]]
            // Expected: [[1,6],[8,10],[15,18]]
            Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

            List<List<Integer>> ans = new ArrayList<>();
            boolean isMerged = false;
            for (int i = 0; i < intervals.length - 1; i++) {
                System.out.println(ans);
                if (intervals[i][0] == intervals[i + 1][0]) {
                    ans.add(i, Arrays.asList(intervals[i][0], Math.max(intervals[i][1], intervals[i + 1][1])));
                } else { // start_i < start_i+1, since we already sorted based on first ele of each inner array
                    if (intervals[i][1] == intervals[i + 1][0]) {
                        ans.add(i, Arrays.asList(intervals[i][0], intervals[i + 1][1]));
                    } else if (intervals[i][1] > intervals[i + 1][0]) {
                        if (intervals[i][1] == intervals[i + 1][1]) {
                            ans.add(i, Arrays.asList(intervals[i][0], intervals[i][1]));
                        } else if (intervals[i][1] < intervals[i + 1][1]) {
                            ans.add(i, Arrays.asList(intervals[i][0], intervals[i + 1][1]));
                            isMerged = true;
                        }
                    } else { // end_i < start_i+1
                        if (isMerged) {
                            isMerged = false;
                            continue;
                        }
                        ans.add(i - 1, Arrays.asList(intervals[i][0], intervals[i][1]));
                    }
                }
            }

            return ans.stream()
                    .map(i -> i.stream().mapToInt(Integer::intValue).toArray())
                    .toArray(int[][]::new);
        }
    }

    public class SortColors {
        public void sortColors(int[] nums) {
            int start = 0, end = nums.length - 1, i = 0;
            while (i <= end) {
                if (nums[i] == 2) {
                    swap(nums, i, end);
                    end--;
                }
                if (nums[i] == 0) { // note how we're checking for the same i even after swapping the 2
                    swap(nums, i, start);
                    start++;
                    i++;
                    // increment i once the zero is swapped or when element is 1
                } else if (nums[i] == 1) { // why am I checking 'cause what if the swap for 2 was 2 itself
                    i++;
                }
            }
        }

        public void brokenApproach(int[] nums) {
            // [1,2,0]
            int start = 0, end = nums.length - 1;
            for (int i = 0; i < nums.length; i++) {
                System.out.println(start + " " + end);
                if (nums[start] == 1 && nums[end] == 1 || start >= end) return;
                if (nums[i] == 2) {
                    if (nums[end] == 0) start++;
                    swap(nums, i, end);
                    end--;
                } else if (nums[i] == 0) {
                    if (nums[start] == 2) end--;
                    swap(nums, i, start);
                    start++;
                }
            }
        }
    }
}
