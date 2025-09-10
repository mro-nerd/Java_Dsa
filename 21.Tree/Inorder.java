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

public class Inorder {
    void inorderHelp(TreeNode cur, List<Integer> ans) {
        if (cur == null)
            return;

        // Left
        inorderHelp(cur.left, ans);

        // Cur Node
        ans.add(cur.val);

        // Right
        inorderHelp(cur.right, ans);
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        inorderHelp(root, ans);
        return ans;
    }

    public static void main(String[] args) {
        // Constructing the binary tree:
        //         1
        //          \
        //           2
        //          /
        //         3

        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        Inorder sol = new Inorder();
        List<Integer> result = sol.inorderTraversal(root);

        // Printing the result
        System.out.println("Inorder Traversal: " + result);
    }
}
