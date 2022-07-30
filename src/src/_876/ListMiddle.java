package _876;

public class ListMiddle {
    private ListNode solve(ListNode head) {
        ListNode slowPointer = head;
        ListNode fastPointer = head;

        while (fastPointer.next != null && fastPointer.next.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }
//        Handle even length list
        if (fastPointer.next != null) {
            slowPointer = slowPointer.next;
        }
        return slowPointer;
    }

    public void driver() {
        ListNode l16 = new ListNode(6);
        ListNode l15 = new ListNode(5, l16);
        ListNode l14 = new ListNode(4, l15);
        ListNode l13 = new ListNode(3, l14);
        ListNode l12 = new ListNode(2, l13);
        ListNode l11 = new ListNode(1, l12);

        ListNode results = this.solve(l11);
        System.out.println(results.val);
    }

}
