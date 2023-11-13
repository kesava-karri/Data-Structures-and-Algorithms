package tst;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import src.MyLinkedList;
import util.MyLinkedListUtil;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class MyLinkedListTest {
    MyLinkedList myLinkedListSize5;
    MyLinkedList myLinkedListSize1;
    @Before
    public void setup() {
        myLinkedListSize5 = MyLinkedListUtil.generateMyLinkedList(5);
        myLinkedListSize1 = MyLinkedListUtil.generateMyLinkedList(1);
    }

    @Test
    @Ignore
    public void testMany() {
         String[] methodNames = new String[] {"MyLinkedList","addAtHead","addAtHead","addAtHead","addAtIndex",
                 "deleteAtIndex","addAtHead","addAtTail","get","addAtHead","addAtIndex","addAtHead"};
        int[][] nums = new int[][] {{},{7},{2},{1},{3,0},{2},{6},{4},{4},{4},{5,0},{6}};
        List<String> clubbedNames = MyLinkedListUtil.executeAllMethodsWGivenInputs(methodNames, nums);
        System.out.println(clubbedNames);
    }
    @Test
    public void test1() {
        MyLinkedList obj = new MyLinkedList(); MyLinkedListUtil.printMyLinkedList(obj);
        obj.addAtHead(7); MyLinkedListUtil.printMyLinkedList(obj); // 7
        obj.addAtHead(2); MyLinkedListUtil.printMyLinkedList(obj);// 2 7
        obj.addAtHead(1); MyLinkedListUtil.printMyLinkedList(obj);// 1 2 7
        obj.addAtIndex(3, 0); MyLinkedListUtil.printMyLinkedList(obj);// 1 2 7 0
        obj.deleteAtIndex(2); MyLinkedListUtil.printMyLinkedList(obj);// 1 2 0
        obj.addAtHead(6); MyLinkedListUtil.printMyLinkedList(obj);// 6 1 2 0
        obj.addAtTail(4); MyLinkedListUtil.printMyLinkedList(obj);// 6 1 2 0 4
        System.out.println(obj.get(4)); MyLinkedListUtil.printMyLinkedList(obj);// 4
        obj.addAtHead(4); MyLinkedListUtil.printMyLinkedList(obj);// 4 6 1 2 0 4
        obj.addAtIndex(5, 0); MyLinkedListUtil.printMyLinkedList(obj);// 4 6 1 2 0 4 0
        obj.addAtHead(6); MyLinkedListUtil.printMyLinkedList(obj);// 6 4 6 1 2 0 4 0

    }

    @Test
    public void test2() {
        String[] methodNames = {"MyLinkedList","addAtHead","deleteAtIndex","addAtHead","addAtHead","addAtHead","addAtHead","addAtHead","addAtTail","get","deleteAtIndex","deleteAtIndex"};
        int[][] nums = new int[][] {{},{2},{1},{2},{7},{3},{2},{5},{5},{5},{6},{4}};
        List<String> clubbedNames = MyLinkedListUtil.executeAllMethodsWGivenInputs(methodNames, nums);

        MyLinkedList obj = new MyLinkedList(); MyLinkedListUtil.printMyLinkedList(obj);
        obj.addAtHead(2); MyLinkedListUtil.printMyLinkedList(obj);
        obj.deleteAtIndex(1); MyLinkedListUtil.printMyLinkedList(obj);
        obj.addAtHead(2); MyLinkedListUtil.printMyLinkedList(obj);
        obj.addAtHead(7); MyLinkedListUtil.printMyLinkedList(obj);
        obj.addAtHead(3); MyLinkedListUtil.printMyLinkedList(obj);
        obj.addAtHead(2); MyLinkedListUtil.printMyLinkedList(obj);
        obj.addAtHead(5); MyLinkedListUtil.printMyLinkedList(obj);
        obj.addAtTail(5); MyLinkedListUtil.printMyLinkedList(obj);
        System.out.println(obj.get(5)); MyLinkedListUtil.printMyLinkedList(obj);
        obj.deleteAtIndex(6); MyLinkedListUtil.printMyLinkedList(obj);
        obj.deleteAtIndex(4); MyLinkedListUtil.printMyLinkedList(obj);

    }

    @Test
    public void test3() {
        String[] methodNames = {"MyLinkedList","addAtHead","addAtIndex","get","addAtHead","addAtTail","get","addAtTail","get","addAtHead","get","addAtHead"};
        int[][] nums = new int[][] {{},{5},{1,2},{1},{6},{2},{3},{1},{5},{2},{2},{6}};
        List<String> clubbedNames = MyLinkedListUtil.executeAllMethodsWGivenInputs(methodNames, nums);
//        System.out.println(clubbedNames);


        MyLinkedList obj = new MyLinkedList(); MyLinkedListUtil.printMyLinkedList(obj);
        obj.addAtHead(5); obj.addAtIndex(1, 2);
        System.out.println(obj.get(1));; obj.addAtHead(6); obj.addAtTail(2); System.out.println(obj.get(3)); obj.addAtTail(1); System.out.println(obj.get(5)); obj.addAtHead(2); System.out.println(obj.get(2)); obj.addAtHead(6);

    }

    @Test
    public void test4() {
        String[] methodNames = {"MyLinkedList","addAtHead","addAtIndex","get","addAtHead","get","addAtHead","get","get","addAtIndex","addAtTail","addAtHead"};
        int[][] nums = new int[][] {{},{0},{1,1},{2},{4},{2},{4},{2},{3},{1,6},{1},{0}};
        List<String> clubbedNames = MyLinkedListUtil.executeAllMethodsWGivenInputs(methodNames, nums);
//        System.out.println(clubbedNames);

        MyLinkedList obj = new MyLinkedList(); MyLinkedListUtil.printMyLinkedList(obj);
        obj.addAtHead(0); obj.addAtIndex(1, 1); System.out.println(obj.get(2)); obj.addAtHead(4); System.out.println(obj.get(2)); obj.addAtHead(4);

        System.out.println(obj.get(2)); System.out.println(obj.get(3)); obj.addAtIndex(1, 6); obj.addAtTail(1); obj.addAtHead(0);
    }

    @Test
    public void test5() {
        MyLinkedList obj = new MyLinkedList(); MyLinkedListUtil.printMyLinkedList(obj);
        obj.addAtTail(1);
        obj.addAtTail(3);
        System.out.println(obj.get(1));
    }

    @Test
    public void test6() {
        MyLinkedList obj = new MyLinkedList(); MyLinkedListUtil.printMyLinkedList(obj);
        obj.addAtIndex(1, 0);
        System.out.println(obj.get(0));
    }

    @Test
    public void testOverAll() {
        // ["MyLinkedList","addAtHead","addAtTail","addAtIndex","get","deleteAtIndex","get"]
        // [[],[1],[3],[1,2],[1],[1],[1]]
        MyLinkedList o1 = new MyLinkedList();
        MyLinkedListUtil.printMyLinkedList(o1);

        o1.addAtHead(1);
        MyLinkedListUtil.printMyLinkedList(o1);

        o1.addAtTail(3);
        MyLinkedListUtil.printMyLinkedList(o1);

        o1.addAtIndex(1, 2);
        MyLinkedListUtil.printMyLinkedList(o1);

        o1.get(1);
        MyLinkedListUtil.printMyLinkedList(o1);

        o1.deleteAtIndex(1);
        MyLinkedListUtil.printMyLinkedList(o1);

        o1.get(1);
        MyLinkedListUtil.printMyLinkedList(o1);
    }
    @Test
    public void testDeleteAtIndex() {
        // Invalid index
        MyLinkedListUtil.printMyLinkedList(myLinkedListSize5); // 1 2 3 4 5
        myLinkedListSize5.deleteAtIndex(-1);
        MyLinkedListUtil.printMyLinkedList(myLinkedListSize5); // 1 2 3 4 5

        // delete index 0 linked list with single node
        MyLinkedListUtil.printMyLinkedList(myLinkedListSize1);
        myLinkedListSize1.deleteAtIndex(0);
        MyLinkedListUtil.printMyLinkedList(myLinkedListSize1);

        // delete index 0 linked list with multiple nodes
        MyLinkedListUtil.printMyLinkedList(myLinkedListSize5);
        myLinkedListSize5.deleteAtIndex(0);
        MyLinkedListUtil.printMyLinkedList(myLinkedListSize5);

        // delete middle node
        MyLinkedListUtil.printMyLinkedList(myLinkedListSize5);
        myLinkedListSize5.deleteAtIndex(1); // 1 3 4 5
        MyLinkedListUtil.printMyLinkedList(myLinkedListSize5);

        // Delete last node - 2 nodes
        MyLinkedList myLinkedListSize2 = MyLinkedListUtil.generateMyLinkedList(2);
        MyLinkedListUtil.printMyLinkedList(myLinkedListSize2);
        myLinkedListSize2.deleteAtIndex(1);
        MyLinkedListUtil.printMyLinkedList(myLinkedListSize2);

        // Delete last node - multiple nodes
        MyLinkedListUtil.printMyLinkedList(myLinkedListSize5);
        myLinkedListSize5.deleteAtIndex(4);
        MyLinkedListUtil.printMyLinkedList(myLinkedListSize5);
    }
    @Test
    public void testAddAtIndex() {
        MyLinkedListUtil.printMyLinkedList(myLinkedListSize5); // 1 2 3 4 5
        myLinkedListSize5.addAtIndex(0, 10);
        MyLinkedListUtil.printMyLinkedList(myLinkedListSize5); // 10 1 2 3 4 5

        myLinkedListSize5.addAtIndex(3, 20);
        MyLinkedListUtil.printMyLinkedList(myLinkedListSize5); // 10 1 2 20 3 4 5

        myLinkedListSize5.addAtIndex(7, 30);
        MyLinkedListUtil.printMyLinkedList(myLinkedListSize5); // 10 1 2 20 3 4 5 30

        myLinkedListSize5.addAtIndex(10, 40);
        MyLinkedListUtil.printMyLinkedList(myLinkedListSize5); // 10 1 2 20 3 4 5 30

        MyLinkedListUtil.printMyLinkedList(myLinkedListSize1); // 1
        myLinkedListSize1.addAtIndex(0, 10);
        MyLinkedListUtil.printMyLinkedList(myLinkedListSize1); // 10 1

        myLinkedListSize1.addAtIndex(1, 20);
        MyLinkedListUtil.printMyLinkedList(myLinkedListSize1); // 10 20 1

        myLinkedListSize1.addAtIndex(3, 30);
        MyLinkedListUtil.printMyLinkedList(myLinkedListSize1); // 10 20 1 30

        myLinkedListSize1.addAtIndex(10, 40);
        MyLinkedListUtil.printMyLinkedList(myLinkedListSize1); // 10 20 1 30

    }
    @Test
    public void testAddAtTail() {
        MyLinkedListUtil.printMyLinkedList(myLinkedListSize5);
        myLinkedListSize5.addAtTail(20);

        myLinkedListSize1.addAtTail(20);
        MyLinkedListUtil.printMyLinkedList(myLinkedListSize1);
    }
    @Test
    public void testAddAtHead() {
        MyLinkedListUtil.printMyLinkedList(myLinkedListSize5);
        myLinkedListSize5.addAtHead(100);
        MyLinkedListUtil.printMyLinkedList(myLinkedListSize5);

        // Single Node
        myLinkedListSize1.addAtHead(21);
        assertEquals(21, myLinkedListSize1.val);

    }
    @Test
    public void testGetMethod() {
        MyLinkedListUtil.printMyLinkedList(myLinkedListSize5);

        assertEquals(5, myLinkedListSize5.get(4));
    }
    @Test
    public void testMyLinkedList() {
        MyLinkedList obj = new MyLinkedList();
        System.out.println(obj);
        System.out.println(obj.val);
        System.out.println(obj.next);
    }

    /*

    public static MyLinkedList generateMyLinkedListR(int[] arr) {
        MyLinkedList head = new MyLinkedList(arr[0]);
        MyLinkedList temp = head;
        for (int i = 1; i < arr.length; i++) {
            MyLinkedList node = new MyLinkedList(arr[i]);
            temp.next = node;
            temp = node;
        }
        return head;
    }
     */
}
