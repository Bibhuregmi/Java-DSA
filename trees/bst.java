class bst {
    public class Node{ //inner node class representing each node in bst
        private int value;
        private Node left;
        private Node right;
        private int height;
        
        //constructor to initialize a node with a value      
        public Node(int value){
            this.value = value; 
        }

        public int getValue(){
            return value;
        }
    }

    private Node root; //root node of bst

    //constructor for bst
    public bst(){

    }

    //method to get height of a node
    public int height(Node node){
        if (node == null){
            return -1; 
        }
        return node.height;
    }

    //isEmpty method
    public boolean isEmpty(){
        return root == null; 
    }
    

    //display method starting from root
    public void display() {
        display(root, "Root Node: ");
    }
    //recursive method to display tree nodes with details 
    private void display(Node node, String details){
        if (node == null){
            return; 
        }
        System.out.println(details + node.value);
        display(node.left, "Left child of the root " + node.value + " : ");
        display(node.right, "Right child of the root " + node.value + " : ");
    }
    //insert method to insert value in bst
    public void insert (int value){
        root = insert(value, root);
    }
    //recursive helper method to insert a value and updating height as a new node is added
    private Node insert(int value, Node node){
        if (node == null){ //insert if position is empty
            node = new Node(value);
            return node; 
        }
        //making comparison and inserting on respective subtree
        if (value < node.value){ 
            node.left = insert(value, node.left);
        }
        if (value > node.value){
            node.right = insert(value, node.right);
        }
        //updating the node height
        node.height = Math.max(height(node.left), height(node.right)) +1;
        return node;
    }
    //method to check if the tree is balanced
    public boolean balanced(){
        return balanced(root);
    }
    private boolean balanced(Node node){
        if (node == null) {
            return true;  
        }
        //checking height difference of tree with it's left and right subtree
        return Math.abs(height(node.left) - height(node.right)) <=1 && balanced(node.left) && balanced(node.right);
    }

    //method to populate bst with an array of values
    public void populate(int[] nums){
        for (int i = 0; i < nums.length; i++) {
            this.insert(nums[i]);
        }
    }
    //method to popualte bst with an sorted array
    public void sortedPopulate(int[] nums){
        sortedPopulate(nums, 0, nums.length);
    }
    //recursive helper method to populate bst to maintain balanced structure
    private void sortedPopulate(int[] nums, int start, int end){
        if (start >= end){
            return;
        }
        int mid = (start + end) /2;
        this.insert(nums[mid]); 
        sortedPopulate(nums, start, mid);
        sortedPopulate(nums, mid+1, end);
    }

    public static void main(String[] args) {
        bst tree = new bst();
        int[] nums = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        tree.sortedPopulate(nums);
        tree.display();
        System.out.println();
        bst tree2 = new bst();
        int [] num = {3,2,65,37,24,75,23,56,42,35,75,23,12,76};
        tree2.populate(num);
        tree2.display();
    }
}