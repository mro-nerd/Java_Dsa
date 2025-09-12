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

public class postOrder {
    void postoderHelp(TreeNode cur, List<Integer> ans) {
        if (cur == null)
            return;

        // Left
        postoderHelp(cur, ans);

        // Right
        postoderHelp(cur, ans);

         // Cur Node
        ans.add(cur.val);
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        postoderHelp(root, ans);
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

        postOrder sol = new postOrder();
        List<Integer> result = sol.postorderTraversal(root);

        System.out.println("Preorder Traversal: " + result);
    }
}
