import java.util.Scanner;

class binarytree {
    //constructor for binary tree class
    public binarytree(){

    }
    //inner class representing a node in a binary tree
    private static class Node{
        int value;
        Node left;
        Node right; 
        
        //constructor for the node class
        public Node(int value){
            this.value = value; 
        }
    }
    private Node root;  //root node of the binary tree

    //method to populate the tree by reading the user input 
    public void populate(Scanner scanner){
        System.out.println("Enter the root node: ");
        int value = scanner.nextInt();
        root = new Node(value);
        populate(scanner,root); //recursive call
    }
    //recursive helper method to populate the tree
    private void populate(Scanner scanner, Node node){
        System.out.println("Do you want to enter the left of " + node.value);
        boolean left = scanner.nextBoolean(); //checks for the left child
        if (left){
            System.out.println("Enter the value for the left of the node: " + node.value);
            int value = scanner.nextInt();
            node.left = new Node(value); //creating the left child
            populate(scanner, node.left); // recursively adding the left subtree
        }
        System.out.println("Do you want to enter the right of " + node.value);
        boolean right = scanner.nextBoolean(); //checking for the right child
        if (right){
            System.out.println("Enter the value for the rigth of the node: " + node.value);
            int value = scanner.nextInt();
            node.right = new Node(value); //creating right child 
            populate(scanner, node.right); //recursively adding the right subtree
        }
    }

    //Method to display the binary tree
    public void display(){
        display(root, 0);
    }
    //helper method to display tree
    private void display(Node node, int level){
        if (node == null){
            return; //base case
        }
       display(node.right, level+1); //displaying the right subtree at first  
       if (level != 0){ //displaying indentation based on level
        for (int i=0; i< level; i++){
            System.out.print("|\t\t");
        }
        System.out.println("-------->" +node.value); 
       }else{
        System.out.println(node.value);
       }
       display(node.left, level+1); //displaying left subtree
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        binarytree tree = new binarytree();
        tree.populate(sc);
        tree.display();
    }
} 