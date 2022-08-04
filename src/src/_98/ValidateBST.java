package _98;

public class ValidateBST {

    public boolean isValidBST(TreeNode root) {
        return assertAllNodesBetween(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean assertAllNodesBetween(TreeNode node, long minValue, long maxValue) {
        if (node == null) {
            return true;
        }
        if (!(node.val > minValue && node.val < maxValue)) {
            return false;
        }
        return assertAllNodesBetween(node.left, minValue, node.val)
                && assertAllNodesBetween(node.right, node.val, maxValue);
    }

    public void driver() {
//        [3,1,5,0,2,4,6]
        TreeNode node0 = new TreeNode(0);
        TreeNode node2 = new TreeNode(2);
        TreeNode node1 = new TreeNode(1, node0, node2);
        TreeNode node4 = new TreeNode(4);
        TreeNode node6 = new TreeNode(6);
        TreeNode node5 = new TreeNode(5, node4, node6);

        TreeNode root = new TreeNode(3, node1, node5);
        boolean answer = this.isValidBST(root);
        System.out.println(answer);
    }

}
