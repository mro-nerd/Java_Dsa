/*Given the root of a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

Example 1:

Input: root = [1,2,3,4,null,null,null,5]

Output: [1,3,4,5]
 */

import java.util.*;

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class rightView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        rightViews(root, result, 0);
        return result;
    }

    public void rightViews(TreeNode curr, List<Integer> result, int currDepth) {
        if (curr == null) return;

        // If this is the first node we're visiting at this depth, it's the rightmost
        if (currDepth == result.size()) {
            result.add(curr.val);
        }

        // Traverse right first to ensure rightmost nodes are visited first
        rightViews(curr.right, result, currDepth + 1);
        rightViews(curr.left, result, currDepth + 1);
    }

    public static void main(String[] args) {
        /*
            Sample Tree:
                    1
                   / \
                  2   3
                   \   \
                    5   4
            Right side view: [1, 3, 4]
        */

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);

        rightView sol = new rightView();
        List<Integer> rightView = sol.rightSideView(root);

        System.out.println("Right Side View of Tree: " + rightView);
    }
}