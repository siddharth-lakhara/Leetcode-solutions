package _141;

import java.util.HashSet;
import java.util.Set;

public class DetectListCycle {

    private boolean solve(ListNode head) {
        Set<ListNode> visitedNodes = new HashSet<>();
        ListNode currNode = head;
        while (currNode != null) {
            if (visitedNodes.contains(currNode)) {
                return true;
            }
            visitedNodes.add(currNode);
            currNode = currNode.next;
        }

        return false;
    }

    public void driver() {
        ListNode l1 = new ListNode(3);
//        ListNode l2 = new ListNode(2);
//        ListNode l3 = new ListNode(0);
//        ListNode l4 = new ListNode(-4);
//        l1.next = l2;
//        l2.next = l3;
//        l3.next = l4;
//        l4.next = l2;
        boolean answer = this.solve(l1);
        System.out.println(answer);
    }

}
