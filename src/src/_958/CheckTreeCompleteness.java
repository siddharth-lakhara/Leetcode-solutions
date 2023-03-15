package _958;

import java.util.ArrayDeque;
import java.util.Deque;

public class CheckTreeCompleteness {

    public boolean isCompleteTree(TreeNode root) {
        if (root == null) {
            return true;
        }

        Deque<TreeNode> dq = new ArrayDeque<>();
        dq.push(root);
        
        return isLevelComplete(dq, false);
    }

    private boolean isLevelComplete(Deque<TreeNode> dq, boolean checkForNulls) {
        int originalSize = dq.size();
        if (originalSize == 0) {
            return true;
        }
        
        for (int iter = 0; iter < originalSize; iter++) {
            TreeNode node = dq.pop();
            if (!checkForNulls) {
                boolean isChildrenNotNull = (node.left != null && node.right != null);
                if (!isChildrenNotNull) {
                    checkForNulls = true;
                    
                    if (isInvalidNode(node)) {
                        return false;
                    }
                }
            } else {
                boolean isChildrenNull = node.left == null && node.right == null;
                if (!isChildrenNull) {
                    return false;
                }
            }

            if (node.left != null) {
                dq.addLast(node.left);
            }
            if (node.right != null) {
                dq.addLast(node.right);
            }
        }
        
        return isLevelComplete(dq, checkForNulls);
    }

    private boolean isInvalidNode(TreeNode node) {
        if (node.left == null) {
            return node.right != null;
        }
        return false;
    }

    public void driver() {
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
//        TreeNode node6 = new TreeNode(6);

        TreeNode node2 = new TreeNode(2, node4, node5);
//        TreeNode node3 = new TreeNode(3);
        
        TreeNode node1 = new TreeNode(1, node2, null);
         
        boolean answer = isCompleteTree(node1);
        System.out.print(answer);
    }

}
