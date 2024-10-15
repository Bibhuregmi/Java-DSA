package stacksNqueues;

class circularQueue {
    protected int[] data;//Array to store queue items
    private static final int DEFAULT_SIZE = 10;  //Default queue size

    protected int end, front, size = 0; //pointers to track front and end positions and the size of the queue

    public circularQueue(){ //default constructor with predefined size
        this(DEFAULT_SIZE); 
    }

    public circularQueue(int size){ //constructs the queue with the given size
        this.data = new int[size]; 
        this.size = size; 
    }

    public boolean isFull(){ //checks if the queue is full
        return (end +1) % size == front; 
    }
    public boolean isEmpty(){ //checks if the queue is empty
        return front == end; 
    }

    public boolean insert(int item){ //insertion in queue
        if (isFull()){
            System.out.println("Queue is full");
            return false; 
        }else{
            data[end] = item; 
            end = (end +1) % size; //circular increment of the end pointer
        }
        return true; 
    }

    public int remove() throws Exception{ //removes and returs the queue item
        if(isEmpty()){
            throw new Exception("Queue is empty"); 
        }
        int item = data[front]; //geting the item form the front of the queue
        front = (front +1) % size; //circular increment of the front pointer
        return item; 
    }

    public void display(){ //displaying the queue item
        if(isEmpty()){
            System.out.println("Empty");
            return; 
        }
        int i = front; //starting from front
        while(true){
            System.out.print(data[i] + " ");
            if (i == end){ //stops when i reaches to end
                break; 
            }
            i = (i+1)%size; //circular increment of the index
        }
        System.out.println();
    }
    public static void main(String[] args) throws Exception {
        circularQueue queue = new circularQueue(); 
        queue.insert(6);
        queue.insert(0);
        queue.insert(7);
        queue.insert(10);
        queue.insert(2);
        queue.insert(8);
        queue.display();
       System.out.println(queue.remove());
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