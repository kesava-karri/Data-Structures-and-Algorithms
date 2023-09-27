import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class FindAllAnagrams {
    static Map<Character, Integer> map = new HashMap<>();
    static Map<Character, Integer> pmap = new HashMap<>();
    static List<Integer> approach1(String s, String p) {
        // Input: s = "cbaebabacd", p = "abc"
        // Output: [0,6]

        // find p's anagrams in s & return start indices
        // since anagram would have same same length as p, implies it could be the size of window
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

class LongestSubstringWithoutRepeatingCharacters {
    static int solution(String s) {
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

    static int brokenApproach(String s) {
        // Input: s = "abcabcbb"
        // Output: 3
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

class SubstringsOfSizeThreeWithDistinctCharacters {
    static int[] freq = new int[26]; // Given only lower case english letters
    static int countGoodSubstrings(String s) {
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

class MaxSumOfkConsecutive {
    static int solution(int[] arr, int k) {
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

class Main {
    public static void main(String[] args) {
        // System.out.println(FindAllAnagrams.approach1("aaa", "aaaa"));
        // System.out.println(FindAllAnagrams.approach1("cbaebabacd", "abc"));
        // System.out.println(FindAllAnagrams.approach1("abab", "ab"));
        // System.out.println(FindAllAnagrams.approach1("baa", "aa"));

        // System.out.println(LongestSubstringWithoutRepeatingCharacters.solution("abcabcbb"));
        // System.out.println(LongestSubstringWithoutRepeatingCharacters.solution(" "));
        // System.out.println(LongestSubstringWithoutRepeatingCharacters.solution("au"));
        // System.out.println(LongestSubstringWithoutRepeatingCharacters.solution("aab"));

        // System.out.println(SubstringsOfSizeThreeWithDistinctCharacters.solution("xyzzaz"));
        // System.out.println(SubstringsOfSizeThreeWithDistinctCharacters.solution("aababcabc"));

        // System.out.println(MaxSumOfkConsecutive.solution(new int[] { 100, 200, 300, 400 }, 2));
    }
}