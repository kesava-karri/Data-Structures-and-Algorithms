package src;

import util.MyUtilityClass;

import java.lang.StringBuilder;
import java.lang.Integer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.Set;
import java.util.Scanner;

public class Arrays_ {
    public class SubArraySumPattern {
        public void subArraySum() {
            /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();

            String input2 = scanner.nextLine();
            int[] arr = Arrays.stream(input2.split(" ")).mapToInt(Integer::parseInt).toArray();

            int evenSum = 0, oddSum = 0;
            for (int i = 0; i < arr.length; i = i + 2) {
                evenSum += arr[i];
            }

            for (int i = 1; i < arr.length; i = i + 2) {
                oddSum += arr[i];
            }
            System.out.println(evenSum + " " + oddSum);
            int[] ans = new int[] { -1, -1 };
            if (evenSum == oddSum) {
                ans[0] = 1;
                System.out.println(Arrays.toString(ans));
            } else {
                System.out.println(Arrays.toString(ans));
            }

        }
    }

    class MaxScoreAfterSplittingString {
        public int maxScore(String s) {
            int score = 0;
            int zeros = 0; // only on left substring
            int ones = 0; // only on right substring
            int n = s.length();
            for (int i = 1; i < n; i++) {
                // count zeros
                zeros = countNums(s.substring(0, i), 0);
                // count ones
                ones = countNums(s.substring(i , n), 1);

                if (zeros + ones > score) {
                    score = zeros + ones;
                }
            }
            return score;
        }

        private int countNums(String s, int i) {
            int count = 0;
            if (i == 0) {
                for (char c : s.toCharArray()) {
                    if (c == '0') count++;
                }
            } else { // i == 1
                for (char c : s.toCharArray()) {
                    if (c == '1') count++;
                }
            }
            return count;
        }
    }

    class ImageSmoother {
        int m, n;
        public int[][] imageSmoother(int[][] img) {
            m = img.length;
            n = img[0].length;
            int[][] ans = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    ans[i][j] = smoothenCell(img, i, j);
                }
            }
            return ans;
        }

        private int smoothenCell(int[][] img, int i, int j) {
            // Consider avg. from all 9 cells and when some index
            // doesn't exist we can ignore it;
            // If our element is at (0, 0) then the outer boundary indexes look like these,
            // follow same for other border indices
            // (-1,-1) (-1,0) (-1,1)
            // (0, -1) (0, 0) (0, 1)
            // (1, -1) (1, 0) (1, 1)
            // So we need to calculate in all eight directions for
            // each cell
            int sum = 0, count = 0;
            for (int k = -1; k <= 1; k++) {
                for (int l = -1; l <= 1; l++) {
                    if ((i + k) < 0 || (i + k) >= m
                            || (j + l) < 0 || (j + l) >= n) {
                        continue;
                    }
                    sum += img[i + k][j + l];
                    count++;
                }
            }

            return sum/count;
        }
    }

    class MaxProductDiffBetweenTwoPairs {
        public int maxProductDifference(int[] nums) {
            Arrays.sort(nums);
            int n = nums.length;
            return (nums[n - 1] * nums[n - 2]) - (nums[0] * nums[1]);
        }
    }

    class DifferenceBetweenOnesAndZerosInRowAndColumn {
        public int[][] onesMinusZeros(int[][] grid) {
            // since diff[i][j] = (onesRowi - zerosRowi) + (onesColj  - zerosColj)
            // I would like to iterate over each row & find it's ith diff & also follow the same for col & find jth diff
            // once we have both creating a diff matrix should be simply adding rows & cols values :)

            int m = grid.length;
            int n = grid[0].length;
            // rowDiff has every row's diff for each row {0 : 1, 1 : 1, 2 : -1}
            // i.e., For row 0: 2 (no. of ones) - 1 (no. of zeros) = 1 & so on.
            Map<Integer, Integer> rowDiff = new HashMap<>();
            Map<Integer, Integer> colDiff = new HashMap<>();

            // Filling up rowDiff
            for (int i = 0; i < m; i++) {
                int ones = 0, zeroes = 0;
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 1) ones++;
                    else zeroes++;
                }
                rowDiff.put(i, ones - zeroes);
            }

            // Filling up colDiff
            for (int j = 0; j < n; j++) {
                int ones = 0, zeroes = 0;
                for (int i = 0; i < m; i++) {
                    if (grid[i][j] == 1) ones++;
                    else zeroes++;
                }
                colDiff.put(j, ones - zeroes);
            }

            int[][] diff = new int[m][n];
            // Fill diff matrix with values we accumulated
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    diff[i][j] = rowDiff.get(i) + colDiff.get(j);
                }
            }
            return diff;
        }
    }

    class ReduceArraySizeToHalfQ14 {
        public int approach1(int[] arr) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int num : arr) {
                if (!map.containsKey(num)) {
                    map.put(num, 1);
                } else {
                    map.put(num, map.get(num) + 1);
                }
            }

            List<Integer> frequencies = new ArrayList<>();
            for (int value : map.values()) {
                frequencies.add(value);
            }

            Collections.sort(frequencies);

            int ans = 0;
            int freqCounter = 0;
            int halfLen = arr.length / 2;

            if (frequencies.size() == 1 && frequencies.get(0) >= halfLen) {
                return ++ans;
            }

            for (int i = frequencies.size() - 1; i > 0; i--) {
                int currentFreq = frequencies.get(i);
                if (currentFreq >= halfLen) {
                    ans++;
                    return ans;
                }
                if (freqCounter >= halfLen) {
                    return ans;
                }
                freqCounter += currentFreq;
                ans++;
            }
            return ans;
        }

        public int brokenApproach(int[] arr) {
            // Doesn't account when more elements are at the end after sort :) E.g: [1000, 1000, 3, 7]
            Arrays.sort(arr);
            int maxCount = 0;
            int currentMaxCount = 1;
            int len = arr.length;
            int halfLen = len / 2;
            int ans = 0;

            for (int i = 1; i < len - 1; i++) {
                if (arr[i] == arr[i - 1]) {
                    currentMaxCount++;
                    if (currentMaxCount >= halfLen) {
                        return 1;
                    }
                } else {
                    ans++; // increase for every transition to new num
                    maxCount = maxCount + currentMaxCount;
                    currentMaxCount = 1; // Reset counter for the start of new transition
                }

                if (maxCount >= halfLen) {
                    return ans;
                }
            }
            return 1;
        }
    }

    class RankTeamsByVotesQ13 {
        public String solution(String[] votes) {
            int len = votes[0].length();
            int[][] mp = new int[26][len + 1]; // len+1 -> extra column to store the corresponding alphabet at the end :)
            for (int i = 0; i < votes.length; i++) {
                String s = votes[i];
                for (int j = 0; j < len; j++) {
                    mp[s.charAt(j) - 'A'][j]++;
                    mp[s.charAt(j) - 'A'][len] = s.charAt(j) - 'A';
                }
            }


            Arrays.sort(mp, (a, b) -> {
                for (int i = 0; i < len; i++) {
                    if (a[i] < b[i]) return 1;
                    if (a[i] > b[i]) return -1;
                }
                return 0;
            });

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < len; i++) {
                sb.append((char)('A' + mp[i][len]));
            }
            return sb.toString();
        }

        public String alt(String[] votes) {
            // Olympic standings :)
            // Comparator sorting

            // Let's take 26 x 26 matrix as each vote would be only English uppercase letter

            // finding the number of places to compete for
            int totalRanks = votes[0].length();
            List<Character> allTeams = new ArrayList<>();
            for (char ch : votes[0].toCharArray()) { // allTeams
                allTeams.add(ch);
            }

            int[][] matrix = new int[totalRanks][26]; // max of competingTeams would be 26, so inner loop takes constant time.

            for (int i = 0; i < votes.length; i++) {
                for (int j = 0; j < votes[i].length(); j++) {
                    matrix[j][votes[i].charAt(j) - 'A']++;
                }
            }

            allTeams.sort(new Comparator<Character>() {
                @Override
                public int compare(Character c1, Character c2) {
                    for (int i = 0; i < totalRanks; i++) {
                        if (matrix[i][c1 - 'A'] != matrix[i][c2 - 'A']) {
                            return matrix[i][c2 - 'A'] - matrix[i][c1 - 'A'];
                        }
                    }
                    return c1 - c2;
                }
            });
            StringBuilder sb = new StringBuilder();
            for (Character ch : allTeams) {
                sb.append(ch);
            }

            return sb.toString();
        }

        public String brokenApproach(String[] votes) {
            // Input: votes = ["ABC","ACB","ABC","ACB","ACB"]
            // Output: "ACB"

            int numTeams = votes[0].length();

            List<Map<Character, Integer>> positionVotes = new ArrayList<>();
            for (int i = 0; i < numTeams; i++) {
                positionVotes.add(new HashMap<>());
            }

            if (votes.length == 1) {
                return votes[0];
            }

            for (String vote : votes) {
                for (int i = 0; i < numTeams; i++) {
                    char team = vote.charAt(i);
                    positionVotes.get(i).put(team, positionVotes.get(i).getOrDefault(team, 0) + 1);
                }
            }
            System.out.println(positionVotes);
            List<Set<Character>> teamList = new ArrayList<>();
            for (int i = 0; i < positionVotes.size(); i++) {
                teamList.add(positionVotes.get(i).keySet());
            }
            return "";
        }
    }

    class NextGreaterElementIIIQ12 {
        public int approach1(int n) {
            // Input: n = 12; // 12443322
            // Output: 21

            String[] str = Integer.toString(n).split("");
            List<Integer> nums = Arrays.stream(str).map(i -> Integer.parseInt(i)).collect(Collectors.toList());
            StringBuilder result = new StringBuilder();

            // find the number less than right adj
            int i = nums.size() - 2;
            while (i >= 0 && nums.get(i) >= nums.get(i + 1)) {
                i--;
            }

            // If the elements are present in decreasing order, then we could never find a num less than right adj
            if (i == -1) {
                return -1;
            }

            // find the next biggest element to swap the with above element
            int j = nums.size() - 1;
            while (j >= 0 && nums.get(j) <= nums.get(i)) {
                j--;
            }

            MyUtilityClass.swap(nums, i, j);

            // Now take all the elements till i
            for (int k = 0; k <= i; k++) {
                result.append(nums.get(k));
            }

            // Append all elements from end
            for (int l = nums.size() - 1; l > i; l--) {
                result.append(nums.get(l));
            }

            return Long.parseLong(result.toString()) <= Integer.MAX_VALUE ? Integer.parseInt(result.toString()) : -1;
        }
    }

    class NextGreaterElementIIQ11 {
        public int[] approach1(int[] nums) {
            int len = nums.length;
            int[] ans = new int[len];

            outerLoop: for (int i = 0; i < len; i++) {
                int currIthNum = nums[i];
                for (int j = i + 1; j < i + 1 + len; j++) {
                    int currJthNum = nums[j % len];
                    if (currJthNum > currIthNum) {
                        ans[i] = currJthNum;
                        continue outerLoop;
                    }
                }
                ans[i] = -1;
            }
            return ans;
        }
    }

    class NextGreaterElementQ10 {
        public int[] approach1(int[] nums1, int[] nums2) {
            // Input: nums1 = [4,1,2], nums2 = [1,3,4,2]
            // Output: [-1,3,-1]
            int[] ans = new int[nums1.length];

            outerLoop: for (int i = 0; i < nums1.length; i++) {
                int currIthNum = nums1[i];
                int ptr = -1;
                for (int j = 0; j < nums2.length; j++) {
                    int currJthElement = nums2[j];
                    // Chose Integer.MAX_VALUE to avoid entering the second condition when not needed :)
                    int matchedNum = ptr == -1 ? Integer.MAX_VALUE : nums2[ptr];

                    if (currIthNum == currJthElement) {
                        ptr = j;
                        continue;
                    }
                    if (currJthElement > matchedNum) {
                        ans[i] = currJthElement;
                        continue outerLoop;
                    }
                }
                ans[i] = -1;
            }
            return ans;
        }
    }

    class IntersectionOfTwoArraysIIQ9 {
        public int[] approach1(int[] nums1, int[] nums2) {
            // Input: nums1 = [1,2,2,1], nums2 = [2,2]
            // Output: [2,2]

            Map<Integer, Integer> map1 = new HashMap<>();
            Map<Integer, Integer> map2 = new HashMap<>();
            List<Integer> intersection = new ArrayList<>();

            for (int i = 0; i < nums1.length; i++) {
                int currentNum = nums1[i];
                if (!map1.containsKey(currentNum)) {
                    map1.put(currentNum, 1);
                } else {
                    map1.replace(currentNum, map1.get(currentNum) + 1);
                }
            }

            for (int i = 0; i < nums2.length; i++) {
                int currentNum = nums2[i];
                if (!map2.containsKey(currentNum)) {
                    map2.put(currentNum, 1);
                } else {
                    map2.replace(currentNum, map2.get(currentNum) + 1);
                }
            }

            map1.forEach((key, value) -> {
                if (map2.containsKey(key)) {
                    int leastOccurence = value < map2.get(key) ? value : map2.get(key);
                    for (int j = 0; j < leastOccurence; j++) {
                        intersection.add(key);
                    }
                }
            });

            return intersection.stream().mapToInt(Integer::intValue).toArray();
        }

        public int[] brokenApproach(int[] nums1, int[] nums2) {
            // Input: nums1 = [1,2,2,1], nums2 = [2,2]
            // Output: [2,2]
            // Doesn't check for element that has already been added, E.g: nums1 = [1, 2, 2, 1]; nums2 = [2]; o/p: [2, 2]

            List<Integer> intersection = new ArrayList<>();

            outerLoop: for (int i = 0; i < nums1.length; i++) {
                for (int j = 0; j < nums2.length; j++) {
                    if (nums1[i] == nums2[j]) {
                        intersection.add(Integer.valueOf(nums1[i]));
                        continue outerLoop;
                    }
                }
            }
            return intersection.stream().mapToInt(Integer::intValue).toArray();
        }
    }

    class IntersectionOfTwoArraysQ8 {
        public int[] hashing(int[] nums1, int[] nums2) {
            // since the frequency doesn't matter considering a HashSet
            Set<Integer> set1 = new HashSet<>();
            Set<Integer> set2 = new HashSet<>();
            List<Integer> result = new ArrayList<>();

            for (int num : nums1) {
                set1.add(num);
            }

            for (int num : nums2) {
                set2.add(num);
            }

            for (int num : set1) {
                if (set2.contains(num)) {
                    result.add(num);
                }
            }
            return result.stream().mapToInt(Integer::valueOf).toArray();
        }

        public int[] approach1(int[] nums1, int[] nums2) {
            // Input: nums1 = [1,2,2,1], nums2 = [2,2]
            // Output: [2]

            Set<Integer> set = new HashSet<>();
            outerLoop: for (int i = 0; i < nums1.length; i++) {
                for (int j = 0; j < nums2.length; j++) {
                    if (nums1[i] == nums2[j] && !set.contains(nums1[i])) {
                        set.add(Integer.valueOf(nums1[i]));
                        continue outerLoop; // Given only unique values needed, so once I add a value, it's not needed to compare that ith with rest of values in nums2
                    }
                }
            }
            return set.stream().mapToInt(Integer::intValue).toArray();
            // .map(i -> i.intValue()).collect(Collectors.toList());
        }
    }

    class RemoveElementQ7 {
        public int approach1(int[] nums, int val) {
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
        public List<String> approach1(int[] nums) {
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
        public boolean approach1(int[] nums, int k) {
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

        public boolean brokenApproach(int[] nums, int k) {
            // to preserve the indices
            List<Integer> copyOfNums = Arrays.stream(nums).boxed().collect(Collectors.toList());
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
        public boolean approach1(int[] nums) {
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
        public void approach1(int[] nums) {
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

    class TrappingRainWater {
        public int approach1(int[] height) {
            // Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
            // Output: 6
            int len = height.length;
            List<Integer> maxiesLeft = new ArrayList<>();
            int[] maxiesRight = new int[len]; // Had to choose an array over ArrayList to add the final element at last index

            maxiesLeft.add(0); // Since there's no bar on the left of first bar

            // find maxies for each bar to their left
            for (int i = 1; i < len; i++) {
                int maxLeft = Math.max(maxiesLeft.get(i - 1), height[i - 1]);
                maxiesLeft.add(i, maxLeft);
            }

            maxiesRight[len - 1] = 0; // Since there's no bar on the left of first bar

            // find maxies for each bar to the right
            for (int j = len - 2; j > 0; j--) {
                int maxRight = Math.max(maxiesRight[j + 1], height[j + 1]);
                maxiesRight[j] = maxRight;
            }

            int waterThatCanBeStored = 0;
            for (int i = 0; i < len; i++) {
                int minWater = Math.min(maxiesLeft.get(i), maxiesRight[i]);
                if (height[i] < minWater) {
                    waterThatCanBeStored += minWater - height[i];
                }
            }

            return waterThatCanBeStored;
        }
    }

    class BuildArrayFromPermutation {
        public int[] constSpace(int[] nums) {
            // We need nums[nums[i]]
            // Input: nums = [5,0,1,2,3,4]
            // Output: [4,5,0,1,2,3]

            int len = nums.length;

            for (int i = 0; i < len; i++) {
                // since the given values would be between 0 to n - 1 gives the chance to use mod
                // We need to retain new value and old value (which would be overwritten)
                // So we to store a num such that we can get both old & new values from it.
                // and by playing with those numbers we come up with this equation (pretty similar to "Dividend Formula")
                // a[i] = old value + 6 * (new value % 6);
                nums[i] = nums[i] + len * (nums[nums[i]] % len);
            }

            for (int i = 0; i < len; i++) {
                nums[i] = nums[i] / len;
            }

            return nums;
        }

        public int[] approach1(int[] nums) {
            // Input: nums = [0,2,1,5,3,4]
            // Output: [0,1,2,4,5,3]
            int len = nums.length;
            int[] ans = new int[len];
            for (int i = 0; i < len; i++) {
                ans[i] = nums[nums[i]];
            }
            return ans;
        }
    }

    class MissingNumber {
        public int linearTime(int[] nums) {
            // Using XOR property :),
            // We know that XOR of two same numbers gives 0 i.e., cancels those duplicate numbers

            // Input: nums = [3,0,1]
            // Output: 2
            int ans = 0; // since 0 XOR a value returns that value
            for (int i = 0; i < nums.length; i++) {
                ans ^= i ^ nums[i];
            }
            // since the last element is not included in the loop, XOR w that element while returning
            return ans ^ nums.length;
        }

        public int brokenApproach(int[] nums) {
            // 111 / 122 testcases passed
            // Given nums would have [0, n]
            // That implies we could use sum of first n natural numbers :)
            int maxValue = -1;
            int sumOfNums = 0;

            // since given range is [0, n]
            // if input has single element
            if (nums.length == 1) {
                if (nums[0] != 0) {
                    return 0;
                }
            }

            for (int i = 0; i < nums.length; i++) {
                int currentNum = nums[i];
                sumOfNums += currentNum;
                if (currentNum > maxValue) {
                    maxValue = currentNum;
                }
            }

            // using the maxValue in nums to find out sum
            int sumOfNaturalNums = (maxValue * (maxValue + 1)) / 2;


            // Since it hasn't been mentioned what to return when no missing number exist ([0, 1] for example)
            // We can assume that 1 is (n - 1)th value, so increment the maxValue and return it
            if (sumOfNaturalNums == sumOfNums) {
                return maxValue + 1;
            }
            return sumOfNaturalNums - sumOfNums;
        }

        public int approach1(int[] nums) {
            // TC: O(nlogn)
            Arrays.sort(nums);
            int i = 0;
            for (i = 0; i < nums.length; i++) {
                if (nums[i] != i) {
                    break;
                }
            }
            return i;
        }
    }

    class PrisonCellsAfterNDays {
        public int[] approach1(int[] cells, int n) {
            // Input: cells = [0,1,0,1,1,0,0,1], n = 7
            // Output: [0,0,1,1,0,0,0,0]
            // Note that n could go till 10 ^ 9 and max operations is 10 ^ 8, so we would get TLE if we iterate.
            // That implies the problem has to be solved without iterating, look for some patterns
            // Day 0: [0, 1, 0, 1, 1, 0, 0, 1] -> Input

            // Day 1: [0, 1, 1, 0, 0, 0, 0, 0]
            // Day 2: [0, 0, 0, 0, 1, 1, 1, 0]
            // Day 3: [0, 1, 1, 0, 0, 1, 0, 0]
            // Day 4: [0, 0, 0, 0, 0, 1, 0, 0]
            // Day 5: [0, 1, 1, 1, 0, 1, 0, 0]
            // Day 6: [0, 0, 1, 0, 1, 1, 0, 0]
            // Day 7: [0, 0, 1, 1, 0, 0, 0, 0]
            // Day 8: [0, 0, 0, 0, 0, 1, 1, 0]
            // Day 9: [0, 1, 1, 1, 0, 0, 0, 0]
            //Day 10: [0, 0, 1, 0, 0, 1, 1, 0]
            //Day 11: [0, 0, 1, 0, 0, 0, 0, 0]
            //Day 12: [0, 0, 1, 0, 1, 1, 1, 0]
            //Day 13: [0, 0, 1, 1, 0, 1, 0, 0]
            //Day 14: [0, 0, 0, 0, 1, 1, 0, 0]

            //Day 15: [0, 1, 1, 0, 0, 0, 0, 0] -> Repeats Day 1
            //Day 16: [0, 0, 0, 0, 1, 1, 1, 0] -> Repeats Day 2
            // That implies the pattern keeps repeating from 15, so 1 to 14 would be our pattern and anything above can be looked in these days with %14

            n = n % 14 == 0 ? 14 : n % 14;

            int len = cells.length; // 8
            int[] temp = new int[8];
            for (int i = 0; i < n; i++) { // for Number of days
                for (int j = 1; j < len - 1; j++) { // all changes for each day
                    if (cells[j - 1] == cells[j + 1]) {
                        temp[j] = 1;
                    } else {
                        temp[j] = 0;
                    }
                }
                for (int k = 0; k < len; k++) { // assigning all values of temp to cells before end of each day :)
                    cells[k] = temp[k];
                }
            }
            return cells;
        }
    }
}
/*
public class Arrays2 {
    public static void main(String[] args) {
        // System.out.println(Arrays.toString(src.PrisonCellsAfterNDays.approach1(new int[] { 0,1,0,1,1,0,0,1 }, 7)));
        // System.out.println(Arrays.toString(src.PrisonCellsAfterNDays.approach1(new int[] { 1,0,0,1,0,0,1,0 }, 1000000000)));
        // System.out.println(Arrays.toString(src.PrisonCellsAfterNDays.approach1(new int[] { 1,1,0,1,1,0,0,1 }, 300663720)));

        // System.out.println(src.MissingNumber.linearTime(new int[] { 9,6,4,2,3,5,7,0,1 }));
        // System.out.println(src.MissingNumber.linearTime(new int[] { 3,0,1 }));
        // System.out.println(src.MissingNumber.approach1(new int[] { 3,0,1 }));

        // System.out.println(Arrays.toString(src.BuildArrayFromPermutation.constSpace(new int[] { 3, 2, 1, 0 })));
        // System.out.println(Arrays.toString(src.BuildArrayFromPermutation.constSpace(new int[] { 5, 0, 1, 2, 3, 4 })));
        // System.out.println(Arrays.toString(src.BuildArrayFromPermutation.approach1(new int[] { 0,2,1,5,3,4 })));

        // System.out.println(src.TrappingRainWater.approach1(new int[] {0,1,0,2,1,0,1,3,2,1,2,1}));

        // System.out.println(src.ReduceArraySizeToHalfQ14.approach1(new int[] { 3, 3, 3, 3, 5, 5, 5, 2, 2, 7 }));
        // System.out.println(src.ReduceArraySizeToHalfQ14.approach1(new int[] { 7, 7, 7, 7, 7, 7 }));
        // System.out.println(src.ReduceArraySizeToHalfQ14.approach1(new int[] { 1000, 1000, 3, 7 }));

        System.out.println(RankTeamsByVotesQ13.solution(new String[] {"AZC","ZAC"}));
        // System.out.println(src.RankTeamsByVotesQ13.approach1(new String[] {"ABC","ACB","ABC","ACB","ACB"}));
        // System.out.println(src.RankTeamsByVotesQ13.approach1(new String[] {"ZMNAGUEDSJYLBOPHRQICWFXTVK"}));

        // System.out.println(src.NextGreaterElementIIIQ12.approach1(12));
        // System.out.println(src.NextGreaterElementIIIQ12.approach1(11452));
        // System.out.println(src.NextGreaterElementIIIQ12.approach1(6537421));
        // System.out.println(src.NextGreaterElementIIIQ12.approach1(12345));
        // System.out.println(src.NextGreaterElementIIIQ12.approach1(2147483486));
        // System.out.println(src.NextGreaterElementIIIQ12.approach1(12443322)); // 13443222 // 13222344

        // System.out.println(Arrays.toString(src.NextGreaterElementIIQ11.approach1(new int[] {1, 2, 1})));
        // System.out.println(Arrays.toString(src.NextGreaterElementIIQ11.approach1(new int[] {1,5,3,6,8})));

        // System.out.println(Arrays.toString(src.NextGreaterElementQ10.approach1(new int[] {4, 1, 2}, new int[] {1, 3, 4, 2})));

        // System.out.println(Arrays.toString(src.IntersectionOfTwoArraysIIQ9.approach1(new int[] {1,2,2,1}, new int[] {2, 2})));
        // System.out.println(Arrays.toString(src.IntersectionOfTwoArraysIIQ9.approach1(new int[] {4,9,5}, new int[] {9,4,9,8,4})));

        // System.out.println(Arrays.toString(src.IntersectionOfTwoArraysQ8.hashing(new int[] {1,2,2,1}, new int[] {2, 2})));
        // System.out.println(Arrays.toString(src.IntersectionOfTwoArraysQ8.approach1(new int[] {1,2,2,1}, new int[] {2, 2})));

        // System.out.println(src.RemoveElementQ7.approach1(new int[] { 0,1,2,2,3,0,4,2 }, 2));

        // src.RangeSumQuery2DImmutableQ6 q6Obj = new src.RangeSumQuery2DImmutableQ6(new int[][] {
        //     {3, 0, 1, 4, 2 }, {5, 6, 3, 2, 1}, {1, 2, 0, 1, 5}, {4, 1, 0, 1, 7}, {1, 0, 3, 0, 5}
        // });
        // System.out.println(q6Obj.sumRegion(2, 1, 4, 3));

        // src.RangeSumQueryImmutableQ5 q5Obj = new src.RangeSumQueryImmutableQ5(new int[] {-2, 0, 3, -5, 2, -1});
        // System.out.println(q5Obj.sumRange(0, 2));

        // System.out.println(src.SummaryRangesQ4.approach1(new int[] { 0,2,3,4,6,8,9 }));
        // System.out.println(src.SummaryRangesQ4.approach1(new int[] { 0,1,2,4,5,7 }));
        // System.out.println(src.SummaryRangesQ4.approach1(new int[] { }));
        // System.out.println(src.SummaryRangesQ4.approach1(new int[] { 42 }));
        // System.out.println(src.SummaryRangesQ4.approach1(new int[] {-3, -1, 0, 3}));
        // System.out.println(src.SummaryRangesQ4.approach1(new int[] {1, 3, 5, 7, 9}));

        // System.out.println(src.ContainsDuplicateIIQ3.approach1(new int[] {1,2,3,1,2,3}, 2));
        // System.out.println(src.ContainsDuplicateIIQ3.approach1(new int[] {1,2,3,1}, 3));

        // src.ContainsDuplicateQ2.approach1(new int[] {1,2,3,1});

        // src.MoveZeroesQ1.approach1(new int[] { 0,1,0,3,12 });
    }
}
*/