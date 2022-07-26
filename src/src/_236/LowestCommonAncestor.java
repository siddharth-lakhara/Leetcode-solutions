package _236;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class LowestCommonAncestor {
    private TreeNode firstNode;
    private TreeNode secondNode;
    private boolean isFirstNodeFound;
    private boolean isSecondNodeFound;
    private LinkedList<TreeNode> firstNodePath;
    private LinkedList<TreeNode> secondNodePath;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.isFirstNodeFound = false;
        this.isSecondNodeFound = false;
        this.firstNode = p;
        this.secondNode = q;

        this.dfs(root, new LinkedList<>());

        Set<TreeNode> seen = new HashSet<>();
        TreeNode currNode = null;
        while (firstNodePath.size() != 0 && secondNodePath.size() != 0) {
            if (firstNodePath.size() > secondNodePath.size()) {
                currNode = firstNodePath.removeLast();
            } else {
                currNode = secondNodePath.removeLast();
            }

            if (seen.contains(currNode)) {
                break;
            } else {
                seen.add(currNode);
            }
        }

        return currNode;
    }

    private void dfs(TreeNode node, LinkedList<TreeNode> pathSoFar) {
        if (node == null) {
            return;
        }

        pathSoFar.add(node);

        if (!isFirstNodeFound && node.val == firstNode.val) {
            firstNodePath = (LinkedList<TreeNode>) pathSoFar.clone();
            isFirstNodeFound = true;
        }
        if (!isSecondNodeFound && node.val == secondNode.val) {
            secondNodePath = (LinkedList<TreeNode>) pathSoFar.clone();
            isSecondNodeFound = true;
        }

        if (!isFirstNodeFound || !isSecondNodeFound) {
            dfs(node.left, pathSoFar);
        }
        if (!isFirstNodeFound || !isSecondNodeFound) {
            dfs(node.right, pathSoFar);
        }

        pathSoFar.removeLast();
    }

    public void driver() {
        TreeNode root = new TreeNode(3);
        TreeNode n5 = new TreeNode(5);
        TreeNode n1 = new TreeNode(1);
        TreeNode n6 = new TreeNode(6);
        TreeNode n2 = new TreeNode(2);
        TreeNode n0 = new TreeNode(0);
        TreeNode n8 = new TreeNode(8);
        TreeNode n7 = new TreeNode(7);
        TreeNode n4 = new TreeNode(4);

        root.left = n5;
        root.right = n1;

        n1.left = n0;
        n1.right = n8;
        n5.left = n6;
        n5.right = n2;

        n0.right = null;
        n0.left = null;
        n8.right = null;
        n8.left = null;
        n6.right = null;
        n6.left = null;
        n2.left = n7;
        n2.right = n4;

        n7.right = null;
        n7.left = null;
        n4.right = null;
        n4.left = null;

        TreeNode answer = lowestCommonAncestor(root, n7, n8);
        System.out.println(answer.val);
    }
}
