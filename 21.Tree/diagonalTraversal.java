/*Given a Binary Tree, return the diagonal traversal of the binary tree.
Consider lines of slope -1 passing between nodes. Given a Binary Tree, return a single list containing all diagonal elements in a binary tree belonging to same line.
If the diagonal element are present in two different subtrees then left subtree diagonal element should be taken first and then right subtree. 

Examples :

Input : root = [8, 3, 10, 1, 6, N, 14, N, N, 4, 7, 13]

Output : [8, 10, 14, 3, 6, 7, 13, 1, 4]
*/

import java.util.*;

// Definition for a binary tree node
class Node {
    int data;
    Node left, right;

    Node(int val) {
        this.data = val;
        this.left = null;
        this.right = null;
    }
}

public class diagonalTraversal {
    public ArrayList<Integer> diagonal(Node root) {
        Queue<Node> cue = new LinkedList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        cue.add(root);

        while (!cue.isEmpty()) {
            Node temp = cue.remove();

            while (temp != null) {
                if (temp.left != null) {
                    cue.add(temp.left);
                }
                ans.add(temp.data);
                temp = temp.right;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        /*
            Sample Tree:
                    8
                   / \
                  3   10
                 / \    \
                1   6    14
                   / \   /
                  4   7 13

            Diagonal Traversal:
            → [8, 10, 14, 3, 6, 7, 13, 1, 4]
        */

        Node root = new Node(8);
        root.left = new Node(3);
        root.right = new Node(10);
        root.left.left = new Node(1);
        root.left.right = new Node(6);
        root.left.right.left = new Node(4);
        root.left.right.right = new Node(7);
        root.right.right = new Node(14);
        root.right.right.left = new Node(13);

        diagonalTraversal tree = new diagonalTraversal();
        ArrayList<Integer> result = tree.diagonal(root);

        System.out.println("Diagonal Traversal of Binary Tree: " + result);
    }
}
