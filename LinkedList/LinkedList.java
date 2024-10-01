package LinkedList;

/*
 * A simple implementation of a singly linked list.
 * LinkedList class represents the list structure and operations.
 */
public class LinkedList {
    
    private Node head; //Reference to the first node in the list
    private Node tail; //Reference to the last node in the list
    private int size; //For keeping track of the number of elements in the list 

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
    
}

/*
 * This class represents each node in linked list which contain value and the reference to the next node
*/
 class Node{ 
    int value; //data stored in the node
    Node next; // reference to the next node

    public Node (int value){ 
        this.value = value; //Construct the node with the given value
    }

    public Node (int value, Node next){ //Constructs a node with the given value and a reference to the next node
        this.value = value;
        this.next = next; 
    }
}