package tst;

import org.junit.Ignore;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import src.Queue1;
import src.Queue1.FindNByKthNodeInLinkedList;
import src.Queue1.LinkedListCycle;
import src.Queue1.MiddleOfTheLinkedList;
import src.Queue1.MinimizeTheSum;
import src.Queue1.Node;
import src.Queue1.TimeNeededToBuyTickets;

// Helper imports
import src.Queue1.ListNode;

public class Queue1Test {
    Queue1 queue1 = new Queue1();
    
    @Test
    public void testLinkedListCycle() {
        int[] arr = new int[] { 3,2,0,-4 };
        Node head = generateLinkedList(arr);
        Node temp = head;
        Node pos = null;
        int i = 0;
        while (temp.next != null) {
            if (arr[i] == 2) {
                pos = temp;
            }
            temp = temp.next;
            i++;
        }

        temp.next = pos;

        LinkedListCycle o1 = queue1.new LinkedListCycle();
        System.out.println(o1.solution(head));
    }

    @Test
    public void testFindNByKthNodeInLinkedList() {
        int[] arr = new int[] { 2, 7, 9, 3, 5 };
        Node head = generateLinkedList(arr);
        /*Node temp1 = head;

        for (int i = 0; i <= arr.length; i++) {
            System.out.println(temp1.data);
            temp1 = temp1.next;
        }*/
        FindNByKthNodeInLinkedList o1 = queue1.new FindNByKthNodeInLinkedList();
        assertEquals(7, o1.solution(head, 3));
    }

    @Test
    public void testMiddleOfTheLinkedList() {
        // arrange
//        int[] arr = new int[] { 1,2,3,4,5 };
        int[] arr = new int[] { 1,2,3,4,5, 6 };
        ListNode head = queue1.new ListNode(arr[0]);
        ListNode temp = head;

        for (int i = 1; i < arr.length; i++) {
            ListNode node = queue1.new ListNode(arr[i]);
            temp.next = node;
            temp = node;
        }

        /*ListNode temp3 = head;

        while (temp3.next != null) {
            System.out.println(temp3.val);
            temp3 = temp3.next;
        }
        System.out.println(temp3.val);
        */
        // act
        MiddleOfTheLinkedList o1 = queue1.new MiddleOfTheLinkedList();
        ListNode resultOfApproachMethod = o1.approach(head);
        ListNode resultOfSolutionMethod = o1.solution(head);

        // assert
        // Odd length
//        assertEquals(3, resultOfApproachMethod.val);
//        assertEquals(3, resultOfSolutionMethod.val);
        // Even length
        assertEquals(4, resultOfApproachMethod.val);
        assertEquals(4, resultOfSolutionMethod.val);
    }

    @Test
    public void testMinimizeTheSum() {
        MinimizeTheSum o1 = queue1.new MinimizeTheSum();
        assertEquals(39, o1.approach(4, new int[] { 1, 4, 7, 10 }));
        assertEquals(0, o1.approach(1, new int[] { 1 }));
    }

    @Test
    public void testTimeNeededToBuyTickets() {
        TimeNeededToBuyTickets o1 = queue1.new TimeNeededToBuyTickets();
        assertEquals(6, o1.approach(new int[] { 2, 3 ,2 }, 2));
        assertEquals(8,o1.approach(new int[] { 5,1,1,1 }, 0));
    }


    private Node generateLinkedList(int[] arr) {
        Node head = queue1.new Node(arr[0]);
        Node temp = head;
        for (int i = 1; i < arr.length; i++) {
            Node node = queue1.new Node(arr[i]);
            temp.next = node;
            temp = node;
        }
        return head;
    }
}

