//return the middle element of list if there are odd no. of elements in list and return the second middle element of the list if there are even no. of elements in list.

public class middleInLinkedList {
    public static class ListNode {
        int val;
        ListNode next;
        
        // Default constructor
        ListNode() {}
        
        // Constructor with value
        ListNode(int val) {
            this.val = val;
        }
    
        // Constructor with value and next node
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    // Function to find the middle node of the linked list
    public static ListNode middleNode(ListNode head) {
        // Two pointers: slow and fast
        ListNode slow = head, fast = head;
        
        // Traverse the list with slow moving one step and fast moving two steps
        while(fast != null && fast.next != null) {
            slow = slow.next; // slow moves one step
            fast = fast.next.next; // fast moves two steps
        }
        
        // When fast reaches the end, slow will be at the middle
        return slow;
    }
    
    // Helper function to create a linked list and find the middle node
    public static void main(String[] args) {
        
        // Create a linked list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        // Find and print the middle node
        ListNode middle = middleNode(head);
        System.out.println("The middle node value is: " + middle.val); // Output: 3
    }


}
