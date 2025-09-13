/*Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.

Example 1:

Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
Output: [3,9,20,null,null,15,7]

Example 2:

Input: preorder = [-1], inorder = [-1]
Output: [-1] */

import java.util.*;

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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0)
            return null;

        int rootVal = preorder[0];
        TreeNode rootNode = new TreeNode(rootVal);

        // Find root index in inorder array
        int rootId = -1;
        for (int i = 0; i < inorder.length; ++i) {
            if (inorder[i] == rootVal) {
                rootId = i;
                break;
            }
        }

        // Split inorder into left and right
        int[] leftInOrder = Arrays.copyOf(inorder, rootId);
        int[] rightInOrder = Arrays.copyOfRange(inorder, rootId + 1, inorder.length);

        // Split preorder into left and right
        int[] leftPreOrder = Arrays.copyOfRange(preorder, 1, leftInOrder.length + 1);
        int[] rightPreOrder = Arrays.copyOfRange(preorder, leftInOrder.length + 1, preorder.length);

        rootNode.left = buildTree(leftPreOrder, leftInOrder);
        rootNode.right = buildTree(rightPreOrder, rightInOrder);

        return rootNode;
    }
}

public class BtFromTraversals {
    public static void main(String[] args) {
        /*
         * Given:
         * Preorder: [3, 9, 20, 15, 7]
         * Inorder:  [9, 3, 15, 20, 7]
         *
         * Expected Tree:
         *       3
         *      / \
         *     9  20
         *        / \
         *       15  7
         */

        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};

        Solution sol = new Solution();
        TreeNode root = sol.buildTree(preorder, inorder);

        System.out.println("Inorder traversal of constructed tree:");
        printInorder(root);
    }

    // Helper method to print inorder traversal
    public static void printInorder(TreeNode root) {
        if (root == null) return;
        printInorder(root.left);
        System.out.print(root.val + " ");
        printInorder(root.right);
    }
}
