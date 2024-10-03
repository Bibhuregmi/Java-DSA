package LinkedList;
public class DoublyLinkedList {
    
    Node head;
    Node tail;
    int size; 

    public DoublyLinkedList(){
        this.size = 0; 
    }
    private class Node {
        int value;
        Node next;
        Node previous;
    
        public Node (int value){
            this.value = value;
        }
        public Node (int value, Node next, Node previous){
            this.value = value;
            this.next = next;
            this.previous = previous; 
        }
    
    }

    public void insertFirst(int val){
        Node node = new Node(val); //Creating a new node
        node.next = head;  //pointing the next of the node to the head node
        if (head != null){ //by default head.previous points to null, so if only it is not null it points to the new node
            head.previous = node; 
        }
        head = node; //new node updates as new head 

        if (tail == null){
            head = tail = node; //if the list was empty at first, the node will also be the tail
        }
        size += 1;
    }

    public void insertLast (int val){
        Node node = new Node(val); //Creating a new node
       if (tail == null){ // if the list was empty and the value inserted is the first value being inserted
        head = node = tail ; 
       }else{
        tail.next = node;  //tail node points to the new node
        node.previous = tail; //node will point back to the tail 
        tail = node; //and the new node becomes the tail
       }
       size ++; 
        
    }

    public void insert (int val, int index){
        Node node = new Node(val); //creating new node

        if (index == 0){
            insertFirst(val); //inserting at index 0
            return; 
        }
        if (index == size -1){
            insertLast(val); //inserting at last index
            return; 
        }
        else{
            Node temp = head; //new temp node pointing to head
            for (int i=0; i< index -1; i++){ 
                temp = temp.next; //traversing till the temp reaches to the node before the index
            }
            node.next = temp.next; //new node pointing to the current node at the index
            node.previous = temp;  // and node also pointing back to the temp which is at the node just before to the index
            if(temp.next != null){
                temp.next.previous = node; //node at the index pointing back to the new node 
            }
            temp.next = node; //the node before the correct index is now pointing to the newly created node, linking the new node to the list at that position.
        }
        size ++; 
    }

    public void display(){
        Node temp = head; //reference node temp starting form head
        while (temp != null){
            System.out.print(temp.value+ " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
    public void displayReverse(){
        Node temp = tail; //referene node temp starting from tail
        while (temp != null){
            System.out.print(temp.value+ " -> ");
            temp = temp.previous;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        list.insertFirst(7);
        list.insertFirst(8);
        list.insertFirst(0);
        list.insertFirst(5);
        list.insertLast(3);
        list.insert(15, 2);
        list.display();
        // list.displayReverse();
    }
}

