/*Given the root of a binary tree, determine if it is a valid binary search tree (BST).

A valid BST is defined as follows:
The left subtree of a node contains only nodes with keys strictly less than the node's key.
The right subtree of a node contains only nodes with keys strictly greater than the node's key.
Both the left and right subtrees must also be binary search trees.
 
Example 1:

Input: root = [2,1,3]
Output: true

Example 2:

Input: root = [5,1,4,null,null,3,6]
Output: false 
*/
class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode() {}

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class validBst {
    public boolean helper(TreeNode root, long max, long min) {
        if (root == null) return true;
        if (root.val <= min || root.val >= max) return false;

        return helper(root.left, root.val, min) &&
               helper(root.right, max, root.val);
    }

    public boolean isValidBST(TreeNode root) {
        return helper(root, Long.MAX_VALUE, Long.MIN_VALUE);
    }

    public static void main(String[] args) {
        /*
            Valid BST:
                    5
                   / \
                  3   7
                 /     \
                2       8

            Invalid BST:
                    5
                   / \
                  3   7
                 /     \
                2       6  ← violates BST rule (6 < 7 but in right subtree of 5)

            We'll test both.
        */

        // Valid BST
        TreeNode validRoot = new TreeNode(5);
        validRoot.left = new TreeNode(3, new TreeNode(2), null);
        validRoot.right = new TreeNode(7, null, new TreeNode(8));

        // Invalid BST
        TreeNode invalidRoot = new TreeNode(5);
        invalidRoot.left = new TreeNode(3, new TreeNode(2), null);
        invalidRoot.right = new TreeNode(7, null, new TreeNode(6)); // 6 < 7 but violates BST

        validBst sol = new validBst();

        System.out.println("Is valid BST (should be true): " + sol.isValidBST(validRoot));
        System.out.println("Is valid BST (should be false): " + sol.isValidBST(invalidRoot));
    }
}
