
    // creating node class
     class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    class OurLinkedList {
        Node head;
        // Reverse a linked list
        public void reverseList() {
            Node prev = null;
            Node current = head;
            Node nextNode = null;
        
            while (current != null) {
                nextNode = current.next; // Store the next node
                current.next = prev; // Reverse the current node's pointer
                prev = current; // Move prev to the current node
                current = nextNode; // Move to the next node
            }
            head = prev; // Update head to the new front of the list
        }

        // Insert at end of the linkedlist
        public void insertAtEnd(int data){
            Node newNode = new Node(data);
            if(head == null){
                head = newNode;
                return;
            }
            Node temp = head;
            while(temp.next != null){
                temp = temp.next;
            }
          
            temp.next = newNode;
        }
        // Display linkedList
        public void displayList(){
            Node curr = head; // current node
            while(curr.next != null){
                System.out.print(curr.data + " ");
                curr = curr.next;
            }
            System.out.println(curr.data); // Print the last node's data
        }    

    }
public class ReverseLinkedList {
    public static void main(String[] args) {
        OurLinkedList ll = new OurLinkedList();
        ll.insertAtEnd(0);
        ll.insertAtEnd(1);
        ll.insertAtEnd(3);
        ll.insertAtEnd(4);
        ll.insertAtEnd(2);

        ll.displayList();

        ll.reverseList();

        ll.displayList();
    }
}
