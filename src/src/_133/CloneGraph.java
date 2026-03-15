package _133;

import java.util.HashMap;

public class CloneGraph {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        HashMap<Node, Node> newNodeMap = new HashMap<>();
        return exploreNode(node, newNodeMap);
    }

    public Node exploreNode(Node node, HashMap<Node, Node> newNodeMap) {
//        already explored, simply return the node
        if (newNodeMap.containsKey(node)) {
            return newNodeMap.get(node);
        }

        Node newNode = new Node(node.val);
        newNodeMap.put(node, newNode);

//        explore all neighbors
        for (Node neighbor: node.neighbors) {
            Node newNeighbor = exploreNode(neighbor, newNodeMap);
            newNode.neighbors.add(newNeighbor);
        }

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
