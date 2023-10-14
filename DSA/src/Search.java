package src;

public class Search {
    public class FindMinRotatedSortedArray {
        public int solution(int[] nums) {
            // Binary Search
            // Assuming the first is the leastValue
            int min = nums[0];

            int start = 0;
            int end = nums.length - 1;
            int mid = -1; // randomValue

            while (start <= end) {
                mid = (start + end) / 2;
                int midNum = nums[mid];
                if (midNum > min) {
                    start = mid + 1;
                } else if (midNum == min) {
                    start = mid + 1;
                } else if (midNum < min) {
                    min = midNum;
                    end = mid - 1;
                }
            }
            return min;
        }
    }

    public class FirstAndLastPosOfElementInSortedArray {
        public int[] solution(int[] nums, int target) {
            // Binary Search
            int start = 0;
            int end = nums.length - 1;
            int leastStartPos = -1;
            int farthestEndPos = -1;

            // To find the least i.e., starting pos
            while (start <= end) {
                int mid = (start + end) / 2;
                int midNum = nums[mid];

                if (midNum < target) {
                    start = mid + 1;
                } else if (midNum == target) {
                    leastStartPos = mid; // assuming whichever we got to be least & there can be a chance that even lower answer is available, since non-increasing array.
                    // And we know that the least index could not exist to the right, so bringing our end to the one less than mid
                    end = mid - 1;
                } else if (midNum > target) {
                    end = mid - 1;
                }
            }

            // Reset start & end
            start = 0;
            end = nums.length - 1;

            // To find the farthest i.e., ending pos
            while (start <= end) {
                int mid = (start + end) / 2;
                int midNum = nums[mid];

                if (midNum < target) {
                    start = mid + 1;
                } else if (midNum == target) {
                    farthestEndPos = mid;
                    start = mid + 1;
                } else if (midNum > target) {
                    end = mid - 1;
                }
            }
            return new int[] { leastStartPos, farthestEndPos};
        }
    }
}

