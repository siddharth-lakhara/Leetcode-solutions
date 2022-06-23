package _2;

public class AddTwoNumber {
    private ListNode solve(ListNode l1, ListNode l2) {
        ListNode resultsHead = new ListNode();
        ListNode resultsRef = resultsHead;
        int carry = 0;

        while (l1 != null || l2 != null) {
            int newVal = carry;
            if (l1 != null) {
                newVal += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                newVal += l2.val;
                l2 = l2.next;
            }

            carry = Math.floorDiv(newVal, 10);
            resultsRef.next = new ListNode(newVal % 10);
            resultsRef = resultsRef.next;
        }

        if (carry > 0) {
            resultsRef.next = new ListNode(carry);
        }

        return resultsHead.next;
    }

    public void driver() {
        ListNode l1 = new ListNode(9);
        ListNode l16 = new ListNode(9);
        ListNode l15 = new ListNode(9, l16);
        ListNode l14 = new ListNode(9, l15);
        ListNode l13 = new ListNode(9, l14);
        ListNode l12 = new ListNode(9, l13);
        ListNode l11 = new ListNode(9, l12);
        l1.next = l11;

        ListNode l2 = new ListNode(9);
        ListNode l23 = new ListNode(9);
        ListNode l22 = new ListNode(9, l23);
        ListNode l21 = new ListNode(9, l22);
        l2.next = l21;

        ListNode results = this.solve(l1, l2);

        System.out.println(results.val);
    }

}
