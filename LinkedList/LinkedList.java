package LinkedList;

/*
 * A simple implementation of a singly linked list.
 * LinkedList class represents the list structure and operations.
 */
public class LinkedList {
    
     static Node head; //Reference to the first node in the list
     Node tail; //Reference to the last node in the list
        int size; //For keeping track of the number of elements in the list 

    public LinkedList(){
        this.size = 0; //Constructs the LinkedList of size 0 during initialization
    }
    public void insert(int val){  //Inserts value to the head of the LinkedList 
        Node node = new Node(val); //Creating new node with the given value
        node.next = head; //Pointing the new node's next to the current head which inserts the value to the beginning of the head
        head = node; // Updates the head to the new node
    
        if (tail == null){ //If only one node is added, then tail must also be pointing to the new node which is also head
            tail = head; 
        }
        size += 1; //Increasing the size of the LinkedList
    }

    public void insertLast(int val){
        if(tail == null){
            insert(val);
            return;
        }
        Node node = new Node(val); //Creating new node with the value 
        tail.next = node; //Pointing the tail to the new node
        tail = node; //new node becomes tail
        size++;
    }

    public void insertAtIndex(int val, int index){
        if (index == 0 ){
            insert(val);
            return;
        }
        if (index == size){
            insertLast(val);
            return; 
        }

        Node temp = head; //Starting form the head 
        for(int i =0; i< index-1; i++){ 
            temp = temp.next; //move to the next node in the list 
        }

        Node node = new Node(val, temp.next); //Creating new node with the value and it is pointing to the temp.next which is the node at the index+1 position
        temp.next = node; //now the node at index-1 points to the new node. 
        size++;
    }

    public int deleteFirst(){
        int val = head.value; //getting the value of the head pointer
        head = head.next; //updating the head to point to the next node, the value is removed cause there will be no node referencing it
        if (head == null){ //if there is only one node
            tail = null; //tail will be updated to point to null and the list becomes empty. 
        }
        size--;
        return val;
    }

    public Node get(int index){
        Node node = head; //Starting from the head node 
        for(int i=0; i<index; i++){
            node = node.next; //traverse through the list till reached the index 
        }
        return node; //returns the node at the specified index
    }

    public Node find (int value){
        Node node = head;
        while (node != null){
            if (node.value == value){
                return node;
            }
            node = node.next;
        }
        return null;
    }

    public int deleteLast(){
        if (size <= 1){ //if there is only one node in the list
            return deleteFirst();
        }

        Node secondLast = get(size -2); //accessing the node that is just before the last node 
        int val = tail.value; // storing the value of the current tail node before removing it
        tail = secondLast; //tail pointer is updated to point towards the node that is before the last node
        tail.next = null; // the new last node will now points towards null ensuring the previous last node is not referenced by any other nodes
        size--;
        return val;
    }

    public int delete(int index){
        if (index == 0){ 
            return deleteFirst();
        }
        if (index == size -1){
            return deleteLast();
        }

        Node prev = get (index -1); //getting the node just before the given index
        int val = prev.next.value; //storing the value of the node that is going to be removed
        prev.next = prev.next.next; // updating the pointer of the node before the index to point the the node after the index so that the node at the index have no any other node that will reference it. 
        return val;
    }
    /*
     * To display the values present in the linked list, we need to create a temp node which points toward
     * head because, here we will not modify the head beacause changing head wil disrupt the structure of 
     * the LinkedList. 
     */
    public void display(){
        Node temp = head; 
        while (temp != null){
            System.out.print(temp.value+ " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
    //Recursive function to insert a node at the certain index
    public void insertRecursive(Node head, int index, int value, int counter){ //here head is just the reference and the head of the list wont change
        if (counter == index -1){ //base case, recursion stops when it reaches the node at index-1
            Node node = new Node(value);//creating the new node
            node.next = head.next; //new node pointing to the node at "index+1" position
            head.next = node; //completing insertion after linking the node at current index with the new node. 
            return;
        }
        insertRecursive(head.next, index, value, counter+1); //on each call head moves to next and counter increases till base case hits

    }
    //Recursive method to reverse a singly linked list
    public void reverseList (Node node){
        if (node == tail){ //base case: if the node reaches tail, tail becomes head
            head = tail; 
            return; 
        }
        reverseList(node.next); //recursive call, calling the next node
        //This executes when the call is coming out of the stack
        tail.next = node; //tail points to the node
        tail = node; //node becomes the tail
        tail.next = null; // and it points to the null
    }
    //In-place method of the reversing the linked list (Most Important)
    public Node reverse(Node head){
        Node previous = null; 
        Node current = head; 
        Node next = null; 

        while (current != null){
            next = current.next; 
            current.next = previous; 
            previous = current; 
            current = next; 
        }
        return previous;
    }
/*
 * This class represents each node in linked list which contain value and the reference to the next node
*/
 public class Node{ 
    int value; //data stored in the node
    Node next; // reference to the next node

    public Node (int value){ 
        this.value = value; //Construct the node with the given value
    }

    public Node (int value, Node next){ //Constructs a node with the given value and a reference to the next node
        this.value = value;
        this.next = next; 
    }

    //Override the toString method to display the meaningful output for the find() method
    @Override
    public String toString(){
        return "Node{" + "vaule=" + value + "}";
    }
}
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.insert(5);
        list.insert(5);
        list.insert(4);
        list.insert(3);
        list.insert(3);
        list.insert(3);
        list.insert(2);
        list.insertRecursive(head, 2, 10, 0);
        list.insertRecursive(head, 6, 10, 0);
        list.display();
        list.reverse(head);
        list.display();
    }
    
}
