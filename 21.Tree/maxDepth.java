/*Given the root of a binary tree, return its maximum depth.

A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

Example:
Input: root = [3,9,20,null,null,15,7]
Output: 3
*/

// Definition for a binary tree node.
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
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0; // Base case: empty tree has depth 0
        }

        int maxLeft = maxDepth(root.left);   // Recursively find depth of left subtree
        int maxRight = maxDepth(root.right); // Recursively find depth of right subtree

        return Math.max(maxLeft, maxRight) + 1; // Add 1 for the current node
    }
}

public class maxDepth {
    public static void main(String[] args) {
        /*
         * Constructing the binary tree:
         *         1
         *        / \
         *       2   3
         *      /
         *     4
         *
         * Expected max depth: 3
         */

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2, new TreeNode(4), null);
        root.right = new TreeNode(3);

        Solution sol = new Solution();
        int depth = sol.maxDepth(root);

        System.out.println("Maximum depth of the tree: " + depth);
    }
}

