package capgemeini_training;
   //Reverse Linked List
        class Node{
            int data;
            Node next;

            Node(int data){
                this.data=data;
                this.next=null;
            }
        }
        public class Assignment_7Feb_LinkedList {
        Node head;
        public void printList(){
            Node temp=head;
            while(temp!=null){
                System.out.print(temp.data+" ");
                temp=temp.next;
            }
            System.out.println();
        }
        public void addNode(int data) {
            Node newNode = new Node(data);
            if(head == null) {
                head = newNode;
            } else {
                Node temp = head;
                while(temp.next != null) {
                    temp = temp.next;
                }
                temp.next = newNode;
            }
        }
        
        public void reverseList() {
            Node prev=null;
            Node curr=head;
            while(curr!=null){
                Node next=curr.next;
                curr.next=prev;
                prev=curr;
                curr=next;
            }
            head=prev;
        }
        public static void main(String[] args) {
             Assignment_7Feb_LinkedList ob=new Assignment_7Feb_LinkedList();
           ob.addNode(10);
           ob.addNode(20);
           ob.addNode(30);
           ob.addNode(40);
            ob.reverseList();
            ob.printList();
        }
}
    

   

    

    

