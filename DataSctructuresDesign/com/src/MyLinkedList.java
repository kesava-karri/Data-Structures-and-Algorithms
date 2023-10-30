package src;


import util.MyLinkedListUtil;

public class MyLinkedList {
    public int val = -1;
    public MyLinkedList next;
    public MyLinkedList() {

    }

    /**
     * int get(int index) Get the value of the indexth node in the linked list.
     * If the index is invalid, return -1.
     * @param index to check the value at a particular position of the linkedList
     * @return the value at given index of the linkedList
     */
    public int get(int index) {
        // index is invalid when it's either negative or greater than length.
        // not adding length case here, since we wouldn't know the length of a linkedList without traversing.
        if (index < 0) return -1;
        int counter = 0;
        MyLinkedList curr = this;
        while (curr != null) {
            if (counter == index) return curr.val;
            curr = curr.next;
            counter++;
        }
        return -1;
    }

    /**
     * Add a node of value val before the first element of the linked list.
     * After the insertion, the new node will be the first node of the linked list.
     * @param val The value that needs to be added to the head of the linked list.
     */
    public void addAtHead(int val) {
        MyLinkedList newHead = new MyLinkedList();
        if (this.next == null && this.val == -1) {
            this.val = val;
        } else {
            // copy the values of this (givenObject) to newHead
            newHead.val = this.val;
            newHead.next = this.next;

            // overwrite the fields of this (givenObject) indirectly changing our head of givenObj
            this.val = val;
            this.next = newHead;
        }
        MyLinkedListUtil.printMyLinkedList(this);
    }

    /**
     * Append a node of value val as the last element of the linked list.
     * @param val The value that needs to be added to the tail of the linked list.
     */
    public void addAtTail(int val) {
        if (this.next == null && this.val == -1) {
            this.val = val;
            return;
        }
        MyLinkedList curr = this;
        while(curr.next != null) {
            curr = curr.next;
        }
        MyLinkedList tailNode = new MyLinkedList();
        curr.next = tailNode;
        tailNode.val = val;
        MyLinkedListUtil.printMyLinkedList(this);
    }

    /**
     * Add a node of value val before the indexth node in the linked list.
     * If index equals the length of the linked list, the node will be appended to the end of the linked list.
     * If index is greater than the length, the node will not be inserted.
     * @param index certain position of the linkedList
     * @param val The value that needs to be added at the index of the linked list.
     */
    public void addAtIndex(int index, int val) {
        if (index == 0) {
            addAtHead(val);
        }  else if (index == 1 && this.next == null) { // can happen when single node exist and also when freshly created node exist
            addAtTail(val);
        } else {
            int counter = 1;
            MyLinkedList prev = this;
            MyLinkedList curr = this.next;
            while (curr != null) {
                if (counter == index) {
                    MyLinkedList newNode = new MyLinkedList();
                    newNode.val = val;

                    prev.next = newNode;
                    newNode.next = curr;
                    return;
                }
                prev = curr;
                curr = curr.next;
                counter++;
            }
            if (index > counter) return;
            addAtTail(val);
        }
        MyLinkedListUtil.printMyLinkedList(this);
    }

    /**
     * Delete the indexth node in the linked list, if the index is valid.
     * @param index at which the node has to be deleted
     */
    public void deleteAtIndex(int index) {
        if (index < 0) return;
        if (index == 0) {
            if (this.next == null) { // indicates only single node is present in the linkedList
                this.val = -1;
            } else {
                MyLinkedList curr = this;
                while (curr.next.next != null) {
                    curr.val = curr.next.val;
                    curr = curr.next;
                }
                curr.val = curr.next.val;
                curr.next = null;
            }
        } else {
            int counter = 1;
            if (this.next == null && index >= counter) return; // if single node & index > counter
            MyLinkedList curr = this.next; // starting from first node since index 0 is already handled above
            MyLinkedList prev = this;
            while (curr.next != null) {
                if (counter == index) {
                    prev.next = curr.next;
                }
                prev = curr;
                curr = curr.next;
                counter++;
            }
            if (counter == index) {
                // If only 2 nodes exist, and if needed to delete the last index
                // or if needed to remove the last node of a larger linked list
                prev.next = null;
            }
        }
        MyLinkedListUtil.printMyLinkedList(this);
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */