import java.util.ArrayList;
import java.lang.String;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class BalancedArrayBonusQ {
    public static int solution(int[] nums) {
        int length = nums.length;
        int result = 0;
        for (int i = 0; i < length; i++) {
            if (i <= (length / 2) - 1) {
                result += nums[i];
            } else {
                result -= nums[i];
            }
        }
        return result < 0 ? -result : result;
    }
}

class FascinatingNumberQ10 {
    public static String altApproach(int n) {
        // Given n should be 3 or more digits
        if (n < 100)
            return "Not Fascinating";
        String concatenatedNum = Integer.toString(n) + Integer.toString(n * 2) + Integer.toString(n * 3);
        Set<Integer> concatenatedNumSet = new HashSet<>();
        for (char letter : concatenatedNum.toCharArray()) {
            int numericValue = Character.getNumericValue(letter);
            if (numericValue != 0) {
                concatenatedNumSet.add(numericValue);
            }
        }

        if (concatenatedNumSet.size() == 9)
            return "Fascinating";
        else
            return "Not Fascinating";
    }

    public static String bruteForce(int n) {
        // Given n should be 3 or more digits
        if (n < 100)
            return "Not Fascinating";
        String concatenatedNum = Integer.toString(n) + Integer.toString(n * 2) + Integer.toString(n * 3);

        int[] countArr = new int[9];
        char[] numberStrings = concatenatedNum.toCharArray();

        for (int i = 0; i < numberStrings.length; i++) {
            int numericValue = Character.getNumericValue(numberStrings[i]);
            if (numericValue > 0) {
                countArr[numericValue - 1] += 1;
            }
        }

        for (int count : countArr) {
            if (count == 0) {
                return "Not Fascinating";
            }
        }
        return "Fascinating";
    }
}

class SumOfSeriesQ9 {
    public static int altApproach(int n) {
        // Math formula for sum of first N natural numbers
        return n * ((n + 1) / 2);
    }

    public static int bruteForce(int n) {
        int i = 0;
        int sum = 0;

        while (i <= n) {
            sum += i;
            i++;
        }
        return sum;
    }
}

class ArrayExceptGreatestTwoQ8 {
    public static ArrayList<Integer> bruteForce(int[] nums) {
        int length = nums.length;
        int temp;
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < length; i++) {
            for (int j = i; j < length; j++) {
                if (nums[i] > nums[j]) {
                    temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }

        for (int i = 0; i < length - 2; i++) {
            result.add(nums[i]);
        }

        return result;
    }

    public static int[] builtins(int[] nums) {
        Arrays.sort(nums);
        return Arrays.copyOfRange(nums, 0, nums.length - 2);
    }
}

class FinalElementQ7 {
    public static int builtins(int[] nums) {
        int length = nums.length;

        Arrays.sort(nums);
        int finalIdx = length % 2 == 0 ? length / 2 - 1 : length / 2;
        return nums[finalIdx];
    }
}

class PalindromeArrayQ6 {
    public static String altApproach(int[] nums) {
        int length = nums.length;
        int last = length - 1;

        for (int i = 0; i < length / 2; i++) {
            if (nums[i] == nums[last]) {
                last--;
                continue;
            } else {
                return "NOT PERFECT";
            }
        }
        return "PERFECT";
    }

    public static String twoPointer(int[] nums) {
        int length = nums.length;
        int last = length - 1;
        for (int i = 0; i < length; i++) {
            if (nums[i] == nums[last]) {
                last--;
            } else if (i == last) {
                return "PERFECT";
            } else {
                return "NOT PERFECT";
            }
        }
        return "PERFECT";
    }
}

class ElementsEqualsIndexValueQ5 {
    public static ArrayList<Integer> bruteForce(int[] nums) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 1; i <= nums.length; i++) {
            if (nums[i - 1] == i)
                result.add(i);
        }
        return result;
    }
}

class AlternateElementsQ4 {
    public static void bruteForce(int[] nums) {
        for (int i = 0; i < nums.length; i += 2) {
            System.out.println(nums[i]);
        }
    }
}

class CountElementsLessThanOrEqualToGivenNumberQ3 {
    public static int bruteForce(int[] A, int X) {
        int count = 0;
        for (int num : A) {
            if (num <= X)
                count++;
        }
        return count;
    }
}

class ElementAtIndexQ2 {
    public static int bruteForce(int[] nums, int key) {
        return nums[key];
    }

    public static int whenArrayList(ArrayList<Integer> nums, int key) {
        return nums.get(key);
    }
}

class SumOfElementsQ1 {
    public static int bruteForce(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }
}

class Main {
    public static void main(String[] args) {
        System.out.println(BalancedArrayBonusQ.solution(new int[] { 1, 5, 3, 2 }));
        System.out.println(BalancedArrayBonusQ.solution(new int[] { 1, 2, 1, 2, 1, 3 }));

        // System.out.println(FascinatingNumberQ10.altApproach(192));
        // System.out.println(FascinatingNumberQ10.altApproach(853));
        // System.out.println(FascinatingNumberQ10.bruteForce(192));
        // System.out.println(FascinatingNumberQ10.bruteForce(853));

        // System.out.println(SumOfSeriesQ9.altApproach(1));
        // System.out.println(SumOfSeriesQ9.bruteForce(5));

        // System.out.println(ArrayExceptGreatestTwoQ8.bruteForce(new int[] { 2, 8, 7, 1, 5 }));
        // System.out.println(ArrayExceptGreatestTwoQ8.bruteForce(new int[] { 7, -2, 3, 4, 9, -1 }));
        // System.out.println(Arrays.toString(ArrayExceptGreatestTwoQ8.builtins(new int[] { 2, 8, 7, 1, 5 })));
        // System.out.println(Arrays.toString(ArrayExceptGreatestTwoQ8.builtins(new int[] { 7, -2, 3, 4, 9, -1 })));

        // System.out.println(FinalElementQ7.builtins(new int[] { 7, 8, 3, 4, 2, 9, 5 }));
        // System.out.println(FinalElementQ7.builtins(new int[] { 8, 1, 2, 9, 4, 3, 7, 5 }));

        // System.out.println(PalindromeArrayQ6.altApproach(new int[] { 1, 2, 3, 2, 1 }));
        // System.out.println(PalindromeArrayQ6.twoPointer(new int[] { 1, 2, 3, 2, 1 }));
        // System.out.println(PalindromeArrayQ6.twoPointer(new int[] { 1, 2, 3, 4, 5 }));

        // System.out.println(ElementsEqualsIndexValueQ5.bruteForce(new int[] { 15, 2, 45, 12, 7 }));
        // System.out.println(ElementsEqualsIndexValueQ5.bruteForce(new int[] { 1 }));

        // AlternateElementsQ4.bruteForce(new int[] { 1, 2, 3, 4 });
        // AlternateElementsQ4.bruteForce(new int[] { 1, 2, 3, 4, 5 });

        // System.out.println(CountElementsLessThanOrEqualToGivenNumberQ3.bruteForce(new
        // int[] { 1, 2, 4, 5, 8, 10 }, 9));
        // System.out.println(CountElementsLessThanOrEqualToGivenNumberQ3.bruteForce(new int[] { 1, 2, 2, 2, 5, 7, 9 }, 2));

        // ArrayList<Integer> arr = new ArrayList<Integer>(Arrays.asList(10, 20, 30, 40, 50, 60, 70));
        // System.out.println(ElementAtIndexQ2.whenArrayList(arr, 4));
        // System.out.println(ElementAtIndexQ2.bruteForce(new int[] { 10, 20, 30, 40, 50}, 2));

        // System.out.println(SumOfElementsQ1.bruteForce(new int[] { 5, 8, 3, 10, 22, 45 }));
    }
}