package util;

import src.MyLinkedList;

import java.util.ArrayList;
import java.util.List;

public class MyLinkedListUtil {
    public static List<String> executeAllMethodsWGivenInputs (String[] methodNames, int[][] nums) {
        // ["MyLinkedList","addAtHead","addAtHead","addAtHead","addAtIndex","deleteAtIndex","addAtHead","addAtTail","get","addAtHead","addAtIndex","addAtHead"]
        // [[],[7],[2],[1],[3,0],[2],[6],[4],[4],[4],[5,0],[6]]

        List<String> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(methodNames[i]);
            for (int j = 0; j < nums[i].length; j++) {
                sb.append(nums[i][j]);
            }
            list.add(sb.toString());
        }

        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            if (s.equals("MyLinkedList")) {
                list.set(i, "MyLinkedList()");
            } else if (s.startsWith("addAtIndex")) { // "addAtIndex(0, 2)"
                int lastIndex = s.length() - 1;
                list.set(i, "obj.addAtIndex(" + s.charAt(lastIndex - 1) + ", " + s.charAt(lastIndex) + ")");
            } else { // addAtHead, deleteAtIndex, addAtTail, get
                int lastIndex = s.length() - 1;
                list.set(i, "obj." + s.substring(0, lastIndex) + "(" + s.charAt(lastIndex) + ")");
            }
        }
        return list;
    }

    public static void printMyLinkedList(MyLinkedList head) {
        System.out.println("\nStart of Linked List");
        MyLinkedList curr = head;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
        System.out.println();
        System.out.println("End of Linked List\n");
    }


    /**
     * Creates a linkedList of given size with values starting from 1 to size
     * @param size The length of linkedList
     * @return head of MyLinkedList
     */
    public static MyLinkedList generateMyLinkedList(int size) {
        MyLinkedList head = new MyLinkedList();
        MyLinkedList temp = head;
        for (int i = 0; i < size; i++) {
            MyLinkedList obj = new MyLinkedList();
            obj.val = i + 1;
            temp.next = obj;
            temp = obj;
        }
        return head.next;
    }
}