package graph;
import java.util.*; 

public class Graph {
    //A map is used to store the value where the key is the node/vertex and edges are the values stored in the list
    private static Map<Integer, List<Integer>> adjList = new HashMap<>(); 

    public Graph(){
    
    }
    //adding nodes to the graph
    public void addNode(int node){
        adjList.putIfAbsent(node, new ArrayList<>()); //putIfAbsent method add key-value pair to the map if the specified key is not present in the map, and if the key is already in the map it simply returns the current value of the key. 
    }

    //adding an edge to the graph, edge is connection between two nodes. Source is the node where the edge starts and destination where the edge ends. 
    public void addEdge(int source, int destination , boolean directed){
        //for the case of the directed graph(graph having said direction of edges between nodes)
        if(directed){
            adjList.putIfAbsent(source, new ArrayList<>());
            adjList.get(source).add(destination); //adding the destination to the source adjacency list
        }else{
            //for the case of the undirected graph(graph having no direction of edges between nodes)
            adjList.putIfAbsent(source, new ArrayList<>());
            adjList.get(source).add(destination); //adding the destination to the source adjacency list
            adjList.putIfAbsent(destination, new ArrayList<>());
            adjList.get(destination).add(source); //adding the source to the destination adjacency list
        }

    }

    public void printGraph(){
        for(Map.Entry<Integer, List<Integer>> entry : adjList.entrySet()){
            Integer nodes = entry.getKey();
            List<Integer> neighbours = entry.getValue(); 

            System.out.println("Vertex " + nodes + " is connected to: " + neighbours);
        }
    }
    //BFS traversal of graph where it visits all it's surrounding neighbours first and then other, similar to tree, queue is used
    public List<Integer> bfs(int start){
        Set<Integer> visited = new HashSet<>(); 
        Queue<Integer> queue = new LinkedList<>(); 
        List<Integer> bfsList = new ArrayList<>(); 
        visited.add(start); 
        queue.add(start); 

        while(!queue.isEmpty()){
            int current = queue.poll(); 
            bfsList.add(current);

            for(int neighbours : adjList.get(current)){
                if(!visited.contains(neighbours)){
                    visited.add(neighbours);
                    queue.add(neighbours);
                }
            }
        }
        return bfsList; 
    }
    //DFS traversal of graph where it visits all the neighbours in depth, and then to it's surrounding. Stack is used to process the node. 
    public List<Integer> dfs(int start){
        Stack<Integer> stack = new Stack<>(); 
        Set<Integer> visited = new HashSet<>(); 
        List<Integer> dfsList = new ArrayList<>();
        
        stack.push(start); 
        while(!stack.isEmpty()){
            int current = stack.pop(); 
            dfsList.add(current);
            for(int neighbours : adjList.get(current)){
                if(!visited.contains(neighbours)){
                    visited.add(neighbours);
                    stack.push(neighbours); 
                }
            }
        }
        return dfsList; 
    }
    //Recursive DFS appraoch
    public static void dfsRecursion(int start){
        System.out.println(start);
        for(int neighbours : adjList.get(start)){
            dfsRecursion(neighbours); 
        }
    }
    // this is the BFS approach to find if there exists the path between the source and the destination nodes in the graph. 
    // TimeCommplexity in worst case will be O(Vertex + Edeges) and SpaceCompexity in worst case will be O(V) where queue have to store all the values of the vertex. 
    boolean hasPath(Graph graph, int source, int destination, Set<Integer> visited){
       Queue<Integer> queue = new LinkedList<>(); 
       queue.offer(source); 
       visited.add(source);
       while(!queue.isEmpty()){
        int current = queue.poll();
        if(current == destination) return true; 
        for(int neighbours : adjList.get(current)){
            if(!visited.contains(neighbours)){
                if(neighbours == destination) return true; 
                if(!visited.contains(neighbours) && !queue.contains(neighbours) && neighbours != destination){ //this condition is used to avoid the cycle in the graph
                    visited.add(neighbours);
                    queue.offer(neighbours); 
                }
            } 
        }
       }
       return false; 
    }
    //this is the overloaded method of the hasPath method where it is called from the main method.
    static boolean hasPath(Graph graph, int source, int destination){ 
        return graph.hasPath(graph, source, destination, new HashSet<>());
    }

    //this is the recursive DFS appraoch to find if there exists the path between source and the destination
    //Similar to the iterative BFS, recursive DFS have same Time and Space complexities.
    static boolean hasPathRecursive(Graph graph, int source, int destination){
        if (source == destination) return true; 

        for(int neighbours : adjList.get(source)){
            if(hasPathRecursive(graph, neighbours, destination) == true) return true; 
        }
        return false; 
    }

    public static void main(String[] args) {
        Graph graph = new Graph(); 

        graph.addNode(0);
        graph.addNode(1);
        graph.addNode(2);
        graph.addNode(3);
        graph.addNode(4);
        graph.addNode(5);

        graph.addEdge(0, 1, false);
        graph.addEdge(1, 2, false);
        graph.addEdge(1, 3, false);
        graph.addEdge(2, 4, false);
        graph.addEdge(3, 4, false);
        graph.addEdge(5, 4, false);

        graph.printGraph();

        System.out.println("BFS traversal of graph: " + graph.bfs(0));
        System.out.println("DFS traverslal of graph: " + graph.dfs(0));
        System.out.println(hasPath(graph, 2, 5));
    }
}

