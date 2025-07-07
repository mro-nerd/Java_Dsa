/*rotate the list towards right for k places */

public class rotateList {
   
static class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}


    // Helper method to calculate the size of the linked list
    public static int size(ListNode head) {
        int s = 0;
        while (head != null) {
            s++;
            head = head.next;
        }
        return s;
    }

    public static ListNode rotateRight(ListNode head, int k) {
        // Handle edge cases
        if (head == null || head.next == null || k == 0) return head;

        int s = size(head);
        k %= s; // Normalize k to avoid unnecessary rotations
        if (k == 0) return head; // No rotation needed

        int go = s - k - 1; // Find the new tail position
        ListNode temp = head;
        for (int i = 0; i < go; i++) {
            temp = temp.next;
        }

        ListNode start = temp.next; // The new head after rotation
        temp.next = null; // Break the link to form the new list

        // Connect the old tail to the old head
        temp = start;
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = head; // Complete the rotation
        return start; // Return the new head
    }

    public static void main(String[] args) {
        // Creating a linked list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        
        int k = 18; // Rotate the list to the right by 2 positions
        ListNode rotatedHead =rotateRight(head, k);

        // Print the resulting linked list after rotation
        System.out.print("Rotated linked list: ");
        printList(rotatedHead);
    }

    // Helper function to print the linked list
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }


}
