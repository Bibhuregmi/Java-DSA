package stacksNqueues;
//This is the custom implementation of the Stack data structure. This DS is not dynamic, meaning it array and only has fixed size of 10 items. 
public class customStack {
    protected int[] data; 
    private static final int DEFAULT_SIZE = 10;

    int pointer = -1; //Points to the top of stack (index of an array). Initializing at -1 meaning stack is empty.

    public customStack(){ //Construsts stack of the default size.  
        this(DEFAULT_SIZE);
    }
    public customStack(int size){ //Constructs stack of the given size. 
        this.data = new int[size];
    }

    public boolean push(int item){ //Method to push an item in stack, returns true if operation is successful either false
        if (isFull()){
            System.out.println("Stack is full!!!");
            return false; 
        }
        pointer++; 
        data[pointer] = item; //adding data to the place indicated by pointer
        return true; 
    }
    public int pop() throws Exception{ //Method to pop item from stack, throws exception if the stack is empty
        if(isEmpty()){
            throw new Exception("Can't pop from empty stack");
        }
        return data[pointer--]; //returns the top item form stack and moves pointer down. 
    }
    public int peek() throws Exception{//method to peek top element in stack and throws exception if the stack is empty
        if(isEmpty()){
            throw new Exception("Can't peek in empty stack");
        }
        return data[pointer];
    }
    //other methods
    public boolean isFull(){ 
        return pointer == data.length-1; 
    }
    public boolean isEmpty(){
        return pointer == -1; 
    }

    public static void main(String[] args) throws Exception {
        customStack stack = new dynamicStack(); //since dynamicStack inherits all properties of the customStack, every dynamicStack is an object of a customStack so it is valid
        stack.push(4);
        stack.push(4);//calls dynamicStack's push 
        stack.push(6);
        stack.push(7);
        stack.push(2);
        stack.push(42);
        System.out.println(stack.pop()); //calls dynamicStack's pop()
    }
}

/*
 * Insertion : O(1)
 * Deletion : O (1)
 */




