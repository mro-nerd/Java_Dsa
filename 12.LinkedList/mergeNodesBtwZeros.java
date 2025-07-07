/*You are given the head of a linked list, which contains a series of integers separated by 0's. The beginning and end of the linked list will have Node.val == 0.

For every two consecutive 0's, merge all the nodes lying in between them into a single node whose value is the sum of all the merged nodes. The modified list should not contain any 0's.
Return the head of the modified linked list. */

public class mergeNodesBtwZeros {
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    
    
        public static ListNode mergeNodes(ListNode head) {
            ListNode ptr1 = head.next; // Start after the first zero
            ListNode ptr2 = head; // Start at the first zero
            int value = 0;
    
            while (ptr1 != null) {
                if (ptr1.val == 0) { 
                    // Assign the cumulative sum to the current zero node (ptr2)
                    ptr2.val = value;
                    // Move ptr2 to the next node if not at the end
                    if (ptr1.next != null) {
                        ptr2 = ptr2.next;
                    }
                    // Reset the value for the next segment
                    value = 0;
                } else {
                    // Add the value of the current node to the sum
                    value += ptr1.val;
                }
                ptr1 = ptr1.next;
            }
    
            // Terminate the list after the last merged node
            ptr2.next = null;
            return head;
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
            
    
            // Example: Create a linked list with given values
            // For example, a list like [0,3,1,0,4,5,2,0] will sum between zeros.
            int[] arr = {0, 3, 1, 0, 4, 5, 2, 0}; // Example list
            ListNode head = createLinkedList(arr);
    
            System.out.println("Original List:");
            printList(head);
    
            // Call the mergeNodes function
            ListNode result = mergeNodes(head);
    
            System.out.println("List after merging nodes:");
            printList(result);
        }
    
    
}
