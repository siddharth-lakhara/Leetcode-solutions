package _23;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedList {

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode answer = null;
        ListNode tailRef = null;
        
        if (lists == null || lists.length == 0) {
            return null;
        } 

        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(Comparator.comparingInt(node -> node.val));
        Collections.addAll(minHeap, lists);
        
        while (minHeap.size() > 0) {
            ListNode minNode = minHeap.poll();
            if (minNode.next != null) {
                minHeap.add(minNode.next);
            }
            minNode.next = null;
            
            if (answer == null) {
                answer = minNode;
                tailRef = answer;
            } else {
                tailRef.next = minNode;
                tailRef = minNode;    
            }
        }
        return answer;
    }

    public void driver() {
        ListNode node11 = new ListNode(1);
        ListNode node12 = new ListNode(4);
        ListNode node13 = new ListNode(5);
        node11.next = node12;
        node12.next = node13;
        
        ListNode node21 = new ListNode(1);
        ListNode node22 = new ListNode(3);
        ListNode node23 = new ListNode(4);
        node21.next = node22;
        node22.next = node23;
        
        ListNode node31 = new ListNode(2);
        ListNode node32 = new ListNode(6);
        node31.next = node32;
        
        ListNode[] testInput = {node11, node21, node31}; 
        ListNode answer = mergeKLists(testInput);

        System.out.print("[");
        while (answer != null) {
            System.out.print(answer.val + ",");
            answer = answer.next;
        }
        System.out.print("]");
    }

}
