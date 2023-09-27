package src;

class ReverseString {
    public static void approach1(char[] s) {
        recursion(s, 0, s.length - 1);
    }

    private static void recursion(char[] s, int i, int j) {
        if (i >= j) return;
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
        recursion(s, i+1, j-1);
    }
}

class PowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        return divideByTwo(n);
    }

    private boolean divideByTwo(int i) {
        if (i == 0) return false;
        if (i == 1) return true;
        return i % 2 == 0 && divideByTwo(i / 2);
    }
}

class Recursion {
    public static void main (String[] args) {
//        ReverseString.approach1(new char[] {'h','e','l','l','o'});
//        System.out.println(PowerOfTwo.isPowerOfTwo(16));
    }
}