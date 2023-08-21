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

class Main {

    public static void main(String[] args) {
        // int q3Median = new MedianElementQ3().usingMinAndMax(new int[] { 2, 5, 19 });
        int[] q3Median = new MedianElementQ3().bruteForce(new int[] { 10, 30, 20, 40 });
        for (int i : q3Median) {
            System.out.println(i);
        }

        MinOfThreeQ2 q2Obj = new MinOfThreeQ2();
        // System.out.println(q2Obj.bruteForce(new int[] { 1, 4, 5 }));
        // System.out.println(q2Obj.bruteForce(new int[] { 4, 2, 5 }));
        // System.out.println(q2Obj.bruteForce(new int[] { 4, 5, 3 }));

        MaxOfThreeQ1 q1Obj = new MaxOfThreeQ1();
        // System.out.println(q1Obj.bruteForce(new int[] { 1, 2, 10 }));
        // System.out.println(q1Obj.bruteForce(new int[] { 20, 1, 2 }));
        // System.out.println(q1Obj.bruteForce(new int[] { 1, 30, 2 }));
        // System.out.println(q1Obj.bruteForce(new int[] { 1, 24, 124, 315246 }));
    }
}