package daily;

import data.TreeNode;

public class HomeWork03MaxDepth {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int left = maxDepth(root.left);
            int right = maxDepth(root.right);
            return Math.max(left, right) + 1;
        }
    }

    public int maxDepth2(TreeNode root) {
        return getDepth(root, 0);
    }

    private int getDepth(TreeNode treeNode, int level) {
        if (treeNode == null) {
            return level;
        }
        int leftDepth = getDepth(treeNode.left, level + 1);
        int rightDepth = getDepth(treeNode.right, level + 1);
        return leftDepth >= rightDepth ? leftDepth : rightDepth;
    }
}
