/*You are given two binary trees root1 and root2.

Imagine that when you put one of them to cover the other, some nodes of the two trees are overlapped while the others are not. You need to merge the two trees into a new binary tree. The merge rule is that if two nodes overlap, then sum node values up as the new value of the merged node. Otherwise, the NOT null node will be used as the node of the new tree.

Return the merged tree.

Example 1:

Input: root1 = [1,3,2,5], root2 = [2,1,3,null,4,null,7]
Output: [3,4,5,5,4,null,7] */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) return t2;
        if (t2 == null) return t1;

        TreeNode node = new TreeNode(t1.val + t2.val);
        node.left = mergeTrees(t1.left, t2.left);
        node.right = mergeTrees(t1.right, t2.right);
        return node;
    }
}

public class mergeBt {
    public static void main(String[] args) {
        /*
         * Tree 1:
         *     1
         *    / \
         *   3   2
         *  /
         * 5
         *
         * Tree 2:
         *     2
         *    / \
         *   1   3
         *    \   \
         *     4   7
         *
         * Merged Tree:
         *     3
         *    / \
         *   4   5
         *  / \   \
         * 5   4   7
         */

        TreeNode t1 = new TreeNode(1,
                        new TreeNode(3,
                            new TreeNode(5),
                            null),
                        new TreeNode(2));

        TreeNode t2 = new TreeNode(2,
                        new TreeNode(1,
                            null,
                            new TreeNode(4)),
                        new TreeNode(3,
                            null,
                            new TreeNode(7)));

        Solution sol = new Solution();
        TreeNode merged = sol.mergeTrees(t1, t2);

        System.out.println("Merged Tree (Preorder Traversal):");
        preorderPrint(merged);
    }

    public static void preorderPrint(TreeNode root) {
        if (root == null) return;
        System.out.print(root.val + " ");
        preorderPrint(root.left);
        preorderPrint(root.right);
    }
}

