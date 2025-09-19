/*Given an integer array nums where the elements are sorted in ascending order, convert it to a height-balanced binary search tree.

Example 1:

Input: nums = [-10,-3,0,5,9]
Output: [0,-3,9,-10,null,5]
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

public class arrayToBst {
    TreeNode helper(int nums[], int l, int r) {
        if (l > r) return null;

        int mid = (l + r) / 2;
        TreeNode root = new TreeNode(nums[mid]);

        root.left = helper(nums, l, mid - 1);
        root.right = helper(nums, mid + 1, r);

        return root;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1);
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
            Input array: [-10, -3, 0, 5, 9]
            Expected BST (balanced):
                    0
                   / \
                -10   5
                  \     \
                 -3     9

            Inorder traversal: -10 -3 0 5 9
        */

        int[] nums = {-10, -3, 0, 5, 9};
        arrayToBst sol = new arrayToBst();
        TreeNode bstRoot = sol.sortedArrayToBST(nums);

        System.out.print("Inorder traversal of BST: ");
        sol.inorder(bstRoot);
    }
}
