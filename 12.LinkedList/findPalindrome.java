/*find if given LL is a palindrome or not */

public class findPalindrome {

public static class ListNode {
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

    public static boolean isPalindrome(ListNode head) {
        if (head == null) return true;

        ListNode slow = head;
        ListNode fast = head;
        ListNode cur = head;
        ListNode prev = null;

        // Finding the middle and reversing the first half
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            // Reversing the first half
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }

        // For edge cases: skip the middle element for odd length lists
        if (fast != null) slow = slow.next;

        // Comparing the first half to the second half
        while (slow != null) {
            if (prev.val != slow.val) return false;
            prev = prev.next;
            slow = slow.next;
        }
        return true;
    }

    public static void main(String[] args) {
        // Creating a linked list: 1 -> 2 -> 2 -> 1
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);

    
        boolean result = isPalindrome(head);
        System.out.println("Is the linked list a palindrome? " + result);

        // Creating another linked list: 1 -> 2 -> 3 -> 4
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = new ListNode(3);
        head2.next.next.next = new ListNode(4);

        boolean result2 = isPalindrome(head2);
        System.out.println("Is the linked list a palindrome? " + result2);
    }


}
