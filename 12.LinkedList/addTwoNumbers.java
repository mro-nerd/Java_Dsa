/*You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list. */

public class addTwoNumbers {

    static class ListNode {

        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode addTwoNumber(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode tail = dummyHead;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            // Get the current values of l1 and l2 or 0 if they are null
            int digit1 = (l1 != null) ? l1.val : 0;
            int digit2 = (l2 != null) ? l2.val : 0;

            // Calculate the sum of the digits plus the carry
            int sum = digit1 + digit2 + carry;
            int digit = sum % 10; // Current digit to add to the result

            // Update the carry for the next iteration
            carry = sum / 10;

            // Create a new node for the current digit and attach it to the result list
            ListNode newNode = new ListNode(digit);
            tail.next = newNode;
            tail = tail.next;

            // Move to the next nodes in l1 and l2
            l1 = (l1 != null) ? l1.next : null;
            l2 = (l2 != null) ? l2.next : null;
        }

        // Return the head of the resulting linked list
        return dummyHead.next;
    }

    public static void main(String[] args) {
        // Creating the first linked list: 2 -> 4 -> 3 (represents the number 342)
        ListNode l1 = new ListNode(6);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        // Creating the second linked list: 5 -> 6 -> 4 (represents the number 465)
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(7);
        l2.next.next = new ListNode(8);

        ListNode result = addTwoNumber(l1, l2);

        // Print the resulting linked list
        System.out.print("Resulting linked list: ");
        printList(result);
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
