package LinkedList;

public class CircularLL {
    Node head; 
    Node tail;
    int size;

    public CircularLL(){
        this.size = 0;     
    }
    private class Node{
        int value;
        Node next; 

        Node (int value){
            this.value = value;
        }
        Node (int value, Node next){
            this.value = value;
            this.next = next;
        }
   }

   public void insertLast(int value){
        Node node = new Node(value);
        if (head == null){
            //List is empty so head and tail both points to the new node
            head = node; 
            tail = node; 
            node.next = head;  // Circular link where tail points to the head of the list 
        }else{
            tail.next = node; //tail pointing to new node
            tail = node; //new node is updated to tail
            tail.next = head; //maintaining the circular link
        }
        size++;
   }

   public void insertFirst(int value){
        Node node = new Node(value);

        if (head == null){
            head = node; 
            node = tail; 
            node.next = head; 
        }else{
            node.next = head; 
            head = node;  
            tail.next = head;
        }
       
        size++;
   }

   public void deleteFirst(){
        if (head == null){
            return; 
        }
        if (head == tail){
            head = null; 
            tail = null; 
        }
        else{
            head = head.next; //moving head to head.next
            tail.next = head; //maintaining circular nature
        }
        size --; 
   }
   
   public Node get(int index){
        Node node = head; 
        for (int i=0; i<index; i++){
            node = node.next;
        }
        return node; 
   }

   public void deleteLast(){
       if (size <= 1){
        deleteFirst();
        return; 
       }
       else{
            Node prev = get (size -2);
            tail = prev; 
            tail.next = head; 
       }
   }

   public void delete(int index){
        if (index == 0){
            deleteFirst();
            return;
        }
        if (index == size -1){
            deleteLast();
            return;
        }
        else{
            Node temp = get (index -1);
            temp.next = temp.next.next; 
        }
        size--;
   }

}