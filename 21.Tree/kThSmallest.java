/*Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) of all the values of the nodes in the tree.

Example 1:

Input: root = [3,1,4,null,2], k = 1
Output: 1

Example 2:

Input: root = [5,3,6,2,4,null,null,1], k = 3
Output: 3 
*/

import java.util.*;

// Definition for a binary tree node.
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

public class kThSmallest {
    List<Integer> values = new ArrayList<>();

    public int kthSmallest(TreeNode root, int k) {
        inorder(root);
        return values.get(k - 1);
    }

    private void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        values.add(root.val);
        inorder(root.right);
    }

    // Utility function to print inorder traversal
    public void printInorder(TreeNode root) {
        if (root == null) return;
        printInorder(root.left);
        System.out.print(root.val + " ");
        printInorder(root.right);
    }

    public static void main(String[] args) {
        /*
            Sample BST:
                    5
                   / \
                  3   6
                 / \
                2   4
               /
              1

            Inorder traversal: 1 2 3 4 5 6
            kth smallest for k = 3 → 3
        */

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(1);

        kThSmallest sol = new kThSmallest();
        int k = 3;
        int result = sol.kthSmallest(root, k);

        System.out.println("Inorder traversal of BST:");
        sol.printInorder(root);
        System.out.println("\n" + k + "rd smallest element in BST: " + result);
    }
}