package _206;

public class ReverseLinkedList {

    private ListNode solve(ListNode head) {
        ListNode prevNode = null;
        ListNode currNode = head;
        ListNode temp;
        while (currNode != null) {
            temp = currNode.next;
            currNode.next = prevNode;
            prevNode = currNode;
            currNode = temp;
        }
        head = prevNode;
        return head;
    }

    public void driver() {
        ListNode l15 = new ListNode(5);
        ListNode l14 = new ListNode(4, l15);
        ListNode l13 = new ListNode(3, l14);
        ListNode l12 = new ListNode(2, l13);
        ListNode l11 = new ListNode(1, l12);
        ListNode answer = this.solve(l11);
        System.out.println(answer);
    }

}
