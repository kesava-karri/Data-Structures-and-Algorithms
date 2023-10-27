package util;

import org.apache.commons.lang3.StringUtils;

import static java.lang.Math.pow;

public class MyUtilityClass {
    private MyUtilityClass() {}

    public static int productOfInclusiveRange(int a, int b) {
        int product = 1;
        System.out.print("Product of range ["+a+", "+b+"] (inclusive): ");
        for (int i = a; i <= b; i++) {
            product *= i;
        }
        return product;
    }

    public static void printBinaryRepresentation(int p) {
        // Print base 10 & binary representation of range [1, 2^p - 1]
        double end = Math.pow(2, p) - 1;
        for (int i = 1; i <= end; i++) {
            if (i < 10) {
                System.out.print("0"+i+": ");
            } else {
                System.out.print(i+": ");
            }
            String binaryValue = Integer.toBinaryString(i);
            if (binaryValue.length() < p) {
                System.out.println(StringUtils.leftPad(binaryValue, p, "0"));
            } else {
                System.out.println(binaryValue);
            }
        }
    }
}
