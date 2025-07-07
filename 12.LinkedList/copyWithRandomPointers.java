/*A linked list of length n is given such that each node contains an additional random pointer, which could point to any node in the list, or null.

Construct a deep copy of the list. The deep copy should consist of exactly n brand new nodes, where each new node has its value set to the value of its corresponding original node. Both the next and random pointer of the new nodes should point to new nodes in the copied list such that the pointers in the original list and copied list represent the same list state. None of the pointers in the new list should point to nodes in the original list.

For example, if there are two nodes X and Y in the original list, where X.random --> Y, then for the corresponding two nodes x and y in the copied list, x.random --> y.

Return the head of the copied linked list. */

public class copyWithRandomPointers {
    // Definition for a Node.
static class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val) {
        val = _val;
        next = null;
        random = null;
    }

    public Node(int _val, Node _next, Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
}

    public static Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        // Step 1: Weave the original list with cloned nodes.
        Node ptr = head;
        while (ptr != null) {
            Node newNode = new Node(ptr.val);
            newNode.next = ptr.next;
            ptr.next = newNode;
            ptr = newNode.next;
        }

        // Step 2: Set up the random pointers for the cloned nodes.
        ptr = head;
        while (ptr != null) {
            ptr.next.random = (ptr.random != null) ? ptr.random.next : null;
            ptr = ptr.next.next;
        }

        // Step 3: Unweave the linked list to separate the original and cloned lists.
        Node ptr_old_list = head;
        Node ptr_new_list = head.next;
        Node head_new = head.next;
        while (ptr_old_list != null) {
            ptr_old_list.next = ptr_old_list.next.next;
            ptr_new_list.next = (ptr_new_list.next != null) ? ptr_new_list.next.next : null;
            ptr_old_list = ptr_old_list.next;
            ptr_new_list = ptr_new_list.next;
        }

        return head_new;
    }

    // Function to print the linked list along with random pointers
    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            int randomVal = (temp.random != null) ? temp.random.val : -1;
            System.out.println("Node Value: " + temp.val + ", Random points to: " + randomVal);
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        

        // Creating a list: 7 -> 13 -> 11 -> 10 -> 1
        Node head = new Node(7);
        head.next = new Node(13);
        head.next.next = new Node(11);
        head.next.next.next = new Node(10);
        head.next.next.next.next = new Node(1);

        // Setting up random pointers
        head.random = null;
        head.next.random = head;
        head.next.next.random = head.next.next.next.next;
        head.next.next.next.random = head.next.next;
        head.next.next.next.next.random = head;

        // Printing the original list
        System.out.println("Original List:");
        printList(head);

        // Creating a deep copy of the list
        Node copiedList = copyRandomList(head);

        // Printing the copied list
        System.out.println("Copied List:");
        printList(copiedList);
    }


}
