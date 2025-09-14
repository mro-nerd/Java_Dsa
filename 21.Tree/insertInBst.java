/*You are given the root node of a binary search tree (BST) and a value to insert into the tree. Return the root node of the BST after the insertion. It is guaranteed that the new value does not exist in the original BST.

Notice that there may exist multiple valid ways for the insertion, as long as the tree remains a BST after insertion. You can return any of them.

Example 1:

Input: root = [4,2,7,1,3], val = 5
Output: [4,2,7,1,3,5] */
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

public class insertInBst {
    public static TreeNode helper(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (root.val > val) {
            root.left = helper(root.left, val);
        } else {
            root.right = helper(root.right, val);
        }
        return root;
    }

    public static TreeNode insertIntoBST(TreeNode root, int val) {
        return helper(root, val);
    }

    // Utility function to print inorder traversal of BST
    public static void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {
        /*
            Initial Tree:
                    5
                   / \
                  3   7

            Insert sequence: 4, 6, 8

            Final Tree (inorder): 3 4 5 6 7 8
        */

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);

        int[] valuesToInsert = {4, 6, 8};

        for (int val : valuesToInsert) {
            root = insertIntoBST(root, val);
        }

        System.out.print("Inorder traversal of BST after insertions: ");
        inorder(root);
    }
}
