/*In a linked list of size n, where n is even, the ith node (0-indexed) of the linked list is known as the twin of the (n-1-i)th node, if 0 <= i <= (n / 2) - 1.

For example, if n = 4, then node 0 is the twin of node 3, and node 1 is the twin of node 2. These are the only nodes with twins for n = 4.
The twin sum is defined as the sum of a node and its twin.

Given the head of a linked list with even length, return the maximum twin sum of the linked list. */

import java.util.*;

public class maxTwinSum {
    

static class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}


    public static int pairSum(ListNode head) {
        int ans = 0, len = 0;
        ArrayList<Integer> vals = new ArrayList<>();

        // Traverse the linked list and store values in the ArrayList
        while (head != null) {
            len++;
            vals.add(head.val);
            head = head.next;
        }
        
        // Calculate the max sum of pairs
        for (int i = 0; i < len / 2; ++i) {
            ans = Math.max(ans, vals.get(i) + vals.get(len - i - 1));
        }
        
        return ans;
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
        int[] arr = {1, 2, 7, 4, 5, 8}; // Example list
        ListNode head = createLinkedList(arr);

        System.out.println("Original List:");
        printList(head);

        // Find the maximum pair sum
        int result = pairSum(head);
        System.out.println("Maximum Pair Sum: " + result);
    }


}
