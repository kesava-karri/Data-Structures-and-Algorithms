package src;

public class Search {
    public class FindMinRotatedSortedArray {
        public int solution(int[] nums) {
        // take the first element for the comparison
        int firstNum = nums[0];
        int start = 0, end = nums.length - 1;
        int ans = Integer.MAX_VALUE;

        // Binary Search
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] >= firstNum) {
                start = mid + 1;
            } else if (nums[mid] < firstNum) {
                end = mid - 1;
                ans = nums[mid];
            }
        }
        // min of firstNum and ans 'cause there could be a case where the given array hasn't been rotated at all
        // or rotated by it's length number of times which would lead to firstNum being the least.
        return Math.min(firstNum, ans);
    }

    public class FirstAndLastPosOfElementInSortedArray {
        public int[] solution(int[] nums, int target) {
            // Binary Search
            int start = 0;
            int end = nums.length - 1;
            int[] ans = new int[] {-1, -1};

            // Binary Search to find the first pos
            while (start <= end) {
                int mid = (start + end) / 2;
                if (nums[mid] < target) {
                    start = mid + 1;
                } else if (nums[mid] == target) {
                    ans[0] = mid; // there's a chance that the first position could be in the left of this region, so continue the binary search in that region
                    end = mid - 1;
                } else if (nums[mid] > target) {
                    end = mid - 1;
                }
            }

            // Reset start & end
            start = 0;
            end = nums.length - 1;

            // Binary search to find the last pos
            while (start <= end) {
                int mid = (start + end) / 2;
                if (nums[mid] < target) {
                    start = mid + 1;
                } else if (nums[mid] == target) {
                    ans[1] = mid; // there's a chance that the first position could be on the region right of this value, so continue the binary search in that region
                    start = mid + 1;
                } else if (nums[mid] > target) {
                    end = mid - 1;
                }
            }
            return ans;
        }
    }
}

