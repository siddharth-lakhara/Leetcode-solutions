package _114;

public class FlattenBinaryTree {
    private TreeNode currListPointer;

    public void flatten(TreeNode root) {
        this.currListPointer = null;
        if (root == null) {
            return;
        }
        this.addToList(root);
    }

    private void addToList(TreeNode node) {
        TreeNode preservedRightTree = node.right;
        TreeNode preservedLeftTree = node.left;

        if (currListPointer == null) {
            currListPointer = node;
            currListPointer.left = null;
            currListPointer.right = null;
        } else {
            currListPointer.right = node;
            node.right = null;
            node.left = null;
            currListPointer = currListPointer.right;
        }


        if (preservedLeftTree != null) {
            this.addToList(preservedLeftTree);
        }
        if (preservedRightTree != null) {
            this.addToList(preservedRightTree);
        }
    }

    public void driver() {
        TreeNode n3 = new TreeNode(3, null, null);
        TreeNode n4 = new TreeNode(4, null, null);
        TreeNode n2 = new TreeNode(2, n3, n4);

        TreeNode n6 = new TreeNode(6, null, null);
        TreeNode n5 = new TreeNode(5, null, n6);
        TreeNode n1 = new TreeNode(1, n2, n5);
        flatten(n1);
        System.out.println(n1);
    }
}
