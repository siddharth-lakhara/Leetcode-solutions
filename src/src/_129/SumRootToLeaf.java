package _129;

public class SumRootToLeaf {
    int sum;
    public int sumNumbers(TreeNode root) {
        sum = 0;
        StringBuilder buff = new StringBuilder("");
        sumNumbers(root, buff);
        return sum;
    }
    
    private void sumNumbers(TreeNode node, StringBuilder buff) {
        if (node == null) {
            return;
        }
        
        buff.append(node.val);

//        is leaf node
        if (node.right == null && node.left == null) {
            int num = Integer.parseInt(buff.toString());
            sum += num;
        } else {
            sumNumbers(node.left, buff);
            sumNumbers(node.right, buff);
        }
        
        buff.setLength(
                Math.max(buff.length()-1, 0)
        );
    }

    public void driver() {
        TreeNode node5 = new TreeNode(5);
        TreeNode node1 = new TreeNode(1);
        TreeNode node0 = new TreeNode(0);
        TreeNode node9 = new TreeNode(9, node5, node1);
        TreeNode node4 = new TreeNode(4, node9, node0);
         
        int answer = sumNumbers(node4);

        System.out.print(answer);
    }

}
