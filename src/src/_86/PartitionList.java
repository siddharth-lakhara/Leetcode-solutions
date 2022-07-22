package _86;

public class PartitionList {
    private ListNode solve(ListNode head, int x) {
        ListNode lowerPartitionHead = null;
        ListNode lowerPartitionTail = lowerPartitionHead;
        ListNode upperPartitionHead = null;
        ListNode upperPartitionTail = upperPartitionHead;
        ListNode currNode = head;

        while (currNode != null) {
            if (currNode.val < x) {
                if (lowerPartitionHead == null) {
                    lowerPartitionHead = currNode;
                    lowerPartitionTail = lowerPartitionHead;
                } else {
                    lowerPartitionTail.next = currNode;
                    lowerPartitionTail = lowerPartitionTail.next;
                }
            } else {
                if (upperPartitionHead == null) {
                    upperPartitionHead = currNode;
                    upperPartitionTail = upperPartitionHead;
                } else {
                    upperPartitionTail.next = currNode;
                    upperPartitionTail = upperPartitionTail.next;
                }
            }

            currNode = currNode.next;
        }

        if (lowerPartitionTail != null) {
            lowerPartitionTail.next = upperPartitionHead;
        }
        if (upperPartitionTail != null) {
            upperPartitionTail.next = null;
        }

        return lowerPartitionHead != null ? lowerPartitionHead : upperPartitionHead;
    }

    public void driver() {
        ListNode l16 = new ListNode(2);
        ListNode l15 = new ListNode(5, l16);
        ListNode l14 = new ListNode(2, l15);
        ListNode l13 = new ListNode(3, l14);
        ListNode l12 = new ListNode(4, l13);
        ListNode l11 = new ListNode(1, l12);

        ListNode results = this.solve(l11, 3);
        System.out.println(results);
    }

}
