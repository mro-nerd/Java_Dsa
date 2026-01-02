/*Given the head of a singly linked list and two integers left and right where left <= right, reverse the nodes of the list from position left to position right, and return the reversed list. */

public class reversedLinkedListII {
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    
    
        public static ListNode reverseBetween(ListNode head, int left, int right) {
            if(head == null || left == right) return head;
    
            int count = 1;
            ListNode pseudoHead = new ListNode();
            pseudoHead.next = head;
    
            ListNode prev = pseudoHead;
            ListNode curr = head;
            ListNode next;
            
            ListNode joinFromLeft = null;
            ListNode joinToRight = null;
    
            
            while(curr != null && count <= right) {
                next = curr.next;
                if(count == left) {
                    // Record pointers where the reversed list should be attached.
                    joinFromLeft = prev; // The node before the "left" node
                    joinToRight = curr; // The "left" node, which will become the tail
                }
                if(count >= left) {
                    // Reverse node logic
                    curr.next = prev;
                }
                prev = curr;
                curr = next;
                count++;
            }
            
            // Connect the reversed portion to the rest of the list
            joinFromLeft.next = prev;
            joinToRight.next = curr;
            return pseudoHead.next;
        }
    
        // Utility function to print the linked list
        public static void printList(ListNode head) {
            ListNode temp = head;
            while(temp != null) {
                System.out.print(temp.val + " ");
                temp = temp.next;
            }
            System.out.println();
        }
    
        // Utility function to create a linked list from an array
        public static ListNode createLinkedList(int[] arr) {
            if (arr.length == 0) return null;
            ListNode head = new ListNode(arr[0]);
            ListNode current = head;
            for (int i = 1; i < arr.length; i++) {
                current.next = new ListNode(arr[i]);
                current = current.next;
            }
            return head;
        }
    
        public static void main(String[] args) {
        
            
            // Example 1:
            int[] arr = {1, 2, 3, 4,5,6};
            ListNode head = createLinkedList(arr);
            System.out.println("Original list:");
            printList(head);
    
            // Reverse between positions 2 and 4
            int left = 2;
            int right = 4;
            ListNode result = reverseBetween(head, left, right);
    
            System.out.println("Reversed list (between 2 and 4):");
            printList(result);
        }
    
    
}
