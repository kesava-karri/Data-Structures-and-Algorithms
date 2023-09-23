package src;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Queue1 {

    public class TimeNeededToBuyTickets {
        public int approach(int[] tickets, int k) {
            // Input: tickets = [2,3,2], k = 2
            // Output: 6
            Queue<Integer> q = new LinkedList<>();

            // Add indcies for number of available ppl
            for (int i = 0 ; i < tickets.length; i++) {
                q.add(i);
            }
//            System.out.println(q);
            int t = 0;

            while (!q.isEmpty()) {
                int guyWhoJustSoldHisTicket = q.poll();
                tickets[guyWhoJustSoldHisTicket]--;
                t++;
                if (tickets[guyWhoJustSoldHisTicket] != 0) {
                    q.add(guyWhoJustSoldHisTicket);
                } else {
                    if (guyWhoJustSoldHisTicket == k) break;
                }
                /*
                if (tickets[k] == 0) {
                    break;
                }*/
            }
//            System.out.println(q);
            return t;
        }
    }

    public class MinimizeTheSum {
        /*
        Input:
        N = 4
        arr[] = {1, 4, 7, 10}

        Output: 39
        */
        public int approach(int N, int arr[]) {
            // Priority Queue has the head as the least element with respect to the specified ordering
            // Ascending if no order is specified
            // https://tinyurl.com/head-as-least-element

            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for (int i = 0; i < arr.length; i++) {
                pq.add(arr[i]);
            }
            int sum = 0;


            // Note: Neither the iterator of Priority Queue nor the System.out.println(pq) return the elements in any particular order
            // https://docs.oracle.com/javase/8/docs/api/java/util/PriorityQueue.html#iterator--:~:text=The%20iterator%20does%20not%20return%20the%20elements%20in%20any%20particular%20order.
//            System.out.println(pq);
            while (!pq.isEmpty()) {
                if (pq.size() == 1) break;

                int firstLeast = pq.poll();
                int secondLeast = pq.poll();
                int currSum = firstLeast + secondLeast;
                sum += currSum;

                pq.add(currSum);
            }
            return sum;
        }
    }

    public class MiddleOfTheLinkedList {
        // Tortoise & Hare approach, 1 jump -> 2 jump :)
        public ListNode solution(ListNode head) {
            ListNode tortoise = head;
            ListNode hare = head;
            while (hare != null && hare.next != null) {
                tortoise = tortoise.next;
                hare = hare.next.next;
//                if (hare == null || hare.next == null) break;
            }
            return tortoise;
        }

        // TC : O(n)
        public ListNode approach(ListNode head) {
            ListNode curr = head;
            int len = 0;
            while (curr != null) {
                len++;
                curr = curr.next;
            }

            int mid = len / 2;
            int count = 0;
            curr = head;
            while (count < mid) {
                count++;
                curr = curr.next;
            }
            return curr;
        }
    }

    public class FindNByKthNodeInLinkedList {
        // 2 7 9 3 5
        // 3
        // o/p : 7
        public int solution(Node head, int k) {
            Node dummy = new Node(1357); // any random num
            dummy.next = head;
            Node tortoise = dummy;

            Node hare = head;

            while (hare != null) {
                int count = 0;
                tortoise = tortoise.next;
                while (count < k && hare != null) {
                    hare = hare.next;
                    count++;
                }
            }
            return tortoise.data;
        }
        public int approach(Node head, int k) {
            // Assign a dummy node for slow since 1 based indexing
            Node dummy = new Node(0);
            dummy.next = head;
            Node slow = dummy;
            Node fast = new Node(0);
//            slow = dummy;
            fast = head;
            while (fast != null) {
                slow = slow.next;
                int count = 0;
                while (count < k && fast != null) {
                    count++;
                    fast = fast.next;
                }
            }
            return slow.data;
        }
    }

    // Helper classes
    public class ListNode {
        public int val;
        public ListNode next;
        public ListNode() {}
        public ListNode(int val) { this.val = val; }
        public ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public class Node {
        public int data;
        public Node next;
        public Node(int key) {
            data = key;
            next = null;
        }
    }
}