/*Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect. If the two linked lists have no intersection at all, return null. */

public class findIntersection {// Definition for singly-linked list.
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    
    
        public static  ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            // Boundary check
            if (headA == null || headB == null) return null;
    
            ListNode cur1 = headA;
            ListNode cur2 = headB;
    
            // Traverse both lists; reset the pointer to the other list's head at the end of the first iteration
            while (cur1 != cur2) {
                cur1 = (cur1 == null) ? headB : cur1.next;
                cur2 = (cur2 == null) ? headA : cur2.next;
                if(cur1==null && cur2 == null)return null;
            }
    
            // Either return the intersection node or null if no intersection
            return cur1;
        }
    
        // Function to print the linked list from a given head node
        public static void printList(ListNode head) {
            while (head != null) {
                System.out.print(head.val + " -> ");
                head = head.next;
            }
            System.out.println("null");
        }
    
        public static void main(String[] args) {
            
    
            // Creating first linked list: 1 -> 9 -> 1
            ListNode headA = new ListNode(1);
            headA.next = new ListNode(9);
            headA.next.next = new ListNode(1);
    
            // Creating second linked list: 3
            ListNode headB = new ListNode(3);
    
            // Creating intersection: 2 -> 4 (shared intersection nodes)
            ListNode intersection = new ListNode(2);
            intersection.next = new ListNode(4);
    
            // Connecting both lists to the intersection
            // headA.next.next.next = intersection;
            // headB.next = intersection;
    
            // Printing both linked lists
            System.out.println("Linked List A:");
            printList(headA);
            System.out.println("Linked List B:");
            printList(headB);
    
            // Finding and printing the intersection node
            ListNode intersectionNode = getIntersectionNode(headA, headB);
            if (intersectionNode != null) {
                System.out.println("Intersection at node with value: " + intersectionNode.val);
            } else {
                System.out.println("No intersection found.");
            }
        }
    
    
}
