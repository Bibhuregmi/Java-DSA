class avl {
    /*
     * Innner node class representing each node in the AVL tree that stores left, right and
     * the height
     */
    public class Node{ 
        private int value;
        private Node left;
        private Node right;
        private int height;
        
        //constructor to initialize a node with a value      
        public Node(int value){
            this.value = value; 
            this.height = 0;  //initial height of 0 for leaf nodes
        }

        public int getValue(){
            return value;
        }
    }

    private Node root; //root node of avl

    //constructor for avl
    public avl(){

    }

    //method to get height of a node
    public int height(Node node){
        if (node == null){
            return -1; 
        }
        return node.height;
    }
    public int height(){
        return height(root);
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
    /*
    Main insert method in avl
    */
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
        System.out.println("Inserted: " + value + ", Updated Height: " + node.height);
        return rotate(node); 
    }

    //method to rotate the subtree if the insertion causes tree to become unstable (AVL tree algorithm)
    private Node rotate(Node node){
        // case if the left subtree height is longer than that of right
        if (height(node.left) - height(node.right) > 1){
            if(height(node.left.left) - height(node.left.right) >= 0){ //left left case 
                return rotateRight(node);
            }
            if(height(node.left.left) - height(node.left.right) <= 0){ // left right case
                node.left = rotateLeft(node.left);
                return rotateRight(node);
            }
        }

        //case if the right subtree height is longrt than that of left
        if (height(node.left) - height(node.right) < -1){
            if (height(node.right.left) - height(node.right.right) <= 0){ //right right case
                return rotateLeft(node);
            } 
            if (height(node.right.left) - height(node.right.right) >= 0){ //right left case
                node.right = rotateRight(node.right);
                return rotateLeft(node);
            }
        }
        return node;
    }
    //left rotation used for right-heavy situations updates height in correct order bottom up (child first and then parent)
    public Node rotateLeft(Node c){
        Node p = c.right; 
        Node t = p.left; 

        p.left = c; 
        c.right = t; 

        p.height = Math.max(height(p.left), height(p.right)) +1;
        c.height = Math.max(height(c.left), height(c.right)) +1;
        return p; 
    }
    //right rotation used for left-heavy situations updates heights in correct order bottom up (child first and then parent)
    public Node rotateRight(Node p){
        Node c = p.left; 
        Node t = c.right; 

        c.right = p ;
        p.left = t; 

        p.height = Math.max(height(p.left), height(p.right)) +1; // p becomes child
        c.height = Math.max(height(c.left), height(c.right)) +1; // c becomes parent
        return c; 
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
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        if (Math.abs(leftHeight - rightHeight) > 1){
            System.out.println("Unbalanced at node: " + node.value + "| Left height: " + leftHeight + "| Right height: " + rightHeight);
            return false;
        }
        return balanced(node.left) && balanced(node.right);
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
        avl tree = new avl();
        // int[] nums = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        // tree.sortedPopulate(nums);
        // tree.display();
        // System.out.println();
        // bst tree2 = new bst();
        // int [] num = {3,2,65,37,24,75,23,56,42,35,75,23,12,76};
        // tree2.populate(num);
        // tree2.display();

        for(int i=0; i < 10; i++){
            tree.insert(i);
        }
        System.out.println("Height: " + tree.height());
        System.out.println(tree.balanced());
    }
}