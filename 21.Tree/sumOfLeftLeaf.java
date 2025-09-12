/*Given the root of a binary tree, return the sum of all left leaves.

Example 1:

Input: root = [3,9,20,null,null,15,7]
Output: 24
Explanation: There are two left leaves in the binary tree, with values 9 and 15 respectively. */

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
    public int sumOfLeftLeaves(TreeNode root) {
        return dfs(root, false);
    }

    int dfs(TreeNode root, boolean isLeft) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return isLeft ? root.val : 0;
        }

        int sumLeft = dfs(root.left, true);
        int sumRight = dfs(root.right, false); 

        return sumLeft + sumRight;
    }
}

public class sumOfLeftLeaf {
    public static void main(String[] args) {
        /*
         * Constructing the binary tree:
         *         3
         *        / \
         *       9   20
         *          /  \
         *         5   17
         *
         * Left leaves: 9 and 15 → sum = 24
         */

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20, new TreeNode(5), new TreeNode(17));

        Solution sol = new Solution();
        int sum = sol.sumOfLeftLeaves(root);

        System.out.println("Sum of left leaves: " + sum);
    }
}

