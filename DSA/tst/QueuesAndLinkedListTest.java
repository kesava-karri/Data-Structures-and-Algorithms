package tst;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import src.QueuesAndLinkedList;
import src.QueuesAndLinkedList.DeleteNNodesAfterMNodes;
import src.QueuesAndLinkedList.FindNByKthNodeInLinkedList;
import src.QueuesAndLinkedList.LinkedListCycle;
import src.QueuesAndLinkedList.MiddleOfTheLinkedList;
import src.QueuesAndLinkedList.MinimizeTheSum;
import src.QueuesAndLinkedList.Node;
import src.QueuesAndLinkedList.RemoveLinkedListElements;
import src.QueuesAndLinkedList.RemoveNthNodeFromEndOfList;
import src.QueuesAndLinkedList.RemoveZeroSumConsecutiveNodes;
import src.QueuesAndLinkedList.TimeNeededToBuyTickets;

// Helper imports
import src.QueuesAndLinkedList.ListNode;

public class QueuesAndLinkedListTest {
    QueuesAndLinkedList queuesAndLinkedList = new QueuesAndLinkedList();

    @Test
    public void testRemoveLinkedListElements() {
        int arr[] = new int[] { 1,2,6,3,4,5,6 };
        ListNode head = generateLinkedListReturnListNode(arr);

        int[] arr2 = new int[] { 7,7,7,7 };
        ListNode head2 = generateLinkedListReturnListNode(arr2);

        RemoveLinkedListElements q6 = queuesAndLinkedList.new RemoveLinkedListElements();
        head = q6.solution(head, 6);
//        head = q6.solution(head2, 7);
        printLinkedList(head);
    }

    @Test
    public void testRemoveZeroSumConsecutiveNodes() {
        int arr[] = new int[] { 1,2,-3,3,1 };
        ListNode head = generateLinkedListReturnListNode(arr);

        int[] arr2 = new int[] { 1,2,3,-3,4 };
        ListNode head2 = generateLinkedListReturnListNode(arr2);

        int[] arr3 = new int[] { 0,1,-1 }; // 1,2,3,-3,-2
        ListNode head3 = generateLinkedListReturnListNode(arr3);

        RemoveZeroSumConsecutiveNodes q3 = queuesAndLinkedList.new RemoveZeroSumConsecutiveNodes();
//        head = q3.approach(head);
        head3 = q3.approach(head3);
        printLinkedList(head3);
    }

    @Test
    public void testDeleteNNodesAfterMNodes() {
        int[] arr = new int[] { 9, 1, 3, 5, 9, 4, 10, 1 };
        Node head = generateLinkedList(arr);

        int[] arr2 = new int[] { 1, 2, 3, 4, 5, 6 };
        Node head2 = generateLinkedList(arr2);

        int[] arr3 = new int[] { 8, 1, 4, 10 };
        Node head3 = generateLinkedList(arr3);

        DeleteNNodesAfterMNodes q2 = queuesAndLinkedList.new DeleteNNodesAfterMNodes();

        Node newHead = q2.approach(head3, 2, 1);
        printLinkedList(newHead);
    }

    @Test
    public void testRemoveNthNodeFromEndOfList() {
        int[] arr = new int[] { 1, 2, 3, 4, 5 };
        int[] arr2 = new int[] { 1, 2 };

        ListNode head = generateLinkedListReturnListNode(arr);
        ListNode head2 = generateLinkedListReturnListNode(arr2);

        RemoveNthNodeFromEndOfList q1 = queuesAndLinkedList.new RemoveNthNodeFromEndOfList();

        printLinkedList(q1.solution(head, 2));

//        printLinkedList(q1.solution(queue1.new ListNode(1, null), 1));

//        printLinkedList(q1.solution(head2, 1));
    }
    
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

        LinkedListCycle o1 = queuesAndLinkedList.new LinkedListCycle();
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
        FindNByKthNodeInLinkedList o1 = queuesAndLinkedList.new FindNByKthNodeInLinkedList();
        assertEquals(7, o1.solution(head, 3));
    }

    @Test
    public void testMiddleOfTheLinkedList() {
        // arrange
//        int[] arr = new int[] { 1,2,3,4,5 };
        int[] arr = new int[] { 1,2,3,4,5, 6 };
        ListNode head = queuesAndLinkedList.new ListNode(arr[0]);
        ListNode temp = head;

        for (int i = 1; i < arr.length; i++) {
            ListNode node = queuesAndLinkedList.new ListNode(arr[i]);
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
        MiddleOfTheLinkedList o1 = queuesAndLinkedList.new MiddleOfTheLinkedList();
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
        MinimizeTheSum o1 = queuesAndLinkedList.new MinimizeTheSum();
        assertEquals(39, o1.approach(4, new int[] { 1, 4, 7, 10 }));
        assertEquals(0, o1.approach(1, new int[] { 1 }));
    }

    @Test
    public void testTimeNeededToBuyTickets() {
        TimeNeededToBuyTickets o1 = queuesAndLinkedList.new TimeNeededToBuyTickets();
        assertEquals(6, o1.approach(new int[] { 2, 3 ,2 }, 2));
        assertEquals(8,o1.approach(new int[] { 5,1,1,1 }, 0));
    }

    private ListNode generateLinkedListReturnListNode(int[] arr) {
        ListNode head = queuesAndLinkedList.new ListNode(arr[0]);
        ListNode temp = head;
        for (int i = 1; i < arr.length; i++) {
            ListNode node = queuesAndLinkedList.new ListNode(arr[i]);
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

    private Node generateLinkedList(int[] arr) {
        Node head = queuesAndLinkedList.new Node(arr[0]);
        Node temp = head;
        for (int i = 1; i < arr.length; i++) {
            Node node = queuesAndLinkedList.new Node(arr[i]);
            temp.next = node;
            temp = node;
        }
        return head;
    }

    private void printLinkedList(Node head) {
        System.out.println("\nStart of Linked List");
        Node curr = head;
        while (curr != null) {
            System.out.println(curr.data);
            curr = curr.next;
        }
        System.out.println("End of Linked List\n");
    }
}

