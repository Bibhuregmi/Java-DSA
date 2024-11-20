//Implementing stacks data structure using linked list, this implementation is useful if the size of the stacks is not known
package stacksNqueues;
import java.util.LinkedList; 

public class stackLinkedList<T> {
   //LinkedList to store stack elements of generic type, generic type allows to add any datatypes. while creating a stack, type must be parameterized.
    LinkedList<T> stack = new LinkedList<>();
    
    public void push (T value){
        stack.addFirst(value); //adding the value to the front of the linkedlist
    }

    public T pop () throws Exception{
        if (stack.isEmpty()){
            throw new Exception("Stack is Empty"); //checking if the stack is empty 
        }
        return stack.removeFirst(); //removing the top element form the stack
    }

    public T peek() throws Exception {
        if (stack.isEmpty()){
            throw new Exception("Stack is Empty"); //checking if the stack is empty
        }
        return stack.getFirst(); //returns the first node of the linkedlist
    }
    public static void main(String[] args) throws Exception {
        stackLinkedList<Integer> stack = new stackLinkedList<>();
        stack.push(6);
        stack.push(13);
        stack.push(10);
        stack.push(16);
        stack.push(11);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.peek());
    }
}

