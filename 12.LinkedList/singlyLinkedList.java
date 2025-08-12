
// class Node {
//     int data;
//     Node next;
//     public Node(int val) {
//         this.data = val;
//         this.next = null;
//     }
// }

// class MyLinkedList {
//     Node head;
//     int length;

//     public MyLinkedList() {
//         head = null;
//         length = 0;
//     }
    
//     public int get(int index) {
//         if(index < 0 || index >= this.length)
//             return -1;

//         Node cur = this.head;

//         for(int i = 0; i < index; i++) {
//             cur = cur.next;
//         }

//         return cur.data;
//     }
    
//     public void addAtHead(int val) {
//         Node newHead = new Node(val);
//         newHead.next = this.head;

//         this.head = newHead;
//         this.length += 1;
//     }
    
//     public void addAtTail(int val) {
//         if(this.length == 0) {
//             addAtHead(val);
//             return;
//         }

//         // Starting from the head,
//         // traverse to the last node
//         Node cur = this.head;
//         while(cur.next != null) {
//             cur = cur.next;
//         }

//         Node newNode = new Node(val);
//         cur.next = newNode;

//         this.length += 1;
//     }
    
//     public void addAtIndex(int index, int val) {
//         if(index < 0 || index > this.length)
//             return;
        
//         if(index == 0) {
//             addAtHead(val);
//             return;
//         }

//         // index >= 1 and index <= this.length
//         Node cur = this.head;
//         for(int i = 0; i < index - 1; ++i)
//             cur = cur.next;

//         Node newNode =  new Node(val);
//         newNode.next = cur.next;
//         cur.next = newNode;

//         this.length += 1;
//     }

//     public void deleteAtHead() {
//         Node secondNode = this.head.next;
//         this.head = secondNode;
//         this.length -= 1;
//     }
    
//     public void deleteAtIndex(int index) {
//         if(index < 0 || index >= this.length)
//             return;
        
//         if(index == 0) {
//             deleteAtHead();
//             return;
//         }

//         Node cur = this.head;
//         for(int i = 0; i < index - 1; ++i) {
//             cur = cur.next;
//         }

//         cur.next = cur.next.next;
//         this.length -= 1;
//     }
// }


// public class singlyLinkedList{
//     public static void main(String[] args){
//         MyLinkedList obj = new MyLinkedList();
//         obj.addAtHead(7);
//         obj.addAtIndex(1, 3);
//         obj.addAtIndex(2, 5);
//         obj.addAtIndex(3, 4);
//         obj.addAtTail(9);
//         obj.addAtIndex(2, 2);
//         obj.deleteAtIndex(4);
//         for (int i = 0; i < 5; i++) {
//             System.out.println(obj.get(i));    
//         }
        
//     }
// }
import java.util.*;
class Pair{
        int id,data;
        Pair(int a,int b){
            this.id=a;
            this.data=b;
        }
        public String toString() {
        return id + " " + data;
    }
    }

public class singlyLinkedList{
    
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        LinkedList<Pair> file=new LinkedList<>();
        for(int i=0;i<n;i++){
            int id=sc.nextInt();
            int data=sc.nextInt();
            if(data==0){
                continue;
            }else{
                file.add(new Pair(id,data));
            }
        }
        if(file.isEmpty()){
            System.out.println("EMPTY");
        }else{
            for(Pair p: file){
                System.out.println(p);
            }
        }
        
    }
}