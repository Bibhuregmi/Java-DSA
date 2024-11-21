package heap;

import java.util.*;
import heap.heap.MinHeap.MaxHeap;

public class heap {
    
  static class MinHeap{
    int[] arr;
    int size;

    //initializing a heap with a fixed capacity
    public MinHeap(int capacity){
        arr = new int[capacity];
        size = 0; 
    }

    //method to add an element to heap
    public void add(int data){
        if (size == arr.length){
            System.out.println("Heap is full");
            return;
        }
        arr[size] = data;
        int childIndex = size;
        int parentIndex = (childIndex -1) /2; 

        //fixing the heap by swapping as necessary
        while (childIndex < 0 && arr[childIndex] < arr[parentIndex]){
            int temp = arr[parentIndex];
            arr[parentIndex] = arr[childIndex];
            arr[childIndex] = temp;
            
            childIndex = parentIndex;
            parentIndex = (childIndex -1) /2; 
        }
        size++;
    }

    //method to peek at the minimum element 
    public int peek(){
        if (size == 0){
            throw new IllegalStateException("Heap khali chaa");
        }
        return arr[0]; 
    }

    //method to check if heap is empty
    public boolean isEmpty(){
        return size == 0; 
    }

    //heapify method that ensures that heap property is maintained
    protected void heapify(int i){
            int minIndex = i; 
            int left = 2 * i +1;
            int right = 2 * i +2; 
    
            //finding the smallest among the current node and its children
            if (left < size && arr[left] < arr[minIndex]){
                minIndex = left; 
            }
    
            if (right < size && arr[right] < arr[minIndex]){
                minIndex = right; 
            }
    
            //swapping and recursively hepify as necessary
            if (minIndex != i){
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
                heapify(minIndex);
            }
        }
    
        //method to remove the minimum element from the heap
        public int remove(){
            if (size == 0){
                throw new IllegalStateException("Heap khali cha");
            }
            int data = arr[0];
    
            //replacing the root with the last element 
            arr[0] = arr[size -1];
            size--; 
    
            //restoring the heap property
            heapify(0);
    
            return data; 
        }
    
        static class MaxHeap extends MinHeap {
            public MaxHeap(int capacity){
                super(capacity);
            }
    
            //overriding add method to implement max heap logic
    
            @Override
            public void add(int data){
                if (size == arr.length){
                    System.out.println("Heap is full");
                    return; 
                }
                arr[size] = data;
                int childIndex = size; 
                int parentIndex = (childIndex -1) /2; 
                //using maxheap comparision logic, where every parent must be greater than it's child 
                while (childIndex > 0 && arr[childIndex] > arr[parentIndex]){
                    int temp = arr[parentIndex];
                    arr[parentIndex] = arr[childIndex];
                    arr[childIndex] = temp; 
    
                    childIndex = parentIndex;
                    parentIndex = (childIndex -1) /2;
                }
                size ++; 
            }
    
            // overriding hepipy method to implement max heap logic
            @Override
            protected void heapify(int i){
                int maxIndex = i;
                int left = 2 * i +1; 
                int right = 2 * i +2;
    
                //using maxheap comparision logic
                if (left < size && arr[left] > arr[maxIndex]){
                    maxIndex = left;
                }
                if (right < size && arr[right] > arr[maxIndex]){
                    maxIndex = right;
                }
                if (maxIndex != i){
                    int temp = arr[i];
                    arr[i] = arr[maxIndex];
                    arr[maxIndex] = temp; 
                    heapify(maxIndex);
                }
            }
        }
}

  public static void main(String[] args) {
    System.out.println("Operations in min heap:");
    MinHeap heap = new MinHeap(10); 
    ArrayList<Integer> minelements = new ArrayList<>();
    heap.add(4);
    heap.add(1);
    heap.add(3);
    heap.add(5);
    heap.add(6);
    heap.add(7);

    while (!heap.isEmpty()){
        minelements.add(heap.peek());
        heap.remove();
        System.out.println(minelements);
    }

    System.out.println("Operations in max heap:");

    MaxHeap hp = new MaxHeap(10); 
    ArrayList<Integer> maxelements = new ArrayList<>();
    hp.add(4);
    hp.add(1);
    hp.add(3);
    hp.add(5);
    hp.add(6);
    hp.add(7);

    while (!hp.isEmpty()){
        maxelements.add(hp.peek());
        hp.remove();
        System.out.println(maxelements);
    }
  
  }
}

//this implementation has both instance of max and min heap, and this is also known as priority queue, 
// Min heap, acts as an priority queue where the element with the smallest value is served first and 
// vice versa for the max heap. 