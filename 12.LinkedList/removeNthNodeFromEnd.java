public class removeNthNodeFromEnd {
   
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


    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;

        // Move `first` pointer `n + 1` places ahead
        for (int i = 0; i <= n; i++) {
            if (first != null) {
                first = first.next;
            }
        }

        // Move both pointers until `first` reaches the end
        while (first != null) {
            first = first.next;
            second = second.next;
        }

        // Remove the n-th node from the end
        if (second.next != null) {
            second.next = second.next.next;  // Bypass the node to be deleted
        }

        // Return the head of the modified list
        return dummy.next;
    }

    public static void main(String[] args) {
        // Creating a linked list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        
        int n = 2; // Remove the 2nd node from the end
        ListNode modifiedHead = removeNthFromEnd(head, n);

        // Print the modified linked list
        System.out.print("Modified linked list: ");
        printList(modifiedHead);
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
