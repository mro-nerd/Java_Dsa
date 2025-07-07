/*Merge two sorted Linked List such that resultant list is also sorted */

public class mergeTwoSortedList {
    // Definition for singly-linked list.
static class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}


    public static ListNode mergeTwoLists(ListNode head1, ListNode head2) {
        if (head1 == null)
            return head2;
        if (head2 == null)
            return head1;

        if (head1.val < head2.val) {
            head1.next = mergeTwoLists(head1.next, head2);
            return head1;
        }

        head2.next = mergeTwoLists(head1,head2.next);
        return head2;
    }

    // Function to print the linked list
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        

        // Creating first sorted linked list: 1 -> 3 -> 5
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(3);
        head1.next.next = new ListNode(5);

        // Creating second sorted linked list: 2 -> 4 -> 6
        ListNode head2 = new ListNode(2);
        head2.next = new ListNode(3);
        head2.next.next = new ListNode(5);
        head2.next.next.next = new ListNode(6);

        // Merging the two sorted linked lists
        ListNode mergedList = mergeTwoLists(head1, head2);

        // Printing the merged sorted list
        System.out.println("Merged Sorted List:");
        printList(mergedList);
    }


}
