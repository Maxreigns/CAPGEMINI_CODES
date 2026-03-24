package capgemeini_training;

public class Assignment_10Feb_LinkedList {
    //Linked List Implementation- addFirst,addLast,print,deleteAtFirst,deleteLast
     Node head;
    class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
            this.next = null;
        }
    }
 // add first
    public void addFirst(String data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }

    }
    //addLast
   public void addLast(String data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node currNode = head;
            while (currNode.next != null) {
                currNode = currNode.next;
            }
            currNode.next = newNode;
        }
    }
    //printList
    public void print(){
        if(head==null){
            System.out.println("empty");
        }
        Node currNode=head;
        while(currNode!=null){
            System.out.print(currNode.data+"->");
            currNode=currNode.next;
        }
    System.out.print("null");
    }
//deleteFirst
 public void deleteFirst() {
        if (head == null) {
            System.out.println("empty");
        }
        head = head.next;
    }
    //deleteLast
    public void deleteLast(){
         if (head == null) {
            System.out.println("empty");
        }
        if (head.next == null) {
            head = null;
        }
        Node secondLast = head;
        Node lastNode = head.next;
        while (lastNode.next != null) {
            secondLast = secondLast.next;
            lastNode = lastNode.next;
        }
        secondLast.next = null;
    }
    
    public static void main(String[] args) {
        Assignment_10Feb_LinkedList list = new Assignment_10Feb_LinkedList();
        list.addFirst("yadav");
        list.addFirst("Mayank");
        list.addLast("Here");
        System.out.println("Linked List:");
        list.print();
        list.deleteFirst();
        System.out.println();
        System.out.println("After deleting first");
        list.print();
        list.deleteLast();
        
    }
}
