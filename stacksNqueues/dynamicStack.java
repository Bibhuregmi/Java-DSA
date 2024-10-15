package stacksNqueues;

public class dynamicStack extends customStack {
    public dynamicStack(){
        super(); //inherits customStack() constructor
    }
    public dynamicStack(int size){
        super(size);  //inherits customStack(int size) constructor
    }

    @Override
    public boolean push(int item){
        if(this.isFull()){
            int [] temp = new int[data.length*2]; //doubling the size of the array
            for(int i=0; i<data.length; i++){ //copying all the data into the new array
                temp[i] = data[i]; 
            }
            data = temp; 
        }
        return super.push(item); //handles insertion of new data
    }
}

/*
 * Insertion : O(1)
 * Deletion : o(1)
 */