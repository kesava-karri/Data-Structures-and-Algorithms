package src;

public class Search {
    public class MinSizeSubArraySum {
        int n;
        int[] prefix;
        public int minSubArrayLen(int target, int[] nums) {
            // calculating prefix sum
            n = nums.length;
            prefix = new int[n];
            prefix[0] = nums[0];
            for (int i = 1; i < n; i++) {
                prefix[i] = prefix[i-1] + nums[i];
            }
            // Binary Search on length :), considering mid as len for our required subarray
            int start = 0, end = n, mid = 0, ans = Integer.MAX_VALUE;
            while(start <= end) {
                mid = (start + end) / 2;
                if (check(mid, target)) {
                    ans = mid;
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
            return ans == Integer.MAX_VALUE ? 0 : ans;
        }

        public boolean check(int mid, int target) {
            for (int i = mid; i < n; i++) {
                if (prefix[i] - prefix[i - mid]>= target) return true;
            }
            // for the first prefix which is not calculated above
            return (mid > 0 && prefix[mid - 1] >= target);
        }
    }

    public class FindPeakElement {
        public int findPeakElement(int[] nums) {
            int start = 0, end = nums.length - 1, mid = 0, ans = 0;
            if (nums.length == 1) return 0;

            while (start <= end) {
                mid = (start + end) / 2;
                if (mid == 0) {
                    // check if it is decreasing slope, since given that
                    // any index is strictly greater if the previous index goes out of bounds
                    if (nums[mid] > nums[mid + 1]) return mid;
                    start = mid + 1; // increasing slope
                } else if (mid - 1 >= 0 && nums[mid] > nums[mid - 1]) {
                    start = mid + 1;
                    ans = mid;
                } else if (nums[mid] < nums[mid - 1]) { // ignoring brevity for better understanding
                    end = mid - 1;
                }
            }
            return ans;
        }

        public int brokenApproach(int[] nums) {
            // do 2 binary searches on left & right half of mid - this doesn't work
            int mid = nums.length - 1 / 2;
            int start = 0, end = nums.length - 1;
            while ((mid - 1) > -1 ){
                mid = (start + end) / 2;
                if (mid - 1 <= -1) break;
                if (nums[mid] > nums[mid - 1] &&
                        nums[mid] > nums[mid + 1]) {
                    return mid;
                } else {
                    end = end - 1;
                }
            }
            // Reset start, end, mid to do binary search on 2nd half
            end = nums.length - 1;
            start = end / 2;
            mid = -1;
            while (mid + 1 < nums.length) {
                mid = start + end / 2;
                if (mid + 1 >= nums.length) break;
                if (nums[mid] > nums[mid - 1] &&
                        nums[mid] > nums[mid + 1]) {
                    return mid;
                } else {
                    start = start + 1;
                }
            }
            return nums.length - 1;
        }
    }

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

