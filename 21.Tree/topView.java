/*You are given a binary tree, and your task is to return its top view. The top view of a binary tree is the set of nodes visible when the tree is viewed from the top.

Note: 

Return the nodes from the leftmost node to the rightmost node.
If two nodes are at the same position (horizontal distance) and are outside the shadow of the tree, consider the leftmost node only. 
Examples:

Input: root[] = [1, 2, 3] 
 
Output: [2, 1, 3]
Input: root[] = [10, 20, 30, 40, 60, 90, 100]
 
Output: [40, 20, 10, 30, 100]
Explanation: The root 10 is visible.
On the left, 40 is the leftmost node and visible, followed by 20.
On the right, 30 and 100 are visible. Thus, the top view is 40 20 10 30 100. */

import java.util.*;

// Node class for the binary tree
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

// Helper Pair class to store node and its column index
class Pair {
    Node node;
    int col;

    Pair(Node a, int b) {
        node = a;
        col = b;
    }
}

class Solution {
    static ArrayList<Integer> topView(Node root) {
        TreeMap<Integer, Integer> colToVal = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));

        while (!q.isEmpty()) {
            Pair p = q.poll();
            Node curNode = p.node;
            int col = p.col;

            if (!colToVal.containsKey(col))
                colToVal.put(col, curNode.data);

            if (curNode.left != null)
                q.add(new Pair(curNode.left, col - 1));

            if (curNode.right != null)
                q.add(new Pair(curNode.right, col + 1));
        }

        ArrayList<Integer> ans = new ArrayList<>();
        for (Map.Entry<Integer, Integer> kv : colToVal.entrySet())
            ans.add(kv.getValue());

        return ans;
    }
}

public class topView {
    public static void main(String[] args) {
        /*
         * Constructing the binary tree:
         *         1
         *        / \
         *       2   3
         *        \   \
         *         4   5
         *
         * Top view: 2 1 3 5
         */

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.right = new Node(4);
        root.right.right = new Node(5);

        ArrayList<Integer> result = Solution.topView(root);

        System.out.println("Top View of the Binary Tree:");
        for (int val : result) {
            System.out.print(val + " ");
        }
    }
}

