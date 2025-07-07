/*reverse a singly linked list */

public class reverseLinkedList {

    public static void main(String[] args) {
        // Create a linked list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        // Print original list
        System.out.println("Original Linked List:");
        printList(head);

        // Reverse the linked list
        ListNode reversedHead = reverseList(head);

        // Print reversed list
        System.out.println("Reversed Linked List:");
        printList(reversedHead);
    }

    // ListNode class
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    // Function to reverse a linked list
    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            // store the address of the next node
            ListNode temp = curr.next;
            // make the current node point to prev
            curr.next = prev;
            // move prev and curr one step forward
            prev = curr;    
            curr = temp;
        }

        return prev; // prev becomes the new head
    }

    // Helper function to print the linked list
    public static void printList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
}
