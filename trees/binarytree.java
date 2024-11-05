import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
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
    //preorder traversal method in binary tree
    public void preOrder(){
        preOrder(root);
    }
    private void preOrder(Node node){
        if (node == null){
            return;
        }
        System.out.println(node.value + " ");
       preOrder(node.left);
       preOrder(node.right);
    }
    //inorder traversal in binary tree
    public void inOrder(){
        inOrder(root);
    }
    private void inOrder(Node node){
        if (node == null){
            return;
        }
        inOrder(node.left);
        System.out.println(node.value + " ");
        inOrder(node.right);
    }
    //postorder traversal in binary tree
    public void postOrder(){
        postOrder(root);
    }
    private void postOrder(Node node){
        if (node == null){
            return; 
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.value + " ");
    }
    List<List<Integer>> BreadthFirstSearch(){
        List<List<Integer>> result = new ArrayList<>(); //list of list of integer to store the value of each on level

        if (root == null){ 
            return result; 
        }
        Queue<Node> q = new LinkedList<Node>(); //using queue to process the each value of the node in the level, remove the current node value and add the value of the next level
        q.offer(root); //starting by adding root value to queue
        //loop logic is that, loop runs till our queue becomes empty, meaning no more node values to process
        while(!q.isEmpty()){
            List<Integer> nodeValue = new ArrayList<>(); //creating a new list that has all the nodevalue
            int levelSize = q.size(); //the current size of the queue is always equal to the total number of nodes in that level. 
            //esuring that nodes at current level are only processed
            for(int i=0; i < levelSize; i++){
                Node currentNode = q.poll(); //removing current value form the start of the queue
                nodeValue.add(currentNode.value); // and adding the value to the list
                //checking both  left and right childern of the node and adding that value to the queue to be processed. 
                if (currentNode.left != null){
                    q.offer(currentNode.left);
                }
                if (currentNode.right != null){
                    q.offer(currentNode.right); 
                } 
            }
            result.add(nodeValue); //after each level has been processed, adding each list to the result list
        }
        return result; 
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        binarytree tree = new binarytree();
        tree.populate(sc);
        tree.display();
        // System.out.println("Pre Order Traversal N->L->R:");
        // tree.preOrder();
        // System.out.println("Post Order Traversal L->R->N:");
        // tree.postOrder();
        // System.out.println("In Order Traversal L->N->R:");
        // tree.inOrder();
        System.out.println(tree.BreadthFirstSearch()); 
    }
} 