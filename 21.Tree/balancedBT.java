/*Given a binary tree, determine if it is height-balanced.
A height-balanced binary tree is a binary tree in which the depth of the two subtrees of every node never differs by more than one.

Example 1:

Input: root = [3,9,20,null,null,15,7]
Output: true

Example 2:

Input: root = [1,2,2,3,3,null,null,4,4]
Output: false

Example 3:

Input: root = []
Output: true
  */



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

// Generic Pair class
class Pair<K, V> {
    K key;
    V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}

class Solution {
    Pair<Integer, Boolean> getHeightAndBal(TreeNode cur) {
        if (cur == null)
            return new Pair<>(0, true);

        Pair<Integer, Boolean> left = getHeightAndBal(cur.left);
        Pair<Integer, Boolean> right = getHeightAndBal(cur.right);

        int curHeight = 1 + Math.max(left.getKey(), right.getKey());
        boolean curBal = (left.getValue() && right.getValue() &&
                          Math.abs(left.getKey() - right.getKey()) <= 1);

        return new Pair<>(curHeight, curBal);
    }

    public boolean isBalanced(TreeNode root) {
        Pair<Integer, Boolean> ans = getHeightAndBal(root);
        return ans.getValue();
    }
}

public class balancedBT {
    public static void main(String[] args) {
        /*
         * Constructing the binary tree:
         *         1
         *        / \
         *       2   3
         *      /
         *     4
         *
         * This tree is balanced.
         */

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2, new TreeNode(4), null);
        root.right = new TreeNode(3);

        Solution sol = new Solution();
        boolean result = sol.isBalanced(root);

        System.out.println("Is the tree balanced? " + result);
    }
}

