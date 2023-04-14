package _105;

import java.util.Arrays;

public class ConstructTreePreOrder {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        } else if (preorder.length == 1) {
            return new TreeNode(preorder[0]);
        }
        
        int centralValue = preorder[0];
        int partitionIdx = findIndex(inorder, centralValue);
        
        int[] leftInorder = Arrays.copyOfRange(inorder, 0, partitionIdx);
        int[] rightInorder = Arrays.copyOfRange(inorder, partitionIdx+1, inorder.length);
        
        int[] leftPreorder = Arrays.copyOfRange(preorder, 1, partitionIdx+1);
        int[] rightPreorder = Arrays.copyOfRange(preorder, partitionIdx+1, preorder.length);
        
        TreeNode centralNode = new TreeNode(
                centralValue,
                buildTree(leftPreorder, leftInorder),
                buildTree(rightPreorder, rightInorder)
        );
        
        return centralNode;
    }
    
    private int findIndex(int[] arr, int val) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == val) {
                return i;
            }
        }
        return -1;
    }

    public void driver() {
        int[] inorder = new int[]{9,3,15,20,7};
        int[] preorder = new int[]{3,9,20,15,7};
        
        TreeNode root = buildTree(preorder, inorder);
        System.out.println(root);
    }
}
