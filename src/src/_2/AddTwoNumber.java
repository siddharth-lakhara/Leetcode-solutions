package _2;

public class AddTwoNumber {
    private ListNode solve(ListNode l1, ListNode l2) {
        ListNode resultsHead = new ListNode();
        ListNode resultsRef = resultsHead;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int val1 = l1 != null ? l1.val : 0;
            int val2 = l2 != null ? l2.val : 0;

            int newVal = val1 + val2 + carry;
            carry = Math.floorDiv(newVal, 10);
            newVal %= 10;

            resultsRef.next = new ListNode(newVal);

            l1 = l1 != null ? l1.next : l1;
            l2 = l2 != null ? l2.next : l2;
            resultsRef = resultsRef.next;
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
