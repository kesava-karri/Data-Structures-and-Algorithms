package src;

import java.util.HashMap;
import java.util.Map;

public class Hashing {
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
}
