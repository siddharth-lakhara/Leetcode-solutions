package _1448;

public class CountGoodNodes {
    public int goodNodes(TreeNode root) {
        return 1 + countGoodNodes(root.left, root.val) + countGoodNodes(root.right, root.val);
    }

    private int countGoodNodes(TreeNode node, int maxValue) {
        if (node == null) {
            return 0;
        }
        int count = node.val >= maxValue ? 1 : 0;
        return count + countGoodNodes(node.left, Math.max(node.val, maxValue)) + countGoodNodes(node.right, Math.max(node.val, maxValue));
    }

    public void driver() {
        TreeNode node5 = new TreeNode(5);
        TreeNode node1 = new TreeNode(1);
        TreeNode node4 = new TreeNode(4, node1, node5);
        TreeNode node3 = new TreeNode(3);
        TreeNode node1a = new TreeNode(1, node3, null);
        TreeNode root = new TreeNode(3, node1a, node4);
        int answer = goodNodes(root);
        System.out.println(answer);
    }
}
