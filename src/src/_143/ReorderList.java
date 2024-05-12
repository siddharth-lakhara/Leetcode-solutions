package _143;

import java.util.Stack;

public class ReorderList {
    public void reorderList(ListNode head) {
        ListNode headPtr = head;
        Stack<ListNode> prevNodeRef = new Stack<>();

        ListNode tailPtr = head;
        while (tailPtr.next != null) {
            prevNodeRef.push(tailPtr);
            tailPtr = tailPtr.next;
        }

        while (headPtr != tailPtr && headPtr.next != tailPtr) {
            ListNode prevNextRef = headPtr.next;
            headPtr.next = tailPtr;
            tailPtr.next = prevNextRef;

            headPtr = prevNextRef;

            prevNodeRef.peek().next = null;
            tailPtr = prevNodeRef.pop();
        }
    }

    public void driver() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        reorderList(n1);

        System.out.println(n1);
    }

}
