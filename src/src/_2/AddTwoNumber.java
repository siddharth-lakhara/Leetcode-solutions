package _2;

public class AddTwoNumber {
    private ListNode solve(ListNode l1, ListNode l2) {
        ListNode resultsHead = null;
        ListNode resultsRef = resultsHead;

        int carry = 0;

        ListNode l1Ref = l1;
        ListNode l2Ref = l2;

        while (l1Ref != null && l2Ref != null) {
            int newVal = l1Ref.val + l2Ref.val + carry;
            if (newVal >= 10) {
                newVal %= 10;
                carry = 1;
            } else {
                carry = 0;
            }

            if (resultsHead == null) {
                resultsHead = new ListNode(newVal);
                resultsRef = resultsHead;
            } else {
                ListNode newNode = new ListNode(newVal);
                resultsRef.next = newNode;
                resultsRef = newNode;
            }

            l1Ref = l1Ref.next;
            l2Ref = l2Ref.next;
        }

//        One of the list is not yet over
        if (l1Ref != null || l2Ref != null) {
            if (l1Ref == null) {
                while (l2Ref != null) {
                    int newVal = l2Ref.val + carry;
                    if (newVal >= 10) {
                        newVal %= 10;
                        carry = 1;
                    } else {
                        carry = 0;
                    }

                    ListNode newNode = new ListNode(newVal);
                    resultsRef.next = newNode;
                    resultsRef = newNode;

                    l2Ref = l2Ref.next;
                }
            } else {
                while (l1Ref != null) {
                    int newVal = l1Ref.val + carry;
                    if (newVal >= 10) {
                        newVal %= 10;
                        carry = 1;
                    } else {
                        carry = 0;
                    }

                    ListNode newNode = new ListNode(newVal);
                    resultsRef.next = newNode;
                    resultsRef = newNode;

                    l1Ref = l1Ref.next;
                }
            }
        }

        if (carry > 0) {
            resultsRef.next = new ListNode(carry);
        }

        return resultsHead;
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
