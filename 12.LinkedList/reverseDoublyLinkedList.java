/*reverse a doubly linkedlist */

public class reverseDoublyLinkedList {

    public static void main(String[] args) {
        // Create a doubly linked list: 1 <-> 2 <-> 3 <-> 4 <-> 5
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.prev = head;
        head.next.next = new Node(3);
        head.next.next.prev = head.next;
        head.next.next.next = new Node(4);
        head.next.next.next.prev = head.next.next;
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.prev = head.next.next.next;

        // Print the original list
        System.out.println("Original Doubly Linked List:");
        printList(head);

        // Reverse the doubly linked list
        Node reversedHead = reverseDLL(head);

        // Print the reversed list
        System.out.println("Reversed Doubly Linked List:");
        printList(reversedHead);
    }

    // Node class for the doubly linked list
    static class Node {
        int data;
        Node prev;
        Node next;

        Node(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    // Function to reverse a doubly linked list
    public static Node reverseDLL(Node head) {
        // Two pointers: curr for current node, prev for previous node
        Node curr = head;
        Node prev = null;

        // Traverse the list and reverse the next and prev pointers
        while (curr != null) {
            Node next = curr.next;  // Store the next node

            // Reverse the links
            curr.next = prev;
            curr.prev = next;

            // Move prev and curr forward
            prev = curr;
            curr = next;
        }

        // The new head of the reversed list is where prev ends up
        return prev;
    }

    // Helper function to print the doubly linked list
    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
}
