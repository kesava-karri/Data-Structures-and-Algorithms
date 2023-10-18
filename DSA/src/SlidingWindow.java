package src;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SlidingWindow {
    public class LongestSubstringKRepeatingCharactersQ5 {
        public int solution(String s, int k) {
            if (s.length() < k && s.length() == 0) return 0;
            if (k <= 1) return s.length();
            Map<Character, Integer> map = new HashMap<>();
            for (char ch : s.toCharArray()) {
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            }
            int l = 0;
            for (int i = 0; i < s.length() && map.get(s.charAt(i)) >= k; i++) {
                l++;
            }
            if (l > s.length() - 1) return l;
            int l1 = solution(s.substring(0, l), k);
            while (l < s.length() && map.get(s.charAt(l)) < k) {
                l++;
            }
            int l2 = solution(s.substring(l), k);
            return Math.max(l1, l2);
            // Can you do it without recursion? it makes it really complicated 'cause look at this example "ababacb" & k=3, char c breaks the string, in turn breaks the solution without char b which leads it to have char a either
            // So with that break point we'll be left with 2 strings which needs similar calculation so we gotta recursion.
        }

        public int approach(String s, int k) {
            // alphabet frequency array
            // return sum of elements greater than k of the array

            int[] freq = new int[26];
            int ans = 0;
            for (int i = 0; i < s.length(); i++) {
                freq[s.charAt(i) - 97]++;
            }
            System.out.println(Arrays.toString(freq));
            for (int i = 0; i < 26; i++) {
                if (freq[i] >= k) {
                    ans += freq[i];
                }
            }
            return ans > 0 ? ans : 0;
        }
    }
    public class SlidingWindowMaximumQ4 {
        public int[] solution(int[] nums, int k) {
            List<Integer> ans = new ArrayList<>();
            Deque<Integer> deck = new ArrayDeque<>();

            for (int i = 0; i < nums.length; i++) {
                // if (!deck.isEmpty() && deck.size() > k) { // if deck size is going over the window size then remove the first element as it wouldn't be in given window size
                if (deck.size() != 0 && deck.getFirst() == i - k) {
                    deck.removeFirst();
                }

                // This makes sure that our max element always stays at the first of deck
                while(!deck.isEmpty() && nums[i] > nums[deck.getLast()]) {
                    deck.removeLast();
                }

                deck.addLast(i);
                // if (i >= k - 1) {
                if (i + 1 >= k) {
                    ans.add(nums[deck.getFirst()]);
                }
            }
            return ans.stream().mapToInt(Integer::intValue).toArray();
        }

        public int[] approach(int[] nums, int k) {
            List<Integer> ans = new ArrayList();
            List<Integer> temp = new ArrayList();

            if (nums.length == k) {
                return new int[] { Arrays.stream(nums).max().getAsInt() };
            }
            if (k == 1) {
                return nums; // since the window is 1, we add all elements resulting in same given array
            }
            for (int i = 0; i < k; i++) {
                temp.add(nums[i]);
            }
            int ptr = 0;
            int tempPtr = 0;

            int temp1 = Collections.max(temp);
            ans.add(temp1);
            for (int i = k; i <= nums.length - 1; i++) {
                if (ans.get(ptr) != temp.get(tempPtr)) {
                    if (nums[i] > ans.get(ptr)) {
                        ans.add(nums[i]);
                        ptr++;
                    } else {
                        ans.add(ans.get(ptr));
                        ptr++;
                    }
                    temp.add(nums[i]);
                    tempPtr++;
                }
            }

            return ans.stream().mapToInt(Integer::intValue).toArray();
        }
    }
    public class ContainsDuplicateIIIQ3 {
        Map<Integer, Integer> shortMap = new HashMap<>();
        public boolean solution(int[] nums, int indexDiff, int valueDiff) {
            // The approach is to create buckets and any 2 values from the bucket should have difference <= valueDiff
            int len = nums.length;
            Map<Long, Long> mp = new HashMap<>();

            for (int i = 0; i < len; ++i) {
                // calculate the bucket value; + 1 in the denominator to have same valueDiff in the same bucket; take an example to understand
                long bucket = (long) (nums[i] / (valueDiff + 1));
                // for -ve values there is a chance that they could belong to the same bucket but their abs diff is greater than valueDiff, so we assign the bucket value one less.
                if (nums[i] < 0) {
                    bucket = bucket - 1;
                }

                if (mp.containsKey(bucket)) return true;
                else {
                    mp.put(bucket, (long)nums[i]);
                    // there's a possibility where previous or next bucket satisfy the difference with the element of current bucket, so check that along with the difference
                    if (mp.containsKey(bucket - 1) && (long) nums[i] - mp.get(bucket - 1) <= valueDiff) return true;
                    if (mp.containsKey(bucket + 1) && (long) mp.get(bucket + 1) - nums[i] <= valueDiff) return true;

                    // After checking with those buckets, our window if crosses the given indexDiff then we remove the bucket containing that element
                    if (mp.size() > indexDiff) {
                        long del = (long) (nums[i - indexDiff] / (valueDiff + 1));

                        if (nums[i - indexDiff] < 0) {
                            del = del - 1;
                        }
                        mp.remove(del);
                    }
                }
            }
            return false;
        }

        public boolean brokenApproach(int[] nums, int indexDiff, int valueDiff) {
            // 33 out of 50;
            System.out.println("1. " + shortMap);
            int windowSize = indexDiff + 1;
            int ptr = 0;
            int firstWindowLen = windowSize > nums.length ? nums.length : windowSize;
            for (int i = 0; i < firstWindowLen; i++) {
                if (i != shortMap.get(nums[i])) {
                    if (Math.abs(i - shortMap.get(nums[i])) <= indexDiff
                            && Math.abs(nums[i] - nums[i]) <= valueDiff) {
                        return true;
                    }
                }
                shortMap.put(nums[i], i);
                System.out.println("2. " + shortMap);
            }
            shortMap.remove(nums[ptr]);
            System.out.println("3. " + shortMap);
            ptr++;
            for (int i = windowSize; i < nums.length; i++) {
                int count = windowSize - 1;
                if (count < windowSize) {
                    if (shortMap.containsKey(nums[i]) && i != shortMap.get(nums[i])) {
                        if (Math.abs(i - shortMap.get(nums[i])) <= indexDiff) {
                            return true;
                        }
                    }
                    shortMap.put(nums[i], i);
                    System.out.println("4.. " + shortMap);
                    count++;
                }
                shortMap.remove(nums[ptr]);
                System.out.println("5. " + shortMap);
                ptr++;
            }

            return false;
        }
    }

    public class ContainsDuplicateIIQ2 {
        Map<Integer, Integer> shortMap = new HashMap<>();

        public boolean approach(int[] nums, int k) {
            int windowSize = k + 1; // since we need difference of indices, so if k is 3 then windowSize would be 4
            int ptr = 0;
            if (nums.length == 1) { // since i, j have to be distinct
                return false;
            }
            // first window
            int firstWindowLen = windowSize >= nums.length ? nums.length : windowSize;
            for (int i = 0; i < firstWindowLen; i++) {
                if (shortMap.containsKey(nums[i]) && i != shortMap.get(nums[i])) {
                    if (Math.abs(i - shortMap.get(nums[i])) <= k) {
                        return true;
                    }
                }
                shortMap.put(nums[i], i);
            }
            shortMap.remove(nums[ptr]);
            ptr = ptr + 1;

            for (int j = ptr + 1; j < nums.length; j++) {
                if (shortMap.containsKey(nums[j]) && j != shortMap.get(nums[j])) {
                    if (Math.abs(j - shortMap.get(nums[j])) <= k) {
                        return true;
                    }
                }
                shortMap.put(nums[j], j);
                if (shortMap.size() == windowSize) {
                    shortMap.remove(nums[ptr]);
                    ptr++;
                }
            }

            return false;
        }

        public boolean brokenApproach(int[] nums, int k) {
            // not storing the values leads to more complex conditions

            if (nums.length - 1 < k) { // since i, j have to be distinct
                return false;
            }
            // first window
            for (int i = 0; i <= k; i++) {
                for (int j = i + 1; j <= k; j++) {
                    if (nums[i] == nums[j] && j - i <= k) {
                        return true;
                    }
                }
            }

            for (int i = 1; i < nums.length - k; i++) {
                for (int j = i; j < i + k; j++) {
                    if (nums[j] == nums[j + 1] && j - i <= k) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    public static class ContainsDuplicateIQ1 {
        public static boolean solution(int[] nums) {
            // Input: nums = [1,2,3,1]
            // Output: true
            Set<Integer> set = new HashSet<>();

            for (int i = 0; i < nums.length; i++) {
                int currentNum = nums[i];
                if (set.contains(currentNum)) {
                    return true;
                }
                set.add(currentNum);
            }
            return false;
        }
    }

    public static class FindAllAnagrams {
        static Map<Character, Integer> map = new HashMap<>();
        static Map<Character, Integer> pmap = new HashMap<>();
        public static List<Integer> approach1(String s, String p) {
            // Input: s = "cbaebabacd", p = "abc"
            // Output: [0,6]

            // find p's anagrams in s & return start indices
            // since anagram would have same length as p, implies it could be the size of window
            List<Integer> ans = new ArrayList<>();
            int ptr = 0;
            int lenOfWindow = p.length();

            if (s.length() < lenOfWindow) {
                return ans;
            }

            // Find first window & also add values to pmap
            for (int i = 0; i < lenOfWindow; i++) {
                map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
                pmap.put(p.charAt(i), pmap.getOrDefault(p.charAt(i), 0) + 1);
            }
            if (isAnagram()) {
                ans.add(0);
            }
            for (int j = lenOfWindow; j < s.length(); j++) {
                map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);
                if (map.get(s.charAt(ptr)) > 1) {
                    int value = map.get(s.charAt(ptr)) - 1;
                    map.put(s.charAt(ptr), value);
                } else {
                    map.remove(s.charAt(ptr));
                }
                ptr++;
                if (isAnagram()) {
                    ans.add(j - lenOfWindow + 1);
                }
            }
            return ans;
        }
        static boolean isAnagram() {
            // System.out.println("map: " + map);
            // System.out.println("pmap: " + pmap);
            return map.equals(pmap);
        }
    }

    public static class LongestSubstringWithoutRepeatingCharacters {
        public static int solution(String s) {
            // Input: s = "abcabcbb"
            // Output: 3
            // since we don't know the window size, we can have change the window size on the go and let's start with first element as window
            Map<Character, Integer> map = new HashMap<>();
            int ans = 0;

            // base case
            if (s.length() == 0) {
                return 0;
            }

            int start = 0;
            for (int end = 0; end < s.length(); end++) {
                if (!map.containsKey(s.charAt(end)) || map.get(s.charAt(end)) < start) {
                    map.put(s.charAt(end), end);
                    ans = Math.max(ans, end - start + 1);
                } else {
                    // if the currChar is present in the map then move the start ptr
                    // to the pos after the char that got repeated :)
                    start = map.get(s.charAt(end)) + 1;
                    map.put(s.charAt(end), end); // update map w new index
                }
            }
            return ans;
        }

        public static int approach(String s) {
            // Input: s = "abcabcbb"
            // Output: 3
            int maxLen = 0;
            int left = 0;
            Map<Character, Integer> map = new HashMap<>();

            for (int i = 0; i < s.length(); i++) {
                char currentChar = s.charAt(i);
                map.put(currentChar, map.getOrDefault(currentChar, 0) + 1);
                System.out.println(map);
                while (map.get(currentChar) == 2) {
                    int value = map.get(s.charAt(left)) - 1;
                    map.put(s.charAt(left), value);
                    left++;
                }
                maxLen = Math.max(maxLen, i - left + 1);

            }
            return maxLen;
        }

        public static int brokenApproach(String s) {
            // Input: s = "abcabcbb"
            // Output: 3
            // Why not this: Using set might be a bad idea, as when using the window, we should also know to the index that we would like to move our start ptr :)
            // abcab
            // It's definitely not impossible but why go for broken approach when you can finish it in lesser complexity
            Set<Character> set = new HashSet<>();
            int len = 0;
            int maxLen = 0;

            if (s.length() == 1) {
                return 1;
            }

            for (int i = 0; i < s.length(); i++) {
                char currentChar = s.charAt(i);
                if (set.contains(currentChar)) {
                    set.clear();
                    len = 0;
                }
                set.add(currentChar);
                len++;
                if (len > maxLen) {
                    maxLen = len;
                }
            }
            // maxLen = len;
            // System.out.println(set);
            return maxLen;
        }
    }

    public static class SubstringsOfSizeThreeWithDistinctCharacters {
        static int[] freq = new int[26]; // Given only lower case english letters
        public static int solution(String s) {
            // Input: s = "xyzzaz"
            // Output: 1
            int k = 3;
            int ans = 0;

            if (s.length() < 3) {
                return ans;
            }

            // Get first window
            for (int i = 0; i < k; i++) {
                freq[s.charAt(i) - 'a'] += 1;
            }
            ans += isGood();
            for (int j = k; j < s.length(); j++) {
                freq[s.charAt(j) - 'a'] += 1;
                freq[s.charAt(j - k) - 'a'] -= 1;
                // System.out.println(Arrays.toString(freq));

                ans += isGood();
            }

            return ans;
        }

        private static int isGood() {
            for (int i = 0; i < 26; i++) {
                if (freq[i] > 1) {
                    return 0;
                }
            }
            return 1;
        }
    }

    public static class MaxSumOfkConsecutive {
        public static int solution(int[] arr, int k) {
            int sum = 0, maxSum = 0;
            for (int i = 0; i < k; i++) {
                sum = sum + arr[i];
            }
            maxSum = sum;
            for (int j = k; j <= arr.length - 1; j++) {
                sum = sum + arr[j] - arr[j - k];
                if (sum > maxSum) {
                    maxSum = sum;
                }
            }
            return maxSum;
        }
    }
}
