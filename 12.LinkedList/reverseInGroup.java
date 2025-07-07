/*Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.
k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.
You may not alter the values in the list's nodes, only nodes themselves may be changed. */

public class reverseInGroup {
    public static class ListNode {
        int val;
        ListNode next;
        
        // Default constructor
        ListNode() {}
        
        // Constructor with value
        ListNode(int val) {
            this.val = val;
        }
    }

        // Helper function to reverse the linked list between head and tail (exclusive of tail)
       static  void reverse(ListNode head, ListNode tail) {
            // Reverse connections between head and tail
            ListNode prev = null;
            ListNode cur = head;
            while (cur != tail)//instaed of cur!=null we are checking cur!=tail.So we will bring tail as end.next instead of just end in argument of this fn 
            {
                ListNode nextNode = cur.next;
                cur.next = prev; // Reverse the link
                prev = cur;
                cur = nextNode;
            }
        }
    
        // Main function to reverse nodes in groups of k
        public static ListNode reverseKGroup(ListNode head, int k) {
            if (k == 1 || head == null || head.next == null)
                return head;
    
            // Find the kth node (tail) for the current group
            ListNode beg = head, end = head;
            for (int i = 0; i < k - 1; ++i) {
                end = end.next;
                // If there are less than k nodes left, return the head as it is
                if (end == null)
                    return head;
            }
    
            // Save the next head of the next group
            ListNode nextGroupHead = reverseKGroup(end.next, k);
    
            // Reverse the current group from beg to end
            reverse(beg, end.next);
    
            // After reversing, beg becomes the end, so connect beg to nextGroupHead
            beg.next = nextGroupHead;
    
            // The new head of the reversed group is end, so return it
            return end;
        }
    
        // Helper function to print the linked list (for testing purposes)
        public static void printList(ListNode head) {
            ListNode current = head;
            while (current != null) {
                System.out.print(current.val + " -> ");
                current = current.next;
            }
            System.out.println("null");
        }
    
        // Main method for testing
        public static void main(String[] args) {
            // Create a sample linked list: 1 -> 2 -> 3 -> 4 -> 5
            ListNode head = new ListNode(1);
            head.next = new ListNode(2);
            head.next.next = new ListNode(3);
            head.next.next.next = new ListNode(4);
            head.next.next.next.next = new ListNode(5);
    
            // Set k to 2 (reverse in groups of 2)
            int k = 2;
    
            // Create solution object
            
    
            // Print original list
            System.out.println("Original Linked List:");
            printList(head);
    
            // Reverse the nodes in groups of k and print the result
            ListNode newHead = reverseKGroup(head, k);
            System.out.println("Reversed Linked List in groups of " + k + ":");
            printList(newHead);
        }
    
}
