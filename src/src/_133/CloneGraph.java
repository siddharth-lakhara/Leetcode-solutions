package _133;

import java.util.ArrayList;
import java.util.HashMap;

public class CloneGraph {
    HashMap<Node, Node> clonedNodes = new HashMap<>();
    
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        
        Node newNode = new Node(node.val);
        clonedNodes.put(node, newNode);
        
        ArrayList<Node> newNeighbors = new ArrayList<>();
        for (Node neighbor : node.neighbors) {
            Node newNeighborNode;
            if (clonedNodes.containsKey(neighbor)) {
                newNeighborNode = clonedNodes.get(neighbor);
            } else {
                newNeighborNode = cloneGraph(neighbor);
            }
            if (newNeighborNode != null) {
                newNeighbors.add(newNeighborNode);    
            }
        }
        newNode.neighbors = newNeighbors;
        
        return newNode;
    }

    public void driver() {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        
        n1.neighbors.add(n2);
        n1.neighbors.add(n4);

        n2.neighbors.add(n1);
        n2.neighbors.add(n3);

        n3.neighbors.add(n2);
        n3.neighbors.add(n4);

        n4.neighbors.add(n1);
        n4.neighbors.add(n3);

        Node results = cloneGraph(n1);

        System.out.println(results.val);
    }

}
