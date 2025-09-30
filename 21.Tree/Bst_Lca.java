/*Given a binary search tree (BST), find the lowest common ancestor (LCA) node of two given nodes in the BST.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”

Example 1:

Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
Output: 6
Explanation: The LCA of nodes 2 and 8 is 6.

Example 2:

Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
Output: 2
 
 */
class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int x) {
        val = x;
    }
}

public class Bst_Lca {
    public TreeNode helper(TreeNode root, TreeNode p, TreeNode q) {
        if (root == p || root == q) return root;

        boolean pinL = p.val < root.val;
        boolean qinL = q.val < root.val;

        if (pinL && qinL) {
            return helper(root.left, p, q);
        }
        if (!pinL && !qinL) {
            return helper(root.right, p, q);
        }
        return root;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return helper(root, p, q);
    }

    // Utility function to find a node by value
    public TreeNode find(TreeNode root, int val) {
        if (root == null || root.val == val) return root;
        if (val < root.val) return find(root.left, val);
        return find(root.right, val);
    }

    public static void main(String[] args) {
        /*
            Sample BST:
                    6
                   / \
                  2   8
                 / \ / \
                0  4 7  9
                  / \
                 3   5

            LCA of 2 and 8 → 6
            LCA of 2 and 4 → 2
        */

        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);

        Bst_Lca sol = new Bst_Lca();

        TreeNode p = sol.find(root, 7);
        TreeNode q = sol.find(root, 9);
        TreeNode lca1 = sol.lowestCommonAncestor(root, p, q);
        System.out.println("LCA of 2 and 8: " + (lca1 != null ? lca1.val : "null"));

        p = sol.find(root, 2);
        q = sol.find(root, 4);
        TreeNode lca2 = sol.lowestCommonAncestor(root, p, q);
        System.out.println("LCA of 2 and 4: " + (lca2 != null ? lca2.val : "null"));
    }
}
