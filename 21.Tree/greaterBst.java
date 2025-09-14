/*Given the root of a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST is changed to the original key plus the sum of all keys greater than the original key in BST.

As a reminder, a binary search tree is a tree that satisfies these constraints:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
 
Example 1:

Input: root = [4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]
Output: [30,36,21,36,35,26,15,null,null,null,33,null,null,null,8] */
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

public class greaterBst {
    int sum;

    greaterBst() {
        sum = 0;
    }

    public void helper(TreeNode root) {
        if (root == null) return;
        helper(root.right);
        sum += root.val;
        root.val = sum;
        helper(root.left);
    }

    public TreeNode bstToGst(TreeNode root) {
        helper(root);
        return root;
    }

    // Utility function to print inorder traversal
    public void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {
        /*
            Original BST:
                    4
                   / \
                  1   6
                 /   / \
                0   5   7
                         \
                          8

            After bstToGst:
            Each node's value becomes the sum of all greater or equal values.

            Inorder traversal of transformed tree should show descending accumulation.
        */

        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(1, new TreeNode(0), null);
        root.right = new TreeNode(6, new TreeNode(5), new TreeNode(7, null, new TreeNode(8)));

        greaterBst sol = new greaterBst();
        TreeNode gstRoot = sol.bstToGst(root);

        System.out.print("Inorder traversal of Greater Sum Tree: ");
        sol.inorder(gstRoot);
    }
}
