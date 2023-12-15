package src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import util.MyUtilityClass.ListNode;
import util.MyUtilityClass.Pair;

public class Hashing {

    public class WordLadder {
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            // whenever shortest path is asked think about the shortest path algorimths like BFS
            Set<String> set = new HashSet<>();
            set.addAll(wordList);
            if (!set.contains(endWord)) return 0;

            Queue<String> q = new LinkedList<>();
            q.add(beginWord);

            Set<String> visited = new HashSet<>();
            visited.add(beginWord);

            int ans = 1; // number of changes

            while (!q.isEmpty()) {
                int size = q.size();
                for (int i = 0; i < size; i++) {
                    String word = q.poll();
                    if (word.equals(endWord)) return ans;
                    for (int j = 0; j < word.length(); j++) {
                        for (int k = 'a'; k <= 'z'; k++) {
                            char[] arr = word.toCharArray();
                            arr[j] = (char) k;
                            String str = new String(arr);
                            if(set.contains(str) && !visited.contains(str)) {
                                q.add(str);
                                visited.add(str);
                            }
                        }
                    }
                }
                ans++;
            }
            return 0;
        }
    }

    public class FairCandySwap {
        public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
            int aSum = Arrays.stream(aliceSizes).sum();
            int bSum = Arrays.stream(bobSizes).sum();
            int[] ans = new int[2];
            // splitting the extra candies should be enough :)
            int extras = (aSum - bSum) / 2;

            HashSet<Integer> set = new HashSet<>();
            for (int num : aliceSizes) set.add(num);
            for (int num : bobSizes) {
                if (set.contains(num + extras)) {
                    ans[0] = num + extras;
                    ans[1] = num;
                    return ans;
                }
            }
            return ans;
        }
    }

    public class SubstringWConcatenationOfAllWords {
        public List<Integer> findSubstring(String s, String[] words) {
            // s = "barfoothefoobarman"
            // words = ["foo","bar"]
            List<Integer> ans = new ArrayList<>();

            int wordLen = words[0].length();
            int n = words.length;
            int total = n * wordLen; // len of each substring
            int k = 0;

            if (s.length() < total) return ans;

            HashMap<String, Integer> freq = new HashMap<>();
            for (int j = 0; j < n; j++) {
                freq.put(words[j], freq.getOrDefault(words[j], 0) + 1);
            }

            outerLoop:
            for (int i = 0; i < s.length() - total + 1; i++) {
                HashMap<String, Integer> mp = new HashMap<>();
                mp.putAll(freq);

                // get substring from s of word length  & check if it exits in our words
                // when all words match our substrings that is our match, so note the index
                // else continue to next char
                for (k = 0; k < n; k++) {
                    // substring starting from index i
                    String temp = s.substring(i + k * wordLen, i + (k + 1) * wordLen);
                    if (mp.get(temp) == null) {
                        continue outerLoop;
                    } else {
                        if (mp.get(temp) != 0) { // for repeated words
                            mp.put(temp, mp.get(temp) - 1);
                        } else {
                            continue outerLoop;
                        }
                    }
                }
                if (k == n) {
                    ans.add(i);
                }
            }
            return ans;
        }

        public List<Integer> brokenApproach(String s, String[] words) {
            // create all substrings & store in map
            Set<String> set = new HashSet<>();
            List<Integer> ans = new ArrayList<>();
            for (int i = 0; i < words.length; i++) {

                StringBuilder sb = new StringBuilder(words[i]);
                for (int j = 0; j < words.length; j++) {
                    if (j != i) {
                        sb.append(words[j]);
                    }
                    System.out.println(sb.toString());
                }
                set.add(sb.toString());
            }
            System.out.println(set);
            Iterator<String> iterator = set.iterator();
            while (iterator.hasNext()) {
                String item = iterator.next();
                int index = s.lastIndexOf(item);
                if (index != -1) {
                    ans.add(index);
                }

            }

            // iterate over String s & find if each substring is available
            // for (int i = 0; i < s.length(); i++) {
            //     set.contains(s)
            // }

            // Note start indices & return them as list
            return ans;
        }
    }

    public class VerifyingAlienDictionary {
        public boolean isAlienSorted(String[] words, String order) {
            Map<Character, Integer> linkedHashMap = new LinkedHashMap();
            // LinkedHashMap to preserve the order
            for (int i = 0; i < order.length(); i++) {
                linkedHashMap.put(order.charAt(i), i + 1);
            }

            for (int i = 0; i < words.length - 1; i++) {
                int p = 0;
                String first = words[i];
                String second = words[i + 1];

                while (p < first.length() && p < second.length()) {
                    char one = first.charAt(p);
                    char two = second.charAt(p);
                    if (linkedHashMap.get(one) < linkedHashMap.get(two)) break; // check the next words
                    else if (linkedHashMap.get(one) == linkedHashMap.get(two)) {
                        p++;
                    }
                    else return false; // linkedHashMap.get(one) > linkedHashMap.get(two)
                }
                if (p == second.length() && p < first.length()) {
                    return false;
                }
            }
            return true;
        }
    }

    public class SubArrayWSumZero {
        public boolean solution(int arr[],int n) {
            HashMap<Integer, Boolean> map = new HashMap<>();
            int sum = 0;

            for (int i = 0; i < arr.length; i++) {
                map.put(sum, true);
                sum +=arr[i];
                if (map.get(sum) != null && map.get(sum) == true) return true;
            }
            return false;
        }

        public boolean altApproach(int arr[],int n) {
            int[] prefixSum = new int[n];
            prefixSum[0] = arr[0];

            // calculate prefix-sum
            for (int i = 1; i < n; i++) {
                prefixSum[i] = prefixSum[i - 1] + arr[i];
            }

            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                if (prefixSum[i] == 0
                        || arr[i] == 0
                        || map.containsKey(prefixSum[i])) return true;

                map.put(prefixSum[i], 1);
            }
            return false;
        }
    }

    public class LargestSubArrayWSumZero {
        public int maxLen(int arr[], int n) {
            Map<Integer, Integer> mpp = new HashMap<>();

            int sum = 0, ans = 0;

            for (int i = 0; i < n; i++) {
                sum += arr[i];
                if (sum == 0) ans = Math.max(ans, i + 1);
                else {
                    if (mpp.get(sum) == null) {
                        mpp.put(sum, i + 1);
                    } else {
                        ans = Math.max(ans, (i + 1) - mpp.get(sum));
                    }
                }
            }
            return ans;
        }

        public int brokenApproach(int arr[], int n) {
            int ans = 0;
            int[] prefix = new int[n];
            prefix[0] = arr[0];

            for (int i = 1; i < n; i++) {
                prefix[i] = prefix[i - 1] + arr[i];
            }

            Map<Integer, Integer> map = new HashMap<>();

            for (int i = 0; i < n; i++) {
                if (prefix[i] == 0
                        || arr[i] == 0) {
                    ans = 1;
                }
                if (map.containsKey(prefix[i])) {
                    ans = Math.max(i, ans);
                } else {
                    map.put(prefix[i], 1);
                }
            }
            return ans;
        }
    }

    public class ConsecutiveArrayEle {
        public boolean areConsecutives(long arr[], int N) {
            Set<Long> set = new HashSet<>();
            long min = arr[0], max = arr[0];

            for (int i = 0; i < N; i++) {
                long num = arr[i];
                 if (set.contains(num)) return false;
                min = Math.min(num, min);
                max = Math.max(num, max);
                set.add(num);
            }

            long range = (max - min + 1);
            return (int)range == set.size();
        }
    }

    public class MaxPointsOnALine {
        public int maxPoints(int[][] points) {
            int ans = 0;
            for (int i = 0; i < points.length; i++) {
                Map<Pair<Integer, Integer>, Integer> map = new HashMap<>();
                int count = 0;
                for (int j = 0; j < points.length; j++) {
                    if (j != i) {
                        int num = points[j][1] - points[i][1];
                        int den = points[j][0] - points[i][0];

                        int g = gcd(num, den);
                        num /= g;
                        den /= g;

                        if (den == 0) num = 1;
                        else if (den < 0) num = -1 * num;
                        if (num == 0) den = 1;

                        Pair pair = new Pair(num, den);
                        map.put(pair, map.getOrDefault(pair, 0) + 1);
                        count = Math.max(count, map.get(pair));
                    }
                }
                ans = Math.max(ans, count + 1);
            }
            return ans;
        }

        private int gcd(int n1, int n2) {
            if (n2 == 0) {
                return n1;
            }
            return gcd(n2, n1 % n2);
        }
    }

    public class LinkedListCycle {
        public boolean hasCycle(ListNode head) {
            Set<ListNode> set = new HashSet<>();
            while (head != null) {
                if (set.contains(head)) return true;
                set.add(head);
                head = head.next;
            }
            return false;
        }
    }

    class DestinationCity {
        public String destCity(List<List<String>> paths) {
            Map<String, String> mp = new HashMap<>();
            StringBuilder ans = new StringBuilder();
            paths.forEach(path -> {
                mp.put(path.get(0), path.get(1));
            });

            mp.entrySet().forEach(set -> {
                if (mp.get(set.getValue()) == null) {
                    ans.append(set.getValue());
                }
            });
            return ans.toString();
        }
    }
}
