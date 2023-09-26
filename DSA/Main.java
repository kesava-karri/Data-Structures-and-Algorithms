import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


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
        // System.out.println(SubstringsOfSizeThreeWithDistinctCharacters.solution("xyzzaz"));
        System.out.println(SubstringsOfSizeThreeWithDistinctCharacters.solution("aababcabc"));

        // System.out.println(MaxSumOfkConsecutive.solution(new int[] { 100, 200, 300, 400 }, 2));
    }
}