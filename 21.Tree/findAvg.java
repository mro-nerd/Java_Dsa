/*Given the root of a binary tree, return the number of nodes where the value of the node is equal to the average of the values in its subtree.
Note:

The average of n elements is the sum of the n elements divided by n and rounded down to the nearest integer.
A subtree of root is a tree consisting of root and all of its descendants.

Example 1:

Input: root = [4,8,5,0,1,null,6]
Output: 5
Explanation: 
For the node with value 4: The average of its subtree is (4 + 8 + 5 + 0 + 1 + 6) / 6 = 24 / 6 = 4.
For the node with value 5: The average of its subtree is (5 + 6) / 2 = 11 / 2 = 5.
For the node with value 0: The average of its subtree is 0 / 1 = 0.
For the node with value 1: The average of its subtree is 1 / 1 = 1.
For the node with value 6: The average of its subtree is 6 / 1 = 6. */

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

public class findAvg {
    // Field to count nodes where average of subtree equals node value
    public int equals = 0;

    public int averageOfSubtree(TreeNode root) {
        dfs(root);
        return equals;
    }

    // DFS returns [sum of subtree, count of nodes]
    public int[] dfs(TreeNode root) {
        if (root == null) return new int[]{0, 0};

        int[] left = dfs(root.left);
        int[] right = dfs(root.right);

        int nodeSum = left[0] + right[0] + root.val;
        int count = left[1] + right[1] + 1;
        int avg = nodeSum / count;

        if (avg == root.val) equals++;

        return new int[]{nodeSum, count};
    }

    public static void main(String[] args) {
        /*
            Sample Tree:
                    4
                   / \
                  8   5
                 / \   \
                0   1   6

            Subtree averages:
            - Node 0: avg = 0 → ✅
            - Node 1: avg = 1 → ✅
            - Node 8: avg = (8+0+1)/3 = 3 → ❌
            - Node 6: avg = 6 → ✅
            - Node 5: avg = (5+6)/2 = 5 → ✅
            - Node 4: avg = (4+8+0+1+5+6)/6 = 4 → ✅

            Expected output: 5
        */

        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(8, new TreeNode(0), new TreeNode(1));
        root.right = new TreeNode(5, null, new TreeNode(6));

        findAvg sol = new findAvg();
        int count = sol.averageOfSubtree(root);

        System.out.println("Number of nodes where subtree average equals node value: " + count);
    }
}