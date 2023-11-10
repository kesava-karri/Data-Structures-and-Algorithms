package src;

public class Search {
    public class FindInMountainArr {
        /**
         * // This is MountainArray's API interface.
         * interface MountainArray {
         *     public int get(int index) {}
         *     public int length() {}
         * }
         */
        // Commenting out the code since MountainArray is not implemented
        /*
        public int findInMountainArray(int target, MountainArray mountainArr) {
            int len = mountainArr.length();
            int start = 0, end = len - 1, mid = 0, peak = -2;
            while (start <= end) {
                mid = (start + end) / 2; // based on eq, since mid tends to zero, so better check mid < mid+1 than going for mid > mid - 1 :)
                // And it is not a valid mountain if the peak is on its edges ;) [1,2,3] is not a moutain as no element exist after 3 :)
                // if (mountainArr.get(mid) > mountainArr.get(mid - 1)) { // read above why this wouldn't work
                int midNum = mountainArr.get(mid);
                int next = mountainArr.get(mid + 1);
                if (midNum < next) {
                    start = mid + 1;
                    peak = start;
                } else {
                    end = mid - 1;
                }
            }

            // left slope
            start = 0;
            end = peak;
            while (start <= end) {
                mid = (start + end) / 2;
                int midNum = mountainArr.get(mid);
                if (midNum == target) {
                    return mid; // 'cause left slope will have min index
                } else if (midNum > target) {
                    end = mid - 1;
                } else if (midNum < target){
                    start = mid + 1;
                }
            }

            // right slope
            start = peak + 1;
            end = len - 1;
            while (start <= end) {
                mid = (start + end) / 2;
                int midNum = mountainArr.get(mid);
                if (midNum == target) return mid;
                else if (midNum > target) start = mid + 1;
                else if (midNum < target)end = mid - 1;
            }
            return -1;
        }
        */
        /*
        public int brokenApproach(int target, MountainArray mountainArr) {
            int start = 0, end = mountainArr.length() - 1, mid = 0, ans = -1;
            // Left slope
            while (start <= end) {
                mid = (start + end) / 2;
                int midElement = mountainArr.get(mid);
                if (midElement == target) {
                    ans = mid;
                    end = mid - 1;
                } else if (midElement > target) {
                    end = mid - 1;
                } else if (midElement < target) {
                    start = mid + 1;
                }
            }
            if (ans != -1) return ans; // 'cause if our target is found on the left slope then ovio it would the minimum
            // if target didn't exist on left slope, search for right
            start = 0;
            end = mountainArr.length() - 1;

            while (start <= end) {
                mid = (start + end) / 2;
                int midElement = mountainArr.get(mid);
                if (midElement == target) {
                    ans = mid;
                }
                start = mid + 1;
            }
            return ans;
        }
         */
    }

    public class PeakIndexMoutainArr {
        public int peakIndexInMountainArray(int[] arr) {
            int start = 0, end = arr.length - 1, mid = 0;
            while (start <= end) {
                mid = (start + end) / 2;
                if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
                    return mid;
                } else if (arr[mid] > arr[mid + 1]) {
                    end = mid;
                } else if (arr[mid] > arr[mid - 1]) {
                    start = mid;
                }
            }
            return -1;
        }
    }

    public class Search2DMatrixII {
        public boolean optimizedSearchMatrix(int[][] matrix, int target) {
            int m = matrix.length;
            int n = matrix[0].length;

            int start = 0, end = n - 1;
            while (start <= m - 1 && end >= 0) {
                if (target == matrix[start][end]) return true;
                else if (target < matrix[start][end]) {
                    end--; // eliminate the last col
                } else if(target > matrix[start][end]) {
                    start++; // elimate the first row if the last ele of first row is less than target :o
                }
            }
            return false;
        }

        public boolean searchMatrix(int[][] matrix, int target) {
            int m = matrix.length;

            // approach:
            // (i) binary search on first row then
            // (ii) binary search on first column and get potential search space
            // (iii) Linear search over the potential search space :)

            // TC: log m + log n + (o * p) + m; o * p < m * n

            int newSearchableRow = binarySearch(matrix[0], target);

            // This iteration is needed to find the first column :)
            int[] firstCol = new int[m];
            for (int i = 0; i < m; i++) {
                firstCol[i] = matrix[i][0];
            }

            int newSearchableCol = binarySearch(firstCol, target);

            for (int i = 0; i <= newSearchableCol; i++) {
                for (int j = 0; j <= newSearchableRow; j++) {
                    if (target == matrix[i][j]) return true;
                }
            }
            return false;
        }

        public int binarySearch(int[] nums, int target) {
            // Binary search to find the best potential mate
            int start = 0, end = nums.length - 1, mid = 0, potentialSearchSpace = 0;
            while(start <= end) {
                mid = (start + end) / 2;
                if (target >= nums[mid]) {
                    potentialSearchSpace = mid;
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
            return potentialSearchSpace;
        }
    }

    public class Search2DMatrix {
        public boolean searchMatrix(int[][] matrix, int target) {
            int n = matrix.length; // rows
            int m = matrix[0].length; // columns

            int rowStart = 0, rowEnd = n - 1, rowMid = 0;
            while (rowStart <= rowEnd) {
                rowMid = (rowStart + rowEnd) / 2;
                if (matrix[rowMid][0] <= target && target <= matrix[rowMid][m - 1]) {
                    return binarySearch(matrix[rowMid], target);
                } else { // target is neither equal nor in range of the current row
                    // target will have 2 chances - whether in prev rows or rows after
                    if (target < matrix[rowMid][0]) {
                        rowEnd = rowMid - 1;
                    } else {
                        rowStart = rowMid + 1;
                    }
                }
            }
            return false;
        }

        public boolean binarySearch(int[] row, int target) {
            int start = 0, end = row.length - 1, mid = 0;
            while(start <= end) {
                mid = (start + end) / 2;
                if(row[mid] == target) return true;
                if (row[mid] > target) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
            return false;
        }
    }

    public class FindMinRotatedSortedArrayII {
        public int findMin(int[] nums) {
            int start = 0, end = nums.length - 1, mid = 0, ans = Integer.MAX_VALUE;
            int firstNum = nums[0];

            while (start < end) {
                mid = (start + end) / 2;

                if (nums[mid] > nums[start]) {
                    start = mid + 1;
                } else if (nums[mid] < nums[start]) {
                    ans = nums[mid];
                    end = mid - 1;
                } else {
                    start = start + 1;
                }
                if (nums[start] < ans) ans = nums[start];
            }
            return Math.min(firstNum, ans);
        }
    }

    public class SearchInRotatedSortedArrayII {
        public boolean search(int[] nums, int target) {
            int start = 0, end = nums.length - 1, mid = 0;

            while (start <= end) {
                mid = (start + end) / 2;
                if (nums[mid] == target) return true;
                if ((nums[start] == nums[mid]) && (nums[end] == nums[mid])) {
                    start = start + 1;
                    end = end - 1;
                } else if (nums[mid] >= nums[start]) {
                    if (nums[mid] > target && target >= nums[start]) {
                        end = mid - 1;
                    } else {
                        start = mid + 1;
                    }
                } else if (nums[mid] < nums[start]) {
                    if (nums[mid] < target && target <= nums[end]) {
                        start = mid + 1;
                    } else {
                        end = mid - 1;
                    }
                }
            }
            return false;
        }
    }

    public class SearchInRotatedSortedArray {
        public int search(int[] nums, int target) {
            int start = 0, end = nums.length - 1, mid = 0;

            while (start <= end) {
                mid = (start + end) / 2;
                if (nums[mid] == target) return mid;
                if (nums[mid] >= nums[start]) {
                    if (nums[mid] > target && target >= nums[start]) {
                        end = mid - 1;
                    } else {
                        start = mid + 1;
                    }
                } else {
                    if (nums[mid] < target && target <= nums[end]) {
                        start = mid + 1;
                    } else {
                        end = mid - 1;
                    }
                }
            }
            return -1;
        }

        public int brokenApproach(int[] nums, int target) {
            int start = 0, end = nums.length - 1, mid = (start + end) / 2;
            int ans = -1;

            // 2 binary searches - left half, right half
            end = mid;
            while (start <= end) {
                int tempMid = (start + end) / 2;
                if (nums[tempMid] > target) {
                    end = tempMid - 1;
                } else if (nums[tempMid] < target) {
                    start = tempMid + 1;
                } else {
                    ans = tempMid;
                    System.out.println("1. " + ans);
                    return ans;
                }
            }
            // not present in left half so looking in left half
            start = mid; end = nums.length - 1;
            while (start <= end) {
                int tempMid = (start + end) / 2;
                if (nums[tempMid] > target) {
                    end = tempMid - 1;
                } else if(nums[tempMid] < target) {
                    start = tempMid + 1;
                } else {
                    ans = tempMid;
                    return ans;
                }
            }
            return ans;
        }
    }

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

