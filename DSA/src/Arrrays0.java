package src;

import java.util.ArrayList;
import java.util.Arrays;

class FirstEvenNumberQ8 {
    public static int bruteForce(int[] nums) {
        for (int num : nums) {
            if (num % 2 == 0)
                return num;
        }
        return -1;
    }
}

class SumOfElementsQ7 {
    public static int bruteForce(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }

    public static int builtins(int[] nums) {
        return Arrays.stream(nums).sum();
    }
}

class OddElementsQ6 {
    public static ArrayList<Integer> bruteForce(int[] nums) {
        int lengthOfArray = nums.length;

        // For dynamic re-size use ArrayList :)
        ArrayList<Integer> result = new ArrayList<Integer>();

        for (int i = 0; i < lengthOfArray; i++) {
            int currentElement = nums[i];
            if (currentElement % 2 != 0) {
                result.add(currentElement);
            }
        }
        return result;
    }
}

class SeriesQ5 {
    public static void bruteForce(int n) {
        for (int i = n; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                System.out.print(j + 1);
            }
            System.out.println();
        }
    }
}

class SeriesQ4 {
    public static void bruteForce(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(j + 1);
            }
            System.out.println();
        }
    }
}

class MedianElementQ3 {
    public int[] bruteForce(int[] elements) {
        int lengthOfElements = elements.length;
        int temp;

        for (int i = 0; i < lengthOfElements; i++) {
            for (int j = i; j < lengthOfElements; j++) {
                if (elements[i] > elements[j]) {
                    temp = elements[i];
                    elements[i] = elements[j];
                    elements[j] = temp;
                }
            }
        }

        if (lengthOfElements % 2 == 0) {
            return new int[] { elements[lengthOfElements / 2 - 1], elements[lengthOfElements / 2] };
        }
        return new int[] { elements[lengthOfElements / 2] };
    }

    public int usingMinAndMax(int[] elements) {
        int max = new MaxOfThreeQ1().bruteForce(elements);
        int min = new MinOfThreeQ2().bruteForce(elements);
        for (int i = 0; i < elements.length; i++) {
            if (elements[i] != min && elements[i] != max) {
                return elements[i];
            }
        }
        return elements[1];
    }
}

class MinOfThreeQ2 {
    public int bruteForce(int[] elements) {
        int i = 1, temp = 0;
        while (i < elements.length) {
            if (elements[temp] > elements[i]) {
                temp = i;
            }
            i++;
        }
        return elements[temp];
    }
}

class MaxOfThreeQ1 {
    public int bruteForce(int[] elements) {
        int i = 1, temp = 0;

        while (i < elements.length) {
            if (elements[temp] < elements[i]) {
                temp = i;
            }
            i++;
        }
        return elements[temp];
    }
}

class AssignmentQuestions1 {
    public static void main(String[] args) {
        System.out.println(FirstEvenNumberQ8.bruteForce(new int[] { 1, 2, 6, 3, 5 }));
        System.out.println(FirstEvenNumberQ8.bruteForce(new int[] { 1, 7, 9, 3, 5 }));
        System.out.println(FirstEvenNumberQ8.bruteForce(new int[] { 1, 7, 4, 8, 5 }));

        // System.out.println(src.SumOfElementsQ7.builtins(new int[] { 1, 2, 6, 3, 5 }));
        // System.out.println(src.SumOfElementsQ7.bruteForce(new int[] { 1, 2, 6, 3, 5 }));

        // System.out.println(
        // src.OddElementsQ6.bruteForce(new int[] { 1, 5, 6, 4, 3, 2, 8})
        // );

        // src.SeriesQ5.bruteForce(5);

        // src.SeriesQ4.bruteForce(5);

        /*
         * int q3Median = new src.MedianElementQ3().usingMinAndMax(new int[] { 2, 5, 19 });
         * int[] q3Median = new src.MedianElementQ3().bruteForce(new int[] { 10, 30, 20, 40
         * });
         * for (int i : q3Median) {
         * System.out.println(i);
         * }
         */

        // src.MinOfThreeQ2 q2Obj = new src.MinOfThreeQ2();
        // System.out.println(q2Obj.bruteForce(new int[] { 1, 4, 5 }));
        // System.out.println(q2Obj.bruteForce(new int[] { 4, 2, 5 }));
        // System.out.println(q2Obj.bruteForce(new int[] { 4, 5, 3 }));

        // src.MaxOfThreeQ1 q1Obj = new src.MaxOfThreeQ1();
        // System.out.println(q1Obj.bruteForce(new int[] { 1, 2, 10 }));
        // System.out.println(q1Obj.bruteForce(new int[] { 20, 1, 2 }));
        // System.out.println(q1Obj.bruteForce(new int[] { 1, 30, 2 }));
        // System.out.println(q1Obj.bruteForce(new int[] { 1, 24, 124, 315246 }));
    }
}
