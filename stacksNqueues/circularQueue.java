package stacksNqueues;

class circularQueue {
    protected int[] data;//Array to store queue items
    private static final int DEFAULT_SIZE = 10;  //Default queue size

    protected int end, front, size = 0; //pointers to track front and end positions and the size of the queue
    private int capacity; 
    public circularQueue(){ //default constructor with predefined size
        this(DEFAULT_SIZE); 
    }

    public circularQueue(int size){ //constructs the queue with the given size
        this.data = new int[size]; 
        this.capacity = size; 
    }

    public boolean isFull(){ //checks if the queue is full
        return size == capacity; 
    }
    public boolean isEmpty(){ //checks if the queue is empty
        return size == 0; 
    }

    public boolean insert(int item){ //insertion in queue
        if (isFull()){
            System.out.println("Queue is full");
            return false; 
        }
        data[end] = item; 
        end = (end +1) % capacity; //circular increment of the end pointer
        size++;
        return true; 
    }

    public int remove() throws Exception{ //removes and returs the queue item
        if(isEmpty()){
            throw new Exception("Queue is empty"); 
        }
        int item = data[front]; //geting the item form the front of the queue
        front = (front +1) % capacity;//circular increment of the front pointer
        size--; 
        return item; 
    }

    public void display(){ //displaying the queue item
        if(isEmpty()){
            System.out.println("Empty");
            return; 
        }
        int i = front; //starting from front
        int element = size; 
        while(element > 0){
            System.out.print(data[i] + " ");
            i = (i+1)%capacity; //circular increment of the index
            element--; 
        }
        System.out.println();
    }
    public static void main(String[] args) throws Exception {
        circularQueue queue = new circularQueue(); 
        queue.insert(6);
        queue.insert(4);
        queue.insert(7);
        queue.insert(10);
        queue.insert(2);
        queue.insert(8);
        queue.display();
       System.out.println(queue.remove());
       queue.display();
       queue.insert(88);
       queue.display();

    }
}

/*
 * Insertion : O(1)
 * Deletion : O(1)
 * 
 * Insert and delete method uses modulo to wrap around the circular queue
 * and display iterates through the queue in circular fashion
 */