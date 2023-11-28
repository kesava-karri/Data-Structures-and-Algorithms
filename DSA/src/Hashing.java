package src;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import util.MyUtilityClass.Pair;

public class Hashing {
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
}
