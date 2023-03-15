package _25;

import java.util.ArrayList;

public class SwapKNodes {

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummyNode = new ListNode(0, head);
        return recursiveReverseGroups(dummyNode, k);
    }

    private ListNode recursiveReverseGroups(ListNode prevRef, int k) {
        ArrayList<ListNode> chain = new ArrayList<>();
        int chainSize = 0;
        ListNode currNode = prevRef.next;
        
        while (currNode != null && chainSize < k) {
            chain.add(currNode);
            
            currNode = currNode.next;
            chainSize++;
        }
        
        if (chainSize == k) {
//            handle first node
            ListNode nextRef = chain.get(chainSize-1).next;

            for (int idx = chainSize-1; idx > 0; idx--) {
                currNode = chain.get(idx);
                currNode.next = chain.get(idx-1);
            }

            chain.get(0).next = nextRef;
            prevRef.next = chain.get(chainSize-1);
            
            recursiveReverseGroups(chain.get(0), k);
        }
        
        return prevRef.next;
    }
    
    public void driver() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        
        ListNode answer = reverseKGroup(node1, 4);

        System.out.print("[");
        while (answer != null) {
            System.out.print(answer.val + ",");
            answer = answer.next;
        }
        System.out.print("]");
    }

}
