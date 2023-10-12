package src;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class QueuesAndLinkedList {
    public class RemoveLinkedListElements {
        public ListNode solution(ListNode head, int val) {
            if (head == null) {
                return null;
            }

            ListNode dummy = new ListNode(1357, head); // any random int :)

            ListNode curr = dummy;
            while(curr.next != null) {
                if (curr.next.val == val) {
                    curr.next = curr.next.next;
                    //    curr = curr.next;
                    // Shouldn't move my curr to curr.next 'cause what if the curr.next has also the val we need to delete then we leave that out & check next.val if we move it:)
                } else {
                    curr = curr.next;
                }
            }
            return dummy.next;

        }
        public ListNode brokenApproach(ListNode head, int val) {
            // ListNode prev = null;
            ListNode curr = head;
            ListNode prev = new ListNode(1357, head);

            // while (curr.next != null && prev.next != null) {
            while (prev.next != null) {
                if (prev!=null) System.out.println("1. " + prev.val);
                System.out.println("2. " + curr.val);
                if (curr.val != val) {
                    prev = curr;
                    curr = curr.next;
                    System.out.println("3. " + prev.val);
                    System.out.println("4. " + curr.val);
                    // if (curr.next == null) break;
                } else {
                    if (curr.next != null && curr.next.val == val) {
                        prev = curr;
                        curr = curr.next;
                        head = prev;
                    } else {
                        // if (prev == null) break;
                        prev.next = curr.next;
                        curr = curr.next;
                        System.out.println("5. " + prev.val);
                        if (curr != null) {
                            System.out.println("6. " + curr.val);
                        }
                        // if (curr == null) break;
                    }
                    // if (curr == null) break;
                }
            }
            if (prev.val == val) {
                head = null;
                System.out.println("Head has been reset");
            }
            return head;

        }

        public ListNode previousApproach(ListNode head, int val) {
            if (head == null) return null;
            ListNode curr = head;
            ListNode nextNode = head.next;

            while (nextNode.next != null) {
                if (curr.val == val && nextNode.val == val) {
                    head = nextNode.next;
                } else if (curr.val == val) {
                    curr.next = nextNode;
                    nextNode = nextNode.next;
                }
                curr = nextNode;
                nextNode = nextNode.next;
            }
            return head.val == val ? null : head;
        }
    }
    public class DeleteNodeInALinkedList {
        public void solution(Node node) {
            node.data = node.next.data;
            node.next = node.next.next;
        }
    }
    public class RemoveZeroSumConsecutiveNodes {
        public ListNode solution(ListNode head) {
            int sum = 0;
            ListNode dummy = new ListNode();
            dummy.next = head;
            Map<Integer, ListNode> map = new HashMap<>();

            map.put(0, dummy);
            for (ListNode i = dummy; i != null; i = i.next) {
                sum += i.val;
                map.put(sum, i);
            }
            sum = 0;
            for (ListNode i = dummy; i != null; i = i.next) {
                sum += i.val;
                i.next = map.get(sum).next;
            }
            return dummy.next;
        }

        public ListNode approach(ListNode head) {
            ListNode curr = head;
            List<Integer> arr = new ArrayList<>();
            List<Integer> updatedArr = new ArrayList<>();
            int sum = 0;

            while (curr != null) {
                arr.add(curr.val);
                curr = curr.next;
            }
            updatedArr = arr;
            for (int i = 0; i < updatedArr.size(); i++) {
                for (int j = i; j < updatedArr.size(); j++) {
                    sum += arr.get(j);
                    if (sum == 0) {
                        if (j < updatedArr.size() - 1) {
                            if (i != 0) {
                                updatedArr.subList(i, j + 1).clear();
                            } else {
                                System.out.println("1. " + "i: " + i + " j: " + j + " arr: " + updatedArr);
                                updatedArr = updatedArr.subList(j+1, updatedArr.size());
                                System.out.println("2. " + "i: " + i + " j: " + j + " size: " + updatedArr);
                            }
                        } else if (j == updatedArr.size() - 1) {
                            if (i != 0) {
                                updatedArr = updatedArr.subList(0, i);
                            } else {
                                head = null;
                                return head;
                            }
                        }
                        break;
                    }
                }
                sum = 0;
            }

            head = generateLinkedList(updatedArr.stream().mapToInt(Integer::intValue).toArray());

            return head.val == 0 ? null: head;
        }

        private ListNode generateLinkedList(int[] arr) {
            ListNode head = new ListNode(arr[0]);
            ListNode temp = head;
            for (int i = 1; i < arr.length; i++) {
                ListNode node = new ListNode(arr[i]);
                temp.next = node;
                temp = node;
            }
            return head;
        }
    }
    public class DeleteNNodesAfterMNodes {
        public Node approach(Node head, int m, int n) {
            Node temp = new Node(-1);
            temp.next = head;
            Node newNode = new Node(-1);
            newNode.next = head;

            while (newNode.next != null) {
                for (int i = 0; i < m; i++) {
                    if (temp.next == null) break;
                    temp = temp.next;
                }
                newNode = temp;
                for (int i = 0; i < n; i++) {
                    if (newNode.next == null) break;
                    newNode = newNode.next;
                }
                temp.next = newNode.next;
                temp = newNode;
            }

            return head;
        }
    }
    public class RemoveNthNodeFromEndOfList {
        public ListNode solution(ListNode head, int n) {
            if (head == null) return null; //base case
            ListNode slow = head;
            ListNode fast = head;
            for (int i = 0; i < n; i++) {
                fast = fast.next;
            }
            if (fast == null) return head.next; // edge case
            while (fast.next != null) {
                fast = fast.next;
                slow = slow.next;
            }
            slow.next = slow.next.next; // got to know why not fast
            return head;
        }

        public ListNode brokenApproach1(ListNode head, int n) {
            ListNode prev = new ListNode(1357, head);
            ListNode curr = head;

            int len = 1; // as curr node is starting from first node :)
            while (curr.next != null) {
                curr = curr.next;
                len++;
            }

            int indexToBeRemoved = len - n; // 3    (5-2)
            int count = 0;

            while (count <= indexToBeRemoved) {
                prev = curr;
                curr = curr.next;
                count++;
                if (count == indexToBeRemoved) {
                    prev.next = curr.next;
                    break;
                }
            }
            if (prev == null) {
                return head.next;
            } else {
                prev.next = curr.next;
                return head;
            }
        }

        public ListNode brokenApproach(ListNode head, int n) {
            ListNode prev = new ListNode(1357, head);
            ListNode curr = head;
            ListNode nextNode = head.next;

            int len = 1; // as curr node is starting from first node :)
            while (curr.next != null) {
                curr = curr.next;
                len++;
            }

            if (len == n) {
                head = head.next;
                return head;
            }


            int count = 0;
            int indexToBeRemoved = len - n;

            if (indexToBeRemoved == count) return head.next = null;
            if (nextNode.next == null) {
                head.next = null;
                return head;
            }

            while (nextNode.next != null && indexToBeRemoved != count) {
                prev = curr;
                curr = nextNode;
                nextNode = nextNode.next;
                count++;
            }

            prev.next = nextNode;

            // if (nextNode.next == null) {
            //     head.next = null;
            // }

            return head;
        }
    }

    public class ReverseNodesInKGroup {
        public ListNode approach(ListNode head, int k) {
            ListNode curr = head;
            ListNode prev = null;
            ListNode next = null;

            ListNode startOfGroupHead = head;
            ListNode endOfPrevGroup = new ListNode(1234, head);

            while (curr.next != null) {
                int count = 0;
                curr = startOfGroupHead;
                prev = endOfPrevGroup;
                while (count < k && curr.next != null) {
                    next = curr.next;
                    curr.next = prev;
                    prev = curr;
                    curr = next;
                    count++;
                }
                startOfGroupHead.next = curr;
                endOfPrevGroup.next = prev;
                endOfPrevGroup = startOfGroupHead;
                startOfGroupHead = curr;
            }
            return head;
        }
    }

    public class ReverseLinkedList {
        public ListNode solution(ListNode head) {
            ListNode temp = null;
            ListNode curr = head;
            ListNode prev = null;

            while (curr != null) {
                temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }
            head = prev;
            return head;
        }
    }

    public class LinkedListCycleII {
        public Node solution(Node head) {
            Node tortoise = head;
            Node hare = head;
            // Divide into smaller problems

            // Check if cycle exists
            while (hare != null && hare.next != null) {
                tortoise = tortoise.next;
                hare = hare.next.next;
                if (hare == tortoise) break;
            }

            if (hare == null || hare.next == null) {
                return null;
            } else {
                // If cycle exists find starting Node of the cycle
                hare = head; // move either one of them to head
                while (hare != tortoise) {
                    tortoise = tortoise.next;
                    hare = hare.next; // make 1 jump now
                }
            }
            return hare;
        }
    }

    public class LinkedListCycle {
        // Using Node class as it's similar

        /**
         * Definition for singly-linked list.
         * class ListNode {
         *     int val;
         *     ListNode next;
         *     ListNode(int x) {
         *         val = x;
         *         next = null;
         *     }
         * }
         */
        public boolean solution(Node head) {
            Node tortoise = head;
            Node hare = head;

            while (hare != null && hare.next != null) {
                tortoise = tortoise.next;
                hare = hare.next.next;
                if (tortoise == hare) return true;
            }
            return false;
        }
    }

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
