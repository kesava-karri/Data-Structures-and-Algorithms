package src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import static util.MyUtilityClass.swap;

public class Sorting {
    public class MajorityElementII {
        public List<Integer> majorityElementUsingQuickSort(int[] nums) {
            return new ArrayList();
        }

        public List<Integer> majorityElement(int[] nums) {
            // We can atmost have only 2 majority elements & minimum no majority elements
            int num1 = 0, num2 = 0, count1 = 0, count2 = 0;
            int n = nums.length;

            for (int num : nums) {
                if (num == num1) {
                    count1++;
                } else if (num == num2) {
                    count2++;
                } else if (count1 == 0) {
                    num1 = num;
                    count1++;
                } else if (count2 == 0) {
                    num2 = num;
                    count2++;
                } else {
                    count1--;
                    count2--;
                }
            }

            count1 = 0;
            count2 = 0;
            for (int num : nums) {
                if (num == num1) count1++;
                else if (num == num2) count2++;
            }

            if (count1 > n / 3 && count2 > n / 3) return Arrays.asList(num1, num2);
            else if (count1 > n / 3) return Arrays.asList(num1);
            else if (count2 > n / 3) return Arrays.asList(num2);
            return new ArrayList();
        }
    }

    public class IntersectionOfTwoArrays {
        public int[] intersection(int[] nums1, int[] nums2) {
            Arrays.sort(nums1);
            Arrays.sort(nums2);
            List<Integer> ans = new ArrayList<>();
            List<Integer> comp = new LinkedList<>();
            System.out.println("1" + ans.getClass().isAssignableFrom(comp.getClass()));

            int i = 0, j = 0;
            int len1 = nums1.length, len2 = nums2.length;

            while(i < len1 && j < len2) {
                if (nums1[i] < nums2[j]) {
                    i++;
                } else if (nums1[i] > nums2[j]) {
                    j++;
                } else { // nums1[i] == nums2[j]
                    if (ans.isEmpty() || ans.get(ans.size() - 1) != nums1[i]) {
                        // Since the arrays are already sorted,
                        // when an intersection element is already added,
                        // then we can be sure that the last ele added could only be the possible duplicate
                        // if not then it must be a new intersection element.
                        ans.add(nums1[i]);
                    }
                    i++;
                    j++;
                }
            }
            return ans.stream().mapToInt(Integer::intValue).toArray();
        }
    }
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

    public class InversionCount {
        public long inversionCount(long arr[], long N) {
            long[] temp = new long[arr.length];
            return divideAndMerge(arr, temp, 0, N - 1);
        }

        public long divideAndMerge(long[] arr, long[] temp, long start, long end) {
            long ans = 0;
            if (start >= end) return ans;

            long mid = (start + end) / 2;

            ans += divideAndMerge(arr, temp, start, mid);
            ans += divideAndMerge(arr, temp, mid + 1, end);

            ans += conquer(arr, temp, start, end, mid);
            return ans;
        }

        public long conquer(long[] arr, long[] temp, long start, long end, long mid) {
            int i = (int) start, j = (int) mid + 1, k = 0;
            long ans = 0;

            while (i <= mid && j <= end) {
                if (arr[j] < arr[i]) {
                    ans += (mid - i + 1);
                    temp[k++] = arr[j++];
                } else {
                    temp[k++] = arr[i++];
                }
            }

            while (i <= mid) {
                temp[k++] = arr[i++];
            }

            while (j <= end) {
                temp[k++] = arr[j++];
            }

            k = 0;
            for (i = (int) start; i <= (int) end; i++) {
                arr[i] = temp[k++];
            }
            return ans;
        }
    }
}
