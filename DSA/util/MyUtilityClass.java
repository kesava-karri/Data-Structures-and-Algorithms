package util;

import org.apache.commons.lang3.StringUtils;
import src.QueuesAndLinkedList;
import src.QueuesAndLinkedList.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.javatuples.Pair;

import static java.lang.Math.pow;

public class MyUtilityClass {
    private MyUtilityClass() {}

    public static void desmosPointsGenerator(List<Integer> arr) {
        List<String> coordinates = new ArrayList<>();
        for (int i = 0; i < arr.size(); i++) {
            coordinates.add("(" + i + ", " + arr.get(i) + ")");
        }
        System.out.println("l = " + coordinates);
        // Use below statements to show only array values as labels on the graph
        System.out.println("Label\n${n}");
        System.out.println("n = f(" + arr + ")");
    }

    public static void print2DArray(int[][] arr) {
        System.out.println(arr.length);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
    }
    public static void visualizeArrays() {
        // continue later;
    }

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

    public static class ListNode {
        public int val;
        public ListNode next;
        public ListNode() {}
        public ListNode(int val) { this.val = val; }
        public ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode generateLinkedListReturnListNode(int[] arr) {
        ListNode head = new ListNode(arr[0]);
        ListNode temp = head;
        for (int i = 1; i < arr.length; i++) {
            ListNode node = new ListNode(arr[i]);
            temp.next = node;
            temp = node;
        }
        return head;
    }

    public static void printLinkedList(ListNode head) {
        System.out.println("\nStart of Linked List");
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
        System.out.println();
        System.out.println("End of Linked List\n");
    }
}
