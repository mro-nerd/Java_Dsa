/*Given a binary tree root, return the maximum sum of all keys of any sub-tree which is also a Binary Search Tree (BST).

Example 1:

Input: root = [1,4,3,2,4,2,5,null,null,null,null,null,null,4,6]
Output: 20

Example 2:

Input: root = [4,3,null,1,2]
Output: 2
 
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

// Helper class to store subtree info
class NodeValue {
    int minNode, maxNode, sum;
    boolean isBST;

    NodeValue(int minNode, int maxNode, int sum, boolean isBST) {
        this.minNode = minNode;
        this.maxNode = maxNode;
        this.sum = sum;
        this.isBST = isBST;
    }
}

public class maxSumBst {
    int maxSum = 0;

    private NodeValue helper(TreeNode root) {
        if (root == null) {
            return new NodeValue(Integer.MAX_VALUE, Integer.MIN_VALUE, 0, true);
        }

        NodeValue left = helper(root.left);
        NodeValue right = helper(root.right);

        if (left.isBST && right.isBST && root.val > left.maxNode && root.val < right.minNode) {
            int currSum = left.sum + right.sum + root.val;
            maxSum = Math.max(maxSum, currSum);
            return new NodeValue(
                Math.min(root.val, left.minNode),
                Math.max(root.val, right.maxNode),
                currSum,
                true
            );
        }

        return new NodeValue(Integer.MIN_VALUE, Integer.MAX_VALUE, 0, false);
    }

    public int maxSumBST(TreeNode root) {
        helper(root);
        return maxSum;
    }

    public static void main(String[] args) {
        /*
            Sample Tree:
                    1
                   / \
                  3   3
                 / \
                2   4

            The subtree rooted at 4 (with children 2 and 4) is a valid BST with sum = 10.
            The subtree rooted at 3 is a valid BST with sum = 3.
            The subtree rooted at 1 is not a BST.

            Expected output: 10
        */

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3, new TreeNode(2), new TreeNode(4));
        root.right = new TreeNode(3);

        maxSumBst sol = new maxSumBst();
        int result = sol.maxSumBST(root);

        System.out.println("Maximum sum of any BST subtree: " + result);
    }
}
