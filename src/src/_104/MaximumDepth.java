package _104;

import java.util.Deque;
import java.util.LinkedList;

public class MaximumDepth {
    private int solve(TreeNode root) {
        int count = 0;
        Deque<TreeNode> queue = new LinkedList<>();
        if (root!=null) {
            queue.add(root);
        }
        while (queue.size() > 0) {
            count++;
            int currLevelLength = queue.size();
            while (currLevelLength > 0) {
                currLevelLength--;
                TreeNode currNode = queue.pop();
                if (currNode.left != null) {
                    queue.add(currNode.left);
                }
                if (currNode.right != null) {
                    queue.add(currNode.right);
                }
            }
        }

        return count;
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
        TreeNode n9 = new TreeNode(9);
        TreeNode n10 = new TreeNode(10);
        TreeNode n11 = new TreeNode(11);

        root.left = n5;
        root.right = n1;

        n1.left = n0;
        n1.right = n8;
        n5.left = n6;
        n5.right = n2;

        n0.right = null;
        n0.left = null;
        n8.right = null;
        n8.left = n10;
        n10.left = n11;
        n10.right = null;
        n11.right = null;
        n11.left = null;
        n6.right = null;
        n6.left = null;
        n2.left = n7;
        n2.right = n4;

        n7.right = n10;
        n7.left = null;
        n4.right = null;
        n4.left = n9;

        int answer = solve(null);
        System.out.println(answer);
    }
}
