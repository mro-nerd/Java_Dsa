/*You are given the root of a full binary tree with the following properties:

Leaf nodes have either the value 0 or 1, where 0 represents False and 1 represents True.
Non-leaf nodes have either the value 2 or 3, where 2 represents the boolean OR and 3 represents the boolean AND.
The evaluation of a node is as follows:

If the node is a leaf node, the evaluation is the value of the node, i.e. True or False.
Otherwise, evaluate the node's two children and apply the boolean operation of its value with the children's evaluations.
Return the boolean result of evaluating the root node.

Input: root = [2,1,3,null,null,0,1]
Output: true
Explanation: The above diagram illustrates the evaluation process.
The AND node evaluates to False AND True = False.
The OR node evaluates to True OR False = True.
The root node evaluates to True, so we return true.*/
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
    public boolean evaluateTree(TreeNode root) {
        if (root.val < 2) {
            return root.val != 0; // 0 = false, 1 = true
        } else if (root.val == 2) {
            return evaluateTree(root.left) || evaluateTree(root.right); // OR
        }
        return evaluateTree(root.left) && evaluateTree(root.right); // AND
    }
}

public class evaluate {
    public static void main(String[] args) {
        /*
         * Constructing the tree:
         *         3
         *        / \
         *       2   1
         *      / \
         *     0   1
         *
         * This represents: (0 OR 1) AND 1 → true
         */

        TreeNode leftSubtree = new TreeNode(2, new TreeNode(0), new TreeNode(1));
        TreeNode rightSubtree = new TreeNode(1);
        TreeNode root = new TreeNode(3, leftSubtree, rightSubtree);

        Solution sol = new Solution();
        boolean result = sol.evaluateTree(root);

        System.out.println("Evaluation result of the tree: " + result);
    }
}

