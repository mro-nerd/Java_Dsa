import java.util.*;

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

public class preOrder {
    void preorderHelp(TreeNode cur, List<Integer> ans) {
        if (cur == null)
            return;

        // Cur Node
        ans.add(cur.val);

        // Left
        preorderHelp(cur.left, ans);

        // Right
        preorderHelp(cur.right, ans);
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        preorderHelp(root, ans);
        return ans;
    }

    // Main function to test the traversal
    public static void main(String[] args) {
        // Constructing the binary tree:
        //       1
        //        \
        //         2
        //        /
        //       3
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        preOrder sol = new preOrder();
        List<Integer> result = sol.preorderTraversal(root);

        System.out.println("Preorder Traversal: " + result);
    }
}
