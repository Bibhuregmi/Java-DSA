package stacksNqueues;

class customQueue {
    protected int[] data; //use of array to store the queue elements 
    private static final int DEFAULT_SIZE = 10;

    int endPointer = 0; //Points to the end of queue where where the next element will be added

    public customQueue(){ //Default constructor that construsts queue of the default size.  
        this(DEFAULT_SIZE);
    }
    public customQueue(int size){ //Constructs queue of the given size. 
        this.data = new int[size];
    }
    public boolean isFull(){ //Method to check if the queue is full
        return endPointer == data.length;
    }
    public boolean isEmpty(){ //Method to check if the queue is empty
        return endPointer == 0; 
    }
    //Metohd to insert the item in the queue, true if it is successful else false if the queue is full
    public boolean insert(int item){
        if(isFull()){
            return false; 
        }
        data[endPointer++] = item; //adding the item at the end pointer and then incrementing it 
        return true;  
    }
    //Method to remove an item form the queue, throws an exception if the queue is empty
    public int remove() throws Exception{
        if(isEmpty()){
            throw new Exception("Queue is Empty!!");
        }
        int removed = data[0]; //storing the removed item to later return it 
        //Shifing the all remaining items to the left after the removal 
        for (int i = 1; i <endPointer; i++) {
            data[i-1] = data[i];
        }
        endPointer--; //decreasing the end pointer 
        return removed;
    }
}

/*
 * Insertion (Enqueue) : O(1)
 * Deletion (Dequeue) : O(n)
 */