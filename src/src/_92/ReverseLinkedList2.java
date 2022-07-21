package _92;

public class ReverseLinkedList2 {

    private ListNode solve(ListNode head, int left, int right) {
        ListNode revStartNode = null;
        ListNode leftNode = null;
        ListNode rightNode = null;
        ListNode prevNode = null;

//        find left node
        ListNode currNode = head;
        int count = 1;
        while (currNode != null) {
            if (count == left) {
                leftNode = currNode;
                break;
            } else {
                revStartNode = currNode;
                currNode = currNode.next;
                count++;
            }
        }

//        find right node
        while (currNode != null) {
            if (count == right) {
                rightNode = currNode;
                prevNode = currNode.next;
                break;
            }
            currNode = currNode.next;
            count++;
        }

//        if nodes not found
        if (leftNode == null || rightNode == null) {
            return head;
        }

//        reverse
        ListNode nextNode = null;
        while (leftNode != rightNode) {
            nextNode = leftNode.next;
            leftNode.next = prevNode;
            prevNode = leftNode;
            leftNode = nextNode;
        }
        rightNode.next = prevNode;
        if (revStartNode != null) {
            revStartNode.next = rightNode;
        } else {
            head = rightNode;
        }
        return head;
    }

    public void driver() {
        ListNode l15 = new ListNode(5);
//        ListNode l14 = new ListNode(4, l15);
        ListNode l13 = new ListNode(3, l15);
//        ListNode l12 = new ListNode(2, l13);
//        ListNode l11 = new ListNode(1, l12);
        ListNode answer = this.solve(l13, 1, 2);
        System.out.println(answer);
    }

}
