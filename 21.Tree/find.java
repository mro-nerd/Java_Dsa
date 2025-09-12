/*Given two binary trees original and cloned and given a reference to a node target in the original tree.
The cloned tree is a copy of the original tree.Return a reference to the same node in the cloned tree.

Note that you are not allowed to change any of the two trees or the target node and the answer must be a reference to a node in the cloned tree.

Example 1:

Input: tree = [7,4,3,null,null,6,19], target = 3
Output: 3
*/
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if (cloned == null)
            return null;

        if (cloned.val == target.val)
            return cloned;

        TreeNode ln = getTargetCopy(original, cloned.left, target);
        if (ln != null)
            return ln;

        TreeNode rn = getTargetCopy(original, cloned.right, target);
        return rn;
    }
}

public class find {
    public static void main(String[] args) {
        // Constructing the original binary tree:
        //         1
        //        / \
        //       2   3
        //      /
        //     4

        TreeNode original = new TreeNode(1);
        original.left = new TreeNode(2);
        original.right = new TreeNode(3);
        original.left.left = new TreeNode(4);

        // Constructing the cloned binary tree (same structure and values)
        TreeNode cloned = new TreeNode(1);
        cloned.left = new TreeNode(2);
        cloned.right = new TreeNode(3);
        cloned.left.left = new TreeNode(4);

        // Target node from original tree
        TreeNode target = original.left.left; // Node with value 4

        Solution sol = new Solution();
        TreeNode result = sol.getTargetCopy(original, cloned, target);

        System.out.println("Target node value in cloned tree: " + (result != null ? result.val : "Not found"));
    }
}

