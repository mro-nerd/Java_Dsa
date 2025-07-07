/*Given the head of a singly linked list, group all the nodes with odd indices together followed by the nodes with even indices, and return the reordered list.

The first node is considered odd, and the second node is even, and so on. */

public class oddEven {
   static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    

        public static ListNode oddEvenList(ListNode head) {
            if (head == null || head.next == null || head.next.next == null)
                return head;
    
            // Initialize odd and even pointers
            ListNode odd = head;
            ListNode even = head.next;
            ListNode evenStart = head.next; // Remember the start of the even list
            
            // Loop through the list to separate odd and even nodes
            while (odd.next != null && even.next != null) {
                odd.next = even.next; // Connect all odd nodes
                even.next = odd.next.next; // Connect all even nodes
                odd = odd.next; // Move odd pointer
                even = even.next; // Move even pointer
            }
    
            // Connect the last odd node to the first even node
            odd.next = evenStart;
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
            int[] arr = {1, 2, 3, 4, 5, 6}; // Example list
            ListNode head = createLinkedList(arr);
    
            System.out.println("Original List:");
            printList(head);
    
            // Call the oddEvenList function
            ListNode result = oddEvenList(head);
    
            System.out.println("List after reordering odd and even:");
            printList(result);
        }
    
    
}
