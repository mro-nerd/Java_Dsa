/*Given head, the head of a linked list, determine if the linked list has a cycle in it.
There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.
Return true if there is a cycle in the linked list. Otherwise, return false. */


public class detectCycle {
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
        public static boolean hasCycle(ListNode head) {
            // Two pointers: slow (tortoise) and fast (hare)
            ListNode slow = head, fast = head;
            
            // Traverse the list with slow moving one step and fast moving two steps
            while (fast != null && fast.next != null) {
                slow = slow.next;          // Move slow by one node
                fast = fast.next.next;     // Move fast by two nodes
                
                // If slow and fast meet, there is a cycle
                if (slow == fast) {
                    return true;
                }
            }
            
            // If fast reaches null, there is no cycle
            return false;
        }
        
        // Helper function to test cycle detection
        public static void main(String[] args) {
            // Create a list with a cycle: 3 -> 2 -> 0 -> -4 (cycle back to 2)
            ListNode head = new ListNode(3);
            ListNode node2 = new ListNode(2);
            ListNode node3 = new ListNode(0);
            ListNode node4 = new ListNode(-4);
            
            head.next = node2;
            node2.next = node3;
            node3.next = node4;
            node4.next = node2;  // Cycle here
            
            
            boolean result = hasCycle(head);
            
            if (result) {
                System.out.println("The linked list has a cycle.");
            } else {
                System.out.println("The linked list does not have a cycle.");
            }
        }
    
}
