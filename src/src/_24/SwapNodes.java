package _24;

public class SwapNodes {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode tempRef = head.next;
        head.next = head.next.next;
        tempRef.next = head;
        head = tempRef;
        
        swapNodes(head.next);
        
        return head;
    }

    private void swapNodes(ListNode prevRef) {
        if (prevRef.next == null || prevRef.next.next == null) {
            return ;
        }
        
        ListNode tempRef = prevRef.next;
        prevRef.next = prevRef.next.next;
        tempRef.next = tempRef.next.next;
        prevRef.next.next = tempRef;
        
        swapNodes(tempRef);
    }

    public void driver() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
//        ListNode node3 = new ListNode(3);
//        ListNode node4 = new ListNode(4);
//        ListNode node5 = new ListNode(5);
//        ListNode node6 = new ListNode(6);
        node1.next = node2;
//        node2.next = node3;
//        node3.next = node4;
//        node4.next = node5;
//        node5.next = node6;
        
        ListNode answer = swapPairs(node1);

        System.out.print("[");
        while (answer != null) {
            System.out.print(answer.val + ",");
            answer = answer.next;
        }
        System.out.print("]");
    }

}
