package _106;

import java.util.Arrays;

public class ConstructTree {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder.length == 0) {
            return null;
        } else if (postorder.length == 1) {
            return new TreeNode(postorder[0]);
        }
        
        int centralValue = postorder[postorder.length-1];
        int partitionIdx = findIndex(inorder, centralValue);
        
        int[] leftInorder = Arrays.copyOfRange(inorder, 0, partitionIdx);
        int[] rightInorder = Arrays.copyOfRange(inorder, partitionIdx+1, inorder.length);
        
        int[] leftPostorder = Arrays.copyOfRange(postorder, 0, partitionIdx);
        int[] rightPostorder = Arrays.copyOfRange(postorder, partitionIdx, postorder.length-1);
        
        TreeNode centralNode = new TreeNode(
                centralValue,
                buildTree(leftInorder, leftPostorder),
                buildTree(rightInorder, rightPostorder)
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
        int[] postorder = new int[]{9,15,7,20,3};
        
        TreeNode root = buildTree(inorder, postorder);
        System.out.println(root);
    }
}
